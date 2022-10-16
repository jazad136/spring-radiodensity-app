-- ((( FLINT STATIONS )))
INSERT INTO rstation (radio_id, call_name, fm_freq, category) VALUES 
 (101 , 'WHLCEV', 100.3,               'Christian/Inspirational')
,(102, 'Unknown 12', 100.5,           'Talk Radio')
--,(31, 'WITL', 100.7,                'Country')  
,(103 , '101 WRIF', 101.1,             null)
,(104 , 'Banana 101.5', 101.5,         'Hard Rock')
,(105 , 'WDET Detroits NPR Station',101.9, 'Talk Radio')
--,(33 , 'WIOG The Hits', 102.5,      'Classic Hits')
--,(4, 'K-LOVE', 102.7,               'Christian/Inspirational')
,(106, 'Unknown 13', 102.9,            'Country')
,(107, 'Unknown 14', 103.1,            'Latin American Broadcasting')
,(108, 'WMUZ-FM', 103.5,               'Christian/Inspirational')
,(109, '103.9 The FOX', 103.9,         'Classic Hits / Rock')
,(110, 'Unknown 15', 104.3,            null)
--,(38, 'Wheelz 104.5 (WILZ)', 104.5, 'Classic Hits / Rock')
,(111, 'WMRP', 104.7,                  'Country')
,(112, 'The Bounce', 105.1,            'Hip Hop')
--,(62, 'CK105.5', 105.5,               'Variety')
,(113, 'Unknown 16', 105.9,            'Hop Hop')
--,(42, 'Q106', 106.1,                'Hard Rock')
,(114, 'Unknown 17', 106.5,            'Christian/Inspirational')
on conflict(radio_id)
do update set 
call_name=EXCLUDED.call_name,
fm_freq=EXCLUDED.fm_freq,
category=EXCLUDED.category;
