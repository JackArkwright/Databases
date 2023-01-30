class Main {
    public static void main(String[] args) {
        // test the database works
        FileHandler.emptyFile("test.txt");
        System.out.println("Database");
        Database db = new Database("test.txt", 10);
        db.appendRecord("thisiswaytoolong");
        db.appendRecord("1.ABCDEFGH");
        db.appendRecord("2.ABCDEFGH");
        db.appendRecord("3.ABCDEFGH");
        db.appendRecord("4.ABCDEFGH");
        db.appendRecord("short");
        System.out.println(db.getRecord(2));	 // should be "2.ABCDEFGH"
        System.out.println(db.findRecord("EBCDEFGHIJ")); // false
        System.out.println(db.findRecord("2.ABCDEFGH")); // true
        System.out.println("count = " + db.getRecordCount()); // 4
    }
}

