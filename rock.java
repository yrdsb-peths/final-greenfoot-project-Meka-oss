import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wagers here.
 * 
 * @author Mekaeel
 * @version 2.1
 */

public class rock extends rps
{
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    // Creates a paper RPS object and scales the images to a chosen size
    
    public rock()
    {
        super("rock");
        rk.scale(size,size);
        setImage(rk);
    }
    
    // Calls the functions created every frame
    
    public void act() 
    {
        shift();
        bump();
        remove();
    }
    
    // Using the placeholder function added to remove itself if it touches the opposite object
    
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
