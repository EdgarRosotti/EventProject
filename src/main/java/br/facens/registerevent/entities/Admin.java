package br.facens.registerevent.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.facens.registerevent.dto.admin.AdminInsertDTO;

@Entity
@Table(name = "TB_ADMIN")
@PrimaryKeyJoinColumn(name = "BASEUSER_ID")
public class Admin extends BaseUser{
    
    @NotBlank(message = "Preencher o telefone.")
    @Length(min = 11, max = 13, message = "O colocar os 11 digitos do telefone, ex: xx xxxxxxxxx")
    private String phoneNumber;

    @OneToMany(mappedBy = "admin")
    private List<Event> events = new ArrayList<>();


    public Admin() {
    }

    public Admin(Long id, String name, String email, String phoneNumber, List<Event> events) {
        super(id, name, email);
        this.phoneNumber = phoneNumber;
        this.events = events;
    }
    public Admin(AdminInsertDTO dto) {
        super.setName(dto.getName());
        super.setEmail(dto.getEmail());
        this.phoneNumber = dto.getPhoneNumber();
    }

// Metodos Getters
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public List<Event> getEvents() {
        return events;
    }
// Metodos Setters
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void addEvent(Event event) {
        this.events.add(event);
    }

    
    
}
