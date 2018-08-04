package com.example.koloh.esthernewsfeedapp;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NewsFeedAdapter extends FragmentPagerAdapter {

    private Set<String> sections;
    private String newsPerPage;
    private String sortOrder;
    private Map<String, String> index = new HashMap<> ();
    private Resources res;

    NewsFeedAdapter(FragmentManager fm, Resources res, SharedPreferences preferences) {
        super ( fm );
        this.res = res;
        sections = preferences.getStringSet ( res.getString ( R.string.news_sections_key ), null );
        newsPerPage = preferences.getString ( res.getString ( R.string.newsfeed_per_page_key ), "10" );
        sortOrder = preferences.getString ( res.getString ( R.string.news_sort_order_key ), "newest" );
        String[] entries = res.getStringArray ( R.array.news_list_preference_entries );
        String[] values = res.getStringArray ( R.array.news_list_preference_entries_values );
        for (int i = 0; i < entries.length; i++) {
            index.put ( values[i], entries[i] );
        }
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return NewsFeedFragment.newInstance ( NewsQueryUtils.getUrl ( null, newsPerPage, sortOrder ) );
        } else {
            return NewsFeedFragment.newInstance ( NewsQueryUtils.getUrl ( (String) sections.toArray ()[position - 1], newsPerPage, sortOrder ) );
        }
    }

    @Override
    public int getCount() {
        return sections == null ? 1 : sections.size () + 1;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return res.getString ( R.string.home );
        } else {
            return index.containsKey ( sections.toArray ()[position - 1] ) ? index.get ( sections.toArray ()[position - 1] ) : res.getString ( R.string.news_sections );
        }
    }
}