package co.gdgcali.imcdemo.domain;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import co.gdgcali.imcdemo.modelo.PersonIMC;

/**
 * Created by jggomezt on 12/08/2016.
 */
public class LCalculos {

    public static List<PersonIMC> lstPersonIMC = new ArrayList<>();

    public PersonIMC calcularIMC(String nombrePersona, double altura, double peso, Uri pathImgPerfil) {

        double imc = peso / (Math.pow(altura, 2));

        PersonIMC objPersonIMC = new PersonIMC();
        objPersonIMC.setNombre(nombrePersona);
        objPersonIMC.setAltura(altura);
        objPersonIMC.setPeso(peso);
        objPersonIMC.setImc(imc);
        objPersonIMC.setImgPerfil(pathImgPerfil);

        return objPersonIMC;
    }

    public void addPersona(PersonIMC personIMC) {
        lstPersonIMC.add(personIMC);
    }

    public void eliminar(PersonIMC personIMC) {
        lstPersonIMC.remove(personIMC);
    }

    public List<PersonIMC> getListaPersonas(){
        return lstPersonIMC;
    }

}
