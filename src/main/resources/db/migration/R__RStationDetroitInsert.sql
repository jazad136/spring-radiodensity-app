-- ((( DETROIT STATIONS )))
INSERT INTO rstation (radio_id, call_name, fm_freq, category) VALUES 
 (201, 'Channel 95.5'            , 95.5, 'Popular Hits')
,(202, 'Windsors Country 95.9' , 95.9, 'Country')
,(203, 'WDVD Todays Best Music', 96.3, 'Popular Hits')
,(204, 'Unknown'                 , 96.7, null)
,(205, '97.1 The Ticket'         , 97.1, 'Sports/Talk Radio')
,(206, 'Radio1'                  , 97.5, 'Talk Radio')
,(207, 'WJLB Vive.com'           , 97.9, null)
on conflict(radio_id)
do update set 
call_name=EXCLUDED.call_name,
fm_freq=EXCLUDED.fm_freq,
category=EXCLUDED.category;
