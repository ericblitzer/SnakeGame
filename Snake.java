import java.util.Random;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake{
  
    private Node nodeListFront, nodeListBack;
  
    private int length;
    private double radius = 1;
    
    private int xCoordinate, yCoordinate;
    private int foodXCoord, foodYCoord;
    
    public Snake(){
        nodeListFront = new Node();
        nodeListBack = new Node();
        length=0;
        
        //(int) Math.ceil(Math.random()*100)
        
        Random randNumGen = new Random();
        foodXCoord = (int)Math.ceil(Math.random()*100);
        foodYCoord = (int)Math.ceil(Math.random()*100);
        
        if(foodXCoord%2 == 0){
            if(foodXCoord == 1) foodXCoord++;
            else foodXCoord--;
        }
        if(foodYCoord%2 == 0){
            if(foodYCoord == 1) foodYCoord++;
            else foodYCoord--;
        }                       
                               
                                 
        
    }
    
    public int getFoodXCoord(){
        return foodXCoord;  
    }
    
    public int getFoodYCoord(){
        return foodYCoord;  
    }
    
   /* public void addSquare(int index, double xCoord, double yCoord){       
        listOfXCoords.add(index, xCoord);
        listOfYCoords.add(index, yCoord);
    }*/
    
    public void addSquare(double xCoord, double yCoord){
        
        if(length==0){
            nodeListFront.setCoords(xCoord, yCoord);
            nodeListFront.setNext(nodeListBack);
        }
        else if(length==1){
            nodeListBack.setCoords(xCoord, yCoord);
            
        }
        else{
            Node temp = new Node();
            temp.setCoords(xCoord, yCoord);
            nodeListBack.setNext(temp);
            nodeListBack = temp;
        }
        length++;
        
      //  System.out.println(nodeListFront.getXCoord());
    }
    
    public void drawFirstSquares(){
        StdDraw.setPenColor(StdDraw.BLACK);
        
        double[] coordinates = new double[2];
        
        StdDraw.filledSquare(53, 49, radius);
        addSquare(53, 49);
        StdDraw.filledSquare(51, 49,radius);
        addSquare(51, 49);
        StdDraw.filledSquare(49, 49,radius);
        addSquare(49, 49);
        StdDraw.filledSquare(47, 49,radius);
        addSquare(47, 49);
        StdDraw.filledSquare(45, 49,radius);
        addSquare(45, 49);
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
        
       // while(placeHolder.getNext() != null){
        for(int i=0; i<length; i++){
           // System.out.println("x: "+placeHolder.getXCoord()+" y: "+placeHolder.getYCoord());
            placeHolder = placeHolder.getNext();
        }
       // System.out.println();
     
        
    }
    

    
    public boolean drawSquare(int newXCoord, int newYCoord){
        StdDraw.setPenColor(StdDraw.BLACK);
        //System.out.println("here");
        
       // Random randNumGen = new Random();
        
       //\ double newXCoord = (2*randNumGen.nextDouble()*50)-1;
        //double newYCoord = (2*randNumGen.nextDouble()*50)-1;
        
        
        if((newXCoord==xCoordinate && newYCoord==yCoordinate) != true){
            //System.out.println("here");
            foodXCoord = newXCoord;
            foodYCoord = newYCoord;
            StdDraw.filledSquare(newXCoord, newYCoord, radius);
            return true;
        } else{
            return false;  
        }
        
    }
    
    public void moveSnake(String direction){
      
      if(direction=="right"){

        Node temp = new Node();
        temp.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord());
        temp.setNext(nodeListFront.getNext());
        nodeListFront.setCoords(nodeListFront.getXCoord()+2, nodeListFront.getYCoord());
        nodeListFront.setNext(temp);
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
        
        for(int i=0; i<length; i++){
           // System.out.println("x: "+placeHolder.getXCoord()+" y: "+placeHolder.getYCoord());
            StdDraw.filledSquare(placeHolder.getXCoord(), placeHolder.getYCoord(), radius);
            placeHolder = placeHolder.getNext();
        }
        
      }
      
      else if(direction=="up"){

        Node temp = new Node();
        temp.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord());
        temp.setNext(nodeListFront.getNext());
        nodeListFront.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord()+2);
        nodeListFront.setNext(temp);
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
        
        for(int i=0; i<length; i++){
           // System.out.println("x: "+placeHolder.getXCoord()+" y: "+placeHolder.getYCoord());
            StdDraw.filledSquare(placeHolder.getXCoord(), placeHolder.getYCoord(), radius);
            placeHolder = placeHolder.getNext();
        }
        
      }
      
      else if(direction=="left"){

        Node temp = new Node();
        temp.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord());
        temp.setNext(nodeListFront.getNext());
        nodeListFront.setCoords(nodeListFront.getXCoord()-2, nodeListFront.getYCoord());
        nodeListFront.setNext(temp);
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
        
        for(int i=0; i<length; i++){
           // System.out.println("x: "+placeHolder.getXCoord()+" y: "+placeHolder.getYCoord());
            StdDraw.filledSquare(placeHolder.getXCoord(), placeHolder.getYCoord(), radius);
            placeHolder = placeHolder.getNext();
        }
        
      }
      
      else if(direction=="down"){

        Node temp = new Node();
        temp.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord());
        temp.setNext(nodeListFront.getNext());
        nodeListFront.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord()-2);
        nodeListFront.setNext(temp);
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
        
        for(int i=0; i<length; i++){
           // System.out.println("x: "+placeHolder.getXCoord()+" y: "+placeHolder.getYCoord());
            StdDraw.filledSquare(placeHolder.getXCoord(), placeHolder.getYCoord(), radius);
            placeHolder = placeHolder.getNext();
        }
        
      }

    }
  
}