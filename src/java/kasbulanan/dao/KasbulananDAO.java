/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbulanan.dao;

import java.util.List;
import kasbulanan.model.Kasbulanan;

/**
 *
 * @author Salma Fazira R
 */
public interface KasbulananDAO {
    List<Kasbulanan> get();  
    boolean save(Kasbulanan kasbulanan);
    Kasbulanan getSinggle(int id);
    boolean update(Kasbulanan kasbulanan);
    boolean delete(int id);
}
