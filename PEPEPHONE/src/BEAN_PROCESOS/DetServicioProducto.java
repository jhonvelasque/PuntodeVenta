package BEAN_PROCESOS;

public class DetServicioProducto {
    private int IdDetalleServicioProducto;
    private int IdServicio;
    private int IdProducto;
    private int Cantidad;
    private float CostoUnitario;
    private float Subtotal;

    public DetServicioProducto() {
    }

    public DetServicioProducto(int IdDetalleServicioProducto, int IdServicio, int IdProducto, int Cantidad, float CostoUnitario, float Subtotal) {
        this.IdDetalleServicioProducto = IdDetalleServicioProducto;
        this.IdServicio = IdServicio;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.CostoUnitario = CostoUnitario;
        this.Subtotal = Subtotal;
    }

    public int getIdDetalleServicioProducto() {
        return IdDetalleServicioProducto;
    }

    public int getIdServicio() {
        return IdServicio;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public float getCostoUnitario() {
        return CostoUnitario;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setIdDetalleServicioProducto(int IdDetalleServicioProducto) {
        this.IdDetalleServicioProducto = IdDetalleServicioProducto;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setCostoUnitario(float CostoUnitario) {
        this.CostoUnitario = CostoUnitario;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }
    
    
}
