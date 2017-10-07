package com.example.bmicalculater;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText mHeightEditText;
    private EditText mWeightEditText;
    private Button mCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeightEditText = (EditText) findViewById(R.id.height_edit_Text);
        mWeightEditText = (EditText) findViewById(R.id.weight_edit_Text);
        mCalculateButton = (Button) findViewById(R.id.calculate_button);


        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightText = mHeightEditText.getText().toString();

                Double height = Double.valueOf(heightText);

                String weightText = mWeightEditText.getText().toString();
                Double weight = Double.valueOf(weightText);

                Double bmi = weight / ((height/100) * (height / 100));


                String bmiText = getBmiText(bmi);


                String result = "ค่า BMI ที่ได้ คือ " + String.valueOf(String.format("%.1f",bmi))+"\n\nอยู่ในเกรณฑ์ : "+bmiText;

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //โค้ดที่ต้องการให้ทำงาน เมื่อปุ่ม OK ในไดอะล็อกถูกคลิก
                       // finish();
                        mHeightEditText.setText(" ");
                        mWeightEditText.setText(" ");
                    }
                });
                dialog.show();
        };

    });
}

    private String getBmiText(Double bmi) {
        String bmiText = "";
        if(bmi < 18.5){
            bmiText  = "น้ำหนักน้อยกว่าปกติ";
        }else if(bmi <25){
            bmiText  = "น้ำหนักปกติ";
        }else if(bmi<30){
            bmiText = "น้ำหนักมากกว่าปกติ(ท้วม)";
        }else{
            bmiText = "น้ำหนักมากกว่าปกติ(อ้วน)";
        }
        return bmiText;
    }
}