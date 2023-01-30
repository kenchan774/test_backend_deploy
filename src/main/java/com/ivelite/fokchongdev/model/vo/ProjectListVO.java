package com.ivelite.fokchongdev.model.vo;

import java.util.List;

import com.alibaba.fastjson2.annotation.JSONField;
import com.ivelite.fokchongdev.model.dto.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectListVO {

    @JSONField
    private List<ProjectDTO> projectList;

    @JSONField
    private Integer totalProjectCount;

}
