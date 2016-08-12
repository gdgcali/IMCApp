package co.gdgcali.imcdemo.views.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

    public IMCAdapter(List<PersonIMC> dataset, OnItemClickListener onItemClickListener){
        this.dataset = dataset;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolderIMC onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item, parent, false);
        return new ViewHolderIMC(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderIMC holder, int position) {
        PersonIMC elemento = dataset.get(position);
        holder.txtIMC.setText(elemento.toString());
        holder.setOnClickItemListener(elemento, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add(PersonIMC record){
        dataset.add(0, record);
        notifyDataSetChanged();
    }

    public void clear(){
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolderIMC extends RecyclerView.ViewHolder{

        @Bind(R.id.list_txt_imc)
        TextView txtIMC;

        public ViewHolderIMC(View itemview){
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
