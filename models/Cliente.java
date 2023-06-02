package ProyectoFinal.models;

import java.io.Serializable;

/**
 * @author Jorge Carmona Girona
 * @version 1.0
 * @since 12/1/2023
 * Es la clase que sirve para generar clientes
 */
public class Cliente extends Usuario implements Serializable {


    public Cliente(String nombre, String apellidos, String dni, String email, String telefono, String fecha_nacimiento, String rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;

    }

    public Cliente(String nombreUsuario, String password, String email, boolean rol, String nombre, String apellidos, String dni, String email1, String telefono, String fecha_nacimiento, boolean rol1, String codigo_de_Acceso) {
        super(nombreUsuario, password, email, rol);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email1;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.rol = rol1;
        Codigo_de_Acceso = codigo_de_Acceso;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    //Atributos
        private String nombre;
        private String apellidos;
        private String dni;
        private String email;
        private String telefono;
        private String fecha_nacimiento;
        private  String nomUsuario;
        private boolean rol=false;

        private String Codigo_de_Acceso;
        //Constructores
            public Cliente(String nombre, String apellidos, String dni) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.dni = dni;
        }

    public Cliente(String nombre, String apellidos, String dni, String email, String telefono, String fecha_nacimiento, String nomUsuario, boolean rol, String codigo_de_Acceso) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nomUsuario = nomUsuario;
        this.rol = rol;
        Codigo_de_Acceso = codigo_de_Acceso;
    }

    //Getter y setter

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getApellidos() {
            return apellidos;
        }
        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }
        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getFecha_nacimiento() {
            return fecha_nacimiento;
        }

        public void setFecha_nacimiento(String fecha_nacimiento) {
            this.fecha_nacimiento = fecha_nacimiento;
        }

        public String getCodigo_de_Acceso() {
            return Codigo_de_Acceso;
        }

        public void setCodigo_de_Acceso(String codigo_de_Acceso) {
            Codigo_de_Acceso = codigo_de_Acceso;
        }
        //toString
        public String infoBasica(){
            return "cliente{" +
                    "nombre='" + nombre + '\'' +
                    ", apellidos='" + apellidos + '\'' +
                    ", dni='" + dni + '\'' +
                    ", email='" + email + '\'';
        }
        @Override
        public String toString() {
            return "cliente{" +
                    "nombre='" + nombre + '\'' +
                    ", apellidos='" + apellidos + '\'' +
                    ", dni='" + dni + '\'' +
                    ", email='" + email + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                    ", Codigo_de_Acceso='" + Codigo_de_Acceso + '\'' +
                    '}';
        }
    }

