package com.abdelrahman.formapplication.formView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.adapter.FormAdapter;
import com.abdelrahman.formapplication.listeners.UpdateView;

/**
 * Author : Abdel-Rahman El-Shikh
 * Date : 03-Jul-21
 * Project : com.abdelrahman.formapplication.formView
 */
public class FormView extends LinearLayout implements UpdateView {
    private RecyclerView recyclerView;
    private final Context context;
    private FormAdapter formAdapter;

    public FormView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public FormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public FormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }


    private void init() {
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.form_view, this, true);

        findViewsById(view);
        setupRecyclerView();
    }

    private void findViewsById(View view) {
        recyclerView = view.findViewById(R.id.rv);
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public void setAdapter(FormAdapter adapter) {
        formAdapter = adapter;
        recyclerView.setAdapter(formAdapter);

    }

    @Override
    public void updateView(int position) {
        formAdapter.notifyItemChanged(position);
    }

    @Override
    public void notifyDataChange() {
        formAdapter.notifyDataSetChanged();
    }

    @Override
    public void scrollToPosition(int position) {
        recyclerView.post(() -> recyclerView.smoothScrollToPosition(position));

    }
}
