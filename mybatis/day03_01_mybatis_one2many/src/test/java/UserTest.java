import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
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
    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件，生成字节输入流
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
         sqlSession = factory.openSession();
        //4.获取dao代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After//用于在执行测试方法之后执行
    public void destory() throws Exception{
        //提交事务
        sqlSession.commit();
        //6.关闭连接
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() throws IOException {
        //5.执行查询所有方法
        List<User> list = userDao.findAll();
        for (User user: list){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }
}
