/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Persistencia.InicioSesionRepository;
import java.io.IOException;


/**
 *
 * @author Suyco
 */
public class InicioSession {
    
    private static Personal usuarioActual;
    private static Huesped huespedActual;

    
    public static void iniciarSesion(String usuario, String contraseña) throws IOException {
        InicioSesionRepository identificarUsuario = new InicioSesionRepository();
        usuarioActual = identificarUsuario.iniciarSesion(usuario, contraseña);

        if (usuarioActual != null) {
            //iniciarSesion LogIn = new iniciarSesion();
            //LogIn.setVisible(false);
            mostrarVistaCorrespondiente();
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
    
    public static void iniciarSesionHuesped(String usuario, String contraseña) throws IOException{
        InicioSesionRepository identificarUsuario = new InicioSesionRepository();
        huespedActual = identificarUsuario.iniciarSesionHuesped(usuario, contraseña);
        
        if (huespedActual != null){
            //iniciarSesion LogIn = new iniciarSesion();
            //LogIn.setVisible(false);
            //vistaHuesped vistaHuesped = new vistaHuesped(huespedActual);
            //vistaHuesped.setVisible(true);
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    private static void mostrarVistaCorrespondiente() throws IOException {
        if (usuarioActual instanceof Administrador) {
            /*Administrador administrador = (Administrador) usuarioActual;
            System.out.println("Abriendo vista de administrador");
           vistaAdministrador vistaAdmin = new vistaAdministrador(administrador);
            vistaAdmin.setVisible(true);*/
        } else if (usuarioActual instanceof Recepcionista) {
            /*Recepcionista recepcionista = (Recepcionista) usuarioActual;
            System.out.println("Abriendo vista de recepcionista");
            vistaRecepcionista vistaRecepionista = new vistaRecepcionista(recepcionista);
            vistaRecepionista.setVisible(true);*/
        } else if(usuarioActual instanceof AmaDeLlaves) { 
            /*AmaDeLlaves amaLlaves = (AmaDeLlaves) usuarioActual;
            System.out.println("Abriendo vista del ama de llaves");
            vistaAmaLLaves vistaAma = new vistaAmaLLaves(amaLlaves);
            vistaAma.setVisible(true);*/
        } else if (usuarioActual instanceof KitchenManager){
            /*KitchenManager jefeCocina = (KitchenManager) usuarioActual;
            System.out.println("Abriendo vista del jefe de cocina");
            vistaJefeCocina vistaCocina = new vistaJefeCocina(jefeCocina);
            vistaCocina.setVisible(true);
        */} else {
            System.out.println("Tipo de usuario no reconocido.");
        }
    }

    public static void cerrarSesion() {
        usuarioActual = null;
        huespedActual = null;
        java.awt.Window[] windows = java.awt.Window.getWindows();
        for (java.awt.Window window : windows) {
            window.dispose(); // Cerrar todas las ventanas abiertas
        }
        //iniciarSesion LogIn = new iniciarSesion();
        //LogIn.setVisible(true);
        System.out.println("Sesion cerrada. Volviendo a la vista de inicio de sesion.");
    }
    
    

}
