package DAO_PROCESOS;



import BEAN_PROCESOS.Servicio;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ServicioDAO {
    
    public ServicioDAO() {
    }
    // proceso de visualizaciòn (select)
    public Vector<Servicio> listaServicio(boolean sw, String cad, String camp){
        Vector <Servicio> listaSer = new Vector<Servicio>();
        String sql;
        DbBean con;
        con = new DbBean();
        sql = "Select * from Servicio";
        if(sw){
            sql = sql + " where " + cad + " like '%"+ camp + "%'";
        }
        try {
            ResultSet resultado;
            resultado = con.resultadoSQL(sql);
            while (resultado.next()){
                Servicio ser = new Servicio();
                ser.setIdServicio(resultado.getInt(1));
                ser.setIdEmpleado(resultado.getInt(2));
                ser.setIdCliente(resultado.getInt(3));
                ser.setFechaServicio(resultado.getString(4));
                ser.setFechaEntrega(resultado.getString(5));
                ser.setTotalServicio(resultado.getFloat(6));
                ser.setObservacion(resultado.getString(7));
                ser.setEstado(resultado.getInt(8));
                ser.setTipoPago(resultado.getInt(9));
                ser.setIdAlmacen(resultado.getInt(910));
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
    public void insertaServicio(Servicio ser){
        DbBean con;
        con = new DbBean();
        String sql;
        try{
            sql = "insert into Servicio values (";
            sql += "  "+ ser.getIdServicio()+" ,";
            sql += "  "+ ser.getIdEmpleado()+",";
            sql += "  "+ ser.getIdCliente()+" ,";
            sql += " '"+ ser.getFechaServicio()+"',";
            sql += " '"+ ser.getFechaEntrega()+"',";
            sql += "  "+ ser.getTotalServicio()+" ,";
            sql += " '"+ ser.getObservacion()+"',";
            sql += "  "+ ser.getEstado()+" ,";
            sql += "  "+ ser.getTipoPago()+",";
            sql += "  "+ ser.getIdAlmacen()+")";
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
    public void actualizaServicio(Servicio ser){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  " update Servicio set ";
            sql += " IdEmpleado= "+ ser.getIdEmpleado()+",";
            sql += " IdCliente= "+ ser.getIdCliente()+",";
            sql += " FechaServicio= '"+ ser.getFechaServicio()+"',";
            sql += " FechaEntrega= '"+ ser.getFechaEntrega()+"',";
            sql += " TotalServicio= "+ ser.getTotalServicio()+",";
            sql += " Observación= '"+ ser.getObservacion()+"',";
            sql += " Estado= "+ ser.getEstado()+",";
            sql += " TipoPago= "+ ser.getTipoPago()+"";
            sql += " IdAlmacen= "+ ser.getIdAlmacen()+"";
            sql += " where IdServicio = "+ ser.getIdServicio() + "";
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
    public void eliminaServicio(int idServicio){
         DbBean con;
         con = new DbBean();
         String sql;
         try {
            sql =  "delete from DetalleServicioCatServicio where IdServicio = " + idServicio + " ; ";
            sql +=  "\ndelete from DetalleServicioProducto where IdServicio = " + idServicio;
            sql +=  "\ndelete from Servicio where IdServicio = " + idServicio;

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
