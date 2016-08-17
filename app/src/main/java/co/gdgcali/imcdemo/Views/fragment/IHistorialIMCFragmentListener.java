package co.gdgcali.imcdemo.views.fragment;

import java.util.List;

import co.gdgcali.imcdemo.modelo.PersonIMC;

/**
 * Created by jggomezt on 12/08/2016.
 */
public interface IHistorialIMCFragmentListener {

    void agregar(PersonIMC personIMC);
    void limpiar();
    void agregarListaPersonas(List<PersonIMC> lstPersonIMC);

}
