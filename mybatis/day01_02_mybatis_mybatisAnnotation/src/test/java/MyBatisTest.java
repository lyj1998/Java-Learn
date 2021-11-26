import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis的入门案例   基于注解的入门案例；
 * 把IUserDao.xml移除，在dao接口的方法上使用@Select注解，并且指定SQL语句
 * 同时需要在SqlMapConfig.xml中的mappper配置时，使用class属性指定dao接口的全限定类名
 */
public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = sessionFactory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> list = userDao.findAll();
        for (User user:list){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
