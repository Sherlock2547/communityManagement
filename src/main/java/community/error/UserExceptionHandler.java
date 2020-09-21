package community.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Map<String,Object> handleUserNotFound(UserNotFoundException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("code",ex.getErrCode());
        map.put("message",ex.getMessage());
        return map;
    }

    @ExceptionHandler(UserDuplicatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Map<String,Object> handleUserDuplicated(UserDuplicatedException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("code",ex.getErrCode());
        map.put("message",ex.getMessage());
        return map;
    }


}
