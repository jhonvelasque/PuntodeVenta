package BEAN_PROCESOS;

public class DetServicioCatServicio {
    private int IdDetalleServicio;
    private int IdServicio;
    private int IdCategoriaServicio;
    private int Cantidad;
    private float CostoUnitario;
    private float Subtotal;

    public DetServicioCatServicio(int IdDetalleServicio, int IdServicio, int IdCategoriaServicio, int Cantidad, float CostoUnitario, float Subtotal) {
        this.IdDetalleServicio = IdDetalleServicio;
        this.IdServicio = IdServicio;
        this.IdCategoriaServicio = IdCategoriaServicio;
        this.Cantidad = Cantidad;
        this.CostoUnitario = CostoUnitario;
        this.Subtotal = Subtotal;
    }

    public DetServicioCatServicio() {
    }

    public int getIdDetalleServicio() {
        return IdDetalleServicio;
    }

    public int getIdServicio() {
        return IdServicio;
    }

    public int getIdCategoriaServicio() {
        return IdCategoriaServicio;
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

    public void setIdDetalleServicio(int IdDetalleServicio) {
        this.IdDetalleServicio = IdDetalleServicio;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
    }

    public void setIdCategoriaServicio(int IdCategoriaServicio) {
        this.IdCategoriaServicio = IdCategoriaServicio;
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
