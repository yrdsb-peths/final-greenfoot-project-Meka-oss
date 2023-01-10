import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wager extends Actor
{
    /**
     * Act - do whatever the wager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage rectangle = new GreenfootImage(200, 600);
    public wager(String ftype){
        if(ftype == "border")
        {
            rectangle.setColor(greenfoot.Color.BLACK);
            rectangle.drawLine(0,0,0,600);
            setImage(rectangle);
        }
        if(ftype == "score")
        {
            
        }
    }
    
    public void act()
    {
    }
}
