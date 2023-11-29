package IU_PROCESOS;

import BEAN_MANTENIMIENTOS.Empleado;
import BEAN_PROCESOS.Usuario;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class MenuPrincipal extends javax.swing.JFrame {
    Empleado emp;
    Usuario usu;
    Login FrmLogin;
    Procesos FrmProcesos;
    public MenuPrincipal() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/IMAGES/logo.png")).getImage());
        
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Toolkit tk = Toolkit.getDefaultToolkit(); // Clase relacionada con la pantalla
        Dimension tamaño = tk.getScreenSize(); // obtienes la dimension de la pantalla
        
        Login FrmLogin = new Login();
        this.User_Empleado.add(FrmLogin);
        FrmLogin.setVisible(true);
        FrmLogin.adaptarTamaño((int)tamaño.getHeight());
        
        Procesos FrmProcesos = new Procesos();
        this.Procesos.add(FrmProcesos);
        FrmProcesos.adaptarTamaño(945, (int)tamaño.getHeight());
        FrmProcesos.setVisible(false);
        
        EmpleadoIngreso FrmEmpl = new EmpleadoIngreso();
        this.User_Empleado.add(FrmEmpl);
        FrmEmpl.setVisible(true);
        FrmEmpl.adaptarTamaño((int)tamaño.getHeight());
        
        // Ubicar logo
        this.Logo.setLocation(this.Procesos.getWidth() - 300, this.Procesos.getHeight() - 300);
        
        // Para el aparecimiento de frames al ingresar y salir
        AncestorListener alLogin = new AncestorListener() {
            public void ancestorActionPerformed(AncestorEvent ae) {
                
            }
            @Override
            public void ancestorAdded(AncestorEvent ae) {
            }

            @Override
            public void ancestorRemoved(AncestorEvent ae) {
                FrmProcesos.setVisible(true);
                emp = FrmLogin.devuelveEmpleado();
                usu = FrmLogin.devuelveUsuario();
                FrmProcesos.recibe(emp, usu);
                FrmEmpl.recibeEmpleado(emp);
                Logo.setVisible(false);
            }

            @Override
            public void ancestorMoved(AncestorEvent ae) {
            }
        };    
        FrmLogin.addAncestorListener(alLogin);
        AncestorListener alEmp = new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent ae) {
            }

            @Override
            public void ancestorRemoved(AncestorEvent ae) {
                FrmLogin.setVisible(true);
                FrmProcesos.setVisible(false);
                Logo.setVisible(true);
            }

            @Override
            public void ancestorMoved(AncestorEvent ae) {
            }
        };    
        FrmEmpl.addAncestorListener(alEmp);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        User_Empleado = new javax.swing.JPanel();
        Procesos = new javax.swing.JPanel();
        Logo = new LIB.JEImagePanel();
        menuBar = new javax.swing.JMenuBar();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        User_Empleado.setBackground(new java.awt.Color(131, 197, 179));
        User_Empleado.setPreferredSize(new java.awt.Dimension(358, 442));

        javax.swing.GroupLayout User_EmpleadoLayout = new javax.swing.GroupLayout(User_Empleado);
        User_Empleado.setLayout(User_EmpleadoLayout);
        User_EmpleadoLayout.setHorizontalGroup(
            User_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        User_EmpleadoLayout.setVerticalGroup(
            User_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Procesos.setBackground(new java.awt.Color(0, 52, 89));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/logo.png"))); // NOI18N
        Logo.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ProcesosLayout = new javax.swing.GroupLayout(Procesos);
        Procesos.setLayout(ProcesosLayout);
        ProcesosLayout.setHorizontalGroup(
            ProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcesosLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(412, Short.MAX_VALUE))
        );
        ProcesosLayout.setVerticalGroup(
            ProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProcesosLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        editMenu.setMnemonic('e');

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(User_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Procesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Procesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(User_Empleado, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIB.JEImagePanel Logo;
    private javax.swing.JPanel Procesos;
    private javax.swing.JPanel User_Empleado;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem pasteMenuItem;
    // End of variables declaration//GEN-END:variables

}
