package com.gobanggame.mapper;

import com.gobanggame.pojo.entity.GameDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: gobanggame
 * @description: 操作棋局历史信息细节表
 **/
@Mapper
public interface GameDetailsMapper {

    /**
     * @description 插入每一步的详细信息数据
     * @param gameDetails
     * @return void
     **/
    @Insert("insert into game_details(game_id, move_x, move_y, color, step_order) VALUES (#{gameId},#{moveX},#{moveY}," +
            "#{color},#{stepOrder})")
    void insert(GameDetails gameDetails);
}
