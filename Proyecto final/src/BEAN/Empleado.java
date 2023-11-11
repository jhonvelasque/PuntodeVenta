
package BEAN;

public class Empleado {
    
private int idEmpleado;
private String NomEmpleado;
private String ApellEmpleado;
private String DocEmpleado;
private String Direccion;
private String TelfEmpleado;
private String Correo;
private int estado;
private String FechInicio;
private String FechTermino; 

    public Empleado() {
    }

    public Empleado(int idEmpleado, String NomEmpleado, String ApellEmpleado, String DocEmpleado, String Direccion, String TelfEmpleado, String Correo, int estado, String FechInicio, String FechTermino) {
        this.idEmpleado = idEmpleado;
        this.NomEmpleado = NomEmpleado;
        this.ApellEmpleado = ApellEmpleado;
        this.DocEmpleado = DocEmpleado;
        this.Direccion = Direccion;
        this.TelfEmpleado = TelfEmpleado;
        this.Correo = Correo;
        this.estado = estado;
        this.FechInicio = FechInicio;
        this.FechTermino = FechTermino;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getTelfEmpleado() {
        return TelfEmpleado;
    }

    public void setTelfEmpleado(String TelfEmpleado) {
        this.TelfEmpleado = TelfEmpleado;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFechInicio() {
        return FechInicio;
    }

    public void setFechInicio(String FechInicio) {
        this.FechInicio = FechInicio;
    }

    public String getFechTermino() {
        return FechTermino;
    }

    public void setFechTermino(String FechTermino) {
        this.FechTermino = FechTermino;
    }


    
}
