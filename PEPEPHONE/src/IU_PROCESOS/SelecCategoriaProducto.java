package IU_PROCESOS;

import BEAN_MANTENIMIENTOS.Categoria_producto;
import DAO_MANTENIMIENTOS.Categoria_ProductoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelecCategoriaProducto extends javax.swing.JDialog {
    Categoria_ProductoDAO catProdDao;
    DefaultTableModel dtm;
    int idCategoriaProd;
    public SelecCategoriaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        catProdDao = new Categoria_ProductoDAO();
        dtm = (DefaultTableModel)this.tblCatProd.getModel();
        
        llenaTblCatProductos(false, "", "");
    }
    private void llenaCmbBuscar(){
        this.cmbBuscar.addItem("ID Categoria");
        this.cmbBuscar.addItem("Descripcion");
        this.cmbBuscar.addItem("Subcategoría");
        this.cmbBuscar.addItem("Garantía");
        this.cmbBuscar.addItem("Dimensión");
        this.cmbBuscar.addItem("Observación");
    }
    private void llenaTblCatProductos(boolean sw, String cad, String camp){
        Vector<Categoria_producto> listaProdCat;
        listaProdCat = catProdDao.listaCatProductos(sw, cad, camp);
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
    
    public int devuelveIdCategoriaProducto(){
        return idCategoriaProd;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCatProd = new javax.swing.JTable();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECCIONE UNA CATEGORÍA DE PRODUCTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        tblCatProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción", "Subcategoría", "Garantia", "Dimension", "Observación"
            }
        ));
        tblCatProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCatProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCatProd);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
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

    private void tblCatProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCatProdMouseClicked
        int FilaProd = this.tblCatProd.getSelectedRow();
        idCategoriaProd = Integer.parseInt(dtm.getValueAt(FilaProd, 0).toString());
        this.dispose();
    }//GEN-LAST:event_tblCatProdMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCatProd;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
