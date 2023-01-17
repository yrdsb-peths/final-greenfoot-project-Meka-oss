import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wagers here.
 * 
 * @author Mekaeel
 * @version 2.1
 */

public class MyWorld extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     * Creating all the different objects that will be used
     */
    
    rps time = new Timer(0,100);
    
    Label countP = new Label(0,50);
    Label P = new Label("Paper",20);
        
    Label countR = new Label(0,50);
    Label R = new Label("Rock",20);
    
    Label countS = new Label(0,50);
    Label S = new Label("Scissor",20);
    
    border border = new border("border");
    Label lastWin = new Label("TBD",60);
    Label lastWinLabel = new Label("Last Win",25);
    
    Wagers currency = new Wagers("purse");
    Label currencyLabel = new Label("Coins",35);
    
    Label wagers = new Label("Wagers",65);
    Wagers bet = new Wagers("bet");
    
    Wagers rock = new Wagers("Rock");
    Wagers paper = new Wagers("Paper");
    Wagers scissors = new Wagers("Scissors");
    
    Wagers betLabel = new Wagers("bet label");
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a c   ell size of 1x1 pixels.
        super(800, 600, 1);
        
        startup();
        
        // Adding all the objects I created into the world
        
        addObject(countS,550,50);
        addObject(S,550,20);
        
        addObject(countP,495,50);
        addObject(P,495,20);
        
        addObject(countR,445,50);
        addObject(R,445,20);
        
        addObject(border,700,300);
        
        addObject(lastWin,700,65);
        addObject(lastWinLabel,700,25);
        
        addObject(currency,700,180);
        addObject(currencyLabel,700,125);
        
        addObject(wagers,700,280);
        addObject(bet,700,350);
        
        addObject(rock,635,435);
        addObject(paper,705,435);
        addObject(scissors,770,435);
        
        addObject(betLabel,700,535);
    }
    
    // Creating placeholders to count how many of each type is currently on the field
    
    public int rockCount;
    public int paperCount;
    public int scissorsCount;
    public int totalCount;
    
    // A function that contains all the parts needed to create the auto RPS System
    
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
        addObject(time,60,60);
        
        
        gameEnd = false;
        gamePause = false;
    }
    
    // These are lists that store all the necessary data for changing an RPS object when they collide
    
    public int[] toAddX = new int[30000];
    public int[] toAddY = new int[30000];
    public String[] toAddType = new String[30000];
    public int toAdd = 0;
    
    // This is used to replace and RPS object when it collides with another
    
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
    
    // Adds one Rock, one Paper and one Scissors object randomly in the world
    
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
    
    // These are variables used to check if the game should end or be paused, as well as if a winner has been decided
    
    public boolean gamePause = false;
    public boolean gameEnd = false;
    
    public String winner = "";
    
    // Checks if there is only one type of RPS object left in the world, and resets it if there is
    
    public void endGame()
    {
        winner = "";
        if(rockCount == totalCount)
        {
            gamePause = true;
            gameEnd = true;
            winner = "Rock";
            lastWin.setValue("Rock");
            resetImages();
        }
        else if(paperCount == totalCount)
        {
            gamePause = true;
            gameEnd = true;
            winner = "Paper";
            lastWin.setValue("Paper");
            resetImages();
        }
        else if(scissorsCount == totalCount)
        {
            gamePause = true;
            gameEnd = true;
            winner = "Scissors";
            lastWin.setValue("Scissors");
            resetImages();
        }
    }
    
    // Resets the betting images
    
    public void resetImages()
    {
        rock.setImage(Wagers.Rock);
        paper.setImage(Wagers.Paper);
        scissors.setImage(Wagers.Scissors);
        bet.setImage(Wagers.placeholder);
    }
}
