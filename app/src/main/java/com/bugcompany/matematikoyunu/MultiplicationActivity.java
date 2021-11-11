package com.bugcompany.matematikoyunu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bugcompany.matematikoyunu.databinding.ActivityMultiplicationBinding;

import java.util.Random;

public class MultiplicationActivity extends AppCompatActivity {

    private ActivityMultiplicationBinding binding;

    Random random = new Random();
    int number1, number2;
    int userAnswer, correctAnswer;
    int userScore = 0;
    int userLife = 3;
    CountDownTimer timer;
    int getCheckedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMultiplicationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        getCheckedTime = intent.getIntExtra("time", 0);

        gameContinue();
        startTimer();


        binding.buttonGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextString = binding.editTextCevap.getText().toString();
                if (editTextString.matches("")) {
                    return;

                } else {
                    userAnswer = Integer.parseInt(editTextString);
                    if (userAnswer == correctAnswer) {
                        userScore = userScore + 10;
                        binding.textViewScore.setText(" " + userScore);
                        binding.buttonGonder.setEnabled(false);
                        binding.editTextCevap.setText("");


                    } else {
                        userLife--;
                        binding.textViewKalanHak.setText("" + userLife);
                        binding.buttonGonder.setEnabled(false);
                        binding.editTextCevap.setText("");
                        userLifeControl();
                    }

                    binding.buttonGonder.setEnabled(true);
                    gameContinue();
                }


            }
        });


        binding.buttonPas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLife--;
                binding.textViewKalanHak.setText("" + userLife);
                userLifeControl();
                binding.editTextCevap.setText("");
                gameContinue();

            }
        });


    }


    private void gameContinue() {

        number1 = random.nextInt(20);
        number2 = random.nextInt(20);
        correctAnswer = number1 * number2;
        binding.textViewSoruAlani.setText(number1 + " *" + number2);

    }


    public void startTimer() {
        timer = new CountDownTimer(getCheckedTime, 1000) {
            @Override
            public void onTick(long l) {
                binding.textViewSure.setText("" + l / 1000);
            }

            @Override
            public void onFinish() {
                binding.textViewKalanHak.setText("" + userLife);
                binding.textViewSoruAlani.setText("Süre Bitti !");
                binding.buttonGonder.setEnabled(false);
                alertDialog();

            }
        }.start();
    }


    public void userLifeControl() {
        if (userLife <= 0) {
            timer.cancel();
            alertDialog();
        }
    }


    public void alertDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MultiplicationActivity.this);

        alert.setTitle("Oyun Bitti!");
        alert.setIcon(R.drawable.matematik_korku);
        alert.setMessage("Yeniden Oynamak ister misiniz?\nPuanınız: " + binding.textViewScore.getText());
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);


            }
        });

        alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        alert.setCancelable(false);


        alert.show();

    }
}