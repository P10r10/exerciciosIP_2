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
        if (img == null)
            throw new NullPointerException("Null pointer in method insertImage");
        images[next++] = img;
    }

    void removeImage (int idx){
        if (idx >= MAX || idx < 0)
            throw new IllegalArgumentException("Image index is invalid!");
        if (next == 0)
            throw new IllegalStateException("Collection is empty!");
        images[idx] = images[next - 1];
        next--;
    }
}
