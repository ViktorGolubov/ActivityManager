package com.example.activitymanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

        Button btnLoad = findViewById(R.id.activity_main__btn__load);
        btnLoad.setOnClickListener(this);

        TextView tvTitle = findViewById(R.id.activity__main__tv__title);
        tvTitle.setOnClickListener(this);

        tvName = findViewById(R.id.activity__main__tv__name);
        tvName.setOnClickListener(this);


    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        String message = null;
        switch (v.getId()) {
            case R.id.activity_main__btn__load:
                message = "button clicked";
                tvName.setText("Hello world!");
                tvName.setBackgroundColor(getResources().getColor(R.color.viktorFavColor));
                break;
            case R.id.activity__main__tv__title:
                message = "title clicked";
                break;
            case R.id.activity__main__tv__name:
                message = "";
                break;
                default:

        }

        if (message != null) {

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
