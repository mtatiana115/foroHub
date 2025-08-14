package com.alura.foroHub.controller;

import com.alura.foroHub.domain.topico.*;
import com.alura.foroHub.domain.usuario.Usuario;
import com.alura.foroHub.domain.usuario.UsuarioRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriBuilder) {
        // Validación de duplicados
        Optional<Topico> topicoDuplicado = topicoRepository.findByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if (topicoDuplicado.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }

        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado"));

        Topico topico = new Topico(datos, autor, datos.curso());
        topicoRepository.save(topico);

        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosRespuestaTopico(topico));
    }
}