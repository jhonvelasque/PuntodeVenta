package IU_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.Categoria_producto;
import DAO_MANTENIMIENTOS.Categoria_ProductoDAO;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel;

public class FrmCategoria_producto extends javax.swing.JInternalFrame {
    private int idCatProd;
    Categoria_ProductoDAO prodCatDao;
    DefaultTableModel dtm;
    Util util; // objeto de la clase util que se conecta a la B
    public FrmCategoria_producto() {
        prodCatDao = new Categoria_ProductoDAO(); // instanciamos el objeto
        util = new Util(); // instanciamos el objeto
        initComponents(); // inicializamos los componentes
        dtm = (DefaultTableModel)this.tblCatProd.getModel(); // inicializamos el modelo de la tabla
        llenaTblCatProductos(false, "", ""); // llenamos la tabla de productos
        llenaCmbTipo(); // llenamos el combo de tipo de productos
        llenaCmbBuscar(); // llenamos el combo de buscar para filtrar la información
        this.txtIdCategoriaProducto.setText(String.valueOf(util.idNext("CategoriaProducto", "IdCategoria"))); // obtiene y muestra el Id automaticamente
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btmGrabar = new javax.swing.JButton();
        btmLimpiar = new javax.swing.JButton();
        btmLimpiar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCatProd = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDimension = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmdSubcategoria = new javax.swing.JComboBox<>();
        txtDescCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdCategoriaProducto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 109, 119));

        btmGrabar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btmGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/agregar-contacto.png"))); // NOI18N
        btmGrabar.setText("Grabar");
        btmGrabar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btmGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmGrabarActionPerformed(evt);
            }
        });

        btmLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btmLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/limpiar (1).png"))); // NOI18N
        btmLimpiar.setText("Limpiar");
        btmLimpiar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btmLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmLimpiarActionPerformed(evt);
            }
        });

        btmLimpiar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btmLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/icons8-cerrar-sesión-48.png"))); // NOI18N
        btmLimpiar1.setText("Salir");
        btmLimpiar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btmLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmLimpiar1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(131, 197, 179));

        tblCatProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblCatProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Categoría", "Descripción", "Subcategoría", "Garantia", "Dimensión", "Observación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCatProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCatProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCatProd);
        if (tblCatProd.getColumnModel().getColumnCount() > 0) {
            tblCatProd.getColumnModel().getColumn(0).setResizable(false);
            tblCatProd.getColumnModel().getColumn(1).setResizable(false);
            tblCatProd.getColumnModel().getColumn(2).setResizable(false);
            tblCatProd.getColumnModel().getColumn(3).setResizable(false);
            tblCatProd.getColumnModel().getColumn(4).setResizable(false);
            tblCatProd.getColumnModel().getColumn(5).setResizable(false);
        }

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel8.setText("Buscar :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206)
                        .addComponent(cmbBuscar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Observacion :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dimensión :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Garantia :");

        txtGarantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGarantiaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Subcategoria :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descripcion Categoria :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("IdCategoria :");

        txtIdCategoriaProducto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtIdCategoriaProducto.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(0, 52, 89));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MANTENIMIENTO PRODUCTO CATEGORIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btmGrabar)
                        .addGap(117, 117, 117)
                        .addComponent(btmLimpiar)
                        .addGap(107, 107, 107)
                        .addComponent(btmLimpiar1))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDescCategoria)
                                        .addComponent(cmdSubcategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(187, 187, 187))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18))))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 72, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmdSubcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDimension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btmGrabar)
                        .addComponent(btmLimpiar))
                    .addComponent(btmLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btmGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmGrabarActionPerformed
        // TODO add your handling code here:
        if(valida() == true){
            Categoria_producto cp;
            cp = new Categoria_producto();
            cp.setCategoria(this.txtDescCategoria.getText());
            //cp.setSubcategoria(Integer.parseInt(this.cmdSubcategoria.getSelectedItem().toString()));
            cp.setGarantia(this.txtGarantia.getText());
            cp.setDimension(this.txtDimension.getText());
            cp.setDescripcion(this.txtObservacion.getText());
          
            if(this.cmdSubcategoria.getSelectedItem().toString().equals("Costo Bajo")){
                cp.setSubcategoria(0);
            }else{
                cp.setSubcategoria(1);
            }
            if(this.btmGrabar.getText().equals("Grabar")){
                cp.setId_categoria(Integer.parseInt(this.txtIdCategoriaProducto.getText()));   
                prodCatDao.insertaCategoriaProducto(cp);
            }else{
                cp.setId_categoria(idCatProd);
                prodCatDao.actualizaCategoriaProducto(cp);
            }
            llenaTblCatProductos(false, "", "");
            limpia();
            JOptionPane.showMessageDialog(this, "Se ha concretado satisfactoriamente el registro");
        }
    }//GEN-LAST:event_btmGrabarActionPerformed
    private boolean valida(){
        boolean sw = false;
        String cad = "";
        if(this.txtDescCategoria.getText().isEmpty()){
            cad = "Debe registrar la Categoria";
        }
        if(this.txtDescCategoria.getText().isEmpty()){
            cad += "\nDebe registrar la descripcion ";
        }
        if(this.cmdSubcategoria.getSelectedItem().toString().isEmpty()){
            cad += "\nDebe seleccionar la subcategoria ";
        }
        if(this.txtGarantia.getText().isEmpty()){
            cad += "\nDebe registrar la garantia ";
        }
        if(this.txtDimension.getText().isEmpty()){
            cad += "\nDebe registrar la dimension ";
        }
        if(this.txtObservacion.getText().isEmpty()){
            cad += "\nDebe registrar la observación ";
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
        this.txtIdCategoriaProducto.setText(String.valueOf(util.idNext("CategoriaProducto", "IdCategoria")));
        this.txtDescCategoria.setText("");
        this.cmdSubcategoria.setSelectedItem("");
        this.txtGarantia.setText("");
        this.txtDimension.setText("");
        this.txtObservacion.setText("");
        this.txtBuscar.setText("");
        this.btmGrabar.setText("Grabar");
        //this.btnElimina.setEnabled(false);
    }
    
    private void llenaTblCatProductos(boolean sw, String cad, String camp){
        Vector<Categoria_producto> listaProdCat;
        listaProdCat = prodCatDao.listaCatProductos(sw, cad, camp);
        dtm.setRowCount(0); //Setea el tblProductos en 0 registros
        for(int i=0;i<listaProdCat.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaProdCat.get(i).getId_categoria());
            vec.addElement(listaProdCat.get(i).getCategoria());
            vec.addElement(listaProdCat.get(i).getSubcategoria());
            vec.addElement(listaProdCat.get(i).getGarantia());
            vec.addElement(listaProdCat.get(i).getDimension());
            vec.addElement(listaProdCat.get(i).getDescripcion());
            dtm.addRow(vec);
        }
    }
    private void llenaCmbTipo(){
        this.cmdSubcategoria.addItem("");
        this.cmdSubcategoria.addItem("Costo Bajo");
        this.cmdSubcategoria.addItem("Costo Alto");
    }
    private void llenaCmbBuscar(){
        this.cmbBuscar.addItem("ID Categoria");
        this.cmbBuscar.addItem("Descripcion");
        this.cmbBuscar.addItem("Subcategoría");
        this.cmbBuscar.addItem("Garantía");
        this.cmbBuscar.addItem("Dimensión");
        this.cmbBuscar.addItem("Observación");
    }
    
    private void btmLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimpiarActionPerformed
        this.limpia();        // TODO add your handling code here:
    }//GEN-LAST:event_btmLimpiarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblCatProductos(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbBuscar.getSelectedItem().toString()){
                case "ID Categoria":    camp = "IdCategoria";   break;
                case "Descripcion":    camp = "DescCategoria";   break;
                case "Subcategoría":    camp = "Subcategoria";   break;
                case "Garantía":    camp = "Marca";   break;
                case "Dimensión":    camp = "Modelo";   break;
                case "Observación":    camp = "Observacion";   break;
            }
            llenaTblCatProductos(true, this.txtBuscar.getText(), camp);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btmLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmLimpiar1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btmLimpiar1ActionPerformed

    private void tblCatProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCatProdMouseClicked
        // TODO add your handling code here:
        int i;
        i = this.tblCatProd.getSelectedRow();
        this.txtIdCategoriaProducto.setText(dtm.getValueAt(i, 0).toString());
        this.idCatProd = Integer.parseInt(dtm.getValueAt(i, 0).toString());
        this.txtDescCategoria.setText(dtm.getValueAt(i, 1).toString());
        this.cmdSubcategoria.setSelectedItem(dtm.getValueAt(i, 2).toString());
        this.txtGarantia.setText(dtm.getValueAt(i, 3).toString());
        this.txtDimension.setText(dtm.getValueAt(i, 4).toString());
        this.txtObservacion.setText(dtm.getValueAt(i, 5).toString());
        // esta sent
        if(dtm.getValueAt(i, 2).toString().equals("1")){
            this.cmdSubcategoria.setSelectedItem("Costo Bajo");
        }else{
            this.cmdSubcategoria.setSelectedItem("Costo Alto");
        }
        this.btmGrabar.setText("Actualizar");
    }//GEN-LAST:event_tblCatProdMouseClicked

    private void txtGarantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGarantiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGarantiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmGrabar;
    private javax.swing.JButton btmLimpiar;
    private javax.swing.JButton btmLimpiar1;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmdSubcategoria;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCatProd;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescCategoria;
    private javax.swing.JTextField txtDimension;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtIdCategoriaProducto;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
