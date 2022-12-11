package ar.edu.undef.fie.relog_rest_api.interfaces;

import ar.edu.undef.fie.relog_rest_api.application.command_services.ClaseCommandService;
import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import ar.edu.undef.fie.relog_rest_api.interfaces.responses.ClaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.undef.fie.relog_rest_api.application.command_queries.FindClaseCommandQuery;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClaseController {
	private final FindClaseCommandQuery query;
	private final ClaseCommandService service;

	public ClaseController(FindClaseCommandQuery claseCommandQuery, ClaseCommandService service) {
		this.query = claseCommandQuery;
		this.service = service;
	}

	@GetMapping("/saludoclases")
	public String saludarClases() {
		return "Hola Soy Clases";
	}



	@GetMapping("/clases")
	public List<ClaseResponse> findAllClases() {
		return query
				.findAll()
				.stream()
				.map(Clase::response)
				.collect(Collectors.toList());
	}


}
