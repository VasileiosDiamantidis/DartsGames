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
                startGamePassed();
            }
        });





    }

    private void startGamePassed() {





        if(playerList.size()<2){
            Context context = getApplicationContext();
            CharSequence text = "Minimum 2 players!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else {

            if(game.equals("301")||game.equals("501")||game.equals("701")){
                Intent intent=new Intent(this,game_701.class);
                intent.putExtra("LIST", (Serializable) playerList);
                intent.putExtra(EXTRA_MESSAGE,game);
                startActivity(intent);
            }else{
                if(game.equals("killer")){
                    Intent intent=new Intent(this,killer.class);
                    intent.putExtra("LIST", (Serializable) playerList);
                    intent.putExtra(EXTRA_MESSAGE,game);
                    startActivity(intent);
                }
            }

        }
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
