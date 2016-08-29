package co.gdgcali.imcdemo.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.gdgcali.imcdemo.R;
import co.gdgcali.imcdemo.domain.LCalculos;
import co.gdgcali.imcdemo.views.fragment.HistorialIMCFragment;
import co.gdgcali.imcdemo.views.fragment.IHistorialIMCFragmentListener;

public class IMCHistorial extends AppCompatActivity {


    private LCalculos objLCalculos;

    private IHistorialIMCFragmentListener historialIMCFragmentListener;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.dwl_menu)
    DrawerLayout drawerLayout;

    @Bind(R.id.nv_opcionesapp)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_historial);

        ButterKnife.bind(this);

        objLCalculos = new LCalculos();

        HistorialIMCFragment fragment = (HistorialIMCFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentHistorialIMC);

        fragment.setRetainInstance(true);

        historialIMCFragmentListener = fragment;

        historialIMCFragmentListener.agregarListaPersonas(objLCalculos.getListaPersonas());

        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();

        ab.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        ab.setDisplayHomeAsUpEnabled(true);

        confNavigationDrawer();
    }

    private void confNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Intent intent;

                switch (item.getItemId()) {
                    case R.id.navigation_item_calculo:
                        item.setChecked(true);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        intent = new Intent(IMCHistorial.this, IMCCalculoActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.navigation_item_descripcion_imc:
                        item.setChecked(true);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        intent = new Intent(IMCHistorial.this, IMCDescripcion.class);
                        startActivity(intent);
                        return true;

                    case R.id.navigation_item_share:
                        item.setChecked(true);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        // TODO: Share app
                        return true;

                    case R.id.navigation_item_acercade:
                        item.setChecked(true);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        // TODO: Popup
                        return true;
                }

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_header, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        historialIMCFragmentListener.agregarListaPersonas(objLCalculos.getListaPersonas());
    }

    @OnClick(R.id.fbAddIMC)
    public void clickAddIMC() {
        Intent intent = new Intent(this, IMCCalculoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_share:
                //TODO: evento de compartir
                return true;
            case R.id.settings:
                Intent intent = new Intent(this, IMCDescripcion.class);
                startActivity(intent);
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
