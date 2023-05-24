package ProyectoFinal.controllers;


import ProyectoFinal.models.Habitacion;
import ProyectoFinal.models.Reservas;
import ProyectoFinal.utils.Validaciones;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static ProyectoFinal.models.Habitacion.GestorDeDatos;

public class GestorHabitaciones {
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
        ArrayList <Habitacion> opcionHabitaciones = new ArrayList<>();
        String numeros;
        GestorDeDatos(opcionHabitaciones);
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

    public static void GernerarHabitaciones(){
        try {
            FileInputStream fi=new FileInputStream("src/ProyectoFinal/data/habitaciones.txt");
            ObjectInputStream oi=new ObjectInputStream(fi);
            while (true){
                Habitacion habitacion=(Habitacion) oi.readObject();

                opcion.add(habitacion);
            }

        }catch (IOException exception){

        } catch (ClassNotFoundException e) {

        }
    }
}
