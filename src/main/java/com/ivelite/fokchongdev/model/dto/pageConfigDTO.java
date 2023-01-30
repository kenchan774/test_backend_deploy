package com.ivelite.fokchongdev.model.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class pageConfigDTO {
    private Integer id;
    private String pageBlock;
    private String pageContent;
    private Integer versionId;
    private Timestamp creationTime;
}
