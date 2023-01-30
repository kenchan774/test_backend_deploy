package com.ivelite.fokchongdev.mapper;

import com.ivelite.fokchongdev.model.dto.ProjectDTO;
import com.ivelite.fokchongdev.model.dto.ProjectImgDTO;
import com.ivelite.fokchongdev.model.param.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FookChongProjectMapper {
    ProjectDTO getProjectDetailById(@Param("projectId")Integer projectId);
    List<ProjectDTO> getAllProjectsWithPage(@Param("pageSize") Integer pageSize, @Param("pageNum") Integer pageNum);

    List<ProjectDTO> getAllProjects();

    List<String> getProjectImgsById(@Param("projectId") Integer projectId);

    int getTotalProjectCount();

    int insertNewProject(ProjectParam projectParam);

    int hideProjectById(Integer projectId);

    int showProjectById(Integer projectId);

    void updateProject(ProjectDTO projectDTO);

    void updateBannerImageUrls(BannerImageParam bannerImageUrls);

    void updateUserComments(UserCommentParam userCommentParam);

    List<String> getBannerImages();

    List<String> getUserComments();

    List<ProjectDTO> getFeaturedProjects();

    void addProjectImages(List<ProjectImgParam> projectImgParams);

    void updateProjectImages(List<UpdateProjectImageParam> updateProjectImageParams);

    void deleteProjectImages(List<ProjectImgParam> projectImgParams);
}
