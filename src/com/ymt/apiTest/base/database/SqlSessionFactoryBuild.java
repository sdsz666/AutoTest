package apiTest.base.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class SqlSessionFactoryBuild {
    private static Map<String,SqlSessionFactory> SqlSessionFactoryMap = new HashMap<>();
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
                return sqlSessionFactory;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getMapperSession(String envName,Class<T> type) {
        SqlSessionFactory ssf = getSqlSessionFactory(envName);
        if (!ssf.getConfiguration().hasMapper(type)){
            ssf.getConfiguration().addMapper(type);
        }

        InvocationHandler sqlMapperProxy = new SqlMapperProxy<T>(ssf.openSession(), type);

        T mapperProxy = (T) Proxy.newProxyInstance(SqlMapperProxy.class.getClassLoader(),
                ssf.openSession().getMapper(type).getClass().getInterfaces(),
                sqlMapperProxy);

        return mapperProxy;
    }
}
