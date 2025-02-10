package endpoints;

public enum Endpoints {

    GETSINGLEUSER("/users/2"),
    GETALLUSERS("/users?page=2"),
    CREATEUSER("/users");

   final   String endPoint;

    Endpoints(String endPoint){
       this.endPoint=endPoint;
    }

    public  String  getEndPoint(){
        return  endPoint;
    }

}
