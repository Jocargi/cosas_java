package ProyectoFinal;

public class GestorClientes {

    Cliente[] listadoCliente;

    //construtores

    public GestorClientes(Cliente[] listadoCliente) {
        this.listadoCliente = listadoCliente;
    }
    //metodos

    /**
     * lo que hace este método es generar clientes
     * @param listadoCliente
     */

    public static void generarClientesBase(Cliente[] listadoCliente) {
        listadoCliente[0]=new Cliente("Manuel","Garcia Santa Maria","12345678C");
        listadoCliente[1]=new Cliente("Atonio","Box Sanchez","12345678C");
        listadoCliente[2]=new Cliente("Pepito","Garcia Box","12345678C");
        listadoCliente[3]=new Cliente("Sergio","Manrresa Bernabeu","12345678C");
        listadoCliente[4]=new Cliente("Jorge","Pelegrin Bru","12345678C");
        listadoCliente[5]=new Cliente("Miguel","Sivila Mora","12345678C");
        listadoCliente[6]=new Cliente("Iker","Berna Morales","12345678C");
        listadoCliente[7]=new Cliente("Juan","Martinez Perez","12345678C");

    }

    /**
     * sirve para mostrar la información básica del cliente
     * @param listadoCliente
     */
    public static void mostrarClientes(Cliente[] listadoCliente) {
        for (Cliente c : listadoCliente) {
            System.out.println(c.infoBasica());
        }
    }

    /**
     * sirve para buscar clientes
     * @param cliente
     * @return
     */

    public Cliente buscarCliente(Cliente cliente) {
        for (Cliente listadoCliente : listadoCliente ) {
            if (listadoCliente.equals(cliente)){
                return listadoCliente;
            }
        }
        return cliente;
    }

    /**
     * Sirve para agregar clientes
     * @param cliente
     */
    public void agregarClientes(Cliente cliente){
        Cliente[] listadoClientesAnterior = listadoCliente;
        listadoCliente = new Cliente[listadoClientesAnterior.length+1];
        for (int i = 0; i < listadoClientesAnterior.length; i++) {
            listadoCliente[i]= listadoClientesAnterior[i];
        }
        listadoCliente[listadoCliente.length-1] = cliente;
    }

    public static class Cliente {
        //Atributos
        private String nombre;
        private String apellidos;
        private String dni;
        private String email;
        private String telefono;
        private String fecha_nacimiento;

        private String Codigo_de_Acceso;
        //Constructores
        public Cliente() {}
        public Cliente(String nombre, String apellidos, String dni) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.dni = dni;
        }

        public Cliente(String nombre, String apellidos, String dni, String email, String telefono, String fecha_nacimiento, String código_de_Acceso) {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.dni = dni;
            this.email = email;
            this.telefono = telefono;
            this.fecha_nacimiento = fecha_nacimiento;
            Codigo_de_Acceso = Codigo_de_Acceso;
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
}
