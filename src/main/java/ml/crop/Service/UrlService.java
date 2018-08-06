package ml.crop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ml.crop.model.Url;
import ml.crop.repo.UrlRepo;

@Service
public class UrlService {

	@Autowired
	private UrlRepo urlRepo;
	
	public boolean existsRandomString(String randomString) {
		return urlRepo.existsByShortenUri(randomString);
	}

	public boolean existsUrl(String url) {
		return urlRepo.existsByUrl(url);
	}

	public Url save(Url url) {
		return urlRepo.save(url);
	}

	public Url findByUrl(String url) {
		return urlRepo.findByUrl(url);
	}

	public boolean existsShortenUri(String uri) {
		return urlRepo.existsByShortenUri(uri);
	}

	public Url findByShortenUri(String uri) {
		return urlRepo.findByShortenUri(uri);
	}
	
	

	
}
