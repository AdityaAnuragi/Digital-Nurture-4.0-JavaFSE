class Logger {
    private static Logger obj = null;

    private Logger() {
        // preventing the default constructor
    }

    public static Logger getInstance() {
        if(obj == null) {
            obj = new Logger();
        }

        return obj;
    }

}
