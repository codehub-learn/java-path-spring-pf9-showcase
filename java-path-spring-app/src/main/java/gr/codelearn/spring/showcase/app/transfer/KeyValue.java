package gr.codelearn.spring.showcase.app.transfer;

import lombok.Value;

/**
 * This class is acting as a DTO with parameterized object types for both key and value.
 *
 * @param <K> The key object type
 * @param <V> The value object type
 */
@Value
public class KeyValue<K, V> {
	K key;
	V value;
}
