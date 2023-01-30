package com.ivelite.fokchongdev.model.vo;

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
public class PageConfigVO {
    @JSONField(serialize = false)
    private Integer id;
    @JSONField
    private String pageBlock;
    @JSONField
    private String pageContent;
    @JSONField(serialize = false)
    private Integer versionId;
    @JSONField(serialize = false)
    private Timestamp creationTime;
}
