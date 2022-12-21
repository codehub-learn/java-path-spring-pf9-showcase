package gr.codelearn.spring.showcase.app.service;

import java.util.List;

public interface BaseService<T, ID> {
	T create(T clazz);

	List<T> createAll(T... clazzes);

	List<T> createAll(List<T> clazzes);

	void update(T clazz);

	void delete(T clazz);

	void deleteById(ID id);

	boolean exists(T clazz);

	List<T> findAll();

	T find(Long id);

	T get(ID id);
}
