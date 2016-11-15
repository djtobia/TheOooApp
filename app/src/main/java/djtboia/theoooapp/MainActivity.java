package djtboia.theoooapp;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.Activity;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.media.MediaPlayer;

public class MainActivity extends Activity implements OnItemSelectedListener {

    Spinner spinnerDropdown;
    ArrayAdapter adapter;
    Button btnPlay, btnStop, btnResume, btnPause;
    boolean startFlag;
    int[] allOoos;
    MediaPlayer oooPlayer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFlag = false;
        allOoos = new int[1];
        allOoos[0] = R.raw.oooolong;
        adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, android.R.layout.simple_spinner_item);

        spinnerDropdown = (Spinner) findViewById(R.id.spinner_dropdown);
        spinnerDropdown.setAdapter(adapter);
        spinnerDropdown.setOnItemSelectedListener(MainActivity.this);


        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new playListener());
        btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new stopListener());

        btnPause = (Button) findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new pauseListener());

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView spinnerDropdownText = (TextView) view;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public class playListener implements View.OnClickListener {



        @Override
        public void onClick(View v) {
            if(!startFlag)

            {
                switch (spinnerDropdown.getSelectedItem().toString()) {
                    case "Long Oooo":
                        startFlag = true;
                        oooPlayer = MediaPlayer.create(MainActivity.this, allOoos[0]);
                        oooPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                startFlag = false;
                            }
                        });
                    oooPlayer.start();
                    break;
                    case "Ooooo":
                        startFlag = true;
                        break;
                    case "Ooo Ooo Ooo":
                        startFlag = true;
                        break;
                    case "Ooooooo I'm tellinnnggggg":
                        startFlag = true;
                        break;
                }
            }




        }
    }

    public class stopListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if(startFlag)
            {
                oooPlayer.pause();
                oooPlayer.seekTo(0);
                startFlag = false;

                //add all other mediaplayers when you get there
            }
        }
    }

    public class pauseListener implements View.OnClickListener{
        @Override
        public void onClick(View v)
        {
            if(startFlag)
            {
                oooPlayer.pause();
                startFlag = false;
            }
        }
    }

}
