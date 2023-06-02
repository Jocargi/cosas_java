package ProyectoFinal.controllers;

import ProyectoFinal.Exception.ArchivoNoEncontrado;
import ProyectoFinal.models.Cliente;
import ProyectoFinal.models.Habitacion;
import ProyectoFinal.models.Reservas;
import ProyectoFinal.utils.Validaciones;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorReserevas {
static ArrayList<Reservas[]> listadoReservas=new ArrayList<>();



    /**
     * Sirve para que el cliente pueda hacer una reserva
     */
    public static void CrearReservas(){
        int numPersonas;
        boolean fechaValida;
        String fechaReserva;
        String fechaSalida;
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        Reservas[]reservas=new Reservas[61];
        do {
            numPersonas= Validaciones.NumPersonas();
        }while (numPersonas<=0);

        do {
            fechaReserva= Validaciones.fechaReservaCorrecta(true);
            fechaSalida= Validaciones.fechaReservaCorrecta(false);
            fechaValida= Validaciones.SalidaMayorEntrada(fechaReserva , fechaSalida);
        }while (fechaValida==false);
        habitaciones= GestorHabitaciones.habitacion(numPersonas, fechaReserva,fechaSalida,reservas);
        if (habitaciones==null){
            System.out.println("No hay habitaciones disponibles");
            return;

        }
        //se encarga de crear las reservas
        for (int i = 0; i < habitaciones.size(); i++) {
            reservas[i] = new Reservas();
            reservas[i].setFecha_entrada(fechaReserva);
            reservas[i].setFecha_salida(fechaSalida);
            reservas[i].setId_habitacion(habitaciones.get(i).getId());


        }
        listadoReservas.add(reservas);

        try {

            FileOutputStream reservasFos = new FileOutputStream("./ProyectoFinal/data/reservas.txt");
            ObjectOutputStream reservasOos= new ObjectOutputStream(reservasFos);

            for (Cliente cliente: GestorClientes.getListadoCliente()) {
                reservasOos.writeObject(cliente);
            }
            throw new ArchivoNoEncontrado("lo siento no encontrmos el archivo");
        } catch (ArchivoNoEncontrado ar){
            System.out.println(ar.getMessage());

        } catch (IOException e){

        }

    }






    public GestorReserevas(ArrayList<Reservas[]> listadoReservas) {
        this.listadoReservas = listadoReservas;
    }

    public static ArrayList<Reservas[]> getListadoReservas() {
        return listadoReservas;
    }


    public void setListadoReservas(ArrayList<Reservas[]> listadoReservas) {
        this.listadoReservas = listadoReservas;
    }
}
