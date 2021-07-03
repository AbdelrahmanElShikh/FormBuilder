package com.abdelrahman.form.forms.edit;

import android.text.InputType;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.form.R;
import com.abdelrahman.form.adapter.viewholders.EditableViewHolder;
import com.abdelrahman.form.forms.FormItem;
import com.abdelrahman.form.listeners.ValidationFailedObserver;
import com.abdelrahman.form.listeners.ValueChangeObserver;

public class EditFormItem implements EditableFormItem {
    private Integer titleRes;
    private Integer placeHolder;
    private String value;
    private String error;
    private String digits;
    private int maxLength;
    private int keyBoardType;
    private boolean isRequired;
    private ValueChangeObserver observer;
    private ValidationFailedObserver validationObserver;

    public static class Builder {
        private Integer titleRes;
        private Integer placeHolder;
        private String value;
        private String error;
        private String digits;
        private int maxLength;
        private int inputType;
        private boolean isRequired = true;
        private ValueChangeObserver observer;
        private ValidationFailedObserver validationObserver;

        public Builder() {
        }

        public Builder withTitleRes(int titleRes) {
            this.titleRes = titleRes;
            return this;
        }

        public Builder withPlaceHolder(int placeHolder) {
            this.placeHolder = placeHolder;
            return this;
        }

        public Builder withValue(String value) {
            this.value = value;
            return this;
        }

        public Builder withError(String error) {
            this.error = error;
            return this;
        }

        public Builder withMaxLength(int maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public Builder withKeyboardInputType(int inputType) {
            this.inputType = inputType;
            return this;
        }

        public Builder withDigits(String digits) {
            this.digits = digits;
            return this;
        }

        public Builder isRequired(boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        public Builder withValueChangeObserver(ValueChangeObserver observer) {
            this.observer = observer;
            return this;
        }

        public Builder withValidationFailedObserver(ValidationFailedObserver validationObserver) {
            this.validationObserver = validationObserver;
            return this;
        }

        public EditFormItem build() {
            return new EditFormItem(this);
        }
    }


    private EditFormItem(Builder builder) {
        this.titleRes = builder.titleRes;
        this.placeHolder = builder.placeHolder;
        this.value = builder.value;
        this.maxLength = builder.maxLength;
        this.error = builder.error;
        this.keyBoardType = builder.inputType;
        this.digits = builder.digits;
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
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (String) value;
    }

    @Override
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public int getKeyboardType() {
        return keyBoardType == 0 ? InputType.TYPE_CLASS_TEXT : keyBoardType;
    }

    @Override
    public void setKeyBoardType(int keyboardType) {
        this.keyBoardType = keyboardType;
    }

    @Override
    public String getDigits() {
        return digits;
    }

    @Override
    public void setDigits(String digits) {
        this.digits = digits;
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
    public ValueChangeObserver getValueChangeObserver() {
        return observer;
    }


    @Override
    public int getLayoutResource() {
        return R.layout.editable_form_item;
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
    public RecyclerView.ViewHolder getViewHolder(@NonNull View itemView, FormItem formItem) {
        return new EditableViewHolder(itemView, formItem);
    }

    @Override
    public Integer getPlaceHolder() {
        return placeHolder;
    }

    @Override
    public void setPlaceHolder(Integer placeHolder) {
        this.placeHolder = placeHolder;
    }

    @Override
    public boolean isValid() {
        boolean isAcceptedCriteria = value != null && !value.isEmpty() && value.length() <= maxLength && error == null;
        if (!isRequired && isAcceptedCriteria)
            return true;
        else if (!isRequired)
            return true;
        else return isAcceptedCriteria;
    }

}
