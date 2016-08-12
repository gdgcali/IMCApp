package co.gdgcali.imcdemo.modelo;

/**
 * Created by jggomezt on 10/08/2016.
 */
public class PersonIMC {

    private String nombre;
    private double altura;
    private double peso;
    private double imc;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return String.format("Altura : %f -- Peso : %f -- IMC : %f", altura, peso, imc);
    }
}
