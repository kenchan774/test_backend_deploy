package com.ivelite.fokchongdev.model.dto;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Integer id;
    private Integer projectId;
    private String projectDescription;
    private String projectBuildingType;
    private String projectCoverImg;
    private String projectDistrict;
    private String projectArea;
    private String projectAddress;
    private String projectBuildingStyle;
    private String projectHouseSize;
    private String projectHouseName;
    private String projectBuildTime;    //when is this project built
    private Date creationTime;    //the project creation time in the web
    private Integer hasFeatured;  //has been set up as feature project; 0 = no, 1 = yes
    private Integer isShow; // 1 = show; 0 = hide;
}
