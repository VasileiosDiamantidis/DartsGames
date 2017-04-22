package com.example.vdiamant.dartsgames.Games;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vdiamant.dartsgames.DartsGames;
import com.example.vdiamant.dartsgames.Fragments.ucAddPoints;
import com.example.vdiamant.dartsgames.Fragments.ucShowPlayerPoints;
import com.example.vdiamant.dartsgames.R;
import com.example.vdiamant.dartsgames.model.Player;

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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void addPoints(int points) {

        //this is called when the user clicks the ok Button

        //An eixame 2o fragment
        ucShowPlayerPoints showPointsF=(ucShowPlayerPoints)getSupportFragmentManager().findFragmentById(R.id.fragment2); //to fragment2 einai apo thn xml toy killer
        showPointsF.addPoints(points);
        showPointsF.initialize();
        showPointsF.setOterPlayers();
        showPointsF.setFirstInPointsTop();
        //initialize();
        //setOterPlayers();
        //setFirstInPointsTop();

    }


    @Override
    public void firstInitialization(List<Player> tmpplayers, String tmpgame, int tmpfgamePoints) {
        ucShowPlayerPoints showStatsFragment=(ucShowPlayerPoints)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        showStatsFragment.firstInitialization(tmpplayers,tmpgame,tmpfgamePoints);
    }
}
