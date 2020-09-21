package community.rest;

import community.entity.Patient;
import community.entity.User;
import community.error.CommunityErrorMessage;
import community.error.CommunityException;
import community.repository.PatientRepository;
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
 * Date: 2020/6/28 21:42 下午
 **/
@RestController
@RequestMapping("api/v1/patients")
public class PatientRestController {
    @Autowired
    CommunityService cs;
    @Autowired
    PatientRepository pr;

    //添加患者
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient, BindingResult result)throws CommunityException {
        if (result.hasErrors()) {
            throw new CommunityException(new CommunityErrorMessage(101, result.getFieldError("pwd").getDefaultMessage()));
        }
        cs.addPatient(patient);
        return new ResponseEntity<Patient>(HttpStatus.CREATED);
    }


    //删除
    @RequestMapping(value = "/{name}",method = RequestMethod.DELETE,produces = "application/json")
    public void deleteUser(@PathVariable("name") String name){
        cs.deletePatientByName(name);
    }

    //查找全部和按用户名查询
    @RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Collection<Patient>> patients(String name){
        Collection<Patient> patients;
        if (name == null){
            patients = cs.getAllPatients();
        }else {
            patients = cs.findPatientByName(name);
        }
        if(patients == null || patients.isEmpty()){
            return new ResponseEntity<>(patients,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(patients,HttpStatus.OK);
        }
    }


}
