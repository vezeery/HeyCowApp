package com.example.heycowapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        TextInputEditText etName = findViewById(R.id.et_name);
        TextInputEditText etNim = findViewById(R.id.et_nim);
        RadioGroup radioGroup = findViewById(R.id.radio_group_gender);
        LinearLayout cardMale = findViewById(R.id.card_male);
        LinearLayout cardFemale = findViewById(R.id.card_female);
        RadioButton rbMale = findViewById(R.id.rb_male);
        RadioButton rbFemale = findViewById(R.id.rb_female);
        ImageView checkMale = findViewById(R.id.iv_check_male);
        ImageView checkFemale = findViewById(R.id.iv_check_female);
        Button btnSubmit = findViewById(R.id.btn_login);

        cardMale.setOnClickListener(v -> {
            rbMale.setChecked(true);
            checkMale.setVisibility(View.VISIBLE);
            checkFemale.setVisibility(View.GONE);
        });

        cardFemale.setOnClickListener(v -> {
            rbFemale.setChecked(true);
            checkFemale.setVisibility(View.VISIBLE);
            checkMale.setVisibility(View.GONE);
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rb_male) {
                checkMale.setVisibility(View.VISIBLE);
                checkFemale.setVisibility(View.GONE);
            } else if (checkedId == R.id.rb_female) {
                checkFemale.setVisibility(View.VISIBLE);
                checkMale.setVisibility(View.GONE);
            }
        });

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String nim = etNim.getText().toString();
            String gender = rbMale.isChecked() ? "Male" : "Female";

            // Start ResultActivity with the input data
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("nim", nim);
            intent.putExtra("gender", gender);
            startActivity(intent);
        });
    }
}