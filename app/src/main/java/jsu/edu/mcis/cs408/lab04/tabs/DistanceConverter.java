package jsu.edu.mcis.cs408.lab04.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

import jsu.edu.mcis.cs408.lab04.databinding.DistanceConverterBinding;

public class DistanceConverter extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {
    private DistanceConverterBinding binding;

    EditText milesInput;
    EditText kilometersInput;

    Button convertBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DistanceConverterBinding.inflate(getLayoutInflater(), container, false);
        milesInput = binding.milesInput;
        kilometersInput = binding.kilometersInput;
        convertBtn = binding.convertBtn;
        milesInput.setOnFocusChangeListener(this);
        kilometersInput.setOnFocusChangeListener(this);
        convertBtn.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    private double MilesToKilometers(double m) {
        return m * 1.609;
    }

    private double KilometersToMiles(double k) {
       return k / 1.609;
    }

    @Override
    public void onClick(View v) {
        boolean milesEmpty = milesInput.getText().toString().isEmpty();
        boolean kilometersEmpty =  kilometersInput.getText().toString().isEmpty();

        if (!milesEmpty) {
            String value = milesInput.getText().toString();
            double miles = Double.parseDouble(value);
            double kilometers = MilesToKilometers(miles);
            kilometersInput.setText(String.valueOf(kilometers));
        } else if (!kilometersEmpty) {
            String value = kilometersInput.getText().toString();
            double kilometers = Double.parseDouble(value);
            double miles = KilometersToMiles(kilometers);
            milesInput.setText(String.valueOf(miles));
        } else {
            Toast.makeText(this.getContext(), "Input Something", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        milesInput.setText("");
        kilometersInput.setText("");
    }
}
