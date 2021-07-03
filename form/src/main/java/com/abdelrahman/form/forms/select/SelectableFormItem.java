package com.abdelrahman.form.forms.select;



import com.abdelrahman.form.forms.FormItem;
import com.abdelrahman.form.listeners.SelectionObserver;

import java.io.Serializable;

public interface SelectableFormItem extends FormItem, Serializable {
    boolean isSelectable();

    void setIsSelectable(boolean isSelectable);

    Integer getHint();

    String getError();

    void setError(String error);

    void setHint(Integer hint);

    SelectionObserver getSelectionObserver();

    void setSelectionObserver(SelectionObserver selectionObserver);
}
