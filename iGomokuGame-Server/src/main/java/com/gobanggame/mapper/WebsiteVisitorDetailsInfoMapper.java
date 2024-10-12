package com.gobanggame.mapper;

import com.gobanggame.pojo.entity.WebsiteVisitorDetailsInfo;
import com.gobanggame.pojo.vo.MapData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: gobanggame
 * @description:
 **/
@Mapper
public interface WebsiteVisitorDetailsInfoMapper {
    /**
     * @param ipAddr
     * @param cityInfoByFile
     * @param now
     * @return void
     * @description 新增网站访客详细信息
     **/
    @Insert("insert into website_visitor_details_info ( ip, address, access_time) values (#{ipAddr},#{cityInfoByFile},#{now});")
    void WebsiteClick(String ipAddr, String cityInfoByFile, LocalDateTime now);

    /**
     * @param
     * @return java.util.List<com.gobanggame.pojo.vo.MapData>
     * @description 分组查询，获取所有地域的点击量统计
     **/
    @Select("SELECT address AS areaName, COUNT(*) AS visitorCount FROM website_visitor_details_info GROUP BY address ORDER BY COUNT(*) desc")
    List<MapData> selectWebsiteDetailsCount();

    /**
     * @param
     * @return java.util.List<com.gobanggame.pojo.entity.WebsiteVisitorDetailsInfo>
     * @description 获取点击网站的访客详细信息——按照访问时间降序每次获取20条
     **/
    @Select("select * from website_visitor_details_info order by access_time desc limit 20")
    List<WebsiteVisitorDetailsInfo> selectWebsiteDetails();

    /**
     * @description 更新细节表的访问用户名
     * @param ipAddr
     * @param nickname
     * @return void
     **/
    @Update("update website_visitor_details_info set name=#{nickname} where ip=#{ipAddr} and access_time>= NOW() - INTERVAL 1 HOUR AND access_time<NOW()")
    void update(String ipAddr, String nickname);

    /**
     * @description 查询今天当前ip访问几次了
     * @param ipAddr
     * @return java.util.List<com.gobanggame.pojo.entity.WebsiteVisitorDetailsInfo>
     **/
    @Select("select * from website_visitor_details_info where ip=#{ipAddr} and access_time>= CURDATE() and access_time<CURDATE() +INTERVAL 1 DAY")
    List<WebsiteVisitorDetailsInfo> selectByIpAddr(String ipAddr);


}
