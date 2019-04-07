import java.io.*;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    File fil = new File("3.in");
    Labyrint lab = Labyrint.lesFraFil(fil);
    //System.out.println(lab);
    //System.out.println(lab.getRute(4,0).north);
    //lab.getRute(1,1).gaa("");
    //lab.getRute(3,5).finnUtvei();
    lab.finnUtveiFra(5,3);
  }
}
