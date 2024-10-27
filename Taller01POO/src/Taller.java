import java.util.Scanner;
import java.util.Random;

public class Taller {
    public static void main(String[] args) {
        menu();
    }

    public static String[][] crearMatrizCartas() {
        String[][] matriz = new String[2][12];
        /*agregarCartas(matriz, "As", "1");
        agregarCartas(matriz, "Dos", "2");
        agregarCartas(matriz, "Tres", "3");
        agregarCartas(matriz, "Cuatro", "4");
        agregarCartas(matriz, "Cinco", "5");
        agregarCartas(matriz, "Seis", "6");
        agregarCartas(matriz, "Siete", "7");
        agregarCartas(matriz, "Ocho", "8");
        agregarCartas(matriz, "Nueve", "9");
        agregarCartas(matriz, "Jota/Reina/Rey", "10");  */
        matriz = agregarCartas(matriz, "As", "3");
        return matriz;

    }

    public static String[][] agregarCartas(String[][] matriz, String nombre, String numero) {
        /*for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == null) {
                matriz[i][0] = nombre;
                matriz[i][1] = numero;
            }
        }       */
        matriz[0][1] = "As";
        matriz[0][2] = "Dos";
        matriz[0][3] = "Tres";
        matriz[0][4] = "Cuatro";
        matriz[0][5] = "Cinco";
        matriz[0][6] = "Seis";
        matriz[0][7] = "Siete";
        matriz[0][8] = "Ocho";
        matriz[0][9] = "Nueve";
        matriz[0][10] = "Jota/Reina/Rey";

        matriz[1][1] = "11";
        matriz[1][2] = "2";
        matriz[1][3] = "3";
        matriz[1][4] = "4";
        matriz[1][5] = "5";
        matriz[1][6] = "6";
        matriz[1][7] = "7";
        matriz[1][8] = "8";
        matriz[1][9] = "9";
        matriz[1][10] = "10";  
        return matriz;
      }

      public static String obtenerResultados(int puntaje1, int puntaje2) {
        if(puntaje1==20) {
            return "El jugador 1 fue el ganador con un puntaje de 20 pts";
        } else if(puntaje2==20) {
            return "El jugador 2 fue el ganador con un puntaje de 20 pts";
        } else if(puntaje1 < puntaje2 || puntaje1 > 20) {
            return "El jugador 2 ha ganado con un puntaje de " + puntaje2 + " pts";
        } else if(puntaje2 < puntaje1 || puntaje2 > 20) {
            return "El jugador 1 ha ganado con un puntaje de" + puntaje1 + " pts";
        }
        return "Empate";
      }


      public static void inicializarCartasJuegos(String[][] matriz){
        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;

        for(int i=0; i<3; i++) {
             System.out.println("Jugador 1: ");
             puntajeJugador1+=obtenerCartas(matriz);
             System.out.println("Jugador 2: ");
             puntajeJugador2+=obtenerCartas(matriz);
         }
         String resultado = obtenerResultados(puntajeJugador1, puntajeJugador2);
         System.out.println(resultado);
      }

      public static int obtenerCartas(String[][] matriz){
        // Método que le entregará una carta aleatoria
        int indice_aleatorio = obtenerIndiceAleatorio();
        System.out.println("Su carta es " + matriz[0][indice_aleatorio]);
        String valor_carta = matriz[1][indice_aleatorio];
        int valor = Integer.parseInt(valor_carta);

        return valor;
      }

      public static int obtenerIndiceAleatorio(){
        Random random = new Random();
        int indice_aleatorio = random.nextInt(10)+1;
        return indice_aleatorio;
      }


      public static void jugar(){
        String[][] matriz = crearMatrizCartas();
        // Son 3 intentos por lo que se realizará un bucle for
        inicializarCartasJuegos(matriz);  

      }

      public static void mostrarOpciones(){
        System.out.println("1. Jugar");
        System.out.println("2. Salir");
        System.out.println("Ingrese una opción: ");
      }

      public static void menu() {
          Scanner teclado = new Scanner(System.in);
          System.out.println("Bienvenido");
          mostrarOpciones();
          int opcion = teclado.nextInt();

          while(opcion!=0) {
              if (opcion == 1) {
                  jugar();
                  mostrarOpciones();
              }
              else{
                  System.out.println("Opción inválida");
                  }    
              opcion=teclado.nextInt();
              }
          }
      }
