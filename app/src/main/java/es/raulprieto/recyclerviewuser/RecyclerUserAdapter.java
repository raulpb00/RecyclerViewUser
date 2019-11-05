package es.raulprieto.recyclerviewuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.raulprieto.recyclerviewuser.model.User;
import es.raulprieto.recyclerviewuser.repository.RepositoryUser;

/**
 * @author Raúl Prieto
 * @version 1.0 Classroom
 */
public class RecyclerUserAdapter extends RecyclerView.Adapter<RecyclerUserAdapter.ViewHolder> {

    private Context context;
    private ArrayList<User> list;
    private OnItemClickListener listener;

    /*  The Class that wants to listen to the RecyclerView's onClick event
        must implement the following interface.
        Option 1: Inherit from View.onClickListener
     */
    public interface OnItemClickListener extends View.OnClickListener {
        @Override
        void onClick(View v);
    }
    public RecyclerUserAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.list = ((ArrayList<User>) RepositoryUser.getInstance().getAll());
        this.listener = listener;
    }

    /*public RecyclerUserAdapter(Context context) {
        this.context = context;
        this.list = ((ArrayList<User>) RepositoryUser.getInstance().getAll());
    }*/

    /**
     * Method that inflates from the XML as many ViewHolder objects as they visualize
     *
     * @param parent   Recycler
     * @param viewType viewType
     * @return ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.user_item, parent, false);

        // Option 1: It has been exploited that the OnItemClick Listener exists
        // at all the view objects
        view.setOnClickListener(listener);

        //TODO Sacar información del objeto de la vista pulsada

        return new ViewHolder(view);
    }

    /**
     * Links data to each component of the ViewHolder when scrolling at the RecyclerView
     *
     * @param holder   views's holder
     * @param position at the parent (recycler)
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvUser.setText(list.get(position).getUser());
        holder.tvEmail.setText(list.get(position).getEmail());
    }

    /**
     * Returns the number of elements/data from the datasource
     *
     * @return collection size
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * Stores the views or elements/items View which compose the RecyclerView
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUser;
        TextView tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvEmail = itemView.findViewById(R.id.tvEmail);

        }
    }
}
