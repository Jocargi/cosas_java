package ProyectoFinal.controllers;

import ProyectoFinal.Exception.ArrayListVacioException;
import ProyectoFinal.models.Cliente;
import ProyectoFinal.models.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase GestorUsuarios para manejar usuarios
 * @author Jorge
 * @version 1.0
 * @since 2023-05-29
 */
public class GestorUsuarios{
    private static ArrayList<Usuario> usuarios = new ArrayList<>();


    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public static boolean buscarUsuario(String correo, boolean esAdmin) {
        if(usuarios.size() < 0){
            return false;
        }
        for (Usuario usuario : usuarios ) {
            if (usuario.getEmail().equals(correo)){
                return (esAdmin && usuario.isRol()) || (!esAdmin && !usuario.isRol());
            }
        }
        return false;
    }

    /**
     * Guarda el arraylist de usuarios en caso de que existan algunos en el arraylist
     * @throws ArrayListVacioException se lanza en caso de que no existan usuarios en el arraylist
     */
    public void guardarUsuarios() throws ArrayListVacioException{
        if(usuarios.size() < 1){
            throw new ArrayListVacioException("Lista de usuarios vacía");
        }
        try{
            FileWriter fw = new FileWriter("./ProyectoFinal/data/usuarios.dat", false);
            for(Usuario usuario : usuarios){
                System.out.println(usuario.formatearObjeto());
                fw.write(usuario.formatearObjeto());
            }
            fw.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
}
