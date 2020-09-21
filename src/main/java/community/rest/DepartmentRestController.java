package community.rest;

import community.entity.Department;
import community.error.CommunityErrorMessage;
import community.error.CommunityException;
import community.repository.DepartmentRepository;
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
 * Date: 2020/6/28 22:15 下午
 **/
@RestController
@RequestMapping("api/v1/departments")
public class DepartmentRestController {
    @Autowired
    CommunityService cs;

    @Autowired
    DepartmentRepository dr;


    //添加
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department user, BindingResult result)throws CommunityException {
        if (result.hasErrors()) {
            throw new CommunityException(new CommunityErrorMessage(101, result.getFieldError("pwd").getDefaultMessage()));
        }
        cs.addDepartment(user);
        return new ResponseEntity<Department>(HttpStatus.CREATED);
    }


    //删除
    @RequestMapping(value = "/{name}",method = RequestMethod.DELETE,produces = "application/json")
    public void deleteDepartment(@PathVariable("name") String name){
        cs.deleteDepartmentByName(name);
    }

    //查找全部和按用户名查询
    @RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Collection<Department>> departments(String name){
        Collection<Department> departments;
        if (name == null){
            departments = cs.getAllDepartments();
        }else {
            departments = cs.findDepartmentByName(name);
        }
        if(departments == null || departments.isEmpty()){
            return new ResponseEntity<>(departments,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(departments,HttpStatus.OK);
        }
    }


}
