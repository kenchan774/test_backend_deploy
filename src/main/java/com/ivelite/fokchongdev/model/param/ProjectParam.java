package com.ivelite.fokchongdev.model.param;

import java.sql.Timestamp;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectParam {

    private String projectDesc;
    private String projectBuildingType;
    private String projectCoverImg;
    private String projectDistrict;
    private String projectArea;
    private String projectAddress;
    private String projectBuildingStyle;
    private Double projectHouseSize;
    private String projectHouseName;
    private String projectBuildTime;    //when is this project built
    private Integer hasFeatured;  //has been set up as feature project; 0 = no, 1 = yes
    private Integer isShow; //1 show ; 0 hide
}
