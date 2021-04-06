package com.abdelrahman.formapplication.beneficiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.SharedViewModel;
import com.abdelrahman.formapplication.adapter.FormAdapter;
import com.abdelrahman.formapplication.databinding.FragmentBeneficiaryBinding;
import com.abdelrahman.formapplication.listeners.UpdateView;

public class BeneficiaryFragment extends Fragment implements UpdateView {
    private FragmentBeneficiaryBinding binding;
    private FormAdapter adapter;
    private BeneficiaryForm beneficiaryForm;
    private SharedViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        beneficiaryForm = new BeneficiaryForm(this, this);
        adapter = new FormAdapter(beneficiaryForm.getFormItems());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beneficiary, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setAdapter(adapter);
        binding.btn.setOnClickListener(v -> {});
        viewModel.getSelectedCurrency().observe(getViewLifecycleOwner(),
                o -> beneficiaryForm
                        .getCurrencySelectFormItem()
                        .getValueChangeObserver()
                        .onValueChange(beneficiaryForm.getCurrencySelectFormItem(), o));

        viewModel.getSelectedCountry().observe(getViewLifecycleOwner(),
                o -> beneficiaryForm
                        .getCountrySelectFormItem()
                        .getValueChangeObserver()
                        .onValueChange(beneficiaryForm.getCountrySelectFormItem(), o));

        viewModel.getSelectedCity().observe(getViewLifecycleOwner(),
                o -> beneficiaryForm
                        .getCitySelectFormItem()
                        .getValueChangeObserver()
                        .onValueChange(beneficiaryForm.getCitySelectFormItem(), o));

    }


    public NavController getNavigationController() {
        return Navigation.findNavController(requireView());
    }

    @Override
    public void updateView(int position) {
        adapter.notifyItemChanged(position);
    }

    @Override
    public void notifyDataChange() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void scrollToPosition(int position) {
        binding.rv.post(() -> binding.rv.smoothScrollToPosition(position));
    }
}