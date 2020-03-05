package chapter10;

import  java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        String line = ""; try (BufferedReader reader = new BufferedReader(new FileReader("word-list.txt"))) {
            readWord(line, reader);
        } catch (IOException e) { e.printStackTrace(); } }

    private static void readWord(String line, BufferedReader reader) throws IOException {
//This section reads in all the words from word-list.txt and places them in a (very long) array
        List<String> list = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            list.add(line); }
//Here, we CHOOSE a random word from this large array
        Random random = new Random();
        int rand = random.nextInt(6345);
        String word = list.get(rand);
        //while (word.length() != 16) {
        //    list.remove(rand);
        //    word = list.get(rand);     }
        //Creating the initial board, which will be all blanks
        List<String> blank = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            blank.add("_"); }
        //Now for the piece de le resistance: The Hangman
        String[] BodyParts = {"Head", "Torso", "Leg", "Leg (3 misses 'til Hangman!)", "Arm", "Arm", "Face"};
        List<String> Penalty = new ArrayList<>();
        //Here, we create the 'guess graveyard' where all incorrect guesses go
        // to help the user not guess the same incorrect letters over and over
        int count = 0;
        List<String> AlreadyGuessed = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        //This while loop is around 50 lines long. Get ready, This is where the game begins. . .
        while (count < 7 ) {
            if (count > 0) {System.out.println(Penalty);
            System.out.print("Already Guessed: "); System.out.print(AlreadyGuessed); System.out.println(); }
            System.out.println(blank);
            System.out.println("Guess a letter "); //                  boolean Valid = (scanner.hasNext("\\p{Alpha}*"));
            String guess = scanner.nextLine();
            //Our guess needs to go through some filters, to assure that only single lowercase
            // letters with no special characters (including spaces) pass through as our inputs.
            //We must also prepare for the user to mistakenly (or just to be difficult) hit the ENTER key
            while (guess.length() == 0) {System.out.println("Type something, even if its wrong!");
            String guess2 = scanner.nextLine();
            guess = guess2;}
            char c = guess.charAt(0);
            while (guess.length() == 0 || c < 'a' || c > 'z' || guess.length() >= 2) {
                    switch (guess.length()) {
                        case 0: System.out.println("Type something, even if its wrong, then press the ENTER key"); break;
                        case 1: System.out.println("Invalid Guess! Other examples are A or 'abc' or 1 or ' ' or !#$% or ;-/ 8) =) ");
                            System.out.println("Now guess a letter");break;
                        case 2: System.out.println("Guess one lowercase letter"); break;
                        default: System.out.println("Guess one lowercase letter. . . or if you're trying to type an essay, go for it"); break;
                    }
                    String guess2 = scanner.nextLine();
                    guess = guess2;
                if (guess.length() > 0) { if (guess.length() < 2) {c = guess.charAt(0);} }
            }// while (guess.length() == 0 || guess.length() >= 2) {System.out.println("Type something, even if its wrong!");
             //   String guess2 = scanner.nextLine();
             //   guess = guess2;}
             //   if (c > 'a' && c < 'z') c = guess.charAt(0);
             //   else System.out.println("Okay buddy, since you want to guess a non-letter so bad, have it your way!");an
            //Here, we take the validated guess (we now know that guess and 'c' have the same content)
            // and scan the word, letter-by-letter, revealing each instance the guessed letter appears
                  //if we have at least one letter correct
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    blank.set(i, guess); }}
                 //if we have no letters correct (see also Line93)
            int wrong = 0;
            for (int j = 0; j < word.length(); j++) {
                 if (word.charAt(j) != c) {
                     wrong++; }}
                     //Below: we only allow 7 incorrect guesses, record those wrong guesses, and then "Hangman Drawing" is updated.
if (wrong == word.length()) { Penalty.add(BodyParts[count]); count++; AlreadyGuessed.add(guess);} System.out.println();
//And finally, here is the conditions that must be met for a WIN!!!   or   Lose =(
if (Solved(word, blank)) {  System.out.println();
    System.out.println(blank); System.out.println("YOU WIN!!!"); break; }
        }
        if (count == 7) {   System.out.println();
            System.out.println("The word is " + word);
            System.out.println(Penalty); System.out.println();
            System.out.println("!!HANGMAN!!");
            System.out.println("You Lose =("); } }
//We need to compare the randomly-chosen word to the board. If the board has no more blanks, it follows that all the letters
// (only correct allowed) have populated the board. This is how we determined if(Solved) in Line94
    private static boolean Solved (String word, List<String> blank) {
        for (int i = 0; i < word.length(); i++) {
            if (blank.get(i) == "_") {return false;}
        }return true; } }




