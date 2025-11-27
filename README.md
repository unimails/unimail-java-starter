# unimail-java-starter

unimail-client 的 spring boot 官方依赖

<!-- TOC -->

* [unimail-java-starter](#unimail-java-starter)
    * [用法](#用法)
    * [LICENSE](#license)

<!-- TOC -->

## 用法

1. 引入依赖

```xml

<dependency>
    <groupId>space.i-curve</groupId>
    <artifactId>spring-boot-starter-unimail</artifactId>
    <version>0.0.2</version>
</dependency>
```

2. 设置key

application.yml

```yaml
unimail:
  key: xxx
```

3. 使用UnimailService

```java
import org.springframework.beans.factory.annotation.Autowired;
import spring.i_curve.UnimailService;

@Autowired
private UnimailService unimailService;

void test() {
    unimailService.sendEmail("email", "title", "content");
}
```

## LICENSE

[BSD 3-Clause License](LICENSE)