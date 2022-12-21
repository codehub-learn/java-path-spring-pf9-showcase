package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.BaseModel;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel> extends AbstractLogComponent
		implements BaseService<T, Long> {
	abstract BaseRepository<T, Long> getRepository();

	@Override
	public T create(final T clazz) {
		logger.trace("Creating {}.", clazz);
		return getRepository().create(clazz);
	}

	@Override
	public List<T> createAll(T... entities) {
		return createAll(List.of(entities));
	}

	@Override
	public List<T> createAll(final List<T> clazzes) {
		final List<T> updatedEntities = new ArrayList<>();
		for (final T clazz : clazzes) {
			updatedEntities.add(create(clazz));
		}
		return updatedEntities;
	}

	@Override
	public void update(final T clazz) {
		logger.trace("Updating {}.", clazz);
		getRepository().update(clazz);
	}

	@Override
	public void delete(final T clazz) {
		logger.trace("Deleting {}.", clazz);
		getRepository().delete(clazz);
	}

	@Override
	public void deleteById(final Long id) {
		final T entityFound = getRepository().get(id);
		logger.trace("Deleting {}.", entityFound);
		getRepository().deleteById(id);
	}

	@Override
	public boolean exists(final T clazz) {
		logger.trace("Checking whether {} exists.", clazz);
		return getRepository().exists(clazz);
	}

	@Override
	public List<T> findAll() {
		logger.trace("Retrieving all data.");
		return getRepository().findAll();
	}

	@Override
	public T find(Long id) {
		return null;
	}

	public T get(Long id) {
		return getRepository().get(id);
	}
}
