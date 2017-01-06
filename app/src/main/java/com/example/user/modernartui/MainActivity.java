package com.example.user.modernartui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar s = (SeekBar) findViewById(R.id.seek);
        final Button one = (Button) findViewById(R.id.one);
        final Button two = (Button) findViewById(R.id.two);
        final Button three = (Button) findViewById(R.id.three);
        final Button four = (Button) findViewById(R.id.four);
        final Button five = (Button) findViewById(R.id.five);
        /*final ColorDrawable col1 = (ColorDrawable) one.getBackground();
        final ColorDrawable col2 = (ColorDrawable) one.getBackground();
        final ColorDrawable col3 = (ColorDrawable) one.getBackground();
        final ColorDrawable col4 = (ColorDrawable) one.getBackground();
        final ColorDrawable col5 = (ColorDrawable) one.getBackground();*/
        int col1 = ContextCompat.getColor(this, R.color.grayish);
        int col2 = ContextCompat.getColor(this,R.color.orangish);
        int col3 = ContextCompat.getColor(this,R.color.greenish);
        int col4 = ContextCompat.getColor(this,R.color.pinkish);
        int col5 = ContextCompat.getColor(this,R.color.bluish);
        final float c1[] = new float[3];
        final float c2[] = new float[3];
        final float c3[] = new float[3];
        final float c4[] = new float[3];
        final float c5[] = new float[3];
        Color.colorToHSV(col1, c1);
        Color.colorToHSV(col2, c2);
        Color.colorToHSV(col3, c3);
        Color.colorToHSV(col4, c4);
        Color.colorToHSV(col5, c5);
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cur = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float p = (float)0.1;
                int val = Math.abs(progress - cur);
                if(cur > progress) {
                    c1[0] = c1[0] - val*p;
                    c1[1] = c1[1] - val*p;
                    c1[2] = c1[2] - val*p; //Log.i("Message","" + p);
                    c2[0] = c2[0] - val*p;
                    c2[1] = c2[1] - val*p;
                    c2[2] = c2[2] - val*p; //Log.i("Message","" + c1[0] +" "+c1[1]+" "+c1[2]);
                    c3[0] = c3[0] - val*p;
                    c3[1] = c3[1] - val*p;
                    c3[2] = c3[2] - val*p; //Log.i("Message","" + c3[0]);
                    c4[0] = c4[0] - val*p;
                    c4[1] = c4[1] - val*p;
                    c4[2] = c4[2] - val*p; //Log.i("Message","" + c4[0]);
                    c5[0] = c5[0] - val*p;
                    c5[1] = c5[1] - val*p;
                    c5[2] = c5[2] - val*p; //Log.i("Message","" + c5[0]);
                }
                else {
                    c1[0] = c1[0] + val*p;
                    c1[1] = c1[1] + val*p;
                    c1[2] = c1[2] + val*p; //Log.i("Message","" + p);
                    c2[0] = c2[0] + val*p;
                    c2[1] = c2[1] + val*p;
                    c2[2] = c2[2] + val*p; //Log.i("Message","" + c1[0] +" "+c1[1]+" "+c1[2]);
                    c3[0] = c3[0] + val*p;
                    c3[1] = c3[1] + val*p;
                    c3[2] = c3[2] + val*p; //Log.i("Message","" + c3[0]);
                    c4[0] = c4[0] + val*p;
                    c4[1] = c4[1] + val*p;
                    c4[2] = c4[2] + val*p; //Log.i("Message","" + c4[0]);
                    c5[0] = c5[0] + val*p;
                    c5[1] = c5[1] + val*p;
                    c5[2] = c5[2] + val*p;
                }
                cur = progress;
                one.setBackgroundColor(Color.HSVToColor(c1));
                two.setBackgroundColor(Color.HSVToColor(c2));
                three.setBackgroundColor(Color.HSVToColor(c3));
                four.setBackgroundColor(Color.HSVToColor(c4));
                five.setBackgroundColor(Color.HSVToColor(c5));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("SeekBar","Called onStartTrackingTouch()");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i("SeekBar","Called onStopTrackingTouch()");
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.info :
                Log.i("Message","R.id.info clicked");
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.custom);
                dialog.setTitle("Select an option");
                Button ok = (Button) dialog.findViewById(R.id.dialogbutton);
                ok.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                        Uri uri = Uri.parse("http://www.moma.org");
                        Intent ii = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(ii);
                    }
                });
                Button cancel = (Button) dialog.findViewById(R.id.dialogcbutton);
                cancel.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
