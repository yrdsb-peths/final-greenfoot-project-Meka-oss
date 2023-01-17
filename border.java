import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wagers here.
 * 
 * @author Mekaeel
 * @version 2.1
 */

public class border extends Actor
{
    /**
     * Act - do whatever the wager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Creating the border object that sits under all the others
    
    GreenfootImage rectangle = new GreenfootImage(200, 600);
    
    public border(String ftype){
        if(ftype == "border")
        {
            rectangle.setColor(greenfoot.Color.BLACK);
            rectangle.drawLine(0,0,0,600);
            rectangle.drawLine(0,100,200,100);
            rectangle.drawLine(0,225,200,225);
            setImage(rectangle);
        }
    }
}
