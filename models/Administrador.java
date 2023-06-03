package ProyectoFinal.models;

import ProyectoFinal.controllers.GestorClientes;
import ProyectoFinal.controllers.GestorHabitaciones;
import ProyectoFinal.utils.Main;
import ProyectoFinal.utils.Validaciones;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrador extends Usuario implements Serializable {
    private boolean rol = true;
    private String nombreUsuario;
    private String password;



    public Administrador(String nombreUsuario, String password, String email, boolean rol) {
        super(nombreUsuario, password, email, rol);
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
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

    public static void menuAdministradores(){
        String opcion = "";
        do {
            System.out.println("------ MENÚ DE GESTIÓN  ------");
            System.out.println("1. Menu Clientes");
            System.out.println("2. Menu Habitaciones");
            System.out.println("3. Menu Reservas");
            System.out.println("0. Salir del sistema");

            System.out.print("Elija una opción: ");


            Scanner sc=new Scanner(System.in);


            try{
                opcion = sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("a");
            }


            switch (opcion) {
                case "1":
                    menuAdministradoresCliente();

                    break;
                case "2":
                    menuAdministradoresHabitaciones();

                    break;
                case "3":


                    break;

            }

        } while (!opcion.equals("0"));
    }

    public static void menuAdministradoresReservas(){
        String opcion = "";
        do {
            System.out.println("------ MENÚ DE GESTIÓN  ------");
            System.out.println("1. Listado reservas ");
            System.out.println("2. eliminar reservas");
            System.out.println("0. Salir del sistema");

            System.out.print("Elija una opción: ");


            Scanner sc=new Scanner(System.in);


            try{
                opcion = sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("a");
            }


            switch (opcion) {
                case "1":


                    break;
                case "2":


                    break;

            }

        } while (!opcion.equals("0"));
    }



    public static void menuAdministradoresCliente() {
        String opcion = "";

        do {
            System.out.println("------ MENÚ DE GESTIÓN DE CLIENTES ------");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("0. salir del programa");

            System.out.print("Elija una opción: ");


            Scanner sc=new Scanner(System.in);


            try{
                opcion = sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("a");
            }


            switch (opcion) {
                case "1":
                    Main.crearCliente();



                    break;
                case "2":
                    System.out.println("inserte el correo del cliente");
                    String correo=sc.nextLine();
                    System.out.println(GestorClientes.buscarCliente(correo));

                    break;
                case "3":
                    System.out.println("inserte correo del cliente");
                    String correoA=sc.nextLine();
                    GestorClientes.ActualizarCliente(correoA);

                    break;
                case "4":
                    System.out.println("inserte correo del cliente");
                    String correoE=sc.nextLine();
                    GestorClientes.eliminarCliente(correoE);



                    break;
                case "5":
                    System.out.println("saliendo del menu");
                    break;
                case "6":
                    menuAdministradoresHabitaciones();
                    break;



            }

        } while (!opcion.equals("0"));
    }



    public static void menuAdministradoresHabitaciones() {
        String opcion = "";

        do {
            System.out.println("------ MENÚ DE GESTIÓN DE HABITACIÓN ------");
            System.out.println("1. Agregar habitación");
            System.out.println("2. Consultar habitación");
            System.out.println("3. Actualizar habitación");
            System.out.println("4. Eliminar habitación");
            System.out.println("0. salir del programa");
        ;
            System.out.print("Elija una opción: ");


            Scanner sc=new Scanner(System.in);


            try{
                opcion = sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("a");
            }


            switch (opcion) {
                case "1":
                    Habitacion habitacion=GestorHabitaciones.crearHabitaciones();
                    if (habitacion!=null){
                        GestorHabitaciones.getListadoHanitaciones().add(habitacion);                    }





                    break;
                case "2":
                    try {
                        System.out.println("inserte el código de la habitación");
                        String idC=sc.nextLine();
                        System.out.println(GestorHabitaciones.buscarHabitacion(idC).toString());

                    }catch (NullPointerException n){
                        System.out.println("fsd");

                    }



                    break;
                case "3":
                    System.out.println("inserte el código de la habitación");
                    String idA=sc.nextLine();

                    GestorHabitaciones.ActualizarHabitacion(idA);


                    break;
                case "4":
                    System.out.println("inserte el código de la habitación");
                    String idE=sc.nextLine();

                    GestorHabitaciones.eliminarHabitaciones(idE);



                    break;
                case "0":
                    System.out.println("saliendo del menu");
                    break;



            }

        } while (!opcion.equals("0"));
    }

}
