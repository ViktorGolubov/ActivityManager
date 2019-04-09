package com.example.activitymanager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName;
    private EditText etInput;


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

        etInput = findViewById(R.id.activity__main__et_input);
        etInput.setOnClickListener(this);

        Button btnLaunch = findViewById(R.id.activity_main__btn__launch);
        btnLaunch.setOnClickListener(this);
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

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View v) {

        String message = null;
        switch (v.getId()) {
            case R.id.activity_main__btn__load:
                message = "button clicked";

                String string = etInput.getText().toString();
                tvName.setText(string);
                tvName.setBackgroundColor(getResources().getColor(R.color.viktorFavColor));
                break;
            case R.id.activity__main__tv__title:
                message = "title clicked";
                break;
            case R.id.activity__main__tv__name:
                message = "";
                break;
            case R.id.activity_main__btn__launch:
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra("data_from_main_activity", tvName.getText());
                //startActivity(intent);
                startActivityForResult(intent,101);
                break;
                default:


        }

        if (message != null) {

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data_from_edit-text",etInput.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        tvName.setText(inState.getString("data_from_edit-text"));
        tvName.setBackgroundColor(getResources().getColor(R.color.viktorFavColor));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == Activity.RESULT_OK && data != null) {
            String returnData = data.getStringExtra("return-data");
            Toast.makeText(this, "Data returned:" + returnData, Toast.LENGTH_SHORT).show();
        }
    }
}
