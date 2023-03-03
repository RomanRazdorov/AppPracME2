package com.example.apppracme2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    EditText nickname;
    EditText fname;
    EditText sname;
    EditText email;
    ActivityResultLauncher<Intent> dataRecieverActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK){
                    Intent data = result.getData();
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nickname = (EditText)findViewById(R.id.nickname);
        fname = (EditText)findViewById(R.id.name);
        sname = (EditText)findViewById(R.id.surname);
        email = (EditText)findViewById(R.id.email);

        TextView loadTitle = (TextView)findViewById(R.id.regscrn);
        loadTitle.setText(R.string.title);
        ImageView loadPicture = (ImageView)findViewById(R.id.catgif);
        loadPicture.setImageResource(R.drawable.catgif);
        Button btnReg = (Button) findViewById(R.id.btnreg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DataRecieverActivity.class);
                intent.putExtra("Nickname", nickname.getText().toString());
                intent.putExtra("FName", fname.getText().toString());
                intent.putExtra("SName", sname.getText().toString());
                intent.putExtra("Email", email.getText().toString());
                dataRecieverActivityResultLauncher.launch(intent);
                Log.i("MainActivity", "Data transferred");
            }
        });
    }
}