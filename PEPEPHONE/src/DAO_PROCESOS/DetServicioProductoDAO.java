package DAO_PROCESOS;


import BEAN_PROCESOS.DetServicioProducto;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class DetServicioProductoDAO {
    public DetServicioProductoDAO() {
    }
    // proceso de visualizaciòn (select)
    public Vector<DetServicioProducto> listaServicio(boolean sw, String cad, String camp){
        Vector <DetServicioProducto> listaSer = new Vector<DetServicioProducto>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from DetalleServicioProducto";
        if(sw){
            sql = sql + " where " + cad + " like '%"+ camp + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                DetServicioProducto ser = new DetServicioProducto();
                ser.setIdDetalleServicioProducto(resultado.getInt(1));
                ser.setIdServicio(resultado.getInt(2));
                ser.setIdProducto(resultado.getInt(3));
                ser.setCantidad(resultado.getInt(4));
                ser.setCostoUnitario(resultado.getFloat(5));
                ser.setSubtotal(resultado.getFloat(6));

                listaSer.addElement(ser);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaSer;
    }
    
   // proceso de insercion (Insert)
    public void insertaDetProdServicio(DetServicioProducto ser){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into DetalleServicioProducto values (";
            sql += "  "+ ser.getIdDetalleServicioProducto()+" ,";
            sql += "  "+ ser.getIdServicio()+",";
            sql += "  "+ ser.getIdProducto()+" ,";
            sql += " "+ ser.getCantidad()+",";
            sql += "  "+ ser.getCostoUnitario()+" ,";
            sql += "  "+ ser.getSubtotal()+" )";

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
    public void actualizaDetalleProdServicio(DetServicioProducto ser){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update DetalleServicioProducto set ";

            sql += " IdServicio= "+ ser.getIdServicio()+",";
            sql += " IdProducto= "+ ser.getIdProducto()+",";
            sql += " Cantidad= "+ ser.getCantidad()+",";
            sql += " CostoUnitario= "+ ser.getCostoUnitario()+",";
            sql += " Subtotal= "+ ser.getSubtotal()+" ";

            sql += " where IdDetalleServicio = "+ ser.getIdDetalleServicioProducto() + "";
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
    public void eliminaDetProdServicio(int idServicio){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  "delete from DetalleServicioProducto where IdDetalleServicio = " + idServicio + "  ";

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
