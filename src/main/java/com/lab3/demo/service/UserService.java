package com.lab3.demo.service;

import com.lab3.demo.myBatis.SqlSessionLoader;
import com.lab3.demo.myBatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class UserService {

    public User findUserById(int userId) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user1;
        try{
            user1 = sqlSession.selectOne("hello.UserMapper.findUserByUsername",userId);
        }
        finally {
            sqlSession.close();
        }
        return user1;
    }

    public User findByUsername(String username) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user1;
        try{
            user1 = sqlSession.selectOne("hello.UserMapper.findUserByUsername",username);
        }
        finally {
            sqlSession.close();
        }
        return user1;
    }

    public List<User> findAllUser() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<User> res;
        try{

            res = sqlSession.selectList("hello.UserMapper.getAllUser");
        }
        finally {
            sqlSession.close();
        }
        return res;
    }
}
