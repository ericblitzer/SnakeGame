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

        while(true){
          
          if(StdDraw.isKeyPressed(KeyEvent.VK_UP )) directionFlag=1;
          if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT )) directionFlag=2;
          if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN )) directionFlag=3;
          if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT )) directionFlag=4;
          
          if(directionFlag==1){
            while(directionFlag==1){
              StdDraw.clear();
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