package estrateca.com.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;

import estrateca.com.app.fragments.AcercaDe;
import estrateca.com.app.fragments.Contactar;
import estrateca.com.app.fragments.Cuenta;
import estrateca.com.app.fragments.MiPerfil;
import estrateca.com.app.fragments.Ordenar;
import estrateca.com.app.fragments.Promociones;
import estrateca.com.app.fragments.Ubicacion;

public class menu extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private static final int NAVIGATION_ORDENAR = 0;
    private static final int NAVIGATION_UBICACIONES = 1;
    private static final int NAVIGATION_ESTADO_CUENTA = 2;
    private static final int NAVIGATION_PROMOCIONES = 3;
    private static final int NAVIGATION_ACERCA_DE = 4;
    private static final int NAVIGATION_CONTACTANOS = 5;
    private static final int NAVIGATION_MI_PERFIL = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        onSectionAttached(6); // se coloca en MiPerfil

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        onSectionAttached(position);

        Log.i("position =",""+position);

    }

    public void onSectionAttached(int position) {

        FragmentManager fragmentManager =  getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = new Fragment();

        switch (position) {
            case NAVIGATION_ORDENAR:
                mTitle = getString(R.string.title_section0);
                fragment = new Ordenar();

                break;
            case NAVIGATION_UBICACIONES:
                mTitle = getString(R.string.title_section1);
                fragment = new Ubicacion();

                break;
            case NAVIGATION_ESTADO_CUENTA:
                mTitle = getString(R.string.title_section2);
                fragment = new Cuenta();

                break;
            case NAVIGATION_PROMOCIONES:
                mTitle = getString(R.string.title_section3);
                fragment = new Promociones();

                break;
            case NAVIGATION_ACERCA_DE:
                mTitle = getString(R.string.title_section4);
                fragment = new AcercaDe();

                break;
            case NAVIGATION_CONTACTANOS:
                mTitle = getString(R.string.title_section5);
                fragment = new Contactar();

                break;
            case NAVIGATION_MI_PERFIL:
                mTitle = getString(R.string.title_section6);
                fragment = new MiPerfil();

                break;

        }

        fragmentTransaction.replace(R.id.vale_holder_container, fragment);
        fragmentTransaction.commit();

        restoreActionBar();

    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.menu, menu);
            //restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

}