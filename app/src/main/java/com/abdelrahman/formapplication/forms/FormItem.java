package com.abdelrahman.formapplication.forms;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.listeners.ValueChangeObserver;


public interface FormItem {
    Integer getTitle();

    void setTitle(Integer title);


    Object getValue();

    void setValue(Object value);

    //TODO : make observer to get value (from Form to formItem)

    int getLayoutResource();

    RecyclerView.ViewHolder getViewHolder(@NonNull View itemView, FormItem item);

    ValueChangeObserver getValueChangeObserver();

    void setChangeObserver(ValueChangeObserver observer);
}
