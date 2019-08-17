create table bs_user(
      id number(11) primary key ,
      username varchar2(100) not null unique,
      password varchar2(100) not null,
      email varchar2(100)
)

CREATE TABLE bs_book (
	id INTEGER (11) PRIMARY KEY auto_increment,
	title varchar(100) not null,
	authot varchar(100) not null,
	price double(11,2) not null,
	sales integer(11),
	stock integer(11),
	img_path varchar(100)
)
create table bs_order(
	id varchar(100) PRIMARY key, --主键
	total_count Integer(11),
	total_amount DOUBLE(11,2),
	state INTEGER(2),
	order_time datetime,
	user_id integer(11),
	FOREIGN key(user_id) references bs_user(id)
);
create table bs_orderitem(
	id integer(11) PRIMARY key auto_increment, --自增主键
	title varchar(100),
	author varchar(100),
	img_path varchar(100),
	price double(11,2),
	count integer(11),
	amount double(11,2),
	order_id varchar(100),
	FOREIGN key(order_id) references bs_order(id)
)
