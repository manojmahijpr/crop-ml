package ml.crop.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ml.crop.Service.UrlService;

@Controller
public class HomeController {

	@Autowired
	private UrlService urlService;
	
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("Home");
	}
	
	@GetMapping("/{uri}")
	public String redirect(@PathVariable("uri") String uri) {
		if(uri.matches("^[a-zA-Z0-9_]*$") &&(uri.length() == 6 || uri.length() == 7) && urlService.existsShortenUri(uri))
			return "redirect:"+ urlService.findByShortenUri(uri).getUrl();
		else return "404";
	}
}
