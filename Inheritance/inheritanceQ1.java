class inheritanceQ1{
  public static void main(String [] args){
    Animal obj1=new Animal("TONY",22);
    Dog obj2= new Dog("Leo",3);
    Cat obj3=new Cat("Tom",4);
    Bird obj4= new Bird("HOO",7);
    obj1.makesound();
    obj2.makesound();
    obj3.makesound();
    obj4.makesound();



  }
}
class Animal{
  String name;
  int age;
  public Animal(String name,int age){
    this.name=name;
    this.age=age;
  }
  public void makesound(){
    System.out.println("The animal Moves");
  }
}
class Dog extends Animal{
  
  public Dog(String name,int age){
    super(name, age);
  }
  public void makesound(){
    System.out.println("Dog barks");
  }
}
class Cat extends Animal{
  
  public Cat(String name,int age){
    super(name,age);
  }
  public void makesound(){
    System.out.println("Cat meow");
  }
}
  class Bird extends Animal{
    
    public Bird(String name,int age){
      super(name, age);
    }
    public void makesound(){
      System.out.println("Bird hums");
    }
  }