

/*
创建比赛表
*/

create table matches(
id integer primary key autoincrement,
season varchar(10),
date_of_match varchar(20),
home_court_team_id integer,
away_team_id integer,
hscore integer,
ascore integer,
hscore_of_first_section integer,
ascore_of_first_section integer,
hscore_of_second_section integer,
ascore_of_second_section integer,
hscore_of_third_section integer,
ascore_of_third_section integer,
hscore_of_fourth_section integer,
ascore_of_fourth_section integer,
is_overtime varchar(5),
unique (date_of_match,home_court_team_id,away_team_id)
);



/*
创建加时赛表
*/
create table overtime_matches(
id integer,
serial_number integer,
hscore integer,
ascore integer,
primary key(id,serial_number)
);



/*
创建球员比赛成绩表
*/
create table player_match_performance(
match_id integer,
team_id integer,
player_id integer,
player_position varchar(10),
presence_time integer,
shootings integer,
shots integer,
three_point_shootings integer,
three_point_shots integer,
free_throw_shootings integer,
free_throw_shots integer,
offensive_rebounds integer,
defensive_rebounds integer,
rebounds integer,
assists integer,
steals integer,
block_shots integer,
turn_overs integer,
fouls integer,
score integer,
double_double integer,
is_start integer,
player_name varchar(15),
primary key (player_name,match_id)
);



/*
创建球员信息表
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
num_of_double_double integer,
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
创建球队信息表
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
创建文件路径表
*/
create table paths(
id integer primary key autoincrement,
path varchar(100)
);
