package IU_PROCESOS;

import BEAN_MANTENIMIENTOS.Empleado;
import BEAN_PROCESOS.Usuario;
import DAO_MANTENIMIENTOS.EmpleadoDAO;
import DAO_PROCESOS.UsuarioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends javax.swing.JInternalFrame {
    Empleado emp;
    Usuario usu;
    public Login() {
        initComponents();
        añadirTexto(this.txtUsuario);
        añadirTexto(this.txtContraseña);
        emp = new Empleado();
        usu = new Usuario();
    }
        
    public void adaptarTamaño(int alto){
        this.setSize(358, alto);
    }
    
    private void añadirTexto(JTextField jtf){
        Font tipoTxt = jtf.getFont();
        tipoTxt = tipoTxt.deriveFont(Font.PLAIN | Font.BOLD);
        jtf.setFont(tipoTxt);
        jtf.setForeground(Color.gray);
    }
    
    public Empleado devuelveEmpleado(){
        return emp;
    }
    public Usuario devuelveUsuario(){
        return usu;
    }
    
    private boolean validar(){
        UsuarioDAO usuDao = new UsuarioDAO();
        Vector<Usuario> listaUsu = usuDao.listaUsuario(false, "", "");
        for(int i=0; i<listaUsu.size(); i++){
            if(this.txtUsuario.getText().equals(listaUsu.get(i).getUsuario()) && this.txtContraseña.getText().equals(listaUsu.get(i).getContraseña())){
                emp.setIdEmpleado(listaUsu.get(i).getIdEmpleado());
                usu = usuDao.retornaUsuario(listaUsu.get(i).getIdUsuario());
                return true;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Panel = new FondoPanel();
        btnIngreso = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jEImagePanel1 = new LIB.JEImagePanel();
        txtContraseña = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnIngreso.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnIngreso.setText("Ingresar");
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N

        jEImagePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/empleado.jpg"))); // NOI18N

        javax.swing.GroupLayout jEImagePanel1Layout = new javax.swing.GroupLayout(jEImagePanel1);
        jEImagePanel1.setLayout(jEImagePanel1Layout);
        jEImagePanel1Layout.setHorizontalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jEImagePanel1Layout.setVerticalGroup(
            jEImagePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

        txtContraseña.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jEImagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContraseña))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jEImagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(btnIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed
        if(validar()){
            EmpleadoDAO empDao = new EmpleadoDAO();
            emp = empDao.buscaEmpleado(emp.getIdEmpleado());
            this.txtUsuario.setText("");
            this.txtContraseña.setText("");
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Usuario no registrado");
        }
    }//GEN-LAST:event_btnIngresoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton btnIngreso;
    private LIB.JEImagePanel jEImagePanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/IMAGES/Fondo_local.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false); //
            super.paint(g); // permite verificar los elementos como labels y text
        }
    }
}
