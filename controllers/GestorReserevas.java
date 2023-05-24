package ProyectoFinal.controllers;

import ProyectoFinal.models.Habitacion;
import ProyectoFinal.models.Reservas;
import ProyectoFinal.utils.Validaciones;

import java.util.ArrayList;

public class GestorReserevas {




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

    }
    static Reservas[] listadoReservas;

    public GestorReserevas(Reservas[] listadoReservas) {
        this.listadoReservas = listadoReservas;
    }

    public static Reservas[] getListadoReservas() {
        return listadoReservas;
    }


    public void setListadoReservas(Reservas[] listadoReservas) {
        this.listadoReservas = listadoReservas;
    }
}
