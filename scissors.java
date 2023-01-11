import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class scissors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class scissors extends rps
{
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static int count = 0;
    public int timer = 0;
    
    public scissors()
    {
        super("scissors");
        sc.scale(size,size);
        setImage(sc);
        setRotation(180);
    }
    
    public void act() 
    {
        shift();
        bump();
        remove();
    }
    
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
