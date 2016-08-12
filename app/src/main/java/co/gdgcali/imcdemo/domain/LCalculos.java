package co.gdgcali.imcdemo.domain;

import co.gdgcali.imcdemo.modelo.PersonIMC;

/**
 * Created by jggomezt on 12/08/2016.
 */
public class LCalculos {

    public PersonIMC calcularIMC(String nombrePersona, double altura, double peso){

        double imc = peso / (Math.pow(altura, 2));

        PersonIMC objPersonIMC = new PersonIMC();
        objPersonIMC.setNombre(nombrePersona);
        objPersonIMC.setAltura(altura);
        objPersonIMC.setPeso(peso);
        objPersonIMC.setImc(imc);

        return objPersonIMC;
    }
}
