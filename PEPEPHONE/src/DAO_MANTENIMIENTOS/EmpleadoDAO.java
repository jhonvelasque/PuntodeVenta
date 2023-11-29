package DAO_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.Empleado;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class EmpleadoDAO {
    public EmpleadoDAO(){
        
    }
    // proceso de visualizaciòn (select)
    public Vector<Empleado> listaEmpleado(boolean sw, String cad, String camp){
        Vector <Empleado> listaEmp;
        listaEmp = new Vector<Empleado>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from Empleado";
        if(sw == true){
            sql = sql + " where " + camp + " LIKE '"+ cad + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                Empleado em = new Empleado();
                em.setIdEmpleado(resultado.getInt(1));
                em.setNomEmpleado(resultado.getString(2));
                em.setApellEmpleado(resultado.getString(3));
                em.setDocEmpleado(resultado.getString(4));
                em.setDireccion(resultado.getString(5));
                em.setTelefono(resultado.getString(6));
                em.setCorreo(resultado.getString(7));
                em.setFechaInicio(resultado.getString(8));
                em.setFechaFinal(resultado.getString(9));
                em.setCargo(resultado.getString(10));
                em.setEstado(resultado.getInt(11));
                listaEmp.addElement(em);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaEmp;
    }
    
   // proceso de insercion (Insert)
    public void insertaEmpleado(Empleado emp){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into Empleado values ("+ emp.getIdEmpleado() +", ";
            sql += " '"+ emp.getNomEmpleado() +"', '"+ emp.getApellEmpleado() +"', ";
            sql += " '"+ emp.getDocEmpleado() +"', '"+ emp.getDireccion() +"', ";
            sql += " '"+ emp.getTelefono() +"', '"+ emp.getCorreo() +"', ";
            sql += " '"+ emp.getFechaInicio() +"', '"+ emp.getFechaFinal() +"', ";
            sql += " " +  emp.getEstado() +  ",'" + emp.getCargo() +"')";
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
     public void actualizaEmpleado(Empleado emp){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql = "update Empleado set NomEmpleado= '"+ emp.getNomEmpleado() +"', ";
            sql += " ApellEmpleado = '"+ emp.getApellEmpleado()+"', ";
            sql += " DocEmpleado = '"+ emp.getDocEmpleado() +"', Dirección = '"+ emp.getDireccion() +"', ";
            sql += " Telefono = '"+ emp.getTelefono() +"', Correo = '"+ emp.getCorreo() +"', ";
            sql += " FechaInicio = '"+ emp.getFechaInicio() +"', FechaFinal = '"+ emp.getFechaFinal() +"', ";
            sql += " Cargo = '"+ emp.getCargo() +"', Estado = "+ emp.getEstado() +" ";
            sql += " where IdEmpleado = "+ emp.getIdEmpleado() + "";
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
    // Elimianacio (Delete)
    public boolean eliminaEmpleado(Empleado emp){
        DbBean con;
        con = new DbBean();
        String sql;
        boolean sw = true;
        try{
            sql = " delete from Empleado where IdEmpleado = "+ emp.getIdEmpleado() +"";
            System.out.println("peru chile: "+sql);
            ResultSet r;
            r = con.resultadoSQL(sql);

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
    public Empleado buscaEmpleado(int idEm){
         DbBean con;
         con = new DbBean();
         String sql =  " select * from Empleado where IdEmpleado = " + idEm;
         Empleado em = new Empleado();
         try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            if(resultado.next()){
                em.setIdEmpleado(resultado.getInt(1));
                em.setNomEmpleado(resultado.getString(2));
                em.setApellEmpleado(resultado.getString(3));
                em.setDocEmpleado(resultado.getString(4));
                em.setDireccion(resultado.getString(5));
                em.setTelefono(resultado.getString(6));
                em.setCorreo(resultado.getString(7));
                em.setFechaInicio(resultado.getString(8));
                em.setFechaFinal(resultado.getString(9));
                em.setCargo(resultado.getString(10));
                em.setEstado(resultado.getInt(11));
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return em;
    }
 }
