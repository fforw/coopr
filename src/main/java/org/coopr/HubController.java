package org.coopr;

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

}
