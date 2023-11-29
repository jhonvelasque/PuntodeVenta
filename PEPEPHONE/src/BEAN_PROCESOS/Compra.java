package BEAN_PROCESOS;

public class Compra {
    private int IdCompra;
    private String FechaEntrega;
    private int IdEmpleado;
    private int IdProveedor;
    private String FechaCompra;
    private float TotalCompra;
    private String Observacion;
    private int Estado;
    private int TipoPago;
    private int IdAlmacen;
    
    public Compra() {
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(String FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public float getTotalCompra() {
        return TotalCompra;
    }

    public void setTotalCompra(float TotalCompra) {
        this.TotalCompra = TotalCompra;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(int TipoPago) {
        this.TipoPago = TipoPago;
    }

    public int getIdAlmacen() {
        return IdAlmacen;
    }

    public void setIdAlmacen(int IdAlmacen) {
        this.IdAlmacen = IdAlmacen;
    }

}
