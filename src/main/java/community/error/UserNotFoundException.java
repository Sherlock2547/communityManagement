package community.error;

public class UserNotFoundException extends Exception{

    public int getErrCode(){return 404;}

    public String getMessage(){return "User Not Found";}

}
