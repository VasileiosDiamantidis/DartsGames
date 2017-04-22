package com.example.vdiamant.dartsgames;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import com.example.vdiamant.dartsgames.Functions.simpleFunctions;
import com.example.vdiamant.dartsgames.Games.game_701;
import com.example.vdiamant.dartsgames.Games.killer;
import com.example.vdiamant.dartsgames.model.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.vdiamant.dartsgames.DartsGames.EXTRA_MESSAGE;

public class AddPlayers extends AppCompatActivity {


    String game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        Intent intent=getIntent();
        game=intent.getStringExtra(EXTRA_MESSAGE);
        System.out.print("The game is: "+game);
        Button add =(Button) findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addP();
            }
        });

        Button start=(Button)findViewById(R.id.button3);
        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openGame(game,playerList);

            }
        });





    }

    private void openGame(String game, List<Player> playerList) {
        simpleFunctions sf=new simpleFunctions(this);
        sf.startGamePassed(game,playerList);
    }


    List<Player> playerList=new ArrayList<Player>();

    private  void addP(){
        EditText tview=(EditText) findViewById(R.id.tView);
        Player tmpPlayer=new Player(tview.getText().toString());
        tview.setText("");


        playerList.add(tmpPlayer);


        View linearLayout =  findViewById(R.id.llayout);
        //LinearLayout layout = (LinearLayout) findViewById(R.id.info);

        TextView valueTV = new TextView(this);
        valueTV.setText(tmpPlayer.getName());
        valueTV.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

        ((LinearLayout) linearLayout).addView(valueTV);


    }
}
