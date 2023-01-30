package com.ivelite.fokchongdev.service;

import com.ivelite.fokchongdev.model.dto.ProjectDTO;
import com.ivelite.fokchongdev.model.param.UserCommentParam;
import com.ivelite.fokchongdev.model.vo.ProjectImgVO;
import com.ivelite.fokchongdev.model.vo.ProjectListVO;
import com.ivelite.fokchongdev.model.vo.ProjectVO;
import org.springframework.lang.Nullable;

import java.util.List;

public interface FookChongProjectService {
  ProjectVO getProjectDetailById(Integer projectId);

  ProjectListVO getAllProjects(@Nullable Integer pageSize, @Nullable Integer pageNum);

  ProjectImgVO getProjectImgUrlById(Integer projectId);

  List<String> getBannerImages();

  List<String> getUserComments();

  List<ProjectDTO> getFeaturedProjects();

  void evictProjectListCache();

  void evictBannerImgUrlsCache();

  void evictUserCommentsCache();

  void evictFeaturedProjectsCache();
}
