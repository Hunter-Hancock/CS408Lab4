package jsu.edu.mcis.cs408.lab04;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import jsu.edu.mcis.cs408.lab04.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}