package nextstep.product.ui;

import lombok.RequiredArgsConstructor;
import nextstep.product.application.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody ProductRequest request) {
        Long id = productService.register(request.getName(), request.getPrice(), request.getStock());
        return ResponseEntity.created(URI.create("/products/" + id)).build();
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll().stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }
}
