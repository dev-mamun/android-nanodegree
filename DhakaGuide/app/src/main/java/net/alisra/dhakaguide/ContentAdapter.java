package net.alisra.dhakaguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentAdapter extends ArrayAdapter<Content> {
    private int mColorResourceId;

    /**
     * Create a new {@link ContentAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param content         is the list of {@link Content}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public ContentAdapter(Context context, ArrayList<Content> content, int colorResourceId) {
        super(context, 0, content);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Content currentItem = getItem(position);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(currentItem.getName());
        TextView review = (TextView) convertView.findViewById(R.id.review);
        review.setText(currentItem.getReview());
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        if (currentItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentItem.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
        View textContainer = convertView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return convertView;
    }
}
