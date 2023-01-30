package com.ivelite.fokchongdev.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectImgDTO {
    private Integer id;
    private Integer projectId;
    private List<String> projectImgUrls;
}
