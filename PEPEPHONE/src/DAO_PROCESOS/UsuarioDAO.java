package DAO_PROCESOS;

import BEAN_PROCESOS.Usuario;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class UsuarioDAO {
    public UsuarioDAO() {
    }
    public Vector<Usuario> listaUsuario(boolean sw, String cad, String camp){
        Vector<Usuario> listaUsu = new Vector<Usuario>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from Usuario";
        if(sw){
            sql = sql + " where " + camp + " LIKE '%"+ cad + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                Usuario usu = new Usuario();
                usu.setIdUsuario(resultado.getInt(1));
                usu.setIdEmpleado(resultado.getInt(2));
                usu.setUsuario(resultado.getString(3));
                usu.setContraseña(resultado.getString(4));
                usu.setUsrReg(resultado.getString(5));
                usu.setFechReg(resultado.getString(6));
                usu.setUsrMod(resultado.getString(7));
                usu.setFechMod(resultado.getString(8));
                listaUsu.addElement(usu);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaUsu;
    }
    
    public void insertaUsuario(Usuario usu){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into Usuario values (";
            sql += "  "+ usu.getIdUsuario()+" ,";
            sql += "  "+ usu.getIdEmpleado()+" ,";
            sql += " '"+ usu.getUsuario()+"',";
            sql += " '"+ usu.getContraseña()+"' ,";
            sql += " '"+ usu.getUsrReg()+"',";
            sql += " '"+ usu.getFechReg()+"' ,";
            sql += " '"+ usu.getUsrMod()+"',";
            sql += " '"+ usu.getFechMod()+"')";
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
     public void actualizaUsuario(Usuario usu){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update Usuario set ";
            sql += " IdEmpleado= "+ usu.getIdEmpleado()+",";
            sql += " Usuario= '"+ usu.getUsuario()+"',";
            sql += " Contraseña= '"+ usu.getContraseña()+"',";
            sql += " UsrReg= '"+ usu.getUsrReg()+"',";
            sql += " FechReg= '"+ usu.getFechReg()+"',";
            sql += " UsrMod= '"+ usu.getUsrMod()+"',";
            sql += " FechMod= '"+ usu.getFechMod()+"'";
            sql += " where IdUsuario = "+ usu.getIdUsuario()+ "";
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
    public void eliminaUsuario(int IdUsu){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " delete from Usuario where IdUsuario = " + IdUsu;
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
    public Usuario retornaUsuario(int idUsu){
        DbBean con;
        con = new DbBean();
        String sql;
        Usuario u = new Usuario();
        try {
            sql =  " select * from Usuario where IdUsuario = " + idUsu;
            ResultSet resul = con.resultadoSQL(sql);
            if(resul.next()){
                u.setIdUsuario(resul.getInt(1));
                u.setIdEmpleado(resul.getInt(2));
                u.setUsuario(resul.getString(3));
                u.setContraseña(resul.getString(4));
                u.setUsrReg(resul.getString(5));
                u.setFechReg(resul.getString(6));
                u.setUsrMod(resul.getString(7));
                u.setFechMod(resul.getString(8));
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return u;
    }
}
