package IU_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.Producto;
import DAO_MANTENIMIENTOS.ProductoDAO;
import IU_PROCESOS.SelecCategoriaProducto;
import UTIL.Util;
import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class FrmProducto extends javax.swing.JInternalFrame {
    
    ProductoDAO prodDao;
    DefaultTableModel dtm;
    Util util;
    private int idProd;
    public FrmProducto() {
        prodDao = new ProductoDAO();
        util = new Util();
        initComponents();
        dtm = (DefaultTableModel)this.TblProductos.getModel();
        this.txtIdProducto.setText(String.valueOf(util.idNext("Producto", "IdProducto")));
        llenaTblProductos(false, "", "");
    }
    
    private void llenaTblProductos(boolean sw, String cad, String camp){
        Vector<Producto> listaProd;
        listaProd = prodDao.listaProductos(sw, cad, camp);
        dtm.setRowCount(0); //Setea el tblProductos en 0 registros
        for(int i=0;i<listaProd.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaProd.get(i).getIdProducto());
            vec.addElement(listaProd.get(i).getIdCategoria());
            vec.addElement(listaProd.get(i).getMarca());
            vec.addElement(listaProd.get(i).getNombreProducto());
            vec.addElement(listaProd.get(i).getCostoUnitario());
            vec.addElement(listaProd.get(i).getPrecioVenta());
            vec.addElement(listaProd.get(i).getFechaIngreso());
            vec.addElement(listaProd.get(i).getEstado());
            dtm.addRow(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        txtIdCategoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblProductos = new javax.swing.JTable();
        cmbBuscar = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscarCategoria = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MANTENIMIENTO PRODUCTO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(0, 52, 89));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 109, 119));

        jLabel1.setBackground(new java.awt.Color(0, 109, 119));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IdProducto");

        txtIdProducto.setEnabled(false);

        txtIdCategoria.setEnabled(false);

        jLabel2.setBackground(new java.awt.Color(0, 109, 119));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("IdCategoria");

        jLabel10.setBackground(new java.awt.Color(0, 109, 119));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Marca");

        jLabel3.setBackground(new java.awt.Color(0, 109, 119));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");

        jLabel4.setBackground(new java.awt.Color(0, 109, 119));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Costo");

        jLabel5.setBackground(new java.awt.Color(0, 109, 119));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PrecioVenta");

        jLabel6.setBackground(new java.awt.Color(0, 109, 119));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FechaIngreso");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "No Activo" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 109, 119));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Estado");

        jPanel1.setBackground(new java.awt.Color(131, 197, 179));
        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel9.setText("Buscar:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 20, 80, 32);

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
        jPanel1.add(txtBuscar);
        txtBuscar.setBounds(180, 20, 220, 28);

        TblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdProducto", "IdCategoria", "Marca", "Nombre", "Costo", "Precio", "FechaIngreso", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblProductos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 600, 190);

        jPanel1.add(cmbBuscar);
        cmbBuscar.setBounds(470, 20, 140, 30);

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/icons8-cerrar-sesión-48.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/limpiar (1).png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/agregar-contacto.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarCategoria.setText("Buscar");
        btnBuscarCategoria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 52, 89));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PRODUCTO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(57, 57, 57)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(67, 67, 67)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(108, 108, 108))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnBuscarCategoria)
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(btnAgregar)
                                .addGap(72, 72, 72)
                                .addComponent(btnLimpiar)
                                .addGap(95, 95, 95)
                                .addComponent(btnSalir)))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblProductos(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbBuscar.getSelectedItem().toString()){
                case "ID Producto":    camp = "IdProducto";   break;
                case "ID Categoria":    camp = "IdCategoria";   break;
                case "Marca":    camp = "Marca";   break;
                case "Nombre":    camp = "NombreProducto";   break;
                case "Costo Unit.":    camp = "CostoUnitario";   break;
                case "Precio Venta":    camp = "PrecioVenta";   break;
                case "Fecha Ingreso":    camp = "FechaIngreso";   break;
                case "Estado":    camp = "Estado";   break;
            }
            llenaTblProductos(true, this.txtBuscar.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void TblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblProductosMouseClicked
        int i;
        i = this.TblProductos.getSelectedRow();
        this.txtIdProducto.setText(dtm.getValueAt(i, 0).toString());
        this.idProd = Integer.parseInt(dtm.getValueAt(i, 0).toString());
        this.txtIdCategoria.setText(dtm.getValueAt(i, 1).toString());
        this.txtMarca.setText(dtm.getValueAt(i, 2).toString());
        this.txtNombre.setText(dtm.getValueAt(i, 3).toString());
        this.txtCosto.setText(dtm.getValueAt(i, 4).toString());
        this.txtPrecioVenta.setText(dtm.getValueAt(i, 5).toString());
        this.txtFechaIngreso.setText(dtm.getValueAt(i, 6).toString());
        if(dtm.getValueAt(i, 7).toString().equals("1")){
            this.cmbEstado.setSelectedItem("Activo");
        }else{
            this.cmbEstado.setSelectedItem("No Activo");
        }
        this.btnAgregar.setText("Actualizar");
    }//GEN-LAST:event_TblProductosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(valida() == true){
            Producto p;
            p = new Producto();

            p.setIdCategoria(Integer.parseInt(this.txtIdCategoria.getText()));
            p.setMarca(this.txtMarca.getText());
            p.setNombreProducto(this.txtNombre.getText());
            p.setCostoUnitario(Float.parseFloat(this.txtCosto.getText()));
            p.setPrecioVenta(Float.parseFloat(this.txtPrecioVenta.getText()));
            p.setFechaIngreso(this.txtFechaIngreso.getText());
            if(this.cmbEstado.getSelectedItem().toString().equals("Activo")){
                p.setEstado(1);
            }else{
                p.setEstado(0);
            }
            if(this.btnAgregar.getText().equals("Agregar")){
                this.idProd = util.idNext("Producto", "IdProducto");
                p.setIdProducto(idProd);
                prodDao.insertaProducto(p);
            }else{
                System.out.println(idProd);
                p.setIdProducto(idProd);

                prodDao.actualizaProducto(p);
            }
            llenaTblProductos(false, "", "");
            limpia();
            JOptionPane.showMessageDialog(this, "Se ha concretado satisfactoriamente el registro");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed
        int IdCatProd;
        SelecCategoriaProducto dialog = new SelecCategoriaProducto(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        IdCatProd = dialog.devuelveIdCategoriaProducto();
        this.txtIdCategoria.setText(String.valueOf(IdCatProd));
    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private boolean valida(){
        boolean sw = false;
        String cad = "";
        if(this.txtIdCategoria.getText().isEmpty()){
            cad = "Debe registrar la categoria";
        }
        if(this.txtMarca.getText().isEmpty()){
            cad = "\nDebe registrar la marca del producto";
        }
        if(this.txtNombre.getText().isEmpty()){
            cad = "\nDebe registrar el nombre del producto";
        }
        if(this.txtCosto.getText().isEmpty()){
            cad = "\nDebe registrar el costo del producto";
        }
        if(this.txtPrecioVenta.getText().isEmpty()){
            cad = "\nDebe registrar el precio de venta del producto";
        }
        if(this.txtFechaIngreso.getText().isEmpty()){
            cad = "\nDebe registrar la fecha de ingreso del producto";
        }
        if(cad.isEmpty()){
            sw = true;
        }else{
            sw = false;
            JOptionPane.showMessageDialog(this, cad);
        }
        return sw;
    }
    private void limpia(){
        this.txtIdProducto.setText(String.valueOf(util.idNext("Producto", "IdProducto")));
        this.txtIdCategoria.setText("");
        this.txtMarca.setText("");
        this.txtNombre.setText("");
        this.txtCosto.setText("");
        this.txtPrecioVenta.setText("");
        this.txtFechaIngreso.setText("");
        this.txtBuscar.setText("");
        this.cmbEstado.setSelectedItem("");
        this.btnAgregar.setText("Agregar");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblProductos;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
