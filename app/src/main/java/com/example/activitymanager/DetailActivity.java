package com.example.activitymanager;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity  {

    private EditText etReturnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();

       TextView text = findViewById(R.id.activity_detail_text);
       String data = getIntent().getStringExtra("data_from_main_activity");
       text.setText(data);

       etReturnData = findViewById(R.id.activity_detail_et_return_data);


       Button btnReturn = findViewById(R.id.activity_detail_btn_return_info);
       btnReturn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent returnIntent = new Intent();
               returnIntent.putExtra("return-data", etReturnData.getText().toString());
               setResult(Activity.RESULT_OK, returnIntent);
               finish();
           }
       });
    }

}
