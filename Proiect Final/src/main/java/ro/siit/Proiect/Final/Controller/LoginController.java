package ro.siit.Proiect.Final.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.Proiect.Final.Model.User;
import ro.siit.Proiect.Final.Service.UserServiceImpl;

@Controller
@RequestMapping(path = "")
public class LoginController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        model.addAttribute("userLogin", new User());
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");
        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

//    @GetMapping("/")
//    public String root() {
//        return "user-trip";
//    }


}