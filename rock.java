import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rock extends rps
{
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int timer = 0;

    public rock()
    {
        super("rock");
        rk.scale(size,size);
        setImage(rk);
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
    
    public void bump()
    {
        if(isTouching(paper.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.toAddX[world.toAdd] = getX();
            world.toAddY[world.toAdd] = getY();
            world.toAddType[world.toAdd] = "paper";
            world.removeObject(this);
            world.replace(world.toAdd);
            world.toAdd++;
        }
    }

}
