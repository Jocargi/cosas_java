package ProyectoFinal.controllers;

import ProyectoFinal.models.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GestorClientesTest {
    Cliente clienteP;
    @BeforeEach void setUp(){

        clienteP=new Cliente("n","n","13","aeretr@a.es","123456789","12/12/2004","AAA123");
    };
    @AfterEach
    void tearDown(){
        GestorClientes.listadoCliente=new ArrayList<>();
    }


    @Test
    void generarClientesBase() {
        int longitudInicial= GestorClientes.listadoCliente.size();
        GestorClientes.generarClientesBase();
        assertAll(
                ()-> assertEquals(longitudInicial+9, GestorClientes.listadoCliente.size())

        );

    }

    @Test
    void mostrarClientes() {
    }

    @Test
    void buscarCliente() {
        GestorClientes.agregarClientes(clienteP);
        assertAll(
                ()-> assertEquals(clienteP,GestorClientes.buscarCliente(clienteP.getEmail()))
        );

    }

    @Test
    void agregarClientes() {
       int longitudInicial= GestorClientes.listadoCliente.size();
       GestorClientes.agregarClientes(clienteP);
        assertAll(
                ()-> assertEquals(longitudInicial+1, GestorClientes.listadoCliente.size()),
                ()-> assertEquals(clienteP,GestorClientes.listadoCliente.get(GestorClientes.listadoCliente.size()-1))

        );

    }
}