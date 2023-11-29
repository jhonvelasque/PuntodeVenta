
package BEAN_MANTENIMIENTOS;

public class Empleado {
    private int IdEmpleado;
    private String NomEmpleado;
    private String ApellEmpleado;
    private String DocEmpleado;
    private String Direccion;
    private String Telefono;
    private String Correo;
    private String FechaInicio;
    private String FechaFinal;
    private String Cargo;
    private int Estado;

    public Empleado() {
    }

    public Empleado(int IdEmpleado, String NomEmpleado, String ApellEmpleado, String DocEmpleado, String Direccion, String Telefono, String Correo, String FechaInicio, String FechaFinal, String Cargo, int Estado) {
        this.IdEmpleado = IdEmpleado;
        this.NomEmpleado = NomEmpleado;
        this.ApellEmpleado = ApellEmpleado;
        this.DocEmpleado = DocEmpleado;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
        this.Cargo = Cargo;
        this.Estado = Estado;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getNomEmpleado() {
        return NomEmpleado;
    }

    public void setNomEmpleado(String NomEmpleado) {
        this.NomEmpleado = NomEmpleado;
    }

    public String getApellEmpleado() {
        return ApellEmpleado;
    }

    public void setApellEmpleado(String ApellEmpleado) {
        this.ApellEmpleado = ApellEmpleado;
    }

    public String getDocEmpleado() {
        return DocEmpleado;
    }

    public void setDocEmpleado(String DocEmpleado) {
        this.DocEmpleado = DocEmpleado;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    
}
