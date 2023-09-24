import java.util.Random;
import java.util.Scanner;

public class BolsaDinosaurios {

    //Variable Inicial
    static String bolsa_de_dinosaurios = "ttttttttvvvvvvvvaaaaaaaabbbbbbbbddddddddssssssss";

    //Metodo para elegir 6 especies de manera aleatoria
    public static String primeraRonda() {

        //Variables
        String letrasSeleccionadas = "";
        Random random = new Random();

        //Extractor de letras
        for (int i = 0; i < 6; i++) {
            int indiceAleatorio = random.nextInt(bolsa_de_dinosaurios.length());
            char letra = bolsa_de_dinosaurios.charAt(indiceAleatorio);
            letrasSeleccionadas += letra;
            bolsa_de_dinosaurios = bolsa_de_dinosaurios.substring(0, indiceAleatorio) +
                    bolsa_de_dinosaurios.substring(indiceAleatorio + 1);
        }
        return letrasSeleccionadas;
    }
        
    //DinoValidador
    public boolean dinoValidador(char dino, String cartas) {

        for (int i = 0; i <cartas.length(); i++ ){
            char indiceCartas = cartas.charAt(i);
            if (dino == indiceCartas) {
                return true;
            }
        }
        System.out.println("Entrada de dinosaurio inválida");
        return false;
    }

    //ZonaValidador
    public boolean zonaValidador(int zona){
        if (zona <= 6 && zona > 0){
            return true;
        }
        else {
            System.out.println("Selección de zona inválida");
            return false;
        }
    }

    public static void Correr(){
        //Ronda 1
        String baraja1_ronda1 = primeraRonda();
        String baraja2_ronda1 = primeraRonda();

        //Ronda 2
        String baraja1_ronda2 = primeraRonda();
        String baraja2_ronda2 = primeraRonda();
        
        //variables para sostener lo que tiene cada zona. (una por jugador)
        String bosqueDeLaSemejanza_Jugador1 = "";
        String pradoDeLaDiferencia_Jugador1 = "";
        String praderaDelAmor_Jugador1 = "";
        String trioFrondoso_Jugador1 = "";
        String reyDeLaSelva_Jugador1 = "";
        String islaSolitaria_Jugador1 = "";
        String rio_Jugador1 = "";
        
        String bosqueDeLaSemejanza_Jugador2 = "";
        String pradoDeLaDiferencia_Jugador2 = "";
        String praderaDelAmor_Jugador2 = "";
        String trioFrondoso_Jugador2 = "";
        String reyDeLaSelva_Jugador2 = "";
        String islaSolitaria_Jugador2 = "";
        String rio_Jugador2 = "";
        
        System.out.println("====== Bienvenid@ a Draftosaurus ======");
        for (int i = 0; i<12; i++){
            String dino_nuevo = "";
            int contador_jugador1 = 0;
            int contador_jugador2 = 1;
            if (i%2==0){
                contador_jugador1 = contador_jugador1 + 1;
                String baraja_dinosaurios = Baraja_a_Utilizar(baraja1_ronda1, baraja2_ronda1, contador_jugador1);
                System.out.println("\n====== Es el turno de Jugador 1 ======\n");
                dino_nuevo = InteraccionJugador(bosqueDeLaSemejanza_Jugador1, pradoDeLaDiferencia_Jugador1, praderaDelAmor_Jugador1, trioFrondoso_Jugador1, reyDeLaSelva_Jugador1, islaSolitaria_Jugador1, rio_Jugador1, baraja_dinosaurios);
                //concatenar el dino nuevo
                char zona_del_dino_nuevo = dino_nuevo.charAt(0);
                char letra_dino_nuevo = dino_nuevo.charAt(1);
                if (zona_del_dino_nuevo=='1'){
                    bosqueDeLaSemejanza_Jugador1 = bosqueDeLaSemejanza_Jugador1 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='2'){
                    pradoDeLaDiferencia_Jugador1 = pradoDeLaDiferencia_Jugador1 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='3'){
                    praderaDelAmor_Jugador1 = praderaDelAmor_Jugador1 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='4'){
                    trioFrondoso_Jugador1 = trioFrondoso_Jugador1 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='5'){
                    reyDeLaSelva_Jugador1 = reyDeLaSelva_Jugador1 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='6'){
                    islaSolitaria_Jugador1 = islaSolitaria_Jugador1 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='7'){
                    rio_Jugador1 = rio_Jugador1 + letra_dino_nuevo;
                }
            }
            if (i%2!=0){
                contador_jugador2 = contador_jugador2 + 1;
                String baraja_dinosaurios = Baraja_a_Utilizar(baraja1_ronda1, baraja2_ronda1, contador_jugador2);
                System.out.println("\n====== Es el turno de Jugador 2 ======\n");
                dino_nuevo = InteraccionJugador(bosqueDeLaSemejanza_Jugador2, pradoDeLaDiferencia_Jugador2, praderaDelAmor_Jugador2, trioFrondoso_Jugador2, reyDeLaSelva_Jugador2, islaSolitaria_Jugador2, rio_Jugador2, baraja_dinosaurios);
                //concatenar el dino nuevo
                char zona_del_dino_nuevo = dino_nuevo.charAt(0);
                char letra_dino_nuevo = dino_nuevo.charAt(1);
                if (zona_del_dino_nuevo=='1'){
                    bosqueDeLaSemejanza_Jugador2 = bosqueDeLaSemejanza_Jugador2 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='2'){
                    pradoDeLaDiferencia_Jugador2 = pradoDeLaDiferencia_Jugador2 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='3'){
                    praderaDelAmor_Jugador2 = praderaDelAmor_Jugador2 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='4'){
                    trioFrondoso_Jugador2 = trioFrondoso_Jugador2+ letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='5'){
                    reyDeLaSelva_Jugador2 = reyDeLaSelva_Jugador2 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='6'){
                    islaSolitaria_Jugador2 = islaSolitaria_Jugador2 + letra_dino_nuevo;
                }
                else if (zona_del_dino_nuevo=='7'){
                    rio_Jugador2 = rio_Jugador2 + letra_dino_nuevo;
                }
            }
        }
        System.out.println("\n====== Fin de la primera ronda. Queda otra ======\n");
        //for para la segunda ronda
        System.out.println("\n====== Fin del juego ======\n");
        
    }
    
    public static String Baraja_a_Utilizar(String baraja_jugador1, String baraja_jugador2, int i){
        String baraja_dinosaurios="";
        if (i%2==0){
            baraja_dinosaurios = baraja_jugador1;
        }
        else {
            baraja_dinosaurios = baraja_jugador2;
        }
        return baraja_dinosaurios;
    }

    public static String InteraccionJugador(String bosqueDeLaSemejanza, String pradoDeLaDiferencia, String praderaDelAmor, String trioFrondoso, String reyDeLaSelva, String islaSolitaria, String rio, String baraja_dinosaurios){
        Scanner in = new Scanner(System.in);
        System.out.println("(1) Bosque de la Semejanza: [" + bosqueDeLaSemejanza + "]");
        System.out.println("(2) Prado de la Diferencia: [" + pradoDeLaDiferencia + "]");
        System.out.println("(3) Pradera del Amor: [" + praderaDelAmor + "]");
        System.out.println("(4) Trio Frondoso: [" + trioFrondoso + "]");
        System.out.println("(5) Rey de la Selva: [" + reyDeLaSelva + "]");
        System.out.println("(6) Isla Solitaria: [" + islaSolitaria + "]");
        System.out.println("(7) Río: [" + rio + "]");
        System.out.println("Estos son sus dinosaurios: [" + baraja_dinosaurios + "]");
        System.out.println("¿Cuál desea colocar? ");
        char dino_colocado = in.next().charAt(0);
        System.out.println("¿En cuál zona lo desea colocar? ");
        int numero_de_zona = in.nextInt();
        String dino_nuevo = "" + numero_de_zona + dino_colocado;
        return dino_nuevo;
    }
}
