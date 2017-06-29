package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/29.
 */

public class CarouselRes implements Serializable {
    private String path;

    public CarouselRes(String path) {
        this.path = path;
    }

    public CarouselRes() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
