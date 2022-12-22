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
    public static int countR = 0;
    public static int count = 0;
    
    public static int timer = 0;
    
    
    
    GreenfootImage rk = new GreenfootImage("\\images\\rock.png");
    public rock()
    {
        rk.scale(50,50);
        setImage(rk);
        countR++;
    }
    
    public void act() 
    {
        bob();
        timer++;
    }    
    
// Bobs the objects up and down giving a better feel for the game
    public void bob()
    {
        int y = getY();
        if(timer % 10 == 0)
        {
            y = y - 1;
        }
        if(timer % 20 == 10)
        {
            y = y + 2;
        }
        setLocation(getX(),y);
    }
}
