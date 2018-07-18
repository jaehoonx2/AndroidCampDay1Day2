package com.tistory.jaehoonx2.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    EditText pizza, spaghetti, salad;
    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    ImageView imageView;
    Button button;
    TextView textResult1, textResult2, textResult3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_picture();
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_picture();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count1 = pizza.getText().toString();
                int icount1 = Integer.parseInt(count1);

                String count2 = spaghetti.getText().toString();
                int icount2 = Integer.parseInt(count2);

                String count3 = salad.getText().toString();
                int icount3 = Integer.parseInt(count3);

                // 주문 개수 만든다.
                int count = icount1 + icount2 + icount3;

                // 총 금액 만든다.
                int total = (icount1*16000) + (icount2*11000) + (icount3*4000);

                // 멤버십이 선택됐는지 알아온다.
                // 할인 금액 만든다.
                int discount;

                if(checkBox.isChecked()){
                    discount = total*7/100;
                    total -= discount;
                }
                else {
                    discount = 0;
                }

                // 화면에 보여준다.
                textResult1.setText("주문개수 : " + count + " 개");
                textResult2.setText("주문금액 : " + total + " 원");
            }
        });
    }

    public void init(){
        pizza = (EditText) findViewById(R.id.pizza);
        spaghetti = (EditText) findViewById(R.id.spaghetti);
        salad = (EditText) findViewById(R.id.salad);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        textResult1 = (TextView) findViewById(R.id.textResult1);
        textResult2 = (TextView) findViewById(R.id.textResult2);
        textResult3 = (TextView) findViewById(R.id.textResult3);

        radioButton1.setChecked(true);
        show_picture();
    }

    public void show_picture(){
        if(radioButton1.isChecked()){
            imageView.setImageResource(R.drawable.pickle);
            textResult3.setText("피클 선택하셨습니다.");
        } else if (radioButton2.isChecked()){
            imageView.setImageResource(R.drawable.source);
            textResult3.setText("소스 선택하셨습니다.");
        }
    }
}
