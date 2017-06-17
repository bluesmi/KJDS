package com.penglai.kjds.model;

import java.util.List;

/**
 * Created by m199 on 2017/6/17.
 */

public class BaseResArray<T> extends BaseResRoot {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
