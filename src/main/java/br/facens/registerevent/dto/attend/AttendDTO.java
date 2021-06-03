package br.facens.registerevent.dto.attend;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.facens.registerevent.entities.Attend;

public class AttendDTO {
    private Long id;

    @NotBlank(message = "Preencher o nome.")
    @Length(min = 3, max = 50, message = "O nome deve ter no minino 3 caracteres e no maximo 50 caracteres.")
    private String name;
    @Email
    private String email;


    public AttendDTO(){

    }
    public AttendDTO(Attend reg) {
        this.id = reg.getId();
        this.name = reg.getName();
        this.email = reg.getEmail();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
    
	

}
