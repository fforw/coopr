package org.coopr;

import org.coopr.dao.UserDAO;
import org.coopr.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HubController 
{
    @Autowired
    private UserDAO userDAO;
    
    
    @RequestMapping("/home")
    public String home()
    {
        User user = new User();
        user.setName("test");
        userDAO.save(user);
        
        return "home";
    }

}
