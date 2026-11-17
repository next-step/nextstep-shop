package nextstep.product.application;

import lombok.RequiredArgsConstructor;
import nextstep.product.domain.Product;
import nextstep.product.infra.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long register(String name, int price, int stock) {
        return productRepository.save(new Product(name, price, stock)).getId();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
