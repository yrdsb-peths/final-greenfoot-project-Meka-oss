import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wagers here.
 * 
 * @author Mekaeel
 * @version 2.1
 */
public class lostWorld extends World
{

    /**
     * Constructor for objects of class lostWorld.
     * 
     */
    
    public lostWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        
        // Creating and setting up the text block that will be added
        Label loseGame = new Label("You Lose\n\u2639 \u2639 \u2639",175);
        loseGame.setFillColor(greenfoot.Color.BLACK);
        
        addObject(loseGame,400,300);
    }
}
