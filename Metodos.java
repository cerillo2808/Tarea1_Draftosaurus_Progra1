import java.util.Scanner;
import java.util.Random;

public class Metodos{
    
    //Variable Inicial
    String bolsa_de_dinosaurios = "ttttttttvvvvvvvvaaaaaaaabbbbbbbbddddddddssssssss";

    //Metodo para elegir 6 especies de manera aleatoria
    public String SeleccionadorDeDinosaurios() {

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
    
    //Sirve para conseguir el dinosaurio ingresado
    public static String ConseguidorDeDinosaurio(String zona1, String zona2, String zona3, String zona4, String zona5, String zona6, String zona7, String baraja){
        Scanner in = new Scanner(System.in);
        
        System.out.println("(1) Bosque de la semejanza: [" + zona1 + "]");
        System.out.println("(2) Prado de la diferencia: [" + zona2 + "]");
        System.out.println("(3) Pradera del amor: [" + zona3 + "]");
        System.out.println("(4) Trio frondoso: [" + zona4 + "]");
        System.out.println("(5) Rey de la selva: [" + zona5 + "]");
        System.out.println("(6) Isla solitaria: [" + zona6 + "]");
        System.out.println("(7) Rio: [" + zona7 + "]");
        System.out.println("Estos son sus dinosaurios: " + baraja);
        System.out.println("¿Cuál desea colocar?: ");
        char dino = in.next().charAt(0);
        System.out.println("¿En cuál zona lo deasea colocar?: ");
        char zona = in.next().charAt(0);
        String DinoNuevo = "" + dino + zona;
        return DinoNuevo;
    }
    
    //Más variables
        //_1 significa jugador 1
        String zona1_1 = "";
        String zona2_1 = "";
        String zona3_1 = "";
        String zona4_1 = "";
        String zona5_1 = "";
        String zona6_1 = "";
        String zona7_1 = "";
        
        //variables del jugador 2
        String zona1_2 = "";
        String zona2_2 = "";
        String zona3_2 = "";
        String zona4_2 = "";
        String zona5_2 = "";
        String zona6_2 = "";
        String zona7_2 = "";
    
        //corre una ronda
    public void Ronda(){
        String baraja1 = SeleccionadorDeDinosaurios();
        String baraja2 = SeleccionadorDeDinosaurios();
        for(int i = 0; i<12; i++){
            char LetraDino = TurnadorDeEnunciado(i, baraja1, baraja2);
            if ((i%2==0)&&(i==2||i==6||i==10)){
                baraja2 = EliminarDino (baraja2, LetraDino);
            }
            if ((i%2==0)&&(i==0||i==4||i==8)){
                baraja1 = EliminarDino (baraja1, LetraDino);
            }
            if ((i%2!=0)&&(i==3||i==7||i==11)){
                baraja1 = EliminarDino (baraja1, LetraDino);
            }
            if ((i%2!=0)&&(i==1||i==5||i==9)){
                baraja2 = EliminarDino (baraja2, LetraDino);
            }
        }
    }
    
    //sirve para poner el tablero correcto de cada jugador
    public char TurnadorDeEnunciado (int i, String baraja1, String baraja2){
        String DinoNuevo = "";
        if (i%2==0){
            System.out.println("====== Es el turno de jugador 1 ======");
            if (i==2||i==6||i==10){
                baraja1 = Drafting(baraja1, baraja2);
            }
            DinoNuevo = ConseguidorDeDinosaurio(zona1_1, zona2_1, zona3_1, zona4_1, zona5_1, zona6_1, zona7_1, baraja1);
            char LetraDino = Concatenar1(DinoNuevo);
            return LetraDino;
            }
        else {
            System.out.println("====== Es el turno de jugador 2 ======");
            if (i==3||i==7||i==11){
                baraja2 = Drafting(baraja2, baraja1);
            }
            DinoNuevo = ConseguidorDeDinosaurio(zona1_2, zona2_2, zona3_2, zona4_2, zona5_2, zona6_2, zona7_2, baraja2);
            char LetraDino = Concatenar2(DinoNuevo);
            return LetraDino;
            }
    }
    
    //sirve para eliminar el dino de la baraja después de ser ingresado
    public static String EliminarDino (String baraja1, char LetraDino){
        for (int i = 0; i<baraja1.length(); i++){
            if (baraja1.charAt(i)==LetraDino){
                baraja1 = baraja1.substring(0, i) + baraja1.substring(i+1);
                break;
            }
        }
        return baraja1;
    }
    
    //sirve para intercambiar las barajas
    public static String Drafting(String baraja1, String baraja2){
        String temporal = "";
        temporal = baraja2;
        baraja2 = baraja1;
        baraja1 = temporal;
        return baraja1;
    }
    
    //sirve para agregar el dinosaurio ingresado a la zona correcta en el tablero de jugador 1
    public char Concatenar1 (String DinoNuevo){
        char dino = DinoNuevo.charAt(0);
        char zona = DinoNuevo.charAt(1);
        
        if (zona == '1'){
            zona1_1 = zona1_1 + dino;
        }
        else if (zona == '2'){
            zona2_1 = zona2_1 + dino;
        }
        else if (zona == '3'){
            zona3_1 = zona3_1 + dino;
        }
        else if (zona == '4'){
            zona4_1 = zona4_1 + dino;
        }
        else if (zona == '5'){
            zona5_1 = zona5_1 + dino;
        }
        else if (zona == '6'){
            zona6_1 = zona6_1 + dino;
        }
        else if (zona == '7'){
            zona7_1 = zona7_1 + dino;
        }
        return dino;
    }
    
    //sirve para agregar el dinosaurio a la zona correcta en el tablero de jugador 2
    public char Concatenar2 (String DinoNuevo){
        char dino = DinoNuevo.charAt(0);
        char zona = DinoNuevo.charAt(1);
        
        if (zona == '1'){
            zona1_2 = zona1_2 + dino;
        }
        else if (zona == '2'){
            zona2_2 = zona2_2 + dino;
        }
        else if (zona == '3'){
            zona3_2 = zona3_2 + dino;
        }
        else if (zona == '4'){
            zona4_2 = zona4_2 + dino;
        }
        else if (zona == '5'){
            zona5_2 = zona5_2 + dino;
        }
        else if (zona == '6'){
            zona6_2 = zona6_2 + dino;
        }
        else if (zona == '7'){
            zona7_2 = zona7_2 + dino;
        }
        return dino;
    }
    
    //sirve para mostrar el tablero final de jugador 1
    public void MostradorDeTableroFinal1(){
        System.out.println("(1) Bosque de la semejanza: [" + zona1_1 + "]");
        System.out.println("(2) Prado de la diferencia: [" + zona2_1 + "]");
        System.out.println("(3) Pradera del amor: [" + zona3_1 + "]");
        System.out.println("(4) Trio frondoso: [" + zona4_1 + "]");
        System.out.println("(5) Rey de la selva: [" + zona5_1 + "]");
        System.out.println("(6) Isla solitaria: [" + zona6_1 + "]");
        System.out.println("(7) Rio: [" + zona7_1 + "]");
    }
    
    //sirve para mostrar el tablero final de jugador 2
    public void MostradorDeTableroFinal2(){
        System.out.println("(1) Bosque de la semejanza: [" + zona1_2 + "]");
        System.out.println("(2) Prado de la diferencia: [" + zona2_2 + "]");
        System.out.println("(3) Pradera del amor: [" + zona3_2 + "]");
        System.out.println("(4) Trio frondoso: [" + zona4_2 + "]");
        System.out.println("(5) Rey de la selva: [" + zona5_2 + "]");
        System.out.println("(6) Isla solitaria: [" + zona6_2 + "]");
        System.out.println("(7) Rio: [" + zona7_2 + "]");
    }
    
    //condiciones para conseguir puntos
    public int CalcularPuntajeZona1(String zona1){
        int contador = 0;
        boolean verificacion = true;
        int puntos = 0;
        
        for (int i = 0; i<=zona1.length(); i++){
            if (zona1.charAt(i-1) == zona1.charAt(i)){
                contador = contador +1;
            }
            else {
                verificacion = false;
                break;
            }
        }
        
        if (verificacion == true){
            if (contador == 0){
                puntos = 0;
            }
            if (contador == 1){
                puntos = puntos + 2;
            }
            if (contador == 2){
                puntos = puntos + 4;
            }
            if (contador == 3){
                puntos = puntos + 8;
            }
            if (contador == 4){
                puntos = puntos + 12;
            }
            if (contador == 5){
                puntos = puntos + 18;
            }
            if (contador == 6){
                puntos = puntos + 24;
            }
            else {
                System.out.println("Hay dinosaurios de más en la zona 1");
            }
        }
        else {
            System.out.println("Hay dinosaurios diferentes en la zona 1");
        }
        return puntos;
    }
} 
        char dino_colocado = in.next().charAt(0);
        System.out.println("¿En cuál zona lo desea colocar? ");
        int numero_de_zona = in.nextInt();
        String dino_nuevo = "" + numero_de_zona + dino_colocado;
        return dino_nuevo;
    }
}
