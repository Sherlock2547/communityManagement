package community.error;

/**
 * Created by 17206133--周文林
 * Date: 2020/5/5 17:09 下午
 **/
public class CommunityException extends Exception {

    private CommunityErrorMessage errorMessage;

    public CommunityException(CommunityErrorMessage errorMessage){
        this.errorMessage = errorMessage;
    }

    public CommunityErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public String getMessage(){
        return errorMessage.getMessage();
    }

}
