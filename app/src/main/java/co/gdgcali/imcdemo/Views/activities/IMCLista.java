package co.gdgcali.imcdemo.views.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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

public class IMCLista extends AppCompatActivity {

    private LCalculos objLCalculos;

    private IHistorialIMCFragmentListener historialIMCFragmentListener;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imclista);

        ButterKnife.bind(this);

        objLCalculos = new LCalculos();

        HistorialIMCFragment fragment = (HistorialIMCFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentHistorialIMC);

        fragment.setRetainInstance(true);

        historialIMCFragmentListener = fragment;

        historialIMCFragmentListener.agregarListaPersonas(objLCalculos.getListaPersonas());

        setSupportActionBar(toolbar);
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
    public void clickAddIMC(){
        Intent intent = new Intent(this, IMCCalculoActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_share:
                //TODO: evento de compartir
                return true;
            case R.id.settings:
                Intent intent = new Intent(this, IMCDescripcion.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
