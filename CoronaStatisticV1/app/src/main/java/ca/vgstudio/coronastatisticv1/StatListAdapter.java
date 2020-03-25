package ca.vgstudio.coronastatisticv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StatListAdapter extends ArrayAdapter<Statistic> {

    public StatListAdapter(@NonNull Context context, ArrayList<Statistic> names) {
        super(context, R.layout.statistic, names);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = convertView;

        if (customView == null){
            customView = inflater.inflate(R.layout.statistic, parent,false);
        }

        Statistic statistic = getItem(position);
        TextView resultCountry = (TextView) customView.findViewById(R.id.resultCountry);
        TextView resultTCases = (TextView) customView.findViewById(R.id.resultTCases);
        TextView resultTRecovered = (TextView) customView.findViewById(R.id.resultTRecovered);
        TextView resultTDeaths = (TextView) customView.findViewById(R.id.resultTDeaths);
        TextView resultNCases = (TextView) customView.findViewById(R.id.resultNCases);
        TextView resultNDeaths = (TextView) customView.findViewById(R.id.resultNDeaths);
        TextView resultACases = (TextView) customView.findViewById(R.id.resultACases);


        resultCountry.setText(statistic.getResultCountry());
        resultTCases.setText(String.valueOf(statistic.getResultTCases()));
        resultTRecovered.setText(String.valueOf(statistic.getResultTRecovered()));
        resultTDeaths.setText(String.valueOf(statistic.getResultTDeaths()));
        resultNCases.setText(String.valueOf(statistic.getResultNCases()));
        resultNDeaths.setText(String.valueOf(statistic.getResultNDeaths()));
        resultACases.setText(String.valueOf(statistic.getResultACases()));

        return customView;
    }
}
