package UI;

import BEAN.Producto;
import DAO.ProductoDAO;
import UTIL.Util;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmProducto extends javax.swing.JFrame {
    ProductoDAO prodDao;
    DefaultTableModel dtm;
    Util util;
    private int idProd;

    public FrmProducto() {
        prodDao = new ProductoDAO();
        util = new Util();
        initComponents();
        dtm = (DefaultTableModel)this.TblProductos.getModel();
        llenaTblProductos(false, "");
    }
    
    private void llenaTblProductos(boolean sw, String cad){
        Vector<Producto> listaProd;
        listaProd = prodDao.listaProductos(sw, cad);
        
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        txtIdCategoria = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtFechaIngreso = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblProductos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("IdProducto");

        jLabel2.setText("IdCategoria");

        jLabel3.setText("Nombre");

        jLabel4.setText("Costo");

        jLabel5.setText("PrecioVenta");

        jLabel6.setText("FechaIngreso");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "No Activo" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("MANTENIMIENTO PRODUCTO");

        jLabel8.setText("Estado");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel9.setText("Buscar");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 20, 38, 16);

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
        txtBuscar.setBounds(80, 20, 470, 22);

        TblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdProducto", "IdCategoria", "Marca", "Nombre", "Costo", "Precio", "FechaIngreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        jScrollPane1.setBounds(10, 50, 620, 190);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(540, 260, 79, 25);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel10.setText("Marca");

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdProducto)
                                    .addComponent(txtIdCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtMarca)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(57, 57, 57)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(34, 34, 34)
                                    .addComponent(txtPrecioVenta))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(70, 70, 70)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btnAgregar)
                        .addGap(130, 130, 130)
                        .addComponent(btnLimpiar)
                        .addGap(149, 149, 149)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>                        

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {                                      
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblProductos(false, "");
        }else{
            llenaTblProductos(true, this.txtBuscar.getText());
        }
    }                                     

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(valida() == true){
            Producto p;
            p = new Producto();
            p.setIdCategoria(Integer.parseInt(this.txtIdCategoria.getText()));
            p.setMarca(this.txtMarca.getText());
            p.setNombreProducto(this.txtNombre.getText());
            p.setCostoUnitario(Integer.parseInt(this.txtCosto.getText()));
            p.setPrecioVenta(Double.parseDouble(this.txtPrecioVenta.getText()));
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
                p.setIdProducto(idProd);
                prodDao.actualizaProducto(p);
            }
            llenaTblProductos(false, "");
            limpia();
            JOptionPane.showMessageDialog(this, "Se ha concretado satisfactoriamente el registro");
        }
    }                                          

    private void TblProductosMouseClicked(java.awt.event.MouseEvent evt) {                                          
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
        this.btnEliminar.setEnabled(true);
    }                                         

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose();
    }                                        

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
         int idx = 0;
        boolean sw = false;
        if(this.TblProductos.getSelectedRow() >= 0){
            idx = this.TblProductos.getSelectedRow();
            Producto prod = new Producto();
            prod.setIdProducto(Integer.parseInt(this.dtm.getValueAt(idx, 0).toString()));
            sw = this.prodDao.eliminaProducto(prod);
        }
        if(sw == true){
            JOptionPane.showMessageDialog(this, "El registro se eliminò correctamente ");
        }else{
            JOptionPane.showMessageDialog(this, "No es posible eliminar el registro por existir dependencias");
        }
        this.llenaTblProductos(false, "");
        this.btnEliminar.setEnabled(false);
        this.limpia();
    }                                           

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.limpia();
    }                                          

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

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
        this.txtIdProducto.setText("");
        this.txtIdCategoria.setText("");
        this.txtMarca.setText("");
        this.txtNombre.setText("");
        this.txtCosto.setText("");
        this.txtPrecioVenta.setText("");
        this.txtFechaIngreso.setText("");
        this.txtBuscar.setText("");
        this.cmbEstado.setSelectedItem("");
        this.btnAgregar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTable TblProductos;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration                   
}
