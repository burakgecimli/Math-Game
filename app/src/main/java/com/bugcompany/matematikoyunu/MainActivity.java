package com.bugcompany.matematikoyunu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bugcompany.matematikoyunu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.buttonCikarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubtractionActivity.class);
                int checkedIntentTime = checkedTimeFun();
                intent.putExtra("time", checkedIntentTime);
                startActivity(intent);

            }
        });

        binding.buttonCarpma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MultiplicationActivity.class);
                int checkedIntentTime = checkedTimeFun();
                intent.putExtra("time", checkedIntentTime);
                startActivity(intent);
            }
        });

        binding.buttonToplama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdditionActivity.class);
                int checkedIntentTime = checkedTimeFun();
                intent.putExtra("time", checkedIntentTime);
                startActivity(intent);

            }
        });

    }

    public int checkedTimeFun() {
        int checkedTime = binding.sureSec.getCheckedRadioButtonId();
        switch (checkedTime) {
            case R.id.radioButton1:
                checkedTime = 30000;
                break;
            case R.id.radioButton2:
                checkedTime = 60000;
                break;
            case R.id.radioButton3:
                checkedTime = 90000;
                break;
            case R.id.radioButton4:
                checkedTime = 120000;
                break;
            default:
                checkedTime = 30000;
        }
        return checkedTime;






    }


}