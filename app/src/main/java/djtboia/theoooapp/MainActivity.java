package djtboia.theoooapp;

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
    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, android.R.layout.simple_spinner_item);

        spinnerDropdown = (Spinner) findViewById(R.id.spinner_dropdown);
        spinnerDropdown.setAdapter(adapter);
        spinnerDropdown.setOnItemSelectedListener(MainActivity.this);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new onClickListener());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView spinnerDropdownText = (TextView) view;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public class onClickListener implements View.OnClickListener {
        boolean startFlag = false;
        MediaPlayer longOoo = MediaPlayer.create(MainActivity.this, R.raw.oooolong);
        @Override
        public void onClick(View v) {
            if(!startFlag)

                switch(spinnerDropdown.getSelectedItem().toString())
                {
                    case "Long Oooo":
                        startFlag = true;
                        longOoo.start();
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


            else {
                 //stop all mediaPlayers
                    startFlag = false;
                    longOoo.pause();
                    longOoo.seekTo(0);

                }
        }
    }
}
