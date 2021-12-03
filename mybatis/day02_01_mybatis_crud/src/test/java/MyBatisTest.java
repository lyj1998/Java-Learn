import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 * 测试MyBatis的CURD操作
 */
public class MyBatisTest {
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
        }
    }

    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("mybatis saveuser");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);

    }

    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(6);
        user.setUsername("mybatis saveuser");
        user.setAddress("浙江省杭州市");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }
    @Test
    public void testDelete() throws IOException {
        userDao.deleteUser(6);
    }

    @Test
    public void testFindById() throws IOException {
        User user = userDao.findById(4);
        System.out.println(user);
    }

    @Test
    public void testFindByName() throws IOException {
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for (User user: users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() throws IOException {
       int num = userDao.findTotal();
        System.out.println(num);
    }

    /**
     * 由多个对象组合成查询条件进行查询
     * @throws IOException
     */
    @Test
    public void testFindByVo() throws IOException {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findByVo(vo);
//        List<User> users = userDao.findByName("王");
        for (User u: users){
            System.out.println(user);
        }
    }
}
