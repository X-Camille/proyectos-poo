Acciones: 
- El jugador saca 3 cartas 
- Se cuenta el puntaje de las cartas 
- El de puntaje 20 exacto gana, sino, gana el que haya sacado el puntaje cercano a 20.
- Si lo supera, pierde. 

Guardar: nombre carta, número

I. MÉTODOS
Métodos principales: 

crearMatrizCartas()
agregarCartas()
inicializarCartasJuegos()
obtenerCartas()
jugar()
salir() // Hará un break para salir del bucle
menu()

Dado que el jugador tiene que sacar 3 cartas, la matriz tendrá 3 columnas y 2 filas. 
En la primera fila se guardará el nombre de la carta. 
En la segunda fila se guardará el valor de la carta. 

Posibles auxiliares a utilizar: 
generarNombreCarta() *la cual retornará una String
generarNumeroCartas() la cual retornará un int* (estas dos funciones no son seguras, se verán en el desarrollo del código)
contarPuntaje(int[][]) la cual retornará un valor resultado tipo int
obtenerResultadoJuego(int puntaje1, int puntaje2) retornará un mensaje tipo String 
mostrarResultado(String resultado) método void, imprimir un mensaje en consola para informar al usuario el resultado del juego

II. VARIABLES 
Matriz de tipo int de dos dimensiones: 
int[][] Matriz 

int numero // Para obtener un número de la carta.

String nombre // Para obtener el nombre aleatorio de la carta.

int opcion // Se utilizará para el método menu() 

int puntajeJugador1 // Almacenará puntaje del jugador 1

int puntajeJugador2  // Almacenará puntaje del jugador 2

String resultado // Tendrá el mensaje del resultado del juego

Se utilizarán más variables, pero las principales son la matriz de 2 dimensiones y la utilización de valores tipo integer. 

Posibles consideraciones: las cartas no se pueden repetir. 
