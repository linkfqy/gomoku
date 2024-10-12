package com.gobanggame.mapper;

import com.gobanggame.pojo.entity.GameHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: gobanggame
 * @description: 操作棋局历史信息表
 **/
@Mapper
public interface GameHistoryMapper {
    /**
     * @param gameHistory
     * @return void
     * @description 插入游戏历史表
     **/
    void insert(GameHistory gameHistory);

    /**
     * @param gameHistory
     * @return void
     * @description 更新棋局表状态
     **/
    @Update("update game_history set end_time=#{endTime} ,game_result=#{gameResult}")
    void update(GameHistory gameHistory);

    /**
     * @param roomId
     * @return com.gobanggame.pojo.entity.GameHistory
     * @description 根据房间号查询游戏历史，需要查询最近的一个——实现超时关闭棋局连接的功能
     **/
    @Select("select * from game_history where room_id=#{roomId} order by begin_time desc limit 1 ")
    GameHistory selectByRoomId(Long roomId);

}
