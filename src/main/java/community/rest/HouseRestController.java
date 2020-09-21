package community.rest;

import community.entity.House;
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
 * Date: 2020/5/5 15:55 下午
 **/
@RestController
@RequestMapping("api/v1/houses")
public class HouseRestController {
    @Autowired
    CommunityService cs;

    //添加房产信息
    @RequestMapping(value = "",method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity<House> addHouse(@Valid @RequestBody House house, BindingResult result)throws CommunityException {
        if (result.hasErrors()) {
            throw new CommunityException(new CommunityErrorMessage(101, result.getFieldError("pwd").getDefaultMessage()));
        }
        cs.addHouse(house);
        return new ResponseEntity<House>(HttpStatus.CREATED);
    }

    //删除房产信息
    @RequestMapping(value = "/{address}",method = RequestMethod.DELETE,produces = "application/json")
    public void deleteHouse(@PathVariable("address") String address){
        cs.deleteHouseByAddress(address);
    }


    //查找全部和按地址查询
    @RequestMapping(value = "",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<Collection<House>> houses(String address){
        Collection<House> houses;
        if (address == null){
            houses = cs.getAllHouses();
        }else {
            houses = cs.findHouseByAddress(address);
        }
        if(houses == null || houses.isEmpty()){
            return new ResponseEntity<>(houses,HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(houses,HttpStatus.OK);
        }
    }
}
