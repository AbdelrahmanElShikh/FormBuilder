package com.abdelrahman.formapplication.forms;

import java.util.List;

public interface Form {
    List<FormItem> getFormItems();

    boolean isValid();
}
