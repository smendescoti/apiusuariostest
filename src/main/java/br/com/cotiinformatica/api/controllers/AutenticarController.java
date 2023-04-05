package br.com.cotiinformatica.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.application.dtos.AutenticarDTO;
import br.com.cotiinformatica.application.dtos.AutenticarResponseDTO;
import br.com.cotiinformatica.application.interfaces.UsuarioAppService;
import jakarta.validation.Valid;

@RestController
public class AutenticarController {

	@Autowired
	private UsuarioAppService usuarioAppService;
	
	@PostMapping("/api/usuarios/autenticar")
	public ResponseEntity<AutenticarResponseDTO> post(@Valid @RequestBody AutenticarDTO dto) {

		AutenticarResponseDTO response = usuarioAppService.autenticar(dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
