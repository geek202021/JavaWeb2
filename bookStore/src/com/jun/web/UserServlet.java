package com.jun.web;

import com.google.gson.Gson;
import com.jun.bean.User;
import com.jun.service.UserService;
import com.jun.service.impl.UserServiceImpl;
import com.jun.utils.WebUtils;
import com.sun.org.apache.bcel.internal.classfile.Code;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author rujun.huang
 * @date 2021-10-15 15:04
 */
public class UserServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();
    //1.处理登录的功能
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
            //转发到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else{
            //使用session优化登录和注销(保存用户登录后的信息)2021年10月18日16:28:43
            req.getSession().setAttribute("user",loginUser);

            //登录成功,转发到login_success.jsp页面
            req.getRequestDispatcher("/pages/user/error404.jsp").forward(req,resp);
        }
    }
    //3.处理注销的功能(利用session优化登录和注销)
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、销毁 Session 中用户登录的信息（或者销毁 Session）
        req.getSession().invalidate();
        //2、重定向到首页（或登录页面）。
        resp.sendRedirect(req.getContextPath());
    }
        //2.处理注册的功能
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //使用WebUtils注入所有参数
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        //2.首先判断验证码是否正确
//        if ("abcde".equalsIgnoreCase(code)) {
        if (token != null && token.equalsIgnoreCase(code)) {
            //2-1验证码输入正确,检查用户名是否可用
            if (userService.existsUsername(username)) {
                //true表示用户名存在，不可用,转发回注册页面，信息回显
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else{
                //false表示用户名不存在，可用,调用Service保存到数据库,转发到注册成功页面
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else{
            //验证码输入错误，把信息回显，保存到Request域中
            req.setAttribute("msg", "验证码输入有误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            //转发回注册页面
            req.getRequestDispatcher("/pages/user/regist.jap").forward(req, resp);
        }
    }

    //3.使用Ajax验证用户名是否可用
    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean b = userService.existsUsername(username);
        //把返回的结果封装成为map对象
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("existUsername", b);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }


}
