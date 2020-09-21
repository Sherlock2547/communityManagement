package community.rest;

import community.entity.Resident;
import community.error.CommunityErrorMessage;
import community.error.CommunityException;
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
 * Date: 2020/5/5 16:08 下午
 **/
@RestController
@RequestMapping("api/v1/residents")
public class ResidentRestController {

    @Autowired
    CommunityService cs;

    //添加小区住户
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<Resident> addResident(@Valid @RequestBody Resident resident, BindingResult result)throws CommunityException {
        if (result.hasErrors()) {
            throw new CommunityException(new CommunityErrorMessage(101, result.getFieldError("phone").getDefaultMessage()));
        }
        cs.addResident(resident);
        return new ResponseEntity<Resident>(HttpStatus.CREATED);
    }


    //删除系统用户
    @RequestMapping(value = "/{name}",method = RequestMethod.DELETE,produces = "application/json")
    public void deleteResident(@PathVariable("name") String name){
        cs.deleteResidentByName(name);
    }


    //查找全部和按用户名查询
    @RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Collection<Resident>> residents(String name){
        Collection<Resident> residents;
        if (name == null){
            residents = cs.getAllResidents();
        }else {
            residents = cs.findResidentByName(name);
        }
        if(residents == null || residents.isEmpty()){
            return new ResponseEntity<>(residents,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(residents,HttpStatus.OK);
        }
    }
}
