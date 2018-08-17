package net.alisra.newsappstage2;

import android.content.AsyncTaskLoader;
import android.content.Context;

import net.alisra.newsappstage2.News;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader {

    private final String apiKey = "e36fef29-fdff-4b39-a41b-395c2f6a2d4d";
    String url;
    /*private static String REQUEST_URL =
            "http://content.guardianapis.com/search?show-tags=contributor&api-key="+this.apiKey;*/

    public NewsLoader(Context context, String url) {

        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (url == null) {
            return null;
        }

        List<News> newsList = QueryUtils.fetchNewsData(url);
        return newsList;
    }
}
