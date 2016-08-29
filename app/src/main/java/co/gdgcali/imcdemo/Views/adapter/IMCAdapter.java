package co.gdgcali.imcdemo.views.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.gdgcali.imcdemo.R;
import co.gdgcali.imcdemo.modelo.PersonIMC;
import co.gdgcali.imcdemo.views.fragment.OnItemClickListener;

/**
 * Created by jggomezt on 12/08/2016.
 */
public class IMCAdapter extends RecyclerView.Adapter<IMCAdapter.ViewHolderIMC> {

    private List<PersonIMC> dataset;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public IMCAdapter(List<PersonIMC> dataset, OnItemClickListener onItemClickListener, Context context) {
        this.dataset = dataset;
        this.onItemClickListener = onItemClickListener;
        this.context = context;
    }

    @Override
    public ViewHolderIMC onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item_historial, parent, false);
        return new ViewHolderIMC(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderIMC holder, int position) {
        PersonIMC elemento = dataset.get(position);

        DecimalFormat df = new DecimalFormat("0.00");

        holder.txtIMC.setText(String.format("%s IMC", df.format(elemento.getImc())));
        holder.txtNombre.setText(elemento.getNombre());
        holder.txtAltura.setText(String.format("%s mts", String.valueOf(elemento.getAltura())));
        holder.txtPeso.setText((String.format("%s kgs", String.valueOf(elemento.getPeso()))));

        if (elemento.getImgPerfil() == null) {
            Picasso.with(context).load(R.drawable.icon_person).resize(130, 130).centerCrop().into(holder.img);
        } else {
            Picasso.with(context).load(elemento.getImgPerfil()).resize(130, 130).centerCrop().into(holder.img);
        }

        holder.setOnClickItemListener(elemento, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add(PersonIMC record) {
        dataset.add(0, record);
        notifyDataSetChanged();
    }

    public void addListaPersonas(List<PersonIMC> lstRecord) {
        dataset = lstRecord;
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolderIMC extends RecyclerView.ViewHolder {

        @Bind(R.id.item_Nombre)
        TextView txtNombre;

        @Bind(R.id.item_Peso)
        TextView txtPeso;

        @Bind(R.id.item_Altura)
        TextView txtAltura;

        @Bind(R.id.item_IMC)
        TextView txtIMC;

        @Bind(R.id.item_img)
        ImageView img;

        public ViewHolderIMC(View itemview) {
            super(itemview);
            ButterKnife.bind(this, itemview);
        }

        public void setOnClickItemListener(final PersonIMC elemento, final OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(elemento);
                }
            });
        }
    }
}
