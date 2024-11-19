/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import Persistencia.DatabaseConnection;
import Persistencia.HuespedRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Huesped;
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
public class HuespedTests {
    private HuespedRepository huespedRepository;
    private Huesped testHuesped;
    private List<Huesped> TestLista;
    
    public HuespedTests() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        // Crear instancia de HuespedRepository
        huespedRepository = new HuespedRepository();

        // Crear un huésped de prueba
        testHuesped = new Huesped(
            12345678, "Juan", "Pérez", 987654321,
            "Dirección", "usuario", "contraseña", "Activo", true
        );

       
        /*TestLista=new ArrayList<>();
        //Crear una lista de huespedes
        TestLista.add(new Huesped(72647899,"Yudi", "Guzman",957199045, "yudi@unmsm.edu.pe","72647899", "yudi00", "Activo", Boolean.TRUE));
        s*/
    
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        System.out.println("AfterEach");
        eliminarHuesped(testHuesped.getDNI());
        //eliminarListaHuesped(TestLista);
       

    }
    public void eliminarHuesped(int dni) {
        String sql = "DELETE FROM huespedes WHERE DNI = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
        
            stmt.setInt(1, dni);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Huesped eliminado exitosamente!");
            } else {
                System.out.println("No se encontró un huesped con ese DNI.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el huesped: " + e.getMessage());
        }
    }
    public void eliminarListaHuesped(List<Huesped> listaHuespedes){
        String sql="DELETE FROM huespedes WHERE DNI = ?";
        try(Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            for(Huesped huespedes : listaHuespedes){
                stmt.setInt(1, huespedes.getDNI());
                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Huesped eliminado exitosamente!");
                } else {
                    System.out.println("No se encontró un huesped con ese DNI.");
                }
                
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el huesped: " + e.getMessage());
        }
    }
    
     @Test
    void testTrue() {
        // Llamar al método que queremos probar
        huespedRepository.crear(testHuesped);

        // Verificar si el huésped fue insertado correctamente
        Huesped creado = huespedRepository.obtener(testHuesped.getDNI());
        assertNotNull(creado, "El huésped no fue encontrado en la base de datos. Revisa el método crear.");
        assertEquals(
            testHuesped.getNombre(), 
            creado.getNombre(), 
            "El nombre del huésped no coincide. Esperado: " + testHuesped.getNombre() + " pero fue: " + creado.getNombre()
        );
        assertEquals(
            testHuesped.getApellido(), 
            creado.getApellido(), 
            "El apellido del huésped no coincide. Esperado: " + testHuesped.getApellido() + " pero fue: " + creado.getApellido()
        );
        assertEquals(
            testHuesped.getDNI(), 
            creado.getDNI(), 
            "El DNI del huésped no coincide. Esperado: " + testHuesped.getDNI() + " pero fue: " + creado.getDNI()
        );
        assertEquals(
            testHuesped.getEsTitular(), 
            creado.getEsTitular(), 
            "El indicador 'Es Titular' no coincide. Esperado: " + testHuesped.getEsTitular() + " pero fue: " + creado.getEsTitular()
        );

      // Esto siempre pasará
    }
    @Test
    void testListaHuespedes(){
        /*huespedRepository.crearHuespedes(TestLista);
        
        //Verificar si el huesped creado es el mismo que tenemos
        Huesped creado = huespedRepository.obtener(72647899);
        assertEquals("Guzman", creado.getApellido());
       */
    }
    
}
