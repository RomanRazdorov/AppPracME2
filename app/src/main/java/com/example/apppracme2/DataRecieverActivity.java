package com.example.apppracme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DataRecieverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_reciever);

               Intent catchIntent = getIntent();
        TextView Nick = (TextView)findViewById(R.id.getNick);
        TextView Names = (TextView) findViewById(R.id.getName);
        TextView Surnames = (TextView)findViewById(R.id.getSurname);
        TextView Emails = (TextView)findViewById(R.id.getEmail);

        Nick.setText(catchIntent.getExtras().get("Nickname").toString());
        Names.setText(catchIntent.getExtras().get("FName").toString());
        Surnames.setText(catchIntent.getExtras().get("SName").toString());
        Emails.setText(catchIntent.getExtras().get("Email").toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent sendIntent = getIntent();
        TextView sendNick = (TextView)findViewById(R.id.getNick);
        TextView sendName = (TextView)findViewById(R.id.getName);
        TextView sendSurname = (TextView)findViewById(R.id.getSurname);
        TextView sendEmail = (TextView)findViewById(R.id.getEmail);

        sendIntent.putExtra("sendNickname", sendNick.getText());
        sendIntent.putExtra("sendName", sendName.getText());
        sendIntent.putExtra("sendSurname", sendSurname.getText());
        sendIntent.putExtra("sendEmail", sendEmail.getText());
    }

    public void onClickLog(View view) {
        Log.i("DataRecieverActivity", "Data Recieved");
    }
}