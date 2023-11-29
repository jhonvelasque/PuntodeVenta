package IU_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.CatCliente;
import BEAN_MANTENIMIENTOS.Cliente;
import DAO_MANTENIMIENTOS.ClienteDAO;
import IU_PROCESOS.SelecCategoriaCliente;
import UTIL.Util;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmCliente extends javax.swing.JInternalFrame {

    private int idCli;
    ClienteDAO cDao;
    DefaultTableModel dtm;
    Util util;
    
    public FrmCliente() {
        initComponents();
        cDao = new ClienteDAO(); 
        util = new Util();
        
        dtm = (DefaultTableModel)this.tblCliente.getModel(); 
        llenaTblCliente(false, "IdCliente" , "");
        limpiar();
    }

    private void llenaTblCliente(boolean sw, String cad1, String cad2) {
        Vector<Cliente> listaC;
        listaC = cDao.listClientes(sw, cad1, cad2);
        dtm.setRowCount(0); 
        for(int i=0;i<listaC.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaC.get(i).getIdCliente());
            vec.addElement(listaC.get(i).getIdCategoria());
            vec.addElement(listaC.get(i).getNombCliente());
            vec.addElement(listaC.get(i).getApellCliente());
            vec.addElement(listaC.get(i).getDocCliente());
            vec.addElement(listaC.get(i).getTelefono());
            vec.addElement(listaC.get(i).getCorreo());
            dtm.addRow(vec);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIdCategoria = new javax.swing.JTextField();
        btnAgregaCategoriaC = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNroDoc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cmbFiltro = new javax.swing.JComboBox<>();
        btnAgregarCliente = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnLimpiarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 52, 89));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CLIENTE");

        jPanel4.setBackground(new java.awt.Color(0, 109, 119));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(0, 109, 119));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Cliente:");

        txtIdCliente.setEditable(false);
        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 109, 119));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Categoría:");

        txtIdCategoria.setEditable(false);

        btnAgregaCategoriaC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnAgregaCategoriaC.setText("Buscar");
        btnAgregaCategoriaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaCategoriaCActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 109, 119));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombres:");

        jLabel4.setBackground(new java.awt.Color(0, 109, 119));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellidos:");

        txtNroDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroDocActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 109, 119));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nro Doc:");

        jLabel7.setBackground(new java.awt.Color(0, 109, 119));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Correo:");

        jLabel6.setBackground(new java.awt.Color(0, 109, 119));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teléfono:");

        jPanel1.setBackground(new java.awt.Color(131, 197, 179));

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cliente", "Id Categoría", "Nombres", "Apellidos", "Nro Doc", "Telefono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Buscar:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IdCliente", "NombCliente", "ApellCliente", "DocCliente" }));

        btnAgregarCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/agregar-contacto.png"))); // NOI18N
        btnAgregarCliente.setText("Agregar");
        btnAgregarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
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

        btnLimpiarCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/limpiar (1).png"))); // NOI18N
        btnLimpiarCliente.setText("Limpiar");
        btnLimpiarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnAgregarCliente)
                        .addGap(57, 57, 57)
                        .addComponent(btnLimpiarCliente)
                        .addGap(66, 66, 66)
                        .addComponent(btnsalir)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiarCliente)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarCliente))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtApellidos)
                                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel7)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregaCategoriaC)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregaCategoriaC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtNroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().equals("")){
            llenaTblCliente(false, "IdCliente", "");
        }else{
            llenaTblCliente(true, this.cmbFiltro.getSelectedItem().toString(), this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnLimpiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarClienteActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarClienteActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        if(validar()){
            Cliente c = new Cliente();
            c.setIdCliente(Integer.parseInt(this.txtIdCliente.getText()));
            c.setIdCategoria(Integer.parseInt(this.txtIdCategoria.getText()));
            c.setNombCliente(this.txtNombres.getText());
            c.setApellCliente(this.txtApellidos.getText());
            c.setDocCliente(Integer.parseInt(this.txtNroDoc.getText()));
            c.setTelefono(Integer.parseInt(this.txtTelefono.getText()));
            c.setCorreo(this.txtCorreo.getText());
            
            
            if(this.btnAgregarCliente.getText().equals("Agregar")){
                cDao.insertaCliente(c);
            }else{
                cDao.actualizaCliente(c);
            }
            limpiar();
        }
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        int fc = this.tblCliente.getSelectedRow();
        this.txtIdCliente.setText(String.valueOf(dtm.getValueAt(fc, 0)));
        this.txtIdCategoria.setText(String.valueOf(dtm.getValueAt(fc, 1)));
        this.txtNombres.setText(String.valueOf(dtm.getValueAt(fc, 2)));
        this.txtApellidos.setText(String.valueOf(dtm.getValueAt(fc, 3)));
        this.txtNroDoc.setText(String.valueOf(dtm.getValueAt(fc, 4)));
        this.txtTelefono.setText(String.valueOf(dtm.getValueAt(fc, 5)));
        this.txtCorreo.setText(String.valueOf(dtm.getValueAt(fc, 6)));
        
        this.btnAgregarCliente.setText("Actualizar");
    }//GEN-LAST:event_tblClienteMouseClicked

    private void btnAgregaCategoriaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaCategoriaCActionPerformed
        CatCliente catClie;
        SelecCategoriaCliente dialog = new SelecCategoriaCliente(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        catClie = dialog.devuelveCatCliente();
        this.txtIdCategoria.setText(String.valueOf(catClie.getIdCategoriaCliente()));
    }//GEN-LAST:event_btnAgregaCategoriaCActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtNroDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroDocActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void limpiar(){
        this.txtIdCliente.setText(String.valueOf(util.idNext("Cliente", "IdCliente")));
        this.txtIdCategoria.setText("");
        this.txtNombres.setText("");
        this.txtApellidos.setText("");
        this.txtNroDoc.setText("");
        this.txtTelefono.setText("");
        this.txtCorreo.setText("");
        this.txtBuscar.setText("");
        this.btnAgregarCliente.setText("Agregar");
        llenaTblCliente(false, "IdCliente", "");
    }
    private boolean validar(){
        String cad = "";
        if(this.txtIdCategoria.getText().equals("")){
            cad += "Inserte Categoría del cliente";
        }
        if(this.txtNombres.getText().equals("")){
            cad += "\nInserte nombres del cliente";
        }
        if(this.txtApellidos.getText().equals("")){
            cad += "\nInserte apellidos del cliente";
        }
        if(this.txtNroDoc.getText().equals("")){
            cad += "\nInserte Nro documento del cliente";
        }
        if(this.txtTelefono.getText().equals("")){
            cad += "\nInserte telefono del cliente";
        }
        if(this.txtCorreo.getText().equals("")){
            cad += "\nInserte correo del cliente";
        }
        
        if(cad.equals("")){
            return true; 
        }else{
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregaCategoriaC;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnLimpiarCliente;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNroDoc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
