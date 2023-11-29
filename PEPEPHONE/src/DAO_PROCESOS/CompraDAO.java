package DAO_PROCESOS;

import BEAN_PROCESOS.Compra;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class CompraDAO {
    public CompraDAO() {
    }
    // proceso de visualizaciòn (select)
    public Vector<Compra> listaCompra(boolean sw, String cad, String camp){
        Vector <Compra> listaComp = new Vector<Compra>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from Compra";
        if(sw){
            sql = sql + " where " + camp + " like '%"+ cad + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                Compra comp = new Compra();
                comp.setIdCompra(resultado.getInt(1));
                comp.setFechaEntrega(resultado.getString(2));
                comp.setIdEmpleado(resultado.getInt(3));
                comp.setIdProveedor(resultado.getInt(4));
                comp.setFechaCompra(resultado.getString(5));
                comp.setTotalCompra(resultado.getFloat(6));
                comp.setObservacion(resultado.getString(7));
                comp.setEstado(resultado.getInt(8));
                comp.setTipoPago(resultado.getInt(9));
                comp.setIdAlmacen(resultado.getInt(10));
                listaComp.addElement(comp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaComp;
    }
    
   // proceso de insercion (Insert)
    public void insertaCompra(Compra comp){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into Compra values (";
            sql += "  "+ comp.getIdCompra()+" ,";
            sql += " '"+ comp.getFechaEntrega()+"' ,";
            sql += "  "+ comp.getIdEmpleado()+",";
            sql += "  "+ comp.getIdProveedor()+" ,";
            sql += " '"+ comp.getFechaCompra()+"',";
            sql += "  "+ comp.getTotalCompra()+" ,";
            sql += " '"+ comp.getObservacion()+"',";
            sql += "  "+ comp.getEstado()+" ,";
            sql += "  "+ comp.getTipoPago()+",";
            sql += "  "+ comp.getIdAlmacen()+")";
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
    public void actualizaCompra(Compra comp){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update Compra set ";
            sql += " FechaEntrega= '"+ comp.getFechaEntrega()+"',";
            sql += " IdEmpleado= "+ comp.getIdEmpleado()+",";
            sql += " IdProveedor= "+ comp.getIdProveedor()+",";
            sql += " FechaCompra= '"+ comp.getFechaCompra()+"',";
            sql += " TotalCompra= "+ comp.getTotalCompra()+",";
            sql += " Observación= '"+ comp.getObservacion()+"',";
            sql += " Estado= "+ comp.getEstado()+",";
            sql += " TipoPago= "+ comp.getTipoPago()+"";
            sql += " IdAlmacen= "+ comp.getIdAlmacen()+"";
            sql += " where IdCompra = "+ comp.getIdProveedor() + "";
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
    public void eliminaCompra(int idCompra){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " delete from DetalleCompra where IdCompra = " + idCompra + ";";
            sql +=  "\ndelete from Compra where IdCompra = " + idCompra;
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
