package chap02;

public class GuessGame {

    Player p1;
    Player p2;
    Player p3;

    public void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int targetNumber = (int) (Math.random() * 10);
        System.out.println("I'm thinking of a number between 0 and 9...");

        while (true) {
            System.out.println("Number to guess is " + targetNumber);

            p1.guess();
            p2.guess();
            p3.guess();

            int guessp1 = p1.number;
            System.out.println("Player one guessed " + guessp1);
            int guessp2 = p2.number;
            System.out.println("Player two guessed " + guessp2);
            int guessp3 = p3.number;
            System.out.println("Player three guessed " + guessp3);

            boolean p1isRight = (guessp1 == targetNumber);
            boolean p2isRight = (guessp2 == targetNumber);
            boolean p3isRight = (guessp3 == targetNumber);

            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("We have a winner!");
                System.out.println("Player one got it right? " + p1isRight);
                System.out.println("Player two got it right? " + p2isRight);
                System.out.println("Player three got it right? " + p3isRight);
                System.out.println("Game is over");
                break;
            } else {
                System.out.println("Players will have to try again.");
            }
        }
    }
}
