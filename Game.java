
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
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(50,80,"Press Right, Up, or Down Arrow to Begin."); 
        StdDraw.show();
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

          directionPlaceHolder = directionFlag;
          if(paused==false){
          if(directionFlag!=0){   StdDraw.clear();}
          drawBoard(snake.getLength()-50);
          lost = snake.moveSnake(directionFlag);

          StdDraw.show(60);
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
        }
        System.out.println("end");
    } 
}