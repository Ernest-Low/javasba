package sg.edu.ntu.assignment;

// import lombok.AllArgsConstructor;
import lombok.Getter;

// 3.9 Spring-intro assignment
// 3.10 Spring-maven

@Getter
// @AllArgsConstructor
public class Products {
    private final int id;
    private static int idcounter = 1;
    private String name;
    private String description;
    private double price;

    public Products(String name, String description, double price) {
        this.id = idcounter;
        this.name = name;
        this.description = description;
        this.price = price;
        idcounter++;
    }

}
