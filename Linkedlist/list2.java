import java.util.*;


public class list2 {
    public static void main(String[] args) {
        InventoryList inventory = new InventoryList();
        inventory.addItemAtBeginning("Pen", 1, 100, 5.0);
        inventory.addItemAtEnd("Notebook", 2, 50, 20.0);
        inventory.addItemAtPosition("Eraser", 3, 75, 2.0, 1);
        inventory.displayInventory();
        System.out.println("Total Value: " + inventory.totalInventoryValue());
        inventory.updateQuantityById(1, 120);
        inventory.searchById(2);
        inventory.searchByName("Eraser");
        inventory.removeItemById(3);
        inventory.sortByName(true);
        inventory.displayInventory();
        inventory.sortByPrice(false);
        inventory.displayInventory();
  }
}

class InventoryItem{
  String itemName;
  int itemId;
  int quantity;
  double price;
  InventoryItem next;
  
  public InventoryItem(String itemName,int itemId, int quantity, double price){
    this.itemName = itemName;
    this.itemId = itemId;
    this.quantity = quantity;
    this.price = price;
    this.next= null;
  }
}


class InventoryList{
  private InventoryItem head;
  
  public void addItemAtBeginning(String itemName,int itemId, int quantity, double price){
    InventoryItem newItem = new InventoryItem(itemName,itemId,quantity,price);
    newItem.next = head;
    head = newItem;
  }
  
  public void addItemAtEnd(String itemName, int itemId, int quantity, double price){
    InventoryItem newnode = new InventoryItem(itemName,itemId,quantity,price);
    
    if(head==null){
      head = newnode;
      return;
    }
    
    InventoryItem temp = head;
    while (temp.next!=null){
      temp = temp.next;
    }
    temp.next = newnode;
  }
  
  public void addItemAtPosition(String itemName, int itemId, int quantity, double price,int position){
    InventoryItem newnode = new InventoryItem(itemName,itemId,quantity,price);
    
    if(head==null || position == 0){
      newnode.next = head;
      head = newnode;
      return;
    }
    
    InventoryItem temp = head;
    for(int i=0;i<position -1 && temp != null;i++){
      temp = temp.next;
    }
    
    if (temp == null) return;
    newnode.next = temp.next;
    temp.next = newnode;
  }
  
  
  public void removeItemById(int itemId){
    if(head==null) return;
    
    if(head.itemId == itemId){
      head = head.next;
      return;
    }
    
    InventoryItem temp = head;
    while (temp.next!=null && temp.next.itemId != itemId){
      temp = temp.next;
    }
    
    if(temp.next != null) {
      temp.next = temp.next.next;
    }
    
  }
  
  public void updateQuantityById(int itemId, int Q){
    InventoryItem temp = head;
    while(temp != null && temp.itemId != itemId){
      temp =temp.next;
    }
    
    if(temp != null){
      temp.quantity = Q;
    }
  }
  
  public void searchById(int itemId){
    InventoryItem temp = head;
    
    while(temp!= null && temp.itemId != itemId){
      temp= temp.next;
      
    }
    
    if(temp != null){
      System.out.println(temp.itemName +" "+ temp.itemId +" "+temp.quantity+" "+temp.price);
      return;
    }
    
  }
  
    public void searchByName(String itemName) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println(temp.itemName + " " + temp.itemId + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }
    
    public double totalInventoryValue(){
      double total = 0;
      InventoryItem temp = head;
      while(temp != null){
        total += temp.price * temp.quantity;
        temp = temp.next;
      }
      
      return total;
    }
    
    public void sortByName(boolean acs){
      head = mergeSortByName(head,acs);
    }
    
    public void sortByPrice(boolean asc){
      head = mergeSortByPrice(head,asc);
    }
    
    
    private InventoryItem mergeSortByName(InventoryItem head, boolean asc){
      if(head == null || head.next == null) return head;
      
      InventoryItem mid = getMiddle(head);
      InventoryItem nextMid = mid.next;
      
      mid.next = null;
      InventoryItem left = mergeSortByName(head,asc);
      InventoryItem right = mergeSortByName(nextMid,asc);
      
      return mergeByName(left,right,asc);
    }
    
    private InventoryItem mergeByName(InventoryItem a, InventoryItem b,boolean asc){
      if(a==null) return b;
      if(b==null) return a;
      if(asc &&(a.itemName.compareToIgnoreCase(b.itemName)<=0) || (!asc && a.itemName.compareToIgnoreCase(b.itemName) > 0)){
        a.next = mergeByName(a.next, b, asc);
        return a;
      }
      else{
        b.next = mergeByName(a,b.next,asc);
        return b;
      }
    }
    
    private InventoryItem mergeSortByPrice(InventoryItem head, boolean ascending) {
        if (head == null || head.next == null) return head;
        InventoryItem mid = getMiddle(head);
        InventoryItem nextMid = mid.next;
        mid.next = null;
        InventoryItem left = mergeSortByPrice(head, ascending);
        InventoryItem right = mergeSortByPrice(nextMid, ascending);
        return mergeByPrice(left, right, ascending);
    }

    private InventoryItem mergeByPrice(InventoryItem a, InventoryItem b, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;
        if ((ascending && a.price <= b.price) || (!ascending && a.price > b.price)) {
            a.next = mergeByPrice(a.next, b, ascending);
            return a;
        } else {
            b.next = mergeByPrice(a, b.next, ascending);
            return b;
        }
    }
    
    private InventoryItem getMiddle(InventoryItem head){
      if(head == null ) return head;
      InventoryItem slow = head, fast = head.next;
      while( fast != null && fast.next != null){
        slow = slow.next ;
        fast = fast.next.next;
      }
      
      return slow;
    }
    
    public void displayInventory() {
        InventoryItem temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " " + temp.itemId + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }
}