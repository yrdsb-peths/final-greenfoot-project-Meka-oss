import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class paper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class paper extends rps
{
    /**
     * Act - do whatever the paper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int timer = 0;
    public static int count = 0;
    
    public paper()
    {
        super("paper");
        pp.scale(size,size);
        setImage(pp);
        
    }
    
    public void act() 
    {
        bob();
        if(timer % 5 == 0)
        {
            shift();
        }
        bump();
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
}
