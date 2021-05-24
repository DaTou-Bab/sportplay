package com.tom.controller;

import com.alibaba.fastjson.JSON;
import com.tom.mapper.UserMapper;
import com.tom.pojo.QueryInfo;
import com.tom.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        //获取最大列表数和当前编号
        int numbers = userMapper.getUserCount("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> userList = userMapper.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number",numbers);
        res.put("data",userList);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/userState/{id}/{state}")
    public String updateUserState(@PathVariable("id") Integer id, @PathVariable("state") Boolean state){
        int i = userMapper.updateState(id, state);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = userMapper.addUser(user);
        return i > 0 ? "success":"error";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i = userMapper.deleteUser(id);
        return i > 0 ? "success" : "error" ;
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        User user = userMapper.getUpdateUser(id);
        String string = JSON.toJSONString(user);
        return string;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = userMapper.editUser(user);
        return i > 0 ? "success" : "error" ;
    }
}
