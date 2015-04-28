package com.xx.demo.biz.logic;

import com.xx.demo.biz.logic.impl.StorageLogicImpl;

public class SLogicFactory {

	private static volatile StorageLogic storageLogic;

	public static StorageLogic getStorageLogic() {
		if (storageLogic == null) {
			synchronized (StorageLogic.class) {
				if (storageLogic == null) {
					storageLogic = new StorageLogicImpl();
				}
			}
		}
		return storageLogic;
	}
}
