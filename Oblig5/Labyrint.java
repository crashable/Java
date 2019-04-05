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
  public void Labyrint(int a, int b) {
    lab = new Rute[a][b];
    sizeRow = a;
    sizeCol = b;
  }

  public void lagLab(int a, int b, char c) {
    if (c == '#') {
      lab[a][b] = new HvitRute();
    } else if(c == '.') {
      lab[a][b] = new SortRute();
    }
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
    Labyrint labbe = new Labyrint();
    labbe.Labyrint(szCol, szRow);
    while(scanner.hasNextLine()) {
      for (int i=0; i<szRow; i++) {
        String innlests = scanner.nextLine();
        for (int j=0; j<szCol; i++) {
          labbe.lagLab(i, j, innlests.charAt(j));
        }
      }
    }
    return labbe;
  }

  public String toString() {
    String one;
    for (int i=0; i<sizeCol; i++) {
      for (int j=0; j<sizeRow; j++) {
        one = lab[i][j] + " ";
        if (j == sizeRow) {
          one += "/n";
        }
      }
    }
    return "yo";
  }
}
