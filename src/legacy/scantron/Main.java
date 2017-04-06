package legacy.scantron;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File path = new File("H:\\cs1\\Image Scanner\\src\\com\\company\\unrotates.png");
	    Scanner file = new Scanner(path);
        ImageReader ir = new ImageReader(path);

        ir.printPixels();

    }

}
