package com.gobanggame.mapper;

import com.gobanggame.pojo.entity.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @program: gobanggame
 * @description:
 **/
@Mapper
public interface FeedbackMapper {
    /**
     * @description 获取所有反馈列表
     * @param
     * @return java.util.List<com.gobanggame.pojo.entity.Feedback>
     **/
    @Select("select * from feedback")
    List<Feedback> list();

    /**
     * @description 条件更新feedback（后续扩展），目前只更新两个字段
     * @param feedback
     * @return void
     **/
    @Update("update feedback set fixed=#{fixed} ,fixed_time=#{fixedTime} where id=#{id}")
    void update(Feedback feedback);

    /**
     * @description 新增反馈
     * @param feedback
     * @return void
     **/
    @Insert("insert into feedback(user_id,feedback_content,feedback_time) values (#{userId},#{feedbackContent},#{feedbackTime})")
    void insert(Feedback feedback);
}
