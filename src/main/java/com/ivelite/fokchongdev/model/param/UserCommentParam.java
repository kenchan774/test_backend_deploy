package com.ivelite.fokchongdev.model.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCommentParam {
    private String user_comment_1;
    private String user_comment_2;
    private String user_comment_3;
    private String user_comment_4;

}
