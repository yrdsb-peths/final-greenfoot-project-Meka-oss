import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rock extends Actor
{
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage rk = new GreenfootImage("\\images\\rock.png");
    public rock()
    {
        rk.scale(50,50);
        setImage(rk);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void bob()
    {
        
    }
}
