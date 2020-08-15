package com.suyz.resource.controller;

import cn.hutool.json.JSONObject;
import com.suyz.resource.mapper.TbUserMapper;
import com.suyz.resource.model.TbUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author suyz
 * @date 2020/8/15 22:21
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private TbUserMapper userMapper;

    @GetMapping("/list")
    public JSONObject selectAll() {
        final List<TbUser> users = userMapper.selectAll();
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("users", users);
        return jsonObject;
    }
}
