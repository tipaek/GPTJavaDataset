package com.newweb.controller.manager.model;

import com.newweb.model.base.User;
import com.newweb.service.base.CustomerService;
import com.newweb.service.base.UserService;
import com.newweb.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final CustomerService customerService;

    @Autowired
    public UserController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value="getUsersJsonData.ajax")
    @ResponseBody
    public String getUsersJsonData(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        int start = Integer.parseInt(request.getParameter("start"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        List list = userService.queryAllUsers(start,limit);
        int size = (Integer) list.get(0);
        User[] users = (User[]) list.get(1);

        StringBuilder json = new StringBuilder("{\"total\":\"" + size + "\",\"data\":[");

        for (User user : users) {
            json.append("{")
                .append("\"id\":\"").append(user.getID()).append("\",")
                .append("\"linkid\":\"").append(user.getLinkid()).append("\",")
                .append("\"lastLoginTime\":\"").append(user.getLastLoginTime() == null ? "无记录" : user.getLastLoginTime()).append("\",")
                .append("\"loginCount\":\"").append(user.getLoginCount()).append("\",")
                .append("\"type\":\"").append(user.getType()).append("\",")
                .append("\"userName\":\"").append(user.getUserName()).append("\",")
                .append("\"linkName\":\"").append(user.getType().equals("customer") ? customerService.findCustomerByID(user.getLinkid()).getName() : user.getUserName()).append("\",")
                .append("\"typeName\":\"").append(user.getType().equals("customer") ? "客户" : user.getType().equals("system") ? "系统" : "未知").append("\"},");
        }

        json.setLength(json.length() - 1); // remove the last comma
        json.append("]}");

        try {
            response.getWriter().write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="modifyUserPasswordTo888888.ajax")
    @ResponseBody
    public String modifyUserPasswordTo888888(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        String ids = request.getParameter("ids");
        StringBuilder sb = new StringBuilder();

        String[] ss = ids.split(",");
        for (String s : ss) {
            int id;
            try {
                id = Integer.parseInt(s);
            } catch (Exception e) {
                sb.append("用户标识符:'").append(s).append("'未能识别!</br>");
                continue;
            }
            int sessionID = (Integer) request.getSession().getAttribute("userID");
            User user = userService.findUserByID(id);
            if(user == null){
                sb.append("该标识符:'").append(id).append("'没有找到对应的用户,可能已经被删除,或ID被修改</br>");
                continue;
            }
            user.setPassword(MD5Util.getMD5("888888"));
            if(userService.modify(user)){
                sb.append("用户: ").append(user.getUserName()).append(" ' 密码重置成功!").append(sessionID == id ? "(注意，此号为当前登陆用户)</br>" : "</br>");
            } else {
                sb.append("用户 : ").append(user.getUserName()).append(" ' 密码重置失败!</br>");
            }
        }
        try {
            response.getWriter().write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
