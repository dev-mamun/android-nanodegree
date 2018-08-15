package net.alisra.dhakaguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {
    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<Content> content = new ArrayList<Content>();
        content.add(new Content(R.string.res_one, R.string.res_review_one,R.drawable.boomers));
        content.add(new Content(R.string.res_two, R.string.res_review_two,R.drawable.koyla_the_bbq_restaurant));
        content.add(new Content(R.string.res_three, R.string.res_review_three,R.drawable.starkabab));
        ContentAdapter adapter = new ContentAdapter(getActivity(), content, R.color.places);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}
