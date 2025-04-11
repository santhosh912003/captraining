class list3 {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTaskAtEnd(101, "Math Homework", 2, "2025-04-10");
        scheduler.addTaskAtBeginning(102, "Science Project", 1, "2025-04-09");
        scheduler.addTaskAtEnd(103, "English Essay", 3, "2025-04-11");
        scheduler.addTaskAtPosition(104, "History Notes", 2, "2025-04-12", 2);

        scheduler.displayAllTasks();

        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();
        scheduler.viewCurrentTask();

        scheduler.searchByPriority(2);
        scheduler.removeTaskById(103);

        System.out.println("After Removal:");
        scheduler.displayAllTasks();
    }
}
class Task{
  int taskId;
  String taskName;
  int priority;
  String dueDate;
  Task next;
  
  public Task(int taskId, String taskName, int priority, String dueDate){
    this.taskId = taskId;
    this.taskName = taskName;
    this.priority = priority;
    this.dueDate = dueDate;
  }
  
}

class TaskScheduler{
  private Task head = null;
  private Task current = null;
  
  public void addTaskAtBeginning(int id, String name, int priority, String dueDate){
    Task newnode = new Task(id, name, priority, dueDate);
    if(head == null){
      head = newnode; 
      head.next = head;
      current  = head;
    }
    else{
      Task temp  = head;
      while (temp.next != head){
        temp = temp.next;
      }
      
      newnode.next = head;
      temp.next = newnode;
      head = newnode;
    }
  }
  
  public void addTaskAtEnd(int id, String name, int priority, String dueDate){
    Task newnode = new Task(id, name, priority, dueDate);
    
    if(head == null){
      head = newnode;
      head.next = head;
      current = head;
    }
    else{
      Task temp = head;
      while(temp.next != head){
        temp = temp.next;
      }
      temp.next = newnode;
      newnode.next = head;
    }
  }
  
  public void addTaskAtPosition(int id, String name, int priority, String dueDate, int pos){
    if(pos==0){
      addTaskAtBeginning(id, name, priority, dueDate);
      return;
    }
    
    
    Task newnode = new Task(id, name, priority, dueDate);
    Task temp = head;
    int cnt = 0;
    while (cnt<pos -1 && temp.next!= head){
      temp = temp.next;
      cnt++;
    }
    
    newnode.next = temp.next;
    temp.next = newnode;
  }
  
  
  public void removeTaskById(int id){
    if(head==null) return;
    if((head.taskId == id) && (head.next == head)){
      head = null;
      current = null;
      return;
    } 
    
    Task temp = head, prev = null;
    do{
      if(temp.taskId == id){
        if(temp == head){
          Task last = head;
          while(last.next != head){
            last = last.next;
          }
          head = head.next;
          last.next = head;
          
        }
        else{
          prev.next = temp.next;
        }
        
        if(current == temp) current = temp.next;
        return;
      }
      prev = temp;
      temp = temp.next;
      
    }
    
    while(temp!= head);
  }
  
 public void viewCurrentTask() { 
       if (current != null) {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due: " + current.dueDate);
        } else {
            System.out.println("No tasks available.");
        }
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        }
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    
    public void searchByPriority(int pri){
      if(head == null){
        System.out.println("No tasks to search");
        return;
      }
      
      Task temp = head;
      boolean found = false;
      while(temp != head){
        if(temp.priority==pri){
         System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due: " + temp.dueDate);
                found = true;
                
        }
        
        temp = temp.next;
      }
      if (!found) {
            System.out.println("No task with priority " + pri + " found.");
        }
      
    }
  

  
}