-- 테스트 케이스를 실행할 때 마다 테이블을 생성하기 때문에 프로젝트 단위로 테스트 케이스를 실행하거나
-- 한번에 여러개의 테스트 케이스를 실행할 때 문제가 생기지 않도록 같은 테이블이 이전에 생성된 경우 지워주고 새로 생성하도록 함
DROP TABLE IF EXISTS USER RESTRICT;
DROP TABLE IF EXISTS COMMUNITY RESTRICT;
DROP TABLE IF EXISTS CLUB RESTRICT;
DROP TABLE IF EXISTS MEMBER RESTRICT;
DROP TABLE IF EXISTS CATEGORY RESTRICT;

-- 사용자
CREATE TABLE USER (
	EMAIL  VARCHAR(40) NOT NULL, -- 사용자ID(이메일)
	NAME   VARCHAR(50) NOT NULL, -- 이름
	PASSWD VARCHAR(50) NOT NULL -- 비밀번호
);

-- 사용자
ALTER TABLE USER
	ADD CONSTRAINT PK_USER -- 사용자 기본키
		PRIMARY KEY (
			EMAIL -- 사용자ID(이메일)
		);

-- 커뮤니티
CREATE TABLE COMMUNITY (
	COMM_NO     INTEGER     NOT NULL, -- 커뮤니티번호
	NAME        VARCHAR(50) NOT NULL, -- 이름
	DESCRIPTION TEXT        NULL, -- 설명
	REG_DATE    TIMESTAMP   NOT NULL DEFAULT NOW() -- 생성일시
);

-- 커뮤니티
ALTER TABLE COMMUNITY
	ADD CONSTRAINT PK_COMMUNITY -- 커뮤니티 기본키
		PRIMARY KEY (
			COMM_NO -- 커뮤니티번호
		);

ALTER TABLE COMMUNITY
	MODIFY COLUMN COMM_NO INTEGER NOT NULL AUTO_INCREMENT;

-- 클럽
CREATE TABLE CLUB (
	CLUB_NO     INTEGER     NOT NULL, -- 클럽번호
	NAME        VARCHAR(50) NOT NULL, -- 이름
	DESCRIPTION TEXT        NULL, -- 설명
	REG_DATE    TIMESTAMP   NOT NULL DEFAULT NOW(), -- 생성일시
	COMM_NO     INTEGER     NOT NULL, -- 커뮤니티번호
	CATEGORY_NO INTEGER     NULL -- 카테고리번호
);

-- 클럽
ALTER TABLE CLUB
	ADD CONSTRAINT PK_CLUB -- 클럽 기본키
		PRIMARY KEY (
			CLUB_NO -- 클럽번호
		);

ALTER TABLE CLUB
	MODIFY COLUMN CLUB_NO INTEGER NOT NULL AUTO_INCREMENT;

-- 모임회원
CREATE TABLE MEMBER (
	USER_ID    VARCHAR(40) NOT NULL, -- 사용자ID
	GROUP_TYPE INTEGER     NOT NULL, -- 구분
	GROUP_NO   INTEGER     NOT NULL, -- 모임번호
	LEVEL      INTEGER     NOT NULL -- 등급
);

-- 모임회원
ALTER TABLE MEMBER
	ADD CONSTRAINT PK_MEMBER -- 모임회원 기본키
		PRIMARY KEY (
			USER_ID,    -- 사용자ID
			GROUP_TYPE, -- 구분
			GROUP_NO    -- 모임번호
		);

-- 카테고리
CREATE TABLE CATEGORY (
	CATEGORY    VARCHAR(50) NOT NULL, -- 카테고리
	CATEGORY_NO INTEGER     NOT NULL, -- 카테고리번호
	COMM_NO     INTEGER     NOT NULL -- 커뮤니티번호
);

-- 카테고리
ALTER TABLE CATEGORY
	ADD CONSTRAINT PK_CATEGORY -- 카테고리 기본키
		PRIMARY KEY (
			CATEGORY_NO -- 카테고리번호
		);

ALTER TABLE CATEGORY
	MODIFY COLUMN CATEGORY_NO INTEGER NOT NULL AUTO_INCREMENT;

