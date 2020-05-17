package com.asa.demo05.controller;

import com.asa.demo05.dao.UserDao;
import com.asa.demo05.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    // 查询数据
    @GetMapping("/getAll")
    public List getAll() {
        List all = userDao.findAll();
        return all;
    }

    // 添加修改数据
    @GetMapping("/add")
    public User add(@RequestParam("name") String name,
                    @RequestParam("age") int age,
                    @RequestParam("address") String address) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setAddress(address);

        User save = userDao.save(user);
        return save;

    }

    // 删除单条数据
    @GetMapping("/deleteOne")
    public String deleteOne(@RequestParam("id") int id) {
        userDao.deleteById(id);
        return "删除成功";
    }

    // 删除多条数据
    @GetMapping("/deleteAll")
    public String deleteAll() {
        userDao.deleteAll();
        return "删除所有成功";
    }

}
