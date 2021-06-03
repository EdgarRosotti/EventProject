package br.facens.registerevent.dto.admin;

import br.facens.registerevent.entities.Admin;


public class AdminDTO {
    
    private Long id;
    
    private String name;

    private String email;
    
    
    public AdminDTO(){

    }
    public AdminDTO(Long id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;

    }
    public AdminDTO(Admin reg) {
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
