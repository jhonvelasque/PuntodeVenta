package IU_PROCESOS;

import BEAN_MANTENIMIENTOS.Cliente;
import DAO_MANTENIMIENTOS.ClienteDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelecCliente extends javax.swing.JDialog {
    Cliente clie;
    ClienteDAO clieDao;
    DefaultTableModel dtm;
    public SelecCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clie = new Cliente();
        clieDao = new ClienteDAO();
        dtm = (DefaultTableModel)this.tblCliente.getModel();
        llenaCmbBuscar();
        llenarTablaCliente(false, "", "");
    }
    
    private void llenaCmbBuscar(){
        this.cmbBuscar.addItem("ID Cliente");
        this.cmbBuscar.addItem("ID Categoria");
        this.cmbBuscar.addItem("Nombres");
        this.cmbBuscar.addItem("Apellidos");
        this.cmbBuscar.addItem("Documento");
        this.cmbBuscar.addItem("Telefono");
        this.cmbBuscar.addItem("Correo");
    }
    
    private void llenarTablaCliente(boolean sw, String cad, String camp){
        Vector<Cliente> listClie = new Vector<Cliente>();
        listClie = clieDao.listClientes(sw, cad, camp);
        dtm.setRowCount(0);
        for(int i=0; i<listClie.size(); i++){
            Vector vec = new Vector();
            vec.add(listClie.get(i).getIdCliente());
            vec.add(listClie.get(i).getIdCategoria());
            vec.add(listClie.get(i).getNombCliente());
            vec.add(listClie.get(i).getApellCliente());
            vec.add(listClie.get(i).getDocCliente());
            vec.add(listClie.get(i).getTelefono());
            vec.add(listClie.get(i).getCorreo());
            dtm.addRow(vec);
        }
    }
    
    public Cliente devuelveCliente(){
        return clie;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 109, 119));

        jPanel2.setBackground(new java.awt.Color(0, 52, 89));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECCIONE UN CLIENTE");

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

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "Title 3", "Nombre", "Telefono", "Correo", "Dirección"
            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

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
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
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
            llenarTablaCliente(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbBuscar.getSelectedItem().toString()){
                case "ID Cliente":    camp = "IdCliente";   break;
                case "ID Categoria":    camp = "IdCategoriaCliente";   break;
                case "Nombres":    camp = "NombCliente";   break;
                case "Apellidos":    camp = "ApellCliente";   break;
                case "Documento":    camp = "DocCliente";   break;
                case "Telefono":    camp = "Telefono";   break;
                case "Correo":    camp = "Correo";   break;
            }
            llenarTablaCliente(true, this.txtBuscar.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        int FilaClie = this.tblCliente.getSelectedRow();
        clie.setIdCliente(Integer.parseInt(dtm.getValueAt(FilaClie, 0).toString()));
        clie.setIdCategoria(Integer.parseInt(dtm.getValueAt(FilaClie, 1).toString()));
        clie.setNombCliente(dtm.getValueAt(FilaClie, 2).toString());
        clie.setApellCliente(dtm.getValueAt(FilaClie, 3).toString());
        clie.setDocCliente(Integer.parseInt(dtm.getValueAt(FilaClie, 4).toString()));
        clie.setTelefono(Integer.parseInt(dtm.getValueAt(FilaClie, 5).toString()));
        clie.setCorreo(dtm.getValueAt(FilaClie, 6).toString());
        this.dispose();
    }//GEN-LAST:event_tblClienteMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
