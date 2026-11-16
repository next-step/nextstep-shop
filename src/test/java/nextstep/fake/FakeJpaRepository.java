package nextstep.fake;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * JpaRepository를 메모리로 흉내 내는 가짜 리포지토리의 베이스.
 * 자주 쓰는 메서드(save, findById, findAll, count, delete...)만 구현하고,
 * 나머지는 UnsupportedOperationException을 던진다. 필요해지면 그때 구현한다.
 * 저장할 때 id 필드가 비어 있으면 1부터 차례로 채운다.
 */
public abstract class FakeJpaRepository<T> implements JpaRepository<T, Long> {

    protected final Map<Long, T> store = new LinkedHashMap<>();
    private long sequence = 0L;

    protected List<T> findAllBy(Predicate<T> condition) {
        return store.values().stream().filter(condition).toList();
    }

    @Override
    public <S extends T> S save(S entity) {
        Long id = (Long) ReflectionTestUtils.getField(entity, "id");
        if (id == null) {
            id = ++sequence;
            ReflectionTestUtils.setField(entity, "id", id);
        }
        store.put(id, entity);
        return entity;
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        List<S> saved = new ArrayList<>();
        entities.forEach(entity -> saved.add(save(entity)));
        return saved;
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public boolean existsById(Long id) {
        return store.containsKey(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<T> findAllById(Iterable<Long> ids) {
        List<T> found = new ArrayList<>();
        ids.forEach(id -> findById(id).ifPresent(found::add));
        return found;
    }

    @Override
    public long count() {
        return store.size();
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public void delete(T entity) {
        store.values().remove(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        ids.forEach(store::remove);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        store.clear();
    }

    // ---- 아래는 지원하지 않는다 ----

    @Override
    public List<T> findAll(Sort sort) {
        throw unsupported();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        throw unsupported();
    }

    @Override
    public void flush() {
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        return save(entity);
    }

    @Override
    public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
        return saveAll(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<T> entities) {
        throw unsupported();
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        throw unsupported();
    }

    @Override
    public void deleteAllInBatch() {
        throw unsupported();
    }

    @Override
    public T getOne(Long id) {
        throw unsupported();
    }

    @Override
    public T getById(Long id) {
        throw unsupported();
    }

    @Override
    public T getReferenceById(Long id) {
        throw unsupported();
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        throw unsupported();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        throw unsupported();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        throw unsupported();
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw unsupported();
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        throw unsupported();
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        throw unsupported();
    }

    @Override
    public <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        throw unsupported();
    }

    private UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException("가짜 리포지토리에서 지원하지 않는 메서드다. 필요하면 FakeJpaRepository에 구현한다.");
    }
}
