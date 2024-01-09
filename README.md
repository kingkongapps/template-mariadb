# Tempalte-MariaDB Project

## spring starter 구성 : [Starter Link](https://start.spring.io/)
```agsl
Spring Boot DevTools
Lombok
Spring Web
Thymeleaf
Spring Data JDBC
MyBatis Framework
MariaDB Driver
```



## MariaDB Setup
 * DB install 은 Docker, Local에 설치 또는 Remote DB 접속정보를 준비한다.
 * root로 접속하여
   * Database 생성
   * 계정 생성
   * 권한 부여를 한다.

### 사용자 계정 조회하기
```
SELECT User, Host FROM mysql.user;
```

### 내부에서만 접속 가능한 사용자 생성
```
CREATE USER 'tester'@'localhost' IDENTIFIED BY '1234';
```

### 아무데서나 접속 가능한 사용자 생성
```
CREATE USER 'tester'@'%' IDENTIFIED BY '1234';
```

### 권한 주기
GRANT ALL PRIVILEGES ON test.* TO 'tester'@'%';
```
GRANT ALL PRIVILEGES ON sampledb.* TO 'kang'@'%';
```

### Create Table
```agsl
CREATE TABLE sampledb.sample (
	id INT NOT NULL PRIMARY KEY,
	name varchar(100) NOT NULL,
	addr varchar(300) NOT NULL,
	cell_phone varchar(20) NOT NULL,
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;
```

### Sample Data Insert
```agsl
INSERT INTO sample VALUES (1, '홍길동', '서울시 관악구', '010-1111-2222');
INSERT INTO sample VALUES (2, '김길동', '서울시 성동구', '010-2222-3333');
INSERT INTO sample VALUES (3, '강길동', '서울시 종로구', '010-3333-4444');
INSERT INTO sample VALUES (4, '허길동', '서울시 강남구', '010-4444-5555');
```


---

### application.properties Setup
```agsl
#mariadb
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/sampledb
spring.datasource.username=test
spring.datasource.password=test1234

#mybatis-mapper
mybatis.mapper-locations=classpath:/mybatis/mapper/**/*.xml
mybatis.type-aliases-package=com.templatemariadb.vo        <--- aliases 가 복수 임.
mybatis.configuration.map-underscore-to-camel-case=true
```

### Thymeleaf Setup
* application.properties
```agsl
#thymeleaf
spring.thymeleaf.check-template-location=true
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.cache=false
```

* Controller
```agsl
    @GetMapping(value = "/sample_thymeleaf")
    public String getSampleThymeleaf(Model model) {
        Date today = new Date();
        //
        List<SampleVO> list = sampleService.getSampleList(new SampleVO());

        model.addAttribute("serverTime", today );
        model.addAttribute("sampleList", list);

        return "/sample/sample_thymeleaf";
    }
```

* HTML - &lt;html xmlns:th="http://www.thymeleaf.org"&gt;
```agsl
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="ko">
<head>
</head>
<body>
    <H1>Sample - Thymeleaf</H1>
    <h2> Server time is <span th:text="${serverTime}"></span></h2>

    <table>
        <tr th:each="sample : ${sampleList}">
            <td th:text="${sample.id}"></td>
            <td th:text="${sample.name}"></td>
            <td th:text="${sample.addr}"></td>
            <td th:text="${sample.cellPhone}"></td>
        </tr>
    </table>
</body>
</html>
```
