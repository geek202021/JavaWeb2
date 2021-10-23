package com.jun.web; /**
 * @author rujun.huang
 * @date 2021-10-14 1:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决post请求中文乱码问题
        // 一定要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        //解决响应中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        // 获取 action 业务鉴别字符串，获取相应的业务 方法反射对象
        //参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //2.保证当前方法是可访问的
            method.setAccessible(true);
            //3.调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
            method.invoke(this, req, resp);
        } catch (Exception e) {
            //在baseDao往上抛异常的过程中，抛到servlet然后servlet再抛到baseServlet，
            //通过baseServlet再往过滤器中抛异常
            e.printStackTrace();
            throw new RuntimeException(e); //把异常抛给Filter过滤器
        }
    }
}
