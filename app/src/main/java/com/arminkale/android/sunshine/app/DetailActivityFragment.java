package com.arminkale.android.sunshine.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private static final String LOG_TAG = DetailActivityFragment.class.getSimpleName();
    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private String mForecastStr;

    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_detail, container, false);
        //Log.v("DetailActivityFragment", "1");
        Intent intent = getActivity().getIntent();
        //Log.v("DetailActivityFragment", "2");
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        //Log.v("DetailActivityFragment", "3");
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            mForecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
        }

        if (mForecastStr != null) {
            ((TextView) rootView.findViewById(R.id.detail_text)).setText(mForecastStr);
            //Log.v("DetailActivityFragment", "4");
        }

        //Log.v("DetailActivityFragment", "5");
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        // Inflate the menu; this adds items to the action bar if it is present.
        //inflater.inflate(R.menu.detail, menu);

        // Retrieve the share menu item.
        MenuItem menuItem = menu.findItem(R.id.action_share);

        // Get the provider and hold onto it to set/change the share intent.
        ShareActionProvider mShareActionProvier =
                (ShareActionProvider)MenuItemCompat.getActionProvider(menuItem);

        // Attach an intent to this ShareActionProiver. You can update this at any time,
        // like when the user selects a new piece of data they might like to share.
        if (mShareActionProvier != null) {
            mShareActionProvier.setShareIntent(createShareForecastIntent());
        } else {
            Log.d(LOG_TAG, "Share Action Provider is null!");
        }
    }

    private Intent createShareForecastIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mForecastStr + FORECAST_SHARE_HASHTAG);
        return shareIntent;
    }
}