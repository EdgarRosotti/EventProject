package br.facens.registerevent.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.facens.registerevent.dto.place.PlaceDTO;
import br.facens.registerevent.dto.place.PlaceInsertDTO;
import br.facens.registerevent.dto.place.PlaceUpdateDTO;
import br.facens.registerevent.entities.Place;
import br.facens.registerevent.repository.PlaceRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {
    
    @Autowired
    private PlaceRepository repo;

    public Page<PlaceDTO> getPlace(PageRequest pageRequest, String address){
        Page<Place> list = repo.find(pageRequest, address);
        return list.map( a -> new PlaceDTO(a));
    }

    public PlaceDTO getPlaceById(Long id){
        Optional<Place> op = repo.findById(id);
        Place reg = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not foud"));
        return new PlaceDTO(reg);
    }

    public PlaceDTO insert(PlaceInsertDTO dto){
        Place entity = new Place(dto); 
        entity = repo.save(entity);
        return new PlaceDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event not found");
        }
    }

    public PlaceDTO update(Long id, PlaceUpdateDTO dto){
        try {
            Place entity = repo.getOne(id);
            entity.setName(dto.getName());;
            entity = repo.save(entity);
            return new PlaceDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }
    
}
