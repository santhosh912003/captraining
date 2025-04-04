class inheri6 {
    public static void main(String[] args){
        shippedorder obj1=new shippedorder(1,"2024-3-24",1);
        delivered obj2=new delivered(2, "2024-3-25", 2, "2024-4-28");
        obj1.orderstatus();
        obj2.orderstatus();

    }
}
class order{
    int orderid;
    String orderdate;
    public order(int orderid,String orderdate){
        this.orderid=orderid;
        this.orderdate=orderdate;
    }
    public void orderstatus(){
        System.out.println("orderid"+this.orderid+"orderdate"+this.orderdate);
    }
}
class shippedorder extends order{
    int trackno;
    public shippedorder(int orderid,String orderdate,int trackno){
        super(orderid,orderdate);
        this.trackno=trackno;
    }
    public void orderstatus(){
        System.out.println("orderid:"+orderid+" orderdate:"+orderdate+" Track no:"+this.trackno);
    }
}
class delivered extends shippedorder{
    String deliverydate;
    public delivered(int orderid,String orderdate,int trackno,String deliverydate){
        super(orderid,orderdate,trackno);
        this.deliverydate=deliverydate;
    }
    public void orderstatus(){
        System.out.println("orderid:"+orderid+" orderdate:"+orderdate+" Track no:"+trackno+" Deliverydate:"+deliverydate);
    }
}