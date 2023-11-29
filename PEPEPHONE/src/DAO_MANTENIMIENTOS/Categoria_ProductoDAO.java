package DAO_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.Categoria_producto;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class Categoria_ProductoDAO {
    public Vector<Categoria_producto> listaCatProductos(boolean sw, String cad, String camp){
        Vector<Categoria_producto> listaCatProd;
        listaCatProd = new Vector<Categoria_producto>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from CategoriaProducto";
        if(sw == true){
            sql = sql + " where " + camp + " like '"+ cad +"%'";
        }
        try{
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Categoria_producto cp = new Categoria_producto();
                cp.setId_categoria(resultado.getInt(1));
                cp.setCategoria(resultado.getString(2));
                cp.setSubcategoria(resultado.getInt(3));
                cp.setGarantia(resultado.getString(4));
                cp.setDimension(resultado.getString(5));
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
        
        return listaCatProd;
    }
    public void insertaCategoriaProducto(Categoria_producto catprod){
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "insert into CategoriaProducto values ("+ catprod.getId_categoria()+",  ";
            sql += " '"+ catprod.getCategoria()+"', "+ catprod.getSubcategoria() +", ";
            sql += " '"+ catprod.getGarantia()+"', '"+ catprod.getDimension()+"', ";
            sql += " '"+ catprod.getDescripcion()+"')";
            //sql += " "+ catprod.getMarca() +", "+ catprod.getModelo() +")";
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
    public void actualizaCategoriaProducto(Categoria_producto catprod){
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "update CategoriaProducto set DescCategoria = '"+ catprod.getCategoria() +"', ";
            sql += " Subcategoria = "+ catprod.getSubcategoria() +", Garantia = '"+ catprod.getGarantia()+"' , ";
            sql += " Dimension = '"+ catprod.getDimension()+"' ,";
            sql += " Descripcion = '"+ catprod.getDescripcion() +"' ";
            sql += " where IdCategoria = "+ catprod.getId_categoria()+"";
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
     public boolean eliminaCategoriaProducto(Categoria_producto catprod){
        DbBean con;
        con = new DbBean();
        String sql;
        boolean sw = true;
        try{
            sql = "select * from CategoriaProducto where IdCategoría = "+ catprod.getId_categoria()+"";
            
            ResultSet r;
            r = con.resultadoSQL(sql);
            if(r.next()){
                sw = true;
            }
            if(sw == true){
                sql = "delete from CategoriaProducto where IdCategoría = "+ catprod.getId_categoria() +"";
                con.ejecutaSQL(sql);
                System.out.println(sql);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return sw;
    }
}
