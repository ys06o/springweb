#[1] 데이터베이스 생성 
drop DATABASE if EXISTS boardservice7;
create database boardservice7;
use boardservice7;

#[2]테이블 생성
create table board(
	bno int unsigned auto_increment,
    constraint primary key(bno),
    bcontent longtext not null,
    bwriter varchar(30) not null,
    bdate datetime default now()
);

#[3] 테이블 샘플 데이터 삽입
INSERT INTO board (bcontent, bwriter) VALUES 
('오늘도 즐거운 하루 되세요!', '홍길동'),
('게시판 테스트 중입니다. 잘 작동하네요.', '김철수'),
('점심 메뉴로 제육볶음 어떠신가요?', '맛점선생'),
('데이터베이스 공부는 끝이 없네요.', '열공모드'),
('주말에 등산 가시는 분 계신가요?', '산악대장'),
('새로 가입했습니다. 잘 부탁드립니다!', '새내기'),
('날씨가 갑자기 추워졌네요. 감기 조심하세요.', '건강제일'),
('오늘 배운 SQL 문법 정리 중입니다.', '공부왕'),
('최신 영화 리뷰 공유합니다.', '무비마니아'),
('노트북 추천 좀 부탁드려도 될까요?', '컴맹탈출'),
('고양이 집사님들 소통해요!', '야옹이'),
('독서 모임 인원 모집합니다 (3/5)', '책벌레'),
('운동 오운완! 뿌듯하네요.', '근성맨'),
('파이썬이랑 자바 중에 뭐가 더 쉬운가요?', '코딩초보'),
('여행 가서 찍은 사진인데 구경하세요.', '방랑자'),
('비 오는 날엔 역시 파전에 막걸리죠.', '주술사'),
('주식 시장이 심상치 않네요.', '개미는뚠뚠'),
('카페에서 코딩하면 집중이 잘 돼요.', '카공족'),
('벌써 퇴근 시간이 다 되어가네요!', '칼퇴기원'),
('마지막 샘플 데이터 입력 완료했습니다.', '관리자');
select*from board;