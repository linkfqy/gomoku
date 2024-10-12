package com.gobanggame.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: gobanggame
 * @description: Feedback表实体类
 **/
@Data
@Schema(description = "Feedback表实体类")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {

    @Schema(description = "主键、自增，反馈id", example = "10001")
    private Long id;

    @Schema(description = "反馈的用户", example = "20001")
    private Long userId;

    @Schema(description = "反馈信息", example = "This is a feedback content example.")
    private String feedbackContent;

    @Schema(description = "反馈时间", example = "2024-10-01T10:15:00")
    private LocalDateTime feedbackTime;
    @Schema(description = "是否解决", example = "false")
    private Boolean fixed;

    @Schema(description = "问题解决时间", example = "2024-10-01T10:15:00")
    private LocalDateTime fixedTime;
}
