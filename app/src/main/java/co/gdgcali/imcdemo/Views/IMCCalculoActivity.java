package co.gdgcali.imcdemo.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.gdgcali.imcdemo.R;

public class IMCCalculoActivity extends AppCompatActivity {

    private ArrayList<String> lstPersonIMC;
    private ArrayAdapter<String> adapterPersonIMC;

    @Bind(R.id.txtAltura)
    EditText textAltura;

    @Bind(R.id.txtPeso)
    EditText textPeso;

    @Bind(R.id.lblResultado)
    TextView lblResultado;

    @Bind(R.id.lvimcs)
    ListView lvimcs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imccalculo);

        ButterKnife.bind(this);

        lstPersonIMC = new ArrayList<>();
        adapterPersonIMC = new ArrayAdapter<>(this, R.layout.list_item, R.id.list_txt_imc, lstPersonIMC);

        lvimcs.setAdapter(adapterPersonIMC);
    }

    @OnClick(R.id.btnCalcular)
    public void clickCalcular(View view){

        double altura = Double.parseDouble(textAltura.getText().toString());
        double peso =  Double.parseDouble(textPeso.getText().toString());

        double imc = peso / (Math.pow(altura, 2));

        lblResultado.setText(String.valueOf(imc));

        lstPersonIMC.add(String.valueOf(imc));

        adapterPersonIMC.notifyDataSetChanged();

        textAltura.setText("");
        textPeso.setText("");

        textPeso.requestFocus();

        Toast.makeText(this, "Se ha calculado correctamente!!", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btnDescripcion)
    public void clickIMCDescripcion(View view){
        Intent intent = new Intent(this, IMCDescripcion.class);
        startActivity(intent);
    }

}
