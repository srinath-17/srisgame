package com.game.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    
    private int numberToGuess;
    private int remainingAttempts;
    
    public GameController() {
        Random rand = new Random();
        numberToGuess = rand.nextInt(10) + 1;
        remainingAttempts = 3;
    }
    
    @GetMapping("/guess/{number}")
    public String guessNumber(@PathVariable int number) {
        if (remainingAttempts == 0) {
            return "You have used up all your attempts. The correct number was " + numberToGuess;
        }
        
        if (number == numberToGuess) {
            return "Congratulations! You guessed the correct number.";
        } else {
            remainingAttempts--;
            return "Incorrect guess. You have " + remainingAttempts + " attempts remaining.";
        }
    }
}
