package DAO_PROCESOS;

import BEAN_PROCESOS.DetCompra;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class DetCompraDAO {
    // proceso de visualizaciòn (select)
    public Vector<DetCompra> listaDetCompra(boolean sw, String cad, String camp){
        Vector <DetCompra> listaDetComp = new Vector<DetCompra>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from DetalleCompra";
        if(sw){
            sql = sql + " where " + camp + " like '%"+ cad + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                DetCompra detComp = new DetCompra();
                detComp.setIdDetalleCompra(resultado.getInt(1));
                detComp.setIdCompra(resultado.getInt(2));
                detComp.setCostoUnitario(resultado.getFloat(3));
                detComp.setIdProducto(resultado.getInt(4));
                detComp.setCantidadProducto(resultado.getInt(5));
                detComp.setSubtotal(resultado.getFloat(6));
                listaDetComp.addElement(detComp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaDetComp;
    }
    
   // proceso de insercion (Insert)
    public void insertaDetCompra(DetCompra detComp){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into DetalleCompra values (";
            sql += " "+ detComp.getIdDetalleCompra()+" ,";
            sql += " "+ detComp.getIdCompra()+" ,";
            sql += " "+ detComp.getCostoUnitario()+",";
            sql += " "+ detComp.getIdProducto()+" ,";
            sql += " "+ detComp.getCantidadProducto()+",";
            sql += " "+ detComp.getSubtotal()+")";
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
    public void actualizaDetCompra(DetCompra detComp){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update DetalleCompra set ";
            sql += " IdCompra= "+ detComp.getIdCompra()+",";
            sql += " CostoUnitario= "+ detComp.getCostoUnitario()+",";
            sql += " IdProducto= "+ detComp.getIdProducto()+",";
            sql += " CantidadProducto= "+ detComp.getCantidadProducto()+",";
            sql += " SubTotal= "+ detComp.getSubtotal()+"";
            sql += " where IdDetalleCompra = "+ detComp.getIdDetalleCompra()+ "";
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
