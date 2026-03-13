use mydb0304;
CREATE TABLE book (
    bookId INT AUTO_INCREMENT PRIMARY KEY,
    bookName VARCHAR(100) NOT NULL,
    Author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100) NOT NULL
);

INSERT INTO book (bookName, Author, publisher) VALUES
('자바의 정석', '남궁성', '도우출판'),
('스프링 부트 실전 가이드', '김철수', '한빛미디어'),
('클린 코드', '로버트 C. 마틴', '인사이트'),
('이것이 자바다', '신용권', '한빛미디어'),
('데이터베이스 개론', '박연정', '생능출판사'),
('리눅스 마스터 2급', '이민호', '영진닷컴'),
('HTTP 완벽 가이드', '데이빗 고를리', '인사이트'),
('객체지향의 사실과 오해', '조영호', '위키북스'),
('Do it! 플러터 앱 프로그래밍', '조준수', '이지스퍼블리싱'),
('SQL 첫걸음', '아사이 아츠시', '한빛미디어');
select*from book;