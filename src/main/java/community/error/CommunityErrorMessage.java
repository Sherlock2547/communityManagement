package community.error;

/**
 * Created by 17206133--周文林
 * Date: 2020/5/5 17:10 下午
 **/
public class CommunityErrorMessage {

    private int code;
    private String message;

    public CommunityErrorMessage(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
