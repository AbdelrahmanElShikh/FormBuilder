package com.abdelrahman.form.forms;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.form.listeners.ValidationFailedObserver;
import com.abdelrahman.form.listeners.ValueChangeObserver;


public interface FormItem {
    Integer getTitle();

    void setTitle(Integer title);

    Object getValue();

    void setValue(Object value);

    int getLayoutResource();

    boolean isRequired();

    void setIsRequired(boolean isRequired);

    RecyclerView.ViewHolder getViewHolder(@NonNull View itemView, FormItem item);

    ValueChangeObserver getValueChangeObserver();

    void setChangeObserver(ValueChangeObserver observer);

    ValidationFailedObserver getValidationFailedObserver();

    void setValidationFailedObserver(ValidationFailedObserver validationObserver);

    boolean isValid();
}
