package com.tools.module.sys.web;

import com.tools.common.model.Result;
import com.tools.common.util.MD5Utils;
import com.tools.common.util.ShiroUtils;
import com.tools.module.sys.entity.SysUser;
import com.tools.module.sys.service.SysUserService;
import io.swagger.annotations.Api;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录
 * 爪哇笔记：https://blog.52itstyle.vip
 * @author 小柒2012
 */
@Api(tags ="登录")
@Controller
@RequestMapping("/sys")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 登录
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(String username, String password){
        try{
            Subject subject = ShiroUtils.getSubject();
            password = MD5Utils.encrypt(username, password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.error("登录失败");
        }
        return Result.ok("登录成功");
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public Result register(SysUser user){
        System.out.println(user.getMobile());
        return Result.ok("注册成功,去登陆");
    }
    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public String logout(){
        ShiroUtils.logout();
        return "redirect:/login.html";
    }
}
