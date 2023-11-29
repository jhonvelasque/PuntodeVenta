package IU_PROCESOS;

import BEAN_MANTENIMIENTOS.Empleado;
import DAO_MANTENIMIENTOS.EmpleadoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelecEmpleado extends javax.swing.JDialog {
    Empleado emp;
    EmpleadoDAO empDao;
    DefaultTableModel dtm;
    public SelecEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        emp = new Empleado();
        empDao = new EmpleadoDAO();
        dtm = (DefaultTableModel)this.TblEmpleado.getModel();
        llenaCmbBuscar();
        llenarTablaEmpleado(false, "", "");
    }
    
    private void llenaCmbBuscar(){
        this.cmbBuscar.addItem("ID Empleado");
        this.cmbBuscar.addItem("Nombres");
        this.cmbBuscar.addItem("Apellidos");
        this.cmbBuscar.addItem("Documento");
        this.cmbBuscar.addItem("Dirección");
        this.cmbBuscar.addItem("Telefono");
        this.cmbBuscar.addItem("Correo");
        this.cmbBuscar.addItem("Inicio");
        this.cmbBuscar.addItem("Fin");
        this.cmbBuscar.addItem("Cargo");
        this.cmbBuscar.addItem("Estado");
    }
    
    private void llenarTablaEmpleado(boolean sw, String cad, String camp){
        Vector<Empleado> listEmp = new Vector<Empleado>();
        listEmp = empDao.listaEmpleado(sw, cad, camp);
        dtm.setRowCount(0);
        for(int i=0; i<listEmp.size(); i++){
            Vector vec = new Vector();
            vec.add(listEmp.get(i).getIdEmpleado());
            vec.add(listEmp.get(i).getNomEmpleado());
            vec.add(listEmp.get(i).getApellEmpleado());
            vec.add(listEmp.get(i).getDocEmpleado());
            vec.add(listEmp.get(i).getDireccion());
            vec.add(listEmp.get(i).getTelefono());
            vec.add(listEmp.get(i).getCorreo());
            vec.add(listEmp.get(i).getFechaInicio());
            vec.add(listEmp.get(i).getFechaFinal());
            vec.add(listEmp.get(i).getCargo());
            vec.add(listEmp.get(i).getEstado());
            dtm.addRow(vec);
        }
    }
    
    public Empleado devuelveEmpleado(){
        return emp;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblEmpleado = new javax.swing.JTable();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SELECCIONE UN EMPLEADO");

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

        TblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Documento", "Dirección", "Telefono", "Correo", "Inicio", "Fin", "Cargo", "Estado"
            }
        ));
        TblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblEmpleado);

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
        if(this.txtBuscar.getText().equals("")){
            llenarTablaEmpleado(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbBuscar.getSelectedItem().toString()){
                case "ID Empleado":    camp = "IdEmpleado";   break;
                case "Nombres":    camp = "NombEmpleado";   break;
                case "Apellidos":    camp = "ApellEmpleado";   break;
                case "Documento":    camp = "DocEmpleado";   break;
                case "Dirección":    camp = "Dirección";   break;
                case "Telefono":    camp = "Telefono";   break;
                case "Correo":    camp = "Correo";   break;
                case "Inicio":    camp = "FechaInicio";   break;
                case "Fin":    camp = "FechaFinal";   break;
                case "Cargo":    camp = "Cargo";   break;
                case "Estado":    camp = "Estado";   break;
            }
            llenarTablaEmpleado(true, this.txtBuscar.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void TblEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblEmpleadoMouseClicked
        int fila = this.TblEmpleado.getSelectedRow();
        emp.setIdEmpleado(Integer.parseInt(dtm.getValueAt(fila, 0).toString()));
        emp.setNomEmpleado(dtm.getValueAt(fila, 1).toString());
        emp.setApellEmpleado(dtm.getValueAt(fila, 2).toString());
        emp.setDocEmpleado(dtm.getValueAt(fila, 3).toString());
        emp.setCorreo(dtm.getValueAt(fila, 4).toString());
        emp.setTelefono(dtm.getValueAt(fila, 5).toString());
        emp.setCorreo(dtm.getValueAt(fila, 6).toString());
        emp.setFechaInicio(dtm.getValueAt(fila, 7).toString());
        emp.setFechaFinal(dtm.getValueAt(fila, 8).toString());
        emp.setCargo(dtm.getValueAt(fila, 9).toString());
        emp.setEstado(Integer.parseInt(dtm.getValueAt(fila, 10).toString()));
        
        this.dispose();
    }//GEN-LAST:event_TblEmpleadoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblEmpleado;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
