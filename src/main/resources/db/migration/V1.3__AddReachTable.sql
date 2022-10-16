CREATE SEQUENCE rs_reach_seq start with 1;
CREATE TABLE reach (
    reach_id bigint NOT NULL DEFAULT nextval('rs_reach_seq'),
	radio_id bigint NOT NULL,
	nearby_id bigint NOT NULL,
	fm_freq numeric(4,1),
	retrieved_date timestamp,
	FOREIGN KEY (radio_id) REFERENCES rstation(radio_id),
    FOREIGN KEY (nearby_id) REFERENCES nearby(nearby_id),
	PRIMARY KEY (reach_id),
	UNIQUE (radio_id, nearby_id, fm_freq)
);

 