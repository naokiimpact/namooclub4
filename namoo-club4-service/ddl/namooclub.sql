-- �����
create table `user` (
	`email`  varchar(40) not null comment '�����id(�̸���)', -- �����id(�̸���)
	`name`   varchar(50) not null comment '�̸�', -- �̸�
	`passwd` varchar(50) not null comment '��й�ȣ' -- ��й�ȣ
)
comment '�����';

-- �����
alter table `user`
	add constraint `pk_user` -- ����� �⺻ű
		primary key (
			`email` -- �����id(�̸���)
		);

-- ŀ�´�ƽ
create table `community` (
	`comm_no`     integer     not null comment 'ŀ�´�ƽ��ȣ', -- ŀ�´�ƽ��ȣ
	`name`        varchar(50) not null comment '�̸�', -- �̸�
	`description` text        null     comment '����', -- ����
	`reg_date`    timestamp   not null default now() comment '���ͻ�' -- ���ͻ�
)
comment 'ŀ�´�ƽ';

-- ŀ�´�ƽ
alter table `community`
	add constraint `pk_community` -- ŀ�´�ƽ �⺻ű
		primary key (
			`comm_no` -- ŀ�´�ƽ��ȣ
		);

alter table `community`
	modify column `comm_no` integer not null auto_increment comment 'ŀ�´�ƽ��ȣ';

-- ŭ��
create table `club` (
	`club_no`     integer     not null comment 'ŭ����ȣ', -- ŭ����ȣ
	`name`        varchar(50) not null comment '�̸�', -- �̸�
	`description` text        null     comment '����', -- ����
	`reg_date`    timestamp   not null default now() comment '���ͻ�', -- ���ͻ�
	`comm_no`     integer     not null comment 'ŀ�´�ƽ��ȣ', -- ŀ�´�ƽ��ȣ
	`category_no` integer     null     comment 'ī�װ?��ȣ' -- ī�װ?��ȣ
)
comment 'ŭ��';

-- ŭ��
alter table `club`
	add constraint `pk_club` -- ŭ�� �⺻ű
		primary key (
			`club_no` -- ŭ����ȣ
		);

alter table `club`
	modify column `club_no` integer not null auto_increment comment 'ŭ����ȣ';

-- ����ȸ��
create table `member` (
	`user_id`    varchar(40) not null comment '�����id', -- �����id
	`group_type` integer     not null comment '����', -- ����
	`group_no`   integer     not null comment '���ӹ�ȣ', -- ���ӹ�ȣ
	`level`      integer     not null comment '���' -- ���
)
comment '����ȸ��';

-- ����ȸ��
alter table `member`
	add constraint `pk_member` -- ����ȸ�� �⺻ű
		primary key (
			`user_id`,    -- �����id
			`group_type`, -- ����
			`group_no`    -- ���ӹ�ȣ
		);

-- ī�װ?
create table `category` (
	`category`    varchar(50) not null comment 'ī�װ?', -- ī�װ?
	`category_no` integer     not null comment 'ī�װ?��ȣ', -- ī�װ?��ȣ
	`comm_no`     integer     not null comment 'ŀ�´�ƽ��ȣ' -- ŀ�´�ƽ��ȣ
)
comment 'ī�װ?';

-- ī�װ?
alter table `category`
	add constraint `pk_category` -- ī�װ? �⺻ű
		primary key (
			`category_no` -- ī�װ?��ȣ
		);

alter table `category`
	modify column `category_no` integer not null auto_increment comment 'ī�װ?��ȣ';

-- ŭ��
alter table `club`
	add constraint `fk_community_to_club` -- ŀ�´�ƽ -> ŭ��
		foreign key (
			`comm_no` -- ŀ�´�ƽ��ȣ
		)
		references `community` ( -- ŀ�´�ƽ
			`comm_no` -- ŀ�´�ƽ��ȣ
		);

-- ŭ��
alter table `club`
	add constraint `fk_category_to_club` -- ī�װ? -> ŭ��
		foreign key (
			`category_no` -- ī�װ?��ȣ
		)
		references `category` ( -- ī�װ?
			`category_no` -- ī�װ?��ȣ
		);

-- ����ȸ��
alter table `member`
	add constraint `fk_user_to_member` -- ����� -> ����ȸ��
		foreign key (
			`user_id` -- �����id
		)
		references `user` ( -- �����
			`email` -- �����id(�̸���)
		);

-- ī�װ?
alter table `category`
	add constraint `fk_community_to_category` -- ŀ�´�ƽ -> ī�װ?
		foreign key (
			`comm_no` -- ŀ�´�ƽ��ȣ
		)
		references `community` ( -- ŀ�´�ƽ
			`comm_no` -- ŀ�´�ƽ��ȣ
		);