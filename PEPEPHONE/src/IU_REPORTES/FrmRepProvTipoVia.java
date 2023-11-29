package IU_REPORTES;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class FrmRepProvTipoVia extends javax.swing.JInternalFrame {

    /** Creates new form FrmRepClienteRang */
    public FrmRepProvTipoVia() {
        initComponents();
        llenarCmb();
    }
    private void llenarCmb(){
        this.cmbTipoVía.addItem("");
        this.cmbTipoVía.addItem("Costo Bajo");
        this.cmbTipoVía.addItem("Costo Alto");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbTipoVía = new javax.swing.JComboBox<>();
        btnReportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REPORTE DE PROVEEDOR POR TIPO DE VÍA");

        jLabel3.setText("Tipo de Vía");

        btnReportar.setText("Reportar");
        btnReportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addComponent(cmbTipoVía, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnReportar)
                .addGap(201, 201, 201))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTipoVía, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportar))
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
        if(!this.cmbTipoVía.getSelectedItem().equals("")){
            HashMap map =  new HashMap();
            map.put("TipoVía", this.cmbTipoVía.getSelectedItem().toString());

            try{
                String r = "src/REPORTES_PARAMETROS/RepProvParam.jasper"; //COLOCAR RUTA DE REPORTE
                DbBean db = new DbBean();
                db.connectRep(r, map, true);
            }catch(SQLException e){
                e.printStackTrace();
            }catch(JRException ex){
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Elija un Tipo de Vía");
        }
        
    }//GEN-LAST:event_btnReportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportar;
    private javax.swing.JComboBox<String> cmbTipoVía;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
