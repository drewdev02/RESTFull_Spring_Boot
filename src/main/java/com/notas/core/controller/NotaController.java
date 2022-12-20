package com.notas.core.controller;

import com.notas.core.entity.Nota;
import com.notas.core.model.MNota;
import com.notas.core.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class NotaController {
	
	@Autowired
	@Qualifier("servicio")
	NotaService service;
	
	@PutMapping("/nota")
	public boolean agregarNota(@RequestBody @Valid Nota nota) {
		return service.crear(nota);
	}
	
	@PostMapping("/nota")
	public boolean actualizarNota(@RequestBody @Valid Nota nota){
		return service.actualizar(nota);
	}
	
	@DeleteMapping("/nota/{id}/{nombre}")
	public boolean borrarNota(@PathVariable("id") long id, 
			@PathVariable("nombre") String nombre) {
		return service.borrar(nombre, id);
	}
	
	@GetMapping(value="/notas")
	public List<MNota> obtenerNotas(Pageable pageable){
		return service.obtenerPorPaginacion(pageable);
	}
	
}
