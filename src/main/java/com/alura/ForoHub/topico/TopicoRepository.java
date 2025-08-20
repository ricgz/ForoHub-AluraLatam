package com.alura.ForoHub.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("""
            select t
            from Topico t
            order by t.creado ASC
            """)
    Page<Topico> findByTop10ByFecha_creacion(Pageable paginacion);

    @Query("""
            select t
            from Topico t
            where id = :id
            """)
    Optional<Topico> getTopicoById(Long id);
}
