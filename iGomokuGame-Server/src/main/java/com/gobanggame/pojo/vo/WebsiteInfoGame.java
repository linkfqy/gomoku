package com.gobanggame.pojo.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @program: gobanggame
 * @description: 网站每天访客量的vo，后台管理中—网站用户的分析VO
 **/
@Data
public class WebsiteInfoGame {
    private Long id;
    private Integer newUserCount;
    private Integer visitorCount;
    private Integer websiteClicks;
    private LocalDate recordDate;
}
