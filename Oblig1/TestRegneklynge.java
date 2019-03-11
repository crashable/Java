class TestRegneklynge {
    public static void main(String[] args) {
        Regneklynge regneklynge = new Regneklynge(3);

        Node n1 = new Node(1,2);
        Node n2 = new Node(3,4);
        Node n3 = new Node(5,6);
        Node n4 = new Node(7,8);
        Node n5 = new Node(9,0);
        Rack r1 = new Rack(2);
        Rack r2 = new Rack(3);

        regneklynge.addNodeToClusterfuck(n1);
        regneklynge.addNodeToClusterfuck(n2);
        regneklynge.addNodeToClusterfuck(n3);
        regneklynge.addNodeToClusterfuck(n4);
        regneklynge.addNodeToClusterfuck(n5);
        //regneklynge.writeNodes();
    }
}
