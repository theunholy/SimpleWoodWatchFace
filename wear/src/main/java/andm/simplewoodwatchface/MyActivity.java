package andm.simplewoodwatchface;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class MyActivity extends Activity {

    public static final String SHARED_PREFERENCE = "shared_preference";

    private ImageView mBackground;
    private TextClock mClock;
    private LinearLayout mContainer;


    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mBackground = (ImageView) findViewById(R.id.watch_background);
        mContainer = (LinearLayout) findViewById(R.id.watch_container);
        mClock = (TextClock) findViewById(R.id.watch_time);


            }
    @Override
    protected void onPause(){
        super.onPause();
        mBackground.setImageResource(R.drawable.dim_wallpaper);
        mClock.setTextColor(getResources().getColor(android.R.color.white));
        mContainer.setBackgroundColor(getResources().getColor(android.R.color.black));

    }
    @Override
    protected  void onResume(){
        super.onResume();
        SharedPreferences pref = getSharedPreferences( SHARED_PREFERENCE, Context.MODE_PRIVATE);
        if (pref.contains(SettngsActivity.SHARED_PREFERENCE_WALLPAPER)) {
            String wallpaperCode = pref.getString(SettngsActivity.SHARED_PREFERENCE_WALLPAPER, "");
            loadWallpaperWatchFace(wallpaperCode);
        }else {
            mBackground.setImageResource(R.drawable.wood1_wallpaper);
            mClock.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            mContainer.setBackgroundColor(getResources().getColor(android.R.color.white));
        }
    }
    private void loadWallpaperWatchFace(String wallpaperCode){
        if( "Wood 1".equals(wallpaperCode)) {
            mBackground.setImageResource(R.drawable.wood1_wallpaper);
            mClock.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
        }else if ("Wood 2".equals(wallpaperCode)) {
            mBackground.setImageResource(R.drawable.wood2_wallpaper);
            mClock.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }else if("Wood 3".equals(wallpaperCode)) {
            mBackground.setImageResource(R.drawable.wood3_wallpaper);
            mClock.setTextColor(getResources().getColor(android.R.color.holo_orange_dark));

        }else{
            mBackground.setImageResource(R.drawable.wood1_wallpaper);
            mClock.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
    }
      mContainer.setBackgroundColor(getResources().getColor(android.R.color.white));
    }
}
