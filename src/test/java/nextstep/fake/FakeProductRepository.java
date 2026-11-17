package nextstep.fake;

import nextstep.product.domain.Product;
import nextstep.product.infra.ProductRepository;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** ProductRepository는 JpaRepository가 아니라 메서드 몇 개짜리 Repository라 직접 구현한다. */
public class FakeProductRepository implements ProductRepository {

    private final Map<Long, Product> store = new HashMap<>();
    private long sequence = 0L;

    /** 실제 리포지토리처럼 없으면 null을 돌려준다. */
    @Override
    public Product findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            ReflectionTestUtils.setField(product, "id", ++sequence);
        }
        store.put(product.getId(), product);
        return product;
    }
}
