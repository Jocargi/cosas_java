package ProyectoFinal.controllers;

import ProyectoFinal.models.Administrador;
import ProyectoFinal.models.Cliente;
import ProyectoFinal.models.Usuario;

import java.util.ArrayList;

    public class GestorAdministradores {


        //constructores

        public GestorAdministradores() {
        }



        //metodos

        /**
         * sirve para mostrar la información básica del cliente
         *
         * @param listadoAdmin
         */
        public static void mostrarAdminstrdores(Administrador[] listadoAdmin) {
            for (Administrador a : listadoAdmin) {
                System.out.println(a.toString());
            }
        }
        static ArrayList<Administrador> listadoAdmin=new ArrayList<>();
        public static void  listadoAdminBase(){


            listadoAdmin.add(new Administrador("pepe","1234","e@e.es",true));

        }

        public static Administrador buscarCliente(String correo) {
            for (Administrador listadoAdminstrador : listadoAdmin ) {
                if (correo.equals(listadoAdminstrador.getEmail())){
                    return listadoAdminstrador;
                }
            }
            System.out.println("admin no encontrado");
            return null;
        }
    }






