package BEAN_PROCESOS;

public class CategoriaServicio {
    private int IdCategoriaServicio;
    private String NombreServicio;
    private float CostoUnitario;

    public CategoriaServicio() {
    }

    public void setIdCategoriaServicio(int IdCategoriaServicio) {
        this.IdCategoriaServicio = IdCategoriaServicio;
    }

    public void setNombreServicio(String NombreServicio) {
        this.NombreServicio = NombreServicio;
    }

    public void setCostoUnitario(float CostoUnitario) {
        this.CostoUnitario = CostoUnitario;
    }

    public int getIdCategoriaServicio() {
        return IdCategoriaServicio;
    }

    public String getNombreServicio() {
        return NombreServicio;
    }

    public float getCostoUnitario() {
        return CostoUnitario;
    }
    
    
}
