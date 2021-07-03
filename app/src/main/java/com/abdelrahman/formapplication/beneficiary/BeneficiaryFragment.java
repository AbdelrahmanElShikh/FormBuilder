package com.abdelrahman.formapplication.beneficiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.abdelrahman.formapplication.R;
import com.abdelrahman.formapplication.SharedViewModel;
import com.abdelrahman.formapplication.adapter.FormAdapter;
import com.abdelrahman.formapplication.databinding.FragmentBeneficiaryBinding;

public class BeneficiaryFragment extends Fragment {
    private FragmentBeneficiaryBinding binding;
    private FormAdapter adapter;
    private BeneficiaryForm beneficiaryForm;
    private SharedViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        beneficiaryForm = new BeneficiaryForm(this);
        adapter = new FormAdapter(beneficiaryForm.getFormItems());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beneficiary, container, false);
        beneficiaryForm.setFormView(binding.formView);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.formView.setAdapter(adapter);
        binding.btn.setOnClickListener(v -> Toast.makeText(getContext(), beneficiaryForm.isValid() + "", Toast.LENGTH_SHORT).show());
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

}