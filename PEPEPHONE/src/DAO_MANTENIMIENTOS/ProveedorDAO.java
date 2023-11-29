package DAO_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.Proveedor;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ProveedorDAO {
    public ProveedorDAO() {
    }
    // proceso de visualizaciòn (select)
    public Vector<Proveedor> listaProveedor(boolean sw, String cad, String camp){
        Vector <Proveedor> listaProv;
        listaProv = new Vector<Proveedor>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from Proveedor";
        if(sw){
            sql = sql + " where " + camp + " LIKE '%"+ cad + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                Proveedor prov = new Proveedor();
                prov.setIdProveedor(resultado.getInt(1));
                prov.setRUC(resultado.getInt(2));
                prov.setNombre(resultado.getString(3));
                prov.setTelefono(resultado.getInt(4));
                prov.setCorreo(resultado.getString(5));
                prov.setDirección(resultado.getString(6));
                listaProv.addElement(prov);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaProv;
    }
    
   // proceso de insercion (Insert)
    public void insertaProveedor(Proveedor prov){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into Proveedor values (";
            sql += "  "+ prov.getIdProveedor()  +" ,";
            sql += "  "+ prov.getRUC()          +" ,";
            sql += " '"+ prov.getNombre()       +"',";
            sql += "  "+ prov.getTelefono()     +" ,";
            sql += " '"+ prov.getCorreo()       +"',";
            sql += " '"+ prov.getDirección()    +"')";
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
     public void actualizaProveedor(Proveedor prov){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update Proveedor set ";
            sql += " RUC= "+ prov.getRUC() +",";
            sql += " Nombre= '"+ prov.getNombre() +"',";
            sql += " Telefono= "+ prov.getTelefono() +",";
            sql += " Correo= '"+ prov.getCorreo() +"',";
            sql += " Dirección= '"+ prov.getDirección() +"'";
            sql += " where IdProveedor = "+ prov.getIdProveedor() + "";
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
    // Busca un proveedor
    public Proveedor BuscarProveedor(int idProv){
         DbBean con;
         con = new DbBean();
         String sql =  " select * from Proveedor where IdProveedor = " + idProv;
         Proveedor prov = new Proveedor();
         try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            if(resultado.next()){
                prov.setIdProveedor(resultado.getInt(1));
                prov.setRUC(resultado.getInt(2));
                prov.setNombre(resultado.getString(3));
                prov.setTelefono(resultado.getInt(4));
                prov.setCorreo(resultado.getString(5));
                prov.setDirección(resultado.getString(6));
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return prov;
    }
}
