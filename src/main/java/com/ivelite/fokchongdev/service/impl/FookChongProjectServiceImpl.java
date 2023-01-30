package com.ivelite.fokchongdev.service.impl;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.ivelite.fokchongdev.mapper.FookChongProjectMapper;
import com.ivelite.fokchongdev.model.dto.ProjectDTO;
import com.ivelite.fokchongdev.model.param.UserCommentParam;
import com.ivelite.fokchongdev.model.vo.ProjectImgVO;
import com.ivelite.fokchongdev.model.vo.ProjectListVO;
import com.ivelite.fokchongdev.model.vo.ProjectVO;
import com.ivelite.fokchongdev.service.FookChongProjectService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FookChongProjectServiceImpl implements FookChongProjectService {

  private final FookChongProjectMapper fookChongProjectMapper;

  private LoadingCache<String, ProjectListVO> projectListFromCache;

  private LoadingCache<String, List<String>> bannerImgUrlsCache;

  private LoadingCache<String, List<String>> userCommentsCache;

  private LoadingCache<String, List<ProjectDTO>> featuredProjectsCache;

  public FookChongProjectServiceImpl(FookChongProjectMapper fookChongProjectMapper) {
    this.fookChongProjectMapper = fookChongProjectMapper;
  }

  @PostConstruct
  public void init() {
    try {
      this.projectListFromCache =
          Caffeine.newBuilder()
              .expireAfterWrite(30, TimeUnit.SECONDS)
              .build((this::getAllProjectsFromDBForCache));
      this.bannerImgUrlsCache =
          Caffeine.newBuilder()
              .expireAfterWrite(30, TimeUnit.MINUTES)
              .build((this::getBannerImagesFromDBForCache));
      this.userCommentsCache =
          Caffeine.newBuilder()
              .expireAfterWrite(30, TimeUnit.MINUTES)
              .build((this::getUserCommentsFromDBForCache));
      this.featuredProjectsCache =
          Caffeine.newBuilder()
              .expireAfterWrite(30, TimeUnit.MINUTES)
              .build((this::getFeaturedProjectsFromDBForCache));
    } catch (Exception ex) {
      log.error("ProjectServiceImpl Cache init error", ex);
    }
  }

  @Override
  public ProjectVO getProjectDetailById(@NonNull Integer projectId) {
    log.info("[Fook Chong] Getting the project detail by id {}", projectId);
    ProjectDTO projectDTO = fookChongProjectMapper.getProjectDetailById(projectId);
    if (Objects.nonNull(projectDTO)) {
      return ProjectVO.builder()
          .id(projectDTO.getId())
          .projectId(projectDTO.getProjectId())
          .projectAddress(projectDTO.getProjectAddress())
          .projectArea(projectDTO.getProjectArea())
          .projectDesc(projectDTO.getProjectDescription())
          .projectDistrict(projectDTO.getProjectDistrict())
          .projectHouseSize(projectDTO.getProjectHouseSize())
          .projectBuildingStyle(projectDTO.getProjectBuildingStyle())
          .projectBuildTime(projectDTO.getProjectBuildTime())
          .projectHouseName(projectDTO.getProjectHouseName())
          .projectCoverImg(projectDTO.getProjectCoverImg())
          .projectBuildingType(projectDTO.getProjectBuildingType())
          .hasFeatured(projectDTO.getHasFeatured())
          .creationTime(projectDTO.getCreationTime())
          .isShow(projectDTO.getIsShow())
          .build();
    }
    log.info("The project id {} is null", projectId);
    return null;
  }

  @Override
  public ProjectListVO getAllProjects(@Nullable Integer pageSize, @Nullable Integer pageNum) {

    final String PROJECT_LIST_CACHE_KEY = "PROJECT_LIST";
    final ProjectListVO result = this.projectListFromCache.get(PROJECT_LIST_CACHE_KEY);

    if (Objects.nonNull(pageNum) && Objects.nonNull(pageSize)) {
      log.info(
          "[Fook Chong] Getting the project list; pageSize = {} pageNum = {}; result size = {}",
          pageSize,
          pageNum,
          result.getProjectList().size());

      ProjectListVO resultClone =
          ProjectListVO.builder()
              .projectList(result.getProjectList())
              .totalProjectCount(result.getTotalProjectCount())
              .build();

      pageSize = pageSize < 0 ? Integer.MAX_VALUE : pageSize;
      pageNum = pageNum < 0 ? 0 : (pageNum - 1) * pageSize;

      resultClone.setProjectList(
          resultClone.getProjectList().stream()
              .skip(pageNum)
              .limit(pageSize)
              .collect(Collectors.toList()));
      return resultClone;
    }

    return result;
  }

  private ProjectListVO getAllProjectsFromDBForCache(String cacheKey) {
    try {
      log.info("[Fook Chong] Getting Data from DB");
      List<ProjectDTO> projectDTOList = fookChongProjectMapper.getAllProjects();
      Integer totalCount = fookChongProjectMapper.getTotalProjectCount();

      return ProjectListVO.builder()
          .projectList(projectDTOList)
          .totalProjectCount(totalCount)
          .build();
    } catch (Exception e) {
      log.error("[Fook Chong] Cant get all projects from DB", e);
    }
    return null;
  }

  @Override
  public ProjectImgVO getProjectImgUrlById(@NonNull Integer projectId) {
    try {
      log.info("[Fook Chong] Getting the project imgs; projectId = {}", projectId);
      List<String> projectImgUrls = fookChongProjectMapper.getProjectImgsById(projectId);
      return ProjectImgVO.builder().projectImgUrls(projectImgUrls).projectId(projectId).build();
    } catch (Exception exception) {
      log.error("[Fook Chong] Cant get the project imgs from DB", exception);
    }
    return null;
  }

  @Override
  public List<String> getBannerImages() {
    final String BANNER_IMG_CACHE_KEY = "BANNER_IMG";
    final List<String> result = this.bannerImgUrlsCache.get(BANNER_IMG_CACHE_KEY);

    return result;
  }

  @Override
  public List<String> getUserComments() {
    final String USER_COMMENT_CACHE_KEY = "USER_COMMENTS";
    final List<String> result = this.userCommentsCache.get(USER_COMMENT_CACHE_KEY);

    return result;
  }

  @Override
  public List<ProjectDTO> getFeaturedProjects() {
    final String FEATURED_PROJECTS_CACHE_KEY = "FEATURED_PROJECTS";
    final List<ProjectDTO> result = this.featuredProjectsCache.get(FEATURED_PROJECTS_CACHE_KEY);

    return result;
  }

  private List<String> getBannerImagesFromDBForCache(String cacheKey) {
    try {
      log.info("[Fook Chong] Getting the banner image urls from DB ... ");
      return fookChongProjectMapper.getBannerImages();
    } catch (Exception exception) {
      log.error("[Fook Chong] Cant get the banner image urls from DB", exception);
    }
    return List.of();
  }

  private List<String> getUserCommentsFromDBForCache(String cacheKey) {
    try {
      log.info("[Fook Chong] Getting the user comments from DB ... ");
      return fookChongProjectMapper.getUserComments();
    } catch (Exception exception) {
      log.error("[Fook Chong] Cant get the banner image urls from DB", exception);
    }
    return List.of();
  }

  private List<ProjectDTO> getFeaturedProjectsFromDBForCache(String cacheKey) {
    try {
      log.info("[Fook Chong] Getting the user comments from DB ... ");
      return fookChongProjectMapper.getFeaturedProjects();
    } catch (Exception exception) {
      log.error("[Fook Chong] Cant get the banner image urls from DB", exception);
    }
    return List.of();
  }

  @Override
  public void evictProjectListCache() {
    this.projectListFromCache.invalidateAll();
  }

  @Override
  public void evictBannerImgUrlsCache() {
    this.bannerImgUrlsCache.invalidateAll();
  }

  @Override
  public void evictUserCommentsCache() {
    this.userCommentsCache.invalidateAll();
  }

  @Override
  public void evictFeaturedProjectsCache() {
    this.featuredProjectsCache.invalidateAll();
  }
}
