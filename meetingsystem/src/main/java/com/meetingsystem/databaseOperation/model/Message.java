package com.meetingsystem.databaseOperation.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Message消息
 *
 * @author 221801318_黄贸之
 * @Date 2021/3/27
 */

@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String id;
    private String userId;
    private String rorumId;
    private String time;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRorumId() {
        return rorumId;
    }

    public void setRorumId(String rorumId) {
        this.rorumId = rorumId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
