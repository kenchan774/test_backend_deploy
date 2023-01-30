package com.ivelite.fokchongdev.service;

import com.ivelite.fokchongdev.model.dto.ProjectDTO;
import com.ivelite.fokchongdev.model.param.*;

import java.util.List;

public interface CMSService {
    void addNewProject(ProjectParam projectParam);

    void hideProjectById(HideProjectParam hideProjectParam);

    void showProjectById(HideProjectParam hideProjectParam);

    void updateProject(ProjectDTO projectDTO);

    void updateBannerImages(BannerImageParam bannerImageUrls);

    void updateUserComments(UserCommentParam userCommentParam);

    void addProjectImages(List<ProjectImgParam> projectImgParam);

    void updateProjectImages(List<UpdateProjectImageParam> updateProjectImageParams);

    void deleteProjectImages(List<ProjectImgParam> projectImgParams);
}
