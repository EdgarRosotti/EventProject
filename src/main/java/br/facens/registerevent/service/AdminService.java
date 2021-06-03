package br.facens.registerevent.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.facens.registerevent.dto.admin.AdminDTO;
import br.facens.registerevent.dto.admin.AdminInsertDTO;
import br.facens.registerevent.dto.admin.AdminUpdateDTO;
import br.facens.registerevent.entities.Admin;
import br.facens.registerevent.repository.AdminRepository;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repo;

    public Page<AdminDTO> getAdmin(PageRequest pageRequest, String name, String email){
        Page<Admin> list = repo.find(pageRequest, name, email);
        return list.map( a -> new AdminDTO(a));
    }

    public AdminDTO getAdminById(Long id){
        Optional<Admin> op = repo.findById(id);
        Admin reg = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not foud"));
        return new AdminDTO(reg);
    }

    public AdminDTO insert(AdminInsertDTO dto){
        Admin entity = new Admin(dto); 
        entity = repo.save(entity);
        return new AdminDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Event not found");
        }
    }

    public AdminDTO update(Long id, AdminUpdateDTO dto){
        try {
            Admin entity = repo.getOne(id);
            entity.setPhoneNumber(dto.getPhoneNumber());
            entity = repo.save(entity);
            return new AdminDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

}
