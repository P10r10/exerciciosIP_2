public class Filter {
    final Color base;
    int width;
    int height;

    Filter(Color color, int width, int height){
        base = color;
        this.width = width;
        this.height = height;
    }

    Filter(ColorImage img){
        base = img.getColor(0, 0);
        width = img.getWidth();
        height = img.getHeight();
    }

    ColorImage applyFilter(ColorImage img){
        ColorImage res = new ColorImage(img.getWidth(), img.getHeight());
        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        for (int x = 0; x < res.getWidth(); x++)
            for (int y = 0; y < res.getHeight(); y++)
                res.setColor(x,y, white);
        for (int x = 0; x < img.getWidth(); x++)
            for (int y = 0; y < img.getHeight(); y++)
                if (img.getColor(x, y).getR() == base.getR() &&
                    img.getColor(x, y).getG() == base.getG() &&
                    img.getColor(x, y).getB() == base.getB())
                    res.setColor(x, y, black);
                else
                    res.setColor(x, y, img.getColor(x, y));
        return res;
    }

    boolean hasChanges(ColorImage img){
        ColorImage res = applyFilter(img);
        for (int x = 0; x < img.getWidth(); x++)
            for (int y = 0; y < img.getHeight(); y++)
                if (img.getColor(x, y).getR() != res.getColor(x, y).getR() &&
                    img.getColor(x, y).getG() != res.getColor(x, y).getG() &&
                    img.getColor(x, y).getB() != res.getColor(x, y).getB())
                        return true;
        return false;
    }
}
