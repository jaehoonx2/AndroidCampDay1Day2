package com.tistory.jaehoonx2.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParkingActivity extends AppCompatActivity {

    TextView tv;
    EditText e1, e2;
    Button bin, bout, b1, b2, b3, b4;
    int current = 1;

    TextView tname[] = new TextView[4];
    int tnameid[] = {R.id.txtCarName1, R.id.txtCarName2, R.id.txtCarName3, R.id.txtCarName4};

    TextView tNum[] = new TextView[4];
    int tNumid[] = {R.id.txtCarNo1, R.id.txtCarNo2, R.id.txtCarNo3, R.id.txtCarNo4};

    TextView tTime[] = new TextView[4];
    int tTimeid[] = {R.id.txtInTime1, R.id.txtInTime2, R.id.txtInTime3, R.id.txtInTime4};

    CarInfo carInfo[] = new CarInfo[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);

        setTitle("주차관리");

        tv = (TextView)findViewById(R.id.txtposno);
        e1 = (EditText)findViewById(R.id.et1);
        e2 = (EditText)findViewById(R.id.et2);

        bin = (Button)findViewById(R.id.txtin);
        bout = (Button)findViewById(R.id.txtout);


        for (int i = 0; i < 4; i++){
            tname[i] = (TextView)findViewById(tnameid[i]);
            tNum[i] = (TextView)findViewById(tNumid[i]);
            tTime[i] = (TextView)findViewById(tTimeid[i]);
            carInfo[i] = new CarInfo();
        }
    }
    public void onInOut(View v){
        if(v.getId() == R.id.txtin){
            carInfo[current - 1].setIn(e1.getText().toString(), e2.getText().toString());
            tname[current - 1].setText("차종류 : " + carInfo[current - 1].getCarName());
            tNum[current - 1].setText("차번호 : " + carInfo[current - 1].getCarNo());
            tTime[current - 1].setText("입차시간 : " + carInfo[current - 1].getInTimeTxt());
            e1.setText("");
            e2.setText("");
        }
        if(v.getId() == R.id.txtout){
            Toast.makeText(getApplicationContext(),carInfo[current - 1].setOut(),Toast.LENGTH_LONG).show();
            tname[current - 1].setText("차종류 : " + carInfo[current - 1].getCarName());
            tNum[current - 1].setText("차번호 : " + carInfo[current - 1].getCarNo());
            tTime[current - 1].setText("입차시간 : " + carInfo[current - 1].getInTimeTxt());
        }
    }
    public void onSelect(View v){
        if(v.getId() == R.id.btn1){
            current = 1;
        }
        if(v.getId() == R.id.btn2){
            current = 2;
        }
        if(v.getId() == R.id.btn3){
            current = 3;
        }
        if(v.getId() == R.id.btn4){
            current = 4;
        }
        tv.setText(current + "번");
        if (carInfo[current - 1].getInTime() != 0){
            bin.setEnabled(false);
            bout.setEnabled(true);
        }
        else{
            bin.setEnabled(true);
            bout.setEnabled(false);
        }
    }
}
