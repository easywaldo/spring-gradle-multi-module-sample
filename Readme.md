## SpringBoot Multi Gradle Build Sample
### 구성
- admin-api
  : 어드민 API 에 대한 컨트롤러 및 서비스 제공
- front-api
  : 일반 사용자 API 에 대한 컨트롤러 및 서비스 제공
- module-common
  : 공통으로 사용하게 될 엔터티 클래스 및 리포지토리 제공
- module-web
  : admin-api 와 front-api 를 포함하는 어플리케이션 진입점 모듈
  
#### Multi MainClass bootJar
-파라미터를 전달하여 bootJar 커맨드를 실행하는 경우 파라미터의 값에 따라서 admin, front MainClass 로
클래스 로더를 실행하여 Jar 를 빌드할 수 있도록 한다

```groovy
tasks.bootJar {
    enabled = true
    ext.profile = (!project.hasProperty('profile') || !profile) ? 'admin' : profile
    if (ext.profile == 'admin') {
        mainClassName = "com.example.moduleweb.admin.AdminModuleWebApplication"
        archiveFileName = "admin-web-server.jar"
    }
    else {
        mainClassName = "com.example.moduleweb.front.FrontModuleWebApplication"
        archiveFileName = "front-web-server.jar"
    }
}
```
아래와 같이 profile 파라미터를 이용하여 bootJar 를 실행한다
```shell
gradle bootJar -Pprofile=admin
```

#### Spring jar execution
```shell
java -jar .\front-web-server.jar -Dspring.server.port=8099
java -jar .\admin-web-server.jar -Dspring.server.port=8098
```

##### 참고문서
https://perfectacle.github.io/2017/09/23/Spring-boot-gradle-profile/
