package co.gdgcali.imcdemo.views.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.gdgcali.imcdemo.R;
import co.gdgcali.imcdemo.domain.LCalculos;
import co.gdgcali.imcdemo.modelo.PersonIMC;

public class IMCCalculoActivity extends AppCompatActivity {

    private static final int SELECT_PICTURE = 200;
    private CharSequence[] opciones;
    private LCalculos objLCalculos;
    private PersonIMC personIMC;
    private Uri pathImgPerfil;

    @Bind(R.id.txtNombrePersona)
    EditText textNombrePersona;

    @Bind(R.id.txtAltura)
    EditText textAltura;

    @Bind(R.id.txtPeso)
    EditText textPeso;

    @Bind(R.id.txtCalculoIMC)
    TextView txtCalculoIMC;

    @Bind(R.id.imgPerfil)
    ImageView imgPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imccalculo);

        ButterKnife.bind(this);

        opciones = new CharSequence[]{getResources().getString(R.string.imc_opcion_foto_tomar),
                getResources().getString(R.string.imc_opcion_foto_seleccionar_galeria)};

        Picasso.with(this).load(R.drawable.icon_person).resize(600, 600).centerCrop().into(imgPerfil);

        objLCalculos = new LCalculos();

        limpiar();
    }

    @OnClick(R.id.btnCalcular)
    public void clickCalcular(View view) {

        String nombrePersona = textNombrePersona.getText().toString();
        double altura = Double.parseDouble(textAltura.getText().toString());
        double peso = Double.parseDouble(textPeso.getText().toString());

        personIMC = objLCalculos.calcularIMC(nombrePersona, altura, peso, pathImgPerfil);

        txtCalculoIMC.setText(String.valueOf(personIMC.getImc()));
    }

    @OnClick(R.id.btnLimpiar)
    public void clickLimpiar(View view) {
        limpiar();
    }

    private void limpiar() {
        textAltura.setText("");
        textPeso.setText("");
        textNombrePersona.setText("");

        textNombrePersona.requestFocus();
    }

    @OnClick(R.id.fbAgregarIMC)
    public void clickAddIMC(){
        personIMC.setImgPerfil(pathImgPerfil);
        objLCalculos.addPersona(personIMC);
        finish();
    }

    @OnClick(R.id.fbAddImgPerfil)
    public void addImgPerfil() {

        AlertDialog.Builder builder = new AlertDialog.Builder(IMCCalculoActivity.this);

        builder.setTitle("Selecciona una opción");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (opciones[which].equals(getResources().getString(R.string.imc_opcion_foto_tomar))) {
                    abrirCamara();
                } else if (opciones[which].equals(getResources().getString(R.string.imc_opcion_foto_seleccionar_galeria))) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "Selecciona tu imagen de perfil"), SELECT_PICTURE);
                } else {
                    dialog.dismiss();
                }

            }
        });

        builder.show();
    }

    private void abrirCamara() {
        //TODO: Abrir camara
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SELECT_PICTURE:
                if (resultCode == RESULT_OK) {
                    pathImgPerfil = data.getData();
                    Picasso.with(this).load(pathImgPerfil).resize(600, 600).centerCrop().into(imgPerfil);
                }
                break;
        }
    }
}
