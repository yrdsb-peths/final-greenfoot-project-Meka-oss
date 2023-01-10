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
    
    
    public int rockCount;
    public int paperCount;
    public int scissorsCount;
    
    Label countP = new Label(0,50);
    Label P = new Label("Paper",20);
        
    Label countR = new Label(0,50);
    Label R = new Label("Rock",20);
    
    Label countS = new Label(0,50);
    Label S = new Label("Scissor",20);
    
    wager border = new wager("border");
    Label scoreLabel = new Label(10,100);
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a c   ell size of 1x1 pixels.
        super(800, 600, 1);
        
        startup();
        
        rps time = new Timer(0,100);
        addObject(time,75,75);
        
        addObject(countS,550,50);
        addObject(S,550,20);
        
        addObject(countP,495,50);
        addObject(P,495,20);
        
        addObject(countR,445,50);
        addObject(R,445,20);
        
        addObject(border,700,300);
        addObject(scoreLabel,700,300);
    }
    
    public void startup()
    {
        totalCount = 0;
        rockCount = 0;
        paperCount = 0;
        scissorsCount = 0;
        
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        addRPS();
        
        rps.timer = 0;
        
        gameEnd = false;
        gamePause = false;
        
        toAddX = new int[300];
        toAddY = new int[300];
        toAddType = new String[300];
        toAdd = 0;
    }
    
    
    public int[] toAddX = new int[300];
    public int[] toAddY = new int[300];
    public String[] toAddType = new String[30000];
    public int toAdd = 0;
    
    public int totalCount;
    
    public void replace(int index)
    {
        if(toAddType[index]=="scissors")
        {
            rps obj4 = new scissors();
            addObject(obj4,toAddX[index],toAddY[index]);
            paperCount--;
            scissorsCount++;
        }
        else if(toAddType[index]=="rock")
        {
            rps obj4 = new rock();
            addObject(obj4,toAddX[index],toAddY[index]);
            rockCount++;
            scissorsCount--;
        }
        else if(toAddType[index]=="paper")
        {
            rps obj4 = new paper();
            addObject(obj4,toAddX[index],toAddY[index]);
            rockCount--;
            paperCount++;
        }
        countP.setValue(paperCount);
        countS.setValue(scissorsCount);
        countR.setValue(rockCount);
    }
    
    public void addRPS()
    {
        
        rps obj1 = new rock();
        addObject(obj1,Greenfoot.getRandomNumber(500) + 50,Greenfoot.getRandomNumber(500) + 50);
        rockCount++;
        
        rps obj2 = new paper();
        addObject(obj2,Greenfoot.getRandomNumber(500) + 50,Greenfoot.getRandomNumber(500) + 50);
        paperCount++;
        
        rps obj3 = new scissors();
        addObject(obj3,Greenfoot.getRandomNumber(500) + 50,Greenfoot.getRandomNumber(500) + 50);
        scissorsCount++;
        
        totalCount = totalCount + 3;
    }
    
    public boolean gamePause = false;
    public boolean gameEnd = false;
    
    public String winner = "";
    
    public void endGame()
    {
        if(rockCount == totalCount)
        {
            gamePause = true;
            gameEnd = true;
            winner = "Rock";
            
        }
        else if(paperCount == totalCount)
        {
            gamePause = true;
            gameEnd = true;
            winner = "Paper";
            
        }
        else if(scissorsCount == totalCount)
        {
            gamePause = true;
            gameEnd = true;
            winner = "Scissor";
            
        }
    }
}
