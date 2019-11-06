package es.raulprieto.recyclerviewuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.raulprieto.recyclerviewuser.databinding.ActivityMainBinding;
import es.raulprieto.recyclerviewuser.model.User;

public class MainActivity extends AppCompatActivity implements RecyclerUserAdapter.OnItemClickListener {

    private ActivityMainBinding binding;
    private RecyclerUserAdapter userAdapter;
    private RecyclerUserAdapter.OnUserClickListener userListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        userAdapter = new RecyclerUserAdapter(this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        binding.rvUser.setAdapter(userAdapter);
        binding.rvUser.setLayoutManager(linearLayoutManager);

        /*
         * Method used for initialize all the Activity Listeners
         */
        initializeListener();
    }

    /**
     * Method where all Listeners/Delegates are initialized
     */
    private void initializeListener() {
        userListener = new RecyclerUserAdapter.OnUserClickListener() {
            @Override
            public void onClick(User user) {
                Toast.makeText(MainActivity.this, user.getUser(), Toast.LENGTH_SHORT).show();
            }
        };
        userAdapter.setOnUserClickListener(userListener);
    }

    /**
     * This method is automatically executed when it's been clicked on an element of the RecyclerView
     *
     * @param view clicked
     */
    @Override
    public void onClick(View view) {
        Toast.makeText(this, getUSerSelected(view).toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * Returns the User Object based on the position of the View given.
     * This method is called from the Option 1 of the ClickListeners
     * @param view clicked
     * @return User object at that view
     */
    private User getUSerSelected(View view) {
        int itemPositionInList = binding.rvUser.getChildAdapterPosition(view);

        return userAdapter.getUser(itemPositionInList);
    }
}
