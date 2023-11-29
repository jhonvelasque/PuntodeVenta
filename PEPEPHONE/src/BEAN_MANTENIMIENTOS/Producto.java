package BEAN_MANTENIMIENTOS;
public class Producto {
    private int IdProducto;
    private int IdCategoria; 
    private String Marca;
    private String NombreProducto;
    private float  CostoUnitario;
    private float PrecioVenta;
    private String FechaIngreso;
    private int Estado;
    
    public Producto(){
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public float getCostoUnitario() {
        return CostoUnitario;
    }

    public void setCostoUnitario(float CostoUnitario) {
        this.CostoUnitario = CostoUnitario;
    }

    public float getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(float PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

}
