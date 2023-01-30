package com.ivelite.fokchongdev.controller;

import com.ivelite.fokchongdev.common.ResponseResult;
import com.ivelite.fokchongdev.model.dto.ProjectDTO;
import com.ivelite.fokchongdev.model.vo.ProjectImgVO;
import com.ivelite.fokchongdev.model.vo.ProjectListVO;
import com.ivelite.fokchongdev.model.vo.ProjectVO;
import com.ivelite.fokchongdev.service.FookChongProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://ivelite-fookchong-ui.herokuapp.com")
@RestController
@RequestMapping("/v1/fookchong/projects")
public class ProjectController {

    private final FookChongProjectService fookChongProjectService;

    public ProjectController(FookChongProjectService fookChongProjectService) {
        this.fookChongProjectService = fookChongProjectService;
    }

    @GetMapping("/{projectId}")
    public ResponseResult<ProjectVO> getProjectDetail(@PathVariable Integer projectId){
        return ResponseResult.success(fookChongProjectService.getProjectDetailById(projectId));
    }

    @GetMapping
    public ResponseResult<ProjectListVO> getAllProjects(@RequestParam(name = "pageSize", required = false) Integer pageSize, @RequestParam(name = "pageNum", required = false) Integer pageNum){
        return ResponseResult.success(fookChongProjectService.getAllProjects(pageSize, pageNum));
    }

    @GetMapping("/{projectId}/img")
    public ResponseResult<ProjectImgVO> getProjectImgById(@PathVariable Integer projectId){
        return ResponseResult.success(fookChongProjectService.  getProjectImgUrlById(projectId));
    }

    @GetMapping("/banners")
    public ResponseResult<List<String>> getBannerImages(){
        return ResponseResult.success(fookChongProjectService.getBannerImages());
    }

    @GetMapping("/comments")
    public ResponseResult<List<String>> getUserComments(){
        return ResponseResult.success(fookChongProjectService.getUserComments());
    }

    @GetMapping("/featuredProject")
    public ResponseResult<List<ProjectDTO>> getFeaturedProjects(){
        return ResponseResult.success(fookChongProjectService.getFeaturedProjects());
    }
}
