package co.gdgcali.imcdemo.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.gdgcali.imcdemo.R;
import co.gdgcali.imcdemo.domain.LCalculos;
import co.gdgcali.imcdemo.modelo.PersonIMC;
import co.gdgcali.imcdemo.views.fragment.HistorialIMCFragment;
import co.gdgcali.imcdemo.views.fragment.IHistorialIMCFragmentListener;

public class IMCCalculoActivity extends AppCompatActivity {

    private IHistorialIMCFragmentListener historialIMCFragmentListener;
    private LCalculos objLCalculos;

    @Bind(R.id.txtNombrePersona)
    EditText textNombrePersona;

    @Bind(R.id.txtAltura)
    EditText textAltura;

    @Bind(R.id.txtPeso)
    EditText textPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imccalculo);

        ButterKnife.bind(this);

        HistorialIMCFragment fragmentHistorial = (HistorialIMCFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragmentHistorialIMC);

        fragmentHistorial.setRetainInstance(true);
        historialIMCFragmentListener = (IHistorialIMCFragmentListener) fragmentHistorial;

        objLCalculos = new LCalculos();
    }

    @OnClick(R.id.btnCalcular)
    public void clickCalcular(View view){

        String nombrePersona = textNombrePersona.getText().toString();
        double altura = Double.parseDouble(textAltura.getText().toString());
        double peso =  Double.parseDouble(textPeso.getText().toString());

        PersonIMC personIMC = objLCalculos.calcularIMC(nombrePersona, altura, peso);

        limpiar();

        historialIMCFragmentListener.agregar(personIMC);
    }

    @OnClick(R.id.btnLimpiar)
    public void clickLimpiar(View view){
        limpiar();
    }

    private void limpiar() {
        textAltura.setText("");
        textPeso.setText("");
        textNombrePersona.setText("");

        textNombrePersona.requestFocus();
    }

    @OnClick(R.id.btnDescripcion)
    public void clickIMCDescripcion(View view){
        Intent intent = new Intent(this, IMCDescripcion.class);
        startActivity(intent);
    }

}
