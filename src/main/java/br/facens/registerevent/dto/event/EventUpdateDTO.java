package br.facens.registerevent.dto.event;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class EventUpdateDTO {
    @NotBlank(message = "Preencher o nome.")
    @Length(min = 3, max = 50, message = "O nome deve ter no minino 3 caracteres e no maximo 50 caracteres.")
    private String name;
    
    @Email
    private String emailContact;
    
    public String getName() {
        return name;
    }
    public String getEmailContact() {
        return emailContact;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

}
