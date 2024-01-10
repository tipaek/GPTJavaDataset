package com.newweb.controller.system;

import com.newweb.model.base.Customer;
import com.newweb.model.base.User;
import com.newweb.service.base.CustomerService;
import com.newweb.service.base.UserService;
import com.newweb.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class RegisterController {

    private final UserService userService;
    private final CustomerService customerService;

    @Autowired
    public RegisterController(UserService userService, CustomerService customerService) {
        this.userService = userService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "getRegisterPage.action", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        return "page/register/register.jsp";
    }

    @RequestMapping(value = "userRegister.action", method = RequestMethod.POST)
    public String userRegister(Locale locale, Model model, ModelMap modelMap,
                               HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String linkName = request.getParameter("linkName");
        String contact = request.getParameter("contact");
        String password = request.getParameter("password");

        User user = new User();
        Customer[] cs = customerService.queryCustomerByName(linkName);
        Customer customer = null;
        boolean linkValid = false;
        for (Customer c : cs) {
            if (c.getName().equals(linkName) && c.getContact().equals(contact)) {
                linkValid = true;
                customer = c;
                break;
            }
        }
        if (!linkValid) {
            return "redirect:/register?registerName=" + userName + "&linkName=" + linkName + "&contact=" + contact;
        }

        user.setUserName(userName);
        user.setType(customer != null ? "customer" : "");
        user.setLinkid(customer.getID());
        user.setPassword(MD5Util.getMD5(password));

        if (!userService.saveUser(user)) {
            return "redirect:/login?registerStatus=failed";
        }

        return "redirect:/login?registerName=" + userName;
    }

    @ResponseBody
    @RequestMapping(value = "isUserExist.ajax")
    public String isUserExist(Locale locale, Model model, ModelMap modelMap,
                               HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("userName");

        User user = userService.findUserByName(name);
        return user != null ? "nameRepeat" : null;
    }

    @ResponseBody
    @RequestMapping(value = "isLinkNameExist.ajax")
    public String islinkNameExist(Locale locale, Model model, ModelMap modelMap,
                                   HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("linkName");

        Customer[] cs = customerService.queryCustomerByName(name);

        if (cs != null) {
            if (cs.length == 1) {
                User u = userService.findUserByLinkID(cs[0].getID());
                return u != null ? "linkNameIsUsed" : "linkNameValid";
            }
            if (cs.length == 0) {
                return "linkNameUnvalid";
            }
            if (cs.length > 1) {
                return "nameRepead";
            }
        }

        return cs == null || cs.length == 0 ? "linkNameUnvalid" : null;
    }
}
