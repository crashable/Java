import java.io.*;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    File fil = new File("1.in");
    Labyrint lab = Labyrint.lesFraFil(fil);
    System.out.println(lab);
  }
}
