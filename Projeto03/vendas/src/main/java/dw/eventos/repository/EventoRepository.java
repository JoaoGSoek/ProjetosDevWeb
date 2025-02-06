package dw.eventos.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dw.eventos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

    @Query("SELECT DISTINCT e.data FROM Evento e WHERE EXTRACT(MONTH FROM e.data) = :mes AND EXTRACT(YEAR FROM e.data) = :ano")
	List<LocalDate> getDaysWithEvents(@Param("mes") int mes, @Param("ano") int ano);
    List<Evento> findByData(LocalDate data);
    List<Evento> findByTituloContaining(String titulo);
    
}
