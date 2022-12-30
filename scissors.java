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
     * Act - do whatever the scissors wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static int count = 0;
    public int timer = 0;
    
    GreenfootImage sc = new GreenfootImage("\\images\\scissors.png");
    public scissors()
    {
        sc.scale(50,50);
        setImage(sc);
        setRotation(180);
    }
    
    public void act() 
    {
        timer++;
        bob();
        if(timer % 5 == 0)
        {
            shift();
        }
        bump();
    }    
    
    public int y;
    public void bob()
    {
        y = getY();
        if(timer%20==0)
        {
            y = y+2;
            setLocation(getX(),y);
        }
        if(timer%10==0)
        {
            y = y-1;
            setLocation(getX(),y);
        }
        
    }
    
    MyWorld world = (MyWorld) getWorld();
    
    public void bump()
    {
        if(isTouching(rock.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.toAddX[world.toAdd] = getX();
            world.toAddY[world.toAdd] = getY();
            world.toAddType[world.toAdd] = "rock";
            world.removeObject(this);
            world.replace(world.toAdd);
            world.toAdd++;
        }
    }
    
    
   int changeX;
    int changeY;
    int destinationX = (Greenfoot.getRandomNumber(500)) + 50;
    int destinationY = (Greenfoot.getRandomNumber(500)) + 50;
    
    public void shift()
    {
        changeX = getX();
        changeY = getY();
    
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
        
        if(timer % 2 ==0)
        {
            if(changeX == destinationX && changeY == destinationY)
            {
                destinationX = (Greenfoot.getRandomNumber(500)) + 50;
                destinationY = (Greenfoot.getRandomNumber(500)) + 50;
                System.out.println("destination reached");
            }
            setLocation(changeX,changeY);
        }
    }
}
