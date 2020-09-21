package community.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

@Component
@ApiModel(description = "House Info")
@Table("houses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class House { //住房信息

    @ApiModelProperty(notes = "House id")
    @Id
    private Integer id;//房间编号
    @ApiModelProperty(notes = "House address")
    private String address;//房间地址,如G3602,G代表G栋,3代表3单元，602代表房间号
    @ApiModelProperty(notes = "House area")
    private Float area;//房间面积
    @ApiModelProperty(notes = "House struct")
    private String struct;//房间类型,如豪华型，经济型等等
    @ApiModelProperty(notes = "House status")
    private String status;//房间状态,如是否出售等等

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getStruct() {
        return struct;
    }

    public void setStruct(String struct) {
        this.struct = struct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }*/
}
