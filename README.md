## 요구사항


* 식품매대
    * 양파(1,000원) 2개
    * 계란(2,000) 5판
    * 파(500) 10개
    * 사과(2,000원) 20개
* `web.xml`
    * `welcome-file-list` 항목에 `index.html` 을 추가합니다.
        * `index.html` 파일에는 `/foods`, `/cart` 로의 링크가 있으면 됩니다.
* Servlet 3.0 annotation + `ServletContainerInitializer` 적극 사용
    * `web.xml` 파일에 `<servlet>`, `<filter>`, `<listener>`, `<context-param>` 없도록
* Servlet
    * 로그인 / 로그아웃
        * `/loginForm.html`
        * `GET /login`
        * `POST /login`
        * `GET /logout`
    * `GET /foods`: 상품 목록
        * 응답에 상품 목록 출력
        * 원하는 상품을 선택해서 장바구니에 담을 수 있는 form 구성
        * 생각보다 복잡할 수 있으므로 우선 상품 목록 출력을 한 다음
            * 그 이후에 장바구니에 담을 수 있는 form을 구성하는 순서로 진행을 추천
    * `POST /cart` : 장바구니에 담기
        * 상품 수량보다 더 많은 주문을 하지 않았는 지 검증
        * 장바구니에 담은 수량만큼 상품매대에서 제거 처리
        * 응답 화면에 장바구니 화면으로 이동할 수 있는 링크 제공
    * `GET /cart`: 장바구니 화면
        * 응답에 장바구니에 담긴 상품 목록과 전체 금액 표시
* Filter
    * `CharacterEncodingFilter` : 모든 요청에 대해 character encoding을 `UTF-8`로 설정
    * `LoginCheckFilter`
        * 로그인 여부 체크
        * `/foods`, `/cart` 요청은 로그인을 해야만 접근 가능
            * 로그인을 하지 않은 상태에서 `/foods`, `/cart` 접근 시 로그인 페이지로 이동
            * 로그인 성공 시 자동으로 원래 URL (`GET /foods`나 `GET /cart`)로 redirect 되어야 함
    * `CounterFilter`
        * `GET /foods`, `GET /cart` 방문 시 카운트 증가 처리해서 로그에 기록
        * 방문자 수는 파일에 기록해서 서버 중지 후 재기동하여도 방문자 수 유지되어야 함
    * 그 외 필요한 경우 추가 생성 가능
* Listener
    * `SessionCountListener` : 현재 로그인된 세션 수의 변동을 로그에 기록
    * 그 외 필요한 경우 추가 생성 가능