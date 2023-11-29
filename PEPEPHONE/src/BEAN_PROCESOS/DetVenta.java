package BEAN_PROCESOS;

public class DetVenta {
    private int IdDetalleVenta;
    private int IdVenta;
    private int IdProducto;
    private int CantidadProducto;
    private float CostoUnitario;
    private float SubTotal;

    public DetVenta() {
    }

    public DetVenta(int IdDetalleVenta, int IdVenta, int IdProducto, int CantidadProducto, float CostoUnitario, float SubTotal) {
        this.IdDetalleVenta = IdDetalleVenta;
        this.IdVenta = IdVenta;
        this.IdProducto = IdProducto;
        this.CantidadProducto = CantidadProducto;
        this.CostoUnitario = CostoUnitario;
        this.SubTotal = SubTotal;
    }

    public int getIdDetalleVenta() {
        return IdDetalleVenta;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public int getCantidadProducto() {
        return CantidadProducto;
    }

    public float getCostoUnitario() {
        return CostoUnitario;
    }

    public float getSubTotal() {
        return SubTotal;
    }

    public void setIdDetalleVenta(int IdDetalleVenta) {
        this.IdDetalleVenta = IdDetalleVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public void setCantidadProducto(int CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    public void setCostoUnitario(float CostoUnitario) {
        this.CostoUnitario = CostoUnitario;
    }

    public void setSubTotal(float SubTotal) {
        this.SubTotal = SubTotal;
    }
    
    
}
