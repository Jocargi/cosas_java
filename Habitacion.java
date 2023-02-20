package ProyectoFinal;

import java.util.ArrayList;
import java.util.Scanner;

public class Habitacion {
    // Atributos
    private String id;
    private String nombre;
    private String Descripcon;
    private int num_camas;
    private int max_personas;
    private boolean banyera;
    private double precio;
    // Constructor
    public Habitacion(String id, String nombre, String descripcon, int num_camas, int max_personas, boolean banyera ,  double precio) {
        this.id = id;
        this.nombre = nombre;
        Descripcon = descripcon;
        this.num_camas = num_camas;
        this.max_personas = max_personas;
        this.banyera = banyera;
        this.precio=precio;
    }
    // Getter y setter
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
    //Métodos

    /**
     * Sirve para mostrar el nombre, el maximo de personas y el precio de cada habitación
     */
    public void mostrar() {
        System.out.println("Habitacion{" +
                "nombre='" + nombre + '\'' +
                ", max_personas=" + max_personas +
                ", precio=" + precio +
                '}');
    }

    /**
     * Sirve para gestionar los datos de Las habitaciones
     * @param listadoHabitaciones
     */

    public static void GestorDeDatos(ArrayList<Habitacion> listadoHabitaciones) {
        listadoHabitaciones.add(new Habitacion("v777","Vege","vistas a la casa willy",4,5,true,77.7));
        listadoHabitaciones.add(new Habitacion("a192","wii","vistas a las montañas",3,4,true, 53.90));
        listadoHabitaciones.add(new Habitacion("a193","capi","vistas a las montañas",2,2,false , 60.80));
        listadoHabitaciones.add(new Habitacion("a194","bara","vistas a las montañas",3,5,false,2.00 ));
        listadoHabitaciones.add(new Habitacion("a195","Viva","vistas a  España",5,7,true,100.0));
    }

    /**
     * Sirve para operar y mostrar las habitaciones
     * @param numPersonas
     * @param fechaParaEntrar
     * @param fechaParaSalir
     * @param reservas
     * @return las habitaciones
     */
    public static ArrayList habitacion(int numPersonas , String fechaParaEntrar, String fechaParaSalir, Reservas[] reservas){
        Scanner sc=new Scanner(System.in);
        ArrayList <Habitacion> opcionHabitaciones = new ArrayList<>();
        String numeros;
        GestorDeDatos(opcionHabitaciones);
        int fechaEntrada= Validaciones.FechaNumero(fechaParaEntrar);
        int fechaSalida= Validaciones.FechaNumero(fechaParaSalir);
        boolean reservaValida;
        boolean opciones=false;
        ArrayList<Habitacion> opcion= new ArrayList<>();
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
                if (reserva.getId_habitacion() == opcionHabitaciones.get(i).getId()) {
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

            if (numeros.equals("0") || numeros.equals("1") ||numeros.equals("2") ||numeros.equals("3") ||numeros.equals("4")  ){
                System.out.println("La habitación a sido reservada correctamente ");
                opciones=true;
            }else {
                System.out.println("Debe elegir una opción disponible");
                opciones=false;


            }


        }while (!opciones);



        return opcionHabitaciones;
    }
}