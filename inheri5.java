class inheri5 {
    public static void main(String[] args){
        thermostat obj1=new thermostat(1,"shipped",30);
        obj1.displaystatus();
    }
}
class device{
    int deviceid;
    String status;
    public device(int deviceid,String status){
        this.deviceid=deviceid;
        this.status=status;
    }
    public void displaystatus(){
        System.out.println("deviceid"+this.deviceid+"status"+this.status);
    }
}
class thermostat extends device{
    int tempset;
    public thermostat(int deviceid,String status,int tempset){
        super(deviceid,status);
        this.tempset=tempset;
    }
    public void displaystatus(){
        System.out.println("deviceid:"+deviceid+" status:"+status+" tempset:"+this.tempset);
    }
}

