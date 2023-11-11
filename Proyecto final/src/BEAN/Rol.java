
package BEAN;

public class Rol {
    private int idRol;
    private String DesRol;
    private double Mensualidad;

    public Rol() {
    }

    public Rol(int idRol, String DesRol, double Mensualidad) {
        this.idRol = idRol;
        this.DesRol = DesRol;
        this.Mensualidad = Mensualidad;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDesRol() {
        return DesRol;
    }

    public void setDesRol(String DesRol) {
        this.DesRol = DesRol;
    }

    public double getMensualidad() {
        return Mensualidad;
    }

    public void setMensualidad(double Mensualidad) {
        this.Mensualidad = Mensualidad;
    }
    
}
