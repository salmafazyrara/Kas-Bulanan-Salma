/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbulanan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kasbulanan.model.DatabaseConfig;
import kasbulanan.model.Kasbulanan;

/**
 *
 * @author Salma Fazira R
 */
public class KasbulananDAOProses implements KasbulananDAO {
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    @Override
    public List<Kasbulanan> get() {
       List<Kasbulanan> list=new ArrayList<Kasbulanan>();
        try{
//            list=new ArrayList<Mahasiswa>();
              String sql="SELECT * FROM tbl_kas";
              connection=DatabaseConfig.openConnection();
              statement=connection.createStatement();
              resultSet=statement.executeQuery(sql);
              while(resultSet.next()){
                  Kasbulanan kas=new Kasbulanan();
                  kas.setId(resultSet.getInt("id"));
                  kas.setBulan(resultSet.getString("bulan"));
                  kas.setPemasukan(resultSet.getString("pemasukan"));             
                  kas.setPengeluaran(resultSet.getString("pengeluaran"));
                  kas.setSaldoakhir(resultSet.getString("saldoakhir"));
                  list.add(kas);
              }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Kasbulanan kasbulanan) {
         boolean flag = false;
         try{
            String sql = "INSERT INTO tbl_kas(bulan,pemasukan,pengeluaran,saldoakhir) VALUES "+"(?,?,?,?)";
            connection=DatabaseConfig.openConnection();
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, kasbulanan.getBulan());
            preparedStatement.setString(2, kasbulanan.getPemasukan());
            preparedStatement.setString(3, kasbulanan.getPengeluaran());
            preparedStatement.setString(4, kasbulanan.getSaldoakhir());
            preparedStatement.executeUpdate();
            flag=true;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public Kasbulanan getSinggle(int id) {
       Kasbulanan kas=null;
        try{
            String sql="select * from tbl_kas where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                kas=new Kasbulanan();
                kas.setId(resultSet.getInt("id"));
                kas.setBulan(resultSet.getString("bulan"));
                kas.setPemasukan(resultSet.getString("pemasukan"));
                kas.setPengeluaran(resultSet.getString("pengeluaran"));
                kas.setSaldoakhir(resultSet.getString("saldoakhir"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return kas;
    }

    @Override
    public boolean update(Kasbulanan kasbulanan) {
        boolean flag=false;
        try{
            String sql="update tbl_kas set bulan=?,pemasukan=?, pegeluaran=? ,saldoakhir=? where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, kasbulanan.getBulan());
            preparedStatement.setString(2, kasbulanan.getPengeluaran());
            preparedStatement.setString(3, kasbulanan.getSaldoakhir());        
            preparedStatement.setInt(4, kasbulanan.getId());
            preparedStatement.executeUpdate();
            flag=true;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }
    
    

    @Override
    public boolean delete(int id) {
         boolean flag=false;
        try{
            String sql="delete from tbl_kas where id=?";
            connection=DatabaseConfig.openConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag=true;
        }catch(SQLException ex){
             ex.printStackTrace();
        }
        return flag;
    }
    
    
    
}
