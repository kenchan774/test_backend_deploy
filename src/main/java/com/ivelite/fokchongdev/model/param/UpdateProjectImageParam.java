package com.ivelite.fokchongdev.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectImageParam {
    private Integer projectId;
    private String existingUrl;
    private String newUrl;
}
