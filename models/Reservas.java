package ProyectoFinal.models;


import java.io.Serializable;

public class Reservas implements Serializable {
    private String cod;
    private String id_cliente;
    private Habitacion id_habitacion;
    private String fecha_entrada;
    private String fecha_salida;

    public Reservas() {}

    public Reservas(String cod, String id_cliente, Habitacion id_habitacion, String fecha_entrada, String fecha_salida) {
        this.cod = cod;
        this.id_cliente = id_cliente;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public void setId_habitacion(String id) {
    }
}
