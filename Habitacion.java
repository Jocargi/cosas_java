package ProyectoFinal;

import java.util.ArrayList;
import java.util.Scanner;

public class Habitacion {
    private String id;
    private String nombre;
   private String Descripcon;
   private int num_camas;
   private int max_personas;
   private boolean banyera;




    public Habitacion(String id, String nombre, String descripcon, int num_camas, int max_personas, boolean banyera) {
        this.id = id;
        this.nombre = nombre;
        Descripcon = descripcon;
        this.num_camas = num_camas;
        this.max_personas = max_personas;
        this.banyera = banyera;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcon() {
        return Descripcon;
    }

    public void setDescripcon(String descripcon) {
        Descripcon = descripcon;
    }

    public int getNum_camas() {
        return num_camas;
    }

    public void setNum_camas(int num_camas) {
        this.num_camas = num_camas;
    }

    public int getMax_personas() {
        return max_personas;
    }

    public void setMax_personas(int max_personas) {
        this.max_personas = max_personas;
    }

    public boolean isBanyera() {
        return banyera;
    }

    public void setBanyera(boolean banyera) {
        this.banyera = banyera;
    }

    public static void GestorDeDatos(ArrayList<Habitacion> listadoHabitaciones) {
        listadoHabitaciones.add(new Habitacion("v777","Vege","vistas a la casa willy",4,5,true));
        listadoHabitaciones.add(new Habitacion("a192","wii","vistas a las montañas",3,4,true));
        listadoHabitaciones.add(new Habitacion("a193","capi","vistas a las montañas",2,2,false));
        listadoHabitaciones.add(new Habitacion("a194","bara","vistas a las montañas",3,5,false));
        listadoHabitaciones.add(new Habitacion("a195","Viva","vistas a  España",5,7,true));

    }
    public static ArrayList habitacion(int numPersonas , String fechaParaEntrar, String fechaParaSalir, Reservas[] reservas){
        Scanner sc=new Scanner(System.in);
        ArrayList <Habitacion> opcionHabitaciones = new ArrayList<>();
        GestorDeDatos(opcionHabitaciones);
        int fechaEntrada;
        int fechaSalida;
        ArrayList<Habitacion> opcion=new ArrayList<>();
        System.out.println("Estas son todas las opciones disponibles");

        for (int i = 0; i <opcionHabitaciones.size(); i++) {
            System.out.println(i);
            opcion=new ArrayList<>();

        }



        return null;
    }


}



