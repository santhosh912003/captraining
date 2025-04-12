import java.util.*;



class list7 {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        network.addUser(1, "Alice", 22);
        network.addUser(2, "Bob", 24);
        network.addUser(3, "Charlie", 21);
        network.addUser(4, "David", 23);

        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);
        network.addFriendConnection(3, 4);

        network.displayAllUsers();
        network.displayFriends(1);
        network.findMutualFriends(1, 2);
        network.countFriends();

        network.removeFriendConnection(1, 3);
        network.displayFriends(1);

        network.searchById(2);
        network.searchByName("Charlie");
    }
}




class User{
  int userId;
  String name; 
  int age;
  List<Integer> friendIds;
  User next;
  
  public User(int userId, String name, int age){
    this.userId = userId;
    this.name = name;
    this.age = age;
    this.friendIds = new ArrayList<>();
    this.next  = null;
  }
}


class SocialNetwork{
  private User head;
  
  
  public void addUser(int userId, String name, int age){
    User newUser = new User(userId, name, age);
    
    if(head == null){
      head = newUser;
      return;
    }
    
    User temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    
    temp.next = newUser;
    
  }
  
  private User getUserById(int userId){
    User temp = head;
    while(temp != null){
      if(temp.userId == userId ) return temp;
      temp = temp.next;
    }
    
    return null;
  }
  
  public void addFriendConnection(int id1, int id2){
    User us1 = getUserById(id1);
    User us2 = getUserById(id2);
    
    if(us1 != null && us2 != null & id1 != id2){
      if(!us1.friendIds.contains(id2)) us1.friendIds.add(id2);
      if(!us2.friendIds.contains(id1)) us2.friendIds.add(id1);
    }
  }
  
  public void removeFriendConnection(int id1, int id2 ){
    User us1 = getUserById(id1);
    User us2 = getUserById(id2);
    
    if(us1!=null && us2 != null){
      us1.friendIds.remove(Integer.valueOf(id2));
      us2.friendIds.remove(Integer.valueOf(id1));
    }
  }
  
  public void displayFriends(int userId){
    User usr = getUserById(userId);
    if(usr== null) return ;
    System.out.println("Friends of "+ usr.name+":");
    for(int frdId : usr.friendIds){
      User frd = getUserById(frdId);
      if(frd!=null){
        System.out.println(frd.name+ " (Id: "+ frd.userId + ")");
      }
    }
  }
  
  public void searchById(int userId){
    User usr = getUserById(userId);
    if(usr!=null){
      System.out.println(usr.name + " (ID: " + usr.userId + "), Age: " + usr.age);
    }
  }
  
  public void searchByName(String name) {
    User temp = head;
    while (temp != null) {
      if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.name + " (ID: " + temp.userId + "), Age: " + temp.age);
            }
      temp = temp.next;
        }
  }
  
  public void findMutualFriends(int id1, int id2){
    User usr1 =getUserById(id1);
    User usr2 = getUserById(id2);
    
    if(usr1==null || usr2 == null ) return ;
    
    System.out.println("Mutual Friends: ");
    for(int fid : usr1.friendIds){
      if(usr2.friendIds.contains(fid)){
        User mutual = getUserById(fid);
        if(mutual != null){
          System.out.println(mutual.name+" (Id: "+ mutual.userId+")");
        }
      }
    }
  }
  
  public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s)");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " (ID: " + temp.userId + "), Age: " + temp.age);
            temp = temp.next;
        }
    }
    
    
  
}