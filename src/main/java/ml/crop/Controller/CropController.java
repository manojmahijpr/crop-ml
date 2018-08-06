package ml.crop.Controller;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ml.crop.Dto.Response;
import ml.crop.Service.UrlService;
import ml.crop.model.Url;

@RestController
@RequestMapping("/crop")
public class CropController {
	
	@Autowired
	private UrlService urlService;

	@PostMapping("/url")
	public Response cropUrl(@RequestParam("url") String url) {
		
		if(urlService.existsUrl(url))
			return new Response("URL Already Trimmed", "OK", urlService.findByUrl(url));
		
		String randomString = getRandomUrl();
		Url urlVar = urlService.save(new Url(url,randomString));
		return new Response("URL Trimmed", "OK", urlVar);
	}

	private String getRandomUrl() {
		
		for(int i=0;i<1000;i++) {
			String randomString = RandomStringUtils.random(6, true, true);
			if(!urlService.existsRandomString(randomString)) {
				return randomString;
			}
		}
		return RandomStringUtils.random(3, true, true)+"_" + RandomStringUtils.random(3, true, true);
	}
	
}
