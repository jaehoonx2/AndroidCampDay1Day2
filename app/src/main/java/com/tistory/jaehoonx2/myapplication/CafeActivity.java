package com.tistory.jaehoonx2.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CafeActivity extends AppCompatActivity {

    EditText e1, e2, e3;
    CheckBox c1;
    Button button;
    TextView t1, t2, t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        e1 = (EditText) findViewById(R.id.edit1);
        e2 = (EditText) findViewById(R.id.edit2);
        e3 = (EditText) findViewById(R.id.edit3);

        c1 = (CheckBox) findViewById(R.id.checkBox);
        button = (Button) findViewById(R.id.button);

        t1 = (TextView) findViewById(R.id.textResult1);
        t2 = (TextView) findViewById(R.id.textResult2);
        t3 = (TextView) findViewById(R.id.textResult3);

        Log.d("CAFE", "==> onCreate()");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 커피 개수를 가져온다
                String count1 = e1.getText().toString();
                int icount1 = Integer.parseInt(count1);

                String count2 = e2.getText().toString();
                int icount2 = Integer.parseInt(count2);

                String count3 = e3.getText().toString();
                int icount3 = Integer.parseInt(count3);

                // 주문 개수 만든다.
                int count = icount1 + icount2 + icount3;

                // 총 금액 만든다.
                int total = (icount1*1000) + (icount2*1500) + (icount3*1700);

                // 멤버십이 선택됐는지 알아온다.
                // 할인 금액 만든다.
                int discount;

                if(c1.isChecked()){
                    discount = total/10;
                }
                else {
                    discount = 0;
                    }

                // 화면에 보여준다.
                t1.setText("주문개수 : " + count + " 개");
                t2.setText("할인금액 : " + discount + " 원");
                t3.setText("결제금액 : " + (total-discount) + " 원");

            }
        });
    }
}
