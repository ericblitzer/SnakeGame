import java.util.Random;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake{
  
    private Node nodeListFront, nodeListBack;
    private int length;
    private double radius = 2;  
    private double xCoordinate, yCoordinate;
    private double foodXCoord, foodYCoord;
    
    public Snake(){
        nodeListFront = new Node();
        nodeListBack = new Node();
        length=0;
        newFood();     
    }
    
    public int getLength(){
        return length;  
    }
    
    public void newFood(){
     // System.out.println("here");
        boolean ok=false;
        while(ok==false){
         // System.out.println("here");
        Random randNumGen = new Random();
        foodXCoord = Math.ceil(Math.random()*100);
        foodYCoord = Math.ceil(Math.random()*100);
        
        if(foodXCoord%2 != 0){
            if(foodXCoord == 1) foodXCoord++;
            else foodXCoord--;
            
            
        }
        if(foodXCoord%4 == 0){
        	if(foodXCoord==4) foodXCoord+=2;
        	else foodXCoord-=2;
        }
        if(foodYCoord%2 != 0){
            if(foodYCoord == 1) foodYCoord++;
            else foodYCoord--;
            
            
        }   
        if(foodYCoord%4 == 0){
        	if(foodYCoord==4) foodYCoord+=2;
        	else foodYCoord-=2;
        }
        System.out.println("XFood: "+foodXCoord);
        System.out.println("YFood: "+foodYCoord);
        //ok=true;
       // System.out.println("here");
        Node temp = new Node();
        temp = nodeListFront;
        ok=true;
        while(temp.getNext() != null){
          if(foodXCoord==temp.getXCoord() && foodYCoord==temp.getYCoord()){
              ok=false; 
          }
          temp = temp.getNext();
        }
        }
    }
    
    public double getFoodXCoord(){
        return foodXCoord;  
    }
    
    public double getFoodYCoord(){
        return foodYCoord;  
    }
    
    public void addSquare(double xCoord, double yCoord){
        
        if(length==0){
            nodeListFront.setCoords(xCoord, yCoord);
            nodeListFront.setNext(nodeListBack);
        }else if(length==10){
            nodeListBack.setCoords(xCoord, yCoord);
            
        }else{
            Node temp = new Node();
            temp.setCoords(xCoord, yCoord);
            nodeListBack.setNext(temp);
            nodeListBack = temp;
        }
        length+=10;
        
        xCoordinate = nodeListFront.getXCoord();
        yCoordinate = nodeListFront.getYCoord();

        System.out.println(length);
    }
    
    public void drawFirstSquares(){
        StdDraw.setPenColor(StdDraw.BLACK);
        
        double[] coordinates = new double[2];
        
        StdDraw.filledSquare(58, 50, radius);
        addSquare(58, 50);
        StdDraw.filledSquare(54, 50,radius);
        addSquare(54, 50);
        StdDraw.filledSquare(50, 50,radius);
        addSquare(50, 50);
        StdDraw.filledSquare(46, 50,radius);
        addSquare(46, 50);
        StdDraw.filledSquare(42, 50,radius);
        addSquare(42, 50);

        Node placeHolder = new Node();
        placeHolder = nodeListFront;

    }
    

    
    public boolean drawSquare(double newXCoord, double newYCoord){
        StdDraw.setPenColor(StdDraw.BLACK);

        if((newXCoord==xCoordinate && newYCoord==yCoordinate) != true){
            foodXCoord = newXCoord;
            foodYCoord = newYCoord;
            StdDraw.filledSquare(newXCoord, newYCoord, radius);
            return true;
        } else{
            return false;  
        }
        
    }
    
    public int moveSnake(int direction){
      int result=0;
      
      if(direction==4){
        drawSquare(foodXCoord, foodYCoord);
        if((nodeListFront.getXCoord()+4)<=99){ 
          
          
          Node temp = new Node();
          temp.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord());
          temp.setNext(nodeListFront.getNext());
          nodeListFront.setCoords(nodeListFront.getXCoord()+4, nodeListFront.getYCoord());
          nodeListFront.setNext(temp);
          
          xCoordinate = nodeListFront.getXCoord();
          yCoordinate = nodeListFront.getYCoord();
          
         // System.out.println("XCoord: "+xCoordinate);
         // System.out.println("YCoord: "+yCoordinate);
          
          if(xCoordinate>99 || xCoordinate<1 || yCoordinate>99 || yCoordinate<1){
            //System.out.println("too far");
            result = 1;    
          }
          
          if(xCoordinate==foodXCoord && yCoordinate==foodYCoord){
            newFood();
            addSquare(nodeListBack.getXCoord(), nodeListBack.getYCoord());
          }
        } else result=1;
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
       
        
        for(int i=0; i<(length/10); i++){
            StdDraw.filledSquare(placeHolder.getXCoord(), placeHolder.getYCoord(), radius);
            placeHolder = placeHolder.getNext();
            if(xCoordinate==placeHolder.getXCoord() && yCoordinate==placeHolder.getYCoord()) result=1;
        }
        
      }
      
      else if(direction==1){
        drawSquare(foodXCoord, foodYCoord);
        if((nodeListFront.getYCoord()+4)<=99){ 
          
          
          Node temp = new Node();
          temp.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord());
          temp.setNext(nodeListFront.getNext());
          nodeListFront.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord()+4);
          nodeListFront.setNext(temp);
          
          xCoordinate = nodeListFront.getXCoord();
          yCoordinate = nodeListFront.getYCoord();
          
          if(xCoordinate>99 || xCoordinate<1 || yCoordinate>99 || yCoordinate<1){
            result = 1;       
          }
          
          if(xCoordinate==foodXCoord && yCoordinate==foodYCoord){
            newFood();
            addSquare(nodeListBack.getXCoord(), nodeListBack.getYCoord());
          }
        }
        else result=1;
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
        
        for(int i=0; i<(length/10); i++){
            StdDraw.filledSquare(placeHolder.getXCoord(), placeHolder.getYCoord(), radius);
            placeHolder = placeHolder.getNext();
            if(xCoordinate==placeHolder.getXCoord() && yCoordinate==placeHolder.getYCoord()) result=1;
        }
        
      }
      
      else if(direction==2){
        drawSquare(foodXCoord, foodYCoord);
        if((nodeListFront.getXCoord()-4)>=1){ 
          
          
          Node temp = new Node();
          temp.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord());
          temp.setNext(nodeListFront.getNext());
          nodeListFront.setCoords(nodeListFront.getXCoord()-4, nodeListFront.getYCoord());
          nodeListFront.setNext(temp);
          
          xCoordinate = nodeListFront.getXCoord();
          yCoordinate = nodeListFront.getYCoord();
          
         //  System.out.println("XCoord: "+xCoordinate);
         // System.out.println("YCoord: "+yCoordinate);
          
          if(xCoordinate>99 || xCoordinate<1 || yCoordinate>99 || yCoordinate<1){
            result = 1;      
          }
          
          if(xCoordinate==foodXCoord && yCoordinate==foodYCoord){
            newFood();
            addSquare(nodeListBack.getXCoord(), nodeListBack.getYCoord());
          }
        }
        else result=1;
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
        
        for(int i=0; i<(length/10); i++){
            StdDraw.filledSquare(placeHolder.getXCoord(), placeHolder.getYCoord(), radius);
            placeHolder = placeHolder.getNext();
            if(xCoordinate==placeHolder.getXCoord() && yCoordinate==placeHolder.getYCoord()) result=1;
        }
        
      }
      
      else if(direction==3){
        drawSquare(foodXCoord, foodYCoord);
        if((nodeListFront.getYCoord()-4)>=1){ 
          
          
          Node temp = new Node();
          temp.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord());
          temp.setNext(nodeListFront.getNext());
          nodeListFront.setCoords(nodeListFront.getXCoord(), nodeListFront.getYCoord()-4);
          nodeListFront.setNext(temp);
          
          xCoordinate = nodeListFront.getXCoord();
          yCoordinate = nodeListFront.getYCoord();
         
          
          if(xCoordinate>99 || xCoordinate<1 || yCoordinate>99 || yCoordinate<1){
            result = 1;      
          }
          
          if(xCoordinate==foodXCoord && yCoordinate==foodYCoord){
            newFood();
            addSquare(nodeListBack.getXCoord(), nodeListBack.getYCoord());
          }
        }
        else result=1;
        
        Node placeHolder = new Node();
        placeHolder = nodeListFront;
        
        for(int i=0; i<(length/10); i++){
            StdDraw.filledSquare(placeHolder.getXCoord(), placeHolder.getYCoord(), radius);
            placeHolder = placeHolder.getNext();
            if(xCoordinate==placeHolder.getXCoord() && yCoordinate==placeHolder.getYCoord()) result=1;
        }
        
      }
    return result;
    }
  
}