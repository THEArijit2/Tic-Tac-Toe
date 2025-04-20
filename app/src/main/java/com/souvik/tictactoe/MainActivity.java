package com.souvik.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activeplayer = 0;
    boolean gameActive = true;
    boolean emptySquare = false;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winpositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
        {0, 4, 8}, {2, 4, 6}};
    public void playertap(View view)
    {
        ImageView img=(ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive)
        {
            gamereset(view);
        }
        if(gamestate[tappedImage]==2)
        {
            gamestate[tappedImage]=activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer==0)
            {
                img.setImageResource(R.drawable.tictactoex);
                activeplayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("O's Turn - Tap to Play");
            }
            else
            {
                img.setImageResource(R.drawable.tictactoe0);
                activeplayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's Turn - Tap to Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
            for (int[] winPosition: winpositions)
            {
                if(gamestate[winPosition[0]] == gamestate[winPosition[1]] &&
                        gamestate[winPosition[1]] == gamestate[winPosition[2]]
                        && gamestate[winPosition[0]]!=2)
                {
                    String winnerStr;
                    gameActive=false;
                    if(gamestate[winPosition[0]] == 0)
                    {
                        winnerStr = "X has won";
                    }
                    else
                    {
                        winnerStr = "O has won";
                    }

                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);
                }
            }
            for (int squareState : gamestate) {
                if (squareState == 2) {
                    emptySquare = true;
                    break;
                }
            }
            if (!emptySquare && gameActive) {
                // Game is a draw
                gameActive = false;
                ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
                TextView status = findViewById(R.id.status);
                status.setText("No one won");
            }
        }
    }
    public void gamereset(View view)
    {
        gameActive = true;
        int activeplayer = 0;
        for (int i = 0; i < gamestate.length; i++)
        {
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView16)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}