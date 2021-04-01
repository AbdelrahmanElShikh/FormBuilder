package com.abdelrahman.formapplication.listeners;

import com.abdelrahman.formapplication.forms.FormItem;

public interface SelectionObserver {
    void onUserSelect(FormItem formItem);
}
