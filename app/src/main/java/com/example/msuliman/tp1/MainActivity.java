package com.example.msuliman.tp1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cnam.smb116.tp1.R;

public class MainActivity extends AppCompatActivity {

    private String onClickStart;
    private EditText editText;
    private int ID;
    private int LID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ID=getIntent().getIntExtra("activity_id",0);
        LID=getIntent().getIntExtra("last_activity_id",0);
        editText = (EditText) findViewById(R.id.editTextId);
        this.editText.append("onCreate"+ID+"\n");
        this.editText.append("onCreate - Last Act"+LID+"\n");
    }

    public void onClickStart(View v) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(onClickStart);
        alertDialog.setMessage("Starting a new activity, same code");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int qui

            ) {
                dialog.dismiss();
                Intent intent = new Intent(MainActivity.this, MainActivity.class); // create another activity with the same code
                intent.putExtra("activity_id",ID+1);
                intent.putExtra("last_activity_id",ID);
                startActivity(intent);
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void onClickFinish(View v) {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.editText.append("onStart\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.editText.append("onResume\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.editText.append("onPause\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.editText.append("onStop\n");
    }

}