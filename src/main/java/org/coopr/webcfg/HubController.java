package org.coopr.webcfg;

import org.coopr.dao.UserDAO;
import org.coopr.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HubController 
{
    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }
    
    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

}
