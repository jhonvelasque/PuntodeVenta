package IU_REPORTES;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;

public class FrmRepClienteRang extends javax.swing.JInternalFrame {

    public FrmRepClienteRang() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnReportarC = new javax.swing.JButton();
        txtDesde = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REPORTE DE CLIENTES POR RANGO DE CUOTAS");

        jLabel2.setText("Tipo de Correo");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReportarC))
                    .addComponent(jLabel1))
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportarC))
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarCActionPerformed
        String d; //desde hasta
        d = this.txtDesde.getText();
        
        HashMap map =  new HashMap();
        map.put("parCorreo", d);

        try{
            String r = "src/REPORTES_PARAMETROS/RepClienteParam.jasper"; //COLOCAR RUTA DE REPORTE
            DbBean db = new DbBean();
            db.connectRep(r, map, true);
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(JRException ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btnReportarCActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportarC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtDesde;
    // End of variables declaration//GEN-END:variables

}
