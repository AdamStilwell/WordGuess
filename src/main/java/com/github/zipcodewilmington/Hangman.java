package com.github.zipcodewilmington;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    public String secretWord, guess, letter;
    public String [] pos = new String[9];
    public StringBuilder display = new StringBuilder();
    public Scanner in = new Scanner(System.in);
    public static Integer randNum = 0;
    public Integer numberOfGuesses, guessesRemaining;
    public Integer streak = 0;
    public boolean replay = false;


    public static void main(String[] args){
        Hangman hangman = new Hangman();
        hangman.setup();

    }//end of main

    private void setup(){
        System.out.println("Hangman\n\nGuess a word!\n\n");
        randNum = randNumberGenerator();
        secretWord = randomWordGenerator();
        System.out.println(displayCreation());
        getGuess();
    } //end of setup

   public Integer randNumberGenerator() {
        Random rand = new Random();
        randNum = rand.nextInt(12);
        return randNum;
    }//end of randNumberGenerator

    public String randomWordGenerator(){
        String randomWord = ("");
        switch(randNum){
            case 0:
                randomWord= "Frog";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 1:
                randomWord= "Toad";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 2:
                randomWord= "Very";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 3:
                randomWord= "Just";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 4:
                randomWord= "Love";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 5:
                randomWord= "Were";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 6:
                randomWord= "Frozen";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 7:
                randomWord= "Great";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 8:
                randomWord= "Slink";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 9:
                randomWord= "Point";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 10:
                randomWord= "Built";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
            case 11:
                randomWord= "Difficult";
                numberOfGuesses = randomWord.length();
                guessesRemaining = numberOfGuesses;
                break;
        }
        return randomWord;
    }//end of randomWordGenerator

    public String displayCreation(){

        for(int i =0; i<numberOfGuesses; i++) {
            if(i ==0){
                pos[i] = "_ ";
            }else if(i==(numberOfGuesses-1)){
                pos[i] = " _";
            }else{
                pos[i] = " _ ";
            }
        }
        appendValues();
        return display.toString();
    }//end of displayCreation

    public String getGuess()
    {
        guess = in.nextLine();
        if(guess.length() != secretWord.length()){
            while(guess.length() != secretWord.length()) {
                System.out.println("Guess the correct length! (" + secretWord.length() + ")");
                guess = in.nextLine();
            }
        }

        checkGuess();
        return guess;
    }//end of getGuess

    public String checkGuess(){
        for(int i = 0; i < numberOfGuesses; i++){
            if(!guess.equalsIgnoreCase(secretWord)) {
                for (int j = 0; j < numberOfGuesses; j++) {
                    if (String.valueOf(guess.charAt(j)).equalsIgnoreCase( String.valueOf(secretWord.charAt(j)))) {
                        letter = String.valueOf(guess.charAt(j));
                        display.setLength(0);
                        correctGuessAppend(j, letter);
                    }
                }
                if(guessesRemaining !=0){
                    guessesRemaining--;
                    if(guessesRemaining == 0) {
                        System.out.println("Out of guesses! The word was: " +secretWord.toUpperCase() + ". Better luck next time!");
                        streak = 0;
                        if(replay == true){
                            System.out.println("Your current win streak is: "+streak);
                        }
                        playAgain();
                    }
                    System.out.println(display);
                    System.out.println("Guess again! Guesses remaining: " + guessesRemaining);
                    getGuess();
                }
            }else{
                System.out.println("Congratulations! You guessed the word "+ secretWord.toUpperCase() + " with " + guessesRemaining + " guesses remaining!");
                streak++;
                if(replay == true){
                    System.out.println("Your current win streak is: " + streak);
                    if(streak>3){
                        System.out.println("You are the word master. I bow to your majestic prowess.");
                    }
                }
                playAgain();
            }
        }
        return display.toString();
    } //end of checkGuess

    /*public String displayChange(/*int j, char letter){
        //String displayArray[] = display.toString().split(" _",numberOfGuesses);
        //String replacement = String.valueOf(letter) + " ";
        //display.replace(j,j+2,replacement);
        display.setLength(0);
        appendValues();
        return display.toString().toUpperCase();
    } //end of displayChange*/

    public boolean playAgain(){
        display.setLength(0);
        System.out.println("Play again? y/n");
        if(in.nextLine().equalsIgnoreCase("y")){
            replay = true;
            setup();
        }else{
            System.out.println("Your win streak was: "+streak);
            System.out.println("Game Over.");
            System.exit(0);
        }
        return true;
    } //end of playAgain

    public String correctGuessAppend(int j, String letter){
        //update pos strings here
        if(j == 0){
            pos[j] = letter.toUpperCase() + " ";
        }else if(j==numberOfGuesses){
            pos[j] = " " + letter.toUpperCase();
        }else{
            pos[j] = " " + letter.toUpperCase() + " ";
        }
        appendValues();
        return display.toString();
    }

    public String appendValues(){
        for(int i = 0; i <numberOfGuesses; i++){
            display.append(pos[i]);
        }
        return display.toString();
    }

}//end of Hangman

