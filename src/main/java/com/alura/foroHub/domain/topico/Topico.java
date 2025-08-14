package com.alura.foroHub.domain.topico;

import com.alura.foroHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    
    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario autor, Curso curso) {
        this.status = true;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.autor = autor;
        this.curso = curso;
    }
    
    public void actualizarDatos(DatosActualizarTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.curso = datos.curso();
    }

    public void desactivarTopico() {
        this.status = false;
    }
}