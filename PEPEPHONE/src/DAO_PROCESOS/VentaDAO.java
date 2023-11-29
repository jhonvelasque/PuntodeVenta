package DAO_PROCESOS;

import BEAN_PROCESOS.Venta;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class VentaDAO {

    public VentaDAO() {
    }
    // proceso de visualizaciòn (select)
    public Vector<Venta> listaVenta(boolean sw, String cad, String camp){
        Vector <Venta> listaVen = new Vector<Venta>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from Venta";
        if(sw){
            sql = sql + " where " + cad + " like '%"+ camp + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                Venta vent = new Venta();
                vent.setIdVenta(resultado.getInt(1));
                vent.setIdEmpleado(resultado.getInt(2));
                vent.setIdCliente(resultado.getInt(3));
                vent.setFechaVenta(resultado.getString(4));
                vent.setTotalVenta(resultado.getFloat(5));
                vent.setObservacion(resultado.getString(6));
                vent.setEstado(resultado.getInt(7));
                vent.setTipoPago(resultado.getInt(8));
                vent.setIdAlmacen(resultado.getInt(9));
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
    public void insertaVenta(Venta vent){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into Venta values (";
            sql += "  "+ vent.getIdVenta()+" ,";
            sql += "  "+ vent.getIdEmpleado()+",";
            sql += "  "+ vent.getIdCliente()+" ,";
            sql += " '"+ vent.getFechaVenta()+"',";
            sql += "  "+ vent.getTotalVenta()+" ,";
            sql += " '"+ vent.getObservacion()+"',";
            sql += "  "+ vent.getEstado()+" ,";
            sql += "  "+ vent.getTipoPago()+",";
            sql += "  "+ vent.getIdAlmacen()+")";
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
    public void actualizaVenta(Venta vent){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update Venta set ";
            sql += " IdEmpleado= "+ vent.getIdEmpleado()+",";
            sql += " IdCliente= "+ vent.getIdCliente()+",";
            sql += " FechaVenta= '"+ vent.getFechaVenta()+"',";
            sql += " TotalVenta= "+ vent.getTotalVenta()+",";
            sql += " Observación= '"+ vent.getObservacion()+"',";
            sql += " Estado= "+ vent.getEstado()+",";
            sql += " TipoPago= "+ vent.getTipoPago()+"";
            sql += " IdAlmacen= "+ vent.getIdAlmacen()+"";
            sql += " where IdVenta = "+ vent.getIdVenta() + "";
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
    public void eliminaVenta(int idVenta){
        DbBean con;
        con = new DbBean();
        String sql;
        try {
            sql =  " delete from DetalleVenta where IdVenta = " + idVenta + ";";
            sql =  "\ndelete from Venta where IdVenta = " + idVenta;
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
