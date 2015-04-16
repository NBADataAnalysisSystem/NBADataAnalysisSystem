

/*
����������
*/

create table matches(
id integer primary key autoincrement,
season varchar(10),
date_of_match varchar(20),
home_court_team varchar(10),
away_team varchar(10),
score varchar(10),
score_of_first_section varchar(10),
score_of_second_section varchar(10),
score_of_third_section varchar(10),
score_of_fourth_section varchar(10),
is_overtime varchar(5),
unique (date_of_match,home_court_team,away_team)
);



/*
������ʱ����
*/
create table overtime_matches(
id varchar��25��,
serial_number varchar(3),
score varchar(10),
primary key(id,serial_number)
);



/*
������Ա�����ɼ���
*/
create table player_match_performance(
match_id varchar(25),
team varchar(10),
player_name varchar(30),
player_position varchar(10),
presence_time varchar(20),
shootings varchar(4),
shots varchar(4),
three_point_shootings varchar(4),
three_point_shots varchar(4),
free_throw_shootings varchar(4),
free_throw_shots varchar(4),
offensive_rebounds varchar(4),
defensive_rebounds varchar(4),
rebounds varchar(4),
assists varchar(4),
steals varchar(4),
block_shots varchar(4),
turn_overs varchar(4),
fouls varchar(4),
score varchar(4),
primary key (player_name,match_id)
);



/*
������Ա��Ϣ��
*/
create table players(
id integer primary key autoincrement,
player_name varchar(30),
jersey_number varchar(4),
position varchar(4),
height varchar(4),
weight varchar(4),
birth varchar(4),
age varchar(4),
exp varchar(4),
school varchar(4),
team varchar(10),
num_of_match integer,
num_of_start integer,
rebounds integer,
assists integer,
presence_time integer,
offences integer,
defences integer,
steals integer,
block_shots integer,
turn_overs integer,
fouls integer,
score integer,
shootings integer,
shots integer,
three_point_shots integer,
three_point_shootings integer,
free_throw_shots integer,
free_throw_shootings integer,
efficiency float,
GmSc_eff float,
true_shooting_persentage float,
shooting_eff float,
rebound_rate float,
offensive_rebound_rate float,
defensive_rebound_rate float,
assist_rate float,
steal_rate float,
block_shot_rate float,
turn_over_rate float,
use_rate float,
unique (player_name,team)
);



/*
���������Ϣ��
*/
create table teams(
id integer primary key autoincrement,
full_name varchar(30),
abbreviation varchar(10),
location varchar(40),
division varchar(40),
section varchar(40),
home_court varchar(40),
setup_time varchar(20),
rebounds integer,
assists integer,
presence_time integer,
offences integer,
defences integer,
steals integer,
block_shots integer,
turn_overs integer,
fouls integer,
score integer,
shootings integer,
shots integer,
three_point_shots integer,
three_point_shootings integer,
free_throw_shots integer,
free_throw_shootings integer,
num_of_match integer,
num_of_win integer,
rival_presence_time integer,
rival_shootings integer,
rival_shots integer,
rival_three_point_shootings integer,
rival_three_point_shots integer,
rival_free_throw_shootings integer,
rival_free_throw_shots integer,
rival_offences integer,
rival_defences integer,
rival_rebounds integer,
rival_assists integer,
rival_steals integer,
rival_block_shots integer,
rival_turn_overs integer,
rival_fouls integer,
rival_score integer,
shooting_persentage float,
three_point_persentage float,
free_throw_persentage float,
win_rate float,
attack_round float,
defensive_round float,
offensive_eff float,
defensive_eff float,
offensive_rebound_eff float,
defensive_rebound_eff float,
steal_eff float,
assist_rate float
);



/*
�����ļ�·����
*/
create table paths(
id integer primary key autoincrement,
path varchar(100)
);
