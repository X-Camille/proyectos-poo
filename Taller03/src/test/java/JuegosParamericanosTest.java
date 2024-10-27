import org.example.JuegosParamericanos;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class JuegosParamericanosTest {
    JuegosParamericanos juegos = new JuegosParamericanos();

    int[] edades;
    int[] numeroParticipantes;
    boolean[] resultadosEsperadosParaEdades;
    boolean[] getResultadosEsperadosParaNumeroParticipantes;

    @BeforeEach
    public void init() {
        edades = new int[]{-10, 25, 100, 10};
        resultadosEsperadosParaEdades = new boolean[]{false, true, false, false};

        numeroParticipantes = new int[]{100, -100, 0, 1};
        getResultadosEsperadosParaNumeroParticipantes = new boolean[]{false, false, false, true};
    }

    @Test
    public void edadEsValidaTest(){
        boolean resultadoCorrecto = true;
        for(int i=0; i < edades.length; i++){
            if(juegos.edadEsValida(edades[i]) != resultadosEsperadosParaEdades[i]){
                resultadoCorrecto = false;
            }
        }
        assertTrue(resultadoCorrecto);
    }

    @Test
    public void numeroEsValidoTest(){
        boolean resultadoCorrecto = true;
        for(int i=0; i < numeroParticipantes.length; i++){
            if(juegos.numeroEsValido(numeroParticipantes[i]) != getResultadosEsperadosParaNumeroParticipantes[i]){
                resultadoCorrecto = false;
            }
        }
        assertTrue(resultadoCorrecto);
    }
}
