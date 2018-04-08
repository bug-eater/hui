package com.javaweb.servlet;

import com.javaweb.dao.AdminDao;
import com.javaweb.pojo.Admin;
import com.javaweb.dao.CarDao;
import com.javaweb.pojo.Car;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out=resp.getWriter();
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String action=req.getParameter("action");
        //控制流语句，员工登录部分
        if(action.equals("work")){
        CarDao dao =new CarDao();
        Car user=dao.login(username,password);
        JSONObject jo=new JSONObject();
        if(user!=null){
            JsonConfig jsonConfig=new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jo= (JSONObject) JSONSerializer.toJSON(user,jsonConfig);
        }else{
            jo.put("code",400);
            jo.put("message","错误的密码或用户名"); }
           out.println(jo.toString());}
        //管理员登录部分
           else if(action.equals("admin")){
                Admin an=new Admin();
            AdminDao ao=new AdminDao();
            an=ao.selectAdmin("username","password");
            ao.update(username);
            JSONObject jo=new JSONObject();
if(an!=null){
    JsonConfig jsonConfig=new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());
    jo=(JSONObject)JSONSerializer.toJSON(an,jsonConfig);
}else{
    jo.put("code",400);
    jo.put("message","错误的密码或用户名"); }
    out.println(jo);
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
