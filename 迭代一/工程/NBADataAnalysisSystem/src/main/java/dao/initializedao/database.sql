

/*
创建比赛表
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
创建加时赛表
*/
create table overtime_matches(
id varchar（25）,
serial_number varchar(3),
score varchar(10),
primary key(id,serial_number)
);



/*
创建球员比赛成绩表
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
team_id int,
num_of_match varchar(4),
num_of_start varchar(4),
rebounds varchar(6),
assists varchar(6),
presence_time varchar(10),
offences varchar(6),
defences varchar(6),
steals varchar(6),
block_shots varchar(6),
turn_overs varchar(6),
fouls varchar(6),
score varchar(10),
unique (player_name,team_id)
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
setup_time varchar(20)
);



/*
创建文件路径表
*/
create table paths(
id integer primary key autoincrement,
path varchar(100)
);
