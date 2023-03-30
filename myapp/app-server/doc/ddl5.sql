create table app_student(
  student_id int not null,
  name varchar(50) not null,
  tel varchar(20),
  created_date datetime default now(),
  pst_no varchar(5),
  bas_addr varchar(255),
  det_addr varchar(255),
  work boolean,
  gender char(1),
  level int
);

alter table app_student
  add constraint primary key (student_id),
  modify column student_id int not null auto_increment;

  
  create table app_hyunwoo(
  member_id int not null,
  pst_no varchar(5),
  bas_addr varchar(255),
  det_addr varchar(255),
  work boolean,
  gender char(1),
  level int
);

alter table app_hyunwoo
  add constraint primary key (member_id),
  add constraint app_hyunwoo_fk foreign key (member_id) references app_member (member_id);

alter table app_hyunwoo
  modify column work boolean not null,
  modify column level int not null;
