package com.example.vdiamant.dartsgames;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vdiamant.dartsgames.model.Player;

import java.util.List;

public class game_701 extends AppCompatActivity {


    List<Player> players;
    Player whoIsPlaying;
    int maxDarts=3;
    int playingDartsLeft=3;
    int numberOfPlayer=0;
    int gamePoints;
    String game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_701);

       // Bundle bundle = getIntent().getExtras();
        //List<Player> pl = bundle.getParcelable("data");

        //android.support.v7.widget.AppCompatTextView playerName=(android.support.v7.widget.AppCompatTextView)findViewById(R.id.pName);
        //EditText eText=(EditText) findViewById(R.id.editText);
        //eText.setText(pl.get(0).getName());
        //playerName.setText(pl.get(0).getName());

        Intent myIntent = getIntent();
        players = (List<Player>) myIntent.getSerializableExtra("LIST");
        game=myIntent.getStringExtra(DartsGames.EXTRA_MESSAGE);
        gamePoints=Integer.parseInt(game);
        EditText eText=(EditText) findViewById(R.id.editText);
        whoIsPlaying=players.get(0);
        TextView txtView=(TextView)findViewById(R.id.textView2);
        txtView.setText(game);
        eText.setText(whoIsPlaying.getName());
        setOterPlayers();
        initialize();
        setFirstInPointsTop();


        for (int i = 0; i < 21; i++) {
            int id = getResources().getIdentifier("soo" + i, "id", getPackageName());
            final Button btn = (Button) findViewById(id);
            btn.setBackgroundColor(Color.parseColor("#00AA72"));
            btn.setPadding(3,3,3,3);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    points(Integer.parseInt(btn.getText().toString()));
                }
            });

        }

        Button btn = (Button) findViewById(R.id.x2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xTwo();
            }
        });
        btn = (Button) findViewById(R.id.x3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xThree();
            }
        });

        btn=(Button)findViewById(R.id.clear);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFunc();
            }
        });

        btn=(Button)findViewById(R.id.ok);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okFunc();
            }
        });




    }



    /*private void points(View v){
        EditText eText=(EditText) findViewById(R.id.editText);
        //String txt=v.toString();
        int num= getInteger(txt)+0;
        eText.setText(num);
        //eText.setText();
    }*/

    private void points(Integer number){
        EditText eText=(EditText) findViewById(R.id.editText);
        eText.setText(number.toString());
        //eText.setText();
    }

    private  void xTwo(){
        EditText eText=(EditText) findViewById(R.id.editText);
        Integer num= (Integer.parseInt(eText.getText().toString()))*2;
        eText.setText(num.toString());
    }

    private  void xThree(){
        EditText eText=(EditText) findViewById(R.id.editText);
        Integer num= (Integer.parseInt(eText.getText().toString()))*3;
        eText.setText(num.toString());
    }

    private void clearFunc(){
        EditText eText=(EditText) findViewById(R.id.editText);
        eText.setText("");
    }

    private void okFunc(){
        EditText eText=(EditText) findViewById(R.id.editText);
        whoIsPlaying.setPoints(whoIsPlaying.getPoints()+(Integer.parseInt(eText.getText().toString())));
        System.out.println(whoIsPlaying.getPoints());
        if(whoIsPlaying.getPoints()>=gamePoints){
            myFinish();
        }
        playingDartsLeft--;
        if(playingDartsLeft==0){
            playingDartsLeft=maxDarts;
            numberOfPlayer++;
            if(numberOfPlayer>(players.size()-1)){
                numberOfPlayer=0;
            }
            whoIsPlaying=players.get(numberOfPlayer);

        }
        initialize();
        setOterPlayers();
        setFirstInPointsTop();
        eText.setText("");
    }



    private void setOterPlayers(){
        View linearLayout =  findViewById(R.id.myListOfOtherPlayer);
        ((LinearLayout) linearLayout).removeAllViews();

        for(int i=0;i<players.size();i++){
            if(players.get(i).getName().equalsIgnoreCase(whoIsPlaying.getName())==false){
                String tmpStirng=players.get(i).getName()+" "+players.get(i).getPoints();
                TextView tmpTextView=new TextView(this);
                tmpTextView.setText(tmpStirng);
                tmpTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                ((LinearLayout) linearLayout).addView(tmpTextView);
            }
        }

    }


    private void initialize(){
        TextView tempTextView=(TextView) findViewById(R.id.pName);
        tempTextView.setText("Playing Now: "+whoIsPlaying.getName().toString());
        tempTextView=(TextView) findViewById(R.id.pPoints);
        tempTextView.setText("Points: "+String.valueOf(whoIsPlaying.getPoints()));
        tempTextView=(TextView) findViewById(R.id.pDartsLeft);
        tempTextView.setText("Darts Left: "+String.valueOf(playingDartsLeft));


    }


    private void setFirstInPointsTop(){
        Player first=players.get(0);
        for(int i=1;i<players.size();i++){
            if(players.get(i).getPoints()>first.getPoints()){
                first=players.get(i);
            }

        }
        TextView firstTextView=(TextView)findViewById(R.id.firstInPoints);
        firstTextView.setText(first.getName()+" "+first.getPoints());
    }

    private void myFinish(){
        System.out.print("Finish");
    }

}
