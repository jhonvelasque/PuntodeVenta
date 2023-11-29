package DAO_PROCESOS;


import BEAN_PROCESOS.DetServicioCatServicio;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class DetServicioCategoriaDAO {
    public DetServicioCategoriaDAO() {
    }
    // proceso de visualizaciòn (select)
    public Vector<DetServicioCatServicio> listaServicio(boolean sw, String cad, String camp){
        Vector <DetServicioCatServicio> listaSer = new Vector<DetServicioCatServicio>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from DetalleServicioCatServicio";
        if(sw){
            sql = sql + " where " + cad + " like '%"+ camp + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                DetServicioCatServicio ser = new DetServicioCatServicio();
                ser.setIdDetalleServicio(resultado.getInt(1));
                ser.setIdServicio(resultado.getInt(2));
                ser.setIdCategoriaServicio(resultado.getInt(3));
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
    public void insertaDetCatServicio(DetServicioCatServicio ser){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into DetalleServicioCatServicio values (";
            sql += "  "+ ser.getIdDetalleServicio()+" ,";
            sql += "  "+ ser.getIdServicio()+",";
            sql += "  "+ ser.getIdCategoriaServicio()+" ,";
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
    public void actualizaDetalleCatServicio(DetServicioCatServicio ser){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update DetalleServicioCatServicio set ";

            sql += " IdServicio= "+ ser.getIdServicio()+",";
            sql += " IdCategoriaServicio= "+ ser.getIdCategoriaServicio()+",";
            sql += " Cantidad= "+ ser.getCantidad()+",";
            sql += " CostoUnitario= "+ ser.getCostoUnitario()+",";
            sql += " Subtotal= "+ ser.getSubtotal()+" ";

            sql += " where IdDetalleServicio = "+ ser.getIdDetalleServicio() + "";
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
    public void eliminaDetCatServicio(int idServicio){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  "delete from DetalleServicioCatServicio where IdDetalleServicio = " + idServicio + "  ";

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
