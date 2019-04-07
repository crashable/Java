import java.util.*;
import java.io.*;

public class Labyrint {
  /*
  Labyrint inneholder et todimensjonalt Rute-array med referanser til alle rutene i labyrinten og
  bør ta vare på antall rader og kolonner. I tillegg skal hele labyrinten kunne returneres i et
  format som enkelt kan skrives ut til terminalen underveis (bruk gjerne toString-metoden til
  dette). Du kan bruke den samme representasjonen som i filformatet, men dette er valgfritt.
  */
  int sizeCol;
  int sizeRow;
  Rute[][] lab;
  public static String rutevei = "";
  public static ArrayList<String> aapninger = new ArrayList<String>();
  private Labyrint(Rute[][] labbe, int rad, int kol) {
    lab = labbe;
    sizeRow = rad;
    sizeCol = kol;
  }

  public static Labyrint lesFraFil(File fil) {
    Scanner scanner = null;
    int szCol;
    int szRow;
    try {
      scanner = new Scanner(fil);
    }catch(FileNotFoundException e) {
      System.out.println("Fant ikke filen.");
      //return new Labyrint();
    }
    String innlest = scanner.nextLine();
    String[] info = innlest.split(" ");
    szRow = Integer.parseInt(info[0]);
    szCol = Integer.parseInt(info[1]);
    Rute[][] labbe = new Rute[szRow][szCol];
    //Labyrint labbe = new Labyrint();
    //labbe.Labyrint();
    //while(scanner.hasNextLine()) {
    Labyrint lab = null;
    for (int row=0; row<szRow; row++) {
      String innlests = scanner.nextLine();
      for (int col=0; col<szCol; col++) {
        //labbe.lagLab(row, col, innlests.charAt(col));
        if (innlests.charAt(col) == '.') {
          if (row==0 || row==szRow-1 || col==0 || col==szCol-1) {
            labbe[row][col] = new Aapning(row, col, lab);
          } else {
            labbe[row][col] = new HvitRute(row, col, lab);
          }
        } else {
          labbe[row][col] = new SortRute(row, col, lab);
        }
    //    }
      }
    }
    for (int row=0; row<szRow; row++) {
      for (int col=0; col<szCol; col++) {
        if (row>0) {
          labbe[row][col].north = labbe[row-1][col];
        }
        if (col>0) {
          labbe[row][col].west = labbe[row][col-1];
        }
        if (row<szRow-1) {
          labbe[row][col].south = labbe[row+1][col];
        }
        if (col<szCol-1) {
          labbe[row][col].east = labbe[row][col+1];
        }
      }
    }
    lab = new Labyrint(labbe, szRow, szCol);
    return lab;
  }

  public Rute getRute(int a, int b) {
    return lab[a][b];
  }

  public String toString() {
    String one = "";
    for (int i=0; i<sizeRow; i++) {
      for (int j=0; j<sizeCol; j++) {
        one += lab[i][j].tilTegn() + "";
      }
      one += "\n";
    }
    return one;
  }

  public ArrayList<String> finnUtveiFra(int kol, int rad) {
    getRute(rad, kol).finnUtvei();
    System.out.println(rutevei);
    return aapninger;

  }

}
