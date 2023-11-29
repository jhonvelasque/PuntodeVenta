
package IU_MANTENIMIENTOS;

import BEAN_MANTENIMIENTOS.CatCliente;
import DAO_MANTENIMIENTOS.CatClienteDAO;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import UTIL.Util;


public class FrmCatCliente extends javax.swing.JInternalFrame {
    CatClienteDAO CatClienteDao;
    DefaultTableModel dtm;
    Util util;
    int idCatCliente;
    public FrmCatCliente() {
        CatClienteDao = new CatClienteDAO();
        initComponents();
        util = new Util();
        dtm = (DefaultTableModel)this.tblCatCliente.getModel();

        llenaCmbEstado();
        llenaSegCliente();
        llenaFrecCompra();
        llenaCantCuotas();
        llenaCmbBuscar();
        llenaTblCatCliente(false, "", "");
        this.txtIdCategoriaCliente.setText(String.valueOf(util.idNext("CategoriaCliente", "IdCategoriaCliente")));
    }
    private void llenaCmbEstado(){
        this.cmbEstado.addItem("");
        this.cmbEstado.addItem("Activo");
        this.cmbEstado.addItem("No Activo");
    }
    private void llenaSegCliente(){
        this.cmbSegCliente.addItem("");
        this.cmbSegCliente.addItem("Joven");
        this.cmbSegCliente.addItem("Adulto");
        this.cmbSegCliente.addItem("Adulto Mayor");
    }
    
    private void llenaFrecCompra(){
        this.cmbFrecCompra.addItem("");
        this.cmbFrecCompra.addItem("Poco Frecuente");
        this.cmbFrecCompra.addItem("Frecuente");
        this.cmbFrecCompra.addItem("Muy Frecuente");
    }
    private void llenaCantCuotas(){
        this.cmbCantCuotas.addItem("");
        this.cmbCantCuotas.addItem("Sin cuotas");
        this.cmbCantCuotas.addItem("1 cuota");
        this.cmbCantCuotas.addItem("2 cuotas");
        this.cmbCantCuotas.addItem("3 cuotas");
        this.cmbCantCuotas.addItem("4 cuotas");
    }
    private void llenaCmbBuscar(){
        this.cmbBuscar.addItem("ID Categoria Cliente");
        this.cmbBuscar.addItem("Segmento Cliente");
        this.cmbBuscar.addItem("Frecuencia de Compra");
        this.cmbBuscar.addItem("Cuotas");
        this.cmbBuscar.addItem("Cantidad de Cuotas");
        this.cmbBuscar.addItem("Estado");
    }
    private void llenaTblCatCliente(boolean sw, String cad, String camp){
        Vector<CatCliente> listaCatCliente = CatClienteDao.listaCatCliente(sw, cad, camp);
        dtm.setRowCount(0); 
        for(int i=0;i<listaCatCliente.size();i++){
            Vector vec = new Vector();
            vec.addElement(listaCatCliente.get(i).getIdCategoriaCliente());
            vec.addElement(listaCatCliente.get(i).getSegCliente());
            vec.addElement(listaCatCliente.get(i).getFrecCompra());
            vec.addElement(listaCatCliente.get(i).getCuotas());
            vec.addElement(listaCatCliente.get(i).getCantCuotas());
            vec.addElement(listaCatCliente.get(i).getEstado());

            dtm.addRow(vec);
        }     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoCuotas = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdCategoriaCliente = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbSegCliente = new javax.swing.JComboBox<>();
        cmbFrecCompra = new javax.swing.JComboBox<>();
        cmbCantCuotas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        rbtSi = new javax.swing.JRadioButton();
        rbtNo = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCatCliente = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox<>();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 109, 119));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segmento de cliente:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Frecuencia del cliente:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cuotas:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad de cuotas:");

        txtIdCategoriaCliente.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Categoría de Cliente:");

        rbtSi.setBackground(new java.awt.Color(0, 109, 119));
        GrupoCuotas.add(rbtSi);
        rbtSi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtSi.setForeground(new java.awt.Color(255, 255, 255));
        rbtSi.setText("Sí");

        rbtNo.setBackground(new java.awt.Color(0, 109, 119));
        GrupoCuotas.add(rbtNo);
        rbtNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtNo.setForeground(new java.awt.Color(255, 255, 255));
        rbtNo.setText("No");

        jPanel1.setBackground(new java.awt.Color(131, 197, 179));

        tblCatCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Categoría ", "Segmento", "Frecuencia", "Cuotas", "Cantidad de cuotas", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCatCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCatClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCatCliente);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel10.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

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

        jPanel3.setBackground(new java.awt.Color(0, 52, 89));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CATEGORÍA DE CLIENTE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(rbtSi)
                        .addGap(18, 18, 18)
                        .addComponent(rbtNo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnAgregar)
                        .addGap(97, 97, 97)
                        .addComponent(btnLimpiar)
                        .addGap(85, 85, 85)
                        .addComponent(btnSalir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbSegCliente, 0, 213, Short.MAX_VALUE)
                                .addComponent(txtIdCategoriaCliente)
                                .addComponent(cmbFrecCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbCantCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdCategoriaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbSegCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbFrecCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbtSi)
                        .addComponent(rbtNo))
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbCantCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel8)
                .addContainerGap(483, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblCatCliente(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbBuscar.getSelectedItem().toString()){
                case "ID Categoria Cliente":    camp = "IdCategoriaCliente";   break;
                case "Segmento Cliente":    camp = "SegCliente";   break;
                case "Frecuencia de Compra":    camp = "FrecCompra";   break;
                case "Cuotas":    camp = "Cuotas";   break;
                case "Cantidad de Cuotas":    camp = "CantCuotas";   break;
                case "Estado":    camp = "Estado";   break;
            }
            llenaTblCatCliente(true, this.txtBuscar.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(valida() == true){
            CatCliente cat;
            cat = new CatCliente();
            cat.setSegCliente(this.cmbSegCliente.getSelectedItem().toString());
            cat.setFrecCompra(this.cmbFrecCompra.getSelectedItem().toString());
            if (this.rbtSi.isSelected()) {
                cat.setCuotas("Si");
            } else if (this.rbtNo.isSelected()) {
                cat.setCuotas("No");
            }
            cat.setCantCuotas(this.cmbCantCuotas.getSelectedItem().toString());
            if(this.cmbEstado.getSelectedItem().toString().equals("Activo")){
                cat.setEstado(1);
            }else{
                cat.setEstado(0);
            }
        if(this.btnAgregar.getText().equals("Agregar")){
                this.idCatCliente = util.idNext("CategoriaCliente", "IdCategoriaCliente");
                cat.setIdCategoriaCliente(idCatCliente);   
                CatClienteDao.insertaCategoría(cat);
            }else{
                cat.setIdCategoriaCliente(idCatCliente);
                CatClienteDao.actualizaCategoria(cat);
            }
        llenaTblCatCliente(false, "", "");
        limpia();
        JOptionPane.showMessageDialog(this, "Se ha registrado satisfactoriamente la Categoría");
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblCatClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCatClienteMouseClicked
        int i;
        i = this.tblCatCliente.getSelectedRow();
        this.txtIdCategoriaCliente.setText(dtm.getValueAt(i, 0).toString());
        this.idCatCliente = Integer.parseInt(dtm.getValueAt(i, 0).toString());
        
        this.cmbSegCliente.setSelectedItem(dtm.getValueAt(i, 1).toString());
        this.cmbFrecCompra.setSelectedItem(dtm.getValueAt(i, 2).toString());
        
        if (dtm.getValueAt(i, 3).toString().equals("Si")) {
        
        this.GrupoCuotas.setSelected(this.rbtSi.getModel(), true);
        } else {
        this.GrupoCuotas.setSelected(this.rbtNo.getModel(), true);
        }
        
        this.cmbCantCuotas.setSelectedItem(dtm.getValueAt(i, 4).toString());
        if(dtm.getValueAt(i, 5).toString().equals("1")){
            this.cmbEstado.setSelectedItem("Activo");
        }else{
            this.cmbEstado.setSelectedItem("No Activo");
        }
        
        this.btnAgregar.setText("Actualizar");
    }//GEN-LAST:event_tblCatClienteMouseClicked
    private void limpia(){
        this.txtBuscar.setText("");
        this.txtIdCategoriaCliente.setText(String.valueOf(util.idNext("CategoriaCliente", "IdCategoriaCliente")));
        this.cmbSegCliente.setSelectedItem("");
        this.cmbFrecCompra.setSelectedItem("");
        GrupoCuotas.clearSelection();
        this.cmbCantCuotas.setSelectedItem("");
        this.cmbEstado.setSelectedItem("");
        this.btnAgregar.setText("Agregar");
    }
    
    private boolean valida(){
        boolean sw = false;
        String cad = "";
        
        if(this.cmbSegCliente.getSelectedItem().toString().isEmpty()){
            cad += "\nDebe seleccionar la Segmentación del cliente ";
        }
        if(this.cmbFrecCompra.getSelectedItem().toString().isEmpty()){
            cad += "\nDebe registrar la Frecuencia de compra del cliente ";
        }
        if(this.cmbCantCuotas.getSelectedItem().toString().isEmpty()){
            cad += "\nDebe registrar la Frecuencia de compra del cliente ";
        }
        if(this.cmbEstado.getSelectedItem().toString().isEmpty()){
            cad = "Debe registrar el Estado";
        }
        if(cad.isEmpty()){
            sw = true;
        }else{
            sw = false;
            JOptionPane.showMessageDialog(this, cad);
        }
        return sw;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoCuotas;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbCantCuotas;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbFrecCompra;
    private javax.swing.JComboBox<String> cmbSegCliente;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtNo;
    private javax.swing.JRadioButton rbtSi;
    private javax.swing.JTable tblCatCliente;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdCategoriaCliente;
    // End of variables declaration//GEN-END:variables
}
