# nextstep-shop

쇼핑몰 주문·할인·환불 도메인을 **Cucumber 기반 ATDD**로 개발하는 NextStep 교육용 프로젝트입니다.

## 기술 스택

- Java 21, Spring Boot 2.7.18, Gradle 8.14.3
- Cucumber 7 + JUnit 5, Testcontainers(PostgreSQL), RestAssured
- Liquibase

## 실행

JDK 21이 필요합니다. 인수 테스트를 실행하려면 Docker가 실행 중이어야 합니다.

```bash
./gradlew test             # 단위 테스트
./gradlew acceptanceTest   # 인수 테스트
./gradlew check            # 단위 + 인수 테스트
```

애플리케이션을 직접 실행할 때는 로컬 DB(PostgreSQL)를 먼저 띄웁니다. 인수 테스트는 Testcontainers DB를 쓰므로 로컬 DB가 필요 없습니다.

```bash
docker compose up -d       # 로컬 DB 실행 (localhost:5432/nextstep_shop)
./gradlew bootRun          # 애플리케이션 실행
docker compose down        # 로컬 DB 종료 (데이터는 볼륨에 남는다)
```

## 문서

- 요구사항: `docs/requirements/`
- 도메인 용어 사전: `docs/glossary.md`
- 의사결정 로그: `docs/decision-log.md`
- AI 협업 규칙: `CLAUDE.md`

## 출처

프로젝트 초기 설정은 [Setup Cucumber, Testcontainers, JUnit5 in Spring Boot](https://datmt.com/backend/java/javaee/setup-cucumber-testcontainers-junit5-in-spring-boot-project/)를 바탕으로 했습니다.
