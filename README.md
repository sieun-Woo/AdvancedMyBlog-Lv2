# ERD

![Blog (5)](https://user-images.githubusercontent.com/116184724/208817386-d1af4554-2f8f-4a9a-9d93-128a66ada329.png)

# API 명세서

| 기능 | API URL | Method | Request  Header | Request | Response | Response header |
| --- | --- | --- | --- | --- | --- | --- |
| 회원가입 | /api/user/signup | Post |   | {       "username" : "dntldms12",       "password" : "tldms6352"   } | {     "statusCode": "200",     "msg": "회원가입 성공"   } |   |
| 로그인 | /api/user/login | Post |   | {       "username" : "dntldms12",       "password" : "tldms6352"   } |   | Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkbnRsZG1zMTIiLCJleHAiOjE2NzExNzE4NDYsImlhdCI6MTY3MTE2ODI0Nn0.3Lmlw89uwcPAhK2xRZuGSHOhwHk\_wWGcA9ORFdIZjVc   Content-Type: application/json |
| 전체 게시글 목록조회 | /api/posts | Get |   |   | \[     {       "id": 2,       "title": "title2",       "username": "dntldms12",       "createdAt": "2022-12-16T14:35:16.778038",       "modifiedAt": "2022-12-16T14:35:16.778038",       "contents": "contents2"     },     {       "id": 1,       "title": "title",       "username": "dntldms12",       "createdAt": "2022-12-16T14:32:23.520497",       "modifiedAt": "2022-12-16T14:32:23.520497",       "contents": "contents"     }   \] |   |
| 선택 게시글 조회 | /api/post/{id} | Get |   |   | {     "id": 1,     "title": "title",     "username": "dntldms12",     "createdAt": "2022-12-16T14:32:23.520497",     "modifiedAt": "2022-12-16T14:32:23.520497",     "contents": "contents"   } |   |
| 게시글 작성 | /api/post | Post | Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkbnRsZG1zMTIiLCJleHAiOjE2NzExNzE4NDYsImlhdCI6MTY3MTE2ODI0Nn0.3Lmlw89uwcPAhK2xRZuGSHOhwHk\_wWGcA9ORFdIZjVc   Content-Type: application/json | {       "title" : "title",       "contents" : "contents"   } | {     "id": 1,     "title": "title",     "username": "dntldms12",     "createdAt": "2022-12-16T14:32:23.5204973",     "modifiedAt": "2022-12-16T14:32:23.5204973",     "contents": "contents"   } |   |
| 게시글 수정 | /api/post/{id} | Post | Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkbnRsZG1zMTIiLCJleHAiOjE2NzExNzE4NDYsImlhdCI6MTY3MTE2ODI0Nn0.3Lmlw89uwcPAhK2xRZuGSHOhwHk\_wWGcA9ORFdIZjVc   Content-Type: application/json | {       "title" : "changedtitle",       "contents" : "changedcontents"   } | {     "id": 1,     "title": "changedtitle",     "username": "dntldms12",     "createdAt": "2022-12-16T14:32:23.520497",     "modifiedAt": "2022-12-16T14:32:23.520497",     "contents": "changedcontents"   } |   |
| 게시글 삭제 | /api/post/{id} | Delete | Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkbnRsZG1zMTIiLCJleHAiOjE2NzExNzE4NDYsImlhdCI6MTY3MTE2ODI0Nn0.3Lmlw89uwcPAhK2xRZuGSHOhwHk\_wWGcA9ORFdIZjVc   Content-Type: application/json |   | {     "statusCode": "200",     "msg": "게시글이 삭제되었습니다."   } |   |

# 자기점검

스프링에 대한 이해도가 아직 부족하다는 것을 알 수 있었다.  
과제와 진도에 매몰되어 깊이 있는 공부를 하지 못하였다.  
JPA에 대한 이해도가 부족하다.  
사용하고 있는 어노테이션에 대한 이해가 부족하다.  
IoC / DI에 대한 이해가 부족하다.  
테이블 간의 관계 형성에 대한 이해가 부족하다.  
제대로 된 이해 없이 더 이상의 과제 진행은 학습에 있어서 혼란이 가중될 것이라고 생각한다.  
기초 지식에 대한 학습이 필요하다.
