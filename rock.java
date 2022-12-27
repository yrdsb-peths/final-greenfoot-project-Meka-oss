import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rock extends Actor
{
    /**
     * Act - do whatever the rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int timer = 0;
    
    GreenfootImage rk = new GreenfootImage("\\images\\rock.png");
    public rock()
    {
        rk.scale(50,50);
        setImage(rk);
    }
    
    public void act() 
    {
        timer++;
        bob();
        bump();
        move(1);
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
