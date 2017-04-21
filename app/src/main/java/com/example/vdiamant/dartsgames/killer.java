package com.example.vdiamant.dartsgames;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vdiamant.dartsgames.model.Player;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

public class killer extends AppCompatActivity implements ucAddPoints.ucAddPointsListener,ucShowPlayerPoints.ucShowPlayerListener{

    List<Player> players;

    int gamePoints;
    String game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_killer);

        Intent myIntent = this.getIntent();
        players = (List<Player>) myIntent.getSerializableExtra("LIST");
        game=myIntent.getStringExtra(DartsGames.EXTRA_MESSAGE);
        gamePoints=300;

        firstInitialization(players,game,gamePoints);
        /*
        Intent myIntent = getIntent();
        players = (List<Player>) myIntent.getSerializableExtra("LIST");
        game=myIntent.getStringExtra(DartsGames.EXTRA_MESSAGE);
        gamePoints=Integer.parseInt(game);

        //setOterPlayers();
        //initialize();
        //setFirstInPointsTop();
        */


    }

    @Override
    public void addPoints(int points) {
        //this is called when the user clicks the ok Button

        //An eixame 2o fragment
        //OnomaDeuterouFragment btmFragment=(OnomaDeuterouFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2); //to fragment2 einai apo thn xml toy killer
        //btmFragment.methodos();

    }

    @Override
    public void firstInitialization(List<Player> tmpplayers, String tmpgame, int tmpfgamePoints) {
        ucShowPlayerPoints showStatsFragment=(ucShowPlayerPoints)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        showStatsFragment.firstInitialization(tmpplayers,tmpgame,tmpfgamePoints);
    }
}
