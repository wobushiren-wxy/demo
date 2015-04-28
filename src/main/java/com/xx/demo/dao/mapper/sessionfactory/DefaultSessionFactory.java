package com.xx.demo.dao.mapper.sessionfactory;

import com.alonew.db.dao.BaseSessionFactory;

/**
 * @author Administrator
 */
public class DefaultSessionFactory extends BaseSessionFactory {

    public DefaultSessionFactory(String configPath) {
        super(configPath);
        initMappers();
    }

    public void initMappers() {
        //使用注解的时候一定要将XXXMapper注册一下，跟XML配置namespace一样
        //		this.getSessionFactory().getConfiguration().addMapper(PersonMapper.class);

    }

    private static final DefaultSessionFactory instance;

    static {
        instance = new DefaultSessionFactory(
                "com/xx/demo/dao/mapper/config/DefaultDbConfig.xml");
    }

    public static DefaultSessionFactory getInstance() {
        return instance;
    }

}
