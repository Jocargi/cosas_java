package ProyectoFinal.Exception;

/**
 * Excepcion para los arraylist que se encuentran vacios
 * Estos pueden generar problemas a la hora de guardar el arraylist en ficheros
 *
 * @author Jorge
 * @version 1.0
 * @since 2023-05-31
 */
public class ArrayListVacioException extends Exception{
    private String mensaje;
    public ArrayListVacioException(String mensaje){
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage(){
        return mensaje;
    }
}
