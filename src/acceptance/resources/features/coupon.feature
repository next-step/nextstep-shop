Feature: 쿠폰

  @wip
  Scenario: 등록한 정액 쿠폰은 쿠폰 코드로 조회하면 할인 금액이 같다
    Given 할인 금액이 3000원인 정액 쿠폰 "WELCOME3000"이 있다
    Then 쿠폰 "WELCOME3000"을 조회하면 할인 금액은 3000원이다

  @wip
  Scenario: 등록한 정률 쿠폰은 쿠폰 코드로 조회하면 할인율이 같다
    Given 할인율이 10%인 정률 쿠폰 "TEN"이 있다
    Then 쿠폰 "TEN"을 조회하면 할인율은 10%이다
