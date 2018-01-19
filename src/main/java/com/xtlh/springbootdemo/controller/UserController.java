package com.xtlh.springbootdemo.controller;

import com.xtlh.springbootdemo.dao.UserRepository;
import com.xtlh.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping(value = "/user")
    private List<User> userList()
    {
        return userRepository.findAll();
    }

    /**
     * 添加一个用户
     * @param username
     * @param password
     * @param type
     * @return
     */
    @PostMapping(value = "/user")
    public User userAdd(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);

        return userRepository.save(user);
    }

    /**
     * 查找一个用户
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public User userFindOne(@PathVariable("id") Integer id)
    {
        return userRepository.findOne(id);
    }

    /**
     * 删除一个用户
     * @param id
     */
    @DeleteMapping(value = "/user/{id}")
    public void userDelete(@PathVariable("id") Integer id)
    {
        userRepository.delete(id);
    }

    @PutMapping(value = "/user/{id}")
    public User userUpdate(@PathVariable("id") Integer id,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("type") String type)
    {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);

        return userRepository.save(user);
    }
}
