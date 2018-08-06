package ml.crop.repo;

import org.springframework.data.repository.CrudRepository;

import ml.crop.model.Url;

public interface UrlRepo extends CrudRepository<Url, Long>{

	boolean existsByUrl(String url);

	Url findByUrl(String url);

	boolean existsByShortenUri(String uri);

	Url findByShortenUri(String uri);

}
