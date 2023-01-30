package com.ivelite.fokchongdev.model.vo;

import java.util.List;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectImgVO {
    @JSONField
    private Integer projectId;
    @JSONField
    private List<String> projectImgUrls;
}
