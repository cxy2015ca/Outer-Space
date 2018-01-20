import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class asteroid extends Mover
{
  //sizes of the asteroid
  int currentSize = 100;
  int smallestSize = 10;
  Space currentWorld;
    
   //this is a method that calls a new asteroid
   //"this" calls itself again and sets a default size
   //having two different functions with the exact same name, this is called overloading
   public asteroid(){
        this(100);
    }
    
    //defined the size, user imputs the size
    public asteroid(int sizeIn) {
        speed = Math.random() * 3;
        turn( (int)(Math.random()*360));
        currentSize = sizeIn;
        sizeImage();
        //sizeImage is a custom made method
    }
    
    private void sizeImage() {
       if (currentSize <= smallestSize) {
           currentWorld.removeObject(this);
        }
        
        GreenfootImage image = getImage();
        //image.scale(int width, int height)
        //u can use currentSize for both here bc the image is a square
        //if rectangle, there would be some proportioning needed
        image.scale(currentSize,currentSize);
        setImage(image);
    }
    
    public void scaleSize (double scaleFactor) {
        //this just rounds the currentSize to an integer
       currentSize = Math.round ( (int) (currentSize*scaleFactor));
    }
    
    
    public void act() 
    {
        currentWorld = (Space)getWorld();
        moveSteadily();
        
        Actor bullet;
        //asking if you're nitersecting with anything of the type bullet class
        bullet = getOneIntersectingObject(Bullet.class);
        
        if (bullet !=null) //if it does detect something 
        {
            scaleSize(0.5);
            sizeImage();
            currentWorld.removeObject(bullet);
            if (currentSize >= smallestSize) {
            currentWorld.addObject(new asteroid(currentSize), (int)getX(), (int)getY());
        }
        }
        }
  
        //the rocket will be removed from Space when it gets hit by an asteroid
      //  if (isTouching(null)) {
       //     removeTouching(null);
   //} 
}

   

