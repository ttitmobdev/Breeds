package com.example.user.breeds;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BreedsAdapter extends RecyclerView.Adapter<BreedsAdapter.ViewHolder> {
    private List<BreedResponse> breedResponseList;

    public BreedsAdapter(List<BreedResponse> breedResponseList) {
        this.breedResponseList = breedResponseList;
    }

    @NonNull
    @Override
    public BreedsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_breed,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BreedsAdapter.ViewHolder viewHolder, int i) {
        viewHolder.breedName.setText((CharSequence) breedResponseList.get(i).getMessage());
    }

    @Override
    public int getItemCount() {
        if (breedResponseList!=null)
            return breedResponseList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView breedName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           breedName = itemView.findViewById(R.id.breedName);

        }
    }
}
