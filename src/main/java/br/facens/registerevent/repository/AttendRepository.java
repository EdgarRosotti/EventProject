package br.facens.registerevent.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.facens.registerevent.entities.Attend;
@Repository
public interface AttendRepository extends JpaRepository<Attend,Long> {

    @Query("SELECT a FROM Attend a "+  
    "WHERE " + 
     "LOWER(a.name)          LIKE    LOWER(CONCAT('%', :name, '%'))          AND " +
     "LOWER(a.email)          LIKE    LOWER(CONCAT('%', :email, '%'))"
    )
    public Page<Attend> find(Pageable pageRequest, String name, String email);
    
}
