import org.junit.jupiter.api.*;
import org.model.Cafe;
import org.model.Cafeteria;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CafeteriaTest {
    Cafe cafe1;
    ArrayList<Cafe> cafes;

    String busqueda;

    @BeforeEach
    public void init() {
        cafe1 = new Cafe(30, 150, "grande", "chocolate");
        busqueda = "grande";
    }

    @Test
    public void buscarCafeTest() {
        boolean cafeCorrecto = true;
        Cafeteria cafeteria = new Cafeteria("Test", "Test", "Test");
        cafeteria.agregarCafe(cafe1);
        ArrayList<Cafe> cafesEncontrados = cafeteria.buscarCafesPorTamano(busqueda);
        for(int i=0; i < cafesEncontrados.toArray().length; i++){
            cafeCorrecto = cafes.get(i) == cafesEncontrados.get(i);
        }
        assertTrue(cafeCorrecto);
    }
}