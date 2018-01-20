import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class Space extends World
{
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    
    int gameState;
    
   private int gameTime = 0;
    /**
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);

    }
    
    public Counter getCounter()
    {
        return counter;
    }
    
    public HealthBar getHealthBar()
    {
        return healthbar;
    }
    
    /**
     * variable gameTime would become one bigger each time the program runs through
     */
    public void act() {
        addObject(counter, 100, 40);
        addObject(healthbar, 200, 40);
        
        switch (gameState) {
        case 0: addObject( new Button(false, "Start game"), 100, 100);//start screen, initialization
                gameState = 1;
                //there's no break here so the program automatic runs into case 1 after
        case 1:  
                MouseInfo mouse = Greenfoot.getMouseInfo(); //start screen loop
        
            if (mouse != null) {
                    Actor currentActor = mouse.getActor();
                if (currentActor != null) {
                  if (currentActor.getClass() == Button.class) {
                      
                        Button currentButton = (Button)currentActor;
                        int mouseButtonPressed = mouse.getButton();
                        int mouseClickCount = mouse.getClickCount();
                        System.out.println(mouseButtonPressed+" "+mouseClickCount );
                        if(mouseClickCount == 1) {
                        currentButton.buttonToggle();
                        gameState = 2;
                        removeObject(currentButton);
                       }
                    }
                }
              }     
        
                break;
               
        case 2:addObject( new Rocket(), 100, 200);   //game initialization
               addObject( new asteroid(), 500, 250);
               gameTime = 0;
               gameState = 3;
               //there is no break here, so it automatically goes into case 2, the game play
        case 3: gameTime += 1;  //gameTime = gameTime +1   //start game
                if ( (gameTime % 360) == 0 ) {
                    //if time/180 leaves a remainder of 0, (gameTime is a factor of 180)
                    //add another object in a random spot
                  addObject( new asteroid(), (int)(Math.random()*600),(int)(Math.random()*400)); 
                }
                if (Greenfoot.isKeyDown("r")) {
                   gameState = 2;
                  removeObjects(getObjects(null)); 
                }
                
                break;
                //now it's gonna loop, but since we're on case 2
                //it'll repeat just the game play
      
        //case 3: //ending the game
        
        default: gameState = 0;
  
      }
    }
  
    public int getTime() {
        return gameTime;
    }
}

