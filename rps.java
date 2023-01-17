import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wagers here.
 * 
 * @author Mekaeel
 * @version 2.1
 */

public class rps extends Actor
{
    /**
     * Act - do whatever the rps wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // Setting up the necessary variables for the class
    
    public static int timer = 0;
    public String type;
    public int size = 30;
    
    // Creating the images that are used for the objects
    
    GreenfootImage rk = new GreenfootImage("\\images\\rock.png");
    GreenfootImage pp = new GreenfootImage("\\images\\paper.png");
    GreenfootImage sc = new GreenfootImage("\\images\\scissors.png");
    
    // Adding values whenever a new object is created, as well as setting the type
    
    public rps(String ftype)
    {
        MyWorld world = (MyWorld) getWorld();
        if(type == "rock")
        {
            world.rockCount++;
        }
        else if(type == "paper")
        {
            world.paperCount++;
        }
        else if(type == "scissors")
        {
            world.scissorsCount++;
        }
        type = ftype;
    }
    
    // A placeholder for the replacing function that will be tailored for each type
    
    public void bump(){}
    
    // Setting up the different values used for randomly moving the objects around
    
    int changeX;
    int changeY;
    public int destinationX = (Greenfoot.getRandomNumber(500)) + 50;
    public int destinationY = (Greenfoot.getRandomNumber(500)) + 50;
    
    // Randomly moves the RPS objects around using Greenfoot.getRandomNumber()
    
    public void shift()
    {        
        MyWorld world = (MyWorld) getWorld();
        if(world.gamePause == false && world.gameEnd == false)
        {
            changeX = getX();
            changeY = getY();
            
            if(timer % 60 == 0)
            {
                destinationX = (Greenfoot.getRandomNumber(600));
                destinationY = (Greenfoot.getRandomNumber(600));
                
            }
        
            if(getX() > destinationX)
            {
                changeX--;
            }
            else if(getX() < destinationX)
            {
                changeX++;
            }
            
            if(getY() > destinationY)
            {
                changeY--;
            }
            else if(getY() < destinationY)
            {
                changeY++;
            }
            
            setLocation(changeX,changeY);
            
        }
    }
    
    // Getting rid of all the objects once the game has finished
    
    public void remove() {
        MyWorld world = (MyWorld) getWorld();
        if(world != null)
        {
            if(world.gameEnd==true)
            {
                getWorld().removeObjects(getWorld().getObjects(rps.class));
                world.startup();
            }
        }
    }
}
