package com.abdelrahman.form.forms.select;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.form.R;
import com.abdelrahman.form.adapter.viewholders.SelectableViewHolder;
import com.abdelrahman.form.forms.FormItem;
import com.abdelrahman.form.listeners.SelectionObserver;
import com.abdelrahman.form.listeners.ValidationFailedObserver;
import com.abdelrahman.form.listeners.ValueChangeObserver;

public class SelectFormItem implements SelectableFormItem {
    private String value;
    private Integer titleRes;
    private Integer hint;
    private String error;
    private boolean isSelectable;
    private boolean isRequired;
    private SelectionObserver selectionObserver;
    private ValueChangeObserver observer;
    private ValidationFailedObserver validationObserver;

    public static class Builder {
        private String value;
        private final Integer titleRes;
        private final Integer hint;
        /**
         * selectable behavior is true by default,
         * unless the user intentionally changed it.
         */
        private boolean isSelectable = true;
        /**
         * required is true by default,
         * unless the user intentionally changed it.
         */
        private boolean isRequired = true;
        private String error;
        private SelectionObserver selectionObserver;
        private ValueChangeObserver observer;
        private ValidationFailedObserver validationObserver;

        public Builder(int titleRes, int hint) {
            this.titleRes = titleRes;
            this.hint = hint;
        }

        public Builder withValue(String value) {
            this.value = value;
            return this;
        }

        public Builder withError(String error) {
            this.error = error;
            return this;
        }

        public Builder isSelectable(boolean isSelectable) {
            this.isSelectable = isSelectable;
            return this;
        }

        public Builder isRequired(boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        public Builder withSelectionObserver(SelectionObserver selectionObserver) {
            this.selectionObserver = selectionObserver;
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

        public SelectFormItem build() {
            return new SelectFormItem(this);
        }
    }


    private SelectFormItem(Builder builder) {
        this.value = builder.value;
        this.titleRes = builder.titleRes;
        this.hint = builder.hint;
        this.isSelectable = builder.isSelectable;
        this.selectionObserver = builder.selectionObserver;
        this.observer = builder.observer;
        this.isRequired = builder.isRequired;
        this.validationObserver = builder.validationObserver;
        this.error = builder.error;
    }

    @Override
    public boolean isSelectable() {
        return isSelectable;
    }

    @Override
    public void setIsSelectable(boolean isSelectable) {
        this.isSelectable = isSelectable;
    }

    @Override
    public Integer getHint() {
        return hint;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public void setHint(Integer hint) {
        this.hint = hint;
    }

    @Override
    public SelectionObserver getSelectionObserver() {
        return selectionObserver;
    }

    @Override
    public void setSelectionObserver(SelectionObserver selectionObserver) {
        this.selectionObserver = selectionObserver;
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
        this.value = String.valueOf(value);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.selectable_form_item;
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
        return new SelectableViewHolder(itemView, formItem);
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
        boolean isAcceptedCriteria = value != null && !value.isEmpty();
        if (!isRequired && isAcceptedCriteria)
            return true;
        else if (!isRequired)
            return true;
        else return isAcceptedCriteria;
    }
}
