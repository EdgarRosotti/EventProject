package br.facens.registerevent.dto.event;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import jdk.jfr.Timestamp;

public class EventInsertDTO {

    @NotBlank(message = "Preencher o nome.")
    @Length(min = 3, max = 50, message = "O nome deve ter no minino 3 caracteres e no maximo 50 caracteres.")
    private String name;

    @NotBlank(message = "Preencher a descrição.")
    @Length(min = 3, max = 70, message = "A descrição deve ter no minino 3 caracteres e no maximo 70 caracteres.")
    private String description;

    @NotBlank(message = "Preencher o local.")
    @Length(min = 3, max = 100, message = "O local deve ter no minino 3 caracteres e no maximo 100 caracteres.")
    private String place;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate endDate;

    @Timestamp
    private LocalTime startTime;
    @Timestamp
    private LocalTime endTime;

    @Email
    private String emailContact;

    
    private Long amountFreeTickets;
    
    private Long amountPayedTickets;

    private double priceTicket;

    
    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }
    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }
    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }
    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }
    public double getPriceTicket() {
        return priceTicket;
    }
    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public String getEmailContact() {
        return emailContact;
    }
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

}
