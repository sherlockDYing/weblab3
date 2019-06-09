package com.lab3.demo.controller;

import com.lab3.demo.Utils.UserLoginToken;
import com.lab3.demo.myBatis.SqlSessionLoader;
import com.lab3.demo.myBatis.entity.User;
import com.lab3.demo.request.UserLoginRequest;
import com.lab3.demo.request.UserRegisterRequest;
import com.lab3.demo.response.ErrorResponse;
import com.lab3.demo.response.SuccessResponse;
import com.lab3.demo.service.TokenService;
import com.lab3.demo.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    Object register(@RequestBody UserRegisterRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        User user = sqlSession.selectOne("hello.UserMapper.findUserByUsername", request.getUsername());
        if (user != null) {
            sqlSession.close();
            return new ErrorResponse("The username is already used");
        } else {
            sqlSession.insert("hello.UserMapper.addUser", new User(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhone()));
            sqlSession.commit();
            sqlSession.close();
            Map<String,Object> data = new HashMap<>();
            String token = tokenService.getToken(request);
            data.put("token", token);
            return new SuccessResponse(data); // use your generated entity here.
        }
    }




    @PostMapping("/login")
    public @ResponseBody
    Object login(@RequestBody UserLoginRequest user) throws  IOException {
        User userForBase=userService.findByUsername(user.getUsername());
        if(userForBase==null) {
            return new ErrorResponse("失败,用户不存在");
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                return new ErrorResponse("登录失败,密码错误");
            }else {
                String token = tokenService.getToken(userForBase);
                Map<String,Object> data = new HashMap<>();
                data.put("token", token);
                return new SuccessResponse(data);
            }
        }
    }

    @GetMapping(value = "/getAll")
    public @ResponseBody
    Object getAllUser() throws IOException {
    List<User> res = userService.findAllUser();
    if(res!=null){
        return res;
    }else return new ErrorResponse("fail to get all user");
    }



    @UserLoginToken
    @GetMapping(value = "/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }


}
