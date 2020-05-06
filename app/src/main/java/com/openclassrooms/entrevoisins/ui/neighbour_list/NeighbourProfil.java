package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.databinding.ActivityNeighbourProfilBinding;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class NeighbourProfil extends AppCompatActivity {

    private ActivityNeighbourProfilBinding binding;
    private Neighbour neighbour;
    private NeighbourApiService mApiService = DI.getNeighbourApiService();
    int tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNeighbourProfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        neighbour = getNeighbour();
        resetText();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(neighbour.isFavorite()) removeToFavorites(neighbour);  // si le neighbour est deja favoris, il ne l'est plus
                else addToFavorites(neighbour); // sinon il le devient
            }
        });

        binding.btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {NeighbourProfil.this.finish();} // clos l'activity de manière à revenir à la précédente
        });
    }

    private Neighbour getNeighbour(){
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1); // récupère la valeur position de l'élément sur lequel on a cliqué
        tag = intent.getIntExtra("tag",-1); // et le tag de l'instance pour savoir si l'on vient de la liste complète ou de celle des favoris
        if(tag == 0) neighbour = mApiService.getNeighbours().get(position); // on récupère le neighbour grace à sa position, dans la bonne liste grace au tag
        else neighbour = mApiService.getFavorites().get(position);
        return neighbour;
    }

    private void resetText(){
        binding.ppseudo.setText(neighbour.getName());
        Glide.with(binding.pAvatar).load(neighbour.getAvatarUrl()).into(binding.pAvatar);
        binding.nameInAvatar.setText(neighbour.getName());
        binding.localisation.setText(neighbour.getAddress());
        binding.telephone.setText(neighbour.getPhoneNumber());
        binding.mail.setText(neighbour.getAvatarUrl());
        binding.description.setText(neighbour.getAboutMe());
        if(neighbour.isFavorite())binding.fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_yellow_24dp));
    }

    public void removeToFavorites(Neighbour neighbour){
        neighbour.setFavorite(false);
        binding.fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_black_24dp));
    }

    public void addToFavorites(Neighbour neighbour){
        neighbour.setFavorite(true);
        binding.fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_yellow_24dp));
    }
}
