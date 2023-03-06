package com.github.zipcodewilmington;


import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    public String secretWord, guess;
    public StringBuilder display = new StringBuilder();
    public Scanner in = new Scanner(System.in);
    public static Integer randNum = 0;
    public Integer numberOfGuesses, guessesRemaining;


    public static void main(String[] args){
        Hangman hangman = new Hangman();
        hangman.Setup();

    }//end of main

    private void Setup(){
        System.out.println("Hangman\n\nGuess a word!\n\n");
        //randNum = randNumberGenerator();
        secretWord = randomWordGenerator(randNumberGenerator());
        System.out.println(secretWord);
        System.out.println(displayCreation());
        getGuess();
    }

   public Integer randNumberGenerator() {
        Random rand = new Random();
        int num =  rand.nextInt(5);
        return num;
    }//end of randNumberGenerator
    public String randomWordGenerator(int randNum){
        String randomWord = ("");
        switch(randNum){
            case 0:
                randomWord= "Frog";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
            case 1:
                randomWord= "Toad";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
            case 2:
                randomWord= "Very";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
            case 3:
                randomWord= "Just";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
            case 4:
                randomWord= "Love";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
            case 5:
                randomWord= "Were";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
        }
        return randomWord;
    }//end of randomWordGenerator

    public String displayCreation(){
        for(int i = 0; i < numberOfGuesses; i++){
            display.append(" _");
        }
        return display.toString();
    }//end of displayCreation

    public String getGuess()
    {
        guess = in.nextLine();
        checkGuess();
        return guess;
    }//end of getGuess

    public String checkGuess(){
        for(int i = 0; i < numberOfGuesses; i++){
            if(!guess.equalsIgnoreCase(secretWord)) {
                for (int j = 0; j < numberOfGuesses; j++) {
                    if (String.valueOf(guess.charAt(j)) == String.valueOf(secretWord.charAt(j))) {
                        System.out.println(displayChange(j, guess.charAt(j)));
                    }
                }
                if(guessesRemaining !=0){
                    guessesRemaining--;
                    System.out.println(display);
                    System.out.println("Guess again! Guesses remaining: " + guessesRemaining);
                    getGuess();
                }else{
                    System.out.println("Out of guesses! The word was: " +secretWord + "Better luck next time!");
                    playAgain();
                }
            }else{
                System.out.println("Congratulations! You guessed the word with " + guessesRemaining + " guesses remaining!");
                playAgain();
            }
        }
        return display.toString();
    } //end of checkGuess

    public String displayChange(int j, char letter){
        String displayArray[] = display.toString().split(" _",numberOfGuesses);
        displayArray[j].toString().replace("_",String.valueOf(letter));
        return displayArray.toString();
    }

    public boolean playAgain(){
        System.out.println("Play again? y/n");
        if(in.nextLine().equalsIgnoreCase("y")){
            Setup();
        }else{
            System.out.println("Game Over.");
        }
        return true;
    }

}//end of Hangman

