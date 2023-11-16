package UI;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {
    Contraseña FrmContr;
    public MenuPrincipal() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Toolkit tk = Toolkit.getDefaultToolkit(); // Clase relacionada con la pantalla
        Dimension tamaño = tk.getScreenSize(); // obtienes la dimension de la pantalla
        
        Contraseña FrmContr = new Contraseña();
        this.User_Empleado.add(FrmContr);
        FrmContr.setVisible(true);
        FrmContr.adaptarTamaño((int)tamaño.getHeight());
        
        Procesos FrmProcesos = new Procesos();
        this.Procesos.add(FrmProcesos);
        FrmProcesos.adaptarTamaño(945, (int)tamaño.getHeight());
        FrmProcesos.setVisible(true);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        User_Empleado = new javax.swing.JPanel();
        Procesos = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        User_Empleado.setBackground(new java.awt.Color(204, 204, 255));
        User_Empleado.setPreferredSize(new java.awt.Dimension(358, 442));

        javax.swing.GroupLayout User_EmpleadoLayout = new javax.swing.GroupLayout(User_Empleado);
        User_Empleado.setLayout(User_EmpleadoLayout);
        User_EmpleadoLayout.setHorizontalGroup(
            User_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        User_EmpleadoLayout.setVerticalGroup(
            User_EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        Procesos.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout ProcesosLayout = new javax.swing.GroupLayout(Procesos);
        Procesos.setLayout(ProcesosLayout);
        ProcesosLayout.setHorizontalGroup(
            ProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        ProcesosLayout.setVerticalGroup(
            ProcesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                .addComponent(Procesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(User_Empleado, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
            .addComponent(Procesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
