/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import Persistencia.ServiciosAdicionalesRepository;
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
public class ServiciosAdicionalesTest {
    private ServiciosAdicionalesRepository servRepo;
    private ServiciosAdicionales servicioTest;
    
    public ServiciosAdicionalesTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        servRepo = new ServiciosAdicionalesRepository();

        servicioTest=servRepo.obtenerxString("Piscina");
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void obtenerServicio() {
        System.out.println("Servicio obtenido: "+servicioTest.getConcepto() + servicioTest.getId());
    }
}
