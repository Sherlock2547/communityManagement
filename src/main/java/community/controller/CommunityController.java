package community.controller;

import community.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CommunityController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    //系统用户
    @RequestMapping("/users")
    public String users(){
        return "users/userList";
    }

    @RequestMapping("/users/add")
    public String addUser(){
        return "users/userAdd";
    }

    @RequestMapping("/users/update")
    public String updateUser(){
        return "users/userUpdate";
    }

    //患者信息
    @RequestMapping("/patients")
    public String patients(){
        return "patients/patientList";
    }

    @RequestMapping("/patients/add")
    public String addPatient(){
        return "patients/patientAdd";
    }

    @RequestMapping("/patients/update")
    public String updatePatient(){
        return "patients/patientUpdate";
    }

    //科室信息
    @RequestMapping("/departments")
    public String departments(){
        return "departments/departmentList";
    }

    @RequestMapping("/departments/add")
    public String addDepartment(){
        return "departments/departmentAdd";
    }

    @RequestMapping("/departments/update")
    public String updateDepartment(){
        return "departments/departmentUpdate";
    }


    //房产信息
    @RequestMapping("/houses")
    public String houses(){
        return "houses/houseList";
    }

    @RequestMapping("/houses/add")
    public String addHouse(){
        return "houses/houseAdd";
    }

    @RequestMapping("/houses/update")
    public String updateHouse(){
        return "houses/houseUpdate";
    }

    //住户信息
    @RequestMapping("/residents")
    public String residents(){
        return "residents/residentList";
    }

    @RequestMapping("/residents/add")
    public String addResident(){
        return "residents/residentAdd";
    }

    @RequestMapping("/residents/update")
    public String updateResident(){
        return "residents/residentUpdate";
    }
}
