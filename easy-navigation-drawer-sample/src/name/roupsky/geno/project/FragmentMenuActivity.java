
package name.roupsky.geno.project;

import name.roupsky.geno.easynavigationdrawer.EasyNavigationDrawerBuilder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class FragmentMenuActivity extends ActionBarActivity {

    private static final String TAG = "GRD.FragmentMenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment contentFragment = getSupportFragmentManager().findFragmentByTag("content");
        if (contentFragment == null) {
            Log.d(TAG, "creating content fragment");
            contentFragment = new SimpleFragment(R.layout.fragment_content);
            ft.add(R.id.grd_content_fragment_container, contentFragment, "content");
        }

        Fragment menuFragment = getSupportFragmentManager().findFragmentByTag("menu");
        if (menuFragment == null) {
            Log.d(TAG, "creating menu fragment");
            menuFragment = new SimpleFragment(R.layout.fragment_left_content);
            ft.add(R.id.grd_left_content_fragment_container, menuFragment, "menu");
        }

        ft.commit();

        new EasyNavigationDrawerBuilder()
                .setContentView(R.layout.activity_fragment_content)
                .setLeftContentView(R.layout.activity_fragment_left_content)
                .disableDrawerIndicator()
                .install(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
