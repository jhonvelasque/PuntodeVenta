package DAO_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.Producto;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ProductoDAO {
    public ProductoDAO() {
    }
    //Proceso de visualización(Select)
    public Vector<Producto> listaProductos(boolean sw, String cad, String camp){
        Vector<Producto> listaProd;
        listaProd = new Vector<Producto>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from Producto";
        if(sw == true){
            sql = sql + " where " + camp + " like '"+ cad +"%'";
        }
        try{
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Producto p = new Producto();
                p.setIdProducto(resultado.getInt(1));
                p.setIdCategoria(resultado.getInt(2));
                p.setMarca(resultado.getString(3));
                p.setNombreProducto(resultado.getString(4));
                p.setCostoUnitario(resultado.getFloat(5));
                p.setPrecioVenta(resultado.getFloat(6));
                p.setFechaIngreso(resultado.getString(7));
                p.setEstado(resultado.getInt(8));
                listaProd.addElement(p);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaProd;
    }
    //Proceso de inserción(Insert)
    
    public void insertaProducto(Producto prod){
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "insert into Producto values ("+ prod.getIdProducto()+",  ";
            sql += " "+ prod.getIdCategoria()+"', '"+ prod.getMarca()+"', '"+ prod.getNombreProducto()+"', "+ prod.getCostoUnitario()+", ";
            sql += " "+ prod.getPrecioVenta()+", '"+ prod.getFechaIngreso()+"', ";
            sql += " '"+ prod.getEstado()+"')";
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
    
    //Proceso de actualización(update)
    public void actualizaProducto(Producto prod){
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "update Producto set IdProducto = "+prod.getIdProducto()+", IdCategoria = "+ prod.getIdCategoria()+", ";
            sql += " Marca = '"+ prod.getMarca()+"', NombreProducto = '"+ prod.getNombreProducto()+"', CostoUnitario = "+ prod.getCostoUnitario()+", ";
            sql += " PrecioVenta = "+ prod.getPrecioVenta()+", FechaIngreso = '"+ prod.getFechaIngreso()+"', ";
            sql += " Estado = "+ prod.getEstado() +"";
            sql += " where IdProducto = "+ prod.getIdProducto()+"";
            
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
    
    //Proceso de eliminación(Delete)
     public boolean eliminaProducto(Producto prod){
        DbBean con;
        con = new DbBean();
        String sql;
        boolean sw = true;
        try{
            sql = "select * from Producto where IdProducto = "+ prod.getIdProducto()+"";
            ResultSet r;
            r = con.resultadoSQL(sql);
            if(r.next()){
                sw = false;
            }
            if(sw == true){
                sql = "delete from Producto where IdProducto = "+ prod.getIdProducto()+"";
                con.ejecutaSQL(sql);
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