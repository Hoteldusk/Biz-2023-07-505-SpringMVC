# Tile Layout 설정

## JSP 을 위한 Layout 설정 도구
- tiles 를 설정하기 위한 dependencies 설정
- spring 5.x 이상에서는 tiles-extras 만 설정해도 기타 필요한 dependency를 모드 import 해 준다
- 다만 tiles-extras 를 설정한 후 Maven Dependecies 에 tiles-core 가 함께 import 되었는지 확인할 필요가 있다
- 만약 tiles-core 가 import 되지 않았을 경우 tiles-extras 와 같은 version 의 tiles-core 를 설정해 주어야 한다

```xml
<properties>
		<tiles-version>3.0.8</tiles-version>
	</properties>

	<dependencies>

		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-core -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-core</artifactId>
			<version>${tiles-version}</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>${tiles-version}</version>
		</dependency>
		
	</dependencies>
```	

### InteranlResourceViewResolver 와 협력관계 설정
- tiles-context.xml 설정 파일을 appServlet 폴더에 생성한다
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<!-- 
	tiles 설정
	tiles 는 InternalResourceViewResolver 와 함께 협력하여
	JSP 파일로 Layout 을 구현하는 도구
	2개의 bean 생성
	
	TilesConfigure tilesConfigure = new TilesConfigure()
	List<String> layouts = new ArrayList<String>()
	layouts.add("main-layout.xml");
	layouts.add("book-layout.xml");
	tilesConfigure.setDefinitions(layouts);
	 -->
	<bean id = "tilesConfigurer" class ="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>/WEB-INF/spring/tiles-layout/*-layout.xml</value>
			</list>
		</property>
	</bean>
	
	<bean class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"></property>
		<property name="order" value="1"></property>
	</bean>
	
</beans>
```
- spring 폴더에 tiles-layout 폴더 만든후 ~~~-layout 이름의 파일을 생성
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE tiles-definitions PUBLIC
  "-//Apache Software Foundation//DTD Tiles Configuration 3.0//EN"
  "http://tiles.apache.org/dtds/tiles-config_3_0.dtd">

  <tiles-definitions>
  		<definition name="default" template="/WEB-INF/views/home.jsp">
  		
  		</definition>
  		<definition name="home" extends="default">
  		
  		</definition>
  </tiles-definitions>
  ```

  - 해당 jsp 파일에 태그 추가
  ```jsp
  <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
  ```