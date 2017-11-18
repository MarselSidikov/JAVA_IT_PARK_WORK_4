package ru.itis;

/**
 * 16.11.2017
 * Map
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
}
