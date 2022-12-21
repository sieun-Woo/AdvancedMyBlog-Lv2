# API 명세서

|Method|URL|Description|Request|Resquest Header|Response|Response Header|
|-|-|-|-|-|-|
|POST|/api/user/signup|회원가입|{"username": "username", "password" : "password"}|-|{"statusCode": "200","msg": "회원가입 성공"}|-|
|POST|/api/user/login|로그인|{"username": "username", "password" : "password"}|-|{"statusCode": "200","msg": "로그인 성공"}|Authorization: Bearer|-| 

# ERD

![Blog (5)](https://user-images.githubusercontent.com/116184724/208817386-d1af4554-2f8f-4a9a-9d93-128a66ada329.png)

# 배운점

1. 처음 설계한 API 명세서에 변경사항이 있었나요?
처음 설계와 비교하여 큰 변화는 없었다.
    
2. ERD를 먼저 설계한 후 Entity를 개발했을 때 어떤 점이 도움이 되셨나요?
과제를 진행하면서 설계하려는 구조를 도식도로 자주 확인이 가능했기 때문에 복잡한 부분도 이해하기 쉬웠다.
    
3. JWT를 사용하여 인증/인가를 구현 했을 때의 장점은 무엇일까요?
HTTP만으로는 구현하기 어려웠던 회원 가입과 로그인을 JWT라는 기술을 활용하여 쉽게 구현 할 수 있었다. JWT를 통해 회원가입과 로그인을 간편하게 구현 할 수 있고, 
복호화를 통해 보안성을 높일 수 있다.
    
4. 반대로 JWT를 사용한 인증/인가의 한계점은 무엇일까요?
외부 공격자가 접근하기 쉬운 위치 놓여있고 정보노출 가능성으로 인해 저장할 수 있는 정보가 제한적이다.

5. 만약 댓글 기능이 있는 블로그에서 댓글이 달려있는 게시글을 삭제하려고 한다면 무슨 문제가 발생할까요? Database 테이블 관점에서 해결방법이 무엇일까요?
게시글이 삭제 되어도 댓글은 데이터베이스에 남아있을 것이라고 생각한다. 
    
6. IoC / DI 에 대해 간략하게 설명해 주세요!
Ioc(Inversion of Control / 제어의 역전)는 DI(Dependency Injection / 의존성 주입)와 같은 의미로 사용되는데 외부에서 두 객체 간의 관계를 결정해주는 디자인 패턴으로, 인터페이스를   사이에 둬서 클래스 레벨에서는 의존관계가 고정되지 않도록 하고 런타임 시에 관계를 동적으로 주입하여 유연성을 확보하고 결합도를 낮출 수 있게 해준다.
