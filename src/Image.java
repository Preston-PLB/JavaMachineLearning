import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by preston on 3/28/17.
 * This class will handle the image translation for processing in the Logic class
 */

// TODO write the documentation crap
public class Image {

    static double[] getRatios(File file){
        double[] ratios = new double[9];
        try {
            BufferedImage image = ImageIO.read(file);
            int height = image.getHeight();
            int width = image.getWidth();
            BufferedImage[] subs = new BufferedImage[9];
            int spot = 0;

            for(int y = 0; y<3; y++){
                for(int x = 0; x<3; x++){
                    subs[spot] = image.getSubimage(x*(height/3), y*(width/3), height/3, width/3);
                    spot++;
                }
            }

            int subIndex = 0;
            for(BufferedImage i: subs){
                double light = 0, dark = 0;
                for(int y = 0; y<i.getWidth(); y++){
                    for(int x = 0; x<i.getHeight(); x++){
                        if(getAverageRGB(i.getRGB(x,y)) > 127){
                            light++;
                        }else{
                            dark++;
                        }
                    }
                }
                ratios[subIndex++] = dark/light*100;
            }

            System.out.println(Arrays.toString(ratios));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratios;
    }

    static void printImage(BufferedImage image){
        String out ="";
        for(int y = 0; y<image.getWidth(); y++){
           out += "[";
           for(int x = 0; x<image.getHeight(); x++){
               int rgb = image.getRGB(x,y);
               int r = (rgb>>16)&255;
               int g = (rgb>>8)&225;
               int b = (rgb)&255;
               out+="R:"+r+",G:"+g+",B:"+b+" | ";
           }
           out+="]\n";
        }
        System.out.println(out);
    }

    private static int getAverageRGB(int rgb){
        int r = (rgb>>16)&255;
        int g = (rgb>>8)&225;
        int b = (rgb)&255;

        return (r+b+g)/3;
    }
}
