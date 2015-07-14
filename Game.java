import java.util.Random;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;

public class Game{

  

    public static void main(String [] args){
        Snake snake = new Snake();
      
        StdDraw.setXscale(0,100);
        StdDraw.setYscale(0,100);
        snake.drawFirstSquares();
        int directionFlag = 0;
        
       /* Random randNumGen = new Random();
        double foodXCoord = (2*randNumGen.nextDouble()*50)-1;
        double foodYCoord = (2*randNumGen.nextDouble()*50)-1;*/
        boolean done=false;
        
        

        while(true){
         /* while(done==false){
              foodXCoord = (2*randNumGen.nextDouble()*50)-1;
              foodYCoord = (2*randNumGen.nextDouble()*50)-1;
              System.out.println("one");
              done = snake.drawSquare(foodXCoord, foodYCoord);
              System.out.println("done: "+done);
              System.out.println("onetwo");
          }*/
          
         // foodXCoord = (2*randNumGen.nextDouble()*50)-1;
         // foodYCoord = (2*randNumGen.nextDouble()*50)-1;
          
          if(StdDraw.isKeyPressed(KeyEvent.VK_UP )) directionFlag=1;
          if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT )) directionFlag=2;
          if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN )) directionFlag=3;
          if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT )) directionFlag=4;
          
          if(directionFlag==1){
            while(directionFlag==1){
              StdDraw.clear();
              /*while(done==false){
                  foodXCoord = (2*randNumGen.nextDouble()*50)-1;
                  foodYCoord = (2*randNumGen.nextDouble()*50)-1;
                 // done = snake.drawSquare(foodXCoord, foodYCoord);
              }*/
              done = snake.drawSquare(snake.getFoodXCoord(), snake.getFoodYCoord());
              snake.moveSnake("up");
              if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT )) directionFlag=4;
              else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT )) directionFlag=2;
              //else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN )) directionFlag=3;
              StdDraw.show(80);
            }
          }
          else if(directionFlag==2){
            while(directionFlag==2){
              StdDraw.clear();
            /*  while(done==false){
                  foodXCoord = (2*randNumGen.nextDouble()*50)-1;
                  foodYCoord = (2*randNumGen.nextDouble()*50)-1;
                  //done = snake.drawSquare(foodXCoord, foodYCoord);
              }*/
              done = snake.drawSquare(snake.getFoodXCoord(), snake.getFoodYCoord());
              snake.moveSnake("left");
             // if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT )) directionFlag=4;
              if(StdDraw.isKeyPressed(KeyEvent.VK_UP )) directionFlag=1;
              else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN )) directionFlag=3;
              StdDraw.show(80);
            }
          }
          else if(directionFlag==3){
            while(directionFlag==3){
              StdDraw.clear();
             /* while(done==false){
                   foodXCoord = (2*randNumGen.nextDouble()*50)-1;
                   foodYCoord = (2*randNumGen.nextDouble()*50)-1;
                //  done = snake.drawSquare(foodXCoord, foodYCoord);
              }*/
              done = snake.drawSquare(snake.getFoodXCoord(), snake.getFoodYCoord());
              snake.moveSnake("down");
              if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT )) directionFlag=4;
             // else if(StdDraw.isKeyPressed(KeyEvent.VK_UP )) directionFlag=1;
              else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT )) directionFlag=2;
              StdDraw.show(80);
            }
          }
          else if(directionFlag==4){
            while(directionFlag==4){
              StdDraw.clear();
             // while(done==false){
                  //foodXCoord = (2*randNumGen.nextDouble()*50)-1;
                  //foodYCoord = (2*randNumGen.nextDouble()*50)-1;
                 // done = snake.drawSquare(foodXCoord, foodYCoord);
             // }
              
              done = snake.drawSquare(snake.getFoodXCoord(), snake.getFoodYCoord());
              snake.moveSnake("right");
              if(StdDraw.isKeyPressed(KeyEvent.VK_UP )) directionFlag=1;
             // else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT )) directionFlag=2;
              else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN )) directionFlag=3;
              StdDraw.show(80);
            }
          }
        
          
        }


    }
  
  
}