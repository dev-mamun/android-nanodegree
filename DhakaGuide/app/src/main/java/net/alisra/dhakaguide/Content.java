package net.alisra.dhakaguide;



public class Content {
    /**
     * String resource ID for the names
     */
    private int mName;

    /**
     * String resource ID for the review
     */
    private int mReview;

    /**
     * Image resource ID for the content
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Content object.
     *
     * @param name   is the string resource ID for name of restaurants, places, etc.
     * @param review is the string resource Id for reviews
     */
    public Content(int name, int review) {
        mName = name;
        mReview = review;
    }

    /**
     * Create a new Content object.
     *
     * @param name            is the string resource ID for name of restaurants, places, etc.
     * @param review          is the string resource Id for reviews
     * @param imageResourceId is the drawable resource ID for the image associated with content
     */
    public Content(int name, int review, int imageResourceId) {
        mName = name;
        mReview = review;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the name.
     */
    public int getName() {
        return mName;
    }

    /**
     * Get the string resource ID for review.
     */
    public int getReview() {
        return mReview;
    }

    /**
     * Return the image resource ID of the content.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
