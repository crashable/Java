public class CarUse2 {
  public static void main(String[] args) {
    Car2 Cartoon = new Car2("Cartoon 2");
    Cartoon.write();
  }
}

class Car2 {
  String LicensePlate;
  public Car2(String nr) {
    LicensePlate = nr;
  }
  public void write() {
    System.out.println(LicensePlate);
  }
}
