package ProyectoFinal;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {


    private static void CrearReservas(){
        int numPersonas;
        boolean fechaValida;
        String fechaReserva;
        String fechaSalida;
        ArrayList habitaciones;
        Reservas[]reservas=new Reservas[2];
        do {
            numPersonas= Validaciones.NumPersonas();
        }while (numPersonas<=0);

        do {
           fechaReserva= Validaciones.fechaReservaCorrecta(true);
           fechaSalida= Validaciones.fechaReservaCorrecta(false);
            fechaValida= Validaciones.SalidaMayorEntrada(fechaReserva , fechaSalida);
        }while (fechaValida=false);
        habitaciones= Habitacion.habitacion(numPersonas, fechaReserva,fechaSalida,reservas);
    }
    public static void Menupreguntas(){
        Scanner sc =new Scanner(System.in);
        System.out.println("***** PREGUNTAS FRECUENTES *****");
        ArrayList <String> preguntas=new ArrayList<String>();
        preguntas.add(" Salir");
        preguntas.add(" Agregar preguntas");
        preguntas.add(" ¿Cómo puedo llamar fuera del hotel con el teléfono de la habitación?");
        preguntas.add(" ¿Es gratis la comida de la nevera de la habitación?");

        for (int i = 0; i < preguntas.size(); i++) {
            System.out.println(i + "." + preguntas.get(i));
        }
        String opcionPregunta;

        do {
            System.out.println("Elige una opción del 0 al 3");
            opcionPregunta=sc.nextLine();

            if (!Validaciones.SoloNumeros(opcionPregunta)){}
            else {
                if (opcionPregunta.length()==0 || opcionPregunta.equals(" ")){
                    System.out.println("escriba algo por favor ");

                }
                if (opcionPregunta.equals("1")){
                    String peguntaNueva;
                    System.out.println("añada preguntas ");
                    peguntaNueva=sc.nextLine();

                    if (peguntaNueva.length()==0){
                        System.out.println("debe contener algo");
                        return;

                    }
                    preguntas.add(peguntaNueva);
                    System.out.println("tendremos sus preguntas en cuenta");
                }
                if (opcionPregunta.equals("2")){
                    System.out.println("no se puede");

                }
                if (opcionPregunta.equals("3")){
                    System.out.println("Si la comida de las neveras de las habitaciones son gratis");
                }

            }
        }while (!opcionPregunta.equals("0"));
    }
    public static void main(String[] args) {
        ArrayList<Habitacion> listadoHabitaciones=new ArrayList<>();
        Reservas[]reserva=new Reservas[2];



        Scanner scan=new Scanner(System.in);
        String opcion;
        String opcion2;
        boolean nose =false;
        do {
            System.out.println("****************************");
            System.out.println("********** Tribago *********");
            System.out.println("****************************");
            System.out.println("1 registro de usuario");
            System.out.println("2 loguin de usuario");
            System.out.println("0 salir");
            System.out.println("elige una opción:");
            opcion=scan.nextLine();



                switch (opcion) {
                    case "1":
                        System.out.println("************");
                        System.out.println("* registro* ");
                        System.out.println("************");
                        System.out.println("Introduce los siguientes datos:");
                        System.out.println("------------------------------------");
                        String nombre = Validaciones.nombreYapellidoComprobar(true);
                        String apellidos=Validaciones.nombreYapellidoComprobar(false);
                        String correo = Validaciones.comprobarCorreo();
                        String teléfono = Validaciones.telefonoBien();
                        String fecha = Validaciones.fechaCorrecta();
                        String frase = Validaciones.fraseControl();
                        System.out.println(frase);

                        System.out.println("Frase de control (6 palabras separadas por espacios): ");

                        break;
                    case "2":
                        while (!nose) {
                            System.out.println("pon tu correo");
                            String correolog = "correo@prueba.es";

                            String codprueba = "AAA123";
                            System.out.println("introduzca el correo de prueba = correo@prueba.es y el código de prueba AAA123");
                            String guardarCosas = scan.nextLine();
                            guardarCosas=guardarCosas.trim();
                            if (correolog.equals(guardarCosas)) {
                                System.out.println("introduzca el correo de prueba = correo@prueba.es y el código de prueba AAA123");
                                System.out.println("código ");
                                guardarCosas = scan.nextLine();
                                guardarCosas=guardarCosas.trim();
                                while (codprueba.equals(guardarCosas)) {

                                    System.out.println("1 Reservar habitación");
                                    System.out.println("2 Atención al cliente");
                                    System.out.println("3 pago online");
                                    System.out.println("4 salir");
                                    opcion2 = scan.nextLine();

                                    switch (opcion2) {


                                        case "1":
                                            CrearReservas();

                                            break;
                                        case "2":
                                            Menupreguntas();

                                            break;
                                        case "3":
                                            System.out.println("esta función no esta disponible");

                                            break;
                                        case "4":


                                            break;
                                    }


                                    nose=true;
                                    if (opcion2.equals("4"))break;
                                }
                            }
                        }
                        break;
                }
            }while (!opcion.equals("0"));
        }

    }


