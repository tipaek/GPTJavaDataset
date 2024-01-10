package com.newweb.controller.system;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newweb.model.base.Customer;
import com.newweb.model.base.User;
import com.newweb.service.base.CustomerService;
import com.newweb.service.base.UserService;
import com.newweb.util.MD5Util;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    /**
     * Login page request
     *
     * @param request
     * @param response
     * @param locale
     * @param model
     * @return
     */
    @GetMapping("login.action")
    public String home(HttpServletRequest request, HttpServletResponse response,
            Locale locale, Model model) {
        String url = request.getParameter("url");
        return "page/login/login.jsp?reqUrl=" + url;
    }

    /**
     * User login logic processing
     * Returns an AJAX request
     *
     * @param request
     * @param response
     * @param userName
     * @param password
     * @param loginKeeping
     * @return
     */
    @ResponseBody
    @GetMapping("userLogin.action")
    public String userLogin(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("userName") String userName,
            @RequestParam("password") String password,
            @RequestParam("loginKeeping") String loginKeeping) {
        response.setCharacterEncoding("UTF-8");

        User user = userService.findUserByName(userName);
        if (user == null || !user.isValid()) {
            return "userIsNotExist";
        }

        if ("system".equals(user.getType())) {
            if (user.getPassword().equals(MD5Util.getMD5(password))) {
                request.getSession().setAttribute("userID", user.getID());
                if ("yes".equals(loginKeeping)) {
                    Cookie nameCookie = new Cookie("loginName", userName);
                    Cookie pswdCookie = new Cookie("loginPassword", MD5Util.getMD5(password));
                    nameCookie.setMaxAge(60 * 60 * 24 * 30);
                    pswdCookie.setMaxAge(60 * 60 * 24 * 7);
                    response.addCookie(nameCookie);
                    response.addCookie(pswdCookie);
                }
                userService.userLoginRecord(request, user);
                return "systemLogin";
            } else {
                return "passwordError";
            }

        } else if ("customer".equals(user.getType())) {
            if (user.getPassword().equals(MD5Util.getMD5(password))) {
                request.getSession().setAttribute("userID", user.getID());
                if ("yes".equals(loginKeeping)) {
                    Cookie nameCookie = new Cookie("loginName", userName);
                    Cookie pswdCookie = new Cookie("loginPassword", MD5Util.getMD5(password));
                    nameCookie.setMaxAge(60 * 60 * 24 * 30);
                    pswdCookie.setMaxAge(60 * 60 * 24 * 7);
                    response.addCookie(nameCookie);
                    response.addCookie(pswdCookie);
                }
                userService.userLoginRecord(request, user);
                return "customerLogin";
            } else {
                return "passwordError";
            }
        }
        return "unknownUser";
    }

    /**
     * Redirect to the corresponding page based on the current user's login identity
     *
     * @param locale
     * @param model
     * @param modelMap
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("userManager.action")
    public String userManager(Locale locale, Model model, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        int sessionUserID = (Integer) request.getSession().getAttribute("userID");
        User user = userService.findUserByID(sessionUserID);
        if ("system".equals(user.getType())) {
            return "page/system/systemIndex.jsp";
        } else if ("customer".equals(user.getType())) {
            return "page/customer/customerCentre.jsp";
        } else {
            return "page/index.jsp?warnMsg=" +
                    URLEncoder.encode(URLEncoder.encode("System could not recognize your identity, please contact the site!", "UTF-8"), "UTF-8");
        }
    }

    /**
     * User logout request
     *
     * @param locale
     * @param model
     * @param modelMap
     * @param request
     * @param response
     * @return
     */
    @GetMapping("logout.action")
    public String logout(Locale locale, Model model, ModelMap modelMap,
            HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("userID", null);
        response.addCookie(new Cookie("loginPassword", ""));
        return "page/index.jsp";
    }

    /**
     * AJAX request
     * Get the username corresponding to the currently logged-in user
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("isUserLogin.ajax")
    @ResponseBody
    public String isUserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = "";
        response.setCharacterEncoding("UTF-8");

        int sessionUserID = (Integer) request.getSession().getAttribute("userID");
        User user = userService.findUserByID(sessionUserID);
        if ("customer".equals(user.getType())) {
            Customer c = customerService.findCustomerByID(user.getLinkid());
            result = c.getName();
        }
        if ("system".equals(user.getType())) {
            result = "System Administrator";
        }
        response.getWriter().write(result);
        return null;
    }
}
