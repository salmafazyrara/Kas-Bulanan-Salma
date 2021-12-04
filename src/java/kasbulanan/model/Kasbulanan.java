/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbulanan.model;

/**
 *
 * @author Salma Fazira R
 */
public class Kasbulanan {
    private int id;
    private String bulan;
    private String pemasukan;
    private String pengeluaran;
    private String saldoakhir;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(String pemasukan) {
        this.pemasukan = pemasukan;
    }

    public String getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(String pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public String getSaldoakhir() {
        return saldoakhir;
    }

    public void setSaldoakhir(String saldoakhir) {
        this.saldoakhir = saldoakhir;
    }
    
    
}
