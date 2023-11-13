package BEAN;

public class Cliente {
    private int IdCliente;
    private int IdCategoria;
    private String NombCliente;
    private String ApellCliente;
    private int DocCliente;
    private int Telefono;
    private String Correo;

    public Cliente() {
    }

    public Cliente(int IdCliente, int IdCategoria, String NombCliente, String ApellCliente, int DocCliente, int Telefono, String Correo) {
        this.IdCliente = IdCliente;
        this.IdCategoria = IdCategoria;
        this.NombCliente = NombCliente;
        this.ApellCliente = ApellCliente;
        this.DocCliente = DocCliente;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public void setNombCliente(String NombCliente) {
        this.NombCliente = NombCliente;
    }

    public void setApellCliente(String ApellCliente) {
        this.ApellCliente = ApellCliente;
    }

    public void setDocCliente(int DocCliente) {
        this.DocCliente = DocCliente;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    
    
    public int getIdCliente() {
        return IdCliente;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public String getNombCliente() {
        return NombCliente;
    }

    public String getApellCliente() {
        return ApellCliente;
    }

    public int getDocCliente() {
        return DocCliente;
    }

    public int getTelefono() {
        return Telefono;
    }

    public String getCorreo() {
        return Correo;
    }
   
    
    
}
