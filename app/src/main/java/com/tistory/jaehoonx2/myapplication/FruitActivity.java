package com.tistory.jaehoonx2.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class FruitActivity extends AppCompatActivity {
    //1. 데이터를 만든다.
    //String data[] = {"사과", "수박", "복숭아"};
    ArrayList<String> data =new ArrayList<String>();
    //2. 어댑터를 만든다.(데이터, 레이아웃)
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        setTitle("과일목록");

        data.add("사과");
        data.add("복숭아");
        data.add("딸기");

        editText = (EditText) findViewById(R.id.editText);
        //3. 어댑터 위젯을 생성한다.
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data); //default layout
        //4. 위젯에 어댑터를 꽂는다.
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    deleteDialog(position);
            }
        });
    }

    public void deleteDialog(final int position){   //final!!!!!!!!!
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("삭제")
                .setMessage("삭제하겠습니까?")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //1.데이터 지운다
                        data.remove(position);
                        //2. 어댑터한테 통보
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("취소", null)
                .show();
    }

    public void onClick(View v){
        //1. 데이터 가져온다
        String one = editText.getText().toString();
        data.add(one);
        //2. 어댑터한테 통보
        adapter.notifyDataSetChanged();
    }
}
