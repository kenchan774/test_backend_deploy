package com.ivelite.fokchongdev.controller;

import java.util.List;

import com.ivelite.fokchongdev.common.ResponseResult;
import com.ivelite.fokchongdev.model.dto.ProjectDTO;
import com.ivelite.fokchongdev.model.param.BannerImageParam;
import com.ivelite.fokchongdev.model.param.HideProjectParam;
import com.ivelite.fokchongdev.model.param.ProjectImgParam;
import com.ivelite.fokchongdev.model.param.ProjectParam;
import com.ivelite.fokchongdev.model.param.UpdateProjectImageParam;
import com.ivelite.fokchongdev.model.param.UserCommentParam;
import com.ivelite.fokchongdev.service.CMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/v1/fookchong/cms")
//@CrossOrigin(
//    allowCredentials = "true",
//    origins = {"https://ivelite-fookchong-ui.herokuapp.com/", "http://localhost:3000"},
//    exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
public class CMSController {

    private final CMSService cmsService;

    public CMSController(CMSService cmsService) {
        this.cmsService = cmsService;
    }

    @PostMapping("/addProject")
    @ResponseBody
    public ResponseResult<Integer> addNewProject(@RequestBody final ProjectParam projectParam){
        try{
            //TODO: add login checking logic
            this.cmsService.addNewProject(projectParam);
            log.info("[Fook Chong] Adding a new project");
            return ResponseResult.success(Integer.valueOf(1));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/hideProject")
    @ResponseBody
    public ResponseResult<Integer> hideProjectById(@RequestBody final HideProjectParam hideProjectParam){

        this.cmsService.hideProjectById(hideProjectParam);
        return ResponseResult.success(1);
    }

    @PostMapping("/showProject")
    @ResponseBody
    public ResponseResult<Integer> showProjectById(@RequestBody final HideProjectParam hideProjectParam){

        this.cmsService.showProjectById(hideProjectParam);
        return ResponseResult.success(1);
    }

    @PostMapping("/updateProject")
    @ResponseBody
    public ResponseResult<Integer> updateProject(@RequestBody final ProjectDTO projectDTO){
        this.cmsService.updateProject(projectDTO);
        return ResponseResult.success(1);
    }

    @PostMapping("/updateBannerImages")
    @ResponseBody
    public ResponseResult<Integer> updateBannerImages(@RequestBody final BannerImageParam bannerImageUrls){
        this.cmsService.updateBannerImages(bannerImageUrls);
        return ResponseResult.success(1);
    }

    @PostMapping("/updateUserComments")
    @ResponseBody
    public ResponseResult<Integer> updateUserComments(@RequestBody final UserCommentParam userCommentParam){
        this.cmsService.updateUserComments(userCommentParam);
        return ResponseResult.success(1);
    }

    @PostMapping("/createProjectImages")
    @ResponseBody
    public ResponseResult<Integer> addProjectImages(@RequestBody final List<ProjectImgParam> projectImgParams){
        this.cmsService.addProjectImages(projectImgParams);
        return ResponseResult.success(1);
    }


    @PostMapping("/updateProjectImages")
    @ResponseBody
    public ResponseResult<Integer> updateProjectImages(@RequestBody final List<UpdateProjectImageParam> updateProjectImageParams){
        this.cmsService.updateProjectImages(updateProjectImageParams);
        return ResponseResult.success(1);
    }

    @PostMapping("/deleteProjectImages")
    @ResponseBody
    public ResponseResult<Integer> deleteProjectImages(@RequestBody final List<ProjectImgParam> projectImgParams){
        this.cmsService.deleteProjectImages(projectImgParams);
        return ResponseResult.success(1);
    }
}
