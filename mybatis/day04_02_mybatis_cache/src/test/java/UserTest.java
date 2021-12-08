import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * 测试MyBatis的CURD操作
 */
public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private SqlSessionFactory factory;
    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
         factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
         sqlSession = factory.openSession();
        //4.获取dao代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After//用于在执行测试方法之后执行
    public void destory() throws Exception{
        //提交事务
//        sqlSession.commit();
        //6.关闭连接
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);
//        sqlSession.close();
//        SqlSession sqlSession = factory.openSession();
//        userDao = sqlSession.getMapper(IUserDao.class);
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

    /**
     * 以及缓存是SqlSession范围的缓存，当调用SqlSession的修改，添加，删除，commit(),close()等方法时，
     * 就会清空一级缓存
     */
    @Test
    public void testClearCache(){
        //1.根据id查询用户信息
        User user1 = userDao.findById(41);
        System.out.println(user1);
        //2.更新用户信息
        user1.setUsername("update user clear cache");
        user1.setAddress("run 0杭州");
        userDao.updateUser(user1);
        //3.再次查询id为41的用户
        User user2 = userDao.findById(41);
        System.out.println(user2);
        System.out.println(user1 == user2);
    }

}
