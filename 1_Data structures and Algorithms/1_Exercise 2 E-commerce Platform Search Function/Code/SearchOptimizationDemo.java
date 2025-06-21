import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

class SearchOptimizationDemo {

    public static void printProduct(Product product) {
        if (product != null) {
            System.out.println("Product Found: ID=" + product.productId + ", Name=" + product.productName + ", Category=" + product.category);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int left = 0, right = sortedProducts.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sortedProducts[mid].productId == targetId) {
                return sortedProducts[mid];
            } else if (sortedProducts[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void sortProductsById(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt((product) -> product.productId) );
    }

    public static void main(String[] args) {

        System.out.println("Big O notation is a way to describe how the time or space needed by an algorithm " +
                "grows as the size of the input increases. It helps developers understand and compare" +
                " the efficiency of different algorithms, especially as data becomes large.");

        System.out.println("Linear Search -");
        System.out.println("Best case - O(n)");
        System.out.println("Worst case - O(n)");
        System.out.println("Average case - O(n)");

        System.out.println("Binary search -");
        System.out.println("Best case - O(log n)");
        System.out.println("Worst case - O(log n)");
        System.out.println("Average case - O(log n)");

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(205, "Shoes", "Footwear"),
                new Product(150, "Book", "Stationery"),
                new Product(350, "Mobile", "Electronics"),
                new Product(275, "T-shirt", "Apparel")
        };

        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        sortProductsById(sortedProducts);

        int targetId = 150;

        System.out.println("Linear Search:");
        Product resultLinear = linearSearch(products, targetId);
        printProduct(resultLinear);

        System.out.println("\nBinary Search:");
        Product resultBinary = binarySearch(sortedProducts, targetId);
        printProduct(resultBinary);

        System.out.println("\n--- Analysis ---");
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n)");
        System.out.println("Binary Search requires the data to be sorted by productId.");
        System.out.println("Binary Search is more efficient for large datasets.");
    }
}
