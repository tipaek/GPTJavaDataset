package com.newweb.controller.system;

import com.newweb.model.base.User;
import com.newweb.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

@Controller
public class SystemController {

    private final UserService userService;

    @Autowired
    public SystemController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="systemLogin.action")
    public String systemLogin(Locale locale, Model model, ModelMap modelMap,
                              HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        int sessionUserID = (Integer) request.getSession().getAttribute("userID");

        User user = userService.findUserByID(sessionUserID);
        if(!"system".equals(user.getType())) {
            return "redirect:/index.jsp?warnMsg=" + URLEncoder.encode(URLEncoder.encode("非法访问：访问权限不够！", "UTF-8"), "UTF-8");
        }

        return "system/systemIndex";
    }

    @RequestMapping(value="cmsDo.action")
    public String systemManagerDo(Locale locale, Model model, ModelMap modelMap,
                                  HttpServletRequest request, HttpServletResponse response) {
        return "system/cms";
    }

    @RequestMapping(value="businessSystemDo.action")
    public String businessSystemDo(Locale locale, Model model, ModelMap modelMap,
                                   HttpServletRequest request, HttpServletResponse response) {
        return "system/businessSystem";
    }

    @RequestMapping(value="htmlContentEdit")
    public String htmlContentEdit(Locale locale, Model model, ModelMap modelMap,
                                  HttpServletRequest request, HttpServletResponse response) {
        return "system/htmlContentEdit";
    }
}
