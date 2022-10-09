-- ((( FLINT STATIONS ))) 

INSERT INTO rstation (radio_id, call_name, fm_freq, category) VALUES 
 (47 , 'WHLCEV', 100.3,               'Christian/Inspirational')
,(48 , 'Unknown 7', 100.5,           'Talk Radio')
--,(29, 'WITL', 100.7,                'Country')  
,(49 , '101 WRIF', 101.1,             null)
,(50 , 'Banana 101.5', 101.5,         'Hard Rock')
,(51 , 'WDET Detroits NPR Station', 101.9, 'Talk Radio')
--,(31 , 'WIOG The Hits', 102.5,      'Classic Hits')
--,(3, 'K-LOVE', 102.7,               'Christian/Inspirational')
,(52, 'Unknown 8', 102.9,            'Country')
,(53, 'Unknown 9', 103.1,            'Latin American Broadcasting')
,(54, 'WMUZ-FM', 103.5,               'Christian/Inspirational')
,(55, '103.9 The FOX', 103.9,         'Classic Hits/Rock')
,(56, 'Unknown 10', 104.3,            null)
--,(36, 'Wheelz 104.5 (WILZ)', 104.5, 'Classic Hits/Rock')
,(57, 'WMRP', 104.7,                  'Country')
,(58, 'The Bounce', 105.1,            'Hip Hop')
,(59, 'CK105.5', 105.5,               'Variety')
,(60, 'Unknown 11', 105.9,            'Hip Hop')
--,(40, 'Q106', 106.1,                'Hard Rock')
--,(61, 'K-LOVE', 106.3,            'Christian/Inspirational')
,(61, 'WSNL', 106.5,            'Christian/Inspirational')
,(62, 'WILZ', 106.7,            'Christian/Inspirational')
,(63, 'Unknown 12', 106.9,      'Christian/Inspirational')
,(64, 'KISS', 107.1,            null)

on conflict(radio_id)
do update set 
call_name=EXCLUDED.call_name,
fm_freq=EXCLUDED.fm_freq,
category=EXCLUDED.category;