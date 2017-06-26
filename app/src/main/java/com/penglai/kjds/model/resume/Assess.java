package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/26.
 */

public class Assess implements Serializable {
    private String content;

    public Assess(String content) {
        this.content = content;
    }

    public Assess() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
