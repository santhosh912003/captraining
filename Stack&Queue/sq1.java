import java.util.*;

class sq1{
  public static void main(String[] args){
    Queue q = new Queue();
    for(int i=0;i<10;i++){
      q.add(i);
    }
    
    q.remove();
    q.remove();
    q.add(100);
    
    System.out.println("remaining elements in the queue");
    while(!q.isEmpty()){
      q.remove();
    }
  }
}



class Queue{
  private Stack<Integer> st1 = new Stack<>();
  private Stack<Integer> st2 = new Stack<>();
  
  
  void add(int val){
    st1.push(val);
  }
  
  void remove(){
    
    if(isEmpty()){
      System.out.println("Queue is Empty");
      return;
    }
    if(st2.isEmpty()){
      while(!st1.isEmpty()){
        st2.push(st1.pop());
      }
    }
    
    System.out.println(st2.pop());
  }
  
  boolean isEmpty(){
    return st1.isEmpty() && st2.isEmpty();
    
  }
}