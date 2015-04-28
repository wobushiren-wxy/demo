package com.xx.demo.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alonew.core.commons.tuple.Tuple;
import com.alonew.core.commons.tuple.TwoTuple;
import com.alonew.core.commons.util.TimeUtil;

public class FileUtil {

	private static final Log LOG = LogFactory.getLog(FileUtil.class);

	// 获取规定后缀的文件列表
	public static List<File> getFiles(String path, String suffix,
			boolean isdepth) {
		// 文件名
		List<File> lstFileNames = new ArrayList<File>();
		// new出这个文件
		File file = new File(path);
		return reverseListFile(lstFileNames, file, suffix, isdepth);
	}

	private static List<File> reverseListFile(List<File> lstFileNames, File f,
			String suffix, boolean isdepth) {
		if (f.isDirectory()) {
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				if (isdepth || t[i].isFile()) {
					reverseListFile(lstFileNames, t[i], suffix, isdepth);
				}
			}
		} else {
			// 获取绝对路径
			String filePath = f.getAbsolutePath();
			if (!suffix.equals("")) {
				int begIndex = filePath.lastIndexOf(".");
				String tempsuffix = "";

				if (begIndex != -1) {
					tempsuffix = filePath.substring(begIndex + 1,
							filePath.length());
					if (tempsuffix.equals(suffix)) {
						lstFileNames.add(f);
					}
				}
			} else {
				lstFileNames.add(f);
			}
		}
		return lstFileNames;
	}

	public static List<String> getListFiles(String path, String suffix,
			boolean isdepth) {
		List<String> lstFileNames = new ArrayList<String>();
		File file = new File(path);
		return listFile(lstFileNames, file, suffix, isdepth);
	}

	private static List<String> listFile(List<String> lstFileNames, File f,
			String suffix, boolean isdepth) {
		if (f.isDirectory()) {
			File[] t = f.listFiles();
			for (int i = 0; i < t.length; i++) {
				if (isdepth || t[i].isFile()) {
					listFile(lstFileNames, t[i], suffix, isdepth);
				}
			}
		} else {
			String filePath = f.getAbsolutePath();
			if (!suffix.equals("")) {
				int begIndex = filePath.lastIndexOf(".");
				String tempsuffix = "";

				if (begIndex != -1) {
					tempsuffix = filePath.substring(begIndex + 1,
							filePath.length());
					if (tempsuffix.equals(suffix)) {
						lstFileNames.add(filePath);
					}
				}
			} else {
				lstFileNames.add(filePath);
			}
		}
		return lstFileNames;
	}

	public static void closeIO(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				// do nothing
			}
		}
	}

	/**
	 * 若文件名有后缀.xxx，则生成文件名为md5.xxx
	 */
	public static String buildMd5FileName(String md5, String fileName) {
		String[] strs = fileName.split("\\.");
		if (strs.length <= 1) {
			return md5;
		}
		return md5 + "." + strs[strs.length - 1];
	}

	/**
	 * 读取文件的二进制内容
	 */
	private static byte[] readBinary(File file) throws IOException {
		byte[] result = new byte[(int) file.length()];
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			int totalBytesRead = 0;
			while (totalBytesRead < result.length) {
				int bytesRemain = result.length - totalBytesRead;
				int bytesRead = in.read(result, totalBytesRead, bytesRemain);
				if (bytesRead > 0) {
					totalBytesRead += bytesRead;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return result;
	}

	/**
	 * 将字节数组写入文件
	 */
	private static void write(byte[] data, File outFile) throws IOException {
		OutputStream output = null;
		try {
			output = new BufferedOutputStream(new FileOutputStream(outFile));
			output.write(data);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (output != null) {
				output.close();
			}
		}
	}

	public static TwoTuple<String, String> writeFileWithMd5Name(String dirName,
			String fileName, File file) {
		TwoTuple<String, byte[]> readResult = readAndCalMd5(file);
		if (readResult == null) {
			return null;
		}
		String md5 = readResult.first;
		byte[] data = readResult.second;

		String saveName = buildMd5FileName(md5, fileName);
		boolean writeResult = writeFile(dirName, saveName, data);
		if (!writeResult) {
			return null;
		}

		return Tuple.tuple(md5, saveName);
	}

	/**
	 * 将文件写入磁盘，返回文件的md5值 返回null表示失败
	 */
	public static TwoTuple<String, byte[]> readAndCalMd5(File file) {
		try {
			byte[] data = FileUtil.readBinary(file);
			String md5 = DigestUtils.md5Hex(data);
			return Tuple.tuple(md5, data);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将文件写入磁盘
	 */
	public static boolean writeFile(String dirName, String fileName, byte[] data) {
		// 确保目录存在
		File dir = new File(dirName);
		dir.mkdirs();

		// 写文件
		File outputFile = new File(dirName + "/" + fileName);
		try {
			write(data, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 写文件
	 * 
	 * @param srcFile
	 * @param destFile
	 * @return
	 */
	public static boolean copyFile(File srcFile, File destFile) {
		if (!srcFile.exists()) {
			LOG.error("src file not exist!");
			return false;
		}
		File destDirFile = destFile.getParentFile();
		if (!destDirFile.exists()) {
			destDirFile.mkdirs();
		}
		// 30m
		long copyBufferSize = 1024 * 1024 * 30;

		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel input = null;
		FileChannel output = null;
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);
			input = fis.getChannel();
			output = fos.getChannel();
			long size = input.size();
			long pos = 0;
			long count = 0;
			while (pos < size) {
				count = (size - pos) > copyBufferSize ? copyBufferSize
						: (size - pos);
				pos += output.transferFrom(input, pos, count);
			}

			IOUtils.closeQuietly(output);
			IOUtils.closeQuietly(input);
		} catch (Exception e) {
			LOG.error("error msg=[" + e.getMessage() + "]");
			return false;
		} finally {
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(fis);
		}

		return true;
	}

	/**
	 * 缩放上传图片
	 * 
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 * @param width
	 *            宽度
	 * @param height
	 *            高度
	 * @return
	 */
	public static boolean uploadImgZoom(File srcFile, File destFile, int width,
			int height) {
		if (!srcFile.exists()) {
			LOG.error("src file not exist while uploading img!");
			return false;
		}
		File destDirFile = destFile.getParentFile();
		if (!destDirFile.exists()) {
			destDirFile.mkdirs();
		}
		try {
			Thumbnails.of(srcFile).size(width, height).toFile(destFile);
		} catch (Exception e) {
			LOG.error("error msg=[" + e.getMessage() + "]");
			return false;
		}
		return true;
	}

	/**
	 * 保存文件
	 * 
	 * @param inStream
	 * @param absFilePath
	 *            文件绝对路径
	 */
	public static boolean saveFile(InputStream inStream, String absFilePath) {
		File outFile = new File(absFilePath);
		File dirFile = outFile.getParentFile();
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outFile);
			byte[] buffer = new byte[1024 * 1024];
			int length = 0;
			while ((length = inStream.read(buffer)) != -1) {
				fos.write(buffer, 0, length);
			}
		} catch (Exception e) {
			LOG.error("saveFile error,msg=[" + e.getMessage() + "]");
			return false;
		} finally {
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(inStream);
		}
		return true;
	}

	public static boolean saveFile(InputStream inStream, File resultFile) {
		return saveFile(inStream, resultFile.getAbsolutePath());
	}

	/**
	 * 获得文件扩展名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFilePostfix(String fileName) {
		String postFix = "";
		if (fileName == null) {
			return postFix;
		}
		int index = fileName.lastIndexOf('.');
		if (index != -1) {
			postFix = fileName.substring(index);
		}
		return postFix;
	}

	public static String getFilePrefix(String fileName) {
		String preFix = "";
		if (fileName == null) {
			return preFix;
		}
		int index = fileName.lastIndexOf('.');
		if (index != -1) {
			preFix = fileName.substring(0, index);
		} else {
			preFix = fileName;
		}
		return preFix;
	}

	public static String getDateFormatStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}

	/**
	 * 上传图片
	 * 
	 * @param srcFile
	 *            源文件
	 * @param relativeDir
	 *            相对路径
	 * @param filename
	 *            文件名
	 * @param thumbnailSizeList
	 *            缩略图大小列表
	 * @return 相对路径+文件名
	 */
	public static String uploadImgAndThumbnail(File srcFile,
			String relativeDir, String filename,
			List<TwoTuple<Integer, Integer>> thumbnailSizeList) {

		String dateStr = TimeUtil.format("yyyyMM", new Date());
		relativeDir += dateStr + "/";

		File dirFile = new File(Constants.STATIC_PATH, relativeDir);
		String fileId = KeyGen.getShortKey();

		String mainFileName = fileId + FileUtil.getFilePostfix(filename);

		File destFile = new File(dirFile, mainFileName);

		File destDirFile = destFile.getParentFile();
		if (!destDirFile.exists()) {
			destDirFile.mkdirs();
		}

		try {
			// 保存主图
			FileUtil.copyFile(srcFile, destFile);

			// 生成缩略图
			for (TwoTuple<Integer, Integer> thumbnail : thumbnailSizeList) {
				String thumbnailFileName = fileId + "_" + thumbnail.first + "_"
						+ thumbnail.second + FileUtil.getFilePostfix(filename);
				File thumbnailFile = new File(dirFile, thumbnailFileName);

				Thumbnails.of(srcFile).size(thumbnail.first, thumbnail.second)
						.toFile(thumbnailFile);
			}

		} catch (Exception e) {
			LOG.error("error msg=[" + e.getMessage() + "]");
			return null;
		}
		return relativeDir + mainFileName;

	}

	//文件与文件夹删除系列
	/**
	 * 根据路径删除指定的目录或文件，无论存在与否
	 * 
	 * @param sPath
	 *            要删除的目录或文件
	 * @return 删除成功返回 true，否则返回 false。
	 */
	public static boolean DeleteFolder(String sPath) {
		
		
		try {
			File file = new File(sPath);
		
			// 判断目录或文件是否存在
			if (!file.exists()) { // 不存在返回 false
				LOG.error("该地址不存在");
				return false;
			} else {
				// 判断是否为文件
				if (file.isFile()) { // 为文件时调用删除文件方法
					return deleteFile(sPath);
				} else { // 为目录时调用删除目录方法
					return deleteDirectory(sPath);
				}
			}
		} catch (Exception e) {
			LOG.error("error msg=[" + e.getMessage() + "]");
			return false;
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param sPath
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	public static boolean deleteFile(String sPath) {
		
		try {
			boolean flag = false;
			File file = new File(sPath);
			// 路径为文件且不为空则进行删除
			if (file.isFile() && file.exists()) {
				file.delete();
				flag = true;
			}
			return flag;
		}catch (Exception e) {
			LOG.error("error msg=[" + e.getMessage() + "]");
			return false;
		}
		
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param sPath
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean deleteDirectory(String sPath) {
		try {
			// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
			if (!sPath.endsWith(File.separator)) {
				sPath = sPath + File.separator;
			}
			File dirFile = new File(sPath);
			// 如果dir对应的文件不存在，或者不是一个目录，则退出
			if (!dirFile.exists() || !dirFile.isDirectory()) {
				return false;
			}
			boolean flag = true;
			// 删除文件夹下的所有文件(包括子目录)
			File[] files = dirFile.listFiles();
			for (int i = 0; i < files.length; i++) {
				// 删除子文件
				if (files[i].isFile()) {
					flag = deleteFile(files[i].getAbsolutePath());
					if (!flag)
						break;
				} // 删除子目录
				else {
					flag = deleteDirectory(files[i].getAbsolutePath());
					if (!flag)
						break;
				}
			}
			if (!flag)
				return false;
			// 删除当前目录
			if (dirFile.delete()) {
				return true;
			} else {
				return false;
			}
		}catch (Exception e) {
			LOG.error("error msg=[" + e.getMessage() + "]");
			return false;
		}
		
		
		/*public static void main(String[] args) {  
	    	HandleFileClass hfc = new HandleFileClass();  
	    	String path = "D:\\Abc\\123\\Ab1";  
	    	boolean result = hfc.CreateFolder(path);  
	    	System.out.println(result);  
	    	path = "D:\\Abc\\124";  
	    	result = hfc.DeleteFolder(path);  
	    	System.out.println(result);  
	  
		}*/
		
	}
	
	

}
