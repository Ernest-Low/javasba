package sg.edu.ntu.assignment;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.Optional;

// 3.9 Sprint-intro assignment
@RestController
public class ProductController {

    ArrayList<Products> myProducts = new ArrayList<>();

    @GetMapping("/products/seed")
    public void getMethodName() {
        System.out.println("Seeding.");
        myProducts.add(new Products(1, "Apple"));
        myProducts.add(new Products(2, "Banana"));
        myProducts.add(new Products(3, "Carrot"));
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable String id) {
        Optional<Products> product = myProducts.stream()
                .filter(prod -> id.equals(String.valueOf(prod.getId())))
                .findFirst();

        return product.map(prod -> "Product Name: " + prod.getName())
                .orElse("No product found with id " + id);
    }

}
