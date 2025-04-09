public class list1 {
    public static void main(String[] args) {
        operations ops=new operations();
        ops.add(new Student(1,"San",21,'A'));
        ops.add(new Student(1, "Rajesh", 22, 'O'));
        ops.addatBeginning(new Student(3,"Abi",23,'B'));
        ops.addatPosition(new Student(4,"Buj",22,'A'), 2);
        ops.display();
        ops.delete(3);
        ops.search(1);
        ops.update(4, 'Z');
        System.out.println("Final display:");
        ops.display();


    }
}
class Student{
    int rno;
    String name;
    int age;
    char grade;
    public Student(int rno,String name,int age,char grade){
        this.rno=rno;
        this.name=name;
        this.age=age;
        this.grade=grade;
    }
}
class Node{
    Student data;
    Node next;
    Node(Student data){
        this.data=data;
        this.next=null;
    }
}
class operations{
    Node head=null;
    public void add(Student student){
        Node newNode=new Node(student);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public void addatBeginning(Student student){
        Node newNode= new Node(student);
        newNode.next=head;
        head=newNode;
    }
    public void addatPosition(Student student, int pos){
        Node newNode= new Node(student);
        if(pos<=1||head==null){
            addatBeginning(student);
            return;
        }
        Node temp=head;
        int count=1;
        while(temp!=null&&count<pos-1){
            temp=temp.next;
            count++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void delete(int rno){
        if(head==null) return;
        if(head.data.rno==rno){
            head=head.next;
            return;
        }
        Node cur=head;
        while(cur.next!=null&cur.next.data.rno!=rno){
            cur=cur.next;
        }
        if(cur.next!=null) cur.next=cur.next.next;
    }
    public void search(int rno){
        Node temp=head;
        while(temp!=null){
            if(temp.data.rno==rno){
                System.out.println("Found"+temp.data.rno);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Not Found");
    }
    public void update(int rno,char newgrade){
        Node temp=head;
        while (temp!=null) {
            if(temp.data.rno==rno){
                temp.data.grade=newgrade;
                return;
            }
            temp=temp.next;
        }
    }
    public void display(){
        Node temp=head;
        while (temp!=null) {
            Student s=temp.data;
            System.out.println("Roll no"+s.rno+"Name"+s.name+"Age:"+s.age+"Grade"+s.grade);
            temp=temp.next;            
        }
    }
}