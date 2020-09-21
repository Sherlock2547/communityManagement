package community.rest;

import community.entity.User;
import community.error.CommunityErrorMessage;
import community.error.CommunityException;
import community.repository.UserRepository;
import community.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by 17206133--周文林
 * Date: 2020/5/4 22:20 下午
 **/
@RestController
@RequestMapping("api/v1/users")
public class UserRestController {

    @Autowired
    CommunityService cs;

    @Autowired
    UserRepository ur;


    //添加系统用户
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user, BindingResult result)throws CommunityException{
        if (result.hasErrors()) {
            throw new CommunityException(new CommunityErrorMessage(101, result.getFieldError("pwd").getDefaultMessage()));
        }
        cs.addUser(user);
        return new ResponseEntity<User>(HttpStatus.CREATED);
    }


    //删除系统用户
    @RequestMapping(value = "/{name}",method = RequestMethod.DELETE,produces = "application/json")
    public void deleteUser(@PathVariable("name") String name){
        cs.deleteUserByName(name);
    }

    //查找全部和按用户名查询
    @RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Collection<User>> users(String name){
        Collection<User> users;
        if (name == null){
            users = cs.getAllUsers();
        }else {
            users = cs.findUserByName(name);
        }
        if(users == null || users.isEmpty()){
            return new ResponseEntity<>(users,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(users,HttpStatus.OK);
        }
    }



}
