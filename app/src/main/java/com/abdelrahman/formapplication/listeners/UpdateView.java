package com.abdelrahman.formapplication.listeners;

public interface UpdateView {
    void updateView(int position);
    void notifyDataChange();
    void scrollToPosition(int position);
}
