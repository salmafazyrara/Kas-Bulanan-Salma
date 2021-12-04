/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbulanan.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kasbulanan.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salma Fazira R
 */
@Controller
public class LoginController {
     @RequestMapping(value="/login")
    public ModelAndView Login(HttpServletRequest req,HttpServletResponse Res){
        if(req.getParameter("message")!= null){
            ModelAndView modelandview= new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();
    }
    @RequestMapping(value="/login/save")
     public ModelAndView save(@ModelAttribute("emp") LoginModel emp){
         ModelAndView modelandview=new ModelAndView("redirect:/login.html");
         if(emp.getUsername().equalsIgnoreCase("salma") &&
                 emp.getPassword().equalsIgnoreCase("salma")){
             return new ModelAndView("redirect:/home.html");
         }else {
             modelandview.addObject("message", "Usename dan password salah");
         }
        return modelandview; 
     }
    
}
