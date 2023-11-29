package BEAN_PROCESOS;

public class DetCompra {
    private int IdDetalleCompra;
    private int IdCompra;
    private float CostoUnitario;
    private int IdProducto;
    private int CantidadProducto;
    private float Subtotal;

    public DetCompra() {
    }

    public int getIdDetalleCompra() {
        return IdDetalleCompra;
    }

    public void setIdDetalleCompra(int IdDetalleCompra) {
        this.IdDetalleCompra = IdDetalleCompra;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public float getCostoUnitario() {
        return CostoUnitario;
    }

    public void setCostoUnitario(float CostoUnitario) {
        this.CostoUnitario = CostoUnitario;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidadProducto() {
        return CantidadProducto;
    }

    public void setCantidadProducto(int Cantidad) {
        this.CantidadProducto = Cantidad;
    }

    public float getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(float Subtotal) {
        this.Subtotal = Subtotal;
    }
}
