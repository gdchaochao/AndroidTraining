package org.yzsoft.sqlitedemo.activity;

import org.yzsoft.sqlitedemo.util.R;
import org.yzsoft.sqlitedemo.util.R.layout;
import org.yzsoft.sqlitedemo.util.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
