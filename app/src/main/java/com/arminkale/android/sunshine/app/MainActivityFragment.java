package com.arminkale.android.sunshine.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Add sample data array
        String[] forecastArray = {
                "Today - Sunny - 70/55",
                "Tomorrow - Mostly Cloudy - 75/52",
                "Monday - Cloudy - 59/54",
                "Tuesday - Rainy - 59/54",
                "Wednesday - Rainy - 66/59",
                "Thursday - Windy - 70/45",
                "Friday - Sunny - 64/39",
                "Saturday - Snow - 32/20",
                "Sunday - Sleet - 38/29",
                "Monday - Rain - 45/36"
        };

        //Create list of strings from array
        List<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

        //Create array adapter with our text view
        ArrayAdapter<String> forecastArrayAdapter =
                new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.list_item_forecast,
                        R.id.list_item_forecast_textview,
                        weekForecast);

        //Find list view
        ListView listView = (ListView)rootView.findViewById(R.id.listview_forecast);
        //Set the array adapter as the list view adapter
        listView.setAdapter(forecastArrayAdapter);

        return rootView;
    }
}
