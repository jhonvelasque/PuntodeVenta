package BEAN_PROCESOS;

public class Almacen {
    private int IdAlmacen;
    private String Descripcion;
    private String Ciudad;
    private String Distrito;
    private String Direccion;
    private int Capacidad;

    public Almacen() {
    }

    public Almacen(int IdAlmacen, String Descripcion, String Ciudad, String Distrito, String Direccion, int Capacidad) {
        this.IdAlmacen = IdAlmacen;
        this.Descripcion = Descripcion;
        this.Ciudad = Ciudad;
        this.Distrito = Distrito;
        this.Direccion = Direccion;
        this.Capacidad = Capacidad;
    }

    public int getIdAlmacen() {
        return IdAlmacen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getDistrito() {
        return Distrito;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setIdAlmacen(int IdAlmacen) {
        this.IdAlmacen = IdAlmacen;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setDistrito(String Distrito) {
        this.Distrito = Distrito;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }
    
    
}
