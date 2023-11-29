package DAO_PROCESOS;

import BEAN_PROCESOS.DetVenta;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class DetVentaDAO {
    public DetVentaDAO() {
    }
    // proceso de visualizaciòn (select)
    public Vector<DetVenta> listaDetalleVenta(boolean sw, String cad, String camp){
        Vector <DetVenta> listaVen = new Vector<DetVenta>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from DetalleVenta";
        if(sw){
            sql = sql + " where " + camp +" = '"+ cad + "'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                DetVenta vent = new DetVenta();
                vent.setIdDetalleVenta(resultado.getInt(1));
                vent.setIdVenta(resultado.getInt(2));
                vent.setIdProducto(resultado.getInt(3));
                vent.setCantidadProducto(resultado.getInt(4));
                vent.setCostoUnitario(resultado.getFloat(5));
                vent.setSubTotal(resultado.getFloat(6));

                listaVen.addElement(vent);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaVen;
    }
    
   // proceso de insercion (Insert)
    public void insertaDetalleVenta(DetVenta vent){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into Venta values (";
            sql += "  "+ vent.getIdDetalleVenta()+" ,";
            sql += "  "+ vent.getIdVenta()+",";
            sql += "  "+ vent.getIdProducto()+" ,";
            sql += "  "+ vent.getCantidadProducto()+" ,";
            sql += "  "+ vent.getCostoUnitario()+" ,";
            sql += "  "+ vent.getSubTotal()+")";
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
     // proceso actualizaciòn Update
    public void actualizaDetalleVenta(DetVenta vent){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update DetalleVenta set ";
            //sql += " IdVenta= "+ vent.getIdEmpleado()+","; --- NO LE PUSE QUE ACTUALICE EL IDVENTA PORQUE NO DEBERÍA CAMBIAR
            sql += " IdProducto= "+ vent.getIdProducto()+",";
            sql += " CantidadProducto= "+ vent.getCantidadProducto()+",";
            sql += " CostoUnitario= "+ vent.getCostoUnitario()+",";
            sql += " SubTotal= "+ vent.getSubTotal()+"";
            sql += " where IdDetalleVenta = "+ vent.getIdDetalleVenta() + "";
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
     // proceso eliminación Delete
    public void eliminaDetalleVenta(int idVenta){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  "delete from DetalleVenta where IdDetalleVenta = " + idVenta + " ";
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
