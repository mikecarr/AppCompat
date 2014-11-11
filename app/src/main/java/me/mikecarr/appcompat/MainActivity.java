package me.mikecarr.appcompat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        addActionProviderWidgets(menu, getApplicationContext(),0 );

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addActionProviderWidgets(Menu menu, Context context, int widgetFlags) {
        MikesActionProvider mikesActionProvider = new MikesActionProvider(getApplicationContext());
        createActionProviderMenuItem(menu, mikesActionProvider, R.string.hello_world);

    }
    /**
     * This method will add the given ActionProvider to the given menu with the given title
     * resource.
     *
     * @param menu menu to add provider to
     * @param provider ActionProvider to add to given menu, this should also implement
     * @param titleResource resource id for title string
     */
    private void createActionProviderMenuItem(Menu menu, ActionProvider provider, int titleResource) {

        // MenuItemCompat.setActionProvider
        MenuItem newItem = menu.add(Menu.NONE, Menu.NONE, Menu.NONE, titleResource);
        MenuItemCompat.setActionProvider(newItem,provider);

        newItem.setShowAsAction(MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
        newItem.setVisible(true);

    }
}
