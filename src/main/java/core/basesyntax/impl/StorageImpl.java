package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_LENGTH = 10;
    private final Pair[] storage;
    private int size = 0;

    public StorageImpl() {
        this.storage = new Pair[MAX_STORAGE_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        int i = 0;
        for (Pair pair : storage) {
            if (pair != null && pair.getKey() == null && key == null
                    || pair != null && pair.getKey() != null && pair.getKey().equals(key)) {
                storage[i] = new Pair(key, value);
                return;
            }
            i++;
        }
        storage[size] = new Pair(key, value);
        size++;
    }

    @Override
    public V get(K key) {
        for (Pair pair : storage) {
            if (pair != null && pair.getKey() == null && key == null
                    || pair != null && pair.getKey() != null && pair.getKey().equals(key)) {
                return (V) pair.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
