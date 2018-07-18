package com.tistory.jaehoonx2.myapplication;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {

    int selectedMemoIndex;
    Memo memo1, memo2, memo3;

    Button button1, button2, button3, new_memo, save;
    EditText title, content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        init();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMemo(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMemo(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMemo(3);
            }
        });

        new_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MEMO", "b_new.setOnClickListener");
                clickMemo(0);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memo_title = title.getText().toString();
                String memo_content = content.getText().toString();

                Snackbar.make(v, "메모가 저장되었습니다.", Snackbar.LENGTH_SHORT).show();

                if(selectedMemoIndex == 1){
                    memo1.setTitle(memo_title);
                    memo1.setContent(memo_content);
                } else if (selectedMemoIndex == 2){
                    memo2.setTitle(memo_title);
                    memo2.setContent(memo_content);
                } else if (selectedMemoIndex == 3){
                    memo3.setTitle(memo_title);
                    memo3.setContent(memo_content);
                }

                Toast.makeText(MemoActivity.this, "[메모 " + selectedMemoIndex + "] 에 저장되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void init(){
        memo1 = new Memo();
        memo2 = new Memo();
        memo3 = new Memo();

        button1 =(Button)findViewById(R.id.button1);
        button2 =(Button)findViewById(R.id.button2);
        button3 =(Button)findViewById(R.id.button3);
        title =(EditText)findViewById(R.id.title);
        content =(EditText)findViewById(R.id.content);
        new_memo  =(Button) findViewById(R.id.new_memo);
        save =(Button) findViewById(R.id.save);
    }

    public void clickMemo(int no){

        selectedMemoIndex = no;

        if(selectedMemoIndex == 1){
            title.setText(memo1.getTitle());
            content.setText(memo1.getContent());
            title.requestFocus();
        }
        else if(selectedMemoIndex == 2){
            title.setText(memo2.getTitle());
            content.setText(memo2.getContent());
            title.requestFocus();
        }
        else if(selectedMemoIndex == 3){
            title.setText(memo3.getTitle());
            content.setText(memo3.getContent());
            title.requestFocus();
        }
        else {
            title.setText("");
            content.setText("");
            title.requestFocus();
        }

        if(no > 0){
            save.setText("[메모 " + no + "] 저장");
        }

    }
}