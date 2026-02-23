public class Main {

    public static void main(String[] args) {
        System.out.println("\n==================================================");
        System.out.println("Dead Sun");
        System.out.println("Developed by Jacob Dong");
        System.out.println("==================================================");

        Game newGame = new Game();
        newGame.start();
    }



}

/*mkdir out 2>nul
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt*/

/* java -cp out Main */
