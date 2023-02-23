package com.example.apppracme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DataRecieverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_reciever);

        Intent catchIntent = getIntent();
        TextView Nick = (TextView)findViewById(R.id.getNick);
        Nick.setText(catchIntent.getExtras().get("Nickname").toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent sendIntent = getIntent();
        TextView sendNick = (TextView)findViewById(R.id.getNick);
        sendIntent.putExtra("sendNickname", sendNick.getText());
    }
}