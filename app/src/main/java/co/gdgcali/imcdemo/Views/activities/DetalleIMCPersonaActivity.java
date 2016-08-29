package co.gdgcali.imcdemo.views.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.gdgcali.imcdemo.R;

public class DetalleIMCPersonaActivity extends AppCompatActivity {

    @Bind(R.id.txtNombrePersona)
    TextView txtNombrePersona;

    @Bind(R.id.txtAlturaPersona)
    TextView txtAlturaPersona;

    @Bind(R.id.txtPesoPersona)
    TextView txtPesoPersona;

    @Bind(R.id.txtIMCPersona)
    TextView txtImcPersona;

    @Bind(R.id.imgPerfilPersona)
    ImageView imgPerfil;

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    public final static String NOMBRE_KEY = "nombrePersona";
    public final static String ALTURA_KEY = "alturaPersona";
    public final static String PESO_KEY = "pesoPersona";
    public final static String IMC_KEY = "imcPersona";
    public final static String IMG_PERFIL_KEY = "imcImgPerfil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_detalle_persona);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        String url = intent.getStringExtra(IMG_PERFIL_KEY);

        if (url == null || url.equals("")) {
            Picasso.with(this).load(R.drawable.icon_person)
                    .resize(700, 700).centerCrop().into(imgPerfil);
        } else {
            Picasso.with(this).load(Uri.parse(url))
                    .resize(700, 700).centerCrop().into(imgPerfil);
        }

        txtNombrePersona.setText(intent.getStringExtra(NOMBRE_KEY));
        txtAlturaPersona.setText(String.format("Altura : %s mts", intent.getStringExtra(ALTURA_KEY)));
        txtPesoPersona.setText(String.format("Peso : %s kgs", intent.getStringExtra(PESO_KEY)));
        txtImcPersona.setText(String.format("IMC : %s ", intent.getStringExtra(IMC_KEY)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_header, menu);
        return true;
    }
}
