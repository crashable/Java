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
  public Labyrint(Rute[][] labbe, int rad, int kol) {
    lab = labbe;
    sizeRow = rad;
    sizeCol = kol;
  }

  /*public static Rute lagLab(char c) {
    if (c == '#') {
      return new HvitRute();
    } else {
      return new SortRute();
  }
}*/

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
        if (innlests.charAt(col) == '#') {
          labbe[row][col] = new HvitRute(row, col, lab);
        } else {
          labbe[row][col] = new SortRute(row, col, lab);
        }
    //    }
      }
      System.out.println(innlests);
    }
    lab = new Labyrint(labbe, szRow, szCol);
    return lab;
  }

  public String toString() {
    String one;
    for (int i=0; i<sizeRow; i++) {
      for (int j=0; j<sizeCol; j++) {
        one = lab[i][j].tilTegn() + " ";
        if (j == sizeCol) {
          one += "/n";
        }
      }
    }
    return "yo";
  }
}
