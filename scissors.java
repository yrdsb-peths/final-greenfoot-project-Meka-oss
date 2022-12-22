import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class scissors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class scissors extends Actor
{
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int countS = 0;
    
    public static int timer = 5;
    
    
    
    GreenfootImage sc = new GreenfootImage("\\images\\scissors.png");
    public scissors()
    {
        sc.scale(50,50);
        setImage(sc);
        countS++;
    }
    
    public void act() 
    {
        bob();
        timer++;
    }    
    
    public void bob()
    {
        int y = getY();
        if(timer % 20 == 0)
        {
            y = y - 2;
        }
        if(timer % 20 == 10)
        {
            y = y + 2;
        }
        setLocation(getX(),y);
    }
}
