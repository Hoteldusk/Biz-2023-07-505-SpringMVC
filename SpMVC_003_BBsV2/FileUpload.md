# String Server Application File Upload
- HTML 에서 파일을 선택하여 Server로 업로드를 할떄, form 에서 POST 방식으로 업로드 한다
- 원래 form 에서 Server 로 보내는 데이터는 Text 데이터이다. 이 Text Data 는 http 프로토콜의 body(payload	)에 담겨서 encoding 이 되어 전송된다
- form 에서 `type="file"` 형식의 input tag를 이용하여 BIN 파일을 업로드 하면 데이터가 body에 담기고 encoding 이 되는데 이과정에서 BIN 파일이 깨져버린다
- 그래서 HTML 에서는 form 의 전송되는 데이터에 새로운 규격을 추가했다 Text type 의 데이터와 None Text Type 데이터를 같이 묶음으로 하여 Server로 전송 할 수 있도록 form에 속성을 추가하였다
- form 에 `type="file"` 속성이 있는 input tag 가 있으면 form tag에 `enctype="multipart/form-data` 라는 속성을 첨가해야 한다
- form `enctype="multipart/form-data"` 라는 속성이 첨가되어 있으면 HTML 데이터를 전송하는 http 프로토콜이 종전의 form 데이터를 전송하는 방법과 달리 작동한다
- form 의 `enctype="multipart/form-data"` 는 Text 데이터와 None Text 데이터를 하나의 프로토콜 payload 에 묶으서 보내는 HTML 의 규격이다

## Spring Controller 에서 multipart/form-data 받기
- Spring Controller(Dispatcher Servlet)는 form 에서 전달되는 모든 데이터를 Text 로만 인식한다
- form 에서 아무리 `multipart/form-data` 형식으로 데이터를 보내도 Spring Controller 에서는 그러한 데이터를 수신(인식)하지 못한다
- Spring Project 에서 파일 업로드 기능을 구현하기 위해서는 다음의 2가지 Dependecies 를 설치해야 한다
- 현재 `commons-fileupload` 최신버전인 1.5 버전을 사용할 경우는 `commons-io`를 같이 설치하지 않아도 된다
- `commons-fileupload` `1.5` 버전을 설치하면 `commons-io` 2.11.0 버전이 의존성 관계에 적합한 도구로 자동 설치된다.

```xml
<!-- 2023.07.12 현재 -->
		<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.5</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.13.0</version>
		</dependency>
```

## Spring Project 에서 파일 업로드를 하기 위한 context 설정
- 파일의 업로드 허용 크기를 지정하여 bean을 하나 생성해 두면 된다
- 생성한 bean 을 직접 핸들링 하지 않고, 이 bean 은 Dispatcher Servlet 이 알아서 사용하는 bean
- `root-context.xml` 을 사용하여 전역적(global public) 세팅을 수행한다

## 이미지 파일을 업로드 하기
- 이미지 파일을 업로드 하는 방법은 원리적으로 이해를 하기에는 학습 분량이 너무 많다
- 절차적인 방법으로 구현을 해 보자
1. html 의 form 을 사용하여 파일을 업로드하는 속성 부여
2. 파일을 선택하기 위한 input tag 에 type 속성 부여
3. 이미지 파일을 선택하기 위하여 `accept` 속성
```html
<from method="POST"enctype="multipart/form-data">
	<input type="file" name="b_name" accept="image/*" />
</from>
```
4. controller 의 Multipart 객체를 매개변수로 사용하여 파일 정보를 수신한다
```java
@RequestParam(value="b_file") MultipartFile b_file,
```
5. FileService 의 fileUp() method 를 통하여 서버의 이미지 업로드 폴더에 파일 `transfer(전송)` 하기

6. fileUp() method 에서는 저장한 파일이름을 return
7. fileUp() method 가 return 한 파일이름을 DB의 table 에 저장한다
* 이미지를 업로드 할떄는 이미지 자체를 DB에 저장하지 않고, 이미지는 서버의 폴더에 저장하고, 이미지 파일 이름만 DB의 Table 에 저장한다. 이미지를 DB에 직접 저장하면 DB 성능에 막대한 문제가 발생한다
