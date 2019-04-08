import java.io.*;
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Labyrint lab = null;
    try {
      File fil = new File("7.in");
      lab = Labyrint.lesFraFil(fil);
    } catch (FileNotFoundException e) {
      System.out.println("Error");
    }
    //System.out.println(lab);
    //System.out.println(lab.getRute(4,0).north);
    //lab.getRute(1,1).gaa("");
    //lab.finnUtveiFra(2,1).print();
    //lab.finnUtvei();
    Stabel<String> test = lab.finnUtveiFra(1,1);
    //for (String e: test) {
    //  System.out.println(e);
    //}
    test.print();
    System.out.println(lab.aapninger);
    //System.out.println(lab.rutevei);
  }
}
