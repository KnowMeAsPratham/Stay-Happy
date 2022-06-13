package com.miniproject.stay_happy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MusicActivity extends AppCompatActivity {

    ImageButton a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        a = findViewById(R.id.btn_cmp);
        b = findViewById(R.id.btn_haps);
        c = findViewById(R.id.btn_rt);
        d = findViewById(R.id.btn_lya);
        e = findViewById(R.id.btn_bm);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://open.spotify.com/playlist/2EXP6pCDBdF4yRj2LZ6xFr");
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://open.spotify.com/show/79GbkgP2sxA8FJ97Qk1GKZ");
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://open.spotify.com/show/6XPm7Mr08nFVWX4Abcqmek");
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://open.spotify.com/show/6925GqlCoRoCEo8UYy17FQ");
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/watch?v=YFSc7Ck0Ao0");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}