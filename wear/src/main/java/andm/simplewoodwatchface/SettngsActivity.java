package andm.simplewoodwatchface;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siulmagic on 10/17/2014.
 */
public class SettngsActivity extends MyActivity {

    public static final String SHARED_PREFERENCE_WALLPAPER = "shared_preference_wallpaper";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final WallpaperObj wallpaper = new WallpaperObj();
        ListView listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter( this, android.R.layout.simple_list_item_1, wallpaper.wallpaperList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences pref = getSharedPreferences(MyActivity.SHARED_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(SHARED_PREFERENCE_WALLPAPER, wallpaper.wallpaperCodeList.get(position));
                editor.commit();
                finish();
            }
        });
    }

    public class WallpaperObj {
        public List<String> wallpaperList = new ArrayList<String>();
        public List<String> wallpaperCodeList = new ArrayList<String>();

        public WallpaperObj() {
            wallpaperList.add("Wood 1 PAT");
            wallpaperCodeList.add("Wood 1");
            wallpaperList.add("Wood 2 PAT");
            wallpaperCodeList.add("Wood 2");
            wallpaperList.add("Wood 3 PAT");
            wallpaperCodeList.add("Wood 3");
            //test
        }
    }
}
