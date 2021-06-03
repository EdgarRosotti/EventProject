package br.facens.registerevent.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.facens.registerevent.entities.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
    
    @Query("SELECT a FROM Place a "+
    "WHERE " + 
    "LOWER(a.address)          LIKE    LOWER(CONCAT('%', :address, '%'))" 
    )
    public Page<Place> find(Pageable pageRequest, String address);
}
