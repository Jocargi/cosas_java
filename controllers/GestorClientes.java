package ProyectoFinal.controllers;

import ProyectoFinal.models.Cliente;
import ProyectoFinal.utils.Validaciones;

import java.io.FileInputStream;
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

    public static void generarClientesBase() {

        listadoCliente.add(new Cliente("Atonio","Box Sanchez","12345678C", "a@a.es" , "999333222", "12/12/2004" , "AAA123"));
        listadoCliente .add(new Cliente("Pepito","Garcia Box","12345678C","s@s.es" , "999333222", "12/12/2004" , "AAA123"));
        listadoCliente.add(new Cliente("Sergio","Manrresa Bernabeu","12345678C", "e@e.es" , "999333222", "12/12/2004" , "AAA123"));
        listadoCliente.add(new Cliente("Jorge","Pelegrin Bru","12345678C", "f@f.es" , "999333222", "12/12/2004" , "AAA123"));
        listadoCliente.add(new Cliente("Miguel","Sivila Mora","12345678C", "d@d.es" , "999333222", "12/12/2004" , "AAA123"));
        listadoCliente.add(new Cliente("Iker","Berna Morales","12345678C","i@i.es" , "999333222", "12/12/2004" , "AAA123"));
        listadoCliente.add(new Cliente("Juan","Martinez Perez","12345678C","d@t.es" , "999333222", "12/12/2004" , "AAA123"));
        listadoCliente.add(new Cliente("Pepe","Martinez Perez","12345678C","e@t.es" , "999333222", "12/12/2004" , "AAA123"));
        listadoCliente.add(new Cliente("Alexis","Martinez Perez","12345678C","s@t.es" , "999333222", "12/12/2004" , "AAA123"));

        try {
            FileInputStream fi=new FileInputStream("./ProyectoFinal/data/cliente.txt");
            ObjectInputStream oi=new ObjectInputStream(fi);
            while (true){
                Cliente cliente=(Cliente)oi.readObject();
                agregarClientes(cliente);
            }

        }catch (IOException exception){

        } catch (ClassNotFoundException e) {

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
