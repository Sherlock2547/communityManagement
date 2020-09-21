package community.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;

@ApiModel(description = "User Info")
@Table("users")
public class User {


    @ApiModelProperty(notes = "User id")
    @Id
    private Integer id;
    @ApiModelProperty(notes = "User name")
    private String name;
    @Pattern(regexp="^[a-zA-Z]\\w{5,17}$",message="密码以字母开头，长度在6~18之间，只能包含字符、数字和下划线")
    @ApiModelProperty(notes = "User password")
    private String pwd;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void run() {
        System.out.println("[ ID:"+this.id+", NAME:"+this.name+", PWD:"+this.pwd+" ]");
    }
}
