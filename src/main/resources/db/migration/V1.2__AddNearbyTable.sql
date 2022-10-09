CREATE SEQUENCE rs_nearby_seq start with 1;
CREATE TABLE nearby (
	nearby_id bigint NOT NULL DEFAULT nextval('rs_nearby_seq'),
	nearby_name varchar(80),
	near_city varchar(80),
	st varchar(80),
	nearby_type int,
	PRIMARY KEY(nearby_id)
-- type should be 1 for center of a city, 2 for special landmark location outside city
);