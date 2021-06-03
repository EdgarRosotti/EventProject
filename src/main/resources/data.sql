INSERT INTO tb_baseuser (name,email) 
VALUES ('Uchoas','uchoas@gmail.com'); 
INSERT INTO tb_admin (phone_number, baseuser_id)
VALUES ('11 9524-6857', 1);

INSERT INTO tb_baseuser (name,email) 
VALUES ('Edgar','edgar@gmail.com'); 
INSERT INTO tb_admin (phone_number, baseuser_id)
VALUES ('11 9524-9794', 2);

INSERT INTO tb_baseuser (name,email) 
VALUES ('João','joao@gmail.com'); 
INSERT INTO tb_admin (phone_number, baseuser_id)
VALUES ('11 9524-0542', 3);




INSERT INTO tb_baseuser (name,email) 
VALUES ('Nami','nami@gmail.com'); 
INSERT INTO tb_attendee (balance, baseuser_id)
VALUES (50.00, 4);

INSERT INTO tb_baseuser (name,email) 
VALUES ('Zed','zed@gmail.com'); 
INSERT INTO tb_attendee (balance, baseuser_id)
VALUES (35.00, 5);

INSERT INTO tb_baseuser (name,email) 
VALUES ('Warwick','Warwick@gmail.com'); 
INSERT INTO tb_attendee (balance, baseuser_id)
VALUES (0.10, 6);




INSERT INTO tb_event (name,description,start_date, end_date,start_time,end_time,email_contact,amount_Free_Tickets,amount_Payed_Tickets,price_Ticket, ADMIN_BASEUSER_ID) 
VALUES ('Team Black','Role De Pleyba','2022-01-23','2022-02-23','19:00:00','05:00:00','joaouchoas@gmail.com',100,2000, 75.00,1);

INSERT INTO tb_event (name,description,start_date, end_date,start_time,end_time,email_contact,amount_Free_Tickets,amount_Payed_Tickets,price_Ticket, ADMIN_BASEUSER_ID) 
VALUES ('Baile Da 011','Bailão','2022-01-01','2022-01-01','12:00:00','18:00:00','joaouchoas@gmail.com',1500,30000, 20.00,2);

INSERT INTO tb_event (name,description,start_date, end_date,start_time,end_time,email_contact,amount_Free_Tickets,amount_Payed_Tickets,price_Ticket, ADMIN_BASEUSER_ID) 
VALUES ('Circ of Magic ','Aniversário','2022-01-01','2022-01-01','12:00:00','18:00:00','joaouchoas@gmail.com',300,10000, 100.00,3);




INSERT INTO tb_place (name,address) 
VALUES ('Gargamel','Jardim dos Gnomos, Rua dos Smurfs nº 23');

INSERT INTO tb_place (name,address) 
VALUES ('Radiator Springs','Arizona, Rota 66');

INSERT INTO tb_place (name,address) 
VALUES ('Marcia','Jardim das Aves, Rua das Caldeiras nº 12');