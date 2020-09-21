package community.service;

import community.entity.*;
import community.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by 17206133--周文林
 * Date: 2020/5/5 17:25 下午
 **/
@Service
public class CommunityServiceImpl implements CommunityService {
    @Resource
    private UserRepository ur;
    private HouseRepository hr;
    private ResidentRepository rr;
    private PatientRepository pr;
    private DepartmentRepository dr;

    @Autowired
    public CommunityServiceImpl(UserRepository ur,HouseRepository hr,ResidentRepository rr,PatientRepository pr,DepartmentRepository dr){
        this.ur = ur;
        this.hr = hr;
        this.rr = rr;
        this.pr = pr;
        this.dr = dr;
    }

    //人员信息
    @Override
    public Collection<User> getAllUsers(){
        return (Collection<User>) ur.findAll();
    }

    @Override
    public Collection<User> findUserByName(String name) {
        return ur.findByName("%"+name+"%");
    }

    @Override
    public User addUser(User user) {
        return ur.save(user);
    }

    @Override
    public void deleteUserByName(String name) {
        ur.deleteByName(name);
    }



    //患者信息
    @Override
    public Collection<Patient> getAllPatients() {
        return (Collection<Patient>) pr.findAll();
    }

    @Override
    public Collection<Patient> findPatientByName(String name) {
        return pr.findByName("%"+name+"%");
    }

    @Override
    public Patient addPatient(Patient patient) {
        return pr.save(patient);
    }

    @Override
    public void deletePatientByName(String name) {
        pr.deleteByName(name);
    }

    //科室信息
    @Override
    public Collection<Department> getAllDepartments() {
        return (Collection<Department>) dr.findAll();
    }

    @Override
    public Collection<Department> findDepartmentByName(String name) {
        return dr.findByName("%"+name+"%");
    }

    @Override
    public Department addDepartment(Department department) {
        return dr.save(department);
    }

    @Override
    public void deleteDepartmentByName(String name) {
        dr.deleteByName(name);
    }


    @Override
    public Collection<House> getAllHouses() {
        return (Collection<House>) hr.findAll();
    }

    @Override
    public Collection<House> findHouseByAddress(String address) {
        return hr.findByAddress("%"+address+"%");
    }

    @Override
    public House addHouse(House house) {
        return hr.save(house);
    }

    @Override
    public void deleteHouseByAddress(String address) {
        hr.deleteByAddress(address);
    }




    @Override
    public Collection<Resident> getAllResidents() {
        return (Collection<Resident>) rr.findAll();
    }

    @Override
    public Collection<Resident> findResidentByName(String name) {
        return rr.findByName("%"+name+"%");
    }

    @Override
    public Resident addResident(Resident resident) {
        return rr.save(resident);
    }

    @Override
    public void deleteResidentByName(String name) {
        rr.deleteByName(name);
    }


}
