class TestBaathus {
    public static void main(String[] args) {
        Baathus baathus = new Baathus(3);

        Baat b1 = new Baat("Triton");
        Baat b2 = new Baat("Chaparral");
        Baat b3 = new Baat("Mercury");
        Baat b4 = new Baat("Mercury");

        baathus.settInn(b1);
        baathus.settInn(b2);
        baathus.settInn(b3);
        baathus.settInn(b4);

        baathus.skrivBaater();
    }
}
