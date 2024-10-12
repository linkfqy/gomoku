package com.gobanggame.pojo.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @program: gobanggame
 * @description: 网站后台棋局信息模块的VO
 **/
@Data
public class GomokuGameCount {
    private Long id;
    private LocalDate recordDate;
    private Integer aiGameCounts;
    private Integer humanGameCount;
}
