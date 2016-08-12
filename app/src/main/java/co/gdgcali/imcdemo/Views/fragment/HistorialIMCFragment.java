package co.gdgcali.imcdemo.views.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.gdgcali.imcdemo.R;
import co.gdgcali.imcdemo.modelo.PersonIMC;
import co.gdgcali.imcdemo.views.activities.DetalleIMCPersonaActivity;
import co.gdgcali.imcdemo.views.adapter.IMCAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorialIMCFragment extends Fragment implements IHistorialIMCFragmentListener, OnItemClickListener{

    @Bind(R.id.rvIMCs)
    RecyclerView rvIMCs;

    private IMCAdapter adapter;

    public HistorialIMCFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historial_imc, container, false);
        ButterKnife.bind(this, view);

        initAdapter();
        initRecyclerView();

        return  view;
    }

    private void initAdapter(){
        if (adapter == null){
            adapter = new IMCAdapter(new ArrayList<PersonIMC>(), this);
        }
    }

    private void initRecyclerView(){
        rvIMCs.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvIMCs.setAdapter(adapter);
    }

    @Override
    public void agregar(PersonIMC personIMC) {
        adapter.add(personIMC);
    }

    @Override
    public void limpiar() {
        adapter.clear();
    }

    @Override
    public void onItemClick(PersonIMC personIMC) {
        Intent intent = new Intent(getActivity(), DetalleIMCPersonaActivity.class);

        intent.putExtra(DetalleIMCPersonaActivity.NOMBRE_KEY, personIMC.getNombre());
        intent.putExtra(DetalleIMCPersonaActivity.ALTURA_KEY, String.valueOf(personIMC.getAltura()));
        intent.putExtra(DetalleIMCPersonaActivity.PESO_KEY, String.valueOf(personIMC.getPeso()));
        intent.putExtra(DetalleIMCPersonaActivity.IMC_KEY, String.valueOf(personIMC.getImc()));

        startActivity(intent);
    }
}
