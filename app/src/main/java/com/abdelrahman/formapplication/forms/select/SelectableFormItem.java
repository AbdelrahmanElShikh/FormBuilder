package com.abdelrahman.formapplication.forms.select;

import com.abdelrahman.formapplication.forms.FormItem;
import com.abdelrahman.formapplication.listeners.SelectionObserver;

import java.io.Serializable;

public interface SelectableFormItem extends FormItem, Serializable {
    boolean isSelectable();

    void setIsSelectable(boolean isSelectable);

    Integer getHint();

    void setHint(Integer hint);

    SelectionObserver getSelectionObserver();

    void setSelectionObserver(SelectionObserver selectionObserver);
}
