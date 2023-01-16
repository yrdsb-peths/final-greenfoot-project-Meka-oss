import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wagers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wagers extends Actor
{
    /**
     * Act - do whatever the Wagers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static int purse = 10;
    public static String f;
    public String type;
    
    
    public static boolean betPlaced = false;
    public static boolean choiceMade = false;
    public static String currentBet;
    public static int currentBetValue;
    
    GreenfootImage placeholder = new GreenfootImage("\\images\\Placeholder.png");
    
    GreenfootImage rock = new GreenfootImage("\\images\\rock.png");
    GreenfootImage paper = new GreenfootImage("\\images\\paper.png");
    GreenfootImage scissors = new GreenfootImage("\\images\\scissors.png");
    
    
    GreenfootImage rockChosen = new GreenfootImage("\\images\\rockChosen.png");
    GreenfootImage paperChosen = new GreenfootImage("\\images\\paperChosen.png");
    GreenfootImage scissorsChosen = new GreenfootImage("\\images\\scissorsChosen.png");
    
    GreenfootImage purseLabel = new GreenfootImage(Integer.toString(purse),85,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
    
    public Wagers(String ftype)
    {
        type = ftype;
        
        rock.scale(50,50);
        paper.scale(50,50);
        scissors.scale(50,50);
        
        rockChosen.scale(50,50);
        paperChosen.scale(50,50);
        scissorsChosen.scale(50,50);
        
        if(type == "bet")
        {
            placeholder.scale(127,67);
            setImage(placeholder);
            
            betPlaced = false;
            choiceMade = false;
            currentBet = "";
        }
        if(type == "rock") setImage(rock);
        if(type == "paper") setImage(paper);
        if(type == "scissors") setImage(scissors);
        if(type == "purse") setImage(purseLabel);
        
        purse = 10;
    }
    
    public void act()
    {
        setAmount();
        choice();
        if(type == "purse")
        {
            purseLabel = new GreenfootImage(Integer.toString(purse),85,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
            setImage(purseLabel);
        }
        result();
    }
    
    public void setAmount()
    {
         if(type == "bet"&&Greenfoot.mousePressed(this)&&rps.timer<180&&!betPlaced)
         {
             f = Greenfoot.ask("How much do you want to wager (Numbers only)");
             GreenfootImage currentBetLabel = new GreenfootImage(f,70,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
             setImage(currentBetLabel);
             
             currentBetValue = Integer.valueOf(f);
             betPlaced = true;
         }
    }
    
    public void choice()
    {
        if(choiceMade == false)
        {
            if(Greenfoot.mousePressed(this) && type == "rock")
            {
                setImage(rockChosen);
                choiceMade = true;
                currentBet = "rock";
            }
            if(Greenfoot.mousePressed(this) && type == "paper")
            {
                setImage(paperChosen);
                choiceMade = true;
                currentBet = "paper";
            }
            if(Greenfoot.mousePressed(this) && type == "scissors")
            {
                setImage(scissorsChosen);
                choiceMade = true;
                currentBet = "scissors";
            }
        }
    }
    
    public void result()
    {
        MyWorld world = (MyWorld) getWorld();
        System.out.println(world.winner);
        System.out.println(currentBet);
        
        if(currentBet != "" && world.winner == currentBet)
        {
            purse = purse + currentBetValue;
            reset();
        }
    }
    
    public void reset()
    {
        choiceMade = false;
        betPlaced = false;
        currentBet = "";
        if(type == "rock") setImage(rock);
        if(type == "paper") setImage(paper);
        if(type == "scissors") setImage(scissors);
    }
}
