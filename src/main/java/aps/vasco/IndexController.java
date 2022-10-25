package aps.vasco;

import java.util.List;

import javax.inject.Inject;

import aps.vasco.modelo.Represa;
import aps.vasco.services.ApiService;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {
	@Inject private Result result;
	@Inject private ApiService apiService;

	@Path("/")
	public void index() {
		List<Represa> represa=apiService.pegarDiaHoje();
		result.include("represa",represa);
		
		
	}
}
