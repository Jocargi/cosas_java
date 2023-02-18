package ProyectoFinal;

import java.util.Scanner;


public class Validaciones {
    //Esta función lo que hace es que compruebe que el nombre sea correcto
    public static String nombreYapellidoComprobar(boolean nombre1) {

        String nombre = "";
        boolean nombreBien = false;
        Scanner scan = new Scanner(System.in);
        //Aquí miramos que los caracteres sean de los rangos a-z A-Z
        while (nombreBien == false) {
            if (nombre1){
                System.out.println("nombre: ");
            }else {
                System.out.println("apellido: ");
            }
            nombre = scan.nextLine();
            nombre=nombre.trim();
            nombre = nombre.toUpperCase();
            for (int i = 0; i < nombre.length(); i++) {
                if (nombre.charAt(i) >= 'a' && nombre.charAt(i) <= 'z') {
                    nombreBien = true;
                } else if (nombre.charAt(i) >= 'A' && nombre.charAt(i) <= 'Z') {
                    nombreBien = true;
                } else if ((nombre.charAt(i) == 'Ó')
                        || (nombre.charAt(i) == 'Á') || (nombre.charAt(i) == 'É')
                        || (nombre.charAt(i) == 'Í') || (nombre.charAt(i) == 'Ú') || (nombre.charAt(i) == 'Ç')
                        || (nombre.charAt(i) >= 128 && nombre.charAt(i) <= 144)
                        || (nombre.charAt(i) >= 147 && nombre.charAt(i) <= 154)
                        || (nombre.charAt(i) >= 160 && nombre.charAt(i) <= 167)
                        || (nombre.charAt(i) >= 181 && nombre.charAt(i) <= 183)
                        || (nombre.charAt(i) >= 210 && nombre.charAt(i) <= 216)
                        || (nombre.charAt(i) >= 226 && nombre.charAt(i) <= 237
                        || nombre.charAt(i) == 'ñ'  && nombre.charAt(i) == 'Ñ' )) {
                    nombreBien=true;
                } else if (nombre.charAt(i) == ' ') {
                    nombreBien = true;

                } else {
                    System.out.println("no valido");
                    nombreBien = false;
                    i = nombre.length();
                }
                //Aquí obligamos a que el nombre no empiece por espacios y que no lo dejen vacío
            }
            if (nombre.length() < 1) {
                System.out.println("no valido ");

                nombreBien = false;

            }
        }
        return nombre;
    }

    // esta función se encarga de comprobar que el correo este bien
    public static String comprobarCorreo() {
        String email = "";
        Scanner scan = new Scanner(System.in);
        boolean correoBien = false;
        while (!correoBien) {
            System.out.println("introduce tu email");
            email = scan.nextLine();
            email=email.trim();
            // Aquí comprobamos que haya una @ y que los caracteres estén en los rangos a-z A-Z y 0-9
            int arrobaMail = email.indexOf('@');
            if (arrobaMail > 0) {
                String mailPart1 = email.substring(0, arrobaMail);
                String mailPart2 = email.substring(arrobaMail + 1);
                //Aquí revisamos la primera parte de el mail
                for (int c = 0; c < mailPart1.length(); c++) {
                    if (mailPart1.charAt(c) >= 'a' && mailPart1.charAt(c) <= 'z') {
                        correoBien = true;
                    } else if (mailPart1.charAt(c) >= 'A' && mailPart1.charAt(c) <= 'Z') {
                        correoBien = true;
                    } else if (mailPart1.charAt(c) >= '0' && mailPart1.charAt(c) <= '9') {
                        correoBien = true;

                    } else {
                        System.out.println("la primera parte de tu email no es valida ");
                        correoBien = false;
                        c = mailPart1.length()+1;
                    }
                    //Aquí revisamos la segunda parte de el mail
                }
                if (correoBien) {
                    for (int c = 0; c < mailPart2.length(); c++) {
                        if (mailPart2.charAt(c) >= 'a' && mailPart2.charAt(c) <= 'z') {
                            correoBien = true;
                        } else if (mailPart2.charAt(c) == '.') {
                            correoBien = true;
                        } else {
                            System.out.println(" la parte entre el @ y . no es válida ");
                            correoBien = false;
                            c = email.length();
                        }
                    }
                    if (mailPart2.lastIndexOf('.') > 0 && correoBien) {
                        String finCorreo = mailPart2.substring(mailPart2.lastIndexOf('.'));
                        if (finCorreo.equals(".es") || finCorreo.equals(".com") || finCorreo.equals(".org")) {
                        } else {
                            System.out.println("la extension tiene que ser  .com ,.es o .org");
                            correoBien = false;
                        }
                    } else {
                        System.out.println("la parte después de la @ no es válida ");
                        correoBien = false;
                    }
                } else {
                    System.out.println("el email no es válido ");
                }
            }

        }
        return email;
    }


    //revisa que el teléfono sea correcto
    public static String telefonoBien() {

        Scanner scan = new Scanner(System.in);
        String telefono = "";
        boolean telfValido = false;

        while (telfValido == false) {
            int numero = 0;
            System.out.println("teléfono: ");
            telefono = scan.nextLine();
            telefono=telefono.trim();
            if (telefono.length() < 1) {
                System.out.println("teléfono no válido");
                telfValido = false;
            } else {

                // aqui revisamos que el teléfono empiece por 6 7 8 9
                if (telefono.charAt(0) == '6' || telefono.charAt(0) == '7' || telefono.charAt(0) == '8' || telefono.charAt(0) == '9') {
                    for (int i = 0; i < telefono.length(); i++) {
                        if (telefono.charAt(i) >= '0' && telefono.charAt(i) <= '9') {
                            numero++;
                            telfValido = true;
                        } else if (telefono.charAt(i) == ' ') {
                            telfValido = true;

                        } else {
                            System.out.println("teléfono no valido solo aceptamos números españoles");
                            telfValido = false;
                            i = telefono.length();
                        }
                    } //aqui comprobamos si es fijo o movil
                    if (numero != 9 && telfValido == true) {
                        System.out.println("el teléfono es diferente a 9  dígitos");
                        telfValido = false;
                    }
                    if (telfValido == true) {
                        if (telefono.charAt(0) == '6' || telefono.charAt(0) == '7') {
                            System.out.println("el teléfono es móvil");
                        } else {
                            System.out.println("el teléfono es fijo");
                        }
                    }
                    if (telefono.length() < 1) {
                        System.out.println("tu teléfono no es válido ");

                        telfValido = false;
                    }
                } else {
                    System.out.println("el teléfono no es valido");
                    telfValido = false;
                }
            }
        }
        return telefono;
    }

    public static String fechaCorrecta() {

        boolean fechaBuena = false;
        String fecha = "";
        Scanner scan = new Scanner(System.in);
        int barra1 = 0;
        int barra2 = 0;
        boolean Adias = false;
        boolean Bdias = false;
        boolean febrero = false;
        int anyo = 0;
        String dias = "";
        String meses = "";
        String anyos = "";
        while (!fechaBuena) {
            int diasint=0;
            int barras = 0;
            System.out.println("Fecha nacimiento (dd/mm/aaaa) o  Fecha nacimiento (dd-mm-aaaa: )");
            fecha = scan.nextLine();
            fecha=fecha.trim();
            if (fecha.length() < 5) {
                System.out.println("Fecha demasiado corta");
            } else {

                //Comprueba que el formato es válido
                if (fecha.length() > 5) {
                    for (int i = 0; i < fecha.length(); i++) {
                        if (fecha.charAt(i) >= '0' && fecha.charAt(i) <= '9') {
                            fechaBuena = true;
                        }
                        //Aquí comprobamos que acepte / y -
                        else if (fecha.charAt(i) == '/' || fecha.charAt(i) == '-') {
                            fechaBuena = true;
                            if (barras == 0) {
                                barra1 = i;
                                barras++;
                            } else if (barras == 1 && fecha.charAt(i)==fecha.charAt(barra1)) {
                                barra2 = i;
                                barras++;
                            }

                        } else {
                            System.out.println("Introduce únicamente números");
                            fechaBuena = false;
                            i = fecha.length() + 1;
                        }

                    }
                    //Comprueba que solo ponga 2 espacios
                    if (barras != 2 && fechaBuena) {
                        fechaBuena = false;
                        System.out.println("Tu formato no esta bien");
                    }
                    if (fechaBuena) {
                        //Aquí voy a sacar un String para cada parte de la fecha. Dia , Mes y Año
                        if (fecha.substring(0, barra1).length() == 2 && fecha.substring(0, barra1).length() <=31) {
                            dias = fecha.substring(0, 2);
                            diasint=Integer.parseInt(dias);
                            System.out.println(dias);

                        } else {
                            fechaBuena = false;
                            System.out.println("dia no valido");

                        }
                        if (fecha.substring(barra1 + 1, barra2).length() == 2 ) {
                            meses = fecha.substring(barra1 + 1, barra1 + 3);
                            System.out.println(meses);
                        } else {
                            fechaBuena = false;
                            System.out.println("mes no valido");
                        }
                        if (fecha.substring(barra2 + 1).length() == 4) {
                            anyos = fecha.substring(barra2 + 1);
                            anyo = Integer.parseInt(anyos);

                        } else {
                            System.out.println("año no valido");
                            fechaBuena = false;
                        }
                        if (fechaBuena) {


                            //Aquí comprueba que los meses sean correctos y su cantidad de dias
                            if (meses.charAt(0) == '1') {
                                if (!(meses.charAt(1) >= '0' && meses.charAt(1) <= '2')) {
                                    fechaBuena = false;
                                    System.out.println("fecha no vàlida");
                                } else if (meses.charAt(1) == '1') {
                                    Adias = true;
                                } else {
                                    Bdias = true;
                                }
                            } else if (meses.charAt(0) == '0' || meses.charAt(0)==0) {
                                if (meses.charAt(1) == '0' || meses.charAt(1)==0) {
                                    fechaBuena = false;
                                    System.out.println("fecha no válida");
                                } else if (meses.charAt(1) == '2') {
                                    febrero = true;
                                } else if ((meses.charAt(1) % 2 == 1 && meses.charAt(1) != '9') || meses.charAt(1) == '8') {
                                    Bdias = true;
                                } else {
                                    Adias = true;
                                }
                            }else {
                                fechaBuena = false;
                                System.out.println("mes no válido");
                            }

                            System.out.println(anyo);
                            //Aquí verifica que el rango de años este entre el 1900-2099
                            if (fechaBuena) {
                                if (anyo >= 1930 && anyo < 2099) {

                                } else {
                                    System.out.println(" año no válida");
                                    fechaBuena = false;

                                }
                                //Aquí comprueba si el cliente es mayor de edad
                                if (anyo > 2004) {
                                    fechaBuena = false;
                                    System.out.println("edad no válida  ");
                                }
                            }
                            //Aquí  comprobar el día
                            if (fechaBuena) {
                                if (Bdias) {
                                    if (diasint<1||diasint>31) {
                                        fechaBuena = false;
                                        System.out.println("fecha no válida");
                                    }
                                } else if (Adias) {
                                    if (dias.charAt(0) > '3' || (dias.charAt(0) == '3' && dias.charAt(1) > '0')) {
                                        fechaBuena = false;
                                        System.out.println("fecha no válida");
                                    }
                                } else if (febrero) {
                                    anyo = Integer.parseInt(anyos);
                                    if ((anyo % 4 == 0 && anyo % 100 != 0) || anyo % 400 == 0) {
                                        if (diasint<1||diasint>29) {
                                            fechaBuena = false;
                                            System.out.println("fecha no válida");
                                        }
                                    } else {
                                        if ((!(dias.charAt(0) == '2' && dias.charAt(1) <= '8') || dias.charAt(0) > '2')) {
                                            fechaBuena = false;
                                            System.out.println("fecha no válida");
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    fechaBuena = false;
                    System.out.println("Formato de fecha no válido");
                }
            }
        }
        return fecha;
    }



    public static String fraseControl() {
        String frase="";
        boolean fraseBien=false;
        Scanner scan = new Scanner(System.in);

        while (!fraseBien) {
            int espacio1 = 0;
            int espacio2 = 0;
            int espacio3 = 0;
            int espacioCantidad = 0;
            // se encarga de comprobar todas las frases
            System.out.println("introduce 4 palabras separadas por un espacio");
            frase = scan.nextLine();
            frase=frase.trim();
            for (int i = 0; i < frase.length(); i++) {
                if (frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z') {
                    fraseBien = true;
                } else if (frase.charAt(i) >= 'A' && frase.charAt(i) <= 'Z') {
                    fraseBien = true;

                } else if (frase.charAt(i) == ' ' && !(i == 0)) {
                    espacioCantidad++;
                    fraseBien=true;
                    if (espacioCantidad == 1) {
                        espacio1 = i;
                    } else if (espacioCantidad == 2) {

                        espacio2 = i;
                    } else if (espacioCantidad == 3) {
                        espacio3 = i;
                    }

                } else {
                    System.out.println(" frase no válida");
                    fraseBien = false;
                    i = frase.length();
                }
            }// Aquí se encarga de realizar las operaciones matemáticas
            if (fraseBien && espacioCantidad == 3) {
                String letra1="";
                String letra2="";
                String letra3="";
                String letra4="";
                String palabra1="";
                String palabra2="";
                String palabra3="";
                String palabra4="";
                char letraFinal1=0;
                char letraFinal2=0;
                char letraFinal3=0;
                char letraFinal4=0;

                if (frase.substring(0, espacio1).length() > 1) {
                    palabra1 = frase.substring(0, espacio1 );
                    letra1 = String.valueOf(palabra1.charAt(0));
                    letraFinal1 = palabra1.charAt(palabra1.length() - 1);
                }
                if (frase.substring(espacio1, espacio2).length() > 1) {
                    palabra2 = frase.substring(espacio1+1, espacio2);
                    letra2 = String.valueOf(palabra2.charAt(0));
                    letraFinal2 = palabra2.charAt(palabra2.length() - 1);
                }
                if (frase.substring(espacio2, espacio3).length() > 1) {
                    palabra3 = frase.substring(espacio2+1, espacio3);
                    letra3 = String.valueOf(palabra3.charAt(0));
                    letraFinal3 = palabra3.charAt(palabra3.length() - 1);
                }
                if (frase.substring(espacio3).length() > 1) {
                    palabra4 = frase.substring(espacio3+1);
                    letra4 = String.valueOf(palabra4.charAt(0));
                    letraFinal4 = palabra4.charAt(palabra4.length()-1);
                }
                String part1= letra1+letra2+letra3+letra4;
                part1=part1.toUpperCase();
                int valorLetraFnal1= letraFinal1;
                int valorLetraFnal2= letraFinal2;
                int valorLetraFnal3= letraFinal3;
                int valorLetraFnal4= letraFinal4;
                int resultado=valorLetraFnal1+valorLetraFnal2+valorLetraFnal3+valorLetraFnal4;
                int reulutadoEntre4= resultado/4;
                int Modresultado= resultado%4;
                int resultadoFinal= reulutadoEntre4-Modresultado;
                String part2= Integer.toString(resultado);
                frase=part1+part2;

            }else {
                System.out.println("frase no valida");
                fraseBien=false;

            }

        }
        return frase;
    }
    /**
     *  Para lo que hace es comprobar el número de personas que van a hacer las reservas
     * @return el numero de personas
     */
    public static int NumPersonas(){
        String personas="";
        Scanner sc=new Scanner(System.in);

            System.out.println("introduce el numero de personas deseado");
            personas=sc.nextLine();
            if (personas.length()==0){
                System.out.println("introduzca algo por favor");
                return -1;
            }
            for (int i = 0; i < personas.length(); i++) {

                if (personas.charAt(i)< '0' || personas.charAt(i)> '9'  ){
                    System.out.println("deben ser solo números");
                    return -1;

                }

            }

        return Integer.parseInt(personas);
    }
    //

    /**
     * Lo que hace esta función es comprobar que las fechas de las reservas sea correcta
     * para que no puedan introducirse datos erróneos
     * @param entrda
     *
     * @return la fecha correcta
     */
    public static String fechaReservaCorrecta(boolean entrda) {


        boolean fechaBuena = false;
        String fecha = "";
        Scanner scan = new Scanner(System.in);
        int barra1 = 0;
        int barra2 = 0;
        boolean Adias = false;
        boolean Bdias = false;
        boolean febrero = false;
        int anyo = 0;
        String dias = "";
        String meses = "";
        String anyos = "";

        while (!fechaBuena) {
            int diasint=0;
            int barras = 0;
            if (entrda){
                System.out.println("Fecha entrada (dd/mm/aaaa) o  Fecha entrada (dd-mm-aaaa: )");
            }else {
                System.out.println("Fecha salida (dd/mm/aaaa) o  Fecha salida (dd-mm-aaaa: )");
            }


            fecha = scan.nextLine();
            fecha=fecha.trim();
            if (fecha.length() < 5) {
                System.out.println("Fecha demasiado corta");
            } else {

                //Comprueba que el formato es válido
                if (fecha.length() > 5) {
                    for (int i = 0; i < fecha.length(); i++) {
                        if (fecha.charAt(i) >= '0' && fecha.charAt(i) <= '9') {
                            fechaBuena = true;
                        }
                        //Aquí comprobamos que acepte / y -
                        else if (fecha.charAt(i) == '/' || fecha.charAt(i) == '-') {
                            fechaBuena = true;
                            if (barras == 0) {
                                barra1 = i;
                                barras++;
                            } else if (barras == 1 && fecha.charAt(i)==fecha.charAt(barra1)) {
                                barra2 = i;
                                barras++;
                            }

                        } else {
                            System.out.println("Introduce únicamente números");
                            fechaBuena = false;
                            i = fecha.length() + 1;
                        }

                    }
                    //Comprueba que solo ponga 2 espacios
                    if (barras != 2 && fechaBuena) {
                        fechaBuena = false;
                        System.out.println("Tu formato no esta bien");
                    }
                    if (fechaBuena) {
                        //Aquí voy a sacar un String para cada parte de la fecha. Dia , Mes y Año
                        if (fecha.substring(0, barra1).length() == 2 && fecha.substring(0, barra1).length() <=31) {
                            dias = fecha.substring(0, 2);
                            diasint=Integer.parseInt(dias);
                            System.out.println(dias);

                        } else {
                            fechaBuena = false;
                            System.out.println("dia no valido");

                        }
                        if (fecha.substring(barra1 + 1, barra2).length() == 2 ) {
                            meses = fecha.substring(barra1 + 1, barra1 + 3);
                            System.out.println(meses);
                        } else {
                            fechaBuena = false;
                            System.out.println("mes no valido");
                        }
                        if (fecha.substring(barra2 + 1).length() == 4) {
                            anyos = fecha.substring(barra2 + 1);
                            anyo = Integer.parseInt(anyos);

                        } else {
                            System.out.println("año no valido");
                            fechaBuena = false;
                        }
                        if (fechaBuena) {


                            //Aquí comprueba que los meses sean correctos y su cantidad de dias
                            if (meses.charAt(0) == '1') {
                                if (!(meses.charAt(1) >= '0' && meses.charAt(1) <= '2')) {
                                    fechaBuena = false;
                                    System.out.println("fecha no vàlida");
                                } else if (meses.charAt(1) == '1') {
                                    Adias = true;
                                } else {
                                    Bdias = true;
                                }
                            } else if (meses.charAt(0) == '0' || meses.charAt(0)==0) {
                                if (meses.charAt(1) == '0' || meses.charAt(1)==0) {
                                    fechaBuena = false;
                                    System.out.println("fecha no válida");
                                } else if (meses.charAt(1) == '2') {
                                    febrero = true;
                                } else if ((meses.charAt(1) % 2 == 1 && meses.charAt(1) != '9') || meses.charAt(1) == '8') {
                                    Bdias = true;
                                } else {
                                    Adias = true;
                                }
                            }else {
                                fechaBuena = false;
                                System.out.println("mes no válido");
                            }

                            System.out.println(anyo);
                            //Aquí verifica que el rango de años este entre el 2023-2024
                            if (fechaBuena) {
                                if (anyo >= 2023 && anyo <= 2024) {

                                } else {
                                    System.out.println(" año no válida");
                                    fechaBuena = false;

                                }

                            }
                            //Aquí  comprobar el día
                            if (fechaBuena) {
                                if (Bdias) {
                                    if (diasint<1||diasint>31) {
                                        fechaBuena = false;
                                        System.out.println("fecha no válida");
                                    }
                                } else if (Adias) {
                                    if (dias.charAt(0) > '3' || (dias.charAt(0) == '3' && dias.charAt(1) > '0')) {
                                        fechaBuena = false;
                                        System.out.println("fecha no válida");
                                    }
                                } else if (febrero) {
                                    anyo = Integer.parseInt(anyos);
                                    if ((anyo % 4 == 0 && anyo % 100 != 0) || anyo % 400 == 0) {
                                        if (diasint<1||diasint>29) {
                                            fechaBuena = false;
                                            System.out.println("fecha no válida");
                                        }
                                    } else {
                                        if (((dias.charAt(0) == '2' && dias.charAt(1) <= '8') || dias.charAt(0) > '2')) {
                                            fechaBuena = false;
                                            System.out.println("fecha no válida");
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    fechaBuena = false;
                    System.out.println("Formato de fecha no válido");
                }

            }

        }
        return fecha;
    }

    /**
     * esta función lo que hace es sumar los años y los meses para comprobar  que fecha es mas grande
     * @param Numfechas
     * @return
     */

    public static int MesessumAnyos(int[] Numfechas){

        for (int i = 0; i <= Numfechas[1]; i++) {
            Numfechas[0]+=30;
        }
        Numfechas[0]+=365*Numfechas[2];
        return Numfechas[0];
    }

    /**
     *lo que hace esta función es convertir la fecha en numeros para operar mas facil con ella
      * @param fecha
     * @return fecha combertida en números
     */
   public static int FechaNumero(String fecha){

        String fechas[]=fecha.split("/");
        int Numfechas[]={Integer.parseInt(fechas [0]) ,Integer.parseInt(fechas [1]), Integer.parseInt(fechas [2])};
        return MesessumAnyos(Numfechas);
   }

    /**
     * hace que la salida no sea menor a la entrada
     * @param fechaEntrada
     * @param fechaSalida
     */
   public static boolean SalidaMayorEntrada(String fechaEntrada , String fechaSalida){
        int entrada = FechaNumero(fechaEntrada);
        int salida = FechaNumero(fechaSalida);
        if (!(entrada<=salida)){
            System.out.println("No puedes salir antes de entrar");

        }
        return entrada<=salida;
   }

    /**
     * lo que hace esta función es comprobar que los datos introducidos sean solo numeros
     * @param numeros
     *
     */
    public static boolean SoloNumeros( String numeros){

        for (int i = 0; i < numeros.length(); i++) {

            if (numeros.charAt(i)< '0' || numeros.charAt(i)> '9'  ){
                System.out.println("deben ser solo números");
                return false;
            }
        }
        return true;
    }
}