import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titleWorld extends World
{

    /**
     * Constructor for objects of class titleWorld.
     * 
     */
    
    Label title = new Label("Rock, Paper\nScissors!",125);
    
    Label rules = new Label("Pick who you think will win and\namass a fortune",55);
    
    Label start = new Label("Click here to start",50);
    
    public titleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        title.setFillColor(greenfoot.Color.BLACK);
        start.setFillColor(greenfoot.Color.GREEN);
        
        addObject(title,400,175);
        addObject(rules,400,400);
        addObject(start,400,525);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(start))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
