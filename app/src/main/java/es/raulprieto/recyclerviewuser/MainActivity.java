package es.raulprieto.recyclerviewuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.raulprieto.recyclerviewuser.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements RecyclerUserAdapter.OnItemClickListener{

    ActivityMainBinding binding;
    RecyclerUserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        userAdapter = new RecyclerUserAdapter(this,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        binding.rvUser.setAdapter(userAdapter);
        binding.rvUser.setLayoutManager(linearLayoutManager);
    }

    /**
     * This method is automatically executed when it's been clicked on an element of the RecyclerView
     * @param view clicked
     */
    @Override
    public void onClick(View view) {

        Toast.makeText(this,"se ha pulsado una opcion: ",Toast.LENGTH_SHORT).show();
    }
}
