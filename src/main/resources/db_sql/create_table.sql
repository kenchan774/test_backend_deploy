
create table fookchong_project(
                                  id serial primary key,
                                  project_id integer,
                                  project_description varchar(200) default '',
                                  project_building_style varchar(200) default '' ,
                                  project_cover_img varchar(100),
                                  project_district varchar(100) ,
                                  project_area varchar(100) ,
                                  project_address varchar(200),
                                  project_building_type varchar(200),
                                  project_house_size float,
                                  project_house_name varchar(20) ,
                                  project_build_time varchar(100),
                                  creation_time timestamp,
                                  has_img_comparison integer default 0
);

comment on column fookchong_project.project_building_style is '建築風格: 歐陸風';
comment on column fookchong_project.project_district is '新界/九龍/香港';
comment on column fookchong_project.project_area is '屯門/元朗/天水圍';
comment on column fookchong_project.project_address is '詳細地址';
comment on column fookchong_project.project_building_type is '建築種類：公屋/居屋/私人屋苑';
comment on column fookchong_project.project_house_size is '建築面積';
comment on column fookchong_project.project_house_name is '屋苑/公屋 名稱';
comment on column fookchong_project.has_img_comparison is '是否有比較圖: 0冇， 1有';


create table fookchong_project_img(
      id serial primary key,
      project_id integer,
      project_img_url varchar(200)
);

create table fookchong_project_compare_img(
    id serial primary key,
    project_id integer,
    project_before_img_url varchar(200),
    project_after_img_url varchar(200)
);

create table fookchong_page_config(
    id serial primary key,
    page_block varchar(200),
    page_content varchar(200)
);