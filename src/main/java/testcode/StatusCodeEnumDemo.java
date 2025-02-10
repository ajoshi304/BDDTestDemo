package testcode;

public class StatusCodeEnumDemo {


    public static void main(String[] args) {
        System.out.println("Code is " + StatusCode.valueOf("REDIRECT").getStatusCode());
    }
}
