package community.service;

import community.entity.*;

import java.util.Collection;

public interface CommunityService {

    //系统用户
    public Collection<User> getAllUsers();
    Collection<User> findUserByName(String name);
    public User addUser(User user);
    public void deleteUserByName(String name);


    //患者信息
    public Collection<Patient> getAllPatients();
    Collection<Patient> findPatientByName(String name);
    public Patient addPatient(Patient patient);
    public void deletePatientByName(String name);

    //科室信息
    public Collection<Department> getAllDepartments();
    Collection<Department> findDepartmentByName(String name);
    public Department addDepartment(Department department);
    public void deleteDepartmentByName(String name);



    //房产信息
    public Collection<House> getAllHouses();
    Collection<House> findHouseByAddress(String address);
    public House addHouse(House house);
    public void deleteHouseByAddress(String address);


    //住户信息
    public Collection<Resident> getAllResidents();
    Collection<Resident> findResidentByName(String name);
    public Resident addResident(Resident resident);
    public void deleteResidentByName(String name);




}
