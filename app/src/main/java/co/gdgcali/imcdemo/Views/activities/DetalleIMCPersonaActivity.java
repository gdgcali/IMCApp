package co.gdgcali.imcdemo.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
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

    public final static String NOMBRE_KEY = "nombrePersona";
    public final static String ALTURA_KEY = "alturaPersona";
    public final static String PESO_KEY = "pesoPersona";
    public final static String IMC_KEY = "imcPersona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_imcpersona);

        ButterKnife.bind(this);

        Intent intent = getIntent();

        txtNombrePersona.setText(intent.getStringExtra(NOMBRE_KEY));
        txtAlturaPersona.setText(intent.getStringExtra(ALTURA_KEY));
        txtPesoPersona.setText(intent.getStringExtra(PESO_KEY));
        txtImcPersona.setText(intent.getStringExtra(IMC_KEY));
    }
}
