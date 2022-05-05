package ecommercenew.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ecommercenew.productservice.ProductRepository productRepository;

    @PostMapping("/addOne")
    public ecommercenew.productservice.Product addProduct(@RequestBody ecommercenew.productservice.Product product) {
        return productRepository.save(product);
    }

    @PostMapping("/addList")
    public List<ecommercenew.productservice.Product> addProductList (@RequestBody List<ecommercenew.productservice.Product> products) {
        return productRepository.saveAll(products);
    }

    @GetMapping("/getAll")
    public List<ecommercenew.productservice.Product> getAllProduct () {
        return productRepository.findAll();
    }
}
