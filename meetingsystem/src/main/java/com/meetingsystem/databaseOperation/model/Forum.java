package com.meetingsystem.databaseOperation.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Forum论坛
 *
 * @author 221801318_黄贸之
 * @Date 2021/3/27
 */

@NoArgsConstructor
@AllArgsConstructor
public class Forum {
    private String id;
    private String name;
    private String masterId;
    private String title;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
