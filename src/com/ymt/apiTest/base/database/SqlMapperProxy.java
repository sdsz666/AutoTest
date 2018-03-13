package apiTest.base.database;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SqlMapperProxy<T> implements InvocationHandler {
    private SqlSession sqlSession;

    private T mapper;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = method.invoke(mapper, args);


        //打印sql
        if (method.getAnnotation(Update.class) != null){
            sqlSession.commit();
            System.out.println("Update SQL: "+method.getAnnotation(Update.class).value()[0]);
        }

        if (method.getAnnotation(Select.class) != null){
            System.out.println("Select SQL: "+ method.getAnnotation(Select.class).value()[0]);
        }

        if (method.getAnnotation(Insert.class) != null){
            sqlSession.commit();
            System.out.println("Insert SQL: "+method.getAnnotation(Insert.class).value()[0]);
        }

        if (method.getAnnotation(Delete.class) != null){
            sqlSession.commit();
            System.out.println("Delete SQL: "+method.getAnnotation(Delete.class).value()[0]);
        }

        //打印参数
        if (args!=null){
            for(int i=0;i<args.length;i++){
                System.out.println("param "+ (i+1)+" :"+args[i].toString());
            }
        }
        return ret;
    }

    public SqlMapperProxy(SqlSession sqlSession,Class<T> type){
        this.sqlSession = sqlSession;
        this.mapper =  sqlSession.getMapper(type);
    }

}
