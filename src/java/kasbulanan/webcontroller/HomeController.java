/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbulanan.webcontroller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kasbulanan.dao.KasbulananDAO;
import kasbulanan.dao.KasbulananDAOProses;
import kasbulanan.model.DatabaseConfig;
import kasbulanan.model.Kasbulanan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salma Fazira R
 */
@Controller
public class HomeController {
     KasbulananDAO kasDao=null;
    public HomeController(){
        kasDao=new KasbulananDAOProses();
    }
    @RequestMapping(value="/home")
    public ModelAndView home(HttpServletRequest req,HttpServletResponse Res) throws SQLException{
//          Connection connection = null;
//        connection = DatabaseConfig.openConnection();
//        if (connection != null){
//            ModelAndView modelandview = new ModelAndView();
//            modelandview.addObject("msg", "Sukses.");
//            return modelandview;
//        } else {
//            ModelAndView modelandview = new ModelAndView();
//            modelandview.addObject("msg", "GAGAL.");
//            return modelandview;
//        }
         return listKasbulanan(req,Res);
    }

    private ModelAndView listKasbulanan(HttpServletRequest req, HttpServletResponse Res) {
        List<Kasbulanan> list=kasDao.get();
        ModelAndView modelandview =new ModelAndView();
        modelandview.addObject("listKasbulanan", list);
        return modelandview;
    }
    
}
