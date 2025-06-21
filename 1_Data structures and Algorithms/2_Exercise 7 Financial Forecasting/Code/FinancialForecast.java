public class FinancialForecast {

    static double predictFutureValue(double[] values, int years) {
        double growthRate = (values[values.length - 1] / values[0]) - 1;
        return predict(values[values.length - 1], growthRate, years, new double[years + 1]);
    }

    static double predict(double current, double rate, int years, double[] memo) {
        if (years == 0) return current;
        if (memo[years] != 0) return memo[years];
        return memo[years] = predict(current * (1 + rate), rate, years - 1, memo);
    }

    public static void main(String[] args) {

        System.out.println("Recursion solves a problem by calling itself with smaller inputs," +
                " ideal for problems with repetitive substructure. " +
                "In this forecasting tool, recursion models compound growth over time. " +
                "The basic recursive solution has O(n) time complexity for predicting n years" +
                " but can still be inefficient if overlapping calculations occur. " +
                "Memoization improves this by storing results of subproblems, " +
                "preventing redundant computations and optimizing performance significantly.");

        double[] pastValues = {1000, 1100, 1210, 1331};
        int yearsToPredict = 3;
        double predicted = predictFutureValue(pastValues, yearsToPredict);
        System.out.println(predicted);
    }
}
