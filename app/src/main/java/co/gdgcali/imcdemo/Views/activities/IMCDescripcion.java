package co.gdgcali.imcdemo.views.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.gdgcali.imcdemo.R;

public class IMCDescripcion extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_descripcion);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBar bar = getSupportActionBar();

        bar.setDisplayHomeAsUpEnabled(true);
    }


}
