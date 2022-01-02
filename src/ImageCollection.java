public class ImageCollection {
    final int MAX = 10;
    ColorImage[] images;
    Filter filter;
    int next = 0;

    ImageCollection(ColorImage img, Filter filter){
        images = new ColorImage[MAX];
        images[next++] = img;
        this.filter = filter;
    }

    void insertImage (ColorImage img){
        if (next == MAX)
            throw new IllegalStateException("Collection full!");
        images[next++] = img;
    }
}
