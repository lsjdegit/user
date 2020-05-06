package com.zt.Servlet;

import com.zt.dao.Impl.UserDaoImpl;
import com.zt.entity.Users;
import com.zt.mapper.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author scj
 * @create 2020-04-15 16:29
 */
@WebServlet(urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String op = request.getParameter("op");
        Users us=new Users();
        UserMapper um=new UserDaoImpl();
       if("login".equals(op)){
           String username=request.getParameter("username");
           String userpassword=request.getParameter("userpassword");
           us.setUsername(username);
           us.setUserpassword(userpassword);
          us= um.login(us);
          request.setAttribute("us",us);
        List<Users>listuser= um.selectAll();
           request.setAttribute("listuser",listuser);
          if(us!=null){
            request.getRequestDispatcher("success.jsp").forward(request,response);
          }else{
             response.sendRedirect("error.jsp");
          }
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("aaa");
        doPost(request,response);

    }
}
