CREATE TABLE t_person(
    per_id INT,
    per_name VARCHAR(50) NOT NULL,
    per_last_name VARCHAR(50) NOT NULL,
    per_mail VARCHAR(50) NOT NULL,
    per_role VARCHAR(50) NOT NULL,
    per_position VARCHAR(50),
    PRIMARY KEY(per_id),
    UNIQUE(per_mail)
);

CREATE TABLE t_owner(
    per_id INT,
    PRIMARY KEY(per_id),
    FOREIGN KEY(per_id) REFERENCES person(per_id)
);

CREATE TABLE t_client(
    per_id INT,
    cli_has_voted boolean,
    PRIMARY KEY(per_id),
    FOREIGN KEY(per_id) REFERENCES person(per_id)
);

CREATE TABLE t_attestation(
    att_id VARCHAR(50),
    per_id INT NOT NULL,
    PRIMARY KEY(att_id),
    FOREIGN KEY(per_id) REFERENCES owner(per_id)
);

CREATE TABLE t_domain_activity(
    dom_id INT,
    dom_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(dom_id)
);

CREATE TABLE t_skill(
    skil_id INT,
    skil_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(skil_id)
);

CREATE TABLE t_enterprise(
    ent_id INT,
    ent_name VARCHAR(50) NOT NULL,
    ent_siren INT NOT NULL,
    ent_vote_score INT,
    ent_phone_number VARCHAR(50),
    addr_id INT NOT NULL,
    PRIMARY KEY(ent_id),
    UNIQUE(ent_siren),
    FOREIGN KEY(addr_id) REFERENCES t_address(addr_id)
);

CREATE TABLE t_employee(
    per_id INT,
    ent_id INT NOT NULL,
    PRIMARY KEY(per_id),
    FOREIGN KEY(per_id) REFERENCES person(per_id),
    FOREIGN KEY(ent_id) REFERENCES enterprise(ent_id)
);

CREATE TABLE t_schedule(
    sch_id INT,
    ent_id INT NOT NULL,
    PRIMARY KEY(sch_id),
    UNIQUE(ent_id),
    FOREIGN KEY(ent_id) REFERENCES enterprise(ent_id)
);

CREATE TABLE t_time_slot(
    timeslot_id VARCHAR(50),
    timeslot_day DATE,
    timeslot_hour TIME,
    sch_id INT NOT NULL,
    PRIMARY KEY(timeslot_id),
    FOREIGN KEY(sch_id) REFERENCES schedule(sch_id)
);

CREATE TABLE t_address(
    addr_id INT,
    addr_number VARCHAR(50) NOT NULL,
    addr_street_name VARCHAR(50),
    addr_city VARCHAR(50),
    addr_zip_code VARCHAR(50),
    addr_optional_info VARCHAR(50),
    addr_latitude varchar(50),
    addr_longitude varchar(50),
    PRIMARY KEY(addr_id)
);

CREATE TABLE t_vote(
    vote_id INT,
    vote_date_creation timestamp without time zone NOT NULL,
    per_id INT NOT NULL,
    PRIMARY KEY(vote_id),
    FOREIGN KEY(per_id) REFERENCES client(per_id)
);

CREATE TABLE t_picture(
    pic_id INT,
    pic_path VARCHAR(250),
    pic_name VARCHAR(150) NOT NULL,
    ent_id INT NOT NULL,
    PRIMARY KEY(pic_id),
    FOREIGN KEY(ent_id) REFERENCES enterprise(ent_id)
);

create table t_comment (
	com_id INT,
   	com_date TIMESTAMP NOT NULL,
   	com_text VARCHAR(250) NOT NULL,
   	ent_id INT NOT NULL,
   	per_id INT NOT NULL,
   	PRIMARY KEY(com_id),
   	FOREIGN KEY(ent_id) REFERENCES t_enterprise(ent_id),
   	FOREIGN KEY(per_id) REFERENCES t_person(per_id)
)

create table t_establishment(
	est_id int,
 	est_main_activity VARCHAR(50),
   	est_date_created VARCHAR(50),
   	est_date_activity_started VARCHAR(50),
   	est_date_closed VARCHAR(50),
   	est_siret VARCHAR(50),
   	addr_id INT NOT NULL,
   	ent_id INT NOT NULL,
   	PRIMARY KEY(est_id),
   	UNIQUE(addr_id),
   	FOREIGN KEY(addr_id) REFERENCES t_address(addr_id),
   	FOREIGN KEY(ent_id) REFERENCES t_enterprise(ent_id)
);

CREATE TABLE t_asso_employee_time_slot(
    per_id INT,
    timeslot_id VARCHAR(50),
    PRIMARY KEY(per_id, timeslot_id),
    FOREIGN KEY(per_id) REFERENCES employee(per_id),
    FOREIGN KEY(timeslot_id) REFERENCES time_slot(timeslot_id)
);

CREATE TABLE t_asso_enterprise_domaine_activity(
    ent_id INT,
    dom_id INT,
    PRIMARY KEY(ent_id, dom_id),
    FOREIGN KEY(ent_id) REFERENCES enterprise(ent_id),
    FOREIGN KEY(dom_id) REFERENCES domain_activity(dom_id)
);

CREATE TABLE t_asso_person_skill (
    per_id INT,
    skil_id INT,
    PRIMARY KEY(per_id, skil_id),
    FOREIGN KEY(per_id) REFERENCES person(per_id),
    FOREIGN KEY(skil_id) REFERENCES skill(skil_id)
);


CREATE TABLE t_asso_enterprise_owner (
    per_id INT,
    ent_id INT,
    PRIMARY KEY(per_id, ent_id),
    FOREIGN KEY(per_id) REFERENCES t_owner(per_id),
    FOREIGN KEY(ent_id) REFERENCES t_enterprise(ent_id)
);



--------------------------------------------

CREATE SEQUENCE IF NOT EXISTS seq_person_id
INCREMENT BY 50
START WITH 100
OWNED BY t_person.per_id;

CREATE SEQUENCE IF NOT EXISTS enterprise_id_seq
INCREMENT BY 1
START WITH 200
OWNED BY t_enterprise.ent_id;

CREATE SEQUENCE IF NOT EXISTS address_id_seq
INCREMENT BY 50
START WITH 200
OWNED BY t_address.addr_id;

CREATE SEQUENCE IF NOT EXISTS comment_id_seq
INCREMENT BY 3
START WITH 19
OWNED BY t_comment.com_id;

CREATE SEQUENCE IF NOT EXISTS skill_id_seq
INCREMENT BY 1
START WITH 1
OWNED BY t_skill.skil_id;

CREATE SEQUENCE IF NOT EXISTS domain_activity_id_seq
INCREMENT BY 1
START WITH 1
OWNED BY t_domain_activity.dom_id;

CREATE SEQUENCE IF NOT EXISTS establishment_id_seq
INCREMENT BY 1
START WITH 1
OWNED BY t_establishment.est_id;