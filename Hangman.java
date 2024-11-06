import java.util.*;
class Hangman {
public static void main(String[] args) {
    //Declaration of global tracking variables
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
    //Loop to fill the arrays for both the correct solution of characters and create the blank array to be filled
    for(int i=0; i<word.length(); i++) {
        correct[i]=word.charAt(i);
        if(word.charAt(i)==' ') {
            current[i]=' ';
        } else {
            current[i]='_';
        }
    }
    //Loop which runs iteratively until the game is won or lost.
    while(end==false) {
        System.out.println("\nLetter Guess: ");
        char guess = input.nextLine().charAt(0);
        boolean right=false;
        //Checks if the letter selected is present in the word and updates the current progress accordingly as well as changing to boolean to denote the guess was correct
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
        //Checks for end conditions (win or loss) and displays according result or the current progress before repeating loop if not.
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