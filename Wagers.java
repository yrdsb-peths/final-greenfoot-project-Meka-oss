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
    
    // The base images shown before a bet is made
    
    static GreenfootImage placeholder = new GreenfootImage("\\images\\Placeholder.png");
    
    // creating the arrays for the animation
    
    static GreenfootImage[] Rock = new GreenfootImage[2];
    static GreenfootImage[] Paper = new GreenfootImage[2];
    static GreenfootImage[] Scissors = new GreenfootImage[2];
    
    GreenfootImage purseLabel = new GreenfootImage(Integer.toString(purse),85,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
    
    GreenfootImage betLabel = new GreenfootImage("TBD",45,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
    
    // The darkened images used to show a choice
    
    // A way to differentiate between the different objects using this class
    
    public String type;
    
    // Runs whenever a Wagers object is created, 
    
    public Wagers(String ftype)
    {
        // Adding the base images to the image array I created
        Rock[0] = new GreenfootImage("\\images\\rock.png");
        Paper[0] = new GreenfootImage("\\images\\paper.png");
        Scissors[0] = new GreenfootImage("\\images\\scissors.png");
        
        // Adding in the second state for the animated image
        Rock[1] = new GreenfootImage("\\images\\rockChosen.png");
        Paper[1] = new GreenfootImage("\\images\\paperChosen.png");
        Scissors[1] = new GreenfootImage("\\images\\scissorsChosen.png");
        
        
        type = ftype;
        
        // Scaling the images
        
        Rock[0].scale(50,50);
        Rock[1].scale(50,50);
        
        Paper[0].scale(50,50);
        Paper[1].scale(50,50);
        
        Scissors[0].scale(50,50);
        Scissors[1].scale(50,50);
        
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
        if(type == "Rock") setImage(Rock[0]);
        if(type == "Paper") setImage(Paper[0]);
        if(type == "Scissors") setImage(Scissors[0]);
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
         if(type == "bet"&&Greenfoot.mousePressed(this)&&rps.timer<360&&!betPlaced)
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
        if(choiceMade == false && rps.timer<360)
        {
            if(Greenfoot.mousePressed(this) && type == "Rock")
            {
                setImage(Rock[1]);
                choiceMade = true;
                currentBet = "Rock";
            }
            if(Greenfoot.mousePressed(this) && type == "Paper")
            {
                setImage(Paper[1]);
                choiceMade = true;
                currentBet = "Paper";
            }
            if(Greenfoot.mousePressed(this) && type == "Scissors")
            {
                setImage(Scissors[1]);
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
            betLabel = new GreenfootImage(currentBet,45,greenfoot.Color.WHITE,greenfoot.Color.WHITE,greenfoot.Color.BLACK);
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
