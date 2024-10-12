package com.gobanggame.pojo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: gobanggame
 * @description: 聊天数据传输实体对象
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private Long userId;
    private Long targetUserId;
    private String nickname;
    private String Message;
}
