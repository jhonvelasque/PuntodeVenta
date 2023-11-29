package IU_REPORTES;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class FrmRepCatClienteFiltro extends javax.swing.JInternalFrame {

    /** Creates new form FrmRepClienteRang */
    public FrmRepCatClienteFiltro() {
        initComponents();
        llenarCmbSegmento();
    }
    private void llenarCmbSegmento(){
        this.cmbSegmento.addItem("");
        this.cmbSegmento.addItem("Joven");
        this.cmbSegmento.addItem("Adulto");
        this.cmbSegmento.addItem("Adulto Mayor");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSegmento = new javax.swing.JComboBox<>();
        btnReportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REPORTE DE CATEGORIA CLIENTE POR SEGMENTO Y CANTIDAD DE CUOTAS ");

        jLabel3.setText("Segmento");

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
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(cmbSegmento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnReportar)
                        .addGap(169, 169, 169))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbSegmento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportar))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
        if(!(this.cmbSegmento.getSelectedItem().equals(""))){
            HashMap map =  new HashMap();
            map.put("Segmento", this.cmbSegmento.getSelectedItem().toString());
            
            try{
                String r = "src/REPORTES_PARAMETROS/repCatClientePar.jasper"; //COLOCAR RUTA DE REPORTE
                DbBean db = new DbBean();
                db.connectRep(r, map, true);
            }catch(SQLException e){
                e.printStackTrace();
            }catch(JRException ex){
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Elija los parametros");
        }
        
    }//GEN-LAST:event_btnReportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportar;
    private javax.swing.JComboBox<String> cmbSegmento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
