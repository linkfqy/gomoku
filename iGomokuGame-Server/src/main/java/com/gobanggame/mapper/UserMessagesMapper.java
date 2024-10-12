package com.gobanggame.mapper;

import com.gobanggame.pojo.vo.MessageResult;
import com.gobanggame.pojo.entity.UserMessage;
import com.gobanggame.pojo.vo.UserFriendChatVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: gobanggame
 * @description: 消息数据库操作mapper
 **/
@Mapper
public interface UserMessagesMapper {
    /**
     * @param userMessage
     * @return void
     * @description 插入这条消息数据
     **/
    @Insert("insert into user_messages(user_id, friend_id, message, message_time,readed) " +
            "VALUES(#{userId},#{friendId},#{message},#{messageTime},#{readed})")
    void insert(UserMessage userMessage);

    /**
     * @param userId
     * @param friendId
     * @return java.util.List<com.gobanggame.pojo.vo.UserFriendChatVO>
     * @description 多表联查20条聊天数据——user表和user_messages表
     **/
    List<UserFriendChatVO> listTwentyRecords(Long userId, Long friendId);

    /**
     * @param id
     * @return java.lang.Long
     * @description 根据userId查询当前未读消息的个数
     **/
    @Select("select count(*) from user_messages where readed=1 and friend_id=#{id}")
    Integer selectByUserId(Long id);

    /**
     * @param id
     * @return java.util.List<com.gobanggame.pojo.vo.MessageResult.UserMessageResult>
     * @description 分组查询，根据不同friend进行一个聚合。查询与不同好友的未读消息数
     **/
    @Select("select count(*) as count,user_id as friendId,friend_id as userId from user_messages where friend_id=#{id} and readed=1 group by user_id")
    List<MessageResult.UserMessageResult> selectManyCountsByUserId(Long id);

    /**
     * @param userId
     * @param friendId
     * @return void
     * @description 修改好友所有未读的信息都为已读
     **/
    @Update("update user_messages set readed=0 where user_id=#{friendId} and friend_id=#{userId}")
    void update(Long userId, Long friendId);
}
