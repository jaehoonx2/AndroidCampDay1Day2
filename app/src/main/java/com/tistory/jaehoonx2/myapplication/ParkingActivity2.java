package com.tistory.jaehoonx2.myapplication;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParkingActivity2 extends AppCompatActivity {

    int current = 1;

    Button in[] = new Button[4];
    int inid[] = {R.id.in1, R.id.in2, R.id.in3, R.id.in4};

    Button out[] = new Button[4];
    int outid[] = {R.id.out1, R.id.out2, R.id.out3, R.id.out4};

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
        setContentView(R.layout.activity_parking2);

        setTitle("더 나은 주차장");

        for (int i = 0; i < 4; i++){
            tname[i] = (TextView)findViewById(tnameid[i]);
            tNum[i] = (TextView)findViewById(tNumid[i]);
            tTime[i] = (TextView)findViewById(tTimeid[i]);
            carInfo[i] = new CarInfo();

            in[i] = (Button) findViewById(inid[i]);
            out[i] = (Button) findViewById(outid[i]);
        }
    }
    public void onInOut(View v){
        switch (v.getId())
        {
            case R.id.in1 :
                current = 1;
                dialog(current);
                break;
            case R.id.in2 :
                current = 2;
                dialog(current);
                break;
            case R.id.in3 :
                current = 3;
                dialog(current);
                break;
            case R.id.in4 :
                current = 4;
                dialog(current);
                break;
        }

        switch (v.getId())
        {
            case R.id.out1 :
                current = 1;
                carOut(current); break;
            case R.id.out2 :
                current = 2;
                carOut(current); break;
            case R.id.out3 :
                current = 3;
                carOut(current); break;
            case R.id.out4 :
                current = 4;
                carOut(current); break;
        }
    }

    public void dialog(final int current){
        View dlgview = View.inflate(this, R.layout.dialog_parking, null);
        final EditText carName = (EditText) dlgview.findViewById(R.id.carName);
        carName.setBackgroundColor(Color.GREEN);
        final EditText carNo = (EditText) dlgview.findViewById(R.id.carNo);
        carNo.setBackgroundColor(Color.GREEN);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("차 정보 입력창");
        dlg.setView(dlgview);
        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                carInfo[current - 1].setIn(carName.getText().toString(), carNo.getText().toString());
                tname[current - 1].setText("차종류 : " + carInfo[current - 1].getCarName());
                tNum[current - 1].setText("차번호 : " + carInfo[current - 1].getCarNo());
                tTime[current - 1].setText("입차시간 : " + carInfo[current - 1].getInTimeTxt());
            }
        });
        dlg.show();
    }

    public void carOut(int current){
        Toast.makeText(getApplicationContext(),carInfo[current - 1].setOut(),Toast.LENGTH_LONG).show();
        tname[current - 1].setText("차종류 : " + carInfo[current - 1].getCarName());
        tNum[current - 1].setText("차번호 : " + carInfo[current - 1].getCarNo());
        tTime[current - 1].setText("입차시간 : " + carInfo[current - 1].getInTimeTxt());
    }
}
