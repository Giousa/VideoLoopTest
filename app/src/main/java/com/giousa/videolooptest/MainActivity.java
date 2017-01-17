package com.giousa.videolooptest;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.custom_video_view)
    CustomVideoView mCustomVideoView;
    @InjectView(R.id.btn_start)
    Button mBtnStart;
    @InjectView(R.id.btn_stop)
    Button mBtnStop;
    private Uri mUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mUri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.guide_1);
    }

    @OnClick({R.id.btn_start, R.id.btn_stop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                mCustomVideoView.playVideo(mUri);
                break;
            case R.id.btn_stop:
                if (mCustomVideoView != null) {
                    mCustomVideoView.stopPlayback();
                }
                break;
        }
    }
}