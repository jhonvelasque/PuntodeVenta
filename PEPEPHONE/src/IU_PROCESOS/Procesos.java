package IU_PROCESOS;

import BEAN_PROCESOS.DetVenta;
import BEAN_PROCESOS.Venta;
import BEAN_MANTENIMIENTOS.Cliente;
import BEAN_MANTENIMIENTOS.Empleado;
import BEAN_MANTENIMIENTOS.Producto;
import BEAN_MANTENIMIENTOS.Proveedor;
import BEAN_PROCESOS.Almacen;
import BEAN_PROCESOS.CategoriaServicio;
import BEAN_PROCESOS.Compra;
import BEAN_PROCESOS.DetCompra;
import BEAN_PROCESOS.DetServicioCatServicio;
import BEAN_PROCESOS.DetServicioProducto;
import BEAN_PROCESOS.Inventario;
import BEAN_PROCESOS.Servicio;
import BEAN_PROCESOS.Usuario;
import DAO_PROCESOS.DetVentaDAO;
import DAO_MANTENIMIENTOS.ClienteDAO;
import DAO_MANTENIMIENTOS.ProveedorDAO;
import DAO_PROCESOS.AlmacenDAO;
import DAO_PROCESOS.CompraDAO;
import DAO_PROCESOS.DetCompraDAO;
import DAO_PROCESOS.DetServicioCategoriaDAO;
import DAO_PROCESOS.DetServicioProductoDAO;
import DAO_PROCESOS.InventarioDAO;
import DAO_PROCESOS.ServicioDAO;
import DAO_PROCESOS.UsuarioDAO;
import DAO_PROCESOS.VentaDAO;
import IU_MANTENIMIENTOS.FrmCatCliente;
import IU_MANTENIMIENTOS.FrmCategoria_producto;
import IU_MANTENIMIENTOS.FrmCliente;
import IU_MANTENIMIENTOS.FrmEmpleado;
import IU_MANTENIMIENTOS.FrmProducto;
import IU_MANTENIMIENTOS.FrmProveedor;
import IU_REPORTES.FrmRepCatClienteFiltro;
import IU_REPORTES.FrmRepCatProd;
import IU_REPORTES.FrmRepClienteRang;
import IU_REPORTES.FrmRepEmpl;
import IU_REPORTES.FrmRepProdMin;
import IU_REPORTES.FrmRepProvTipoVia;
import UTIL.Util;
import UTIL.DbBean;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

public class Procesos extends javax.swing.JInternalFrame {
    Util util;
    Empleado emp;
    ClienteDAO clieDao;
    
    // Atributos Usuario
    Usuario us;
    String Constraseña;
    UsuarioDAO usuDao;
    DefaultTableModel dtmUsuario;
    // Atributos de Compra
    DefaultTableModel dtmProdCompra;
    DefaultTableModel dtmProvCompra;
    DefaultTableModel dtmOrdenCompra;
    DetCompraDAO detCompDao;
    CompraDAO compDao;
    ProveedorDAO provDao;
    // Atributos de Venta
    DefaultTableModel dtmProdVenta;
    DefaultTableModel dtmClieVenta;
    DefaultTableModel dtmOrdenVenta;
    DetVentaDAO detVentDao;
    VentaDAO ventDao;
    // Atributos de Servicio
    DefaultTableModel dtmProdServicio;
    DefaultTableModel dtmCatServServicio;
    DefaultTableModel dtmClieServicio;
    DefaultTableModel dtmOrdenServicio;
    DetServicioProductoDAO detServProdDao;
    DetServicioCategoriaDAO detServCatServDao;
    ServicioDAO servDao;
    // Atributos de Almacen e inventario
    DefaultTableModel dtmInv;
    DefaultTableModel dtmAlmacen;
    AlmacenDAO almDao;
    InventarioDAO invDao;
    
    public Procesos() {
        initComponents();
        emp = new Empleado();
        util = new Util();
        clieDao = new ClienteDAO();
        llenarCmbTipoPago();
        llenarCmbEstado();
        llenaCmbReporte();
        // Inicializando Compras
        this.txtIdCompra.setText(String.valueOf(util.idNext("Compra", "IdCompra")));
        dtmProdCompra = (DefaultTableModel)this.tblProdCompra.getModel();
        dtmProvCompra = (DefaultTableModel)this.tblProveedorCompra.getModel();
        dtmOrdenCompra = (DefaultTableModel)this.tblOrdenCompra.getModel();
        detCompDao = new DetCompraDAO();
        compDao = new CompraDAO();
        provDao = new ProveedorDAO();
        llenarCmbProvCompra();
        llenarCmbCompra();
        llenarTblProveedorCompra(false, "", "");
        llenarTblOrdenCompra(false, "", "");
        //Inicializando Ventas
        this.txtIdVenta.setText(String.valueOf(util.idNext("Venta", "IdVenta")));
        dtmProdVenta = (DefaultTableModel)this.tblProdVenta.getModel();
        dtmClieVenta = (DefaultTableModel)this.tblClienteVenta.getModel();
        dtmOrdenVenta = (DefaultTableModel)this.tblOrdenVenta.getModel();
        detVentDao = new DetVentaDAO();
        ventDao = new VentaDAO();
        llenarCmbClieVenta();
        llenarCmbVenta();
        llenarTblClienteVenta(false, "", "");
        llenarTblOrdenVenta(false, "", "");
        // Servicios
        this.txtIdServicio.setText(String.valueOf(util.idNext("Servicio", "IdServicio")));
        dtmProdServicio = (DefaultTableModel)this.tblProdServicio.getModel();
        dtmCatServServicio = (DefaultTableModel)this.tblCatServServicio.getModel();
        dtmClieServicio = (DefaultTableModel)this.tblClienteServicio.getModel();
        dtmOrdenServicio = (DefaultTableModel)this.tblOrdenServicio.getModel();
        detServProdDao = new DetServicioProductoDAO();
        detServCatServDao = new DetServicioCategoriaDAO();
        servDao = new ServicioDAO();
        llenarCmbClieServicio();
        llenarCmbServicio();
        llenarTblClienteServicio(false, "", "");
        llenarTblOrdenServicio(false, "", "");
        // Almacen e Inventario
        dtmInv = (DefaultTableModel)this.tblInventario.getModel();
        dtmAlmacen = (DefaultTableModel)this.tblAlmacen.getModel();
        almDao = new AlmacenDAO();
        invDao = new InventarioDAO();
        // Usuario
        Usuario us = new Usuario();
        usuDao = new UsuarioDAO();
        dtmUsuario = (DefaultTableModel) this.tblUsuario.getModel();
        this.txtIdUsuario.setText(String.valueOf(util.idNext("Usuario", "IdUsuario")));
        llenarTblUsuarios(false,"", "");
    }
    
    public void recibe(Empleado em, Usuario u){
        emp = em;
        this.txtIdEmpleadoCompra.setText(String.valueOf(em.getIdEmpleado()));
        this.txtIdEmpleadoVenta.setText(String.valueOf(em.getIdEmpleado()));
        this.txtIdEmpleadoServicio.setText(String.valueOf(em.getIdEmpleado()));
        us = u;
        this.txtUsuReg.setText(us.getUsuario());
        this.txtFechReg.setText(util.obtenerFecha().substring(0, 10));
        this.txtUsuMod.setText(us.getUsuario());
        this.txtFechMod.setText(util.obtenerFecha().substring(0, 10));
    }
    
    public void adaptarTamaño(int ancho, int alto){
        this.setSize(ancho, alto-80);
    }
    
    private void llenaCmbReporte(){
        this.cmbMantenimiento.addItem("");
        this.cmbMantenimiento.addItem("Categoria Cliente");
        this.cmbMantenimiento.addItem("Categoria Producto");
        this.cmbMantenimiento.addItem("Cliente");
        this.cmbMantenimiento.addItem("Producto");
        this.cmbMantenimiento.addItem("Proveedor");
        this.cmbMantenimiento.addItem("Empleado");
        this.cmbTipoReporte.addItem("");
        this.cmbTipoReporte.addItem("Simple");
        this.cmbTipoReporte.addItem("Parametros");
    }
    
    private void llenarCmbTipoPago(){
        this.cmbTipoPagoCompra.addItem("");
        this.cmbTipoPagoCompra.addItem("Efectivo");
        this.cmbTipoPagoCompra.addItem("Visa");
        this.cmbTipoPagoCompra.addItem("Yape / Plin");
        
        this.cmbTipoPagoVenta.addItem("");
        this.cmbTipoPagoVenta.addItem("Efectivo");
        this.cmbTipoPagoVenta.addItem("Visa");
        this.cmbTipoPagoVenta.addItem("Yape / Plin");
        
        this.cmbTipoPagoServicio.addItem("");
        this.cmbTipoPagoServicio.addItem("Efectivo");
        this.cmbTipoPagoServicio.addItem("Visa");
        this.cmbTipoPagoServicio.addItem("Yape / Plin");
    }
    private void llenarCmbEstado(){
        this.cmbEstadoCompra.addItem("");
        this.cmbEstadoCompra.addItem("Pendiente");
        this.cmbEstadoCompra.addItem("Entregada");
        
        this.cmbEstadoVenta.addItem("");
        this.cmbEstadoVenta.addItem("Pendiente");
        this.cmbEstadoVenta.addItem("Entregada");
        
        this.cmbEstadoServicio.addItem("");
        this.cmbEstadoServicio.addItem("Pendiente");
        this.cmbEstadoServicio.addItem("Entregada");
    }
    private void llenarTblAlmacen(boolean sw, String cad, String camp){
        Vector<Almacen> listAlm = new Vector<Almacen>();
        listAlm = almDao.listAlmacen(sw, cad, camp);
        this.dtmAlmacen.setRowCount(0);
        for(int i=0; i<listAlm.size(); i++){
            Vector vec = new Vector();
            vec.add(listAlm.get(i).getIdAlmacen());
            vec.add(listAlm.get(i).getDescripcion());
            vec.add(listAlm.get(i).getCiudad());
            vec.add(listAlm.get(i).getDistrito());
            vec.add(listAlm.get(i).getDireccion());
            vec.add(listAlm.get(i).getCapacidad());
            dtmAlmacen.addRow(vec);
        }
    }
    private void llenarTblInventario(boolean sw, String cad, String camp){
        Vector<Cliente> listClie = new Vector<Cliente>();
        listClie = clieDao.listClientes(sw, cad, camp);
        this.dtmClieServicio.setRowCount(0);
        for(int i=0; i<listClie.size(); i++){
            Vector vec = new Vector();
            vec.add(listClie.get(i).getIdCliente());
            vec.add(listClie.get(i).getIdCategoria());
            vec.add(listClie.get(i).getNombCliente() + ", "+ listClie.get(i).getApellCliente());
            vec.add(listClie.get(i).getDocCliente());
            vec.add(listClie.get(i).getTelefono());
            vec.add(listClie.get(i).getCorreo());
            dtmClieServicio.addRow(vec);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TbPnlProcesos = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        TbPnlCompra = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProveedorCompra = new javax.swing.JTable();
        cmbProveedorCompra = new javax.swing.JComboBox<>();
        txtBuscarProveedorCompra = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrdenCompra = new javax.swing.JTable();
        txtBuscarCompra = new javax.swing.JTextField();
        cmbOrdenCompra = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnBuscarProvCompra = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnAgregarProvCompra = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIdProvCompra = new javax.swing.JTextField();
        txtRucProvCompra = new javax.swing.JTextField();
        txtNombreProvCompra = new javax.swing.JTextField();
        txtTelefonoProvCompra = new javax.swing.JTextField();
        txtDireccionProvCompra = new javax.swing.JTextField();
        txtCorreoProvCompra = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdCompra = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtIdProdCompra = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnAgregarProdCompra = new javax.swing.JButton();
        btnBuscarProdCompra = new javax.swing.JButton();
        txtCantidadProdCompra = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCostoUnitProdCompra = new javax.swing.JTextField();
        txtTotalCompra = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnAñadirProdCompra = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        txtSubTotalCompra = new javax.swing.JTextField();
        btnEliminaProductoCompra = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDiaCompra = new javax.swing.JTextField();
        cmbEstadoCompra = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtMesCompra = new javax.swing.JTextField();
        txtAñoCompra = new javax.swing.JTextField();
        txtDiaEntregaCompra = new javax.swing.JTextField();
        txtMesEntregaCompra = new javax.swing.JTextField();
        txtAñoEntregaCompra = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacionesCompra = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbTipoPagoCompra = new javax.swing.JComboBox<>();
        txtIdEmpleadoCompra = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtIdAlmacenCompra = new javax.swing.JTextField();
        btnBuscarEmpleadoCompra = new javax.swing.JButton();
        btnBuscarAlmacenCompra = new javax.swing.JButton();
        btnGrabarCompra = new javax.swing.JButton();
        btnLimpiarCompra = new javax.swing.JButton();
        btnEliminarCompra = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        TbPnlVenta = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblClienteVenta = new javax.swing.JTable();
        cmbClienteVenta = new javax.swing.JComboBox<>();
        txtBuscarClienteVenta = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblOrdenVenta = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        txtBuscarVenta = new javax.swing.JTextField();
        cmbOrdenVenta = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        btnBuscarClieVenta = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        btnAgregarClieVenta = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtIdClieVenta = new javax.swing.JTextField();
        txtDniClieVenta = new javax.swing.JTextField();
        txtNomApeClieVenta = new javax.swing.JTextField();
        txtTelefonoClieVenta = new javax.swing.JTextField();
        txtIdCategoraClieVenta = new javax.swing.JTextField();
        txtCorreoClieVenta = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblProdVenta = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        txtIdProdVenta = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        btnAgregarProductoVenta = new javax.swing.JButton();
        btnBuscarProductoVenta = new javax.swing.JButton();
        txtCantidadProdVenta = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtCostoUnitProdVenta = new javax.swing.JTextField();
        txtTotalVenta = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        btnAñadirProdVenta = new javax.swing.JButton();
        btnEliminaProductoVenta = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtSubTotalVenta = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtDiaVenta = new javax.swing.JTextField();
        cmbEstadoVenta = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        txtMesVenta = new javax.swing.JTextField();
        txtAñoVenta = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtObservacionesVenta = new javax.swing.JTextArea();
        jLabel39 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbTipoPagoVenta = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        txtIdEmpleadoVenta = new javax.swing.JTextField();
        btnBuscarEmpleadoVenta = new javax.swing.JButton();
        btnBuscarAlmacenVenta = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        txtIdAlmacenVenta = new javax.swing.JTextField();
        btnGrabarVenta = new javax.swing.JButton();
        btnLimpiarVenta = new javax.swing.JButton();
        btnEliminarVenta = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        TbPnlServicio = new javax.swing.JTabbedPane();
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblClienteServicio = new javax.swing.JTable();
        cmbClienteServicio = new javax.swing.JComboBox<>();
        txtBuscarClienteServicio = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblOrdenServicio = new javax.swing.JTable();
        txtBuscarServicio = new javax.swing.JTextField();
        cmbOrdenServicio = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        txtIdServicio = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtDiaServicio = new javax.swing.JTextField();
        cmbEstadoServicio = new javax.swing.JComboBox<>();
        jLabel76 = new javax.swing.JLabel();
        txtMesServicio = new javax.swing.JTextField();
        txtAñoServicio = new javax.swing.JTextField();
        txtDiaEntregaServicio = new javax.swing.JTextField();
        txtMesEntregaServicio = new javax.swing.JTextField();
        txtAñoEntregaServicio = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtObservacionesServicio = new javax.swing.JTextArea();
        jLabel77 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cmbTipoPagoServicio = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        txtIdEmpleadoServicio = new javax.swing.JTextField();
        btnBuscarEmpleadoServicio = new javax.swing.JButton();
        btnBuscarAlmacenServicio = new javax.swing.JButton();
        txtIdAlmacenServicio = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        btnBuscarClieServicio = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        btnAgregarClieServicio = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtIdClieServicio = new javax.swing.JTextField();
        txtDniClieServicio = new javax.swing.JTextField();
        txtNomApeClieServicio = new javax.swing.JTextField();
        txtTelefonoClieServicio = new javax.swing.JTextField();
        txtIdCategoraClieServicio = new javax.swing.JTextField();
        txtCorreoClieServicio = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblProdServicio = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        txtIdProdServicio = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        btnAgregarProductoServicio = new javax.swing.JButton();
        btnBuscarProductoServicio = new javax.swing.JButton();
        txtCantidadProdServicio = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        txtCostoUnitProdServicio = new javax.swing.JTextField();
        txtTotalProdServicio = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        btnAñadirProdServicio = new javax.swing.JButton();
        btnEliminaProductoServicio = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        txtSubTotalProdServicio = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        txtIdCatServServicio = new javax.swing.JTextField();
        txtCostoUnitCatServServicio = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        txtCantidadCatServServicio = new javax.swing.JTextField();
        txtSubTotalCatServServicio = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblCatServServicio = new javax.swing.JTable();
        btnAñadirCatServServicio = new javax.swing.JButton();
        btnEliminaCatServServicio = new javax.swing.JButton();
        jLabel88 = new javax.swing.JLabel();
        txtTotalCatServServicio = new javax.swing.JTextField();
        btnBuscarCatServServicio = new javax.swing.JButton();
        btnAgregarCatServServicio = new javax.swing.JButton();
        btnGrabarServicio = new javax.swing.JButton();
        btnLimpiarServicio = new javax.swing.JButton();
        btnEliminarServicio = new javax.swing.JButton();
        txtTotalServicio = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        iconProveedor = new LIB.JEImagePanel();
        pnlMantenimientos = new javax.swing.JPanel();
        iconProducto = new LIB.JEImagePanel();
        iconCategoriaProducto = new LIB.JEImagePanel();
        iconEmpleado = new LIB.JEImagePanel();
        iconCliente = new LIB.JEImagePanel();
        iconCategoriaCliente = new LIB.JEImagePanel();
        iconAlmacen = new LIB.JEImagePanel();
        iconCategoriaServicio = new LIB.JEImagePanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblAlmacen = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jTextField45 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        cmbMantenimiento = new javax.swing.JComboBox<>();
        btnGeneraReporte = new javax.swing.JButton();
        cmbTipoReporte = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pnlReportes = new javax.swing.JPanel();
        pnlUsuario = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtIdEmpleadoUsuario = new javax.swing.JTextField();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtFechMod = new javax.swing.JTextField();
        txtUsuReg = new javax.swing.JTextField();
        txtFechReg = new javax.swing.JTextField();
        txtUsuMod = new javax.swing.JTextField();
        btnBuscaEmpleado = new javax.swing.JButton();
        btnGrabarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        txtContraseñaUsuario = new javax.swing.JPasswordField();
        btnVerContraseñaUsuario = new javax.swing.JToggleButton();
        pnlUsuarioDatos = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 52, 89));

        TbPnlProcesos.setBackground(new java.awt.Color(102, 255, 102));
        TbPnlProcesos.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        TbPnlProcesos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TbPnlProcesosStateChanged(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 52, 89));

        TbPnlCompra.setBackground(new java.awt.Color(153, 153, 153));
        TbPnlCompra.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        TbPnlCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPnlCompraMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 109, 119));

        jPanel13.setBackground(new java.awt.Color(131, 197, 179));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));

        tblProveedorCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "Nombre", "Telefono", "Correo", "Dirección"
            }
        ));
        tblProveedorCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorCompraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProveedorCompra);

        txtBuscarProveedorCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProveedorCompraKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel16.setText("Buscar");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(60, 60, 60)
                .addComponent(txtBuscarProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cmbProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarProveedorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(131, 197, 179));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenes de compra"));

        tblOrdenCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Compra", "ID Empleado", "ID Proveedor", "Fecha Compra", "Fecha Entrega", "Total", "Observación", "Estado", "Tipo de Pago", "ID Almacen"
            }
        ));
        tblOrdenCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdenCompraMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblOrdenCompra);

        txtBuscarCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCompraKeyReleased(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel63.setText("Buscar");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addGap(35, 35, 35)
                        .addComponent(txtBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cmbOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbOrdenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel63)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        TbPnlCompra.addTab("Presentación", jPanel4);

        jPanel6.setBackground(new java.awt.Color(0, 109, 119));

        jPanel9.setBackground(new java.awt.Color(131, 197, 179));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedor"));

        btnBuscarProvCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarProvCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarProvCompra.setText("Buscar");
        btnBuscarProvCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarProvCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProvCompraActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("ID Proveedor:");

        btnAgregarProvCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarProvCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/insertar.png"))); // NOI18N
        btnAgregarProvCompra.setText("Agregar");
        btnAgregarProvCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarProvCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProvCompraActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("RUC:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Nombre:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Telefono:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Dirección:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Correo:");

        txtIdProvCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtIdProvCompra.setEnabled(false);

        txtRucProvCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtRucProvCompra.setEnabled(false);

        txtNombreProvCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombreProvCompra.setEnabled(false);

        txtTelefonoProvCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefonoProvCompra.setEnabled(false);

        txtDireccionProvCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDireccionProvCompra.setEnabled(false);

        txtCorreoProvCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCorreoProvCompra.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProvCompra))
                .addGap(45, 45, 45)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdProvCompra)
                    .addComponent(txtRucProvCompra)
                    .addComponent(txtNombreProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefonoProvCompra)
                    .addComponent(txtDireccionProvCompra)
                    .addComponent(txtCorreoProvCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarProvCompra)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarProvCompra)
                .addGap(22, 22, 22))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtDireccionProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreoProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtIdProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtRucProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreProvCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel10.setBackground(new java.awt.Color(131, 197, 179));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tblProdCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cantidad", "Costo Unit.", "Sub Total"
            }
        ));
        tblProdCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdCompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdCompra);

        jLabel13.setText("ID Producto:");

        txtIdProdCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtIdProdCompra.setEnabled(false);

        jLabel17.setText("Cantidad:");

        btnAgregarProdCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarProdCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/insertar.png"))); // NOI18N
        btnAgregarProdCompra.setText("Agregar");
        btnAgregarProdCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarProdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdCompraActionPerformed(evt);
            }
        });

        btnBuscarProdCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarProdCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarProdCompra.setText("Buscar");
        btnBuscarProdCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarProdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdCompraActionPerformed(evt);
            }
        });

        txtCantidadProdCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadProdCompraKeyReleased(evt);
            }
        });

        jLabel19.setText("Costo Unit.:");

        txtCostoUnitProdCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCostoUnitProdCompra.setEnabled(false);

        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalCompra.setText("0");
        txtTotalCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalCompra.setEnabled(false);

        jLabel20.setText("Total");

        btnAñadirProdCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAñadirProdCompra.setText("Añadir Producto");
        btnAñadirProdCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAñadirProdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirProdCompraActionPerformed(evt);
            }
        });

        jLabel40.setText("SubTotal:");

        txtSubTotalCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtSubTotalCompra.setEnabled(false);

        btnEliminaProductoCompra.setText("Eliminar Producto");
        btnEliminaProductoCompra.setEnabled(false);
        btnEliminaProductoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaProductoCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarProdCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarProdCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(txtSubTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidadProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCostoUnitProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnAñadirProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminaProductoCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtIdProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtCostoUnitProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCantidadProdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSubTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnBuscarProdCompra)
                                .addGap(11, 11, 11)
                                .addComponent(btnAgregarProdCompra))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadirProdCompra)
                    .addComponent(jLabel20)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminaProductoCompra))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(131, 197, 179));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden de Compra"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("ID:");

        txtIdCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtIdCompra.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Fecha Compra:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Fecha Entrega:");

        txtDiaCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDiaCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDiaCompra.setEnabled(false);

        cmbEstadoCompra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoCompraItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Estado:");

        txtMesCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMesCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMesCompra.setEnabled(false);

        txtAñoCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAñoCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAñoCompra.setEnabled(false);

        txtDiaEntregaCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDiaEntregaCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDiaEntregaCompra.setEnabled(false);

        txtMesEntregaCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMesEntregaCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMesEntregaCompra.setEnabled(false);

        txtAñoEntregaCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAñoEntregaCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtAñoEntregaCompra.setEnabled(false);

        txtObservacionesCompra.setColumns(20);
        txtObservacionesCompra.setRows(5);
        jScrollPane3.setViewportView(txtObservacionesCompra);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Observaciones:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Tipo de pago:");

        txtIdEmpleadoCompra.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("ID Empleado:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("ID Almacen:");

        txtIdAlmacenCompra.setEnabled(false);

        btnBuscarEmpleadoCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarEmpleadoCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarEmpleadoCompra.setText("Buscar");
        btnBuscarEmpleadoCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarEmpleadoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoCompraActionPerformed(evt);
            }
        });

        btnBuscarAlmacenCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarAlmacenCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarAlmacenCompra.setText("Buscar");
        btnBuscarAlmacenCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarAlmacenCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlmacenCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbEstadoCompra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addComponent(txtDiaEntregaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMesEntregaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAñoEntregaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(txtDiaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMesCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAñoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdCompra, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(cmbTipoPagoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdEmpleadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdAlmacenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscarAlmacenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarEmpleadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtIdEmpleadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarEmpleadoCompra))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMesCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAñoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaEntregaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMesEntregaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAñoEntregaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstadoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarAlmacenCompra)
                            .addComponent(txtIdAlmacenCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(cmbTipoPagoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(27, 27, 27))
        );

        btnGrabarCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGrabarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/agregar-contacto.png"))); // NOI18N
        btnGrabarCompra.setText("Grabar");
        btnGrabarCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGrabarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarCompraActionPerformed(evt);
            }
        });

        btnLimpiarCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/limpiar (1).png"))); // NOI18N
        btnLimpiarCompra.setText("Limpiar");
        btnLimpiarCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCompraActionPerformed(evt);
            }
        });

        btnEliminarCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/eliminar.png"))); // NOI18N
        btnEliminarCompra.setText("Eliminar");
        btnEliminarCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarCompra.setEnabled(false);
        btnEliminarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(btnGrabarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnLimpiarCompra)
                        .addGap(71, 71, 71)
                        .addComponent(btnEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGrabarCompra)
                        .addComponent(btnLimpiarCompra))
                    .addComponent(btnEliminarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        TbPnlCompra.addTab("Registro", jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TbPnlCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(TbPnlCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 93, Short.MAX_VALUE))
        );

        TbPnlProcesos.addTab("Compra", jPanel3);

        jPanel5.setBackground(new java.awt.Color(0, 52, 89));

        TbPnlVenta.setBackground(new java.awt.Color(153, 153, 153));
        TbPnlVenta.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        jPanel15.setBackground(new java.awt.Color(0, 109, 119));

        jPanel16.setBackground(new java.awt.Color(131, 197, 179));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        tblClienteVenta.setBackground(new java.awt.Color(153, 226, 180));
        tblClienteVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblClienteVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoría", "DNI", "Nombres y Apellidos", "Telefono", "Correo"
            }
        ));
        tblClienteVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteVentaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblClienteVenta);

        txtBuscarClienteVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteVentaKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel21.setText("Buscar");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(60, 60, 60)
                .addComponent(txtBuscarClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cmbClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(131, 197, 179));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenes de Venta"));

        tblOrdenVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venta", "ID Empleado", "ID Cliente", "Fecha Venta", "Total", "Observación", "Estado", "Tipo de pago", "ID Almacen"
            }
        ));
        tblOrdenVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdenVentaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblOrdenVenta);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel22.setText("Buscar");

        txtBuscarVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarVentaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(60, 60, 60)
                .addComponent(txtBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cmbOrdenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOrdenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        TbPnlVenta.addTab("Presentación", jPanel15);

        jPanel18.setBackground(new java.awt.Color(0, 109, 119));

        jPanel19.setBackground(new java.awt.Color(131, 197, 179));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        btnBuscarClieVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarClieVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarClieVenta.setText("Buscar");
        btnBuscarClieVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarClieVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClieVentaActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("ID Cliente:");

        btnAgregarClieVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarClieVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/insertar.png"))); // NOI18N
        btnAgregarClieVenta.setText("Agregar");
        btnAgregarClieVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarClieVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClieVentaActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("DNI:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Nombre y Apellido:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Telefono:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("ID Categoría");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Correo:");

        txtIdClieVenta.setEnabled(false);

        txtDniClieVenta.setEnabled(false);

        txtNomApeClieVenta.setEnabled(false);

        txtTelefonoClieVenta.setEnabled(false);

        txtIdCategoraClieVenta.setEnabled(false);

        txtCorreoClieVenta.setEnabled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarClieVenta)
                    .addComponent(btnAgregarClieVenta))
                .addGap(35, 35, 35)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(txtIdClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDniClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCategoraClieVenta))
                            .addComponent(txtNomApeClieVenta)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(txtTelefonoClieVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCorreoClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarClieVenta)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarClieVenta)
                .addGap(22, 22, 22))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtNomApeClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtTelefonoClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(txtCorreoClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtIdClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(txtDniClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCategoraClieVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel20.setBackground(new java.awt.Color(131, 197, 179));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tblProdVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cantidad", "Costo Unit.", "Sub Total"
            }
        ));
        tblProdVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdVentaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblProdVenta);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("ID Producto:");

        txtIdProdVenta.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Cantidad:");

        btnAgregarProductoVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarProductoVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/insertar.png"))); // NOI18N
        btnAgregarProductoVenta.setText("Agregar");
        btnAgregarProductoVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoVentaActionPerformed(evt);
            }
        });

        btnBuscarProductoVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarProductoVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarProductoVenta.setText("Buscar");
        btnBuscarProductoVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoVentaActionPerformed(evt);
            }
        });

        txtCantidadProdVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadProdVentaKeyReleased(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Costo Unit.:");

        txtCostoUnitProdVenta.setEnabled(false);

        txtTotalVenta.setEnabled(false);

        jLabel34.setText("Total");

        btnAñadirProdVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAñadirProdVenta.setText("Añadir Producto");
        btnAñadirProdVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAñadirProdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirProdVentaActionPerformed(evt);
            }
        });

        btnEliminaProductoVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminaProductoVenta.setText("Eliminar Producto");
        btnEliminaProductoVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminaProductoVenta.setEnabled(false);
        btnEliminaProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaProductoVentaActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("SubTotal:");

        txtSubTotalVenta.setEnabled(false);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarProductoVenta)
                    .addComponent(btnAgregarProductoVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(26, 26, 26)
                        .addComponent(txtIdProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtCostoUnitProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidadProdVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(txtSubTotalVenta))))
                .addGap(32, 32, 32)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(btnAñadirProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminaProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnBuscarProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarProductoVenta))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAñadirProdVenta)
                                .addComponent(btnEliminaProductoVenta))
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel34)))))
                .addGap(7, 7, 7))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtIdProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCostoUnitProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadProdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtSubTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(131, 197, 179));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden de Venta"));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("ID:");

        txtIdVenta.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Fecha Venta:");

        txtDiaVenta.setEnabled(false);

        cmbEstadoVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoVentaItemStateChanged(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Estado:");

        txtMesVenta.setEnabled(false);

        txtAñoVenta.setEnabled(false);

        txtObservacionesVenta.setColumns(20);
        txtObservacionesVenta.setRows(5);
        jScrollPane8.setViewportView(txtObservacionesVenta);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Observaciones:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Tipo de pago:");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("ID Empleado");

        txtIdEmpleadoVenta.setEnabled(false);

        btnBuscarEmpleadoVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarEmpleadoVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarEmpleadoVenta.setText("Buscar");
        btnBuscarEmpleadoVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarEmpleadoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoVentaActionPerformed(evt);
            }
        });

        btnBuscarAlmacenVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarAlmacenVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarAlmacenVenta.setText("Buscar");
        btnBuscarAlmacenVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarAlmacenVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlmacenVentaActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setText("ID Almacen");

        txtIdAlmacenVenta.setEnabled(false);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(42, 42, 42)
                        .addComponent(cmbEstadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addComponent(jLabel35))
                                .addComponent(jLabel36))
                            .addGap(42, 42, 42)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIdVenta)
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addComponent(txtDiaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAñoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cmbTipoPagoVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdEmpleadoVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(txtIdAlmacenVenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarAlmacenVenta)
                            .addComponent(btnBuscarEmpleadoVenta))
                        .addGap(63, 63, 63))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoPagoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEstadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAñoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                    .addComponent(btnBuscarEmpleadoVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIdEmpleadoVenta)
                                    .addComponent(jLabel52))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnBuscarAlmacenVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel60)
                                    .addComponent(txtIdAlmacenVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btnGrabarVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGrabarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/agregar-contacto.png"))); // NOI18N
        btnGrabarVenta.setText("Agregar");
        btnGrabarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGrabarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarVentaActionPerformed(evt);
            }
        });

        btnLimpiarVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/limpiar (1).png"))); // NOI18N
        btnLimpiarVenta.setText("Limpiar");
        btnLimpiarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarVentaActionPerformed(evt);
            }
        });

        btnEliminarVenta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/eliminar.png"))); // NOI18N
        btnEliminarVenta.setText("Eliminar");
        btnEliminarVenta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarVenta.setEnabled(false);
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnGrabarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnLimpiarVenta)
                        .addGap(54, 54, 54)
                        .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabarVenta)
                    .addComponent(btnEliminarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(736, 736, 736))
        );

        TbPnlVenta.addTab("Registro", jPanel18);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TbPnlVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(TbPnlVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 104, Short.MAX_VALUE))
        );

        TbPnlProcesos.addTab("Venta", jPanel5);

        jPanel7.setBackground(new java.awt.Color(0, 52, 89));

        TbPnlServicio.setBackground(new java.awt.Color(153, 153, 153));
        TbPnlServicio.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        TbPnlServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPnlServicioMouseClicked(evt);
            }
        });

        jPanel30.setBackground(new java.awt.Color(0, 109, 119));

        jPanel31.setBackground(new java.awt.Color(131, 197, 179));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        tblClienteServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoría", "Nombres y Apellidos", "DNI", "Telefono", "Correo"
            }
        ));
        tblClienteServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteServicioMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblClienteServicio);

        txtBuscarClienteServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClienteServicioKeyReleased(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel59.setText("Buscar");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addGap(60, 60, 60)
                .addComponent(txtBuscarClienteServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cmbClienteServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClienteServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarClienteServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel32.setBackground(new java.awt.Color(131, 197, 179));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenes de Servicio"));

        tblOrdenServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Servicio", "ID Empleado", "ID Cliente", "Fecha Servicio", "Fecha Entrega", "Total", "Observación", "Estado", "Tipo de Pago", "ID Almacen"
            }
        ));
        tblOrdenServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdenServicioMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblOrdenServicio);

        txtBuscarServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarServicioKeyReleased(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel64.setText("Buscar");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64)
                .addGap(69, 69, 69)
                .addComponent(txtBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(cmbOrdenServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOrdenServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TbPnlServicio.addTab("Presentación", jPanel30);

        jPanel33.setBackground(new java.awt.Color(0, 109, 119));

        jPanel36.setBackground(new java.awt.Color(131, 197, 179));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden de Servicio"));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("ID:");

        txtIdServicio.setEnabled(false);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setText("Fecha Servicio:");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setText("Fecha Entrega:");

        txtDiaServicio.setEnabled(false);

        cmbEstadoServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoServicioItemStateChanged(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("Estado:");

        txtMesServicio.setEnabled(false);

        txtAñoServicio.setEnabled(false);

        txtDiaEntregaServicio.setEnabled(false);

        txtMesEntregaServicio.setEnabled(false);

        txtAñoEntregaServicio.setEnabled(false);

        txtObservacionesServicio.setColumns(20);
        txtObservacionesServicio.setRows(5);
        jScrollPane16.setViewportView(txtObservacionesServicio);

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("Observaciones");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Tipo de pago:");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("ID Empleado");

        txtIdEmpleadoServicio.setEnabled(false);

        btnBuscarEmpleadoServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarEmpleadoServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarEmpleadoServicio.setText("Buscar");
        btnBuscarEmpleadoServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarEmpleadoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoServicioActionPerformed(evt);
            }
        });

        btnBuscarAlmacenServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarAlmacenServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarAlmacenServicio.setText("Buscar");
        btnBuscarAlmacenServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarAlmacenServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlmacenServicioActionPerformed(evt);
            }
        });

        txtIdAlmacenServicio.setEnabled(false);

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setText("ID Almacen");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(39, 39, 39)
                        .addComponent(txtIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel36Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26))
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addComponent(jLabel76)
                                    .addGap(42, 42, 42)))
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addComponent(txtDiaEntregaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMesEntregaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAñoEntregaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cmbEstadoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel36Layout.createSequentialGroup()
                            .addComponent(jLabel74)
                            .addGap(39, 39, 39)
                            .addComponent(txtDiaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMesServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtAñoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                                .addComponent(cmbTipoPagoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel65))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdEmpleadoServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(txtIdAlmacenServicio))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnBuscarEmpleadoServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(btnBuscarAlmacenServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel77)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMesServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAñoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaEntregaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMesEntregaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAñoEntregaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEstadoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76)))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipoPagoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel61)
                                    .addComponent(txtIdEmpleadoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarEmpleadoServicio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnBuscarAlmacenServicio)
                                    .addComponent(txtIdAlmacenServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65))))
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel77)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel23.setBackground(new java.awt.Color(131, 197, 179));
        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        btnBuscarClieServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarClieServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarClieServicio.setText("Buscar");
        btnBuscarClieServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarClieServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClieServicioActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("ID Cliente:");

        btnAgregarClieServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarClieServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/insertar.png"))); // NOI18N
        btnAgregarClieServicio.setText("Agregar");
        btnAgregarClieServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarClieServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClieServicioActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("DNI:");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Nombre y Apellido:");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Telefono:");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("ID Categoría");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Correo:");

        txtIdClieServicio.setEnabled(false);

        txtDniClieServicio.setEnabled(false);

        txtNomApeClieServicio.setEnabled(false);

        txtTelefonoClieServicio.setEnabled(false);

        txtIdCategoraClieServicio.setEnabled(false);

        txtCorreoClieServicio.setEnabled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarClieServicio)
                    .addComponent(btnBuscarClieServicio))
                .addGap(53, 53, 53)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(txtIdClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDniClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCategoraClieServicio))
                            .addComponent(txtNomApeClieServicio)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addComponent(txtTelefonoClieServicio)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCorreoClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(btnBuscarClieServicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarClieServicio)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txtNomApeClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(txtTelefonoClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58)
                            .addComponent(txtCorreoClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(txtIdClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(txtDniClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCategoraClieServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel55)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel26.setBackground(new java.awt.Color(131, 197, 179));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tblProdServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cantidad", "Costo Unit.", "Sub Total"
            }
        ));
        tblProdServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdServicioMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblProdServicio);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setText("ID Producto:");

        txtIdProdServicio.setEnabled(false);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("Cantidad:");

        btnAgregarProductoServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarProductoServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/insertar.png"))); // NOI18N
        btnAgregarProductoServicio.setText("Agregar");
        btnAgregarProductoServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarProductoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoServicioActionPerformed(evt);
            }
        });

        btnBuscarProductoServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarProductoServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarProductoServicio.setText("Buscar");
        btnBuscarProductoServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarProductoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoServicioActionPerformed(evt);
            }
        });

        txtCantidadProdServicio.setEnabled(false);
        txtCantidadProdServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadProdServicioKeyReleased(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("Costo Unit.:");

        txtTotalProdServicio.setEnabled(false);

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("Total");

        btnAñadirProdServicio.setText("Añadir Producto");
        btnAñadirProdServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirProdServicioActionPerformed(evt);
            }
        });

        btnEliminaProductoServicio.setText("Eliminar Producto");
        btnEliminaProductoServicio.setEnabled(false);
        btnEliminaProductoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaProductoServicioActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("SubTotal:");

        txtSubTotalProdServicio.setEnabled(false);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarProductoServicio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarProductoServicio, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtCostoUnitProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidadProdServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(txtSubTotalProdServicio)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addGap(26, 26, 26)
                        .addComponent(txtIdProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(btnAñadirProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminaProductoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel82)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(txtIdProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProductoServicio))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCostoUnitProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel81))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCantidadProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel80)))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarProductoServicio))))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubTotalProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83)
                    .addComponent(btnAñadirProdServicio)
                    .addComponent(btnEliminaProductoServicio)
                    .addComponent(jLabel82)
                    .addComponent(txtTotalProdServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel28.setBackground(new java.awt.Color(131, 197, 179));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria Servicio"));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("ID Categoria Servicio:");

        txtIdCatServServicio.setEnabled(false);

        txtCostoUnitCatServServicio.setEnabled(false);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("Costo Unit.:");

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("Cantidad:");

        txtCantidadCatServServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadCatServServicioKeyReleased(evt);
            }
        });

        txtSubTotalCatServServicio.setEnabled(false);

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("SubTotal:");

        tblCatServServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cantidad", "Costo Unit.", "Sub Total"
            }
        ));
        tblCatServServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCatServServicioMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblCatServServicio);

        btnAñadirCatServServicio.setText("Añadir Cat. Servicio");
        btnAñadirCatServServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirCatServServicioActionPerformed(evt);
            }
        });

        btnEliminaCatServServicio.setText("Eliminar Cat. Servicio");
        btnEliminaCatServServicio.setEnabled(false);
        btnEliminaCatServServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaCatServServicioActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("Total");

        txtTotalCatServServicio.setEnabled(false);

        btnBuscarCatServServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscarCatServServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscarCatServServicio.setText("Buscar");
        btnBuscarCatServServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarCatServServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCatServServicioActionPerformed(evt);
            }
        });

        btnAgregarCatServServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarCatServServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/insertar.png"))); // NOI18N
        btnAgregarCatServServicio.setText("Agregar");
        btnAgregarCatServServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarCatServServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCatServServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnBuscarCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgregarCatServServicio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCostoUnitCatServServicio)
                            .addComponent(txtIdCatServServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel87)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSubTotalCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCantidadCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(btnAñadirCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminaCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel88)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(txtIdCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCostoUnitCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel85))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidadCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel86)))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(txtSubTotalCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadirCatServServicio)
                    .addComponent(btnEliminaCatServServicio)
                    .addComponent(jLabel88)
                    .addComponent(txtTotalCatServServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnBuscarCatServServicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarCatServServicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGrabarServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGrabarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/agregar-contacto.png"))); // NOI18N
        btnGrabarServicio.setText("Grabar");
        btnGrabarServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGrabarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarServicioActionPerformed(evt);
            }
        });

        btnLimpiarServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/limpiar (1).png"))); // NOI18N
        btnLimpiarServicio.setText("Limpiar");
        btnLimpiarServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarServicioActionPerformed(evt);
            }
        });

        btnEliminarServicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminarServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/eliminar.png"))); // NOI18N
        btnEliminarServicio.setText("Eliminar");
        btnEliminarServicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarServicio.setEnabled(false);
        btnEliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServicioActionPerformed(evt);
            }
        });

        txtTotalServicio.setEnabled(false);

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Total Servicio");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(btnGrabarServicio)
                .addGap(68, 68, 68)
                .addComponent(btnLimpiarServicio)
                .addGap(50, 50, 50)
                .addComponent(btnEliminarServicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarServicio)
                    .addComponent(btnLimpiarServicio)
                    .addComponent(btnGrabarServicio)
                    .addComponent(jLabel89)
                    .addComponent(txtTotalServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(445, 445, 445))
        );

        TbPnlServicio.addTab("Registro", jPanel33);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TbPnlServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(TbPnlServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TbPnlProcesos.addTab("Servicio", jPanel7);

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));

        iconProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Provv.png"))); // NOI18N
        iconProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconProveedorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iconProveedorLayout = new javax.swing.GroupLayout(iconProveedor);
        iconProveedor.setLayout(iconProveedorLayout);
        iconProveedorLayout.setHorizontalGroup(
            iconProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );
        iconProveedorLayout.setVerticalGroup(
            iconProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        pnlMantenimientos.setBackground(new java.awt.Color(131, 197, 179));

        javax.swing.GroupLayout pnlMantenimientosLayout = new javax.swing.GroupLayout(pnlMantenimientos);
        pnlMantenimientos.setLayout(pnlMantenimientosLayout);
        pnlMantenimientosLayout.setHorizontalGroup(
            pnlMantenimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMantenimientosLayout.setVerticalGroup(
            pnlMantenimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );

        iconProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Prod.png"))); // NOI18N
        iconProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconProductoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iconProductoLayout = new javax.swing.GroupLayout(iconProducto);
        iconProducto.setLayout(iconProductoLayout);
        iconProductoLayout.setHorizontalGroup(
            iconProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );
        iconProductoLayout.setVerticalGroup(
            iconProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        iconCategoriaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cat-Prod.png"))); // NOI18N
        iconCategoriaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCategoriaProductoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iconCategoriaProductoLayout = new javax.swing.GroupLayout(iconCategoriaProducto);
        iconCategoriaProducto.setLayout(iconCategoriaProductoLayout);
        iconCategoriaProductoLayout.setHorizontalGroup(
            iconCategoriaProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        iconCategoriaProductoLayout.setVerticalGroup(
            iconCategoriaProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        iconEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Emplead.png"))); // NOI18N
        iconEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconEmpleadoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iconEmpleadoLayout = new javax.swing.GroupLayout(iconEmpleado);
        iconEmpleado.setLayout(iconEmpleadoLayout);
        iconEmpleadoLayout.setHorizontalGroup(
            iconEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );
        iconEmpleadoLayout.setVerticalGroup(
            iconEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        iconCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/Cli.png"))); // NOI18N
        iconCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconClienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iconClienteLayout = new javax.swing.GroupLayout(iconCliente);
        iconCliente.setLayout(iconClienteLayout);
        iconClienteLayout.setHorizontalGroup(
            iconClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );
        iconClienteLayout.setVerticalGroup(
            iconClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        iconCategoriaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/cat_cli.png"))); // NOI18N
        iconCategoriaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCategoriaClienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iconCategoriaClienteLayout = new javax.swing.GroupLayout(iconCategoriaCliente);
        iconCategoriaCliente.setLayout(iconCategoriaClienteLayout);
        iconCategoriaClienteLayout.setHorizontalGroup(
            iconCategoriaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );
        iconCategoriaClienteLayout.setVerticalGroup(
            iconCategoriaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        iconAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/alma.png"))); // NOI18N
        iconAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconAlmacenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iconAlmacenLayout = new javax.swing.GroupLayout(iconAlmacen);
        iconAlmacen.setLayout(iconAlmacenLayout);
        iconAlmacenLayout.setHorizontalGroup(
            iconAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );
        iconAlmacenLayout.setVerticalGroup(
            iconAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        iconCategoriaServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/logo.png"))); // NOI18N
        iconCategoriaServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconCategoriaServicioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout iconCategoriaServicioLayout = new javax.swing.GroupLayout(iconCategoriaServicio);
        iconCategoriaServicio.setLayout(iconCategoriaServicioLayout);
        iconCategoriaServicioLayout.setHorizontalGroup(
            iconCategoriaServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );
        iconCategoriaServicioLayout.setVerticalGroup(
            iconCategoriaServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(iconProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iconEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconCategoriaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iconCategoriaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(pnlMantenimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconCategoriaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iconCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iconProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iconProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(iconCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(iconEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(iconAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(iconCategoriaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addComponent(pnlMantenimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TbPnlProcesos.addTab("Mantenimientos", jPanel8);

        jPanel29.setBackground(new java.awt.Color(0, 52, 89));

        jPanel22.setBackground(new java.awt.Color(0, 109, 119));

        tblAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Almacén", "Descripción", "Ciudad", "Distrito", "Dirección", "Capacidad"
            }
        ));
        tblAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlmacenMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblAlmacen);

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Inventario", "ID Producto", "ID Almacén", "Cantidad Stock", "Fecha Actualización", "Minimo Stock"
            }
        ));
        jScrollPane9.setViewportView(tblInventario);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel45.setText("Buscar");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        jLabel46.setText("Buscar");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel45)
                .addGap(38, 38, 38)
                .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel46)
                .addGap(56, 56, 56)
                .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        TbPnlProcesos.addTab("Inventario", jPanel29);

        jPanel24.setBackground(new java.awt.Color(0, 52, 89));

        jPanel25.setBackground(new java.awt.Color(131, 197, 179));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnGeneraReporte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGeneraReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/reporte.png"))); // NOI18N
        btnGeneraReporte.setText("Generar Reporte");
        btnGeneraReporte.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGeneraReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneraReporteActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Tipo de Reporte");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Mantenimiento");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cmbMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(cmbTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btnGeneraReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel37)
                .addGap(236, 236, 236)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel37))
                .addGap(1, 1, 1)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGeneraReporte)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlReportes.setBackground(new java.awt.Color(131, 197, 179));

        javax.swing.GroupLayout pnlReportesLayout = new javax.swing.GroupLayout(pnlReportes);
        pnlReportes.setLayout(pnlReportesLayout);
        pnlReportesLayout.setHorizontalGroup(
            pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlReportesLayout.setVerticalGroup(
            pnlReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        TbPnlProcesos.addTab("Reportes", jPanel24);

        pnlUsuario.setBackground(new java.awt.Color(0, 109, 119));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("PESTAÑA USUARIO");

        jPanel2.setBackground(new java.awt.Color(131, 197, 179));

        txtIdEmpleadoUsuario.setEnabled(false);

        txtIdUsuario.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Contraseña");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Usuario");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("ID Empleado");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("ID Usuario");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Usuario Registro");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Fecha Registro");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Usuario Modificación");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Fecha Modificación");

        txtFechMod.setEnabled(false);

        txtUsuReg.setEnabled(false);

        txtFechReg.setEnabled(false);

        txtUsuMod.setEnabled(false);

        btnBuscaEmpleado.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnBuscaEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btnBuscaEmpleado.setText("Buscar");
        btnBuscaEmpleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaEmpleadoActionPerformed(evt);
            }
        });

        btnGrabarUsuario.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnGrabarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/agregar-contacto.png"))); // NOI18N
        btnGrabarUsuario.setText("Grabar");
        btnGrabarUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGrabarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/eliminar.png"))); // NOI18N
        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.setEnabled(false);
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnEditarUsuario.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/insertar.png"))); // NOI18N
        btnEditarUsuario.setText("Editar");
        btnEditarUsuario.setEnabled(false);
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnVerContraseñaUsuario.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btnVerContraseñaUsuario.setText("Ver");
        btnVerContraseñaUsuario.setFocusable(false);
        btnVerContraseñaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerContraseñaUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuario)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdEmpleadoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscaEmpleado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechReg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechMod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(47, 47, 47)
                        .addComponent(txtUsuReg, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(btnGrabarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txtUsuReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txtFechReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel49))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtUsuMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(txtFechMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdEmpleadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)
                            .addComponent(btnBuscaEmpleado))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerContraseñaUsuario))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabarUsuario)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pnlUsuarioDatos.setBackground(new java.awt.Color(131, 197, 179));

        tblUsuario.setBackground(new java.awt.Color(204, 204, 255));
        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "ID Empleado", "Usuario", "Usuario Registro", "Fecha Registro", "Usuario Modificación", "Fecha Modificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblUsuario);

        javax.swing.GroupLayout pnlUsuarioDatosLayout = new javax.swing.GroupLayout(pnlUsuarioDatos);
        pnlUsuarioDatos.setLayout(pnlUsuarioDatosLayout);
        pnlUsuarioDatosLayout.setHorizontalGroup(
            pnlUsuarioDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioDatosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlUsuarioDatosLayout.setVerticalGroup(
            pnlUsuarioDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioDatosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUsuarioLayout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel62))
                    .addGroup(pnlUsuarioLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlUsuarioDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel62)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pnlUsuarioDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        TbPnlProcesos.addTab("Usuarios", pnlUsuario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TbPnlProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(TbPnlProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconCategoriaServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCategoriaServicioMouseClicked
        FrmCategoriaServicio FrmCatClie = new FrmCategoriaServicio();
        this.pnlMantenimientos.add(FrmCatClie);
        FrmCatClie.setVisible(true);
        FrmCatClie.setLocation((pnlMantenimientos.getWidth() - FrmCatClie.getWidth())/2, (pnlMantenimientos.getHeight()- FrmCatClie.getHeight())/2);
    }//GEN-LAST:event_iconCategoriaServicioMouseClicked

    private void iconAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconAlmacenMouseClicked
        FrmAlmacen FrmAlm = new FrmAlmacen();
        this.pnlMantenimientos.add(FrmAlm);
        FrmAlm.setVisible(true);
        FrmAlm.setLocation((pnlMantenimientos.getWidth() - FrmAlm.getWidth())/2, (pnlMantenimientos.getHeight()- FrmAlm.getHeight())/2);
    }//GEN-LAST:event_iconAlmacenMouseClicked

    private void iconCategoriaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCategoriaClienteMouseClicked
        FrmCatCliente FrmCatClie = new FrmCatCliente();
        this.pnlMantenimientos.add(FrmCatClie);
        FrmCatClie.setVisible(true);
        FrmCatClie.setLocation((pnlMantenimientos.getWidth() - FrmCatClie.getWidth())/2, (pnlMantenimientos.getHeight()- FrmCatClie.getHeight())/2);
    }//GEN-LAST:event_iconCategoriaClienteMouseClicked

    private void iconClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconClienteMouseClicked
        FrmCliente FrmClie = new FrmCliente();
        this.pnlMantenimientos.add(FrmClie);
        FrmClie.setVisible(true);
        FrmClie.setLocation((pnlMantenimientos.getWidth() - FrmClie.getWidth())/2, (pnlMantenimientos.getHeight()- FrmClie.getHeight())/2);
    }//GEN-LAST:event_iconClienteMouseClicked

    private void iconEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconEmpleadoMouseClicked
        FrmEmpleado FrmEmp = new FrmEmpleado();
        this.pnlMantenimientos.add(FrmEmp);
        FrmEmp.setVisible(true);
        FrmEmp.setLocation((pnlMantenimientos.getWidth() - FrmEmp.getWidth())/2, (pnlMantenimientos.getHeight()- FrmEmp.getHeight())/2);
    }//GEN-LAST:event_iconEmpleadoMouseClicked

    private void iconCategoriaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconCategoriaProductoMouseClicked
        FrmCategoria_producto FrmCatProd = new FrmCategoria_producto();
        this.pnlMantenimientos.add(FrmCatProd);
        FrmCatProd.setVisible(true);
        FrmCatProd.setLocation((pnlMantenimientos.getWidth() - FrmCatProd.getWidth())/2, (pnlMantenimientos.getHeight()- FrmCatProd.getHeight())/2);
    }//GEN-LAST:event_iconCategoriaProductoMouseClicked

    private void iconProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconProductoMouseClicked
        FrmProducto FrmProd = new FrmProducto();
        this.pnlMantenimientos.add(FrmProd);
        FrmProd.setVisible(true);
        FrmProd.setLocation((pnlMantenimientos.getWidth() - FrmProd.getWidth())/2, (pnlMantenimientos.getHeight()- FrmProd.getHeight())/2);
    }//GEN-LAST:event_iconProductoMouseClicked

    private void iconProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconProveedorMouseClicked
        FrmProveedor FrmProv = new FrmProveedor();
        this.pnlMantenimientos.add(FrmProv);
        FrmProv.setVisible(true);
        FrmProv.setLocation((pnlMantenimientos.getWidth() - FrmProv.getWidth())/2, (pnlMantenimientos.getHeight()- FrmProv.getHeight())/2);
    }//GEN-LAST:event_iconProveedorMouseClicked
    // VENTAS****************************************************************************
    private void btnLimpiarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarVentaActionPerformed
        limpiarVenta();
    }//GEN-LAST:event_btnLimpiarVentaActionPerformed

    private void btnGrabarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarVentaActionPerformed
        if(validaVenta()){
            Venta vent = new Venta();
            DetVenta detVent = new DetVenta();

            // Registrando Compra
            vent.setIdVenta(Integer.parseInt(this.txtIdVenta.getText()));
            if(this.cmbEstadoVenta.getSelectedItem().equals("Pendiente")){
                vent.setFechaVenta("1000-01-01");
            }else{
                vent.setFechaVenta(this.txtAñoVenta.getText() + "-" + this.txtMesVenta.getText() + "-" + this.txtDiaVenta.getText());
            }
            vent.setIdEmpleado(Integer.parseInt(this.txtIdEmpleadoVenta.getText()));
            vent.setIdCliente(Integer.parseInt(this.txtIdClieVenta.getText()));
            vent.setTotalVenta(Float.parseFloat(this.txtTotalVenta.getText()));
            vent.setObservacion(this.txtObservacionesVenta.getText());
            if(this.cmbEstadoCompra.getSelectedItem().equals("Pendiente")){
                vent.setEstado(0); // pendiente
            }else{
                vent.setEstado(1); // entregada
            }
            if(this.cmbTipoPagoCompra.getSelectedItem().equals("Efectivo")){
                vent.setTipoPago(0); // efectivo
            }else if(this.cmbTipoPagoCompra.getSelectedItem().equals("Visa")){
                vent.setTipoPago(1); // visa o tarjeta
            }else{
                vent.setTipoPago(2); // Yape o plin
            }
            vent.setIdAlmacen(Integer.parseInt(this.txtIdAlmacenVenta.getText()));

            if(this.btnGrabarVenta.getText().equals("Grabar")){
                ventDao.insertaVenta(vent);
            }else{
                ventDao.actualizaVenta(vent);
            }
            // Registrando Detalle Compra
            for(int i=0; i<dtmProdVenta.getRowCount(); i++){
                detVent.setIdDetalleVenta(util.idNext("DetalleVenta", "IdDetalleVenta"));
                detVent.setIdVenta(Integer.parseInt(this.txtIdVenta.getText()));
                detVent.setIdProducto(Integer.parseInt(this.dtmProdVenta.getValueAt(i, 0).toString()));
                detVent.setCantidadProducto(Integer.parseInt(this.dtmProdVenta.getValueAt(i, 2).toString()));
                detVent.setCostoUnitario(Float.parseFloat(this.dtmProdVenta.getValueAt(i, 3).toString()));
                detVent.setSubTotal(Float.parseFloat(this.dtmProdVenta.getValueAt(i, 4).toString()));
                // Actualiza o añade inventario
                Inventario inv = new Inventario();
                inv.setIdInventario(util.idNext("Inventario", "IdInventario"));
                inv.setIdProducto(Integer.parseInt(this.txtIdProdVenta.getText()));
                inv.setIdAlmacen(Integer.parseInt(this.txtIdAlmacenVenta.getText()));
                inv.setCantidadStock(Integer.parseInt(this.txtCantidadProdVenta.getText()));
                inv.setMinimoStock(Integer.parseInt(this.txtCantidadProdVenta.getText()));
                inv.setFechaActualizacion(util.obtenerFecha().substring(0, 10));
                invDao.actualizaInventario(inv, "Venta");
                if(this.btnGrabarVenta.getText().equals("Grabar")){
                    detVentDao.insertaDetalleVenta(detVent);
                }else{
                    detVentDao.actualizaDetalleVenta(detVent);
                }
                
            }
            limpiarVenta();
        }
    }//GEN-LAST:event_btnGrabarVentaActionPerformed

    private void cmbEstadoVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoVentaItemStateChanged
        if(this.cmbEstadoVenta.getSelectedItem().equals("Entregada")){
            String fecha = util.obtenerFecha();
            this.txtDiaVenta.setText(fecha.substring(8,10));
            this.txtMesVenta.setText(fecha.substring(5,7));
            this.txtAñoVenta.setText(fecha.substring(0,4));
        }else{
            this.txtDiaVenta.setText("");
            this.txtMesVenta.setText("");
            this.txtAñoVenta.setText("");
        }
    }//GEN-LAST:event_cmbEstadoVentaItemStateChanged

    private void btnEliminaProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaProductoVentaActionPerformed
        if(this.dtmProdVenta.getRowCount() != 0){
            int fila = this.tblProdVenta.getSelectedRow();
            float subtotal = Float.parseFloat(this.dtmProdVenta.getValueAt(fila, 3).toString());
            float total = Float.parseFloat(this.txtTotalVenta.getText()) - subtotal;
            this.txtTotalVenta.setText(String.valueOf(total));
            this.dtmProdVenta.removeRow(fila);
            this.btnEliminaProductoVenta.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this, "Ingresa datos en Productos");
        }
    }//GEN-LAST:event_btnEliminaProductoVentaActionPerformed

    private void btnAñadirProdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProdVentaActionPerformed
        if(validaProdVenta()){
            Vector vec = new Vector();
            vec.add(this.txtIdProdVenta.getText());
            vec.add(this.txtCantidadProdVenta.getText());
            vec.add(this.txtCostoUnitProdVenta.getText());
            vec.add(this.txtSubTotalVenta.getText());
            dtmProdVenta.addRow(vec);
            float subtotal = Float.parseFloat(this.txtSubTotalVenta.getText());
            float total = Float.parseFloat(this.txtTotalVenta.getText()) + subtotal;
            this.txtTotalVenta.setText(String.valueOf(total));
            limpiarProdVenta();
        }
    }//GEN-LAST:event_btnAñadirProdVentaActionPerformed

    private void txtCantidadProdVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProdVentaKeyReleased
        if(this.txtCantidadProdVenta.getText().equals("") || this.txtCostoUnitProdVenta.getText().equals("")){
            this.txtSubTotalVenta.setText("0");
        }else{
            int cant = Integer.parseInt(this.txtCantidadProdVenta.getText());
            Float costUnit = Float.parseFloat(this.txtCostoUnitProdVenta.getText());
            Float resul = cant * costUnit;
            this.txtSubTotalVenta.setText(String.valueOf(resul));
        }
    }//GEN-LAST:event_txtCantidadProdVentaKeyReleased

    private void btnBuscarProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoVentaActionPerformed
        Producto prod;
        SelecProducto dialog = new SelecProducto(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        prod = dialog.devuelveProducto();
        this.txtIdProdVenta.setText(String.valueOf(prod.getIdProducto()));
        this.txtCostoUnitProdVenta.setText(String.valueOf(prod.getCostoUnitario()));
    }//GEN-LAST:event_btnBuscarProductoVentaActionPerformed

    private void btnAgregarProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoVentaActionPerformed
        this.TbPnlProcesos.setSelectedIndex(3);
    }//GEN-LAST:event_btnAgregarProductoVentaActionPerformed

    private void tblProdVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdVentaMouseClicked
        int fila = this.tblProdVenta.getSelectedRow();
        this.txtIdProdVenta.setText(this.tblProdVenta.getValueAt(fila, 0).toString());
        this.txtCantidadProdVenta.setText(this.tblProdVenta.getValueAt(fila, 1).toString());
        this.txtCostoUnitProdVenta.setText(this.tblProdVenta.getValueAt(fila, 2).toString());
        this.txtSubTotalVenta.setText(this.tblProdVenta.getValueAt(fila, 3).toString());
        this.btnEliminaProductoVenta.setEnabled(true);
    }//GEN-LAST:event_tblProdVentaMouseClicked

    private void btnAgregarClieVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClieVentaActionPerformed
        this.TbPnlProcesos.setSelectedIndex(3);
    }//GEN-LAST:event_btnAgregarClieVentaActionPerformed

    private void btnBuscarClieVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClieVentaActionPerformed
        Cliente clie;
        SelecCliente dialog = new SelecCliente(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        clie = dialog.devuelveCliente();
        this.txtIdClieVenta.setText(String.valueOf(clie.getIdCliente()));
        this.txtIdCategoraClieVenta.setText(String.valueOf(clie.getIdCategoria()));
        this.txtDniClieVenta.setText(String.valueOf(clie.getDocCliente()));
        this.txtNomApeClieVenta.setText(clie.getNombCliente()+ ", " +clie.getApellCliente());
        this.txtTelefonoClieVenta.setText(String.valueOf(clie.getTelefono()));
        this.txtCorreoClieVenta.setText(clie.getCorreo());
    }//GEN-LAST:event_btnBuscarClieVentaActionPerformed

    private void txtBuscarVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarVentaKeyReleased
        if(this.txtBuscarVenta.getText().equals("")){
            llenarTblOrdenVenta(false, "", "");
        }else{
            String camp = "", cad = "";
            switch(this.cmbOrdenVenta.getSelectedItem().toString()){
                case "ID Venta":    camp = "IdVenta";   break;
                case "ID Empleado":    camp = "IdEmpleado";   break;
                case "ID Cliente":    camp = "IdCliente";   break;
                case "Observación":    camp = "Observación";   break;
                case "Estado":          camp = "Estado";   break;
                case "Tipo de Pago":    camp = "TipoPago";   break;
            }
            if(camp.equals("Estado")){
                if(this.txtBuscarVenta.getText().equals("P")){
                    cad = "0";
                }else if(this.txtBuscarVenta.getText().equals("E")){
                    cad = "1";
                }
                llenarTblOrdenVenta(true, cad, camp);
            }else if(camp.equals("TipoPago")){
                if(this.txtBuscarVenta.getText().equals("E")){
                    cad = "0";
                }else if(this.txtBuscarVenta.getText().equals("V")){
                    cad = "1";
                }else if(this.txtBuscarVenta.getText().equals("Y")){
                    cad = "2";
                }
                llenarTblOrdenVenta(true, cad, camp);
            }else{
                llenarTblOrdenVenta(true, this.txtBuscarVenta.getText(), camp);
            }
        }
    }//GEN-LAST:event_txtBuscarVentaKeyReleased

    private void tblOrdenVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdenVentaMouseClicked
        int fila = this.tblOrdenVenta.getSelectedRow();
        this.txtIdVenta.setText(this.dtmOrdenVenta.getValueAt(fila, 0).toString());
        this.txtIdEmpleadoVenta.setText(this.dtmOrdenVenta.getValueAt(fila, 1).toString());
        Cliente clie = clieDao.BuscarCliente(Integer.parseInt(this.dtmOrdenVenta.getValueAt(fila, 2).toString()));
        this.txtIdClieVenta.setText(String.valueOf(clie.getIdCliente()));
        this.txtIdCategoraClieVenta.setText(String.valueOf(clie.getIdCategoria()));
        this.txtNomApeClieVenta.setText(clie.getNombCliente() + ", " +clie.getApellCliente());
        this.txtDniClieVenta.setText(String.valueOf(clie.getDocCliente()));
        this.txtTelefonoClieVenta.setText(String.valueOf(clie.getTelefono()));
        this.txtCorreoClieVenta.setText(clie.getCorreo());

        this.txtDiaVenta.setText(this.dtmOrdenVenta.getValueAt(fila, 3).toString().substring(8, 10));
        this.txtMesVenta.setText(this.dtmOrdenVenta.getValueAt(fila, 3).toString().substring(5, 7));
        this.txtAñoVenta.setText(this.dtmOrdenVenta.getValueAt(fila, 3).toString().substring(0, 4));

        this.txtTotalVenta.setText(this.dtmOrdenVenta.getValueAt(fila, 4).toString());
        this.txtObservacionesVenta.setText(this.dtmOrdenVenta.getValueAt(fila, 5).toString().trim());
        this.cmbEstadoVenta.setSelectedItem(this.dtmOrdenVenta.getValueAt(fila, 6).toString());
        this.cmbTipoPagoVenta.setSelectedItem(this.dtmOrdenVenta.getValueAt(fila, 7).toString());
        this.txtIdAlmacenVenta.setText(this.dtmOrdenVenta.getValueAt(fila, 8).toString());
        this.btnEliminarVenta.setEnabled(true);

        Vector <DetVenta> listaDetVent = new Vector<DetVenta>();
        listaDetVent = detVentDao.listaDetalleVenta(true, txtIdVenta.getText(), "IdVenta");
        this.dtmProdVenta.setRowCount(0);
        for(int i=0; i<listaDetVent.size(); i++){
            Vector vec = new Vector();
            vec.add(listaDetVent.get(i).getIdProducto());
            vec.add(listaDetVent.get(i).getCantidadProducto());
            vec.add(listaDetVent.get(i).getCostoUnitario());
            vec.add(listaDetVent.get(i).getSubTotal());
            dtmProdVenta.addRow(vec);
        }
        this.TbPnlVenta.setSelectedIndex(1);
        this.btnGrabarVenta.setText("Actualiza");
    }//GEN-LAST:event_tblOrdenVentaMouseClicked

    private void txtBuscarClienteVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteVentaKeyReleased
        if(this.txtBuscarClienteVenta.getText().equals("")){
            llenarTblClienteVenta(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbClienteVenta.getSelectedItem().toString()){
                case "ID Cliente":    camp = "IdCliente";   break;
                case "Nomb. y Apell.":    camp = "NombCliente like " + this.txtBuscarClienteVenta.getText() +  " or ApellCliente ";   break;
                case "Categoría":    camp = "IdCategoriaCliente";   break;
                case "DNI":    camp = "DocCliente";   break;
                case "Telefono":    camp = "Telefono";   break;
                case "Correo":    camp = "Correo";   break;
            }
            llenarTblClienteVenta(true, this.txtBuscarClienteVenta.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarClienteVentaKeyReleased

    private void tblClienteVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteVentaMouseClicked
        int fila = this.tblClienteVenta.getSelectedRow();
        llenarTblOrdenVenta(true, this.dtmClieVenta.getValueAt(fila, 0).toString(), "IdCliente");
    }//GEN-LAST:event_tblClienteVentaMouseClicked

    // COMPRAS****************************************************************************
    private void TbPnlCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPnlCompraMouseClicked
        String fecha = util.obtenerFecha();
        this.txtDiaCompra.setText(fecha.substring(8,10));
        this.txtMesCompra.setText(fecha.substring(5,7));
        this.txtAñoCompra.setText(fecha.substring(0,4));
    }//GEN-LAST:event_TbPnlCompraMouseClicked

    private void btnLimpiarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCompraActionPerformed
        limpiarCompra();
    }//GEN-LAST:event_btnLimpiarCompraActionPerformed

    private void btnGrabarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarCompraActionPerformed
        if(validaCompra()){
            Compra comp = new Compra();
            DetCompra detComp = new DetCompra();

            // Registrando Compra
            comp.setIdCompra(Integer.parseInt(this.txtIdCompra.getText()));
            if(this.cmbEstadoCompra.getSelectedItem().equals("Pendiente")){
                comp.setFechaEntrega("1000-01-01");
            }else{
                comp.setFechaEntrega(this.txtAñoEntregaCompra.getText() + "-" + this.txtMesEntregaCompra.getText() + "-" + this.txtDiaEntregaCompra.getText());
            }
            comp.setIdEmpleado(Integer.parseInt(this.txtIdEmpleadoCompra.getText()));
            comp.setIdProveedor(Integer.parseInt(this.txtIdProvCompra.getText()));
            comp.setFechaCompra(this.txtAñoCompra.getText() + "-" + this.txtMesCompra.getText() + "-" + this.txtDiaCompra.getText());
            comp.setTotalCompra(Float.parseFloat(this.txtTotalCompra.getText()));
            comp.setObservacion(this.txtObservacionesCompra.getText());
            if(this.cmbEstadoCompra.getSelectedItem().equals("Pendiente")){
                comp.setEstado(0); // pendiente
            }else{
                comp.setEstado(1); // entregada
            }
            if(this.cmbTipoPagoCompra.getSelectedItem().equals("Efectivo")){
                comp.setTipoPago(0); // efectivo
            }else if(this.cmbTipoPagoCompra.getSelectedItem().equals("Visa")){
                comp.setTipoPago(1); // visa o tarjeta
            }else{
                comp.setTipoPago(2); // Yape o plin
            }
            comp.setIdAlmacen(Integer.parseInt(this.txtIdAlmacenCompra.getText()));
            
            if(this.btnGrabarCompra.getText().equals("Grabar")){
                compDao.insertaCompra(comp);
            }else{
                compDao.actualizaCompra(comp);
            }
            // Registrando Detalle Compra
            for(int i=0; i<dtmProdCompra.getRowCount(); i++){
                detComp.setIdDetalleCompra(util.idNext("DetalleCompra", "IdDetalleCompra"));
                detComp.setIdCompra(Integer.parseInt(this.txtIdCompra.getText()));
                detComp.setIdProducto(Integer.parseInt(this.dtmProdCompra.getValueAt(i, 0).toString()));
                detComp.setCantidadProducto(Integer.parseInt(this.dtmProdCompra.getValueAt(i, 1).toString()));
                detComp.setCostoUnitario(Float.parseFloat(this.dtmProdCompra.getValueAt(i, 2).toString()));
                detComp.setSubtotal(Float.parseFloat(this.dtmProdCompra.getValueAt(i, 3).toString()));

                // Actualiza o añade inventario
                Inventario inv = new Inventario();
                inv.setIdInventario(util.idNext("Inventario", "IdInventario"));
                inv.setIdProducto(Integer.parseInt(this.txtIdProdCompra.getText()));
                inv.setIdAlmacen(Integer.parseInt(this.txtIdAlmacenCompra.getText()));
                inv.setCantidadStock(Integer.parseInt(this.txtCantidadProdCompra.getText()));
                inv.setMinimoStock(Integer.parseInt(this.txtCantidadProdCompra.getText()));
                inv.setFechaActualizacion(util.obtenerFecha().substring(0, 10));
                invDao.actualizaInventario(inv, "Compra");
                if(this.btnGrabarCompra.getText().equals("Grabar")){
                    detCompDao.insertaDetCompra(detComp);
                }else{
                    detCompDao.actualizaDetCompra(detComp);
                }
            }
            limpiarCompra();
        }
    }//GEN-LAST:event_btnGrabarCompraActionPerformed

    private void cmbEstadoCompraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoCompraItemStateChanged
        if(this.cmbEstadoCompra.getSelectedItem().equals("Entregada")){
            String fecha = util.obtenerFecha();
            this.txtDiaEntregaCompra.setText(fecha.substring(8,10));
            this.txtMesEntregaCompra.setText(fecha.substring(5,7));
            this.txtAñoEntregaCompra.setText(fecha.substring(0,4));
        }else{
            this.txtDiaEntregaCompra.setText("");
            this.txtMesEntregaCompra.setText("");
            this.txtAñoEntregaCompra.setText("");
        }
    }//GEN-LAST:event_cmbEstadoCompraItemStateChanged

    private void btnEliminaProductoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaProductoCompraActionPerformed
        if(this.dtmProdCompra.getRowCount() != 0){
            int fila = this.tblProdCompra.getSelectedRow();
            float subtotal = Float.parseFloat(this.dtmProdCompra.getValueAt(fila, 3).toString());
            float total = Float.parseFloat(this.txtTotalCompra.getText()) - subtotal;
            this.txtTotalCompra.setText(String.valueOf(total));
            this.dtmProdCompra.removeRow(fila);
            this.btnEliminaProductoCompra.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(this, "Ingresa datos en Productos");
        }
    }//GEN-LAST:event_btnEliminaProductoCompraActionPerformed

    private void btnAñadirProdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProdCompraActionPerformed
        if(validaProdCompra()){
            Vector vec = new Vector();
            vec.add(this.txtIdProdCompra.getText());
            vec.add(this.txtCantidadProdCompra.getText());
            vec.add(this.txtCostoUnitProdCompra.getText());
            vec.add(this.txtSubTotalCompra.getText());
            dtmProdCompra.addRow(vec);
            float subtotal = Float.parseFloat(this.txtSubTotalCompra.getText());
            float total = Float.parseFloat(this.txtTotalCompra.getText()) + subtotal;
            this.txtTotalCompra.setText(String.valueOf(total));
            limpiarProdCompra();
        }
    }//GEN-LAST:event_btnAñadirProdCompraActionPerformed

    private void txtCantidadProdCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProdCompraKeyReleased
        if(this.txtCantidadProdCompra.getText().equals("") || this.txtCostoUnitProdCompra.getText().equals("")){
            this.txtSubTotalCompra.setText("0");
        }else{
            int cant = Integer.parseInt(this.txtCantidadProdCompra.getText());
            float costUnit = Float.parseFloat(this.txtCostoUnitProdCompra.getText());
            float resul = cant * costUnit;
            this.txtSubTotalCompra.setText(String.valueOf(resul));
        }
    }//GEN-LAST:event_txtCantidadProdCompraKeyReleased

    private void btnBuscarProdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdCompraActionPerformed
        Producto prod;
        SelecProducto dialog = new SelecProducto(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        prod = dialog.devuelveProducto();
        this.txtIdProdCompra.setText(String.valueOf(prod.getIdProducto()));
        this.txtCostoUnitProdCompra.setText(String.valueOf(prod.getCostoUnitario()));
    }//GEN-LAST:event_btnBuscarProdCompraActionPerformed

    private void btnAgregarProdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdCompraActionPerformed
        this.TbPnlProcesos.setSelectedIndex(3);
    }//GEN-LAST:event_btnAgregarProdCompraActionPerformed

    private void tblProdCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdCompraMouseClicked
        int fila = this.tblProdCompra.getSelectedRow();
        this.txtIdProdCompra.setText(this.dtmProdCompra.getValueAt(fila, 0).toString());
        this.txtCantidadProdCompra.setText(this.dtmProdCompra.getValueAt(fila, 1).toString());
        this.txtCostoUnitProdCompra.setText(this.dtmProdCompra.getValueAt(fila, 2).toString());
        this.txtSubTotalCompra.setText(this.dtmProdCompra.getValueAt(fila, 3).toString());
        this.btnEliminaProductoCompra.setEnabled(true);
    }//GEN-LAST:event_tblProdCompraMouseClicked

    private void btnAgregarProvCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProvCompraActionPerformed
        this.TbPnlProcesos.setSelectedIndex(3);
    }//GEN-LAST:event_btnAgregarProvCompraActionPerformed

    private void btnBuscarProvCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProvCompraActionPerformed
        Proveedor prov;
        SelecProveedor dialog = new SelecProveedor(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        prov = dialog.devuelveProveedor();
        this.txtIdProvCompra.setText(String.valueOf(prov.getIdProveedor()));
        this.txtRucProvCompra.setText(String.valueOf(prov.getRUC()));
        this.txtNombreProvCompra.setText(prov.getNombre());
        this.txtTelefonoProvCompra.setText(String.valueOf(prov.getTelefono()));
        this.txtCorreoProvCompra.setText(prov.getCorreo());
        this.txtDireccionProvCompra.setText(prov.getDirección());
    }//GEN-LAST:event_btnBuscarProvCompraActionPerformed

    private void txtBuscarCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCompraKeyReleased
        if(this.txtBuscarCompra.getText().equals("")){
            llenarTblOrdenCompra(false, "", "");
        }else{
            String camp = "", cad = "";
            switch(this.cmbOrdenCompra.getSelectedItem().toString()){
                case "ID Compra":    camp = "IdCompra";   break;
                case "ID Empleado":    camp = "IdEmpleado";   break;
                case "ID Proveedor":    camp = "IdProveedor";   break;
                case "Observación":    camp = "Observación";   break;
                case "Estado":          camp = "Estado";   break;
                case "Tipo de Pago":    camp = "TipoPago";   break;
            }
            if(camp.equals("Estado")){
                if(this.txtBuscarCompra.getText().equals("P")){
                    cad = "0";
                }else if(this.txtBuscarCompra.getText().equals("E")){
                    cad = "1";
                }
                llenarTblOrdenCompra(true, cad, camp);
            }else if(camp.equals("TipoPago")){
                if(this.txtBuscarCompra.getText().equals("E")){
                    cad = "0";
                }else if(this.txtBuscarCompra.getText().equals("V")){
                    cad = "1";
                }else if(this.txtBuscarCompra.getText().equals("Y")){
                    cad = "2";
                }
                llenarTblOrdenCompra(true, cad, camp);
            }else{
                llenarTblOrdenCompra(true, this.txtBuscarCompra.getText(), camp);
            }
        }
    }//GEN-LAST:event_txtBuscarCompraKeyReleased

    private void tblOrdenCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdenCompraMouseClicked
        int fila = this.tblOrdenCompra.getSelectedRow();
        this.txtIdCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 0).toString());
        this.txtIdEmpleadoCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 1).toString());
        Proveedor prov = provDao.BuscarProveedor(Integer.parseInt(this.dtmOrdenCompra.getValueAt(fila, 2).toString()));
        this.txtIdProvCompra.setText(String.valueOf(prov.getIdProveedor()));
        this.txtRucProvCompra.setText(String.valueOf(prov.getRUC()));
        this.txtNombreProvCompra.setText(prov.getNombre());
        this.txtTelefonoProvCompra.setText(String.valueOf(prov.getIdProveedor()));
        this.txtCorreoProvCompra.setText(prov.getCorreo());
        this.txtDireccionProvCompra.setText(prov.getDirección());

        this.txtDiaCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 3).toString().substring(8, 10));
        this.txtMesCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 3).toString().substring(5, 7));
        this.txtAñoCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 3).toString().substring(0, 4));
        this.txtDiaEntregaCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 4).toString().substring(8, 10));
        this.txtMesEntregaCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 4).toString().substring(5, 7));
        this.txtAñoEntregaCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 4).toString().substring(0, 4));

        this.txtTotalCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 5).toString());
        this.txtObservacionesCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 6).toString().trim());
        this.cmbEstadoCompra.setSelectedItem(this.dtmOrdenCompra.getValueAt(fila, 7).toString());
        this.cmbTipoPagoCompra.setSelectedItem(this.dtmOrdenCompra.getValueAt(fila, 8).toString());
        this.txtIdAlmacenCompra.setText(this.dtmOrdenCompra.getValueAt(fila, 9).toString());
        this.btnEliminarCompra.setEnabled(true);

        Vector <DetCompra> listaDetComp = new Vector<DetCompra>();
        listaDetComp = detCompDao.listaDetCompra(true, txtIdCompra.getText(), "IdCompra");
        this.dtmProdCompra.setRowCount(0);
        for(int i=0; i<listaDetComp.size(); i++){
            Vector vec = new Vector();
            vec.add(listaDetComp.get(i).getIdProducto());
            vec.add(listaDetComp.get(i).getCantidadProducto());
            vec.add(listaDetComp.get(i).getCostoUnitario());
            vec.add(listaDetComp.get(i).getSubtotal());
            dtmProdCompra.addRow(vec);
        }
        this.TbPnlCompra.setSelectedIndex(1);
        this.btnGrabarCompra.setText("Actualiza");
    }//GEN-LAST:event_tblOrdenCompraMouseClicked

    private void txtBuscarProveedorCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProveedorCompraKeyReleased
        if(this.txtBuscarProveedorCompra.getText().equals("")){
            llenarTblProveedorCompra(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbProveedorCompra.getSelectedItem().toString()){
                case "ID Proveedor":    camp = "IdProveedor";   break;
                default: camp = this.cmbProveedorCompra.getSelectedItem().toString();
            }
            llenarTblProveedorCompra(true, this.txtBuscarProveedorCompra.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarProveedorCompraKeyReleased

    private void tblProveedorCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorCompraMouseClicked
        int fila = this.tblProveedorCompra.getSelectedRow();
        llenarTblOrdenCompra(true, this.dtmProvCompra.getValueAt(fila, 0).toString(), "IdProveedor");
    }//GEN-LAST:event_tblProveedorCompraMouseClicked
    // SERVICIOS****************************************************************************
    private void btnBuscarClieServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClieServicioActionPerformed
        Cliente clie;
        SelecCliente dialog = new SelecCliente(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        clie = dialog.devuelveCliente();
        this.txtIdClieServicio.setText(String.valueOf(clie.getIdCliente()));
        this.txtIdCategoraClieServicio.setText(String.valueOf(clie.getIdCategoria()));
        this.txtDniClieServicio.setText(String.valueOf(clie.getDocCliente()));
        this.txtNomApeClieServicio.setText(clie.getNombCliente()+ ", " +clie.getApellCliente());
        this.txtTelefonoClieServicio.setText(String.valueOf(clie.getTelefono()));
        this.txtCorreoClieServicio.setText(clie.getCorreo());
    }//GEN-LAST:event_btnBuscarClieServicioActionPerformed

    private void btnAgregarClieServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClieServicioActionPerformed
        this.TbPnlProcesos.setSelectedIndex(3);
    }//GEN-LAST:event_btnAgregarClieServicioActionPerformed

    private void tblProdServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdServicioMouseClicked
        int fila = this.tblProdServicio.getSelectedRow();
        this.txtIdProdServicio.setText(this.dtmProdServicio.getValueAt(fila, 0).toString());
        this.txtCantidadProdServicio.setText(this.dtmProdServicio.getValueAt(fila, 1).toString());
        this.txtCostoUnitProdServicio.setText(this.dtmProdServicio.getValueAt(fila, 2).toString());
        this.txtSubTotalProdServicio.setText(this.dtmProdServicio.getValueAt(fila, 3).toString());
        this.btnEliminaProductoServicio.setEnabled(true);
    }//GEN-LAST:event_tblProdServicioMouseClicked

    private void btnAgregarProductoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoServicioActionPerformed
        this.TbPnlProcesos.setSelectedIndex(3);
    }//GEN-LAST:event_btnAgregarProductoServicioActionPerformed

    private void btnBuscarProductoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoServicioActionPerformed
        Producto prod;
        SelecProducto dialog = new SelecProducto(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        prod = dialog.devuelveProducto();
        this.txtIdProdServicio.setText(String.valueOf(prod.getIdProducto()));
        this.txtCostoUnitProdServicio.setText(String.valueOf(prod.getCostoUnitario()));
    }//GEN-LAST:event_btnBuscarProductoServicioActionPerformed

    private void txtCantidadProdServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProdServicioKeyReleased
        if(this.txtCantidadProdServicio.getText().equals("") || this.txtCostoUnitProdServicio.getText().equals("")){
            this.txtSubTotalProdServicio.setText("0");
        }else{
            int cant = Integer.parseInt(this.txtCantidadProdServicio.getText());
            float costUnit = Float.parseFloat(this.txtCostoUnitProdServicio.getText());
            float resul = cant * costUnit;
            this.txtSubTotalProdServicio.setText(String.valueOf(resul));
        }
    }//GEN-LAST:event_txtCantidadProdServicioKeyReleased

    private void btnAñadirProdServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProdServicioActionPerformed
        if(validaProdServicio()){
            Vector vec = new Vector();
            vec.add(this.txtIdProdServicio.getText());
            vec.add(this.txtCantidadProdServicio.getText());
            vec.add(this.txtCostoUnitProdServicio.getText());
            vec.add(this.txtSubTotalProdServicio.getText());
            dtmProdServicio.addRow(vec);
            float subtotal = Float.parseFloat(this.txtSubTotalProdServicio.getText());
            float total = Float.parseFloat(this.txtTotalProdServicio.getText()) + subtotal;
            this.txtTotalProdServicio.setText(String.valueOf(total));
            limpiarProdServicio();
            CambiarTotalServicio();
        }
    }//GEN-LAST:event_btnAñadirProdServicioActionPerformed

    private void btnEliminaProductoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaProductoServicioActionPerformed
        if(this.dtmProdServicio.getRowCount() != 0){
            int fila = this.tblProdServicio.getSelectedRow();
            float subtotal = Float.parseFloat(this.dtmProdServicio.getValueAt(fila, 3).toString());
            float total = Float.parseFloat(this.txtTotalProdServicio.getText()) - subtotal;
            this.txtTotalProdServicio.setText(String.valueOf(total));
            this.dtmProdServicio.removeRow(fila);
            this.btnEliminaProductoServicio.setEnabled(false);
            CambiarTotalServicio();
        }else{
            JOptionPane.showMessageDialog(this, "Ingresa datos en Productos");
        }
    }//GEN-LAST:event_btnEliminaProductoServicioActionPerformed

    private void txtCantidadCatServServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadCatServServicioKeyReleased
        if(this.txtCantidadCatServServicio.getText().equals("") || this.txtCostoUnitCatServServicio.getText().equals("")){
            this.txtSubTotalCatServServicio.setText("0");
        }else{
            int cant = Integer.parseInt(this.txtCantidadCatServServicio.getText());
            float costUnit = Float.parseFloat(this.txtCostoUnitCatServServicio.getText());
            float resul = cant * costUnit;
            this.txtSubTotalCatServServicio.setText(String.valueOf(resul));
        }
    }//GEN-LAST:event_txtCantidadCatServServicioKeyReleased

    private void tblCatServServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCatServServicioMouseClicked
        int fila = this.tblCatServServicio.getSelectedRow();
        this.txtIdCatServServicio.setText(this.dtmCatServServicio.getValueAt(fila, 0).toString());
        this.txtCantidadCatServServicio.setText(this.dtmCatServServicio.getValueAt(fila, 1).toString());
        this.txtCostoUnitCatServServicio.setText(this.dtmCatServServicio.getValueAt(fila, 2).toString());
        this.txtSubTotalCatServServicio.setText(this.dtmCatServServicio.getValueAt(fila, 3).toString());
        this.btnEliminaCatServServicio.setEnabled(true);
    }//GEN-LAST:event_tblCatServServicioMouseClicked

    private void btnAñadirCatServServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirCatServServicioActionPerformed
        if(validaCatServServicio()){
            Vector vec = new Vector();
            vec.add(this.txtIdCatServServicio.getText());
            vec.add(this.txtCantidadCatServServicio.getText());
            vec.add(this.txtCostoUnitCatServServicio.getText());
            vec.add(this.txtSubTotalCatServServicio.getText());
            dtmCatServServicio.addRow(vec);
            float subtotal = Float.parseFloat(this.txtSubTotalCatServServicio.getText());
            float total = Float.parseFloat(this.txtTotalCatServServicio.getText()) + subtotal;
            this.txtTotalCatServServicio.setText(String.valueOf(total));
            CambiarTotalServicio();
            limpiarCatServServicio();
        }else{
            JOptionPane.showMessageDialog(this, "Ingresa datos en Productos");
        }
    }//GEN-LAST:event_btnAñadirCatServServicioActionPerformed

    private void btnEliminaCatServServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaCatServServicioActionPerformed
        if(this.dtmCatServServicio.getRowCount() != 0){
            int fila = this.tblCatServServicio.getSelectedRow();
            float subtotal = Float.parseFloat(this.dtmCatServServicio.getValueAt(fila, 3).toString());
            float total = Float.parseFloat(this.txtTotalCatServServicio.getText()) - subtotal;
            this.txtTotalCatServServicio.setText(String.valueOf(total));
            this.dtmCatServServicio.removeRow(fila);
            this.btnEliminaCatServServicio.setEnabled(false);
            CambiarTotalServicio();
        }else{
            JOptionPane.showMessageDialog(this, "Ingresa datos en Productos");
        }
    }//GEN-LAST:event_btnEliminaCatServServicioActionPerformed

    private void btnBuscarCatServServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCatServServicioActionPerformed
        CategoriaServicio catServ;
        SelecCategoriaServicio dialog = new SelecCategoriaServicio(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        catServ = dialog.devuelveCategoriaServicio();
        this.txtIdCatServServicio.setText(String.valueOf(catServ.getIdCategoriaServicio()));
        this.txtCostoUnitCatServServicio.setText(String.valueOf(catServ.getCostoUnitario()));
    }//GEN-LAST:event_btnBuscarCatServServicioActionPerformed

    private void btnAgregarCatServServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCatServServicioActionPerformed
        this.TbPnlProcesos.setSelectedIndex(3);
    }//GEN-LAST:event_btnAgregarCatServServicioActionPerformed

    private void TbPnlServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPnlServicioMouseClicked
        String fecha = util.obtenerFecha();
        this.txtDiaServicio.setText(fecha.substring(8,10));
        this.txtMesServicio.setText(fecha.substring(5,7));
        this.txtAñoServicio.setText(fecha.substring(0,4));
    }//GEN-LAST:event_TbPnlServicioMouseClicked

    private void cmbEstadoServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoServicioItemStateChanged
        if(this.cmbEstadoServicio.getSelectedItem().equals("Entregada")){
            String fecha = util.obtenerFecha();
            this.txtDiaEntregaServicio.setText(fecha.substring(8,10));
            this.txtMesEntregaServicio.setText(fecha.substring(5,7));
            this.txtAñoEntregaServicio.setText(fecha.substring(0,4));
        }else{
            this.txtDiaEntregaServicio.setText("");
            this.txtMesEntregaServicio.setText("");
            this.txtAñoEntregaServicio.setText("");
        }
    }//GEN-LAST:event_cmbEstadoServicioItemStateChanged

    private void btnGrabarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarServicioActionPerformed
        if(validaServicio()){
            Servicio serv = new Servicio();
            DetServicioProducto detServProd = new DetServicioProducto();
            DetServicioCatServicio detServCatServ = new DetServicioCatServicio();

            // Registrando Compra
            serv.setIdServicio(Integer.parseInt(this.txtIdServicio.getText()));
            if(this.cmbEstadoServicio.getSelectedItem().equals("Pendiente")){
                serv.setFechaEntrega("1000-01-01");
            }else{
                serv.setFechaEntrega(this.txtAñoEntregaServicio.getText() + "-" + this.txtMesEntregaServicio.getText() + "-" + this.txtDiaEntregaServicio.getText());
            }
            serv.setIdEmpleado(Integer.parseInt(this.txtIdEmpleadoServicio.getText()));
            serv.setIdCliente(Integer.parseInt(this.txtIdClieServicio.getText()));
            serv.setFechaServicio(this.txtAñoServicio.getText() + "-" + this.txtMesServicio.getText() + "-" + this.txtDiaServicio.getText());
            serv.setTotalServicio(Float.parseFloat(this.txtTotalServicio.getText()));
            serv.setObservacion(this.txtObservacionesServicio.getText());
            if(this.cmbEstadoServicio.getSelectedItem().equals("Pendiente")){
                serv.setEstado(0); // pendiente
            }else{
                serv.setEstado(1); // entregada
            }
            if(this.cmbTipoPagoServicio.getSelectedItem().equals("Efectivo")){
                serv.setTipoPago(0); // efectivo
            }else if(this.cmbTipoPagoServicio.getSelectedItem().equals("Visa")){
                serv.setTipoPago(1); // visa o tarjeta
            }else{
                serv.setTipoPago(2); // Yape o plin
            }
            serv.setIdAlmacen(Integer.parseInt(this.txtIdAlmacenServicio.getText()));

            if(this.btnGrabarServicio.getText().equals("Grabar")){
                servDao.insertaServicio(serv);
                
            }else{
                servDao.actualizaServicio(serv);
            }
            // Registrando Detalle Compra
            for(int i=0; i<dtmProdServicio.getRowCount(); i++){
                detServProd.setIdDetalleServicioProducto(util.idNext("DetalleServicioProducto", "IdDetalleServicio"));
                detServProd.setIdServicio(Integer.parseInt(this.txtIdServicio.getText()));
                detServProd.setIdProducto(Integer.parseInt(this.dtmProdServicio.getValueAt(i, 0).toString()));
                detServProd.setCantidad(Integer.parseInt(this.dtmProdServicio.getValueAt(i, 2).toString()));
                detServProd.setCostoUnitario(Float.parseFloat(this.dtmProdServicio.getValueAt(i, 3).toString()));
                detServProd.setSubtotal(Float.parseFloat(this.dtmProdServicio.getValueAt(i, 4).toString()));
                // Actualiza o añade inventario
                Inventario inv = new Inventario();
                inv.setIdInventario(util.idNext("Inventario", "IdInventario"));
                inv.setIdProducto(Integer.parseInt(this.txtIdProdServicio.getText()));
                inv.setIdAlmacen(Integer.parseInt(this.txtIdAlmacenServicio.getText()));
                inv.setCantidadStock(Integer.parseInt(this.txtCantidadProdServicio.getText()));
                inv.setMinimoStock(Integer.parseInt(this.txtCantidadProdServicio.getText()));
                inv.setFechaActualizacion(util.obtenerFecha().substring(0, 10));
                invDao.actualizaInventario(inv, "Servicio");
                if(this.btnGrabarServicio.getText().equals("Grabar")){
                    detServProdDao.insertaDetProdServicio(detServProd);
                }else{
                    detServProdDao.actualizaDetalleProdServicio(detServProd);
                }
            }
            for(int i=0; i<dtmCatServServicio.getRowCount(); i++){
                detServCatServ.setIdDetalleServicio(util.idNext("DetalleServicioProducto", "IdDetalleServicio"));
                detServCatServ.setIdServicio(Integer.parseInt(this.txtIdServicio.getText()));
                detServCatServ.setIdCategoriaServicio(Integer.parseInt(this.dtmCatServServicio.getValueAt(i, 0).toString()));
                detServCatServ.setCantidad(Integer.parseInt(this.dtmCatServServicio.getValueAt(i, 2).toString()));
                detServCatServ.setCostoUnitario(Float.parseFloat(this.dtmCatServServicio.getValueAt(i, 3).toString()));
                detServCatServ.setSubtotal(Float.parseFloat(this.dtmCatServServicio.getValueAt(i, 4).toString()));
                if(this.btnGrabarServicio.getText().equals("Grabar")){
                    detServCatServDao.insertaDetCatServicio(detServCatServ);
                }else{
                    detServCatServDao.actualizaDetalleCatServicio(detServCatServ);
                }
            }
            limpiarServicio();
        }
    }//GEN-LAST:event_btnGrabarServicioActionPerformed

    private void tblClienteServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteServicioMouseClicked
        int fila = this.tblClienteServicio.getSelectedRow();
        llenarTblOrdenServicio(true, this.dtmClieServicio.getValueAt(fila, 0).toString(), "IdServicio");
    }//GEN-LAST:event_tblClienteServicioMouseClicked

    private void btnLimpiarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarServicioActionPerformed
        limpiarServicio();
    }//GEN-LAST:event_btnLimpiarServicioActionPerformed

    private void tblOrdenServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdenServicioMouseClicked
        int fila = this.tblOrdenServicio.getSelectedRow();
        this.txtIdServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 0).toString());
        this.txtIdEmpleadoServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 1).toString());
        Cliente clie = clieDao.BuscarCliente(Integer.parseInt(this.dtmOrdenServicio.getValueAt(fila, 2).toString()));
        this.txtIdClieServicio.setText(String.valueOf(clie.getIdCliente()));
        this.txtIdCategoraClieServicio.setText(String.valueOf(clie.getIdCategoria()));
        this.txtNomApeClieServicio.setText(clie.getNombCliente() + ", " +clie.getApellCliente());
        this.txtDniClieServicio.setText(String.valueOf(clie.getDocCliente()));
        this.txtTelefonoClieServicio.setText(String.valueOf(clie.getTelefono()));
        this.txtCorreoClieServicio.setText(clie.getCorreo());

        this.txtDiaServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 3).toString().substring(8, 10));
        this.txtMesServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 3).toString().substring(5, 7));
        this.txtAñoServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 3).toString().substring(0, 4));
        this.txtDiaEntregaServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 4).toString().substring(8, 10));
        this.txtMesEntregaServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 4).toString().substring(5, 7));
        this.txtAñoEntregaServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 4).toString().substring(0, 4));
        
        this.txtTotalServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 5).toString());
        this.txtObservacionesServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 6).toString().trim());
        this.cmbEstadoServicio.setSelectedItem(this.dtmOrdenServicio.getValueAt(fila, 7).toString());
        this.cmbTipoPagoServicio.setSelectedItem(this.dtmOrdenServicio.getValueAt(fila, 8).toString());
        this.txtIdAlmacenServicio.setText(this.dtmOrdenServicio.getValueAt(fila, 9).toString());
        this.btnEliminarServicio.setEnabled(true);
        
        float TotalProd = 0, TotalCatServ = 0;
        Vector <DetServicioProducto> listaDetServProd = new Vector<DetServicioProducto>();
        listaDetServProd = detServProdDao.listaServicio(true, txtIdCompra.getText(), "IdCompra");
        this.dtmProdServicio.setRowCount(0);
        for(int i=0; i<listaDetServProd.size(); i++){
            Vector vec = new Vector();
            vec.add(listaDetServProd.get(i).getIdProducto());
            vec.add(listaDetServProd.get(i).getCantidad());
            vec.add(listaDetServProd.get(i).getCostoUnitario());
            vec.add(listaDetServProd.get(i).getSubtotal());
            TotalProd = TotalProd + listaDetServProd.get(i).getSubtotal();
            dtmProdServicio.addRow(vec);
        }
        Vector <DetServicioCatServicio> listaDetServCatServ = new Vector<DetServicioCatServicio>();
        listaDetServCatServ = detServCatServDao.listaServicio(true, txtIdCompra.getText(), "IdCompra");
        this.dtmProdServicio.setRowCount(0);
        for(int i=0; i<listaDetServCatServ.size(); i++){
            Vector vec = new Vector();
            vec.add(listaDetServCatServ.get(i).getIdCategoriaServicio());
            vec.add(listaDetServCatServ.get(i).getCantidad());
            vec.add(listaDetServCatServ.get(i).getCostoUnitario());
            vec.add(listaDetServCatServ.get(i).getSubtotal());
            TotalCatServ = TotalCatServ + listaDetServCatServ.get(i).getSubtotal();
            dtmProdServicio.addRow(vec);
        }
        this.txtTotalProdServicio.setText(String.valueOf(TotalProd));
        this.txtTotalCatServServicio.setText(String.valueOf(TotalCatServ));
        this.TbPnlServicio.setSelectedIndex(1);
        this.btnGrabarServicio.setText("Actualiza");
    }//GEN-LAST:event_tblOrdenServicioMouseClicked

    private void txtBuscarClienteServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClienteServicioKeyReleased
        if(this.txtBuscarClienteServicio.getText().equals("")){
            llenarTblClienteServicio(false, "", "");
        }else{
            String camp = "";
            switch(this.cmbClienteServicio.getSelectedItem().toString()){
                case "ID Cliente":    camp = "IdCliente";   break;
                case "Nomb. y Apell.":    camp = "NombCliente like " + this.txtBuscarClienteServicio.getText() +  " or ApellCliente ";   break;
                case "Categoría":    camp = "IdCategoriaCliente";   break;
                case "DNI":    camp = "DocCliente";   break;
                case "Telefono":    camp = "Telefono";   break;
                case "Correo":    camp = "Correo";   break;
            }
            llenarTblClienteServicio(true, this.txtBuscarClienteServicio.getText(), camp);
        }
    }//GEN-LAST:event_txtBuscarClienteServicioKeyReleased

    private void txtBuscarServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarServicioKeyReleased
        if(this.txtBuscarServicio.getText().equals("")){
            llenarTblOrdenServicio(false, "", "");
        }else{
            String camp = "", cad = "";
            switch(this.cmbOrdenServicio.getSelectedItem().toString()){
                case "ID Servicio":    camp = "IdServicio";   break;
                case "ID Empleado":    camp = "IdEmpleado";   break;
                case "ID Cliente":    camp = "IdCliente";   break;
                case "Observación":    camp = "Observación";   break;
                case "Estado":          camp = "Estado";   break;
                case "Tipo de Pago":    camp = "TipoPago";   break;
            }
            if(camp.equals("Estado")){
                if(this.txtBuscarServicio.getText().equals("P")){
                    cad = "0";
                }else if(this.txtBuscarServicio.getText().equals("E")){
                    cad = "1";
                }
                llenarTblOrdenServicio(true, cad, camp);
            }else if(camp.equals("TipoPago")){
                if(this.txtBuscarServicio.getText().equals("E")){
                    cad = "0";
                }else if(this.txtBuscarServicio.getText().equals("V")){
                    cad = "1";
                }else if(this.txtBuscarServicio.getText().equals("Y")){
                    cad = "2";
                }
                llenarTblOrdenServicio(true, cad, camp);
            }else{
                llenarTblOrdenServicio(true, this.txtBuscarServicio.getText(), camp);
            }
        }
    }//GEN-LAST:event_txtBuscarServicioKeyReleased
    // REPORTES****************************************************************************
    private void btnGeneraReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneraReporteActionPerformed
        if(!(this.cmbTipoReporte.getSelectedItem().equals("") || this.cmbMantenimiento.getSelectedItem().equals(""))){
            String r = "src/REPORTES_SIMPLES/";
            if(this.cmbTipoReporte.getSelectedItem().equals("Simple")){
                // REPORTES SIMPLES
                switch(this.cmbMantenimiento.getSelectedItem().toString()){
                    case "Categoria Cliente": r += "repCatClienteSimp.jasper"; break;
                    case "Categoria Producto": r += "Productocto_categoria.jasper"; break;
                    case "Cliente": r += "RepClienteSimp.jasper"; break;
                    case "Producto": r += "repProdSimp.jasper"; break;
                    case "Proveedor": r += "repProvSimp.jasper"; break;
                    case "Empleado": r += "repEmpleSimp.jasper"; break;
                }
                try{
                    DbBean db = new DbBean();
                    db.connectRep(r, null, false);
                }catch(SQLException e){
                    e.printStackTrace();
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }else{
                // REPORTES CON PARAMETROS
                switch(this.cmbMantenimiento.getSelectedItem().toString()){
                    case "Categoria Cliente": 
                        FrmRepCatClienteFiltro FrmRepCatClie = new FrmRepCatClienteFiltro();
                        this.pnlReportes.add(FrmRepCatClie);
                        FrmRepCatClie.setVisible(true);
                        FrmRepCatClie.setLocation((pnlReportes.getWidth() - FrmRepCatClie.getWidth())/2, (pnlReportes.getHeight()- FrmRepCatClie.getHeight())/2);
                        break;
                    case "Categoria Producto": 
                        FrmRepCatProd FrmRepCatProd = new FrmRepCatProd();
                        this.pnlReportes.add(FrmRepCatProd);
                        FrmRepCatProd.setVisible(true);
                        FrmRepCatProd.setLocation((pnlReportes.getWidth() - FrmRepCatProd.getWidth())/2, (pnlReportes.getHeight()- FrmRepCatProd.getHeight())/2);
                        break;
                    case "Cliente": 
                        FrmRepClienteRang FrmRepClie = new FrmRepClienteRang();
                        this.pnlReportes.add(FrmRepClie);
                        FrmRepClie.setVisible(true);
                        FrmRepClie.setLocation((pnlReportes.getWidth() - FrmRepClie.getWidth())/2, (pnlReportes.getHeight()- FrmRepClie.getHeight())/2);
                        break;
                    case "Producto": 
                        FrmRepProdMin FrmRepProd = new FrmRepProdMin();
                        this.pnlReportes.add(FrmRepProd);
                        FrmRepProd.setVisible(true);
                        FrmRepProd.setLocation((pnlReportes.getWidth() - FrmRepProd.getWidth())/2, (pnlReportes.getHeight()- FrmRepProd.getHeight())/2);
                        break;
                    case "Proveedor": 
                        FrmRepProvTipoVia FrmRepProv = new FrmRepProvTipoVia();
                        this.pnlReportes.add(FrmRepProv);
                        FrmRepProv.setVisible(true);
                        FrmRepProv.setLocation((pnlReportes.getWidth() - FrmRepProv.getWidth())/2, (pnlReportes.getHeight()- FrmRepProv.getHeight())/2);
                        break;
                    case "Empleado": 
                        FrmRepEmpl FrmRepEmp = new FrmRepEmpl();
                        this.pnlReportes.add(FrmRepEmp);
                        FrmRepEmp.setVisible(true);
                        FrmRepEmp.setLocation((pnlReportes.getWidth() - FrmRepEmp.getWidth())/2, (pnlReportes.getHeight()- FrmRepEmp.getHeight())/2);
                        break;
                }
            }
        }
    }//GEN-LAST:event_btnGeneraReporteActionPerformed

    private void tblAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlmacenMouseClicked
        int fila = this.tblAlmacen.getSelectedRow();
        llenarTblInventario(true, this.dtmAlmacen.getValueAt(fila, 0).toString(), "IdAlmacen");
    }//GEN-LAST:event_tblAlmacenMouseClicked

    private void TbPnlProcesosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TbPnlProcesosStateChanged
        if(this.TbPnlProcesos.getSelectedIndex() == 4){
            llenarTblAlmacen(false, "", "");
        }else if(this.TbPnlProcesos.getSelectedIndex() == 6){
            if(!emp.getCargo().equals("Administrador")){
                JOptionPane.showMessageDialog(this, "Pestaña restringida a los administradores");
                this.TbPnlProcesos.setSelectedIndex(3);
            }else{
                this.txtUsuMod.setText(us.getUsuario());
                this.txtFechMod.setText(util.obtenerFecha().substring(0, 10));
            }
        }
    }//GEN-LAST:event_TbPnlProcesosStateChanged

    private void btnEliminarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCompraActionPerformed
        this.compDao.eliminaCompra(Integer.parseInt(this.txtIdCompra.getText()));
        this.TbPnlCompra.setSelectedIndex(0);
        this.limpiarCompra();
        this.llenarTblOrdenCompra(false, "", "");
    }//GEN-LAST:event_btnEliminarCompraActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        this.ventDao.eliminaVenta(Integer.parseInt(this.txtIdVenta.getText()));
        this.TbPnlVenta.setSelectedIndex(0);
        this.limpiarVenta();
        this.llenarTblOrdenVenta(false, "", "");
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void btnEliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServicioActionPerformed
        this.servDao.eliminaServicio(Integer.parseInt(this.txtIdServicio.getText()));
        this.TbPnlServicio.setSelectedIndex(0);
        this.limpiarServicio();
        this.llenarTblOrdenServicio(false, "", "");
    }//GEN-LAST:event_btnEliminarServicioActionPerformed

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        int fila = this.tblUsuario.getSelectedRow();
        this.txtIdUsuario.setText(this.dtmUsuario.getValueAt(fila, 0).toString());
        this.txtIdEmpleadoUsuario.setText(this.dtmUsuario.getValueAt(fila, 1).toString());
        this.txtUsuario.setText(this.dtmUsuario.getValueAt(fila, 2).toString());
        this.txtUsuReg.setText(this.dtmUsuario.getValueAt(fila, 3).toString());
        this.txtFechReg.setText(this.dtmUsuario.getValueAt(fila, 4).toString());
        this.txtUsuMod.setText(this.dtmUsuario.getValueAt(fila, 5).toString());
        this.txtFechMod.setText(this.dtmUsuario.getValueAt(fila, 6).toString());
        
        this.txtUsuario.setEnabled(false);
        this.txtContraseñaUsuario.setEnabled(false);
        this.btnBuscaEmpleado.setEnabled(false);
        this.btnEditarUsuario.setEnabled(true);
        this.btnGrabarUsuario.setText("Limpiar");
        this.btnEliminarUsuario.setEnabled(true);
    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void btnGrabarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarUsuarioActionPerformed
        if(this.btnGrabarUsuario.getText().equals("Limpiar")){
            limpiarUsuario();
        }else{
            if(validaUsuario()){
                Usuario usu = new Usuario();
                usu.setIdUsuario(Integer.parseInt(this.txtIdUsuario.getText()));
                usu.setIdEmpleado(Integer.parseInt(this.txtIdEmpleadoUsuario.getText()));
                usu.setUsuario(this.txtUsuario.getText());
                usu.setContraseña(this.txtContraseñaUsuario.getText());
                usu.setUsrReg(this.txtUsuReg.getText());
                usu.setFechReg(this.txtFechReg.getText());
                if(this.btnGrabarUsuario.getText().equals("Grabar")){
                    usu.setUsrMod(this.txtUsuMod.getText());
                    usu.setFechMod(this.txtFechMod.getText());
                    usuDao.insertaUsuario(usu);
                }else{
                    System.out.println(this.us.getUsuario());
                    usu.setUsrMod(this.us.getUsuario());
                    usu.setFechMod(this.util.obtenerFecha().substring(0, 10));
                    usuDao.actualizaUsuario(usu);
                }
                limpiarUsuario();
            }else{
                JOptionPane.showMessageDialog(this, "Ingrese Usuario y/o Contraseña");
            }
        }
    }//GEN-LAST:event_btnGrabarUsuarioActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        ValidarContraseña dialog = new ValidarContraseña(new javax.swing.JFrame(), true);
        dialog.setLocation(this.getWidth()-300, this.getHeight()-250);
        dialog.setVisible(true);
        boolean es = dialog.esValida();
        if(es){
            this.txtUsuario.setEnabled(true);
            this.txtContraseñaUsuario.setEnabled(true);
            this.btnGrabarUsuario.setText("Actualizar");
            this.btnEditarUsuario.setEnabled(false);
        }
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        int fila = this.tblUsuario.getSelectedRow();
        usuDao.eliminaUsuario(Integer.parseInt(dtmUsuario.getValueAt(fila, 0).toString()));
        limpiarUsuario();
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnBuscaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaEmpleadoActionPerformed
        Empleado emp;
        SelecEmpleado dialog = new SelecEmpleado(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        emp = dialog.devuelveEmpleado();
        this.txtIdEmpleadoUsuario.setText(String.valueOf(emp.getIdEmpleado()));
    }//GEN-LAST:event_btnBuscaEmpleadoActionPerformed

    private void btnBuscarEmpleadoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoCompraActionPerformed
        Empleado emp;
        SelecEmpleado dialog = new SelecEmpleado(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        emp = dialog.devuelveEmpleado();
        this.txtIdEmpleadoCompra.setText(String.valueOf(emp.getIdEmpleado()));
    }//GEN-LAST:event_btnBuscarEmpleadoCompraActionPerformed

    private void btnBuscarAlmacenCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlmacenCompraActionPerformed
        Almacen alm;
        SelecAlmacen dialog = new SelecAlmacen(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        alm = dialog.devuelveAlmacen();
        this.txtIdAlmacenCompra.setText(String.valueOf(alm.getIdAlmacen()));
    }//GEN-LAST:event_btnBuscarAlmacenCompraActionPerformed

    private void btnBuscarEmpleadoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoVentaActionPerformed
        Empleado emp;
        SelecEmpleado dialog = new SelecEmpleado(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        emp = dialog.devuelveEmpleado();
        this.txtIdEmpleadoVenta.setText(String.valueOf(emp.getIdEmpleado()));
    }//GEN-LAST:event_btnBuscarEmpleadoVentaActionPerformed

    private void btnBuscarAlmacenVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlmacenVentaActionPerformed
        Almacen alm;
        SelecAlmacen dialog = new SelecAlmacen(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        alm = dialog.devuelveAlmacen();
        this.txtIdAlmacenVenta.setText(String.valueOf(alm.getIdAlmacen()));
    }//GEN-LAST:event_btnBuscarAlmacenVentaActionPerformed

    private void btnBuscarEmpleadoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoServicioActionPerformed
        Empleado emp;
        SelecEmpleado dialog = new SelecEmpleado(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        emp = dialog.devuelveEmpleado();
        this.txtIdEmpleadoServicio.setText(String.valueOf(emp.getIdEmpleado()));
    }//GEN-LAST:event_btnBuscarEmpleadoServicioActionPerformed

    private void btnBuscarAlmacenServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlmacenServicioActionPerformed
        Almacen alm;
        SelecAlmacen dialog = new SelecAlmacen(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        alm = dialog.devuelveAlmacen();
        this.txtIdAlmacenServicio.setText(String.valueOf(alm.getIdAlmacen()));
    }//GEN-LAST:event_btnBuscarAlmacenServicioActionPerformed

    private void btnVerContraseñaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerContraseñaUsuarioMouseClicked
        if(this.btnVerContraseñaUsuario.isSelected()){
            this.txtContraseñaUsuario.setEchoChar((char)0); // permite ver la contraseña
            this.btnVerContraseñaUsuario.setText("Ocultar");
        }else{
            this.txtContraseñaUsuario.setEchoChar('\u25cf'); // cambiando caracter a unicode que oculta
            this.btnVerContraseñaUsuario.setText("Ver");
        }
    }//GEN-LAST:event_btnVerContraseñaUsuarioMouseClicked
    // COMPRAS****************************************************************************
    private void llenarCmbProvCompra(){
        this.cmbProveedorCompra.addItem("");
        this.cmbProveedorCompra.addItem("ID Proveedor");
        this.cmbProveedorCompra.addItem("RUC");
        this.cmbProveedorCompra.addItem("Nombre");
        this.cmbProveedorCompra.addItem("Telefono");
        this.cmbProveedorCompra.addItem("Correo");
        this.cmbProveedorCompra.addItem("Dirección");
    }
    
    private void llenarCmbCompra(){
        this.cmbOrdenCompra.addItem("");
        this.cmbOrdenCompra.addItem("ID Compra");
        this.cmbOrdenCompra.addItem("ID Empleado");
        this.cmbOrdenCompra.addItem("ID Proveedor");
        this.cmbOrdenCompra.addItem("Observación");
        this.cmbOrdenCompra.addItem("Estado");
        this.cmbOrdenCompra.addItem("Tipo de Pago");
    }
    
    private void llenarTblProveedorCompra(boolean sw, String cad, String camp){
        Vector<Proveedor> listProv = new Vector<Proveedor>();
        listProv = provDao.listaProveedor(sw, cad, camp);
        this.dtmProvCompra.setRowCount(0);
        for(int i=0; i<listProv.size(); i++){
            Vector vec = new Vector();
            vec.add(listProv.get(i).getIdProveedor());
            vec.add(listProv.get(i).getRUC());
            vec.add(listProv.get(i).getNombre());
            vec.add(listProv.get(i).getTelefono());
            vec.add(listProv.get(i).getCorreo());
            vec.add(listProv.get(i).getDirección());
            dtmProvCompra.addRow(vec);
        }
    }
    
    private void llenarTblOrdenCompra(boolean sw, String cad, String camp){
        Vector<Compra> listComp = new Vector<Compra>();
        listComp = compDao.listaCompra(sw, cad, camp);
        this.dtmOrdenCompra.setRowCount(0);
        for(int i=0; i<listComp.size(); i++){
            Vector vec = new Vector();
            vec.add(listComp.get(i).getIdCompra());
            vec.add(listComp.get(i).getIdEmpleado());
            vec.add(listComp.get(i).getIdProveedor());
            vec.add(listComp.get(i).getFechaCompra());
            vec.add(listComp.get(i).getFechaEntrega());
            vec.add(listComp.get(i).getTotalCompra());
            vec.add(listComp.get(i).getObservacion());
            if(listComp.get(i).getEstado() == 0){
                vec.add("Pendiente");
            }else{
                vec.add("Entregada");
            }
            if(listComp.get(i).getTipoPago() == 0){
                vec.add("Efectivo");
            }else if(listComp.get(i).getTipoPago() == 1){
                vec.add("Visa");
            }else{
                vec.add("Yape / Plin");
            }
            vec.add(listComp.get(i).getIdAlmacen());
            dtmOrdenCompra.addRow(vec);
        }
    }
    
    private boolean validaProdCompra(){
        String cad = "";
        if(this.txtIdAlmacenCompra.getText().equals("")){
            cad += "Inserte Almacen\n";
        }
        if(this.txtIdProdCompra.getText().equals("")){
            cad += "Inserte Producto\n";
        }
        if(this.txtCantidadProdCompra.getText().equals("")){
            cad += "Inserte Cantidad del Producto\n";
        }
        
        if(cad.isEmpty()){
            int idAlm = Integer.parseInt(this.txtIdAlmacenCompra.getText());
            int idProd = Integer.parseInt(this.txtIdProdCompra.getText());
            int cant = Integer.parseInt(this.txtCantidadProdCompra.getText());
            if(invDao.ComparaStock(idAlm, idProd, cant)){
                return true;
            }else{
                JOptionPane.showMessageDialog(this, "La cantidad supera al Stock");
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }
    }
    private boolean validaCompra(){
        String cad = "";
        
        if(this.cmbEstadoCompra.getSelectedItem().equals("")){
            cad += "Seleccione un estado\n";
        }
        if(this.txtIdProvCompra.getText().equals("")){
            cad += "Seleccione un proveedor\n";
        }
        if(this.cmbTipoPagoCompra.getSelectedItem().equals("")){
            cad += "Seleccione un tipo de pago\n";
        }
        if(this.dtmProdCompra.getRowCount() == 0){
            cad += "Seleccione producto(s)\n";
        }
        
        if(cad.isEmpty()){
            return true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }
    }
    private void limpiarProdCompra(){
        this.txtIdProdCompra.setText("");
        this.txtCostoUnitProdCompra.setText("");
        this.txtCantidadProdCompra.setText("");
        this.txtSubTotalCompra.setText("");
        this.btnEliminaProductoCompra.setEnabled(false);
    }
    private void limpiarCompra(){
        // Compra
        this.txtIdCompra.setText(String.valueOf(util.idNext("Compra", "IdCompra")));
        this.cmbEstadoCompra.setSelectedItem("");
        this.cmbTipoPagoCompra.setSelectedItem("");
        this.txtObservacionesCompra.setText("");
        // Proveedor
        this.txtIdProvCompra.setText("");
        this.txtRucProvCompra.setText("");
        this.txtNombreProvCompra.setText("");
        this.txtTelefonoProvCompra.setText("");
        this.txtCorreoProvCompra.setText("");
        this.txtDireccionProvCompra.setText("");
        // Productos
        limpiarProdCompra();
        // Adicionales
        this.txtTotalCompra.setText("");
        this.dtmProdCompra.setRowCount(0);
        this.btnGrabarCompra.setText("Grabar");
        this.btnEliminarCompra.setEnabled(false);
        this.llenarTblOrdenCompra(false, "", "");
    }
    // VENTAS****************************************************************************
    private void llenarCmbClieVenta(){
        this.cmbClienteVenta.addItem("");
        this.cmbClienteVenta.addItem("ID Cliente");
        this.cmbClienteVenta.addItem("Nomb. y Apell.");
        this.cmbClienteVenta.addItem("Categoría");
        this.cmbClienteVenta.addItem("DNI");
        this.cmbClienteVenta.addItem("Telefono");
        this.cmbClienteVenta.addItem("Correo");
    }
    
    private void llenarCmbVenta(){
        this.cmbOrdenVenta.addItem("");
        this.cmbOrdenVenta.addItem("ID Compra");
        this.cmbOrdenVenta.addItem("ID Empleado");
        this.cmbOrdenVenta.addItem("ID Proveedor");
        this.cmbOrdenVenta.addItem("Observación");
        this.cmbOrdenVenta.addItem("Estado");
        this.cmbOrdenVenta.addItem("Tipo de Pago");
    }
    
    private void llenarTblClienteVenta(boolean sw, String cad, String camp){
        Vector<Cliente> listClie = new Vector<Cliente>();
        listClie = clieDao.listClientes(sw, cad, camp);
        this.dtmClieVenta.setRowCount(0);
        for(int i=0; i<listClie.size(); i++){
            Vector vec = new Vector();
            vec.add(listClie.get(i).getIdCliente());
            vec.add(listClie.get(i).getIdCategoria());
            vec.add(listClie.get(i).getNombCliente() + ", "+ listClie.get(i).getApellCliente());
            vec.add(listClie.get(i).getDocCliente());
            vec.add(listClie.get(i).getTelefono());
            vec.add(listClie.get(i).getCorreo());
            dtmClieVenta.addRow(vec);
        }
    }
    
    private void llenarTblOrdenVenta(boolean sw, String cad, String camp){
        Vector<Venta> listVenta = new Vector<Venta>();
        listVenta = ventDao.listaVenta(sw, cad, camp);
        this.dtmOrdenVenta.setRowCount(0);
        for(int i=0; i<listVenta.size(); i++){
            Vector vec = new Vector();
            vec.add(listVenta.get(i).getIdVenta());
            vec.add(listVenta.get(i).getIdEmpleado());
            vec.add(listVenta.get(i).getIdCliente());
            vec.add(listVenta.get(i).getFechaVenta());
            vec.add(listVenta.get(i).getTotalVenta());
            vec.add(listVenta.get(i).getObservacion());
            if(listVenta.get(i).getEstado() == 0){
                vec.add("Pendiente");
            }else{
                vec.add("Entregada");
            }
            if(listVenta.get(i).getTipoPago() == 0){
                vec.add("Efectivo");
            }else if(listVenta.get(i).getTipoPago() == 1){
                vec.add("Visa");
            }else{
                vec.add("Yape / Plin");
            }
            vec.add(listVenta.get(i).getIdAlmacen());
            dtmOrdenVenta.addRow(vec);
        }
    }
    
    private boolean validaProdVenta(){
        String cad = "";
        if(this.txtIdAlmacenVenta.getText().equals("")){
            cad += "Inserte Almacen\n";
        }
        if(this.txtIdProdVenta.getText().equals("")){
            cad += "Inserte Producto\n";
        }
        if(this.txtCantidadProdVenta.getText().equals("")){
            cad += "Inserte Cantidad del Producto\n";
        }
        
        if(cad.isEmpty()){
            int idAlm = Integer.parseInt(this.txtIdAlmacenVenta.getText());
            int idProd = Integer.parseInt(this.txtIdProdVenta.getText());
            int cant = Integer.parseInt(this.txtCantidadProdVenta.getText());
            if(invDao.ComparaStock(idAlm, idProd, cant)){
                return true;
            }else{
                JOptionPane.showMessageDialog(this, "La cantidad supera al Stock");
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }
    }
    private boolean validaVenta(){
        String cad = "";
        
        if(this.cmbEstadoVenta.getSelectedItem().equals("")){
            cad += "Seleccione un estado\n";
        }
        if(this.txtIdClieVenta.getText().equals("")){
            cad += "Seleccione un cliente\n";
        }
        if(this.cmbTipoPagoVenta.getSelectedItem().equals("")){
            cad += "Seleccione un tipo de pago\n";
        }
        if(this.dtmProdVenta.getRowCount() == 0){
            cad += "Seleccione producto(s)\n";
        }
        
        if(cad.isEmpty()){
            return true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }
    }
    private void limpiarProdVenta(){
        this.txtIdProdVenta.setText("");
        this.txtCostoUnitProdVenta.setText("");
        this.txtCantidadProdVenta.setText("");
        this.txtSubTotalVenta.setText("");
        this.btnEliminaProductoVenta.setEnabled(false);
    }
    private void limpiarVenta(){
        // Venta
        this.txtIdVenta.setText(String.valueOf(util.idNext("Venta", "IdVenta")));
        this.cmbEstadoVenta.setSelectedItem("");
        this.cmbTipoPagoVenta.setSelectedItem("");
        this.txtObservacionesVenta.setText("");
        // Cliente
        this.txtIdClieVenta.setText("");
        this.txtDniClieVenta.setText("");
        this.txtIdCategoraClieVenta.setText("");
        this.txtNomApeClieVenta.setText("");
        this.txtTelefonoClieVenta.setText("");
        this.txtCorreoClieVenta.setText("");
        // Productos
        limpiarProdVenta();
        // Adicionales
        this.txtTotalVenta.setText("");
        this.dtmProdVenta.setRowCount(0);
        this.btnGrabarVenta.setText("Grabar");
        this.btnEliminarVenta.setEnabled(false);
        this.llenarTblOrdenVenta(false, "", "");
    }
    // SERVICIOS****************************************************************************
    private void llenarCmbClieServicio(){
        this.cmbClienteServicio.addItem("");
        this.cmbClienteServicio.addItem("ID Cliente");
        this.cmbClienteServicio.addItem("Nomb. y Apell.");
        this.cmbClienteServicio.addItem("Categoría");
        this.cmbClienteServicio.addItem("DNI");
        this.cmbClienteServicio.addItem("Telefono");
        this.cmbClienteServicio.addItem("Correo");
    }
    
    private void llenarCmbServicio(){
        this.cmbOrdenServicio.addItem("");
        this.cmbOrdenServicio.addItem("ID Servicio");
        this.cmbOrdenServicio.addItem("ID Empleado");
        this.cmbOrdenServicio.addItem("ID Cliente");
        this.cmbOrdenServicio.addItem("Observación");
        this.cmbOrdenServicio.addItem("Estado");
        this.cmbOrdenServicio.addItem("Tipo de Pago");
    }
    
    private void llenarTblClienteServicio(boolean sw, String cad, String camp){
        Vector<Cliente> listClie = new Vector<Cliente>();
        listClie = clieDao.listClientes(sw, cad, camp);
        this.dtmClieServicio.setRowCount(0);
        for(int i=0; i<listClie.size(); i++){
            Vector vec = new Vector();
            vec.add(listClie.get(i).getIdCliente());
            vec.add(listClie.get(i).getIdCategoria());
            vec.add(listClie.get(i).getNombCliente() + ", "+ listClie.get(i).getApellCliente());
            vec.add(listClie.get(i).getDocCliente());
            vec.add(listClie.get(i).getTelefono());
            vec.add(listClie.get(i).getCorreo());
            dtmClieServicio.addRow(vec);
        }
    }
    
    private void llenarTblOrdenServicio(boolean sw, String cad, String camp){
        Vector<Servicio> listServ = new Vector<Servicio>();
        listServ = servDao.listaServicio(sw, cad, camp);
        this.dtmOrdenServicio.setRowCount(0);
        for(int i=0; i<listServ.size(); i++){
            Vector vec = new Vector();
            vec.add(listServ.get(i).getIdServicio());
            vec.add(listServ.get(i).getIdEmpleado());
            vec.add(listServ.get(i).getIdCliente());
            vec.add(listServ.get(i).getFechaServicio());
            vec.add(listServ.get(i).getFechaEntrega());
            vec.add(listServ.get(i).getTotalServicio());
            vec.add(listServ.get(i).getObservacion());
            if(listServ.get(i).getEstado() == 0){
                vec.add("Pendiente");
            }else{
                vec.add("Entregada");
            }
            if(listServ.get(i).getTipoPago() == 0){
                vec.add("Efectivo");
            }else if(listServ.get(i).getTipoPago() == 1){
                vec.add("Visa");
            }else{
                vec.add("Yape / Plin");
            }
            vec.add(listServ.get(i).getIdAlmacen());
            dtmOrdenServicio.addRow(vec);
        }
    }
    
    private boolean validaProdServicio(){
        String cad = "";
        if(this.txtIdAlmacenServicio.getText().equals("")){
            cad += "Inserte Almacen\n";
        }
        if(this.txtIdProdServicio.getText().equals("")){
            cad += "Inserte Producto\n";
        }
        if(this.txtCantidadProdServicio.getText().equals("")){
            cad += "Inserte Cantidad del Producto\n";
        }
        
        if(cad.isEmpty()){
            int idAlm = Integer.parseInt(this.txtIdAlmacenServicio.getText());
            int idProd = Integer.parseInt(this.txtIdProdServicio.getText());
            int cant = Integer.parseInt(this.txtCantidadProdServicio.getText());
            if(invDao.ComparaStock(idAlm, idProd, cant)){
                return true;
            }else{
                JOptionPane.showMessageDialog(this, "La cantidad supera al Stock");
                return false;
            }
        }
        else{
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }
    }
    private boolean validaCatServServicio(){
        if(this.txtIdCatServServicio.getText().equals("") || this.txtCantidadCatServServicio.getText().equals("")){
            return false;
        }else{
            return true;
        }
    }
    private boolean validaServicio(){
        String cad = "";
        
        if(this.cmbEstadoCompra.getSelectedItem().equals("")){
            cad += "Seleccione un estado\n";
        }
        if(this.txtIdProvCompra.getText().equals("")){
            cad += "Seleccione un cliente\n";
        }
        if(this.cmbTipoPagoCompra.getSelectedItem().equals("")){
            cad += "Seleccione un tipo de pago\n";
        }
        if(this.dtmProdCompra.getRowCount() == 0){
            cad += "Seleccione producto(s)\n";
        }
        
        if(cad.isEmpty()){
            return true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
            return false;
        }
    }
    private void limpiarProdServicio(){
        this.txtIdProdServicio.setText("");
        this.txtCostoUnitProdServicio.setText("");
        this.txtCantidadProdServicio.setText("");
        this.txtSubTotalProdServicio.setText("");
        this.btnEliminaProductoServicio.setEnabled(false);
    }
    private void limpiarCatServServicio(){
        this.txtIdCatServServicio.setText("");
        this.txtCostoUnitCatServServicio.setText("");
        this.txtCantidadCatServServicio.setText("");
        this.txtSubTotalCatServServicio.setText("");
        this.btnEliminaCatServServicio.setEnabled(false);
    }
    private void limpiarServicio(){
        // Compra
        this.txtIdServicio.setText(String.valueOf(util.idNext("Compra", "IdCompra")));
        this.cmbEstadoServicio.setSelectedItem("");
        this.cmbTipoPagoServicio.setSelectedItem("");
        this.txtObservacionesServicio.setText("");
        // Cliente
        this.txtIdClieServicio.setText("");
        this.txtDniClieServicio.setText("");
        this.txtIdCategoraClieServicio.setText("");
        this.txtNomApeClieServicio.setText("");
        this.txtTelefonoClieServicio.setText("");
        this.txtCorreoClieServicio.setText("");
        // Productos
        limpiarProdServicio();
        // Servicios
        limpiarCatServServicio();
        // Adicionales
        this.txtTotalProdServicio.setText("");
        this.txtTotalCatServServicio.setText("");
        this.dtmProdServicio.setRowCount(0);
        this.dtmCatServServicio.setRowCount(0);
        this.btnGrabarServicio.setText("Grabar");
        this.btnEliminarServicio.setEnabled(false);
        this.llenarTblOrdenServicio(false, "", "");
    }
    private void CambiarTotalServicio(){
        if(this.txtTotalCatServServicio.getText().equals("") || this.txtTotalCatServServicio.getText().equals("0") || this.txtTotalProdServicio.getText().equals("") || this.txtTotalProdServicio.getText().equals("0")){
            this.txtTotalServicio.setText("0");
        }else{
            float TotalCatServ = Integer.parseInt(this.txtTotalCatServServicio.getText());
            float TotalProdServ = Integer.parseInt(this.txtTotalProdServicio.getText());
            float total = TotalCatServ + TotalProdServ;
            this.txtTotalServicio.setText(String.valueOf(total));
        }
    }
    // USUARIO***************************************************
    private void llenarTblUsuarios(boolean sw, String cad, String camp){
        Vector<Usuario> listUsuario = new Vector<Usuario>();
        listUsuario = usuDao.listaUsuario(sw, cad, camp);
        this.dtmUsuario.setRowCount(0);
        for(int i=0; i<listUsuario.size(); i++){
            Vector vec = new Vector();
            vec.add(listUsuario.get(i).getIdUsuario());
            vec.add(listUsuario.get(i).getIdEmpleado());
            vec.add(listUsuario.get(i).getUsuario());
            vec.add(listUsuario.get(i).getUsrReg());
            vec.add(listUsuario.get(i).getFechReg());
            vec.add(listUsuario.get(i).getUsrMod());
            vec.add(listUsuario.get(i).getFechMod());
            dtmUsuario.addRow(vec);
        }
    }
    private boolean validaUsuario(){
        String cad = "";
        if(this.txtIdEmpleadoUsuario.getText().isEmpty()){
            cad += "Eleja un Empleado \n";
        }
        if(this.txtIdEmpleadoUsuario.getText().isEmpty()){
            cad += "Escriba un Usuario\n";
        }
        if(this.txtIdEmpleadoUsuario.getText().isEmpty()){
            cad += "Escriba una Contraseña";
        }
        
        if(cad.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    private void limpiarUsuario(){
        this.txtUsuario.setEnabled(true);
        this.txtContraseñaUsuario.setEnabled(true);
        this.btnBuscaEmpleado.setEnabled(true);
        this.btnEditarUsuario.setEnabled(false);
        this.btnGrabarUsuario.setText("Grabar");
        this.btnEliminarUsuario.setEnabled(false);
        
        this.txtIdUsuario.setText(String.valueOf(util.idNext("Usuario", "IdUsuario")));
        this.txtIdEmpleadoUsuario.setText("");
        this.txtUsuario.setText("");
        this.txtContraseñaUsuario.setText("");
        this.txtUsuReg.setText(us.getUsuario());
        this.txtFechReg.setText(util.obtenerFecha().substring(0, 10));
        this.txtUsuMod.setText(us.getUsuario());
        this.txtFechMod.setText(util.obtenerFecha().substring(0, 10));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TbPnlCompra;
    private javax.swing.JTabbedPane TbPnlProcesos;
    private javax.swing.JTabbedPane TbPnlServicio;
    private javax.swing.JTabbedPane TbPnlVenta;
    private javax.swing.JButton btnAgregarCatServServicio;
    private javax.swing.JButton btnAgregarClieServicio;
    private javax.swing.JButton btnAgregarClieVenta;
    private javax.swing.JButton btnAgregarProdCompra;
    private javax.swing.JButton btnAgregarProductoServicio;
    private javax.swing.JButton btnAgregarProductoVenta;
    private javax.swing.JButton btnAgregarProvCompra;
    private javax.swing.JButton btnAñadirCatServServicio;
    private javax.swing.JButton btnAñadirProdCompra;
    private javax.swing.JButton btnAñadirProdServicio;
    private javax.swing.JButton btnAñadirProdVenta;
    private javax.swing.JButton btnBuscaEmpleado;
    private javax.swing.JButton btnBuscarAlmacenCompra;
    private javax.swing.JButton btnBuscarAlmacenServicio;
    private javax.swing.JButton btnBuscarAlmacenVenta;
    private javax.swing.JButton btnBuscarCatServServicio;
    private javax.swing.JButton btnBuscarClieServicio;
    private javax.swing.JButton btnBuscarClieVenta;
    private javax.swing.JButton btnBuscarEmpleadoCompra;
    private javax.swing.JButton btnBuscarEmpleadoServicio;
    private javax.swing.JButton btnBuscarEmpleadoVenta;
    private javax.swing.JButton btnBuscarProdCompra;
    private javax.swing.JButton btnBuscarProductoServicio;
    private javax.swing.JButton btnBuscarProductoVenta;
    private javax.swing.JButton btnBuscarProvCompra;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminaCatServServicio;
    private javax.swing.JButton btnEliminaProductoCompra;
    private javax.swing.JButton btnEliminaProductoServicio;
    private javax.swing.JButton btnEliminaProductoVenta;
    private javax.swing.JButton btnEliminarCompra;
    private javax.swing.JButton btnEliminarServicio;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnGeneraReporte;
    private javax.swing.JButton btnGrabarCompra;
    private javax.swing.JButton btnGrabarServicio;
    private javax.swing.JButton btnGrabarUsuario;
    private javax.swing.JButton btnGrabarVenta;
    private javax.swing.JButton btnLimpiarCompra;
    private javax.swing.JButton btnLimpiarServicio;
    private javax.swing.JButton btnLimpiarVenta;
    private javax.swing.JToggleButton btnVerContraseñaUsuario;
    private javax.swing.JComboBox<String> cmbClienteServicio;
    private javax.swing.JComboBox<String> cmbClienteVenta;
    private javax.swing.JComboBox<String> cmbEstadoCompra;
    private javax.swing.JComboBox<String> cmbEstadoServicio;
    private javax.swing.JComboBox<String> cmbEstadoVenta;
    private javax.swing.JComboBox<String> cmbMantenimiento;
    private javax.swing.JComboBox<String> cmbOrdenCompra;
    private javax.swing.JComboBox<String> cmbOrdenServicio;
    private javax.swing.JComboBox<String> cmbOrdenVenta;
    private javax.swing.JComboBox<String> cmbProveedorCompra;
    private javax.swing.JComboBox<String> cmbTipoPagoCompra;
    private javax.swing.JComboBox<String> cmbTipoPagoServicio;
    private javax.swing.JComboBox<String> cmbTipoPagoVenta;
    private javax.swing.JComboBox<String> cmbTipoReporte;
    private LIB.JEImagePanel iconAlmacen;
    private LIB.JEImagePanel iconCategoriaCliente;
    private LIB.JEImagePanel iconCategoriaProducto;
    private LIB.JEImagePanel iconCategoriaServicio;
    private LIB.JEImagePanel iconCliente;
    private LIB.JEImagePanel iconEmpleado;
    private LIB.JEImagePanel iconProducto;
    private LIB.JEImagePanel iconProveedor;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JPanel pnlMantenimientos;
    private javax.swing.JPanel pnlReportes;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JPanel pnlUsuarioDatos;
    private javax.swing.JTable tblAlmacen;
    private javax.swing.JTable tblCatServServicio;
    private javax.swing.JTable tblClienteServicio;
    private javax.swing.JTable tblClienteVenta;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTable tblOrdenCompra;
    private javax.swing.JTable tblOrdenServicio;
    private javax.swing.JTable tblOrdenVenta;
    private javax.swing.JTable tblProdCompra;
    private javax.swing.JTable tblProdServicio;
    private javax.swing.JTable tblProdVenta;
    private javax.swing.JTable tblProveedorCompra;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtAñoCompra;
    private javax.swing.JTextField txtAñoEntregaCompra;
    private javax.swing.JTextField txtAñoEntregaServicio;
    private javax.swing.JTextField txtAñoServicio;
    private javax.swing.JTextField txtAñoVenta;
    private javax.swing.JTextField txtBuscarClienteServicio;
    private javax.swing.JTextField txtBuscarClienteVenta;
    private javax.swing.JTextField txtBuscarCompra;
    private javax.swing.JTextField txtBuscarProveedorCompra;
    private javax.swing.JTextField txtBuscarServicio;
    private javax.swing.JTextField txtBuscarVenta;
    private javax.swing.JTextField txtCantidadCatServServicio;
    private javax.swing.JTextField txtCantidadProdCompra;
    private javax.swing.JTextField txtCantidadProdServicio;
    private javax.swing.JTextField txtCantidadProdVenta;
    private javax.swing.JPasswordField txtContraseñaUsuario;
    private javax.swing.JTextField txtCorreoClieServicio;
    private javax.swing.JTextField txtCorreoClieVenta;
    private javax.swing.JTextField txtCorreoProvCompra;
    private javax.swing.JTextField txtCostoUnitCatServServicio;
    private javax.swing.JTextField txtCostoUnitProdCompra;
    private javax.swing.JTextField txtCostoUnitProdServicio;
    private javax.swing.JTextField txtCostoUnitProdVenta;
    private javax.swing.JTextField txtDiaCompra;
    private javax.swing.JTextField txtDiaEntregaCompra;
    private javax.swing.JTextField txtDiaEntregaServicio;
    private javax.swing.JTextField txtDiaServicio;
    private javax.swing.JTextField txtDiaVenta;
    private javax.swing.JTextField txtDireccionProvCompra;
    private javax.swing.JTextField txtDniClieServicio;
    private javax.swing.JTextField txtDniClieVenta;
    private javax.swing.JTextField txtFechMod;
    private javax.swing.JTextField txtFechReg;
    private javax.swing.JTextField txtIdAlmacenCompra;
    private javax.swing.JTextField txtIdAlmacenServicio;
    private javax.swing.JTextField txtIdAlmacenVenta;
    private javax.swing.JTextField txtIdCatServServicio;
    private javax.swing.JTextField txtIdCategoraClieServicio;
    private javax.swing.JTextField txtIdCategoraClieVenta;
    private javax.swing.JTextField txtIdClieServicio;
    private javax.swing.JTextField txtIdClieVenta;
    private javax.swing.JTextField txtIdCompra;
    private javax.swing.JTextField txtIdEmpleadoCompra;
    private javax.swing.JTextField txtIdEmpleadoServicio;
    private javax.swing.JTextField txtIdEmpleadoUsuario;
    private javax.swing.JTextField txtIdEmpleadoVenta;
    private javax.swing.JTextField txtIdProdCompra;
    private javax.swing.JTextField txtIdProdServicio;
    private javax.swing.JTextField txtIdProdVenta;
    private javax.swing.JTextField txtIdProvCompra;
    private javax.swing.JTextField txtIdServicio;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtMesCompra;
    private javax.swing.JTextField txtMesEntregaCompra;
    private javax.swing.JTextField txtMesEntregaServicio;
    private javax.swing.JTextField txtMesServicio;
    private javax.swing.JTextField txtMesVenta;
    private javax.swing.JTextField txtNomApeClieServicio;
    private javax.swing.JTextField txtNomApeClieVenta;
    private javax.swing.JTextField txtNombreProvCompra;
    private javax.swing.JTextArea txtObservacionesCompra;
    private javax.swing.JTextArea txtObservacionesServicio;
    private javax.swing.JTextArea txtObservacionesVenta;
    private javax.swing.JTextField txtRucProvCompra;
    private javax.swing.JTextField txtSubTotalCatServServicio;
    private javax.swing.JTextField txtSubTotalCompra;
    private javax.swing.JTextField txtSubTotalProdServicio;
    private javax.swing.JTextField txtSubTotalVenta;
    private javax.swing.JTextField txtTelefonoClieServicio;
    private javax.swing.JTextField txtTelefonoClieVenta;
    private javax.swing.JTextField txtTelefonoProvCompra;
    private javax.swing.JTextField txtTotalCatServServicio;
    private javax.swing.JTextField txtTotalCompra;
    private javax.swing.JTextField txtTotalProdServicio;
    private javax.swing.JTextField txtTotalServicio;
    private javax.swing.JTextField txtTotalVenta;
    private javax.swing.JTextField txtUsuMod;
    private javax.swing.JTextField txtUsuReg;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
