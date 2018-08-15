package net.alisra.kabaddiscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int TOUCHDOWN_POINTS = 6;
    final int FOUL_POINTS = -1;
    final int EXTRA_POINT_1_POINT = 1;
    final int EXTRA_POINT_2_POINTS = 2;

    int lakshmipur_score = 0;
    int dhaka_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Update Score
     * */
    public void updateTeamScore(View v) {
        switch (v.getId()) {
            case R.id.team_a_touchdown:
                lakshmipur_score += TOUCHDOWN_POINTS;
                break;
            case R.id.team_a_foul:
                if(lakshmipur_score > 0){
                    lakshmipur_score += FOUL_POINTS;
                }
                break;
            case R.id.team_a_extra_point_1:
                lakshmipur_score += EXTRA_POINT_1_POINT;
                break;
            case R.id.team_a_extra_point_2:
                lakshmipur_score += EXTRA_POINT_2_POINTS;
                break;

            case R.id.team_b_touchdown:
                dhaka_score += TOUCHDOWN_POINTS;
                break;
            case R.id.team_b_foul:
                if(dhaka_score > 0){
                    dhaka_score += FOUL_POINTS;
                }
                break;
            case R.id.team_b_extra_point_1:
                dhaka_score += EXTRA_POINT_1_POINT;
                break;
            case R.id.team_b_extra_point_2:
                dhaka_score += EXTRA_POINT_2_POINTS;
                break;

            default:
                break;
        }

        displayLakshmipurScore(lakshmipur_score);
        displayDhakaScore(dhaka_score);
    }

    /**
     * Display Scores
     */
    public void displayLakshmipurScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayDhakaScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Reset Scores
     */
    public void reset(View v) {
        lakshmipur_score = 0;
        dhaka_score = 0;
        displayLakshmipurScore(lakshmipur_score);
        displayDhakaScore(dhaka_score);
    }
    /**
     * Show Result
     * */
    public void result(View v){
        TextView result = (TextView) findViewById(R.id.result);
        if(lakshmipur_score > dhaka_score){
            result.setText("Lakshmipur win by "+lakshmipur_score+" point");
        }else if(lakshmipur_score == dhaka_score) {
            result.setText("Game was tie");
        }else{
            result.setText("Dhaka win by "+lakshmipur_score+" point");
        }
    }
}
