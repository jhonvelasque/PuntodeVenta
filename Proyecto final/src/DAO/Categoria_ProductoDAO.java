/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Categoria_producto;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author carlo
 */
public class Categoria_ProductoDAO {
    public Vector<Categoria_producto> listaCatProductos(boolean sw, String cad){
        Vector<Categoria_producto> listaCatProd;
        listaCatProd = new Vector<Categoria_producto>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from CategoriaProducto";
        System.out.println(sql);
        if(sw == true){
            sql = sql + " where DescCategoria like '"+ cad +"%'";
        }
        try{
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Categoria_producto cp = new Categoria_producto();
                cp.setId_categoria(resultado.getInt(1));
                cp.setCategoria(resultado.getString(2));
                cp.setSubcategoria(resultado.getInt(3));
                cp.setMarca(resultado.getString(4));
                cp.setModelo(resultado.getString(5));
                cp.setDescripcion(resultado.getString(6));
                listaCatProd.addElement(cp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        System.out.println(listaCatProd);
        return listaCatProd;
    }
    public void insertaProducto(Categoria_producto catprod){
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "insert into producto values ("+ catprod.getId_categoria()+",  ";
            sql += " '"+ catprod.getCategoria()+"', '"+ catprod.getSubcategoria() +"', ";
            sql += " '"+ catprod.getMarca()+"', '"+ catprod.getModelo() +"', ";
            sql += " '"+ catprod.getDescripcion()+"'";
            //sql += " "+ catprod.getMarca() +", "+ catprod.getModelo() +")";
            System.out.println(sql);
            con.ejecutaSQL(sql);
            
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    public void actualizaProducto(Categoria_producto catprod){
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "update producto set DescCategoria = '"+ catprod.getCategoria() +"', ";
            sql += " Subcategoria = '"+ catprod.getSubcategoria() +"', Marca = "+ catprod.getMarca() +", ";
            sql += " Modelo = "+ catprod.getModelo() +" ";
            sql += " Descripcion = "+ catprod.getDescripcion() +" ";
            sql += " where id_producto = "+ catprod.getId_categoria()+"";
            
            con.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
}
