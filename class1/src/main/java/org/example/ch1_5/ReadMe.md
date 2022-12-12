## CGI ( Common GateWay Interface)
- 웹 서버와 애플리케이션 사이에 데이터를 주고받는 규약
- CGI규칙에 따라서 만들어진 프로그램을 CGI프로그램이라고 함
- CGI프로그램 종류로는 컴파일(java) 방식과 인터프리터(python) 방식이 있음

![스크린샷 2022-11-07 오전 9 38 07](https://user-images.githubusercontent.com/39672033/200204815-dc2715a5-a00a-4b8f-9397-f32e41c79a0e.png)

웹 서버와 Script Engine사이에는 CGI규칙에 따라 데이터를 주고받는다.
웹 서버와 서블릿 컨테이너도 마찬가지로 CGI규칙에 따라 데이터를 주고받는다.
따라서 개발자는 CGI를 몰라도 데이터를 주고받을 수 있다. 
대신 서블릿 컨테이너와 서블릿 파일사이의 규칙을 알아야 한다.

## 서블릿 이란?
- 자바에서 웹 애플리케이션을 만드는 기술
- 자바에서 동적인 웹 페이지를 구현하기 위한 표준


## 서블릿 컨테이너
- 서블릿의 생성부터 소멸까지의 라이프사이클을 관리한다.
- 웹 서버와 소켓을 만들고 통신하는 과정을 대신 처리한다. 따라서 개발자는 비즈니스 로직에만 집중하면 된다.
- 서블릿 객체들은 싱글톤으로 관리된다.
  - 상태를 유지하도록 설계하면 안됨(Thread Safe하지 않음)

### Engin vs 컨테이너
컨테이너라는 말을 붙일때에는 라이프사이클을 관리할때 보통 붙인다. 
따라서 서블릿 컨테이너는 서블릿의 라이프사이클을 관리하지만 Script Engine은 그렇지 않다라는 것을 알 수 있다.

## WAS vs 서블릿 컨테이너
- WAS를 서블릿 컨테이너를 포함하는 개념
- WAS는 매 요청마다 스레드 풀에서 기존 스레드를 사용함
- 따라서 WAS의 주요 튜닝 포인트는 max thread수를 조절
- 대표적으로 WAS로는 톰켓이 있다.