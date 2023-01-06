package gr.codelearn.spring.showcase.app.mapper;

import java.util.List;

public interface BaseMapper<D, R> {

	R toResource(D domain);

	List<R> toResources(List<D> domains);

	D toDomain(R resource);

	List<D> toDomains(List<R> resources);
}
