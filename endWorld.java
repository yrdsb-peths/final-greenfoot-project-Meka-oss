import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class endWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class endWorld extends World
{

    /**
     * Constructor for objects of class endWorld.
     * 
     */
    
    public String text = "";
    public endWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        
        text = text + " won";
        
        Label end = new Label (text,100);
        addObject(end,300,300);
    }
}
