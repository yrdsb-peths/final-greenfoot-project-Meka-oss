import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        totalCount = 0;
        rock.count = 0;
        paper.count = 0;
        scissors.count = 0;

        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        
    }
    
    
    public int[] toAddX = new int[300];
    public int[] toAddY = new int[300];
    public String[] toAddType = new String[300];
    public int toAdd = 0;
    
    public int totalCount = 0;
    
    public void replace(int index)
    {
        if(toAddType[index]=="scissors")
        {
            scissors obj4 = new scissors();
            addObject(obj4,toAddX[index],toAddY[index]);
            paper.count--;
            scissors.count++;
        }
        else if(toAddType[index]=="rock")
        {
            rock obj4 = new rock();
            addObject(obj4,toAddX[index],toAddY[index]);
            rock.count++;
            scissors.count--;
        }
        else if(toAddType[index]=="paper")
        {
            paper obj4 = new paper();
            addObject(obj4,toAddX[index],toAddY[index]);
            rock.count--;
            paper.count++;
        }
    }
    
    public void addRPS()
    {
        
        scissors obj1 = new scissors();
        addObject(obj1,Greenfoot.getRandomNumber(500) + 50,Greenfoot.getRandomNumber(500) + 50);
        scissors.count++;
        
        paper obj2 = new paper();
        addObject(obj2,Greenfoot.getRandomNumber(500) + 50,Greenfoot.getRandomNumber(500) + 50);
        paper.count++;
        
        rock obj3 = new rock();
        addObject(obj3,Greenfoot.getRandomNumber(500) + 50,Greenfoot.getRandomNumber(500) + 50);
        rock.count++;
    }
}
