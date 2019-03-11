public class CarUse3 {
  public static void main(String[] args) {
    Car3 Carthur = new Car3("Carthur 3");
    Person Jonathan = new Person(Carthur);
    Jonathan.write();
  }
}

class Car3 {
  String LicensePlate;
  public Car3(String nr) {
    LicensePlate = nr;
  }
  public String getNumber() {
    return LicensePlate;
  }
  public void write() {
    System.out.println(LicensePlate);
  }
}

class Person {
  Car3 TheCar;
  public Person(Car3 stuff) {
      TheCar = stuff;
  }
  public void write() {
    System.out.println(TheCar.getNumber());
  }
}
