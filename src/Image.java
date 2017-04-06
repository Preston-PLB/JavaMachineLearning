import legacy.scantron.Pixel;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by preston on 3/28/17.
 * This class will handle the image translation for processing in the Logic class
 */

// TODO write the documentation crap
public class Image {
    private BufferedImage image;
    private Pixel[] pixelArray;
    byte[] b;

    public Image(String path){
        try {
            image = ImageIO.read(new File(path));
            generatePixelArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image(){
        try {
            b = IOUtils.toByteArray(new FileInputStream("C:\\Users\\131111\\Downloads\\Lone_Star_Soccer_Logo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(b));
    }

    public Image(BufferedImage image){
        this.image = image;
        generatePixelArray();
    }

    private void generatePixelArray(){

    }

    void calculateSectorRatio(){
        
    }

}
