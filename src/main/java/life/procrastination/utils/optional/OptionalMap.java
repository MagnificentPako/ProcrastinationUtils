package life.procrastination.utils.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalMap<K,V> {

    private Map<K,V> optionalMap;

    public OptionalMap() {
        this.optionalMap = new HashMap();
    }

    public Optional<V> get(K key) {
        if(optionalMap.containsKey(key))
            return Optional.of(optionalMap.get(key));
        return Optional.empty();
    }

    public V put(K key, V value) {
        return this.optionalMap.put(key, value);
    }

}
