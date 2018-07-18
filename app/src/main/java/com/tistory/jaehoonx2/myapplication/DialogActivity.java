package com.tistory.jaehoonx2.myapplication;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {
    int selectedMenuIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        setTitle("대화상자");
    }

    public void onClick(View v){
        if(v.getId() == R.id.button){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this); //getApplication(), this, DialogActivity.this
            dlg.setTitle("기본대화상자");
            dlg.setIcon(R.mipmap.ic_launcher);
            dlg.setMessage("이것은 기본 대화상자입니다.");
            dlg.setNegativeButton("닫기", null);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "확인을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.show();
        }
        if(v.getId() == R.id.button1){
            final String data[] = {"치킨", "스파게티"};
            AlertDialog.Builder dlg = new AlertDialog.Builder(this); //getApplication(), this, DialogActivity.this
            dlg.setTitle("라디오대화상자");
            dlg.setIcon(R.mipmap.ic_launcher);
            dlg.setSingleChoiceItems(data, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    selectedMenuIndex = which;
                }
            });
            dlg.setNegativeButton("닫기", null);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), data[selectedMenuIndex] + "을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.show();
        }
        if(v.getId() == R.id.button2){
            final String hobby[] = {"피아노", "독서", "영화보기", "코딩하기"};
            final boolean checked[] = {true, true, false, false};
            AlertDialog.Builder dlg = new AlertDialog.Builder(this); //getApplication(), this, DialogActivity.this
            dlg.setTitle("취미를 고르세요");
            dlg.setMultiChoiceItems(hobby, checked, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    checked[which] = isChecked;
                    if(isChecked)
                        Toast.makeText(getApplicationContext(), hobby[which] + "가 체크되었습니다.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), hobby[which] + "가 체크 해제되었습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.setPositiveButton("선택완료", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String str = "";
                    for(int i = 0; i < checked.length; i++)
                        if(checked[i]) str += " " + hobby[i];

                    Toast.makeText(getApplicationContext(),str + "을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.show();
        }
        if(v.getId() == R.id.button3){
            View dlgview = View.inflate(this, R.layout.dialog, null);
            final EditText et1 = (EditText) dlgview.findViewById(R.id.editText);          // 완전 중요
            et1.setBackgroundColor(Color.BLUE);
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);        //getApplication(), this, DialogActivity.this
            dlg.setTitle("사용자정의 대화상자");
            dlg.setView(dlgview);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),
                            et1.getText().toString() + "을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.show();
        }
    }


}
