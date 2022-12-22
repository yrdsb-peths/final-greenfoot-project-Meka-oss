import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rps extends Actor
{
    public static int countR = 0;
    public static int countP = 0;
    public static int countS = 0;
    public static int count = 0;
    
    public static int timer = 0;
    
    public rps(String type)
    {
        if(type == "rock")
        {
            countR++;
 
        }
        if(type == "paper")
        {
            countP++;

        }
        if(type == "scissor")
        {
            countS++;

        }
        count++;
    }
    
    public void act() 
    {
        timer++;
    }    
}
