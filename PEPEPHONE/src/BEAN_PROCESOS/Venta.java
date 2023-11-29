package BEAN_PROCESOS;

public class Venta {
    private int IdVenta;
    private int IdEmpleado;
    private int IdCliente;
    private String FechaVenta;
    private float TotalVenta;
    private String Observacion;
    private int Estado;
    private int TipoPago;
    private int IdAlmacen;

    public Venta() {
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public float getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(float TotalVenta) {
        this.TotalVenta = TotalVenta;
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
