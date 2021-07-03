package com.abdelrahman.form.listeners;


import com.abdelrahman.form.forms.FormItem;

public interface ValueChangeObserver {
    void onValueChange(FormItem formItem, Object changedValue);
}
