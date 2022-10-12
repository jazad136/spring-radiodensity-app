CREATE TABLE nearby (
	nearby_id bigint NOT NULL
	,nearby_name varchar(80)
	,nearby_city varchar(80)
	,st varchar(80)
	,nearby_type int
	,PRIMARY KEY(nearby_id)
-- type should be 1 for center of a city, 2 for special landmark location outside city
);


