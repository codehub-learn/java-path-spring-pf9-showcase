package gr.codelearn.spring.showcase.app.repository;

import java.util.List;

public interface BaseRepository<T, ID> {
	T create(T clazz);

	List<T> createAll(List<T> clazzes);

	void update(T clazz);

	void delete(T clazz);

	void deleteById(ID id);

	boolean exists(T clazz);

	T get(ID id);

	List<T> findAll();
}
