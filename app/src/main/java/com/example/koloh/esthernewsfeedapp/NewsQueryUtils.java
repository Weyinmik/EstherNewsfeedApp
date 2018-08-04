package com.example.koloh.esthernewsfeedapp;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Helper methods related to requesting and receiving newsfeed data from Guardian API.
 */
class NewsQueryUtils {

    private static final String SOURCE = "http://content.guardianapis.com/search?";
    private static final String SECTION_PARAMETER = "section";
    private static final String API_PARAMETER = "api-key";
    private static final String SHOW_TAG_PARAMETER = "show-tags";
    private static final String CONTRIBUTOR_AUTHOR_TAG = "contributor";
    private static final String API_KEY = "640deee2-109e-47f6-80d1-8038dc69cbcd";
    private static final String SORT_PARAMETER = "order-by";
    private static final String SHOW_FIELDS_PARAMETER = "show-fields";
    private static final String PAGE_ENQUIRY_PARAMETER = "page-size";

    static String getUrl(String section, String page, String sortOrder) {
        if (section != null) {
            return Uri.parse ( SOURCE ).buildUpon ()
                    .appendQueryParameter ( SECTION_PARAMETER, section )
                    .appendQueryParameter ( API_PARAMETER, API_KEY )
                    .appendQueryParameter ( SHOW_TAG_PARAMETER, CONTRIBUTOR_AUTHOR_TAG )
                    .appendQueryParameter ( SHOW_FIELDS_PARAMETER, "thumbnail" )
                    .appendQueryParameter ( SORT_PARAMETER, sortOrder )
                    .appendQueryParameter ( PAGE_ENQUIRY_PARAMETER, page ).build ().toString ();

        } else {
            return Uri.parse ( SOURCE ).buildUpon ()
                    .appendQueryParameter ( SECTION_PARAMETER, section )
                    .appendQueryParameter ( API_PARAMETER, API_KEY )
                    .appendQueryParameter ( SHOW_TAG_PARAMETER, CONTRIBUTOR_AUTHOR_TAG )
                    .appendQueryParameter ( SHOW_FIELDS_PARAMETER, "thumbnail" )
                    .appendQueryParameter ( SORT_PARAMETER, sortOrder )
                    .appendQueryParameter ( PAGE_ENQUIRY_PARAMETER, page ).build ().toString ();

        }
    }

    public static URL createUrl(String uri) {
        URL url = null;
        try {
            url = new URL ( uri );
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        }
        return url;
    }
}