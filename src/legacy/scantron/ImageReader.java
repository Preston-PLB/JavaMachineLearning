package legacy.scantron;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

/**
 * Created by 131111 on 9/27/2016.
 */
public class ImageReader {
    private BufferedImage image;
    private byte[] raw;
    private Pixel[] pixels;
    private int fileWidth;
    private int fileHeight;
    private int scaleFactor;
    private int rotation;
    private File base;

    public ImageReader(File f)throws IOException{
        pixels = new Pixel[300000/4];
        try {
            image = new BufferedImage(250, 300, BufferedImage.TYPE_4BYTE_ABGR);
            image = ImageIO.read(f);
        }catch(Exception e){
            System.out.println("Error while parsing image:\n"+e);
        }
        raw = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        for(int i = 0; i<300000/4-3; i++){
            pixels[i] = new Pixel(raw[i],raw[i+1],raw[i+2],raw[i+3]);
        }
        System.out.println("help");
    }

    public void printPixels(){
        int count = 0;
        for(byte i: raw){
            count++;
            System.out.print(i+", ");
        }
        System.out.println();
        System.out.println(count);
    }

    private void findRotation() {

    }

    public int getChoice(int row, int scaleFactor, int[][] image) {
        int[] filledIn = new int[4];
        row = row*scaleFactor;
        int yStart = row-(2*scaleFactor);
        int xStart = 9*scaleFactor;
        int choice = 0;

        for(int i = 0; i<4; i++){
            for(int y = yStart; y < yStart+4; y++){
                for(int x = xStart; x < xStart+3; x++){
                    if(image[y][x] == 1){
                        filledIn[i]++;
                    }
                }
            }
            xStart+=9;
        }
        for(int a = 0; a<4; a++){
            for(int b = 0; b<4; b++){
                if(filledIn[b] > filledIn[a]){
                    choice = b+1;
                }
            }
        }
        return choice;
    }



    public int getScaleFactor() {
        return scaleFactor;
    }

    public int getRotation() {
        return rotation;
    }
}
