import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rps extends Actor
{
    /**
     * Act - do whatever the rps wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    
    public static int timer = 0;
    public String type;
    public int size = 30;
    
    GreenfootImage rk = new GreenfootImage("\\images\\rock.png");
    GreenfootImage pp = new GreenfootImage("\\images\\paper.png");
    GreenfootImage sc = new GreenfootImage("\\images\\scissors.png");
    
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
    
    public int change(int c)
    {
        return c - Greenfoot.getRandomNumber(c*2);
    }
    
    public void bump(){}
    
    int changeX;
    int changeY;
    public int destinationX = (Greenfoot.getRandomNumber(500)) + 50;
    public int destinationY = (Greenfoot.getRandomNumber(500)) + 50;
    
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
    
    public void remove() {
        MyWorld world = (MyWorld) getWorld();
        if(world != null)

        if(world.gameEnd==true)
        {
            getWorld().removeObjects(getWorld().getObjects(rps.class));
            world.startup();
        }
    }
}
