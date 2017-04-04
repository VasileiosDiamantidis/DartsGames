package com.example.vdiamant.dartsgames;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DartsGames extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.vdiamant.dartsgame.DartsGames";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darts_games);
        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                simpleSumGame("701");
            }
        });

        btn=(Button)findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                simpleSumGame("501");
            }
        });

        btn=(Button)findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                simpleSumGame("301");
            }
        });

        btn=(Button)findViewById(R.id.button6);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                killer();
            }
        });



    }

    public void simpleSumGame(String game){
        Intent intent=new Intent(this,AddPlayers.class);
        intent.putExtra(EXTRA_MESSAGE,game);
        startActivity(intent);
    }

    public void killer(){
        Intent intent=new Intent(this,AddPlayers.class);
        intent.putExtra(EXTRA_MESSAGE,"killer");
        startActivity(intent);
    }



}
