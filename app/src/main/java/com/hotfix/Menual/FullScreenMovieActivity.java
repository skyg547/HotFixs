package com.hotfix.Menual;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bufsrepair.R;

public class FullScreenMovieActivity extends AppCompatActivity {
    com.hotfix.Menual.FullScreenVideoView videoView;
    MediaController controller;
    Intent intent;
    String name;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_movie);
        ActionBar abar = getSupportActionBar();
        abar.hide();

        videoView = (com.hotfix.Menual.FullScreenVideoView) findViewById(R.id.videoView);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        intent = getIntent();
        name = intent.getExtras().getString("name");
        index = intent.getExtras().getInt("index");

        if (name.equals("Sink")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e24.mp4"));
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e25.mp4"));
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e38.mp4"));
            } else if (index == 4) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e48.mp4"));
            } else if (index == 5) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e43.mp4"));
            }
        } else if (name.equals("Basin")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e28.mp4"));
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e26.mp4"));
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e27.mp4"));
            }
        } else if (name.equals("Bathroom")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e31.mp4"));
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e32.mp4"));
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e33.mp4"));
            }
        } else if (name.equals("Tile")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e34.mp4"));
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e35.mp4"));
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e36.mp4"));
            } else if (index == 4) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e39.mp4"));
            } else if (index == 5) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e44.mp4"));
            } else if (index == 6) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e49.mp4"));
            }
        } else if (name.equals("Paint")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e40.mp4"));
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e50.mp4"));
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e45.mp4"));
            } else if (index == 4) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e41.mp4"));
            } else if (index == 5) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e51.mp4"));
            } else if (index == 6) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e46.mp4"));
            } else if (index == 7) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e53.mp4"));
            } else if (index == 8) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e42.mp4"));
            } else if (index == 9) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e52.mp4"));
            } else if (index == 10) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e47.mp4"));
            }
        } else if (name.equals("Wallpaper")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e54.mp4"));
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e55.mp4"));
            }
        } else if (name.equals("Shelf")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e30.mp4"));
            }
        } else if (name.equals("Monitor")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e29.mp4"));
            }
        } else if (name.equals("Doorknob")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e22.mp4"));
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e23.mp4"));
            }
        } else if (name.equals("동영상")) {
            if (index == 1) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e01.mp4"));
            } else if (index == 2) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e02.mp4"));
            } else if (index == 3) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e03.mp4"));
            } else if (index == 4) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e04.mp4"));
            } else if (index == 5) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e05.mp4"));
            } else if (index == 6) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e06.mp4"));
            } else if (index == 7) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e07.mp4"));
            } else if (index == 8) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e08.mp4"));
            } else if (index == 9) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e09.mp4"));
            } else if (index == 10) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e10.mp4"));
            } else if (index == 11) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e11.mp4"));
            } else if (index == 12) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e12.mp4"));
            } else if (index == 13) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e13.mp4"));
            } else if (index == 14) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e14.mp4"));
            } else if (index == 15) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e15.mp4"));
            } else if (index == 16) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e16.mp4"));
            } else if (index == 17) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e17.mp4"));
            } else if (index == 18) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e18.mp4"));
            } else if (index == 19) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e19.mp4"));
            } else if (index == 20) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e20.mp4"));
            } else if (index == 21) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e21.mp4"));
            } else if (index == 22) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e22.mp4"));
            } else if (index == 23) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e23.mp4"));
            } else if (index == 24) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e24.mp4"));
            } else if (index == 25) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e25.mp4"));
            } else if (index == 26) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e26.mp4"));
            } else if (index == 27) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e27.mp4"));
            } else if (index == 28) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e28.mp4"));
            } else if (index == 29) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e29.mp4"));
            } else if (index == 30) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e30.mp4"));
            } else if (index == 31) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e31.mp4"));
            } else if (index == 32) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e32.mp4"));
            } else if (index == 33) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e33.mp4"));
            } else if (index == 34) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e34.mp4"));
            } else if (index == 35) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e35.mp4"));
            } else if (index == 36) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e36.mp4"));
            } else if (index == 37) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e37.mp4"));
            } else if (index == 38) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e38.mp4"));
            } else if (index == 39) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e39.mp4"));
            } else if (index == 40) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e40.mp4"));
            } else if (index == 41) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e41.mp4"));
            } else if (index == 42) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e42.mp4"));
            } else if (index == 43) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e43.mp4"));
            } else if (index == 44) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e44.mp4"));
            } else if (index == 45) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e45.mp4"));
            } else if (index == 46) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e46.mp4"));
            } else if (index == 47) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e47.mp4"));
            } else if (index == 48) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e48.mp4"));
            } else if (index == 49) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e49.mp4"));
            } else if (index == 50) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e50.mp4"));
            } else if (index == 51) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e51.mp4"));
            } else if (index == 52) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e52.mp4"));
            } else if (index == 53) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e53.mp4"));
            } else if (index == 54) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e54.mp4"));
            } else if (index == 55) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e55.mp4"));
            } else if (index == 56) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e56.mp4"));
            } else if (index == 57) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e57.mp4"));
            } else if (index == 58) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e58.mp4"));
            } else if (index == 59) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e59.mp4"));
            } else if (index == 60) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e60.mp4"));
            } else if (index == 61) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e61.mp4"));
            } else if (index == 62) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e62.mp4"));
            } else if (index == 63) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e63.mp4"));
            } else if (index == 64) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e64.mp4"));
            } else if (index == 65) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e65.mp4"));
            } else if (index == 66) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e66.mp4"));
            } else if (index == 67) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e67.mp4"));
            } else if (index == 68) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e68.mp4"));
            } else if (index == 69) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e69.mp4"));
            } else if (index == 70) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e70.mp4"));
            } else if (index == 71) {
                videoView.setVideoURI(Uri.parse("https://gwanwoo.s3.ap-northeast-2.amazonaws.com/e71.mp4"));
            }
        }


        controller = new MediaController(FullScreenMovieActivity.this);
        controller.setAnchorView(videoView);

        videoView.setMediaController(controller);
        videoView.requestFocus();
        videoView.seekTo(0);
        videoView.start();
    }
}
