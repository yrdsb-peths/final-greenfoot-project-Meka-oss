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
    
    // Overall variables that are used for choosing a winner and placing a bet 
    
    public static int purse = 10;
    public static String f;
    public static boolean betPlaced = false;
    public static boolean choiceMade = false;
    public static String currentBet;
    public static int currentBetValue;
    
    // The base images used to choose bets
    
    static GreenfootImage placeholder = new GreenfootImage("\\images\\Placeholder.png");
    
    static GreenfootImage Rock = new GreenfootImage("\\images\\rock.png");
    static GreenfootImage Paper = new GreenfootImage("\\images\\paper.png");
    static GreenfootImage Scissors = new GreenfootImage("\\images\\scissors.png");
    
    GreenfootImage purseLabel = new GreenfootImage(Integer.toString(purse),85,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
    
    GreenfootImage betLabel = new GreenfootImage("TBD",65,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
    
    // The darkened images used to show a choice
    
    GreenfootImage RockChosen = new GreenfootImage("\\images\\rockChosen.png");
    GreenfootImage PaperChosen = new GreenfootImage("\\images\\paperChosen.png");
    GreenfootImage ScissorsChosen = new GreenfootImage("\\images\\scissorsChosen.png");
    
    // A way to differentiate between the different objects using this class
    
    public String type;
    
    // Runs whenever a Wagers object is created, 
    
    public Wagers(String ftype)
    {
        type = ftype;
        
        Rock.scale(50,50);
        Paper.scale(50,50);
        Scissors.scale(50,50);
        
        RockChosen.scale(50,50);
        PaperChosen.scale(50,50);
        ScissorsChosen.scale(50,50);
        
        // Creating the betting button and reseting the associated values
        
        if(type == "bet")
        {
            placeholder.scale(127,67);
            setImage(placeholder);
            
            betPlaced = false;
            choiceMade = false;
            currentBet = "";
        }
        
        purse = 10;
        
        // Settting the images for the different types of objects
        
        if(type == "bet label") setImage(betLabel);
        if(type == "Rock") setImage(Rock);
        if(type == "Paper") setImage(Paper);
        if(type == "Scissors") setImage(Scissors);
        if(type == "purse") setImage(purseLabel);
        
    }
    
    // Calls all the different function that create the wager system
    
    public void act()
    {
        setAmount();
        choice();
        updateImages();
        result();
        bankrupt();
    }
    
    // Setting the amount that you want to wager using the Greenfoot.ask() function, and reseting if the value isn't acceptable using recursion 
    
    public void setAmount()
    {
         if(type == "bet"&&Greenfoot.mousePressed(this)&&rps.timer<240&&!betPlaced)
         {
             f = Greenfoot.ask("How much do you want to wager (Numbers only)");
             try {
                 int d = Integer.parseInt(f);
             } catch (NumberFormatException nfe) {
                 setAmount();
             }
             
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
             
             // Stops the user from changing the value after choosing it the first time
             betPlaced = true;
         }
    }
    
    // Checks if the user has chosen their predicted winner and highlights the object you select
    
    public void choice()
    {
        if(choiceMade == false && rps.timer<240)
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
    
    // After a winner has been chosen from the world function, this function adds or subtracts the wager from the users purse
    
    public void result()
    {
        MyWorld world = (MyWorld) getWorld();
        
        if(world.winner != "")
        {
            if(world.winner == currentBet)
            {
                purse = purse + currentBetValue;
                reset();
                world.winner = "";
            }
             if(world.winner != currentBet)
            {
                purse = purse - currentBetValue;
                reset();
                world.winner = "";
            }
        }
    }
    
    // Resets the variables that stop the user from recinding their bets
    
    public void reset()
    {
        choiceMade = false;
        betPlaced = false;
        currentBet = "";
    }
    
    // Resets the necessary images when required
    
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
    
    // Changes the world depending if the purse is empty or has reached its goal
    
    public void bankrupt()
    {
        if(purse <= 0)
        {
            Greenfoot.setWorld(new lostWorld());
        }
        if(purse >= 50)
        {
            Greenfoot.setWorld(new wonWorld());
        }
    }
}
