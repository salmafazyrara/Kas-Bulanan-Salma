<%-- 
    Document   : home
    Created on : Dec 2, 2021, 7:26:49 PM
    Author     : Salma Fazira R
--%>

<%@page isELIgnored="false" %>
<%@include file="include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <h2>Daftar Kas Bulanan</h2>
        <p>
        <table class="table table-striped table-bordered table-primary" >
            <tr style="background-color:grey; color:white;">
                <th>ID</th>                   
                <th>bulan</th>
                <th>Pemasukan</th>
                <th>Pengeluaran</th>
                <th>Saldo akhir</th>
                <th>Aksi</th>
            </tr>
            <c:forEach items="${listKasbulanan}" var="kas">
                <tr>
                    <td>${kas.id}</td>                                 
                    <td>${kas.bulan}</td>
                    <td>${kas.pemasukan}</td>
                    <td>${kas.pengeluaran}</td>
                    <td>${kas.saldoakhir}</td>
                    <td>
                        <button class="btn btn-primary" onclick="window.location.href='kasbulanan-form2.html?action=edit&id=${kas.id}'">Edit</button>
                        <button class="btn btn-danger" onclick="window.location.href='kasbulanan-form.html?action=delete&id=${kas.id}'">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </p>
        <p>
            <button class="btn btn-primary" onclick="window.location.href='kasbulanan-form.html'" >
                Add Kas Baru
            </button>
        </p>
        
    </body>
        
    </body>
</html>
