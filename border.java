import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class border extends Actor
{
    /**
     * Act - do whatever the wager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage rectangle = new GreenfootImage(200, 600);
    
    public int score = 0;
    public border(String ftype){
        if(ftype == "border")
        {
            rectangle.setColor(greenfoot.Color.BLACK);
            rectangle.drawLine(0,0,0,600);
            rectangle.drawLine(0,100,200,100);
            rectangle.drawLine(0,225,200,225);
            setImage(rectangle);
            
            score = 10;
        }
    }
    
    public void act()
    {
    }
}
