import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wagers here.
 * 
 * @author Mekaeel
 * @version 2.1
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
    
    static GreenfootImage Rock = new GreenfootImage("\\images\\rock.png");
    static GreenfootImage Paper = new GreenfootImage("\\images\\paper.png");
    static GreenfootImage Scissors = new GreenfootImage("\\images\\scissors.png");
    
    
    GreenfootImage RockChosen = new GreenfootImage("\\images\\rockChosen.png");
    GreenfootImage PaperChosen = new GreenfootImage("\\images\\paperChosen.png");
    GreenfootImage ScissorsChosen = new GreenfootImage("\\images\\scissorsChosen.png");
    
    GreenfootImage purseLabel = new GreenfootImage(Integer.toString(purse),85,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
    
    GreenfootImage betLabel = new GreenfootImage("TBD",65,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
    
    
    public Wagers(String ftype)
    {
        type = ftype;
        
        Rock.scale(50,50);
        Paper.scale(50,50);
        Scissors.scale(50,50);
        
        RockChosen.scale(50,50);
        PaperChosen.scale(50,50);
        ScissorsChosen.scale(50,50);
        
        if(type == "bet")
        {
            placeholder.scale(127,67);
            setImage(placeholder);
            
            betPlaced = false;
            choiceMade = false;
            currentBet = "";
        }
        if(type == "bet label") setImage(betLabel);
        if(type == "Rock") setImage(Rock);
        if(type == "Paper") setImage(Paper);
        if(type == "Scissors") setImage(Scissors);
        if(type == "purse") setImage(purseLabel);
        
        purse = 10;
    }
    
    public void act()
    {
        setAmount();
        choice();
        updateImages();
        result();
        bankrupt();
        
    }
    
    public void setAmount()
    {
         if(type == "bet"&&Greenfoot.mousePressed(this)&&rps.timer<180&&!betPlaced)
         {
             f = Greenfoot.ask("How much do you want to wager (Numbers only)");
             
             if(Integer.valueOf(f) > purse)
             {
                 setAmount();
             }
             if(Integer.valueOf(f) <= purse)
             {
                 currentBetValue = Integer.valueOf(f);
                 GreenfootImage currentBetLabel = new GreenfootImage(f,70,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
                 setImage(currentBetLabel);
             }
             
             
             betPlaced = true;
         }
    }
    
    public void choice()
    {
        if(choiceMade == false)
        {
            if(Greenfoot.mousePressed(this) && type == "Rock")
            {
                setImage(RockChosen);
                choiceMade = true;
                currentBet = "Rock";
            }
            if(Greenfoot.mousePressed(this) && type == "Paper")
            {
                setImage(PaperChosen);
                choiceMade = true;
                currentBet = "Paper";
            }
            if(Greenfoot.mousePressed(this) && type == "Scissors")
            {
                setImage(ScissorsChosen);
                choiceMade = true;
                currentBet = "Scissors";
            }
        }
    }
    
    public void result()
    {
        MyWorld world = (MyWorld) getWorld();
        
        if(currentBet != "")
        {
            if(world.winner == currentBet)
            {
                purse = purse + currentBetValue;
                reset();
                world.winner = "";
            }
             if(world.winner != "" && world.winner != currentBet)
            {
                purse = purse - currentBetValue;
                reset();
                world.winner = "";
            }
        }
    }
    
    public void reset()
    {
        choiceMade = false;
        betPlaced = false;
        currentBet = "";
    }
    
    public void resetImage(Object r)
    {
        if(type == "Rock") setImage(Rock);
        if(type == "Paper") setImage(Paper);
        if(type == "Scissors") setImage(Scissors);
    }
    
    public void updateImages()
    {
        if(type == "purse")
        {
            purseLabel = new GreenfootImage(Integer.toString(purse),85,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
            setImage(purseLabel);
        }
        if(type == "bet label" && currentBet != "")
        {
            betLabel = new GreenfootImage(currentBet,65,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
            setImage(betLabel);
        }
    }
    
    public void bankrupt()
    {
        if(purse <= 0)
        {
            Greenfoot.setWorld(new lostWorld());
        }
        if(purse >= 100)
        {
            Greenfoot.setWorld(new wonWorld());
        }
    }
}
