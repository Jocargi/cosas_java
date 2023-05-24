package ProyectoFinal.models;
import java.util.ArrayList;
/**
 * @author Jorge Carmona Girona
 * @version 1.0
 * @since 12/1/2023
 * Es la clase que sirve para generar habitaciones
 */
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

    /**
     *
     * @param id
     * @param nombre
     * @param descripcon
     * @param num_camas
     * @param max_personas
     * @param banyera
     * @param precio
     */
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
        listadoHabitaciones.add(new Habitacion("a199","VivaLaVida","vistas a  España",2,2,true,100.0));
    }


}