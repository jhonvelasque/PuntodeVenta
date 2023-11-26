package UTIL;
import java.sql.*;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class DbBean {
    String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=PEPEPHONE";
    String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    private Connection dbCon;
    private String login = "sa";
    private String password = "123456789"; 

    public DbBean() {
        conecta();
    }
    
    public boolean conecta(){
        try{
            Class.forName(this.dbDriver);
        }catch(java.lang.ClassNotFoundException e){
            System.out.println("Error en clase");
            return false;
        }
        try{
            this.dbCon = DriverManager.getConnection(this.dbURL, this.login, this.password);
        }catch(SQLException ex){
            System.out.println("No hay conexion al servidor");
            return false;
        }
        return true;
    }
    
    public void desconecta()throws SQLException{
        this.dbCon.close();
    }
    
       
    public ResultSet resultadoSQL(String sql)throws SQLException{
        Statement s = this.dbCon.createStatement();
        ResultSet r = s.executeQuery(sql);
        if(r==null){
            return null;
        }else{
            return r;
        }
    }
    public int ejecutaSQL(String sql)throws SQLException{
        Statement s = this.dbCon.createStatement();
        int r = s.executeUpdate(sql);
        if(r == 0){
            return 0;
        }else{
            return r;
        }
    }
    public void connectRep(String ruta, HashMap m, boolean sw)throws SQLException, JRException{
        conecta();
        JasperReport reporte = null;
        JasperPrint imp;
        reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
        if(sw == false){
            imp = JasperFillManager.fillReport(reporte, null, dbCon);
        }else{
            imp = JasperFillManager.fillReport(reporte, m, dbCon);
        }
        JasperViewer ver = new JasperViewer(imp);
        ver.setTitle("Reporte");
        ver.setVisible(true);                
    }
}


