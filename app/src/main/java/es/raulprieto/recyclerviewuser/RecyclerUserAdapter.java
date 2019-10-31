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

    public RecyclerUserAdapter(Context context) {
        this.context = context;
        this.list = ((ArrayList<User>) RepositoryUser.getInstance().getAll());
    }

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

//        WARNING: The item layout's height has to be wrap_content in order to avoid showing single items per window at the RecyclerView
        View view = layoutInflater.inflate(R.layout.user_item, parent, false);

        return new ViewHolder(view);
    }

    /**
     * Links data to each component of the ViewHolder when scrolling at the RecyclerView
     *
     * @param holder views's holder
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
