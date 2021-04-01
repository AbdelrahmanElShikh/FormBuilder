package com.abdelrahman.formapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.forms.FormBinder;
import com.abdelrahman.formapplication.forms.FormItem;

import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<FormItem> formItems;

    public FormAdapter(List<FormItem> formItems) {
        this.formItems = formItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FormItem formItem = formItems.get(viewType);
        View view = LayoutInflater.from(parent.getContext())
                .inflate(formItem.getLayoutResource(), parent, false);
        return formItem.getViewHolder(view, formItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FormBinder) holder).bind();
    }


    @Override
    public int getItemCount() {
        return formItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
