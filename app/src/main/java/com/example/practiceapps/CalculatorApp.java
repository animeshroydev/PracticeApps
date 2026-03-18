package com.example.practiceapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorApp extends AppCompatActivity {

    double firstNum = 0;
    String operator = "";
    boolean isOperatorClicked = false;

    private EditText editTxtInput;
    private Button acBtn, modBtn, delBtn, divBtn, btn7, btn8, btn9,
            btnMulti, btnFour, btnFive, btnSix, btnMinus, btnOne, btnTwo,
            btnThree, btnPlus, btnZeroZero, btnZero, btnDot, btnEqual;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_calculator_app);

        acBtn = findViewById(R.id.acBtn);
        btnEqual = findViewById(R.id.btnEqual);
        btnPlus = findViewById(R.id.btnPlus);
        modBtn = findViewById(R.id.modBtn);
        delBtn = findViewById(R.id.delBtn);
        editTxtInput = findViewById(R.id.editTxtInput);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnZero = findViewById(R.id.btnZero);
        btnZeroZero = findViewById(R.id.btnZeroZero);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);
        btnMulti = findViewById(R.id.btnMulti);



        acBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.setText("");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btn7.getText().toString());
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btn8.getText().toString());
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btn9.getText().toString());
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btnFour.getText().toString());
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btnFive.getText().toString());
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btnSix.getText().toString());
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btnOne.getText().toString());
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btnTwo.getText().toString());
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btnThree.getText().toString());
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btnZero.getText().toString());
            }
        });

        btnZeroZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTxtInput.append(btnZeroZero.getText().toString());
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTxtInput.getText().toString().contains(".")) {
                    editTxtInput.append(btnDot.getText().toString());
                }
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = editTxtInput.getText().toString();
                if (!val.isEmpty()) {
                    editTxtInput.setText(val.substring(0, val.length() - 1));
                }
            }
        });

        modBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = editTxtInput.getText().toString();

                if (!value.isEmpty() && !operator.isEmpty()) {

                    double secondNum = Double.parseDouble(value);
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = firstNum + secondNum;
                            break;
                        case "-":
                            result = firstNum - secondNum;
                            break;
                        case "*":
                            result = firstNum * secondNum;
                            break;
                        case "/":
                            if (secondNum != 0) {
                                result = firstNum / secondNum;
                            } else {
                                Toast.makeText(CalculatorApp.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            break;
                    }
                    editTxtInput.setText(String.valueOf(result));

                    // Reset state
                    operator = "";
                    isOperatorClicked = false;
                    firstNum = 0;
                }
            }

        });

        btnPlus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String value = editTxtInput.getText().toString();

                if (!value.isEmpty()) {
                    firstNum = Double.parseDouble(value);
                    operator = "+";
                    isOperatorClicked = true;
                    editTxtInput.setText("");
                }

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}