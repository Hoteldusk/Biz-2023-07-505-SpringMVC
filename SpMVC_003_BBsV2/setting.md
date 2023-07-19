# thymeleaf 세팅

- slf4j 없어도 logback 이 대채
- thymeleaf 5만있어도됨

- servlet => prefix 경로변경, order우선순위 5로설정


## thymeleaf-context.xml => bean, context 체크
```xml
<!-- thymeleaf 로 만들어진 view 파일을 Rendering 하는 도구 -->
	<bean id="thViewResolver"
		class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
		<property name="prefix" value="/WEB-INF/views/html/" />
		<property name="suffix" value=".html" />
		<property name="templateMode" value="HTML" />
		<property name="cacheable" value="false" />
	</bean>
	<bean id="thEngine"
		class="org.thymeleaf.spring5.SpringTemplateEngine">
		<property name="templateResolver" ref="thViewResolver"/>
		<property name="enableSpringELCompiler" value="true"/>
		<property name="additionalDialects">
			<set>
				<bean class="nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect"/>
			</set>
		</property>
	</bean>
	<bean class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
		<property name="templateEngine" ref="thEngine"/>
		<property name="characterEncoding" value="UTF-8" />
	</bean>
```	