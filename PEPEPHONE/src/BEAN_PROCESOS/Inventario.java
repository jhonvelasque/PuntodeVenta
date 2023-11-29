package BEAN_PROCESOS;

public class Inventario {
    private int IdInventario;
    private int IdProducto;
    private int IdAlmacen;
    private int CantidadStock;
    private String FechaActualizacion;
    private int MinimoStock;

    public Inventario() {
    }

    public int getIdInventario() {
        return IdInventario;
    }

    public void setIdInventario(int IdInventario) {
        this.IdInventario = IdInventario;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getIdAlmacen() {
        return IdAlmacen;
    }

    public void setIdAlmacen(int IdAlmacen) {
        this.IdAlmacen = IdAlmacen;
    }

    public int getCantidadStock() {
        return CantidadStock;
    }

    public void setCantidadStock(int CantidadStock) {
        this.CantidadStock = CantidadStock;
    }

    public String getFechaActualizacion() {
        return FechaActualizacion;
    }

    public void setFechaActualizacion(String FechaActualizacion) {
        this.FechaActualizacion = FechaActualizacion;
    }

    public int getMinimoStock() {
        return MinimoStock;
    }

    public void setMinimoStock(int MinimoStock) {
        this.MinimoStock = MinimoStock;
    }
    
}
