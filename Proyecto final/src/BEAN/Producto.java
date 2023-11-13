package BEAN;
public class Producto {
    private int IdProducto;
    private int IdCategoria;
    private String NombreProducto;
    private double  CostoUnitario;
    private double PrecioVenta;
    private String FehcaIngreso;
    private int Estado;
    
    public Producto(){
    }
    
    public Producto (int IdProducto, int IdCategoria, String NombreProducto, double CostoUnitario, double PrecioVenta, String FechaIngreso, int Estado){
        this.IdProducto = IdProducto;
        this.IdCategoria = IdCategoria;
        this.NombreProducto = NombreProducto;
        this.CostoUnitario = CostoUnitario;
        this.PrecioVenta = PrecioVenta;
        this.FehcaIngreso = FehcaIngreso;
        this.Estado = Estado;
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

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public double getCostoUnitario() {
        return CostoUnitario;
    }

    public void setCostoUnitario(double CostoUnitario) {
        this.CostoUnitario = CostoUnitario;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public String getFehcaIngreso() {
        return FehcaIngreso;
    }

    public void setFehcaIngreso(String FehcaIngreso) {
        this.FehcaIngreso = FehcaIngreso;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    
}
