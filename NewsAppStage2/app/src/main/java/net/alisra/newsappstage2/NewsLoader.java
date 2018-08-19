package net.alisra.newsappstage2;

import android.content.AsyncTaskLoader;
import android.content.Context;

import net.alisra.newsappstage2.News;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader {

    String url;

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
