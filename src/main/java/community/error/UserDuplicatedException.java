package community.error;

public class UserDuplicatedException extends Exception{

    public int getErrCode(){
        return 409;
    }

    public String getMessage(){
        return "User's id duplicated";
    }
}
