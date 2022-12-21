package gr.codelearn.spring.showcase.app.repository;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T, Long> {
	private final List<T> storage = new LinkedList<>();

	@Override
	public T create(final T clazz) {
		storage.add(clazz);
		return null;
	}

	@Override
	public List<T> createAll(final List<T> clazzes) {
		storage.addAll(clazzes);
		return null;
	}

	@Override
	public void update(final T clazz) {

	}

	@Override
	public void delete(final T clazz) {

	}

	@Override
	public void deleteById(final Long id) {

	}

	@Override
	public boolean exists(final T clazz) {
		return false;
	}

	@Override
	public T get(final Long id) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return storage;
	}
}
