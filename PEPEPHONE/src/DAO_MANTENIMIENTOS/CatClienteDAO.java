
package DAO_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.CatCliente;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class CatClienteDAO {
    public CatClienteDAO(){    
    }

    public Vector<CatCliente> listaCatCliente(boolean sw, String cad, String camp){
        Vector<CatCliente> listaCatCliente = new Vector<CatCliente>();
        DbBean con = new DbBean();
        String sql = "select * from CategoriaCliente ";
        
        if(sw == true){
            sql = sql + " where "+ camp +" like '"+ cad +"%'";
        }

        try{
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            
            while(resultado.next()){
                CatCliente cat = new CatCliente();
                cat.setIdCategoriaCliente(resultado.getInt(1));
                cat.setSegCliente(resultado.getString(2));
                cat.setFrecCompra(resultado.getString(3));
                cat.setCuotas(resultado.getString(4));
                cat.setCantCuotas(resultado.getString(5));
                cat.setEstado(resultado.getInt(6));
                
                listaCatCliente.addElement(cat);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaCatCliente;
    }
    public void insertaCategoría(CatCliente cat){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "insert into CategoriaCliente values ( ";
            sql +=  " "+ cat.getIdCategoriaCliente() +", ";
            sql += " '"+ cat.getSegCliente()+"', '"+ cat.getFrecCompra()+"', ";
            sql += " '"+ cat.getCuotas()+"','"+cat.getCantCuotas()+"', ";
            sql += " "+ cat.getEstado()+")";
        System.out.println(sql);
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
        public void actualizaCategoria(CatCliente cat){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "update CategoriaCliente set SegCliente = '"+ cat.getSegCliente() +"', ";
            sql += "FrecCompra = '"+ cat.getFrecCompra() +"', ";
            sql += "Cuotas = '"+ cat.getCuotas() +"', CantCuotas = '"+cat.getCantCuotas()+"', ";
            sql += "Estado = " + cat.getEstado() +" ";
            sql += " where IdCategoriaCliente = "+ cat.getIdCategoriaCliente()+"";
            System.out.println(sql);
           
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

