INSERT INTO nearby (nearby_id, nearby_name, nearby_city, st, nearby_type) VALUES
 (1, 'Laingsburg Woodbury Car Pool', 'Lansing', 'MI', 2)
,(2, 'Great Lakes Crossing Mall', 'Detroit', 'MI', 2)
,(3, 'Flint I-69/I-75 Junction', 'Flint', 'MI', 1)

on conflict(nearby_id)
do update set 
nearby_name=EXCLUDED.nearby_name,
nearby_type=EXCLUDED.nearby_type;