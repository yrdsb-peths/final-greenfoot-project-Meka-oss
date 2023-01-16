import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wagers here.
 * 
 * @author Mekaeel
 * @version 2.1
 */
public class wonWorld extends World
{

    /**
     * Constructor for objects of class wonWorld.
     * 
     */
    public wonWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        Label winGame = new Label("You Win!\n\u263A \u263A \u263A",175);
        winGame.setFillColor(greenfoot.Color.BLACK);
        
        addObject(winGame,400,300);
    }
}
