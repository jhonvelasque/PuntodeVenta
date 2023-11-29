package BEAN_PROCESOS;

public class Servicio {
    private int IdServicio;
    private int IdEmpleado;
    private int IdCliente;
    private String FechaServicio;
    private String FechaEntrega;
    private float TotalServicio;
    private String Observacion;
    private int Estado;
    private int TipoPago;
    private int IdAlmacen;

    public Servicio() {
    }

    public int getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
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

    public String getFechaServicio() {
        return FechaServicio;
    }

    public void setFechaServicio(String FechaServicio) {
        this.FechaServicio = FechaServicio;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(String FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    public float getTotalServicio() {
        return TotalServicio;
    }

    public void setTotalServicio(float TotalServicio) {
        this.TotalServicio = TotalServicio;
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
