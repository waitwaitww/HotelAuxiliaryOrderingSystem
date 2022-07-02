package com.code.back.controller;


import cn.hutool.http.server.HttpServerRequest;
import com.code.back.pojo.Code;
import com.code.back.pojo.Msg;
import com.code.back.pojo.User;
import com.code.back.service.CodeService;
import com.code.back.service.UserService;
import com.code.back.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * ?û?? 前端控制器
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@RestController
@RequestMapping("/back/user")
public class UserController {


    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("CodeServiceImpl")
    private CodeService codeService;


    @RequestMapping("/t1")
    public String testSpringBoot(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        Msg msg = new Msg();
        msg.setResult("index");
        return jsonUtil.getJson(msg);
    }

//    @RequestMapping(value = "/loginById",produces = "application/json;charset=utf-8")
//    public String loginId(@RequestParam("uid")Long uid, @RequestParam("upassword")String password){
////        String pwdById = userService.queryPwdById(uid);
//        if(pwdById.equals(password)) {
//            return jsonUtil.getJson("true");
//        }
//        else return jsonUtil.getJson("false");
//    }

    @RequestMapping(value = "/t2", produces = "application/json;charset=utf-8")
    public String loginEmail(@RequestParam("uname") String email, @RequestParam("upassword") String password, HttpServletRequest request) {
//        String pwdById = userService.queryPwdByEmail(email);
        String pwdById = userService.queryPwdByEmail(email);
        String msg = "false";
        Msg msg1 = new Msg();
        msg1.setResult(msg);
        System.out.println("email");
        if (pwdById.equals(password)) {
            System.out.println(password);
            msg1.setResult("success");
            User user = userService.queryAllInfoByEmail(email);
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            System.out.println(user);
            return jsonUtil.getJson(msg1);
        } else return jsonUtil.getJson(msg1);
    }



//    @AuthAccess
//    @RequestMapping(value = "/sendemailcode",produces = "application/json;charset=utf-8")
//    public String sendEmailCode(@RequestParam("email") String email){
//        String s = userService.sendEmail(email);
//        Msg msg = new Msg();
//        msg.setResult("邮件发送成功");
//        if(s.equals("")){
//            msg.setResult("邮件发送失败");
//        }
//        return jsonUtil.getJson(msg);
//    }

    @RequestMapping(value = "/register-first", produces = "application/json;charset=utf-8")
    public String registerFirst(@RequestParam("email") String email) {
        Msg msg = new Msg();
        int exist = userService.isUserExistByEmail(email);
        if (exist == 1) {
            msg.setResult("用户已存在");
            return jsonUtil.getJson(msg);
        }
        String code = userService.sendEmail(email);
        Code code1 = new Code();
        code1.setCode(code);
        code1.setEmail(email);
//        codeService.addCode(code1);
        msg.setResult("false");
        if (code.equals("")) {
            return jsonUtil.getJson(msg);
        }
        msg.setResult(code);
//        msg.setResult("1234");
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/register-second", produces="application/json;charset=utf-8")
    public String registerSecond(@RequestParam("email") String email,@RequestParam("upassword") String upassword){
        Msg msg = new Msg();
        User user = new User();
        user.setEmail(email);
        user.setUpassword(upassword);
        int i = userService.addUser(user);
        System.out.println(i);
        msg.setResult("success");
        if(i==0){
            msg.setResult("false");
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/changePwd", produces = "application/json;charset=utf-8")
    public String changePwd(@RequestParam("upassword") String upassword,@RequestParam("newpassword") String newpassword,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Long uid = user.getUId();
        int exist = userService.isUserExistByUid(uid);
        Msg msg = new Msg();
        if(exist == 0){
            msg.setResult("用户不存在");
            return jsonUtil.getJson(msg);
        }
        String oldpassword = userService.queryPwdById(uid);
        if(upassword.equals(oldpassword)){
            userService.updataUpassword(uid,newpassword);
            msg.setResult("success");
            user.setUpassword(newpassword);
            session.setAttribute("user",user);
            return jsonUtil.getJson(msg);
        }
        msg.setResult("用户密码输入错误");
        return jsonUtil.getJson(msg);
    }


    @RequestMapping(value = "/modifinfo", produces = "application/json;charset=utf-8")
    public String modifyInfo(@RequestParam("uname") String uname, @RequestParam("age") int age,
                             @RequestParam("sex")int sex, @RequestParam("userdescribe") String userdescribe,
                             HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Msg msg = new Msg();
        msg.setResult("false");
        user.setSex(sex);
        user.setAge(age);
        user.setUserdescribe(userdescribe);
        user.setUname(uname);
        int i = userService.updataUser(user);
        if(i == 1) {
            msg.setResult("success");
            session.setAttribute("user",user);

        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryalluser",produces = "application/json;charset=utf-8")
    public String queryAllUserInfo(){
        List<User> users = userService.queryAllUser();
        Msg msg = new Msg();
        msg.setResult(users);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryuserbyname",produces = "application/json;charset=utf-8")
    public String queryUserByName(@RequestParam("uname") String uname){
        List<User> users = userService.queryUserByName(uname);
        Msg msg = new Msg();
        msg.setResult(users);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/logout",produces = "application/json;charset=utf-8")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        Msg msg = new Msg();
        msg.setResult("success");
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/deleteuser",produces = "application/json;charset=utf-8")
    public String deleteUser(@RequestParam("u_id") Long uid){
        Msg msg = new Msg();
        userService.deleteUserById(uid);
        msg.setResult("success");
        return jsonUtil.getJson(msg);
    }


}

