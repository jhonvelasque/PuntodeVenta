package BEAN_PROCESOS;

public class Usuario {
    private int IdUsuario;
    private int IdEmpleado;
    private String Usuario;
    private String Contraseña;
    private String UsrReg;
    private String FechReg;
    private String UsrMod;
    private String FechMod;

    public Usuario() {
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getUsrReg() {
        return UsrReg;
    }

    public void setUsrReg(String UsrReg) {
        this.UsrReg = UsrReg;
    }

    public String getFechReg() {
        return FechReg;
    }

    public void setFechReg(String FechReg) {
        this.FechReg = FechReg;
    }

    public String getUsrMod() {
        return UsrMod;
    }

    public void setUsrMod(String UsrMod) {
        this.UsrMod = UsrMod;
    }

    public String getFechMod() {
        return FechMod;
    }

    public void setFechMod(String FechMod) {
        this.FechMod = FechMod;
    }

}
