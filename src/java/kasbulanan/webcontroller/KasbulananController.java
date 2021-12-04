/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbulanan.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kasbulanan.dao.KasbulananDAO;
import kasbulanan.dao.KasbulananDAOProses;
import kasbulanan.model.Kasbulanan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salma Fazira R
 */
@Controller
public class KasbulananController {
    KasbulananDAO kasDao = null;
    private Object kas;
    public KasbulananController(){
        kasDao=new KasbulananDAOProses(); 
    }  
    
     @RequestMapping(value="/kasbulanan-form")
     public ModelAndView index(HttpServletRequest req, HttpServletResponse res){
        String action=req.getParameter("action");
        ModelAndView modelandview;
        if(action==null){
            action="ADD";
        }
        switch(action.toUpperCase()){
            case "EDIT":
                modelandview=editKasbulanan(req,res);
                break;
            case "DELETE":
                modelandview=deleteKasbulanan(req,res);
                break;
            default:
                modelandview=addKasbulanan(req,res);
                break;
        }
        return modelandview;
     }
     
     @RequestMapping(value="/kasbulanan-form2")
     public ModelAndView indexedit(HttpServletRequest req, HttpServletResponse res){
        String action=req.getParameter("action");
        ModelAndView modelandview;
        if(action==null){
            action="ADD";
        }
        switch(action.toUpperCase()){
            case "EDIT":
                modelandview=editKasbulanan(req,res);
                break;
            case "DELETE":
                modelandview=deleteKasbulanan(req,res);
                break;
            default:
                modelandview=addKasbulanan(req,res);
                break;
        }
        return modelandview;
     }
     
     
     
      @RequestMapping(value="/kasbulanan-form", method=RequestMethod.POST)
      public ModelAndView save(@ModelAttribute("kas") Kasbulanan ks){
         ModelAndView modelandview=new ModelAndView("redirect:/kasbulanan-form.html");
        if(ks.getId()!=0){
            if(kasDao.update(ks)){
                return new ModelAndView("redirect:/home.html");  
            }else {
                modelandview.addObject("message", "Gagal Update Data");
            }
            
        }else{
            if(kasDao.save(ks)){
                return new ModelAndView("redirect:/home.html");  
            }else {
                modelandview.addObject("message", "Gagal Simpan Data");
            }
            
        }
        return modelandview;
        }

    private ModelAndView editKasbulanan(HttpServletRequest req, HttpServletResponse res) {
       if(req.getParameter("message") !=null){
            ModelAndView modelandview = new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();
    }

    private ModelAndView deleteKasbulanan(HttpServletRequest req, HttpServletResponse res) {
       String id=req.getParameter("id");
        if(kasDao.delete(Integer.parseInt(id))){
            return new ModelAndView("redirect:/home.html");
        }else{
            req.setAttribute("message", "Gagal Delete");
            return addKasbulanan(req, res);
        }
    }

    private ModelAndView addKasbulanan(HttpServletRequest req, HttpServletResponse res) {
       if(req.getParameter("message") !=null){
            ModelAndView modelandview = new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();
    }
        
 }

    
