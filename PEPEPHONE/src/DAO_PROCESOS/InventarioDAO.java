package DAO_PROCESOS;

import BEAN_PROCESOS.Almacen;
import BEAN_PROCESOS.Inventario;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class InventarioDAO {
    public Vector<Inventario> listInventario(boolean sw, String cad, String camp){
        Vector<Inventario> listInv = new Vector<Inventario>();
        DbBean con = new DbBean();
        
        String sql = "Select *from Inventario ";
        
        if(sw == true){
            sql = sql + " where " + camp + " like '" + cad + "%'";
        }
        try{
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Inventario inv = new Inventario();
                inv.setIdInventario(resultado.getInt(1));
                inv.setIdProducto(resultado.getInt(2));
                inv.setIdAlmacen(resultado.getInt(3));
                inv.setCantidadStock(resultado.getInt(4));
                inv.setFechaActualizacion(resultado.getString(5));
                inv.setMinimoStock(resultado.getInt(6));

                listInv.addElement(inv);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listInv;
    }
    public void actualizaInventario(Inventario inv, String proceso){ // Venta o servicio
        DbBean con;
        con = new DbBean();
        String sql = "select * from Inventario ";
        boolean acepta = false;
        Inventario aux = new Inventario();
        
        try{
            ResultSet resul = con.resultadoSQL(sql);
            while(resul.next()){
                aux.setIdInventario(resul.getInt(1));
                aux.setIdInventario(resul.getInt(2));
                aux.setIdInventario(resul.getInt(3));
                aux.setIdInventario(resul.getInt(4));
                aux.setIdInventario(resul.getInt(5));
                aux.setIdInventario(resul.getInt(6));
                if(aux.getIdAlmacen()==inv.getIdAlmacen() && aux.getIdProducto()==inv.getIdProducto()){
                    acepta = true;
                    break;
                }
            }
            
            if(acepta){
                sql = "update Inventario set ";
                switch(proceso){
                    case "Compra": inv.setCantidadStock(aux.getCantidadStock() + inv.getCantidadStock()); break;
                    default: inv.setCantidadStock(aux.getCantidadStock() - inv.getCantidadStock()); break;
                }
                sql += " CantidadStock = "+ inv.getCantidadStock()+" ";
                sql += " where IdInventario = "+ aux.getIdInventario()+ " ";
            }else{
                sql = "insert into Inventario values ("+ inv.getIdInventario()+",  ";
                sql += " "+ inv.getIdProducto()+", "+ inv.getIdAlmacen()+", ";
                sql += " "+ inv.getCantidadStock()+", '"+ inv.getFechaActualizacion()+"', " + inv.getMinimoStock()+")";
            }
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
    public boolean ComparaStock(int IdAlm, int IdProd, int cant){
        DbBean con;
        con = new DbBean();
        String sql =  " select * from Inventario where IdAlmacen = " + IdAlm + " and IdProducto = " + IdProd;
        Inventario inv = new Inventario();
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            if(resultado.next()){
                inv.setIdInventario(resultado.getInt(1));
                inv.setIdProducto(resultado.getInt(2));
                inv.setIdAlmacen(resultado.getInt(3));
                inv.setCantidadStock(resultado.getInt(4));
                inv.setFechaActualizacion(resultado.getString(5));
                inv.setMinimoStock(resultado.getInt(6));
                if(inv.getCantidadStock() < cant){
                    return false;
                }
            }else{
                return false;
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
