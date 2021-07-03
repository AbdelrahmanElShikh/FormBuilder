package com.abdelrahman.form.forms.switchitem;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.form.R;
import com.abdelrahman.form.adapter.viewholders.SwitchableViewHolder;
import com.abdelrahman.form.forms.FormItem;
import com.abdelrahman.form.listeners.ValidationFailedObserver;
import com.abdelrahman.form.listeners.ValueChangeObserver;

public class SwitchFormItem implements FormItem {

    private Object value;
    private Integer titleRes;
    private boolean isRequired;
    private ValueChangeObserver observer;
    private ValidationFailedObserver validationObserver;

    public static class Builder {
        private Object value;
        private final Integer titleRes;
        private boolean isRequired = true;
        private ValueChangeObserver observer;
        private ValidationFailedObserver validationObserver;

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

        public Builder withValidationFailedObserver(ValidationFailedObserver validationObserver) {
            this.validationObserver = validationObserver;
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
        this.validationObserver = builder.validationObserver;
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
    public ValidationFailedObserver getValidationFailedObserver() {
        return validationObserver;
    }

    @Override
    public void setValidationFailedObserver(ValidationFailedObserver validationObserver) {
        this.validationObserver = validationObserver;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
