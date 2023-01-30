package com.ivelite.fokchongdev.model.param;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BannerImageParam {
    private String banner_img_1;
    private String banner_img_2;
    private String banner_img_3;
    private String banner_img_4;
}
