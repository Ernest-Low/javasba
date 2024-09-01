package sg.edu.ntu.assignment;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// 3.9 Spring-intro assignment
// 3.10 Spring-maven
@RestController
@RequestMapping("/products")
public class ProductController {

    ArrayList<Products> myProducts = new ArrayList<>();

    @GetMapping("/seed")
    public void getMethodName() {
        System.out.println("Seeding.");
        myProducts.add(new Products("Apple", "Red & Juicy", 2.99));
        myProducts.add(new Products("Banana", "Yellow", 0.99));
        myProducts.add(new Products("Carrot", "Orange", 1.99));
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        Optional<Products> product = myProducts.stream()
                .filter(prod -> id.equals(String.valueOf(prod.getId())))
                .findFirst();

        return product.map(prod -> "Product Name: " + prod.getName())
                .orElse("No product found with id " + id);
    }

    @GetMapping({ "", "/" })
    public Products getProducts() {
        return new Products("Rice", "Nice", 6);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<Products> createProduct(@RequestBody Products entity) {
        try {
            myProducts.add(entity);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

}
