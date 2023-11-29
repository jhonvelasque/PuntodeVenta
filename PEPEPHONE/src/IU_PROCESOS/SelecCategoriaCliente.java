package IU_PROCESOS;

import BEAN_MANTENIMIENTOS.CatCliente;
import DAO_MANTENIMIENTOS.CatClienteDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelecCategoriaCliente extends javax.swing.JDialog {
    CatCliente catClie;
    CatClienteDAO catClieDao;
    DefaultTableModel dtm;
    public SelecCategoriaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        catClie = new CatCliente();
        catClieDao = new CatClienteDAO();
        dtm = (DefaultTableModel)this.tblCategoriaCliente.getModel();
        llenaCmbBuscar();
        llenarTablaCatCliente(false, "", "");
    }
    
    private void llenaCmbBuscar(){
        this.cmbBuscar.addItem("ID Categoria Cliente");
        this.cmbBuscar.addItem("Segmento Cliente");
        this.cmbBuscar.addItem("Frecuencia de Compra");
        this.cmbBuscar.addItem("Cuotas");
        this.cmbBuscar.addItem("Cantidad de Cuotas");
        this.cmbBuscar.addItem("Estado");
    }
    
    private void llenarTablaCatCliente(boolean sw, String cad, String camp){
        Vector<CatCliente> listCatClie = new Vector<CatCliente>();
        listCatClie = catClieDao.listaCatCliente(sw, cad, camp);
        dtm.setRowCount(0);
        for(int i=0; i<listCatClie.size(); i++){
            Vector vec = new Vector();
            vec.add(listCatClie.get(i).getIdCategoriaCliente());
            vec.add(listCatClie.get(i).getSegCliente());
            vec.add(listCatClie.get(i).getFrecCompra());
            vec.add(listCatClie.get(i).getCuotas());
            vec.add(listCatClie.get(i).getCantCuotas());
            vec.add(listCatClie.get(i).getEstado());
            dtm.addRow(vec);
        }
    }
    
    public CatCliente devuelveCatCliente(){
        return catClie;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoriaCliente = new javax.swing.JTable();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 109, 119));

        jPanel2.setBackground(new java.awt.Color(0, 52, 89));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECCIONE UNA CATEGORIA DE CLIENTE");

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

        tblCategoriaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Segmento", "Frecuencia de Compra", "Cuotas", "Cantidad de Cuotas", "Estado"
            }
        ));
        tblCategoriaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategoriaCliente);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)))
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().equals("")){
            llenarTablaCatCliente(false, "", "");
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
            llenarTablaCatCliente(true, this.txtBuscar.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblCategoriaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaClienteMouseClicked
        int FilaProv = this.tblCategoriaCliente.getSelectedRow();
        catClie.setIdCategoriaCliente(Integer.parseInt(dtm.getValueAt(FilaProv, 0).toString()));
        catClie.setSegCliente(dtm.getValueAt(FilaProv, 1).toString());
        catClie.setFrecCompra(dtm.getValueAt(FilaProv, 2).toString());
        catClie.setCuotas(dtm.getValueAt(FilaProv, 3).toString());
        catClie.setCantCuotas(dtm.getValueAt(FilaProv, 4).toString());
        catClie.setEstado(Integer.parseInt(dtm.getValueAt(FilaProv, 5).toString()));
        this.dispose();
    }//GEN-LAST:event_tblCategoriaClienteMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCategoriaCliente;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
