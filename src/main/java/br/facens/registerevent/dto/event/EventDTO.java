package br.facens.registerevent.dto.event;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.facens.registerevent.entities.Event;
import jdk.jfr.Timestamp;

public class EventDTO {
    private Long id;

    @NotBlank(message = "Preencher o nome.")
    @Length(min = 3, max = 50, message = "O nome deve ter no minino 3 caracteres e no maximo 50 caracteres.")
    private String name;


    @NotBlank(message = "Preencher a descrição.")
    @Length(min = 3, max = 70, message = "A descrição deve ter no minino 3 caracteres e no maximo 70 caracteres.")
    private String description;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Timestamp
    private LocalTime startTime;
    @Email
    private String emailContact;

    private Double priceTicket;
    
    public EventDTO(){
    }
    public EventDTO(Long id, String name, String description,LocalDate startDate,LocalTime startTime, String emailContact, double priceTicket) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.startTime = startTime;
        this.emailContact = emailContact;
        this.priceTicket = priceTicket;
    }
    public EventDTO(Event reg) {
        this.id = reg.getId();
        this.name = reg.getName();
        this.description = reg.getDescription();
        this.startDate = reg.getStartDate();
        this.startTime = reg.getStartTime();
        this.emailContact = reg.getEmailContact();
        this.priceTicket = reg.getPriceTicket();
    }

    // Metodos Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getEmailContact() {
        return emailContact;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public double getPriceTicket() {
        return priceTicket;
    }

    // Metodos Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }    
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }  
    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }



}
