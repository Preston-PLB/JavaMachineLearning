import legacy.scantron.Pixel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

/**
 * Created by preston on 3/28/17.
 * This class will handle the image translation for processing in the Logic class
 */

// TODO write the documentation crap
public class Image {
    private BufferedImage image;
    private Pixel[] pixelArray;

    public Image(String path){
        try {
            image = ImageIO.read(new File(path));
            generatePixelArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image(File file){
        try {
            image = ImageIO.read(file);
            generatePixelArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image(BufferedImage image){
        this.image = image;
        generatePixelArray();
    }

    private void generatePixelArray(){
        byte[] raw = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        for(int i = 0; i<300000/4-3; i++){
            pixelArray[i] = new Pixel(raw[i],raw[i+1],raw[i+2],raw[i+3]);
        }
    }

    void calculateSectorRatio(){
        
    }

}
