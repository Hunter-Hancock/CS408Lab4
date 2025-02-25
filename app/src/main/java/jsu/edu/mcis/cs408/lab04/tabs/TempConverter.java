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

import jsu.edu.mcis.cs408.lab04.databinding.TempConverterBinding;

public class TempConverter extends Fragment implements View.OnFocusChangeListener, View.OnClickListener{
    private TempConverterBinding binding;

    EditText fahrenheitInput;
    EditText celsiusInput;
    Button convertBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TempConverterBinding.inflate(getLayoutInflater(), container, false);
        fahrenheitInput = binding.fahrenheitInput;
        celsiusInput = binding.celsiusInput;
        fahrenheitInput.setOnFocusChangeListener(this);
        celsiusInput.setOnFocusChangeListener(this);
        convertBtn = binding.button;
        convertBtn.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
    private float FahrenheitToCelsius(float f) {
        return (f - 32) * 5/9;
    }

    private float CelsiusToFahrenheit(float c) {
        return (c * 9/5) + 32;
    }

    public void Convert() {
        boolean fahEmpty = fahrenheitInput.getText().length() == 0;
        boolean celEmpty = celsiusInput.getText().length() == 0;

        if (!fahEmpty) {
            String value = fahrenheitInput.getText().toString();
            float fah = Float.parseFloat(value);
            float cel = FahrenheitToCelsius(fah);
            celsiusInput.setText(String.valueOf(cel));
        } else if (!celEmpty) {
            String value = celsiusInput.getText().toString();
            float cel = Float.parseFloat(value);
            float fah = CelsiusToFahrenheit(cel);
            fahrenheitInput.setText(String.valueOf(fah));
        } else {
            Toast.makeText(this.getContext(), "Both Fields cannot be blank", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        Convert();
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        fahrenheitInput.setText("");
        celsiusInput.setText("");
    }
}
