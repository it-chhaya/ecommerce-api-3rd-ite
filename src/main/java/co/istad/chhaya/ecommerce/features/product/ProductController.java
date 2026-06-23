package co.istad.chhaya.ecommerce.features.product;

import co.istad.chhaya.ecommerce.features.product.dto.CreateProductRequest;
import co.istad.chhaya.ecommerce.features.product.dto.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse createNew(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return productService.createNew(createProductRequest);
    }

}
