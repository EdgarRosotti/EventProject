package br.facens.registerevent.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.facens.registerevent.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{     
    
    //Consulta JPQL!!!
    @Query("SELECT r FROM Event r "+  
    "WHERE " + 
     "LOWER(r.name)          LIKE    LOWER(CONCAT('%', :name, '%'))          AND " +
     "LOWER(r.emailContact)          LIKE    LOWER(CONCAT('%', :emailContact, '%'))          AND " +
     "r.startDate > :startDate                                               AND " +
     "LOWER(r.description)   LIKE    LOWER(CONCAT('%', :description, '%'))   AND " +
     "LOWER(r.priceTicket)   LIKE    LOWER(CONCAT('%', :priceTicket, '%')) "  
    )
    public Page<Event> find(Pageable pageRequest, String name,String emailContact, LocalDate startDate,String description, Double priceTicket);
    
}
