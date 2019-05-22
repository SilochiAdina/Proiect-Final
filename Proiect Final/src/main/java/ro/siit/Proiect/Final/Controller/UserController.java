package ro.siit.Proiect.Final.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.siit.Proiect.Final.Model.User;

import ro.siit.Proiect.Final.Service.UserServiceImpl;

import javax.validation.Valid;
import java.util.Iterator;

@Controller
public class UserController  {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping(path = "/user")
    public ModelAndView getAllUser(){
        //pe pagina user-page se va putea accesa atributul userList cu valoarea pe care o stocheaza el
        ModelAndView mv = new ModelAndView("user-page");
        mv.addObject("userList", userServiceImpl.getAllUsers());
        int counter=0;
        Iterator i = userServiceImpl.getAllUsers().iterator();
        while(i.hasNext()){
            counter++;
            i.next();
        }
        System.out.println("No. of users from DB:" + counter);
        return mv;
    }

    @GetMapping(path = "/user/add")
    public ModelAndView showAddAuthorPage(Model model){
        ModelAndView mv = new ModelAndView("add-user");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping(path="/user/add")
    public String saveNewUser(@Valid User user, BindingResult bindingResult){
        System.out.println("Users: " + user);//cand afisam un string + un obiect stie automat sa sa apeleze toString pentru obiect
        if(bindingResult.hasErrors()){
            System.out.println("Error when trying to insert");
            return "add-user";
        }
//       user.setRole("user");
        userServiceImpl.saveUser(user);
        System.out.println("New users was saved!");
        return "redirect:/login";
    }
}