package ProyectoFinal.utils;

import ProyectoFinal.controllers.GestorClientes;
import ProyectoFinal.controllers.GestorHabitaciones;
import ProyectoFinal.models.Cliente;
import ProyectoFinal.models.Habitacion;
import ProyectoFinal.models.Reservas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import static ProyectoFinal.controllers.GestorReserevas.*;

/**
 * @author Jorge Carmona Girona
 * @version 1.0
 * @since 12/1/2023
 *
 */
public class Main {

    public static void Pago(Cliente clientes) {


        Scanner sc = new Scanner(System.in);
        String opcionPago;
        do {

            System.out.println("1 bizzum");
            System.out.println("2 tarjeta");
            opcionPago = sc.nextLine();
            switch (opcionPago) {
                case "1":
                    System.out.println("envie el dinero al 662 168 121");
                    break;
                case "2":
                    PagoTarjeta(clientes);
                    break;

            }

        } while (opcionPago == "3");


    }

    public static void PagoTarjeta(Cliente clientes) {

        Scanner sc = new Scanner(System.in);
        String tarjeta="";
        do {
            System.out.println("introduzca su tarjeta");

             tarjeta = sc.nextLine();


        }while (!GestorClientes.validacion_tarjeta(tarjeta));

        GestorClientes.tipo_tarjeta(tarjeta);


    }


    public static void main(String[] args) {
        GestorHabitaciones.GernerarHabitaciones();




        GestorClientes.generarClientesBase();
        ArrayList<Habitacion> listadoHabitaciones=new ArrayList<>();
        Reservas[]reserva=new Reservas[2];
        Scanner scan=new Scanner(System.in);
        String opcion;
        String opcion2;
        boolean nose =false;
        do {
            System.out.println("****************************");
            System.out.println("********** Tribago *********");
            System.out.println("****************************");
            System.out.println("1 registro de usuario");
            System.out.println("2 loguin de usuario");
            System.out.println("0 salir");
            System.out.println("elige una opción:");
            opcion=scan.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("************");
                    System.out.println("* registro* ");
                    System.out.println("************");
                    System.out.println("Introduce los siguientes datos:");
                    System.out.println("------------------------------------");

                    String nombre = Validaciones.nombreYapellidoComprobar();
                    String apellidos=Validaciones.nombreYapellidoComprobar();
                    String correo = Validaciones.comprobarCorreo();
                    String telefono = Validaciones.telefonoBien();
                    String fecha = Validaciones.fechaCorrecta();
                    String frase = Validaciones.fraseControl();
                    System.out.println(frase);
                    //String nombre, String apellidos, String dni, String email, String telefono, String fecha_nacimiento, String código_de_Acceso)
                    Cliente clienteGuardar= new Cliente(nombre,apellidos , "12345678C", correo, telefono, fecha, frase);
                    GestorClientes.agregarClientes(clienteGuardar);


                    break;
                case "2":
                    while (!nose) {
                        System.out.println("pon tu correo");

                        System.out.println("");
                        String guardarCosas = scan.nextLine();
                        guardarCosas=guardarCosas.trim();

                        if (GestorClientes.buscarCliente(guardarCosas)!=null) {

                            System.out.println("Introduzca su código");
                            String guardarCosas2=scan.nextLine();

                            while (!guardarCosas2.equals(GestorClientes.buscarCliente(guardarCosas).getCodigo_de_Acceso())) {

                                System.out.println("1 Reservar habitación");
                                System.out.println("2 Atención al cliente");
                                System.out.println("3 pago online");
                                System.out.println("4 salir");
                                opcion2 = scan.nextLine();

                                Cliente clientes=GestorClientes.buscarCliente(guardarCosas);


                                switch (opcion2) {


                                    case "1":
                                        CrearReservas();

                                        break;
                                    case "2":
                                        GestorClientes.Menupreguntas();

                                        break;
                                    case "3":

                                        Pago(clientes);



                                        break;
                                    case "4":
                                        System.out.println("Saliendo del sistema...");



                                        break;
                                }


                                nose=true;
                                if (opcion2.equals("4"))break;
                            }
                        }
                    }
                    break;
            }
        }while (!opcion.equals("0"));

        try {

            FileOutputStream clienteFos = new FileOutputStream("./ProyectoFinal/data/cliente.txt");
            ObjectOutputStream clienteOos= new ObjectOutputStream(clienteFos);

            for (Cliente cliente: GestorClientes.getListadoCliente()) {
                clienteOos.writeObject(cliente);
            }
        }catch (IOException ex){

        }


    }
}