package com.ivelite.fokchongdev.service.impl;

import com.ivelite.fokchongdev.mapper.FookChongProjectMapper;
import com.ivelite.fokchongdev.model.dto.ProjectDTO;
import com.ivelite.fokchongdev.model.param.*;
import com.ivelite.fokchongdev.service.CMSService;
import com.ivelite.fokchongdev.service.FookChongProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CMSServiceImpl implements CMSService {

    private final FookChongProjectMapper fookChongProjectMapper;

    private final FookChongProjectService fookChongProjectService;

    public CMSServiceImpl(FookChongProjectMapper fookChongProjectMapper, FookChongProjectService fookChongProjectService) {
        this.fookChongProjectMapper = fookChongProjectMapper;
        this.fookChongProjectService = fookChongProjectService;
    }

    @Override
    public void addNewProject(ProjectParam projectParam) {
        try{
            this.fookChongProjectMapper.insertNewProject(projectParam);
            this.fookChongProjectService.evictProjectListCache();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void hideProjectById(HideProjectParam hideProjectParam){
        try{
            this.fookChongProjectMapper.hideProjectById(hideProjectParam.getProjectId());
            this.fookChongProjectService.evictProjectListCache();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showProjectById(HideProjectParam hideProjectParam){
        try{
            this.fookChongProjectMapper.showProjectById(hideProjectParam.getProjectId());
            this.fookChongProjectService.evictProjectListCache();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProject(ProjectDTO projectDTO) {
        try{
            this.fookChongProjectMapper.updateProject(projectDTO);
            this.fookChongProjectService.evictProjectListCache();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateBannerImages(BannerImageParam bannerImageUrls){
        try{
            this.fookChongProjectMapper.updateBannerImageUrls(bannerImageUrls);
            this.fookChongProjectService.evictBannerImgUrlsCache();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserComments(UserCommentParam userCommentParam) {
        try{
            this.fookChongProjectMapper.updateUserComments(userCommentParam);
            this.fookChongProjectService.evictUserCommentsCache();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addProjectImages(List<ProjectImgParam> projectImgParam) {
        try{
            this.fookChongProjectMapper.addProjectImages(projectImgParam);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProjectImages(List<UpdateProjectImageParam> updateProjectImageParams) {
        try{
            this.fookChongProjectMapper.updateProjectImages(updateProjectImageParams);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProjectImages(List<ProjectImgParam> projectImgParams) {
        try{
            this.fookChongProjectMapper.deleteProjectImages(projectImgParams);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
