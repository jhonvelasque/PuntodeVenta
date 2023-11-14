package DAO;

import BEAN.Cliente;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ClienteDAO {
    public Vector<Cliente> listClientes(boolean sw, String cad1, String cad2){
        Vector<Cliente> listaCliente = new Vector<Cliente>();
        DbBean con = new DbBean();
        String sql = "Select *from Cliente";
        if(sw == true){
            sql = sql + " where " + cad1 + " like '" + cad2 + "%'";
        }
        try{
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while(resultado.next()){
                Cliente c = new Cliente();
                c.setIdCliente(resultado.getInt(1));
                c.setIdCategoria(resultado.getInt(2));
                c.setNombCliente(resultado.getString(3));
                c.setApellCliente(resultado.getString(4));
                c.setDocCliente(resultado.getInt(5));
                c.setTelefono(resultado.getInt(6));
                c.setCorreo(resultado.getString(7));
                listaCliente.addElement(c);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        return listaCliente;
    }
    
    public void insertaCliente(Cliente c) {
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "insert into Cliente values ("+ c.getIdCliente()+",  ";
            sql += " "+ c.getIdCategoria()+", '"+ c.getNombCliente() +"', ";
            sql += " '"+ c.getApellCliente()+"', "+ c.getDocCliente() +", " + c.getTelefono() +", ";
            sql += " '"+ c.getCorreo()+"')";
            
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
    public void actualizaProducto(Cliente c){
        DbBean con;
        con = new DbBean();
        String sql;
        
        try{
            sql = "update Cliente set IdCategoria = " + c.getIdCategoria() + " , NombCliente = '"+ c.getNombCliente() +"', ";
            sql += " ApellCliente = '"+ c.getApellCliente() +"', DocCliente = "+ c.getDocCliente() +" , ";
            sql += " Telefono = "+ c.getTelefono() +" ,";
            sql += " Correo = '"+ c.getCorreo() +"' ";
            sql += " where IdCliente = "+ c.getIdCliente()+ "";
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
     public boolean eliminaCliente(Cliente c){
        DbBean con;
        con = new DbBean();
        String sql;
        boolean sw = true;
        try{
            sql = "select * from Cliente where IdCliente = "+ c.getIdCliente()+" ";
            
            ResultSet r;
            r = con.resultadoSQL(sql);
            if(r.next()){
                sw = true;
            }
            if(sw == true){
                sql = "delete from Cliente where IdCliente = "+ c.getIdCliente()+"";
                con.ejecutaSQL(sql);
                System.out.println(sql);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return sw;
    }
}
