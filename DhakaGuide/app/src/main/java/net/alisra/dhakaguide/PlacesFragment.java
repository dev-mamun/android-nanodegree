package net.alisra.dhakaguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {
    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        // Create a list of content
        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content(R.string.place_one, R.string.place_review_one,R.drawable.ahsanmanzil));
        content.add(new Content(R.string.place_two, R.string.place_review_two,R.drawable.lalbaghfort));
        content.add(new Content(R.string.place_three, R.string.place_review_three,R.drawable.sonargaon));
        ContentAdapter adapter = new ContentAdapter(getActivity(), content, R.color.places);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}
