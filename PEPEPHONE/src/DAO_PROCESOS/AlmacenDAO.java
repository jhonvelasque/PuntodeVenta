package DAO_PROCESOS;

import BEAN_PROCESOS.Almacen;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class AlmacenDAO {
    public Vector<Almacen> listAlmacen(boolean sw, String cad1, String cad2){
        Vector<Almacen> listAlmacen = new Vector<Almacen>();
        DbBean con = new DbBean();
        
        String sql = "Select *from Almacen ";
        
        if(sw == true){
            sql = sql + " where " + cad1 + " like '" + cad2 + "%'";
        }
        try{
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Almacen c = new Almacen();
                c.setIdAlmacen(resultado.getInt(1));
                c.setDescripcion(resultado.getString(2));
                c.setCiudad(resultado.getString(3));
                c.setDistrito(resultado.getString(4));
                c.setDireccion(resultado.getString(5));
                c.setCapacidad(resultado.getInt(6));

                listAlmacen.addElement(c);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listAlmacen;
    }
    public void insertaAlmacen(Almacen c) {
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "insert into Almacen values ("+ c.getIdAlmacen()+",  ";
            sql += " '"+ c.getDescripcion()+"', '"+ c.getCiudad() +"', ";
            sql += " '"+ c.getDistrito()+"', '"+ c.getDireccion()+"', " + c.getCapacidad()+")";
            
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
    public void actualizaAlmacen(Almacen c){
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "update Almacen set Descripcion = '" + c.getDescripcion() + "' , Ciudad = '"+ c.getCiudad()+"', ";
            sql += " Distrito = '"+ c.getDistrito() +"', Direccion = '"+ c.getDireccion() +"' , ";
            sql += " Capacidad = "+ c.getCapacidad() +" ";
            sql += " where IdAlmacen = "+ c.getIdAlmacen()+ " ";
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
     public boolean eliminaAlmacen(Almacen c){
        DbBean con;
        con = new DbBean();
        String sql;
        boolean sw = true;
        try{
            sql = "select * from Almacen where IdAlmacen = "+ c.getIdAlmacen()+" ";
            
            ResultSet r;
            r = con.resultadoSQL(sql);
            if(r.next()){
                sw = true;
            }
            if(sw == true){
                sql = "delete from Almacen where IdAlmacen = "+ c.getIdAlmacen()+"";
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
