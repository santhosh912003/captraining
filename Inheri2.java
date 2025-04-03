class Inheri2 {
    public static void main(String [] args){
        manager obj1=new manager("Santhosh",22,20000,4);
        developer obj2=new developer("Dharun",22,15000,"Java");
        intern obj3=new intern("vijayan",22,10000);
        obj1.display();
        obj2.display();
        obj3.display();

    }
}
class employee{
    String name;
    int id;
    int salary;
    public employee(String name,int id,int salary){
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
}
class manager extends employee{
    int teamsize;
    public manager(String name,int id, int salary,int teamsize){
        super(name,id,salary);
        this.teamsize=teamsize;
    }
    public void display(){
        System.out.println("Manager team size"+this.teamsize);
    }
}
class developer extends employee{
    String prolan;
    public developer(String name,int id,int salary,String prolan){
        super(name,id,salary);
        this.prolan=prolan;
    }
    public void display(){
        System.out.println("Developer programming language is"+this.prolan);
    }
}
class intern extends employee{
    public intern(String name,int id,int salary){
        super(name,id,salary);
    }
    public void display(){
        System.out.println("Doing intern");

    }
}
