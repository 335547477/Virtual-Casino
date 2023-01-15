/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningtoprogram;

/**
 * Author: Kinjal Class: ICS3U
 *
 * Program: Virtual Casino Input: choices for various games 
 * Processing: takes choices and "plays game" with them
 * Output: declares results and winner 
 *
 */
//Import Statements Listed Alphabetically
import java.io.*;           //used for any type of input or output
import java.util.*;         //useful utilities like Scanner
import hsa.Console;
import hsa.*;

/**
 *
 * @author Kinjal
 */
public class VirtualCasino {

    public static void diceRolls (int dice1, int dice2, int totalRoll, Console c) {
        //prints result for each roll to player
        c.println ("Your first die roll is: " + dice1);
        c.println ("Your second die roll is: " + dice2);
        c.println ("Your total die roll is: " + totalRoll);
    }
    /**
     * * MAIN METHOD
     *
     **
     * @param args
     */
    public static void main(String[] args) {

        //FIRST WRITE YOUR PSEUDOCODE USING COMMENTS, THEN FILL IN WITH CODE
        System.out.println("Starting...");
        Console c = new Console();
        Random r = new Random ();
        //welcome player to casino and reads name
        c.println ("Hello, what is your name?");
        String name = c.readLine ();
        c.clear();
        c.println ("Hello, " + name + "! Welcome to the Virtual Casino");
        //introduces skill test and asks user for key to continue
        c.println ("Before we start we are going to do a quick skill test to check"
                + " if your eligible to play at the Virtual Casino!! Press Enter to Cotinue!");
        c.getChar();
        c.clear();
        //asks skill set question
        c.println ("There are some people on the train. 19 people get off the train at the first stop. "
                + "17 people get on the train. Now there are 63 people on the train. How many "
                + "people were on the train to begin with?");
        //creates variable answer
        int answer;
        //loop that starts at 0 and goes up by 1, 3 times 
        for (int i=0; i<3; i++) {
            //reads answer entered by user
            answer = c.readInt();
            //if answer is 65, user can continue into the virtual casino and break from loop
            if (answer==65) {
                c.println ("Wow! You got it!");
                c.clear();
                break;
            }
            //if answer isn't correct on the third try, they cannot play and return
            else if (answer!=65 && i==2) {
              c.println ("Sorry you couldn't get the right answer. You can't play.");
              return;  
            }
            //if answer isn't correct and it isn't their last try, then user gets to try again
            else {
                c.println ("You got the answer wrong try again.");
            }
        }
        //user starts off with 100 tokens and wins/loses tokens based on how they play
        c.println ("You start off with 100 tokens!");
        int fixedTokens;
        fixedTokens = 100;
        //declaring varibles for dice game
            int dice1;
            int dice2;
            int totalRoll;
            int numChosen;
        //while 'true' (infinite) the menu option and games can be repeated until break statement 
        while (true) {
        //menu options
        c.println ("Pick which game you would like to play: ");
        c.println ("Dice\n" + "Roulette\n" + "Cash Out\n" + "Exit\n");
        //string based on which option is chosen
        String gameChose = c.readLine ();
        //prints dice if that game is chosen
        if (gameChose.equalsIgnoreCase ("Dice")) {
            //welcomes player to dice game
            c.clear();
            c.println ("Welcome to the game of Dice, " + name);
            //plays the dice game                         
            //asks player to select number from 3-12 and tells them to roll dice
            c.println ("Select a number from 3-12");
            numChosen = c.readInt ();
            c.println("Lets roll the dice and see if you won!");
            c.clear();
            c.println ("Your number is: " + numChosen);
            //creates random variables for potential rolls for dice 1 and dice 2
            dice1 = r.nextInt (6)+1;
            dice2 = r.nextInt (6)+1;
            //sums rolls for both dice and uses method to print statements 
            totalRoll = dice1 + dice2;
            diceRolls (dice1, dice2, totalRoll, c);
            //if the number chosen is equal to the sum of die rolls, player wins and thus gets 3 tokens 
            if (numChosen == totalRoll) {
                c.println ("Congratulations, You Won!");
            }
            //if the sum of the die roll is 2, then player rolls the die again
            else if (totalRoll == 2) {
              c.clear();
              c.println ("You rolled snake eyes :o");
              c.println ("Press any key to roll the die once more!");
              c.getChar();
              dice1 = r.nextInt (6)+1;
              dice2 = r.nextInt (6)+1;
              totalRoll = dice1 + dice2;
              diceRolls (dice1, dice2, totalRoll, c);
              //if the sum of second die roll is equal to the number chosen, player wins and thus gets 20 tokens 
              if (totalRoll == numChosen) {
                  c.println ("Congratulations, You Won!");
              }
              //otherwise, if not equal player loses and thus loses 20 tokens 
              else {
                  c.println ("Your number doesn't match the total die roll. You Lose. Boo Hoo xD");
              }
            }
            //otherwise, if not equal then player loses 
            else {
            c.println ("Your number doesn't match the total roll. You Lose. Boo Hoo xD");
            }
            //if the total roll equals the number chosen they won 20 tokens 
            //user presses any key to break out of the loop and return to the menu
            if (totalRoll == numChosen) {
                fixedTokens = fixedTokens + 20;
                c.println ("You got 20 tokens. You now have " + fixedTokens + " tokens!");
                c.println ("Press any key to return to the menu");
                c.getChar();
                c.clear();
            }
            //if the total roll doesn't equal the number chosen they lose 20 tokens 
            //user presses any key to break out of loop and return to menu
            else {
                fixedTokens = fixedTokens - 20;
                c.println ("You lost 20 tokens. You now have " + fixedTokens + " tokens!");
                c.println ("Press any key to return to the menu.");
                c.getChar();
                c.clear();
            }
        }
        //if player chooses roulette, then welcome them
        else if (gameChose.equalsIgnoreCase("Roulette")) {
            c.clear();
            c.println ("Welcome to the game of Roulette, " + name);
        //after game is done asks user to press any key to return to menu
            c.println ("Press any key to return to the menu.");
            c.getChar();
        }
        //if player chooses cash out, then welcome them
        else if (gameChose.equalsIgnoreCase ("Cash Out")) {
            c.clear();
            c.println ("Welcome to Cash Out " + name);
        //displays amount of fixed tokens left and allows user to return back to menu
            c.println ("You have cashed out with " + fixedTokens + " tokens");
            c.println ("Press any key to return to the menu.");
            c.getChar();
        }
        //if user chooses exit then breaks from loop
        else if (gameChose.equalsIgnoreCase ("Exit")) {
            break;
        }
        //otherise, tell player they entered an invalid game 
        else {
            c.clear();
            c.println ("Sorry you entered an invalid game. Try again!");
        }
    }
        //if user chooses exit, it breaks from the loop and prints goodbye statement 
        c.clear();
        c.println ("Thanks for visiting the virtual casino, Goodbye!");
    }
}
