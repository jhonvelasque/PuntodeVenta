package BEAN;

public class Proveedor {
    private int IdProveedor;
    private int RUC;
    private String Nombre;
    private int Telefono;
    private String Correo;
    private String Dirección;

    public Proveedor() {
    }
    
    public int getIdProveedor() {
        return IdProveedor;
    }

    public int getRUC() {
        return RUC;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getTelefono() {
        return Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public void setRUC(int RUC) {
        this.RUC = RUC;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }
}
