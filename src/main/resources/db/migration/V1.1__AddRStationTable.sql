CREATE SEQUENCE rs_rstation_seq start with 1;
CREATE TABLE rstation (
	radio_id bigint NOT NULL DEFAULT nextval('rs_rstation_seq'),
	call_name varchar(40), 
	fm_freq numeric(4,1) NOT NULL,
	category varchar(40), 
	haat int, 
	erpkw numeric(4,2), 
	PRIMARY KEY (radio_id)
);