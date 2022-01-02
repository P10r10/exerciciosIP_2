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
        if (idx >= next || idx < 0)
            throw new IllegalArgumentException("Image index is invalid!");
        images[idx] = images[next - 1];
        next--;
    }

    void filterInRange(int a, int b){
        if (a < 0 || b >= next || b < 0 || a > b)
            throw new IllegalArgumentException("Invalid range values!");
        for (int i = a; i <= b ; i++)
            images[i] = filter.applyFilter(images[i]);
    }

    void gridImage(int idx){
        if (idx >= next || idx < 0)
            throw new IllegalArgumentException("Invalid index!");
        Main.grid(images[idx], 2, 2);
    }
}
