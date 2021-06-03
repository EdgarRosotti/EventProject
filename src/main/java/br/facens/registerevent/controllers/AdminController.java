package br.facens.registerevent.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.facens.registerevent.dto.admin.AdminDTO;
import br.facens.registerevent.dto.admin.AdminInsertDTO;
import br.facens.registerevent.dto.admin.AdminUpdateDTO;
import br.facens.registerevent.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {
    
    @Autowired
    private AdminService service;

    @GetMapping
    public ResponseEntity<Page<AdminDTO>> getAdmin(
        @RequestParam(value = "page",           defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage",   defaultValue = "5") Integer linesPerPage,
        @RequestParam(value = "direction",      defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy",        defaultValue = "id") String orderBy,
        @RequestParam(value = "name",           defaultValue = "") String  name,
        @RequestParam(value = "email",           defaultValue = "") String  email
        
        ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);

        Page<AdminDTO> list = service.getAdmin(pageRequest, name.trim(), email.trim());
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long id){
        AdminDTO dto = service.getAdminById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AdminDTO> insert(@Valid @RequestBody AdminInsertDTO insertDto){
        AdminDTO dto = service.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AdminDTO> update(@PathVariable Long id,@Valid @RequestBody AdminUpdateDTO updateDto){
        AdminDTO dto = service.update(id, updateDto);
        return ResponseEntity.ok().body(dto);
    }

}
