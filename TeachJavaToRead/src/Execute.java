import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by preston on 3/28/17.'
 * This class will be used to execute things.
 */
public class Execute {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("path/to/the/thing"));

        while(s.hasNextLine()){
            try {
                BufferedImage image = ImageIO.read(new File(s.nextLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
