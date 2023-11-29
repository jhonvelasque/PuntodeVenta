package IU_PROCESOS;

import BEAN_MANTENIMIENTOS.Producto;
import DAO_MANTENIMIENTOS.ProductoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelecProducto extends javax.swing.JDialog {
    Producto prod;
    ProductoDAO prodDao;
    DefaultTableModel dtm;
    public SelecProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prod = new Producto();
        prodDao = new ProductoDAO();
        dtm = (DefaultTableModel)this.tblProducto.getModel();
        llenaTblProductos(false, "", "");
        llenaCmbBuscar();
    }
    
    private void llenaCmbBuscar(){
        this.cmbBuscar.addItem("ID Producto");
        this.cmbBuscar.addItem("ID Categoria");
        this.cmbBuscar.addItem("Marca");
        this.cmbBuscar.addItem("Nombre");
        this.cmbBuscar.addItem("Costo Unit.");
        this.cmbBuscar.addItem("Precio Venta");
        this.cmbBuscar.addItem("Fecha Ingreso");
        this.cmbBuscar.addItem("Estado");
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
    
    public Producto devuelveProducto(){
        return prod;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 109, 119));

        jPanel2.setBackground(new java.awt.Color(0, 52, 89));

        jLabel2.setBackground(new java.awt.Color(0, 109, 119));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECCIONE UN PRODUCTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "ID Categoría", "Marca", "Nombre", "Costo", "Precio", "Fecha Ingreso", "Estado"
            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel1.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        int FilaProd = this.tblProducto.getSelectedRow();
        prod.setIdProducto(Integer.parseInt(dtm.getValueAt(FilaProd, 0).toString()));
        prod.setIdCategoria(Integer.parseInt(dtm.getValueAt(FilaProd, 1).toString()));
        prod.setMarca(dtm.getValueAt(FilaProd, 2).toString());
        prod.setNombreProducto(dtm.getValueAt(FilaProd, 3).toString());
        prod.setCostoUnitario(Float.parseFloat(dtm.getValueAt(FilaProd, 4).toString()));
        prod.setPrecioVenta(Float.parseFloat(dtm.getValueAt(FilaProd, 5).toString()));
        prod.setFechaIngreso(dtm.getValueAt(FilaProd, 6).toString());
        prod.setEstado(Integer.parseInt(dtm.getValueAt(FilaProd, 7).toString()));
        this.dispose();
    }//GEN-LAST:event_tblProductoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
