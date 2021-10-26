package com.example.tutorial02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_temp;
    RadioButton rdBtn_C,rdBtn_F;
    Button btn_cal;
    TextView tv_ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_temp = findViewById(R.id.edt_temp);
        rdBtn_C = findViewById(R.id.rdBtn_C);
        rdBtn_F = findViewById(R.id.rdBtn_F);
        btn_cal = findViewById(R.id.btn_cal);
        tv_ans = findViewById(R.id.tv_ans);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {
        Calculations cal = new Calculations();
        String value = edt_temp.getText().toString();

        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Float temp = Float.parseFloat(value);
            if(rdBtn_C.isChecked()){
                temp = cal.convertCelciusToFahrenheit(temp);
            }
            else if (rdBtn_F.isChecked()){
                temp = cal.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this, "Select the radio button",
                        Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }

            tv_ans.setText(new Float(temp).toString());
        }
    }
}