class Test {

    public static void main(String[] args) {
        Logger obj = Logger.getInstance();
        Logger obj2 = Logger.getInstance();

        if(obj == obj2) {
            System.out.println("Singleton implemented successfully");
        }

        else {
            System.out.println("Single pattern wasn't successfully implemented");
        }

    }
}
