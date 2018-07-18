package com.tistory.jaehoonx2.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    LinearLayout linear;
    ImageView image;
    TextView text;
    int rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        linear = (LinearLayout) findViewById(R.id.linearBG);
        image = (ImageView) findViewById(R.id.image);
        text = (TextView) findViewById(R.id.text);

        rotate = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);  //xml을 뻥튀기해서 뷰로 만들어주는 함수
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnuRed :
                linear.setBackgroundColor(Color.RED); break;

            case R.id.mnuBlue :
                linear.setBackgroundColor(Color.BLUE); break;

            case R.id.mnuYellow :
                linear.setBackgroundColor(Color.YELLOW); break;

            case R.id.mnuRotate :
                if(rotate < 360)
                    rotate += 30;
                else
                    rotate = 30;

                image.setRotation(rotate); break;

            case R.id.mnuSizeup :
                if(item.isChecked())
                {
                    item.setChecked(false);
                    image.setScaleX(1);
                    image.setScaleY(1);
                }
                else {
                    item.setChecked(true);
                    image.setScaleX(2);
                    image.setScaleY(2);
                }

                break;

            case R.id.mnuTitle :
                if(item.isChecked())
                {
                    item.setChecked(false);
                    text.setVisibility(View.INVISIBLE);
                }
                else {
                    item.setChecked(true);
                    text.setVisibility(View.VISIBLE);
                }

                break;

            case R.id.mnuChicken :
                image.setImageResource(R.drawable.chicken);
                item.setChecked(true);
                text.setText("겁나 맛있는 치킨"); break;

            case R.id.mnuSpa :
                image.setImageResource(R.drawable.spaghetti);
                item.setChecked(true);
                text.setText("겁나 맛있는 스파게티"); break;
        }

        return super.onOptionsItemSelected(item);
    }
}
