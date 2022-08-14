-- dont forget fmquery
-- https://www.fcc.gov/media/radio/fm-query
--
--	radio_id bigint NOT NULL DEFAULT nextval('rs_rstation_seq'),
--	call_name varchar(40), 
--	fm_freq numeric(4,1) NOT NULL,
--	category varchar(40), 
--	haat int, 
--	erpkw numeric(4,2), 
--	PRIMARY KEY (radio_id)
INSERT INTO rstation (radio_id, call_name, fm_freq, category) VALUES 
 (1 , 'SmileFM', 88.1,        'Christian/Inspirational')
,(2 , 'SmileFM', 88.5,        'Christian/Inspirational')
,(3 , 'WDBM-FM',88.9,         null)
,(4 , 'K-LOVE' , 89.1,        'Christian/Inspirational')
,(5 , 'Christian 1', 89.3,    'Christian/Inspirational')
,(6 , 'WCMU NPR', 89.5,       'Classical')
,(7 , 'MI Radio', 89.7,       'Talk Radio')
,(8 , 'WKAR', 90.5,           'Classical')
,(9 , 'Christian 2', 90.9,               'Christian')
,(10, 'MI Radio', 91.7,       'Talk Radio')
,(11, 'STACKS 92.1', 92.1,    'Party Hits')
,(12, 'Z92.5 The Castle', 92.5, 'Variety')
,(13, 'Cruisin 92.7 WLMI', 92.7, 'Classic Hits')
,(14, 'Easy 93'  , 93.3,      'Easy Listening')
,(15, 'WHMI 93.5', 93.5,      'Classic Hits/Rock')
,(16, 'B93.7'    , 93.7,      'Country')
,(17, 'Duke 94.1', 94.1,      'Country')
,(18, '94.5 The Moose', 94.5, 'Country')
,(19, 'WMMQ 94.7', 94.7,       'Classic Hits')
,(20, 'WRBE 95.1', 95.1,       null)
,(21, '95.9 Air1', 95.9,        'Christian/Inspirational')
,(22, 'Unknown 1', 96.1,        null)
,(23, 'Unknown 2', 96.5,        null)
,(24, 'NOW-FM'   , 97.5,        null)
,(25, 'KCQ'      , 98.1,        'Country')
,(26, 'WIN 98.5' , 98.5,        'Country')
,(27, 'WFMK-FM'  , 99.1,        'Variety') 
,(28, 'MyFLR Family Life Radio',99.7, 'Christian/Inspirational')
,(29, 'MyFLR Family Life Radio',99.9, 'Christian/Inspirational')
,(30, 'JoyFM'    , 100.3,       'Christian/Inspirational')
,(31, 'WITL'     , 100.7,       'Country')
,(32, 'WKAR', 102.3,            null)
,(33, 'WIOG', 102.5,            null)
,(34, 'W4', 102.9,              'Country')
,(35, 'Unknown 3', 103.1,      null)
,(36, 'KFR', 103.3,            null)
,(37, 'Unknown 4', 103.9,               null)
,(38, 'Wheelz WILZ', 104.5,    null)
,(39, 'Unknown 5', 104.7,      null)
,(40, 'CK105.5', 105.5,        'Classic Hits')
,(41, 'Unknown 6' , 105.7,     null)
,(42, 'Q106' , 106.1 ,         null)
,(43, 'Unknown 7', 106.3,      null)
,(44, 'Unknown 8', 106.7,      null)
,(45, 'WZKO'  , 106.9,         null)
,(46, 'Unknown 9', 107.1,      null)
,(47, 'THUNDER 107.3', 107.3, 'Country')
,(48, 'Unknown 10', 107.7,      null)
,(49, 'Unknown 11', 107.9,     null)
on conflict(radio_id)
do update set 
call_name=EXCLUDED.call_name,
fm_freq=EXCLUDED.fm_freq,
category=EXCLUDED.category;

INSERT INTO rstation (radio_id, call_name, fm_freq, category, haat, erpkw) VALUES 
 (15, 'WHMI 93.5', 93.5, 'Classic Hits/Rock', 150, 5.20)
,(19, 'WMMQ 94.7', 94.7, 'Classic Hits', 150, 50.00)
on conflict(radio_id)
do update set 
call_name=EXCLUDED.call_name,
fm_freq=EXCLUDED.fm_freq,
category=EXCLUDED.category,
haat=EXCLUDED.haat,
erpkw=EXCLUDED.erpkw;
