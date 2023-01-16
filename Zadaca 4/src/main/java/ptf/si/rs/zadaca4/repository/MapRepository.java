package ptf.si.rs.zadaca4.repository;

import ptf.si.rs.zadaca4.models.SequentialData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRepository<T extends SequentialData> implements CRUDRepository<T> {
    private long counter = 0;
    private final Map<Long, T> valuesMap = new HashMap<>();

    @Override
    public void save(T value) {
        if (value.getId() != null) {
            update(value);
            return;
        }
        value.setId(counter);
        valuesMap.put(counter++, value);
    }

    @Override
    public void update(T value) {
        if (value.getId() == null) throw new IllegalStateException("Cannot update value with the id of null");
        valuesMap.put(value.getId(), value);
    }

    @Override
    public List<T> readAll() {
        List<T> values = valuesMap.values().stream().toList();
        return values;
    }

    @Override
    public void delete(Long id) {
        valuesMap.remove(id);
    }
}
