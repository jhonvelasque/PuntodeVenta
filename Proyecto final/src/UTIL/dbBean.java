package UTIL;
import java.sql.*;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class dbBean {
  //Conexión: a través del ODBC
    String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Mantenimiento";
    String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private Connection dbCon;
    private String Login="sa";
    private String password="123456789";


  public dbBean(){
       connect();
       }

    public boolean connect() {
        try {
            Class.forName(this.dbDriver);
        } catch(java.lang.ClassNotFoundException e) {
            System.out.println("Error en class");
            return false;
        }
        try {
            dbCon = DriverManager.getConnection(this.dbURL, this.Login, this.password);
        } catch(SQLException ex) {
            System.out.println("No se puede conectar al servidor");
            return false;
        }
        return true;
     }
    
    public void connectRep(String ruta, HashMap m, boolean sw)throws SQLException, JRException{
        connect();
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
    
    
  public void close() throws SQLException{
        dbCon.close();
       }

   public ResultSet execSQL(String sql) throws SQLException{
        Statement s = dbCon.createStatement();
        ResultSet r = s.executeQuery(sql);
        return (r == null) ? null : r;    
  }


  public int updateSQL(String sql) throws SQLException{
        Statement s = dbCon.createStatement();
        int r = s.executeUpdate(sql);
        return (r == 0) ? 0 : r;
  }



}