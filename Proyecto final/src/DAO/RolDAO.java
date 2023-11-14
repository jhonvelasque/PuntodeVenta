
package DAO;

import BEAN.Rol;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class RolDAO {
    public RolDAO() {
    }
    //Visualizaciòn (select)
    public Vector<Rol> listaRol(boolean sw, String cad) throws SQLException{
            Vector<Rol> listaRol = new Vector<Rol>();
            DbBean con = new DbBean();
            String sql = "select * from Rol ";
        
        if (sw == true){
            sql = sql + " where DescRol like '"+ cad +"%'";
        }
        
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            
            while(resultado.next()){
                Rol rol = new Rol();
                rol.setIdRol(resultado.getInt(1));
                rol.setDesRol(resultado.getString(2));
                rol.setMensualidad(resultado.getInt(3));
                listaRol.addElement(rol);
            }   
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        //return listaAvi;
        return listaRol; 
    }
    
    
    //Inserciòn (inserts)
    public void insertaLibro(Rol r) throws SQLException{
        DbBean con = new DbBean();
        String sql;
        sql = "insert into Libro values ( ";
        sql = sql + " "+ r.getIdRol() +", '"+ r.getDesRol() +"')";
        con.ejecutaSQL(sql);
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
    }
    
    //Actualizaciòn (update)
    public void actualizaRol(Rol r){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "update Rol set DescripRol = '"+ r.getDesRol() +"', ";
            sql += " where Id_Rol = "+ r.getIdRol() +"";
           
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
