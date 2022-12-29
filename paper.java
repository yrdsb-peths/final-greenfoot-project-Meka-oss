import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class paper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class paper extends Actor
{
    /**
     * Act - do whatever the paper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int timer = 0;
    public static int count = 0;
    GreenfootImage pp = new GreenfootImage("\\images\\paper.png");
    public paper()
    {
        pp.scale(50,50);
        setImage(pp);
        
    }
    
    public void act() 
    {
        timer++;
        bob();
        move(1);
        bump();
        if(timer % 5 == 0)
        {
            shift();
        }
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
        if(isTouching(scissors.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.toAddX[world.toAdd] = getX();
            world.toAddY[world.toAdd] = getY();
            world.toAddType[world.toAdd] = "scissors";
            world.removeObject(this);
            world.replace(world.toAdd);
            world.toAdd++;
        }
    }
    
    
    public void shift()
    {
        int changeY = Greenfoot.getRandomNumber(6) - 3;
        int changeX = Greenfoot.getRandomNumber(6) - 3;
        
        changeY = getY() + changeY;
        changeX = getX() + changeX;
        
        
        setLocation(changeX,changeY);
    }
}
