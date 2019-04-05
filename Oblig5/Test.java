import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Labyrint test = new Labyrint();
    File fil = new File("1.in");
    test.lesFraFil(fil);
    test.toString();
  }
}
