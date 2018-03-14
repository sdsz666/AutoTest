package com.ymt.apiTest.base.database;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class SqlSessionFactoryBuild {
    private static Map<String,SqlSessionFactory> SqlSessionFactoryMap = new HashMap<>();
    private static Map<Class<?>,Object> mapperMap = new HashMap<>();
    private static Map<SqlSessionFactory,SqlSession> SqlSessionMap = new HashMap<>();

    private static SqlSessionFactoryBuild sqlSessionFactoryBuild = null;
    private static String dbconfigName = System.getProperty("user.dir") + File.separator + "config" + File.separator + "dbconfig.xml";

    private SqlSessionFactoryBuild(){}

    public static synchronized SqlSessionFactory getSqlSessionFactory(String envName){
        if (SqlSessionFactoryMap.keySet().contains(envName)){
            return SqlSessionFactoryMap.get(envName);
        }else{
            if (sqlSessionFactoryBuild==null){
                sqlSessionFactoryBuild = new SqlSessionFactoryBuild();
            }

            try {
                SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(new FileReader(dbconfigName), envName);
                SqlSessionFactoryMap.put(envName, sqlSessionFactory);
                SqlSessionMap.put(sqlSessionFactory,sqlSessionFactory.openSession());
                return sqlSessionFactory;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static synchronized <T>  void addMapper(SqlSessionFactory ssf,Class<T> type){
        if (mapperMap.keySet().contains(type)){
            return ;
        }

        ssf.getConfiguration().addMapper(type);
        T mapper =SqlSessionMap.get(ssf).getMapper(type);

        InvocationHandler sqlMapperProxy = new SqlMapperProxy<T>(SqlSessionMap.get(ssf), type);

        T mapperProxy = (T)Proxy.newProxyInstance(SqlMapperProxy.class.getClassLoader(),
                mapper.getClass().getInterfaces(),
                sqlMapperProxy);
        mapperMap.put(type, mapperProxy);

    }


    public static <T> T getMapperSession(String envName,Class<T> type) {
        SqlSessionFactory ssf = getSqlSessionFactory(envName);
        if (!mapperMap.keySet().contains(type)){
            addMapper(ssf,type);
        }


        return (T) mapperMap.get(type);
    }


}
