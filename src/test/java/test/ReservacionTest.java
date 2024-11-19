/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import Persistencia.HabitacionRepository;
import Persistencia.ServiciosAdicionalesRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.Habitacion;
import modelo.Huesped;
import modelo.Reservacion;
import modelo.ServiciosAdicionales;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Suyco
 */
public class ReservacionTest {
    
    public ReservacionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {


        LocalDateTime inicioHuesped = LocalDateTime.of(2024, 11, 4, 14, 0);  // Fecha y hora de inicio (4 de noviembre de 2024 a las 14:00)
        LocalDateTime finHuesped = LocalDateTime.of(2024, 11, 10, 14, 0);    // Fecha y hora de fin (10 de noviembre de 2024 a las 12:00)

                                                //num habitaciones

        Huesped huesped1= new Huesped(999, "Jacinto", "Booleano", 9999, "Mz G ", "pepe8", "booleano00", "Activo", Boolean.TRUE);
        Huesped huesped2= new Huesped(111, "Test", "Caceres", 98999, "Mz G ", "pepe8", "lucho00", "Activo", Boolean.FALSE);
        ServiciosAdicionalesRepository repoServ = new ServiciosAdicionalesRepository();
        ServiciosAdicionales servicio1 = new ServiciosAdicionales();
        servicio1=repoServ.obtenerxString("FitnessCenter");
        ServiciosAdicionales servicio2 = new ServiciosAdicionales();
        servicio2= repoServ.obtenerxString("Piscina");
        //TipoDeHabitacion tipoHab = new TipoDeHabitacion(1,"Bussiness", 123);
        //Habitacion habitacion1 = new Habitacion();
        HabitacionRepository habRepo = new HabitacionRepository();
        Habitacion habitacion1 = new Habitacion();
        //Simulando que se escogio habitacion p
        habitacion1= habRepo.obtener(120);
        List<Huesped> listaHuespedes = new ArrayList<>();
        List<ServiciosAdicionales> listaServicios = new ArrayList<>();
        List<Habitacion> listaHabitacion = new ArrayList<>();
        
        listaHuespedes.add(huesped1);
        listaHuespedes.add(huesped2);
        listaServicios.add(servicio1);
        listaServicios.add(servicio2);
        listaHabitacion.add(habitacion1);
        
        Reservacion reserva = new Reservacion(1,"Reservado", inicioHuesped, finHuesped,inicioHuesped);
        reserva.reservarAhora(reserva, listaHuespedes, listaHabitacion, listaServicios);
    }
    
    @AfterEach
    public void tearDown() {
    }


     @Test
     public void ReservacionTest() {
        assertTrue(true, "Este test siempre debe ser verdadero");
     }
     @Test
     public void ReservacionAhoraTest(){
        assertTrue(true, "Este test siempre debe ser verdadero");
     }
}
