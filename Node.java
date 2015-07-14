public class Node{

    private double xCoord;
    private double yCoord;
    private Node next;
    
    public Node(){
        next = null; 
    }
    
    public double getXCoord(){
        return xCoord;
    }
    
    public double getYCoord(){
        return yCoord;
    }
    
    public void setCoords(double x, double y){
        xCoord = x;
        yCoord = y;
    }
    
    public void setNext(Node nextNode){
        next = nextNode;
    }
    
    public Node getNext(){
        return next;  
    }
    
    
  
  
  
}