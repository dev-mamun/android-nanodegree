package net.alisra.dhakaguide;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsFragment extends Fragment {
    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        // Create a list of content
        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content(R.string.event_one, R.string.event_review_one));
        content.add(new Content(R.string.event_two, R.string.event_review_two));
        content.add(new Content(R.string.event_three, R.string.event_review_three));
        ContentAdapter adapter = new ContentAdapter(getActivity(), content, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;
    }
}
