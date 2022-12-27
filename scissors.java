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
    public int timer = 0;
    
    GreenfootImage sc = new GreenfootImage("\\images\\scissors.png");
    public scissors()
    {
        sc.scale(50,50);
        setImage(sc);
    }
    
    public void act() 
    {
        timer++;
        bob();
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
}
