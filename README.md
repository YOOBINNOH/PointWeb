# PointWeb

<br/>
<br/>
 



 메인 페이지에는 로그인, 회원가입 두 가지 중 하나를 선택 할 수 있다. 만약 회원 세션이 있다면 바로 개인 회원 페이지로 이동시킨다.
<br/>
<br/>
 
 ![image](https://user-images.githubusercontent.com/76957075/236601407-45741d37-e435-4269-910a-734c4c4a2ebb.png)

 <br/>
<br/><br/>
<br/><br/>
<br/>
 
 

회원 가입은 Validation 을 이용해서 조건에 맞는 입력만 인식하도록 하였고, 이 역시도 회원 세션이 있다면 회원 페이지로 이동시켰다.
 <br/>
<br/>
![image](https://user-images.githubusercontent.com/76957075/236601432-0bb83cd5-788c-47b7-a6bb-569c511a30d7.png)

 
 
 
 <br/>
<br/><br/>
<br/><br/>
<br/> <br/>
<br/><br/>
<br/><br/>
<br/>
 
 
 
 
이미 사용중인 아이디로 회원가입을 시도하면 에러 페이지를 발생 시키고 회원가입 페이지로 다시 돌려 보낸다.
<br/>
<br/>
 ![image](https://user-images.githubusercontent.com/76957075/236601436-87937621-ca74-4628-90ce-9bced1407874.png)

 

 
 
  <br/>
<br/><br/>
<br/><br/>
<br/>
 

 
 
로그인 페이지 역시 Validation 을 이용해 제약을 해두었으며, host/1234 로 로그인 할 경우 admin 세션을 주어 관리자 페이지로 이동 시키고 일반 회원의 경우 회원 페이지로 이동시킨다.
<br/>
<br/>
 ![image](https://user-images.githubusercontent.com/76957075/236601440-f6bd7ed4-a064-4128-911c-a0ab9b124708.png)


 
 
  <br/>
<br/><br/>
<br/><br/>
<br/>

 
 
 
관리자 아이디로 로그인 한 경우이다. 각 회원들의 정보들을 볼 수 있으며, 아래의 button 을 통해 원하는 기능을 수행 할 수 있다.
<br/>
<br/>
 
![image](https://user-images.githubusercontent.com/76957075/236601442-9411359c-d42b-48af-b5ae-fc4ca323b750.png)

 
 

  <br/>
<br/><br/>
<br/><br/>
<br/>
 
 
 
회원 계정 관리 페이지에서는 회원를 삭제 할 수 있고, 회원의 팀을 이동시킬 수 있다. 없는 회원이라면 에러 페이지를 발생 시켰다.
<br/>
<br/>
 
![image](https://user-images.githubusercontent.com/76957075/236601444-f647c042-d059-45d8-9561-2bf214b7fc8e.png)

 
 
 
 
 <br/>
<br/><br/>
<br/><br/>
<br/>
 
 
 
회원 포인트 관리 페이지에서는 회원의 포인트 증감, 차감이 가능하다. 이 역시도 없는 아이디면 에러 페이지를 발생 시켰고, 차감한 포인트가 음수가 되면 0점이 되도록 예외 처리를 해주었다.
<br/>
<br/>
 
![image](https://user-images.githubusercontent.com/76957075/236601446-588241a2-0594-4e6f-a290-9ca20cd09fb9.png)

 
 

 
 <br/>
<br/><br/>
<br/><br/>
<br/>
 

 

 

 
 
탈퇴 회원 보기 페이지이다. 탈퇴한 회원들의 목록을 볼 수 있다.
<br/>
<br/>
 ![image](https://user-images.githubusercontent.com/76957075/236601449-c25e34b9-08dd-4298-91ed-e1fafd53d9b8.png)


 
 
 

  <br/>
<br/><br/>
<br/><br/>
<br/>

 

 

 
 
일반 회원 로그인 성공 시 나오는 페이지이다. 로그인 하면 100 포인트를 지급해주고 개인 페이지를 통해 정보를 보여준다. 아래 버튼들을 통해 원하는 기능을 수행할 수 있다.
<br/>
<br/>
 
![image](https://user-images.githubusercontent.com/76957075/236601454-d28f3d70-52ac-4702-abbc-68f3c40ec94e.png)

 
 
 

 

 
 <br/>
<br/><br/>
<br/><br/>
<br/>
 

 

 
포인트 선물하기를 통해 다른 회원에게 포인트를 지급할 수 있다. 포인트가 부족하거나, 존재하지 않은 회원이라면 각 경우에 맞는 에러 페이지를 보여주고, 다시 회원 페이지로 넘겨준다.
<br/>
<br/>
 ![image](https://user-images.githubusercontent.com/76957075/236601460-9df03da7-fa39-4abc-b6be-1f5a53857239.png)


 

  <br/>
<br/><br/>
<br/><br/>
<br/>
 

 

 

 

 
 
로그아웃을 누르면 다시 메인 페이지로 가고, 세션을 제거한다.
<br/>
<br/>
 
![image](https://user-images.githubusercontent.com/76957075/236601461-26d4ff38-d194-46cc-beb8-abe9bedbd580.png)

 
 

 

  <br/>
<br/><br/>
<br/><br/>
<br/>
 

 
 
회원 탈퇴하기를 누르면 회원 목록에서 제거 시키고, 탈퇴 회원 목록에 추가해주어서 host 가 탈퇴 회원 목록 체크 시 확인할 수 있도록 한다. 메인 페이지로 다시 돌아가도록 한다.
<br/>
<br/>
 ![image](https://user-images.githubusercontent.com/76957075/236601464-3120e599-778a-4a6f-859e-8a62e9cb48f9.png)


 

 

 

 

 

 

 

 
DB 는 H2 DB를 이용했고 sql 문을 사용해서 Member 와 Resign 을 조회할 수 있다.
<br/>
<br/>
 ![image](https://user-images.githubusercontent.com/76957075/236601466-4d4ea29f-e430-4c4f-a657-2a97d4c67b30.png)



