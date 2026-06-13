# unimail-java-starter

> 当前sdk的版本是v2, 如果你需要用以前的v1版本, 请切换v1分支

unimail-java-sdk 的 spring boot 官方依赖

## 兼容性

- Spring Boot 2.7.x
- Spring Boot 3.x
- Spring Boot 4.x

本 starter 同时保留了 `spring.factories`（兼容 Boot 2）和 `AutoConfiguration.imports`（兼容 Boot 3/4）两种自动配置注册方式。

本 starter 不向业务项目传递固定 Spring Boot 版本，业务项目使用自己的 Spring Boot BOM/Parent 决定最终版本。

## 用法

1. 引入依赖

```xml

<dependency>
    <groupId>top.allcloud</groupId>
    <artifactId>spring-boot-starter-unimail</artifactId>
    <version>1.0.0</version>
</dependency>
```


2. 设置key

application.yml

```yaml
unimail:
  key: xxx
```

可选配置如下：

| 配置项 | 类型 | 默认值 | 说明 |
| --- | --- | --- | --- |
| `unimail.enabled` | `boolean` | `true` | 是否启用自动装配 |
| `unimail.key` | `String` | - | API Key，启用时必填 |
| `unimail.host` | `String` | - | 自定义 API Host |
| `unimail.language` | `String` | - | 接口语言 |

自动装配生效条件：
- `unimail.enabled=true`（默认）
- 存在 `unimail.key` 配置

3. 使用UnimailService

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.allcloud.UnimailService;

@Service
public class DemoService {
    @Autowired
    private UnimailService unimailService;

    void test() {
        // unimailService.sendEmail("email", "title", "content");
    }
}
```

## LICENSE

[BSD 3-Clause License](LICENSE)
