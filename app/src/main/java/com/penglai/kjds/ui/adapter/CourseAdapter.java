package com.penglai.kjds.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.penglai.kjds.model.index.Course;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.holder.CourseViewHolder;

/**
 * Created by m199 on 2017/7/8.
 */

public class CourseAdapter extends BaseAdapter<Course> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new CourseViewHolder(context,parent);
    }
}
