package IU_PROCESOS;

import BEAN_PROCESOS.Almacen;
import DAO_PROCESOS.AlmacenDAO;
import UTIL.Util;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmAlmacen extends javax.swing.JInternalFrame {

    private int idAlm;
    AlmacenDAO cDao;
    DefaultTableModel dtm;
    Util util;
    
    public FrmAlmacen() {
        initComponents();
        cDao = new AlmacenDAO(); 
        util = new Util();
        
        dtm = (DefaultTableModel)this.tblAlmacen.getModel(); 
        llenaTblAlmacen(false, "IdAlmacen" , "");
        limpiar();
    }

    private void llenaTblAlmacen(boolean sw, String cad1, String cad2) {
        Vector<Almacen> listaC;
        listaC = cDao.listAlmacen(sw, cad1,cad2);
        dtm.setRowCount(0); 
        for(int i=0;i<listaC.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaC.get(i).getIdAlmacen());
            vec.addElement(listaC.get(i).getDescripcion());
            vec.addElement(listaC.get(i).getCiudad());
            vec.addElement(listaC.get(i).getDistrito());
            vec.addElement(listaC.get(i).getDireccion());
            vec.addElement(listaC.get(i).getCapacidad());

            dtm.addRow(vec);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarAlmacen = new javax.swing.JButton();
        btnLimpiarAlmacen = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlmacen = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cmbFiltro = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDistrito = new javax.swing.JTextField();
        txtIdAlmacen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(0, 109, 119));

        jPanel1.setBackground(new java.awt.Color(131, 197, 179));

        btnAgregarAlmacen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/agregar-contacto.png"))); // NOI18N
        btnAgregarAlmacen.setText("Agregar");
        btnAgregarAlmacen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlmacenActionPerformed(evt);
            }
        });

        btnLimpiarAlmacen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/limpiar (1).png"))); // NOI18N
        btnLimpiarAlmacen.setText("Limpiar");
        btnLimpiarAlmacen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAlmacenActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/icons8-cerrar-sesión-48.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tblAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Almacen", "Descripcion", "Ciudad", "Distrito", "Direccion", "Capacidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlmacenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlmacen);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel8.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IdAlmacen", "Descripcion", "Ciudad", "Distrito", "Capacidad" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnAgregarAlmacen)
                        .addGap(52, 52, 52)
                        .addComponent(btnLimpiarAlmacen)
                        .addGap(64, 64, 64)
                        .addComponent(btnsalir)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarAlmacen)
                    .addComponent(btnLimpiarAlmacen)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Capacidad:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dirección:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Distrito:");

        txtIdAlmacen.setEditable(false);
        txtIdAlmacen.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Id Almacen:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descripcion:");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ciudad:");

        jPanel3.setBackground(new java.awt.Color(0, 52, 89));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ALMACEN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txtCiudad)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDistrito)
                    .addComponent(txtDescripcion)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(623, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().equals("")){
            llenaTblAlmacen(false, "IdAlmacen", "");
        }else{
            llenaTblAlmacen(true, this.cmbFiltro.getSelectedItem().toString(), this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnLimpiarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAlmacenActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarAlmacenActionPerformed

    private void btnAgregarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlmacenActionPerformed
        if(validar()){
            Almacen c = new Almacen();
            c.setIdAlmacen(Integer.parseInt(this.txtIdAlmacen.getText()));
            c.setDescripcion(this.txtDescripcion.getText());
            c.setCiudad(this.txtCiudad.getText());
            c.setDistrito(this.txtDistrito.getText());
            c.setDireccion(this.txtDireccion.getText());
            c.setCapacidad(Integer.parseInt(this.txtCapacidad.getText()));

            if(this.btnAgregarAlmacen.getText().equals("Agregar")){
                cDao.insertaAlmacen(c);
            }else{
                cDao.actualizaAlmacen(c);
            }
            limpiar();
        }
    }//GEN-LAST:event_btnAgregarAlmacenActionPerformed

    private void tblAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlmacenMouseClicked
        int fc = this.tblAlmacen.getSelectedRow();
        this.txtIdAlmacen.setText(String.valueOf(dtm.getValueAt(fc, 0)));
        this.txtDescripcion.setText(String.valueOf(dtm.getValueAt(fc, 1)));
        this.txtCiudad.setText(String.valueOf(dtm.getValueAt(fc, 2)));
        this.txtDistrito.setText(String.valueOf(dtm.getValueAt(fc, 3)));
        this.txtDireccion.setText(String.valueOf(dtm.getValueAt(fc, 4)));
        this.txtCapacidad.setText(String.valueOf(dtm.getValueAt(fc, 5)));

        
        this.btnAgregarAlmacen.setText("Actualizar");
    }//GEN-LAST:event_tblAlmacenMouseClicked

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void limpiar(){
        this.txtIdAlmacen.setText(String.valueOf(util.idNext("Almacen", "IdAlmacen")));
        this.txtDescripcion.setText("");
        this.txtCiudad.setText("");
        this.txtDistrito.setText("");
        this.txtDireccion.setText("");
        this.txtCapacidad.setText("");
        this.txtBuscar.setText("");
        this.btnAgregarAlmacen.setText("Agregar");
        llenaTblAlmacen(false, "IdAlmacen", "");
    }
    private boolean validar(){
        String cad = "";

        if(this.txtDescripcion.getText().equals("")){
            cad += "\nInserte descripcion";
        }
        if(this.txtCiudad.getText().equals("")){
            cad += "\nInserte ciudad";
        }
        if(this.txtDistrito.getText().equals("")){
            cad += "\nInserte distrito";
        }
        if(this.txtDireccion.getText().equals("")){
            cad += "\nInserte direccion";
        }
        if(this.txtCapacidad.getText().equals("")){
            cad += "\nInserte capacidad";
        }
        
        if(cad.equals("")){
            return true; 
        }else{
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAlmacen;
    private javax.swing.JButton btnLimpiarAlmacen;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlmacen;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtIdAlmacen;
    // End of variables declaration//GEN-END:variables
}
