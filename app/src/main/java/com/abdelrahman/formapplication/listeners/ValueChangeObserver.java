package com.abdelrahman.formapplication.listeners;

import com.abdelrahman.formapplication.forms.FormItem;

public interface ValueChangeObserver {
    void onValueChange(FormItem formItem, Object changedValue);
}
