package br.facens.registerevent.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.facens.registerevent.dto.attend.AttendDTO;
import br.facens.registerevent.dto.attend.AttendInsertDTO;
import br.facens.registerevent.dto.attend.AttendUpdateDTO;
import br.facens.registerevent.entities.Attend;
import br.facens.registerevent.repository.AttendRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendService {
    @Autowired
    private AttendRepository repo;

    public Page<AttendDTO> getAttendees(PageRequest pageRequest, String name, String email){
        Page<Attend> list = repo.find(pageRequest, name, email);
        return list.map( a -> new AttendDTO(a));
    }

    public AttendDTO getAttendeesById(Long id){
        Optional<Attend> op = repo.findById(id);
        Attend reg = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attendees not foud"));
        return new AttendDTO(reg);
    }

    public AttendDTO insert(AttendInsertDTO dto){
        Attend entity = new Attend(dto); 
        if(entity.getBalance() < 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor não pode ser negativo");
        else
            entity = repo.save(entity);
        return new AttendDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event not found");
        }
    }

    public AttendDTO update(Long id, AttendUpdateDTO dto){
        try {
            Attend entity = repo.getOne(id);
            entity.setBalance(dto.getBalance());
            entity = repo.save(entity);
            return new AttendDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }
}
