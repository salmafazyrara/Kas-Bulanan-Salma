<%-- 
    Document   : kasbulanan-form
    Created on : Dec 2, 2021, 8:20:53 PM
    Author     : Salma Fazira R
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Kas Bulanan</title>
    </head>
    <body>
       <div class="container" >
            <h2>Tambah Kas</h2>
            <div class="row">
                    <form action="kasbulanan-form.html" modelAttribute="kas" method="POST"  >                    
                        <div class="mb-3">
                            <label for="bulan" class="form-label" >Kas Bulan</label>
                            <input type="text" class="form-control" id="bulan" name="bulan" value="${kas.bulan}"/>
                        </div>
                         <div class="mb-3">
                              <label for="pemasukan" class="form-label" >Kas Masuk</label>
                              <input type="text" class="form-control" id="pemasukan" name="pemasukan" value="${kas.pemasukan}"/>
                        </div>
                        <div class="mb-3">
                             <label for="pengeluaran" class="form-label" >Pengeluaran</label>
                             <input type="text" class="form-control" id="pengeluaran" name="pengeluaran" value="${kas.pengeluaran}"/>
                        </div> 
                        <div class="mb-3">
                             <label for="saldoakhir" class="form-label" >Saldo Akhir</label>
                             <input type="text" class="form-control" id="saldoakhir" name="saldoakhir" value="${kas.saldoakhir}"/>
                        </div> 
                         <div class="mb-3">
                        <button type="submit" class="btn btn-primary">Save</button>
                         </div>
                    </form>
                
            </div>
            <a href="${pageContext.request.contextPath}/home.html">Kembali ke List</a>
        </div>
    </body>
</html>
