package ProyectoFinal.models;

public class Administrador extends Ususario {
    private boolean rol = true;
   private String nombreUsuario;
    private String password;

    public Administrador(boolean rol, String nombreUsuario, String password, String email) {
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
    }

    public Administrador(String nombreUsuario, String password, String email, boolean rol, boolean rol1, String nombreUsuario1, String password1, String email1) {
        super(nombreUsuario, password, email, rol);
        this.rol = rol1;
        this.nombreUsuario = nombreUsuario1;
        this.password = password1;
        this.email = email1;
    }

    private String email;

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
