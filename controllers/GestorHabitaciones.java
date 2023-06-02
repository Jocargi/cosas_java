package ProyectoFinal.controllers;


import ProyectoFinal.Interfaces.BuscarHabitaciones;
import ProyectoFinal.models.Habitacion;
import ProyectoFinal.models.Reservas;
import ProyectoFinal.utils.Validaciones;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class GestorHabitaciones implements BuscarHabitaciones {


    /**
     * Sirve para operar y mostrar las habitaciones
     * @param numPersonas
     * @param fechaParaEntrar
     * @param fechaParaSalir
     * @param reservas
     * @return las habitaciones con todos los datos introducidos correctamente
     */

    static ArrayList<Habitacion> opcion= new ArrayList<>();
    public static ArrayList habitacion(int numPersonas , String fechaParaEntrar, String fechaParaSalir, Reservas[] reservas){
        Scanner sc=new Scanner(System.in);
        ArrayList <Habitacion> opcionHabitaciones = opcion;
        String numeros;

        int fechaEntrada= Validaciones.FechaNumero(fechaParaEntrar);
        int fechaSalida= Validaciones.FechaNumero(fechaParaSalir);
        boolean reservaValida;
        boolean opciones=false;


        System.out.println("Estas son todas las opciones disponibles");
        //Busca posibles opciones de reserva

        for (int i = 0; i < opcionHabitaciones.size(); i++) {
            System.out.println("Opcion "+ i);
            opcion = new ArrayList<>();

            opcion.add(opcionHabitaciones.get(i));
            reservaValida = true;
            //Si la habitación por si sola no puede contener tanta gente busca otra habitación para complementarla
            if (opcionHabitaciones.get(i).getMax_personas()<numPersonas){
                for (Habitacion habitacionComplementaria : opcionHabitaciones) {
                    if (habitacionComplementaria == opcionHabitaciones.get(i)){
                        continue;
                    }
                    if (opcionHabitaciones.get(i).getMax_personas() + habitacionComplementaria.getMax_personas() >= numPersonas) {
                        opcion.add(habitacionComplementaria);
                        break;
                    }
                }
            }
            for (Reservas reserva : reservas) {
                if (reserva == null){
                    break;
                }

                    if (Validaciones. FechaNumero(reserva.getFecha_entrada()) >= fechaEntrada &&
                            Validaciones. FechaNumero(reserva.getFecha_entrada()) >= fechaSalida) {
                        reservaValida = false;
                        break;
                    } else if (Validaciones. FechaNumero(reserva.getFecha_salida()) >= fechaEntrada &&
                            Validaciones. FechaNumero(reserva.getFecha_salida()) >= fechaSalida) {
                        reservaValida = false;
                        break;
                    }

            }
            double precioTotal = 0;
            int maxPersonas=0;
            if (reservaValida) {
                for (Habitacion habitacionNecesaria : opcion) {
                    habitacionNecesaria.mostrar();
                    precioTotal += habitacionNecesaria.getPrecio();
                    maxPersonas += habitacionNecesaria.getMax_personas();
                }
                System.out.println("Precio Final: " + precioTotal);
                if (maxPersonas<numPersonas){
                    System.out.println("no hay capacidad necesaria en esta habitación");
                }
            }
            System.out.println("");

        }
        //Aquí eliges la opción que tu quieras
        do {
            System.out.println("Elige una habitación");
            numeros=sc.nextLine();

            if (numeros.equals("0") || numeros.equals("1") ||numeros.equals("2") ||numeros.equals("3") ||numeros.equals("4")||numeros.equals("5")||numeros.equals("6")||numeros.equals("7")||numeros.equals("8") ){
                System.out.println("La habitación a sido reservada correctamente ");
                opciones=true;
            }else {
                System.out.println("Debe elegir una opción disponible");
                opciones=false;


            }

        }while (!opciones);

        return opcionHabitaciones;
    }
    static ArrayList<Habitacion> listadoHanitaciones = new ArrayList<>();

    public static Habitacion crearHabitaciones(){
        Scanner entrada= new Scanner(System.in);
        String id = null;
        String nombre;
        String descripcon;
        int numCamas = 0;
        int max_personas = 0;
        boolean banyera = false;
        double precio = 0;
        boolean opcionValida=false;

        //TODO llamar excepciones donde se encuentran los return vacíos
        do {
            System.out.println("Escribe en Id de la habitación");
            try {
                id= entrada.nextLine();
                System.out.println("El id es:" + id);
                if (id.equalsIgnoreCase("exit")){
                    return null;
                }
                opcionValida=true;
            }catch (InputMismatchException inputMismatchException){
                System.out.println("Numero de puerta tiene que ser un numero");
            }
        }while (!opcionValida);

        //Pedir Y Comprobar Nombre
        nombre = Validaciones.nomHabitacion(true);
        System.out.println("El nombre de la habitación es: " + nombre);
        if (nombre.equalsIgnoreCase("exit")) {
            return null;
        }
        //Pedir Y Comprobar Descripcion

        descripcon = Validaciones.nomHabitacion(false);
        System.out.println("La descripción de la habitación es: " + descripcon);
        if (descripcon.equalsIgnoreCase("exit")) {
            return null;
        }

        //Pedir Y Comprobar Numero de camas
        do {
            System.out.println("Escribe el numero de camas");
            try {
                String camas= entrada.nextLine();

                numCamas= Integer.parseInt(camas);
                System.out.println("El numero de camas es:" + numCamas);
                opcionValida=true;
            }catch (NumberFormatException inputMismatchException){
                System.out.println("Numero de camas tiene que ser un numero");
                opcionValida=false;
            }
        }while (!opcionValida);


        //Pedir Y Comprobar Máximo de personas
        do {
            System.out.println("Escribe el máximo de personas");
            try {
                String personas= entrada.nextLine();
                if (personas.equalsIgnoreCase("exit")){
                    return null;
                }
                max_personas= Integer.parseInt(personas);
                System.out.println("El numero de personas es:" + personas);
                opcionValida=true;
            }catch (NumberFormatException inputMismatchException){
                System.out.println("max_personas no valido");
                opcionValida=false;
            }
        }while (!opcionValida);
        //Pedir Y Comprobar Bañera
        do {
            System.out.println("¿Tiene bañera? S/N");
            try {
                String banera= entrada.nextLine();
                if (banera.equalsIgnoreCase("s")){
                    banyera=true;
                    opcionValida=true;
                    System.out.println("Si tiene bañera");
                }else if (banera.equalsIgnoreCase("n")){
                    banyera=false;
                    opcionValida=true;
                    System.out.println("No tiene bañera");
                }else {
                    System.out.println("Opción incorrecta");
                    opcionValida=false;
                }
            }catch (InputMismatchException inputMismatchException){
            }
        }while (!opcionValida);

        //Pide el precio por noche
        do {
            System.out.println("Escribe precio por noche");
            try {
                String precioHabitacion= entrada.nextLine();
                if (precioHabitacion.equalsIgnoreCase("exit")){
                    return null;
                }
                precio= Double.parseDouble(precioHabitacion);
                System.out.println("El precio por noche es:" + precio);
                opcionValida=true;
            }catch (NumberFormatException inputMismatchException){
                System.out.println("Precio no valido. Insterta solo numeros");
                opcionValida=false;
            }
        }while (!opcionValida);
        listadoHanitaciones.add(new Habitacion(id,nombre,descripcon,numCamas,max_personas,banyera,precio));


        return null;
    }







    public static void GernerarHabitaciones(){
        try {
            FileInputStream fi=new FileInputStream("data/habitaciones.txt");
            ObjectInputStream oi=new ObjectInputStream(fi);
            while (true){
                Habitacion habitacion=(Habitacion) oi.readObject();
                listadoHanitaciones.add(habitacion);

            }
        }catch (IOException exception){

        } catch (ClassNotFoundException e) {


        }
    }

    public static void ActualizarHabitacion (String id) {
        for (int i=0;i<listadoHanitaciones.size(); i++ ) {
            if (id.equals(listadoHanitaciones.get(i).getId())){

                listadoHanitaciones.set(i, crearHabitaciones());
            }
        }
        System.out.println("cliente no encontrado");

    }


    public static ArrayList<Habitacion> getListadoHanitaciones() {
        return listadoHanitaciones;
    }

    public static void mostrarHabitaciones(Habitacion[] listadoHabitaciones) {
        for (Habitacion a : listadoHabitaciones) {
            System.out.println(a.toString());
        }
    }



    public static Habitacion buscarHabitacion(String id) {
        for(Habitacion listadoHabitacion : listadoHanitaciones ) {
            if (id.equals(listadoHabitacion.getId())){
                return listadoHabitacion;
            }
        }
        System.out.println("Habitación no encontrada");
        return null;
    }

    public static void eliminarHabitaciones(String id) {
        Habitacion habitacionEncontrada = null;
        for (Habitacion habitacion : listadoHanitaciones) {
            if (id.equals(habitacion.getId())) {
                habitacionEncontrada = habitacion;
                break;
            }
        }

        if (habitacionEncontrada != null) {
            listadoHanitaciones.remove(habitacionEncontrada);
            System.out.println("habitación eliminada correctamente.");
        } else {
            System.out.println("habitación no encontrada.");
        }
    }
}
