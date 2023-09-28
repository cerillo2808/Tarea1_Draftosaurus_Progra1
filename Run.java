public class Run{
    public static void Correr (){
        //instancias
        Metodos empezar = new Metodos();
        
        System.out.println("====== ¡Bienvenido a Draftosaurus! ======\n");
        empezar.Ronda();
        System.out.println("\n====== Fin de la primera ronda. Queda 1 más ======\n");
        empezar.Ronda();
        System.out.println("\n====== Fin del juego. ======\n");
        System.out.println("====== Así queda el tablero de jugador 1 ======\n");
        empezar.MostradorDeTableroFinal1();
        System.out.println("\n====== Así queda el tablero de jugador 2 ======\n");
        empezar.MostradorDeTableroFinal2();
        //puntajes
        //ganador
    }
}
