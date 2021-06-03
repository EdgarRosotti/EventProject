package br.facens.registerevent.service;


import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.facens.registerevent.dto.event.EventDTO;
import br.facens.registerevent.dto.event.EventInsertDTO;
import br.facens.registerevent.dto.event.EventUpdateDTO;
import br.facens.registerevent.entities.Event;
import br.facens.registerevent.repository.EventRepository;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repo;

    public Page<EventDTO> getEvents(PageRequest pageRequest, String name,String emailContact, LocalDate startDate,String description, Double priceTicket){
        Page<Event> list = repo.find(pageRequest, name, emailContact, startDate, description, priceTicket);
        return list.map( r -> new EventDTO(r));
    }


//  toDTOList foi mudado para fazer a listagem paginada
    /*
    private List<RegisterDTO> toDTOList(List<Register> list) {
        List<RegisterDTO> listDTO = new ArrayList<>();
        for(Register r : list){
            RegisterDTO dto = new RegisterDTO(r.getId(), r.getName(), r.getDescription(), r.getEmailContact());
            listDTO.add(dto);
        }
        return listDTO;
    }
*/
    public EventDTO getEventById(Long id){
        Optional<Event> op = repo.findById(id);
        Event reg = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not foud"));
        return new EventDTO(reg);
    }

    
    public EventDTO insert(EventInsertDTO dto){
        Event entity = new Event(dto); 
        if(entity.getStartDate().isAfter(entity.getEndDate()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data inicial não pode ser maior que a data final.");
        else if(entity.getStartDate().isEqual(entity.getEndDate()) && entity.getStartTime().isAfter(entity.getEndTime()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O horario inicial não pode ser maior que o horario final.");
        else if(entity.getAmountPayedTickets() > 0 && entity.getPriceTicket() <= 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor do ingresso informado tem que ser maior que zero.");
        else if(entity.getAmountPayedTickets() <= 0 && entity.getPriceTicket() > 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor do ingresso informado tem que ser zero e não pode ser negativo.");
        else if(entity.getAmountPayedTickets() <= 0 && entity.getAmountFreeTickets() <= 0)//Ver se esta funcionando ... testar depois.
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tem que ter no minino 1 ingresso para ter um evento e não pode ter valor negativo!");
        else
            entity = repo.save(entity);
        return new EventDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event not found");
        }
    }

    public EventDTO update(Long id, EventUpdateDTO dto){
        try {
            Event entity = repo.getOne(id);
            entity.setName(dto.getName());
            entity.setEmailContact(dto.getEmailContact());
            entity = repo.save(entity);
            return new EventDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

}
