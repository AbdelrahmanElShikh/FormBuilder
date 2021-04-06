package com.abdelrahman.formapplication.forms.switchitem;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.adapter.viewholders.SwitchableViewHolder;
import com.abdelrahman.formapplication.forms.FormItem;
import com.abdelrahman.formapplication.listeners.ValueChangeObserver;

public class SwitchFormItem implements FormItem {

    private Object value;
    private Integer titleRes;
    private boolean isRequired;
    private ValueChangeObserver observer;

    public static class Builder {
        private Object value;
        private final Integer titleRes;
        private boolean isRequired = true;
        private ValueChangeObserver observer;

        public Builder(Integer titleRes) {
            this.titleRes = titleRes;
        }

        public SwitchFormItem.Builder withValue(Object value) {
            this.value = value;
            return this;
        }

        public SwitchFormItem.Builder isRequired(boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        public SwitchFormItem.Builder withValueChangeObserver(ValueChangeObserver observer) {
            this.observer = observer;
            return this;
        }

        public SwitchFormItem build() {
            return new SwitchFormItem(this);
        }
    }


    private SwitchFormItem(SwitchFormItem.Builder builder) {
        this.value = builder.value;
        this.titleRes = builder.titleRes;
        this.observer = builder.observer;
        this.isRequired = builder.isRequired;
    }

    @Override
    public Integer getTitle() {
        return titleRes;
    }

    @Override
    public void setTitle(Integer title) {
        this.titleRes = title;
    }

    @Override
    public Object getValue() {
        return value == null ? false : value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public int getLayoutResource() {
        return R.layout.switchable_form_item;
    }

    @Override
    public boolean isRequired() {
        return isRequired;
    }

    @Override
    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(@NonNull View itemView, FormItem item) {
        return new SwitchableViewHolder(itemView, item);
    }

    @Override
    public ValueChangeObserver getValueChangeObserver() {
        return observer;
    }

    @Override
    public void setChangeObserver(ValueChangeObserver observer) {
        this.observer = observer;
    }

    @Override
    public boolean isValid() {
        return false;
    }
}
