package com.newweb.interceptor;

import com.newweb.model.base.User;
import com.newweb.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private final UserService userService;

    @Autowired
    public SecurityInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getRequestURI().replace(request.getContextPath(), "");

        if ("/".equals(url) || "\\".equals(url)) {
            return true;
        }

        if (url.contains("isUserLogin.ajax")) {
            Integer sessionUserID = (Integer) request.getSession().getAttribute("userID");
            if (sessionUserID == null) {
                if (!cookieLogin(request, response)) {
                    response.getWriter().write("noUserLogin");
                    return false;
                }
            } else if (userService.findUserByID(sessionUserID) == null) {
                request.getSession().setAttribute("userID", null);
                response.getWriter().write("noUserLogin");
                return false;
            }
            return true;
        }

        String[] noFilters = new String[]{"userLogin.action", "logout.action", "login.action",
                "indexPage", "Register", "isUserExist.ajax", "isLinkNameExist.ajax",
                "indexGetShowDone.action", "indexGetShowProcessed.action", "indexGetShowUnprocessed.action",
                "nearOrder"};

        if (isFilter(url, noFilters)) {
            Integer sessionUserID = (Integer) request.getSession().getAttribute("userID");
            if (sessionUserID == null && !cookieLogin(request, response)) {
                response.getWriter().write("noUserLogin");
                response.sendRedirect(request.getContextPath() + "/indexPage?warnMsg=" + URLEncoder.encode(URLEncoder.encode("此操作需要登陆", "UTF-8"), "UTF-8"));
                return false;
            }
            return securityController(request, response, url);
        }
        return true;
    }

    private boolean securityController(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
        Integer sessionUserID = (Integer) request.getSession().getAttribute("userID");

        String[] adminFilter = {"cmsDo.action", "businessSystemDo.action"};
        for (String string : adminFilter) {
            if (url.contains(string) && !"system".equals(userService.findUserByID(sessionUserID).getType())) {
                response.sendRedirect(request.getContextPath() + "/indexPage?warnMsg=" + URLEncoder.encode(URLEncoder.encode("非法访问：访问权限不够！", "UTF-8"), "UTF-8"));
                return false;
            }
        }
        return true;
    }

    private boolean cookieLogin(HttpServletRequest request, HttpServletResponse response) {
        String name = "";
        String password = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("loginName".equals(cookie.getName())) {
                    name = cookie.getValue();
                } else if ("loginPassword".equals(cookie.getName())) {
                    password = cookie.getValue();
                }
            }
        }
        return !name.isEmpty() && !password.isEmpty();
    }

    private boolean isFilter(String url, String[] filters) {
        for (String filter : filters) {
            if (url.contains(filter)) {
                return false;
            }
        }
        return true;
    }
}
