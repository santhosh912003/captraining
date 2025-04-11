
public class list4 {
    public static void main(String[] args) {
        MovieList ml = new MovieList();

        ml.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        ml.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.6);
        ml.addAtPosition("The Prestige", "Christopher Nolan", 2006, 8.5, 1);
        ml.addAtEnd("Dunkirk", "Christopher Nolan", 2017, 7.9);

        System.out.println("All Movies (Forward):");
        ml.displayForward();

        System.out.println("\nAll Movies (Reverse):");
        ml.displayReverse();

        System.out.println("\nSearch by Director (Christopher Nolan):");
        ml.searchByDirector("Christopher Nolan");

        System.out.println("\nSearch by Rating (8.8):");
        ml.searchByRating(8.8);

        System.out.println("\nUpdate Rating of Inception to 9.0");
        ml.updateRating("Inception", 9.0);
        ml.displayForward();

        System.out.println("\nRemove 'Dunkirk'");
        ml.removeByTitle("Dunkirk");
        ml.displayForward();
    }
}

class Movie {
  String title;
  String director;
  int year;
  double rating;
  Movie next;
  Movie prev;
  
  
  
  public Movie(String title, String director, int year, double rating){
    this.title = title;
    this.director = director;
    this.year = year;
    this.rating = rating;
    this.next = null;
    this.prev = null;
    
  }
}

class MovieList{
  private Movie  head;
  private Movie tail;
  
  
  public void addAtBeginning(String title, String director, int year, double rating){
    Movie newMovie = new Movie(title, director,year, rating);
    if(head==null){
      head = tail = newMovie;
    }
    else{
      newMovie.next = head;
      head.prev = newMovie;
      head = newMovie;
    }
  }
  
  
  public void addAtEnd(String title, String director, int year, double rating){
    Movie newMovie = new Movie(title, director, year, rating);
    if(head == null){
      head = tail = newMovie;
      
    }
    else{
      tail.next = newMovie;
      newMovie.prev = tail;
      tail = newMovie;
    }
  }
  
  
  public void addAtPosition(String title, String director, int year, double rating, int pos){
    if(pos<=0){
      addAtBeginning(title, director, year, rating);
      return ;
    }
    
    Movie newnode = new Movie(title, director, year,rating);
    
    Movie temp = head;
    int index = 0;
    while(temp != null && index < pos -1){
      temp = temp.next;
      index++;
    }
    
    if(temp == null || temp.next == null){
      addAtEnd(title, director, year, rating);
    }
    else{
      newnode.next = temp.next;
      newnode.prev = temp;
      temp.next.prev = newnode;
      temp.next = newnode;
    }
  }
  
  public void removeByTitle(String title){
    Movie temp = head;
    while(temp != null){
      if(temp.title.equalsIgnoreCase(title)){
        if(temp == head & temp == tail){
          head = tail = null;
        }
        else if(temp == head){
          head = head.next;
          head.prev = null;
        }
        else if(temp == tail){
          tail  = tail.prev;
          tail.next = null;
        }
        else{
          temp.prev.next = temp.next;
          temp.next.prev = temp.prev;
        }
        return;
      }
      temp = temp.next;
    }
  }
  
    public void searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " - " + temp.director + " - " + temp.year + " - " + temp.rating);
            }
            temp = temp.next;
        }
    }
  
  public void searchByDirector(String director){
    Movie temp = head;
    while(temp != null){
      if(temp.director.equals(director)){
        System.out.println(temp.title+" - "+temp.director+" - "+temp.year+" - "+temp.rating);
      }
      
      temp = temp.next;
    }
  }
  
  public void displayForward(){
    Movie temp = head;
    
    while(temp != null){
      System.out.println(temp.title+" - "+temp.director+" - "+ temp.year+" - "+temp.rating);
      temp = temp.next;
    }
    
  }
  
  public void displayReverse(){
    Movie temp = tail;
    while(temp != null){
      System.out.println(temp.title+" - "+temp.director+" - "+ temp.year+" - "+ temp.rating);
      temp = temp.prev;
    }
  }
  
  public void updateRating(String title, double newRating){
    Movie temp = head;
    while(temp != null){
        if(temp.title.equalsIgnoreCase(title)){
          temp.rating = newRating;
          return;
        }
      temp = temp.next;
    }
  }
}