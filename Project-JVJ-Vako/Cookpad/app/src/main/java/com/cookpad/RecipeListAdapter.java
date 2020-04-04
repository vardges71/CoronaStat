package com.cookpad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class RecipeListAdapter extends ArrayAdapter<Recipe> {

    RecipeListAdapter(@NonNull Context context, ArrayList<Recipe> names) {
        super(context, R.layout.listview_layout,names);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = convertView;

        if (customView == null){
            customView = inflater.inflate(R.layout.listview_layout,parent,false);
        }

        Recipe recipe = getItem(position);
        TextView tvRecipeName = customView.findViewById(R.id.tvRecipeName);
        TextView tvRecipeOrigin = customView.findViewById(R.id.tvRecipeOrigin);
//        tvRecipeName.setText(recipe.getRecipeName());
//        tvRecipeOrigin.setText(recipe.getCountryOrigin());

        return customView;
    }
}
