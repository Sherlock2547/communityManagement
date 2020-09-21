package community.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Component
@ApiModel(description = "Resident Info")
@Table("residents")
public class Resident { //小区住户信息

    @ApiModelProperty(notes = "Resident id")
    @Id
    private Integer id;//住户编号
    @ApiModelProperty(notes = "Resident name")
    private String name;//姓名
    @ApiModelProperty(notes = "Resident age")
    private Integer age;//年龄
    @ApiModelProperty(notes = "Resident gender")
    private String gender;//性别
    @ApiModelProperty(notes = "Resident address")
    private String house_address;//物业地址
    @ApiModelProperty(notes = "Resident identification number")
    private Number number;//身份证号码
    @ApiModelProperty(notes = "Resident phone number")
    //@Pattern(regexp="^\\d{11}$",message="请输入11位电话号码")
    private Number phone;//电话号
    @ApiModelProperty(notes = "Resident check in time")
    private Date start;//入住时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Number getPhone() {
        return phone;
    }

    public void setPhone(Number phone) {
        this.phone = phone;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
