-- ((( FLINT STATIONS )))
INSERT INTO rstation (radio_id, call_name, fm_freq, category) VALUES 
 (101 , 'WHLCEV', 100.3,               'Christian/Inspirational')
,(102, 'Unknown 8', 100.5,           'Talk Radio')
--,(31, 'WITL', 100.7,                'Country')  
,(103 , '101 WRIF', 101.1,             null)
,(104 , 'Banana 101.5', 101.5,         'Hard Rock')
,(105 , 'WDET Detroits NPR Station',101.9, 'Talk Radio')
--,(33 , 'WIOG The Hits', 102.5,      'Classic Hits')
--,(4, 'K-LOVE', 102.7,               'Christian/Inspirational')
,(106, 'Unknown 9', 102.9,            'Country')
,(107, 'Unknown 10', 103.1,            'Latin American Broadcasting')
,(108, 'WMUZ-FM', 103.5,               'Christian/Inspirational')
,(109, '103.9 The FOX', 103.9,         'Classic Hits / Rock')
,(110, 'Unknown 11', 104.3,            null)
--,(38, 'Wheelz 104.5 (WILZ)', 104.5, 'Classic Hits / Rock')
,(111, 'WMRP', 104.7,                  'Country')
,(112, 'The Bounce', 105.1,            'Hip Hop')
--,(62, 'CK105.5', 105.5,               'Variety')
,(113, 'Unknown 12', 105.9,            'Hip Hop')
--,(42, 'Q106', 106.1,                'Hard Rock')
--,(114, 'K-LOVE', 106.3,               'Christian/Inspirational')
,(115, 'WSNL', 106.5,                 'Christian/Inspirational')
,(116, 'WILZ', 106.7,                 'Christian/Inspirational')
,(117, 'Unknown 13', 106.9,           'Christian/Inspirational')
,(118, 'KISS 107.1', 107.1,           'Hard Rock')
,(119, 'Classic Hits K107.3', 107.3,  'Classic Hits')
,(120, 'Hot 107.5 (WGPR)', 107.5,     'Hip Hop')
,(121, 'CARS 108 80s 90s and Now (WCRZ)', 107.9, 'Variety')
,(122, 'SmileFM', 88.1, 'Christian/Inspirational')
--,(122, 'SmileFM', 88.3, 'Christian/Inspirational')
--,(4, 'K-LOVE',88.9, 'Christian/Inspirational')
--,(4, 'K-LOVE',89.1, 'Christian/Inspirational')
,(123, 'WCMU NPR', 89.5,  'Talk Radio')
--,(122, 'SmileFM', 89.7'Christian/Inspirational')
,(124, 'MI Radio', 90.1, 'Talk Radio')
,(125, 'WKAR NPR', 90.5,  'Talk Radio')
,(126, 'HopeFM', 90.7,    'Christian/Inspirational')
--,(124, 'MI Radio', 91.1, 'Talk Radio')
,(127, 'Unknown 14', 91.3, null)
--,(124, 'MI Radio', 91.7, 'Talk Radio') 
,(128, 'STACKS 92.1', 92.1, 'Party Hits')
,(129, 'Z92.5 The Castle', 92.5, 'Variety')
,(130, 'WDZZ 92.7 Flints R&B and Throwbacks', 92.7, 'Hip Hop')
,(131, 'Cruisin 92.9 Lansings Gtst Hits (WLMI)', 92.9, 'Classic Hits/Rock')
,(132, 'New Country 93.1 Detroits New Country', 93.1, 'Country')
,(133, 'Z93', 93.3, 'Rock')
--,(13, 'WHMI 93.5 Livingston Countys Own', 93.5, 'Classic Hits/Rock')
,(134, 'Club 93.7', 93.7, 'Hip Hop')
,(135, 'DUKE FM', 94.1, 'Country')
on conflict(radio_id)
do update set 
call_name=EXCLUDED.call_name,
fm_freq=EXCLUDED.fm_freq,
category=EXCLUDED.category;
