package com.ivelite.fokchongdev.model.vo;

import java.sql.Date;
import java.sql.Timestamp;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectVO {

    @JSONField
    private Integer id;
    @JSONField
    private Integer projectId;
    @JSONField
    private String projectDesc;
    @JSONField
    private String projectBuildingType;
    @JSONField
    private String projectCoverImg;
    @JSONField
    private String projectDistrict;
    @JSONField
    private String projectArea;
    @JSONField
    private String projectAddress;
    @JSONField
    private String projectBuildingStyle;
    @JSONField
    private String projectHouseSize;
    @JSONField
    private String projectHouseName;
    @JSONField
    private String projectBuildTime;    //when is this project built
    @JSONField
    private Date creationTime;    //the project creation time in the web
    @JSONField
    private Integer hasFeatured;  //has been set up as feature project; 0 = no, 1 = yes
    @JSONField
    private Integer isShow;  //1 = show; 0 = hide
}
