package testcode;

public enum StatusCode {

  SUCCESS(200),FAIL(400),REDIRECT(300);

    final Integer statusCode;

    StatusCode(Integer statusCode){
        this.statusCode=statusCode;
    }

    public Integer getStatusCode(){
        return statusCode;
    }
}
