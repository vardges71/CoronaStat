package ca.vgstudio.coronastatisticv1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    EditText countryCode;
    Button showStatistic, clearStatistic;

    private RequestQueue mQueue;

    ArrayList<Statistic> statisticList;
    StatListAdapter statListAdapter;

    public void initialize() {

        listView = findViewById(R.id.listView);
        countryCode = findViewById(R.id.editTextCCode);

        showStatistic = findViewById(R.id.btnShow);
        showStatistic.setOnClickListener(this);
        clearStatistic = findViewById(R.id.btnClear);
        clearStatistic.setOnClickListener(this);

        statisticList = new ArrayList<Statistic>();

        statListAdapter = new StatListAdapter(this, statisticList);
        listView.setAdapter(statListAdapter);

        mQueue = Volley.newRequestQueue(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    @Override
    public void onClick(View v) {

        int btnId = v.getId();

        switch (btnId) {

            case R.id.btnShow:
                jsonParse();
                break;
            case R.id.btnClear:
                statListAdapter.clear();
                countryCode.setText(null);
                break;
        }
    }

    public void jsonParse() {

        String cCode = countryCode.getText().toString();

        String url = "https://thevirustracker.com/free-api?countryTotal" + "=" + cCode;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray jsonArray = response.getJSONArray("countrydata");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject stat = jsonArray.getJSONObject(i);
                                JSONObject info = stat.getJSONObject("info");

                                String title = info.getString("title");
                                int total_cases = stat.getInt("total_cases");
                                int total_recovered = stat.getInt("total_recovered");
                                int total_deaths = stat.getInt("total_deaths");
                                int total_new_cases_today = stat.getInt("total_new_cases_today");
                                int total_new_deaths_today = stat.getInt("total_new_deaths_today");
                                int total_active_cases = stat.getInt("total_active_cases");

                                Statistic st1 = new Statistic(
                                        title,
                                        total_cases,
                                        total_recovered,
                                        total_deaths,
                                        total_new_cases_today,
                                        total_new_deaths_today,
                                        total_active_cases );

                                statisticList.add(st1);
                                statListAdapter.notifyDataSetChanged();

                            }
                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
