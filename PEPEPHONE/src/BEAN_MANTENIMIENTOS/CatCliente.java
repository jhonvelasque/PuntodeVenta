package BEAN_MANTENIMIENTOS;

public class CatCliente {
    private int IdCategoriaCliente;
    private String SegCliente;
    private String FrecCompra;
    private String Cuotas;
    private String CantCuotas;
    private int Estado;

    public CatCliente() {
    }

    public CatCliente(int IdCategoriaCliente, String SegCliente, String FrecCompra, String Cuotas, String CantCuotas, int Estado) {
        this.IdCategoriaCliente = IdCategoriaCliente;
        this.SegCliente = SegCliente;
        this.FrecCompra = FrecCompra;
        this.Cuotas = Cuotas;
        this.CantCuotas = CantCuotas;
        this.Estado = Estado;
    }

    public int getIdCategoriaCliente() {
        return IdCategoriaCliente;
    }

    public void setIdCategoriaCliente(int IdCategoriaCliente) {
        this.IdCategoriaCliente = IdCategoriaCliente;
    }

    public String getSegCliente() {
        return SegCliente;
    }

    public void setSegCliente(String SegCliente) {
        this.SegCliente = SegCliente;
    }

    public String getFrecCompra() {
        return FrecCompra;
    }

    public void setFrecCompra(String FrecCompra) {
        this.FrecCompra = FrecCompra;
    }

    public String getCuotas() {
        return Cuotas;
    }

    public void setCuotas(String Cuotas) {
        this.Cuotas = Cuotas;
    }

    public String getCantCuotas() {
        return CantCuotas;
    }

    public void setCantCuotas(String CantCuotas) {
        this.CantCuotas = CantCuotas;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

} 
    

