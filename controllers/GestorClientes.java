package ProyectoFinal.controllers;

import ProyectoFinal.models.Cliente;
import ProyectoFinal.utils.Main;
import ProyectoFinal.utils.Validaciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static ProyectoFinal.controllers.GestorReserevas.getListadoReservas;

/**
 * @author Jorge Carmona Girona
 * @version 1.0
 * @since 12/1/2023
 * Esta clase se encarga de gestionar clientes
 */
public class GestorClientes {

    static ArrayList<Cliente> listadoCliente=new ArrayList<>();

    //constructores

    public GestorClientes(ArrayList listadoCliente) {
        this.listadoCliente = listadoCliente;
    }

    //metodos

    /**
     * lo que hace este método es generar clientes
     *
     */

    public static void generarClientes() {
        try {
            FileInputStream clienteFis = new FileInputStream("data/cliente.dat");
            ObjectInputStream clienteOis = new ObjectInputStream(clienteFis);
            while (true) {
                Cliente cliente = (Cliente) clienteOis.readObject();
                agregarClientes(cliente);
            }

        } catch (IOException | ClassNotFoundException eofException) {
            

        }
    }


    public static void eliminarCliente(String correo) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : listadoCliente) {
            if (correo.equals(cliente.getEmail())) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            listadoCliente.remove(clienteEncontrado);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
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
     * @param correo
     * @return listadoCliente
     */

    public static Cliente buscarCliente(String correo) {
        for (Cliente listadoCliente : listadoCliente ) {
            if (correo.equals(listadoCliente.getEmail())){
                return listadoCliente;
            }
        }
        System.out.println("cliente no encontrado");
        return null;
    }


    public static void ActualizarCliente(String correo) {
        for (int i=0;i<listadoCliente.size(); i++ ) {
            if (correo.equals(listadoCliente.get(i).getEmail())){

                listadoCliente.set(i, Main.crearCliente());
            }
        }
        System.out.println("cliente no encontrado");

    }

    /**
     * Sirve para agregar clientes
     * @param clienteGuardar
     */
    public static  void agregarClientes(Cliente clienteGuardar ){

        listadoCliente.add(clienteGuardar);
    }
    /**
     * Sirve para que cuando el cliente pulse la opción de atención al cliente
     * muestre el menu
     */

    public static void Menupreguntas() {
        Scanner sc = new Scanner(System.in);
        String opcionPregunta;
        do {
            System.out.println("***** PREGUNTAS FRECUENTES *****");
            ArrayList<String> preguntas = new ArrayList<String>();
            preguntas.add(" Salir");
            preguntas.add(" Agregar preguntas");
            preguntas.add(" ¿Cómo puedo llamar fuera del hotel con el teléfono de la habitación?");
            preguntas.add(" ¿Es gratis la comida de la nevera de la habitación?");

            for (int i = 0; i < preguntas.size(); i++) {
                System.out.println(i + "." + preguntas.get(i));
            }


            System.out.println("Elige una opción del 0 al 3");
            opcionPregunta = sc.nextLine();

            if (!Validaciones.SoloNumeros(opcionPregunta)) {
            } else {
                if (opcionPregunta.length() == 0 || opcionPregunta.equals(" ")) {
                    System.out.println("escriba algo por favor ");

                }
                if (opcionPregunta.equals("1")) {
                    String peguntaNueva;
                    System.out.println("añada preguntas ");
                    peguntaNueva = sc.nextLine();

                    if (peguntaNueva.length() == 0) {
                        System.out.println("debe contener algo");
                        return;

                    }
                    preguntas.add(peguntaNueva);
                    System.out.println("tendremos sus preguntas en cuenta");
                }
                if (opcionPregunta.equals("2")) {
                    System.out.println("no se puede");

                }
                if (opcionPregunta.equals("3")) {
                    System.out.println("Si la comida de las neveras de las habitaciones son gratis");
                }

            }
        } while (!opcionPregunta.equals("0"));
    }



    /**
     * esta function se encarga de distinguir los tipos de tarjeta
     * @param tarjeta
     */
    public static void tipo_tarjeta(String tarjeta){
        int primer_digito = Integer.parseInt(tarjeta.substring(0, 1));
        int segundo_digito = Integer.parseInt(tarjeta.substring(1, 2));
        if (primer_digito == 4) {
            System.out.println("Esta tarjeta es una tarjeta Visa");
        } else if (primer_digito == 5 && (segundo_digito >= 1 && segundo_digito <= 5)) {
            System.out.println("Esta tarjeta es una tarjeta MasterCard");
        } else if (primer_digito == 3 && (segundo_digito == 4 || segundo_digito == 7)) {
            System.out.println("Esta tarjeta es una tarjeta American Express");
        } else if (primer_digito == 3 && (segundo_digito == 0 || segundo_digito == 6 || segundo_digito ==8)) {
            System.out.println("Esta tarjeta es una tarjeta Diners Club");
        } else {
            System.out.println("Este tipo de tarjeta no está soportado");
        }

    }

    /**
     * esta función se encarga de verificar la tarjeta
     * @param tarjeta
     * @return tarjeta valida
     */
    public static boolean validacion_tarjeta(String tarjeta){
        int sum=0;
        boolean alternative=false;
        for (int i = tarjeta.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(tarjeta.substring(i, i + 1));
            if (alternative) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternative = !alternative;
        }
        return (sum % 10 == 0);
    }


    public static ArrayList<Cliente> getListadoCliente() {
        return listadoCliente;
    }

    public static void setListadoCliente(ArrayList<Cliente> listadoCliente) {
        GestorClientes.listadoCliente = listadoCliente;
    }
}
