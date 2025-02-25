package jsu.edu.mcis.cs408.lab04.tabs;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import jsu.edu.mcis.cs408.lab04.R;
import jsu.edu.mcis.cs408.lab04.databinding.TempConverterBinding;
import jsu.edu.mcis.cs408.lab04.databinding.TipCalculatorBinding;

public class TipCalculator extends Fragment implements View.OnClickListener {
    private TipCalculatorBinding binding;

    EditText totalInput;
    EditText percentInput;
    EditText numPeopleInput;
    Button calcButton;

    TextView resultLabel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = TipCalculatorBinding.inflate(getLayoutInflater(), container, false);
        totalInput = binding.totalInput;
        percentInput = binding.percentInput;
        numPeopleInput = binding.numPeopleInput;
        calcButton = binding.calcButton;
        resultLabel = binding.result;

        calcButton.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    boolean shouldCalculate() {
        try {
            Double.parseDouble(totalInput.getText().toString());
            Double.parseDouble(percentInput.getText().toString());
            Double.parseDouble(numPeopleInput.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "Must Provide All Fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void Calculate() {
        MathContext mc = new MathContext(10);
        BigDecimal total = new BigDecimal(totalInput.getText().toString());
        BigDecimal percent = new BigDecimal(percentInput.getText().toString()).divide(new BigDecimal(100), mc);
        BigDecimal numPeople = new BigDecimal(numPeopleInput.getText().toString());

        BigDecimal tip = total.multiply(percent).add(total);

        BigDecimal perPerson = tip.divide(numPeople, mc).setScale(2, RoundingMode.HALF_UP);

        Resources res = getResources();

        String result = String.format(res.getString(R.string.result), perPerson.toString());

        resultLabel.setText(result);
    }

    @Override
    public void onClick(View v) {
        if (shouldCalculate()) {
            Calculate();
        }
    }
}
