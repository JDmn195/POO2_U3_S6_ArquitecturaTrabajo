package p2.arquitectura.model;

import p2.arquitectura.model.dao.UsuarioDAO;
import p2.arquitectura.model.dao.UsuarioDTO;

public class Fachada {

    private static Fachada instance;

    // Patrón Singleton
    private Fachada() {
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }

        return instance;
    }

    public String getWelcomeText() {
        return "Sistema de gestión personal";
    }

    public String validarCredenciales(String usuario, String passwd, String hora) throws Exception {
        String nombreCompleto = "";

        System.out.println(passwd);
        
        UsuarioDTO dto = (new UsuarioDAO()).validarCredenciales(usuario, passwd,hora);
        System.out.println("dto = "+dto);
        if (dto != null) {
            nombreCompleto = dto.getNombreCompleto();
        } else {
            throw new Exception("No se encontró usuario con esas credenciales o la hora es incorrecta");
        }

        return nombreCompleto;
    }

}
