package com.abdelrahman.formapplication.forms.select;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.listeners.ValueChangeObserver;
import com.abdelrahman.formapplication.forms.FormItem;
import com.abdelrahman.formapplication.adapter.viewholders.SelectableFormItemViewHolder;
import com.abdelrahman.formapplication.listeners.SelectionObserver;

public class SelectFormItem implements SelectableFormItem {
    private Object value;
    private Integer titleRes;
    private Integer hint;
    private boolean isSelectable;
    private SelectionObserver selectionObserver;
    private ValueChangeObserver observer;

    public static class Builder {
        private Object value;
        private final Integer titleRes;
        private final Integer hint;
        private boolean isSelectable = true;
        private SelectionObserver selectionObserver;
        private ValueChangeObserver observer;

        public Builder(int titleRes, int hint) {
            this.titleRes = titleRes;
            this.hint = hint;
        }

        public Builder withValue(Object value) {
            this.value = value;
            return this;
        }

        public Builder isSelectable(boolean isSelectable) {
            this.isSelectable = isSelectable;
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
        this.value = value;
    }

    @Override
    public int getLayoutResource() {
        return R.layout.selectable_form_item;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(@NonNull View itemView, FormItem formItem) {
        return new SelectableFormItemViewHolder(itemView, formItem);
    }

    @Override
    public ValueChangeObserver getValueChangeObserver() {
        return observer;
    }

    @Override
    public void setChangeObserver(ValueChangeObserver observer) {
        this.observer = observer;
    }
}
