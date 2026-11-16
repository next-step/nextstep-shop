package nextstep.product.infra;

import nextstep.product.domain.Product;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, Long> {

    Product findById(Long id);

    Product save(Product product);
}
