package ProyectoFinal.Exception;

public class FechaNoValidaException extends Exception{
    public String mensaje;

    public FechaNoValidaException(String mensaje){this.mensaje =mensaje;}


    public  String getMessage(){return mensaje;}
}
