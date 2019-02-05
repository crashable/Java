import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Regneklynge {
  public List<Rack> regneklynge;
  int antNodes;
  boolean adding = true; //Checks if rack is full.
  int counting = 0; //Counts how many racks in Clusterfuck.
  int counts = 0; //Counts if the rack in Clusterfuck is full.
  int amount;
  int minne;
  int pros;
/*
  public Regneklynge(int ants) {
    regneklynge = new ArrayList<>();
    antNodes = ants;
  }
*/

  public Regneklynge(String filename) throws Exception {
    regneklynge = new ArrayList<>();
    Scanner fil = new Scanner(new File(filename));
    String linje = "";
    linje = fil.nextLine();
    antNodes = Integer.parseInt(linje);
    while(fil.hasNextLine()) {
      linje = fil.nextLine();
      String[] delt = linje.split(" ");
      amount = Integer.parseInt(delt[0]);
      minne = Integer.parseInt(delt[1]);
      pros = Integer.parseInt(delt[2]);
      for (int i=0; i<amount; i++) {
        addNodeToClusterfuck(minne, pros);
      }
    }
  }
  public int antProsessorer() {
    int curPros = 0;  //Current Processor amount.
    for (int i=0; i<regneklynge.size(); i++) {
      curPros += regneklynge.get(i).antProsessorer();
    }
    return curPros;
  }//test

  public int noderMedNokMinne(int paakrevdMinne) {
    int curNodes = 0;
    for (int i=0; i<regneklynge.size(); i++) {
      curNodes += regneklynge.get(i).noderMedNokMinne(paakrevdMinne);
    }
    return curNodes;
  }

  public void addNodeToClusterfuck(int minne, int pros) {
    if (adding == false) {
      if (regneklynge.get(counting-1) != null) {
        regneklynge.get(counting-1).AddNode(minne, pros);
        counts++;
        if (counts == antNodes) {
          adding = true;
          counts = 0;
        }
      }
    } else {
        counting++;
        Rack aRack = new Rack(antNodes);
        regneklynge.add(aRack);
        regneklynge.get(counting-1).AddNode(minne, pros);
        counts++;
        adding = false;
    }
  }
}
