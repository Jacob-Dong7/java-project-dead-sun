public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("Dead Sun");
        System.out.println("Developed by Jacob Dong");
        System.out.println("==================================================");
        Player userPlayer = new Player();
        userPlayer.create();
        userPlayer.intro();
    }

}

//javac src/Main.java src/Character.java src/Player.java