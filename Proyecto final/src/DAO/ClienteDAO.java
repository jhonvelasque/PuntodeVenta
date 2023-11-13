package DAO;

import BEAN.Cliente;
import java.util.Vector;

public class ClienteDAO {
    public Vector<Cliente> listClientes(boolean swr, String cad){
        Vector<Cliente> lista = new Vector<Cliente>();
        DbBean con = new DbBean();
        String sql = "Select *from Cliente";
        if(sw == true){
            
        }
        return lista;
    }
}
