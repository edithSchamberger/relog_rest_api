package ar.edu.undef.fie.relog_rest_api.application.command_services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.undef.fie.relog_rest_api.domain.clases.Clase;
import ar.edu.undef.fie.relog_rest_api.infrastructure.ClaseRepositoty;

@Service
public class ClaseCommandService {
	private final ClaseRepositoty claseRepositoty;

	public ClaseCommandService(ClaseRepositoty claseRepositoty) {
		this.claseRepositoty = claseRepositoty;
	}

	public List<Clase> create(List<Clase> clases) {
		return claseRepositoty.saveAll(clases);
	}

	public Clase save(Clase clase) {
		return claseRepositoty.save(clase);
	}
	public List<Clase> findAll() {
		return claseRepositoty.findAll();
	}

	public Optional<Clase> findById(long id) {
		return claseRepositoty.findById(id);
	}

	public void delete(Long id) {
		claseRepositoty.deleteById(id);
	}


}
