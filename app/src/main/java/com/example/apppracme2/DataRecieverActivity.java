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

    TextView Nick;
    TextView Names;
    TextView Surnames;
    TextView Emails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_reciever);

        Nick = (TextView)findViewById(R.id.getNick);
        Names = (TextView) findViewById(R.id.getName);
        Surnames = (TextView)findViewById(R.id.getSurname);
        Emails = (TextView)findViewById(R.id.getEmail);

        Intent catchIntent = getIntent();
        Nick.setText(catchIntent.getExtras().get("Nickname").toString());
        Names.setText(catchIntent.getExtras().get("FName").toString());
        Surnames.setText(catchIntent.getExtras().get("SName").toString());
        Emails.setText(catchIntent.getExtras().get("Email").toString());
    }

    public void onClickLog(View view) {

        Log.i("DataRecieverActivity", "Data Recieved");
        Intent intent = new Intent();
        intent.putExtra("Nickname",Nick.getText().toString());
        intent.putExtra("FName",Names.getText().toString());
        intent.putExtra("SName",Surnames.getText().toString());
        intent.putExtra("Email",Emails.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}