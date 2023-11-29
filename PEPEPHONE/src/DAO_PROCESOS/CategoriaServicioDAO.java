package DAO_PROCESOS;

import BEAN_PROCESOS.CategoriaServicio;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class CategoriaServicioDAO {
    public CategoriaServicioDAO() {
    }
    // proceso de visualizaciòn (select)
    public Vector<CategoriaServicio> listaCategoriaServicio(boolean sw, String cad, String camp){
        Vector <CategoriaServicio> listaCatServ = new Vector<CategoriaServicio>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from CategoriaServicio";
        if(sw){
            sql = sql + " where " + camp + " like '%"+ cad + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                CategoriaServicio catServ = new CategoriaServicio();
                catServ.setIdCategoriaServicio(resultado.getInt(1));
                catServ.setNombreServicio(resultado.getString(2));
                catServ.setCostoUnitario(resultado.getFloat(3));
                listaCatServ.addElement(catServ);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaCatServ;
    }
    
   // proceso de insercion (Insert)
    public void insertaCategoriaServicio(CategoriaServicio catServ){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into CategoriaServicio values (";
            sql += "  "+ catServ.getIdCategoriaServicio()+" ,";
            sql += " '"+ catServ.getNombreServicio()+"',";
            sql += "  "+ catServ.getCostoUnitario()+")";
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
    public void actualizaCategoriaServicio(CategoriaServicio catServ){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update CategoriaServicio set ";
            sql += " NombreServicio= '"+ catServ.getNombreServicio()+"',";
            sql += " CostoUnitario= "+ catServ.getCostoUnitario()+"";
            sql += " where IdCategoriaServicio = "+ catServ.getIdCategoriaServicio() + "";
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
