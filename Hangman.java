import java.util.*;
class Hangman {
public static void main(String[] args) {
    String[] pictures = new String[]{"+---+\r\n" + "  |   |\r\n" + "  O   |\r\n" + " /|\\  |\r\n" + " / \\  |\r\n" + "      |\r\n" + "=========",
                                   "+---+\r\n" + "  |   |\r\n" + "  O   |\r\n" + " /|\\  |\r\n" + " /    |\r\n" + "      |\r\n" +"=========",
                                   "+---+\r\n" + "  |   |\r\n" + "  O   |\r\n" + " /|   |\r\n" + "      |\r\n" + "      |\r\n" +"=========",
                                   "+---+\r\n" + "  |   |\r\n" + "  O   |\r\n" + "  |   |\r\n" + "      |\r\n" + "      |\r\n" +"=========",
                                   "+---+\r\n" + "  |   |\r\n" + "  O   |\r\n" + "      |\r\n" + "      |\r\n" + "      |\r\n" +"=========",
                                   "+---+\r\n" + "  |   |\r\n" + "      |\r\n" + "      |\r\n" + "      |\r\n" + "      |\r\n" +"========="};
    Scanner input=new Scanner(System.in);
    boolean end=false;
    int lives=6;
    System.out.println("Enter your word: ");
    String word=input.nextLine();
    char[] correct= new char[word.length()];
    char[] current= new char[word.length()];
    for(int i=0; i<word.length(); i++) {
        correct[i]=word.charAt(i);
        if(word.charAt(i)==' ') {
            current[i]=' ';
        } else {
            current[i]='_';
        }
    }
    while(end==false) {
        System.out.println("\nLetter Guess: ");
        char guess = input.nextLine().charAt(0);
        boolean right=false;
        for(int i=0; i<correct.length; i++) {
            if(correct[i]==guess) {
                current[i]=guess;
                right=true;
            }
        }
        if(!right) {
            lives--;
        }
        System.out.println(current);
        if(Arrays.equals(correct, current)) {
            end=true;
            System.out.print("You win!");
        } else if(lives==1) {
            System.out.println(pictures[0]);
            System.out.println("You lost! The word was: " + word);
            end=true;
        } else {
            System.out.println(pictures[(lives-1)]);
            System.out.println("\n");
        }

}
}
}