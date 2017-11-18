package ru.itis;

/**
 * 16.11.2017
 * MapEntriesArrayImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MapEntriesArrayImpl<K, V> implements Map<K, V> {

    // вложенный класс, который хранит информацию об одной паре
    // ключ-значени, при этом ключ может быть любого типа,
    // значение тоже может быть любого типа
    private static class Entry<Key, Value> {
        private Key key;
        private Value value;

        Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
    // массив пар ключ-значение
    private Entry<K,V> entries[];
    private int count;

    public MapEntriesArrayImpl() {
        this.entries = new Entry[10];
    }

    //метод, который кладет новую пару в массив
    @Override
    public void put(K key, V value) {
        // сначала пробегаем по всем элементам
        for (int i = 0; i < count; i++) {
            // если найдена пара с таким ключом, то меняем его значение
            if (entries[i].key.equals(key)) {
                entries[i].value = value;
                // останавливаем выполнение функции
                return;
            }
        }

        // если не нашли, то создаем новую пару
        Entry<K, V> newEntry = new Entry<>(key, value);
        // кладем в конец массива
        entries[count++] = newEntry;
    }

    // получение значения по ключу
    @Override
    public V get(K key) {
        // пробегаем весь массив
        for (int i = 0; i < count; i++) {
            // проверяем каждую пару на наличие ключа, который мы ищем
            if (entries[i].key.equals(key)) {
                // если ключ в паре совпал, возвращаем значение
                return entries[i].value;
            }
        }
        return null;
    }
}
