package IU_REPORTES;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class FrmRepCatProd extends javax.swing.JInternalFrame {

    /** Creates new form FrmRepClienteRang */
    public FrmRepCatProd() {
        initComponents();
        llenarCmb();
    }
    private void llenarCmb(){
        this.cmbSubCategoria.addItem("");
        this.cmbSubCategoria.addItem("Costo Bajo");
        this.cmbSubCategoria.addItem("Costo Alto");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSubCategoria = new javax.swing.JComboBox<>();
        btnReportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REPORTE DE CATEGORIA PRODUCTO POR SUBCATEGORIA");

        jLabel3.setText("SubCategoría");

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
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)
                        .addComponent(cmbSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnReportar)
                        .addGap(201, 201, 201))
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
                    .addComponent(cmbSubCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportar))
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarActionPerformed
        if(!this.cmbSubCategoria.getSelectedItem().equals("")){
            HashMap map =  new HashMap();
            if(this.cmbSubCategoria.getSelectedItem().equals("Costo Bajo")){
                map.put("Subcategoria", 0);
            }else{
                map.put("Subcategoria", 1);
            }

            try{
                String r = "src/REPORTES_PARAMETROS/Param_Producto_Categoria.jasper"; //COLOCAR RUTA DE REPORTE
                DbBean db = new DbBean();
                db.connectRep(r, map, true);
            }catch(SQLException e){
                e.printStackTrace();
            }catch(JRException ex){
                ex.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Elija una Subcategoria");
        }
        
    }//GEN-LAST:event_btnReportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReportar;
    private javax.swing.JComboBox<String> cmbSubCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
