package ProyectoFinal.Exception;



public class ArchivoNoEncontrado extends Exception  {

        public String mensaje;

        public ArchivoNoEncontrado(String mensaje){this.mensaje =mensaje;}


        public  String getMessage(){return mensaje;}

}
