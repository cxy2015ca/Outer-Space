import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    boolean buttonState = false;
    String buttonText = "Start game";
    
    public Button() {
    buttonOff();
    }
    
    public Button(boolean stateIn, String textIn) {
        buttonText = textIn;
        if (stateIn) buttonOn();
        else buttonOff();
    }
    
    /**
     *the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void buttonOff() {
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 20, Color.CYAN, Color.BLACK);
        setImage(buttonImage);
        buttonState = false;
    }
    
    public void buttonOn() {
        GreenfootImage buttonImage = new GreenfootImage(buttonText, 20, Color.BLACK, Color.GREEN);
        setImage(buttonImage);
        buttonState = true;
    }
    
    public void buttonToggle() {
        if (buttonState) {
            buttonOff();
        }
        else {
            buttonOn();
        }
    }
}
