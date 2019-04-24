package com.sunql.blog;


import com.sunql.blog.entity.User;
import com.sunql.blog.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper userMapper;


    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));

        List<User> userList = userMapper.selectList(null);
       // Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testSelectUser() {
        System.out.println(("----- selectAll method test ------"));
        User user = userMapper.loginUser("18716643045", "12345678");
        System.out.println(user.toString());
    }
    @Test
    public void selectMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("user_name","测试");
       List<User>  users= userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
}
