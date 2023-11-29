package IU_REPORTES;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class FrmRepProdMin extends javax.swing.JInternalFrame {

    /** Creates new form FrmRepClienteRang */
    public FrmRepProdMin() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnReportarC = new javax.swing.JButton();
        txtProdMin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REPORTE DE PRODUCTOS POR PRECIO MINIMO");

        jLabel3.setText("Precio Minimo");

        btnReportarC.setText("Reportar");
        btnReportarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(42, 42, 42)
                        .addComponent(txtProdMin, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnReportarC)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(154, 154, 154))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProdMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportarC))
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarCActionPerformed
        if(!this.txtProdMin.getText().equals("")){
            HashMap map =  new HashMap();
            map.put("PrecMin", Integer.parseInt(this.txtProdMin.getText()));
            try{
                String r = "src/REPORTES_PARAMETROS/RepProdParam.jasper"; //COLOCAR RUTA DE REPORTE
                DbBean db = new DbBean();
                db.connectRep(r, map, true);

            }catch(SQLException e){
                e.printStackTrace();
            }catch(JRException ex){
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Escriba un precio minimo");
        }
        
    }//GEN-LAST:event_btnReportarCActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportarC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtProdMin;
    // End of variables declaration//GEN-END:variables

}
