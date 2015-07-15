import java.util.Random;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;

public class Game{

    public static void drawBoard(int score){
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.text(5,108,"Snake");
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(93,108,"Score: "+score);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0, 0, 100, 0);
        StdDraw.line(100, 0, 100, 100);
        StdDraw.line(100, 100, 0, 100);
        StdDraw.line(0, 100, 0, 0);
    }
    
    

    public static void main(String [] args){
        Snake snake = new Snake();
      
        
        
        StdDraw.setXscale(-5,105);
        StdDraw.setYscale(-5,110);
        drawBoard(0);
        snake.drawFirstSquares();
        int directionFlag = 0; 
        int directionPlaceHolder=0;
        int lost=0;
        int length=0;
        int count=0;
        
        boolean paused = false;
        
        boolean gameOn=true;

        while(gameOn==true){
          
          if(StdDraw.isKeyPressed(KeyEvent.VK_UP ) && paused==false && directionFlag != 3) { paused=false; directionFlag=1;}
          if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT ) && directionFlag!=0 && paused==false && directionFlag != 4) { paused=false; directionFlag=2;}
          if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN ) && paused==false && directionFlag != 1) { paused=false; directionFlag=3;}
          if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT ) && paused==false && directionFlag != 2) { paused=false; directionFlag=4;}
         /* if(StdDraw.isKeyPressed(KeyEvent.VK_P)) { 
            System.out.println("pausestuff");
            //if(paused==false){ 
              System.out.println("HERE");
                paused=true;
               // break;
            //} else{
             // System.out.println("HERETWOOOOOOO");
               // paused=false;  
            }*/
          
          //System.out.println("p value: "+paused);
          directionPlaceHolder = directionFlag;
          if(paused==false){
          if(directionFlag!=0){   StdDraw.clear();}
          drawBoard(snake.getLength()-50);
          lost = snake.moveSnake(directionFlag);
             // System.out.println("lost value: "+lost);
          StdDraw.show(90);
          if(lost==1){
             System.out.println("lost value: "+lost);
             StdDraw.setPenColor(StdDraw.BLACK);
             StdDraw.text(50,50,"Game Over. You Lose!"); 
             StdDraw.show();
             gameOn=false;
             return;
          }
          count++;
          }
          
          /*if(directionFlag==1){
            while(directionFlag==1){
              StdDraw.clear();
              drawBoard(snake.getLength()-50);
              lost = snake.moveSnake("up");
              if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT )) directionFlag=4;
              if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT )) directionFlag=2;
              //else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN )) directionFlag=3;
              StdDraw.show(100);
              if(lost==1){System.out.println("111"); gameOn=false; return;}
            }
          }
          if(directionFlag==2){
            while(directionFlag==2){
              StdDraw.clear();
              drawBoard(snake.getLength()-50);
              lost = snake.moveSnake("left");
             // if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT )) directionFlag=4;
              if(StdDraw.isKeyPressed(KeyEvent.VK_UP )) directionFlag=1;
              if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN )) directionFlag=3;
              StdDraw.show(100);
              if(lost==1){System.out.println("111"); gameOn=false; return;}
            }
          }
          if(directionFlag==3){
            while(directionFlag==3){
              StdDraw.clear();
              drawBoard(snake.getLength()-50);
              lost = snake.moveSnake("down");
              if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT )) directionFlag=4;
             // else if(StdDraw.isKeyPressed(KeyEvent.VK_UP )) directionFlag=1;
              if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT )) directionFlag=2;
              StdDraw.show(100);
              if(lost==1){System.out.println("111"); gameOn=false; return;}
            }
          }
          if(directionFlag==4){
            while(directionFlag==4){
              StdDraw.clear();
              drawBoard(snake.getLength()-50);
              lost = snake.moveSnake("right");
              if(StdDraw.isKeyPressed(KeyEvent.VK_UP )) directionFlag=1;
             // else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT )) directionFlag=2;
              if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN )) directionFlag=3;
              StdDraw.show(100);
              if(lost==1){System.out.println("111"); gameOn=false; return;}
            }
          }*/
        
        // StdDraw.show(100); 
        }
        System.out.println("end");
    } 
}