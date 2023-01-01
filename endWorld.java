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
        
        Label end = new Label ("",100);
        addObject(end,300,300);
    }
    
    public static void newGame()
    {
        if(Greenfoot.isKeyDown("space"))
        {       
            MyWorld MyWorld = new MyWorld();
            Greenfoot.setWorld(MyWorld);
        }
    }
}
