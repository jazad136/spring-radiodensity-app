-- dont forget fmquery
-- https://www.fcc.gov/media/radio/fm-query
--
--	radio_id bigint NOT NULL DEFAULT nextval('rs_rstation_seq'),
--	call_name varchar(40) UNIQUE, 
--	fm_freq numeric(4,1) NOT NULL,
--	category varchar(40), 
--	haat int, 
--	erpkw numeric(4,2)
--	PRIMARY KEY (radio_id)

-- (((LANSING STATIONS)))
INSERT INTO rstation (radio_id, call_name, fm_freq, category) VALUES 
 (1 , 'SmileFM', 88.1,          'Christian/Inspirational')
--,(1 , 'SmileFM', 88.5,        'Christian/Inspirational')
,(2 , 'WDBM-FM',88.9,           null)
,(3 , 'K-LOVE' , 89.1,          'Christian/Inspirational')
,(4 , 'Christian 1', 89.3,      'Christian/Inspirational')
,(5 , 'WCMU NPR', 89.5,         'Classical')
,(6 , 'MI Radio', 89.7,         'Talk Radio')
--,(9, 'MI Radio', 91.7,        'Talk Radio')
,(7 , 'WKAR NPR', 90.5,         'Classical')
,(8 , 'Christian 2', 90.9,      'Christian')
,(9, 'STACKS 92.1', 92.1,       'Party Hits')
,(10, 'Z92.5 The Castle', 92.5, 'Variety')
,(11, 'Cruisin 92.7 WLMI', 92.7,'Classic Hits')
,(12, 'Easy 93'  , 93.3,        'Easy Listening')
,(13, 'WHMI 93.5', 93.5,        'Classic Hits/Rock')
,(14, 'B93.7'    , 93.7,        'Country')
,(15, 'Duke 94.1', 94.1,        'Country')
,(16, '94.5 The Moose', 94.5,   'Country')
,(17, 'WMMQ 94.7', 94.7,        'Classic Hits')
,(18, 'WRBE 95.1', 95.1,        null)
,(19, 'ShineFM', 95.3,          'Christian/Inspirational')
,(21, 'WHNN', 96.1,             'Variety')
,(20, '95.9 Air1', 95.9,        'Christian/Inspirational')
,(22, 'Unknown 1', 96.5,        null)
,(23, 'NOW-FM'   , 97.5,        null)
,(24, 'KCQ'      , 98.1,        'Country')
,(25, 'WIN 98.5' , 98.5,        'Country')
,(26, 'WFMK-FM'  , 99.1,        'Variety') 
,(27, 'MyFLR Family Life Radio',99.7, 'Christian/Inspirational')
--,(27, 'MyFLR Family Life Radio',99.9, 'Christian/Inspirational')
,(28, 'JoyFM'    , 100.3,       'Christian/Inspirational')
,(29, 'WITL'     , 100.7,       'Country')
,(30, 'WHZZ MIKE 101.7', 101.7, 'Variety'
,(30, 'WKAR', 102.3,            null)
,(31, 'WIOG The Hits', 102.5,   null)
,(32, 'W4', 102.9,              'Country')
,(33, 'La Poderosa', 103.1,     'Mexican Format')
,(34, 'KFR', 103.3,             null)
,(35, 'The FOX', 103.9,         'Classic Hits')
,(36, 'Wheelz 104.5 (WILZ)', 104.5,    null)
,(37, 'Unknown 1', 104.7,       null)
,(38, 'CK105.5', 105.5,         'Classic Hits')
,(39, 'Star 105.7' , 105.7,     'Pop')
,(40, 'Q106' , 106.1 ,          'Hard Rock')
,(41, 'Unknown 2', 106.3,       null)
,(42, 'Unknown 3', 106.7,       null)
,(43, 'WZKO'  , 106.9,          null)
,(44, 'Unknown 4', 107.1,       null)
,(45, 'THUNDER 107.3', 107.3,  'Country')
,(46, 'Unknown 5', 107.7,      null)
,(47, 'Unknown 6', 107.9,      null);

--on conflict(radio_id)
--do update set 
--call_name=EXCLUDED.call_name,
--fm_freq=EXCLUDED.fm_freq,
--category=EXCLUDE

INSERT INTO rstation (radio_id, call_name, fm_freq, category, haat, erpkw) VALUES 
 (13, 'WHMI 93.5', 93.5, 'Classic Hits/Rock', 150, 5.20)
,(17, 'WMMQ 94.7', 94.7, 'Classic Hits', 150, 50.00)
on conflict(radio_id)
do update set 
call_name=EXCLUDED.call_name,
fm_freq=EXCLUDED.fm_freq,
category=EXCLUDED.category,
haat=EXCLUDED.haat,
erpkw=EXCLUDED.erpkw;