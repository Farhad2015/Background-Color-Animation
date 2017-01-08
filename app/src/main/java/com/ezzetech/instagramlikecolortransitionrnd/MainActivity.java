package com.ezzetech.instagramlikecolortransitionrnd;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import cn.zhaiyifan.rememberedittext.RememberEditText;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    AnimationDrawable anim;
    Button buttonGoSecondActivity;

    RememberEditText rememberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);
        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);

        rememberEditText = (RememberEditText)findViewById(R.id.username);
        buttonGoSecondActivity = (Button)findViewById(R.id.btnGoSecondActivity);
        buttonGoSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = rememberEditText.getText().toString();
                Toast.makeText(getApplicationContext(),data, Toast.LENGTH_SHORT).show();
                rememberEditText.setText("");
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }
}
