INSERT INTO rstation (radio_id, call_name, fm_freq, category) VALUES 
 (19, 'Channel 95.5'            , 95.5, 'Popular Hits')
,(20, 'Windsors Country 95.9' , 95.9, 'Country')
,(21, 'WDVD Todays Best Music', 96.3, 'Popular Hits')
,(22, 'Unknown'                 , 96.7, null)
,(23, '97.1 The Ticket'         , 97.1, 'Sports/Talk Radio')
,(24, 'Radio1'                  , 97.5, 'Talk Radio')
,(25, 'WJLB Vive.com'           , 97.9, null)
on conflict(radio_id)
do update set 
call_name=EXCLUDED.call_name,
fm_freq=EXCLUDED.fm_freq,
category=EXCLUDED.category;
