package ru.itis;

/**
 * 16.11.2017
 * HashMap
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HashMap<K, V> implements Map<K, V> {

    private static class Node<Key, Value> {
        Key key;
        Value value;
        Node<Key, Value> next;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> buckets[] = new Node[16];

    @Override
    public void put(K key, V value) {
        // считаем хеш от ключа
        int hash = key.hashCode();
        // преобразуем его в индекс
        int index = hash & buckets.length - 1;
        // если корзина для данного индекса пустая
        if (buckets[index] == null) {
            // просто кладем узел туда
            Node<K,V> newNode = new Node<>(key, value);
            buckets[index] = newNode;
        } else {
            // если корзина была не пустой
            // мы должны убедиться, что в данной корзине
            // либо есть такой ключ - тогда мы заменим его значение,
            // либо нет - тогда создадим новый узел

            // запоминаем первый узел
            Node<K,V> current = buckets[index];
            // пока после текущего еще есть узлы
            while (current.next != null) {
                // проверяем, не совпал ли ключ текущего узла
                // с ключом, под которым мы кладем значение
                if (current.key.equals(key)) {
                    // если совпал - заменяем значение
                    current.value = value;
                    return;
                }
                // если не совпал идем дальше
                current = current.next;
            }
            // проверяем последний узел - вдруг его значение равно ключу
            if (current.key.equals(key)) {
                // если совпал - заменяем значение
                current.value = value;
                return;
            }
            // если среди узлов данной корзины мы не нашли ключа
            // просто присоединяем новый ключ
            Node<K,V> newNode = new Node<>(key, value);
            current.next = newNode;
        }
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();

        int index = hash & buckets.length - 1;

        if (buckets[index] == null) {
            return null;
        }

        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
}
