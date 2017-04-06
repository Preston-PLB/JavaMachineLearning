package legacy.scantron;

/**
 * Created by 131111 on 10/17/2016.
 */
public class Pixel{
    private int[] rgba;

    public Pixel(){

    }

    public Pixel(int r, int g, int b, int a){
        rgba = new int[4];
        rgba[0] = r;
        rgba[1] = g;
        rgba[2] = b;
        rgba[3] = a;
    }

    public boolean isBlack(){
        return rgba[0] == 255 && rgba[1] == 255 && rgba[2] == 255;
    }

}
