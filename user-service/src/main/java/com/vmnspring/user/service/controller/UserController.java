package com.vmnspring.user.service.controller;

import com.vmnspring.user.service.entity.User;
import com.vmnspring.user.service.service.UserService;
import com.vmnspring.user.service.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("In the SaveUser Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("In getUserWithDepartment");
        return userService.getUserWithDepartment(userId);

    }

}
