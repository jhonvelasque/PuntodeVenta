package IU_PROCESOS;

import BEAN_PROCESOS.CategoriaServicio;
import DAO_PROCESOS.CategoriaServicioDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelecCategoriaServicio extends javax.swing.JDialog {
    CategoriaServicio catServ;
    CategoriaServicioDAO catServDao;
    DefaultTableModel dtm;
    public SelecCategoriaServicio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        catServ = new CategoriaServicio();
        catServDao = new CategoriaServicioDAO();
        dtm = (DefaultTableModel)this.tblCategoriaServicio.getModel();
        llenaCmbBuscar();
        llenarTablaCategoriaServicio(false, "", "");
    }
    
    private void llenaCmbBuscar(){
        this.cmbBuscar.addItem("ID Categoria Serv.");
        this.cmbBuscar.addItem("Nombre");
        this.cmbBuscar.addItem("Costo Unit.");
    }
    
    private void llenarTablaCategoriaServicio(boolean sw, String cad, String camp){
        Vector<CategoriaServicio> listCatServ = new Vector<CategoriaServicio>();
        listCatServ = catServDao.listaCategoriaServicio(sw, cad, camp);
        dtm.setRowCount(0);
        for(int i=0; i<listCatServ.size(); i++){
            Vector vec = new Vector();
            vec.add(listCatServ.get(i).getIdCategoriaServicio());
            vec.add(listCatServ.get(i).getNombreServicio());
            vec.add(listCatServ.get(i).getCostoUnitario());
            dtm.addRow(vec);
        }
    }
    
    public CategoriaServicio devuelveCategoriaServicio(){
        return catServ;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoriaServicio = new javax.swing.JTable();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 109, 119));

        jPanel2.setBackground(new java.awt.Color(0, 52, 89));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECCIONE UN PROVEEDOR");

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

        tblCategoriaServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "CostoUnitario"
            }
        ));
        tblCategoriaServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaServicioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategoriaServicio);

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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
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
                .addGap(0, 38, Short.MAX_VALUE))
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
        if(this.txtBuscar.getText().equals("")){
            llenarTablaCategoriaServicio(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbBuscar.getSelectedItem().toString()){
                case "ID Categoria Serv.":    camp = "IdCategoriaServicio";   break;
                case "Nombre":    camp = "NombreServicio";   break;
                case "Costo Unit.":    camp = "CostoUnitario";   break;
            }
            llenarTablaCategoriaServicio(true, this.txtBuscar.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblCategoriaServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaServicioMouseClicked
        int FilaProv = this.tblCategoriaServicio.getSelectedRow();
        catServ.setIdCategoriaServicio(Integer.parseInt(dtm.getValueAt(FilaProv, 0).toString()));
        catServ.setNombreServicio(dtm.getValueAt(FilaProv, 1).toString());
        catServ.setCostoUnitario(Integer.parseInt(dtm.getValueAt(FilaProv, 2).toString()));
        this.dispose();
    }//GEN-LAST:event_tblCategoriaServicioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCategoriaServicio;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
