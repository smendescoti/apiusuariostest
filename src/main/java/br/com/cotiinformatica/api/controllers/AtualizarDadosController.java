package br.com.cotiinformatica.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.application.dtos.AtualizarDadosDTO;
import br.com.cotiinformatica.application.dtos.AtualizarDadosResponseDTO;
import br.com.cotiinformatica.application.interfaces.UsuarioAppService;
import jakarta.validation.Valid;

@RestController
public class AtualizarDadosController {

	@Autowired
	private UsuarioAppService usuarioAppService;
	
	@PutMapping("/api/usuarios/atualizar-dados")
	public ResponseEntity<AtualizarDadosResponseDTO> put(@Valid @RequestBody AtualizarDadosDTO dto) {

		AtualizarDadosResponseDTO response = usuarioAppService.atualizarDados(dto);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
