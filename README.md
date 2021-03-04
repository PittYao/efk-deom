#elk demo
## 1.logback
### 1.1 logback-spring.xml收集日志  
   
   - 配置文件收集日志
        ```xml
       <!--2.输出到文件-->
      
          <!--2.1 debug级别日志输出-->
          <appender name="DEBUG_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
              <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                  <!-- 日志归档名称  LOG_FILE_PATH = application.logging.file.name  APP_NAME=logstash -->
                  <fileNamePattern>${LOG_FILE_PATH}/debug/${APP_NAME}-debug-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
                  <!--日志文档保留天数-->
                  <maxHistory>${log.maxHistory}</maxHistory>
                  <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                      <!-- 日志分割文件最大大小               -->
                      <maxFileSize>${log.maxFileSize}</maxFileSize>
                  </timeBasedFileNamingAndTriggeringPolicy>
              </rollingPolicy>
              <!--日志文档输出格式-->
              <encoder>
                  <pattern>${FILE_LOG_PATTERN}</pattern>
                  <charset>UTF-8</charset> <!-- 此处设置字符集，防止中文乱码 -->
              </encoder>
              <!-- 此日志文档只记录debug级别的 -->
              <filter class="ch.qos.logback.classic.filter.LevelFilter">
                  <level>debug</level>
                  <onMatch>ACCEPT</onMatch>
                  <onMismatch>DENY</onMismatch>
              </filter>
          </appender>
          <!--2.2 Info级别日志输出-->
          <appender name="INFO_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
              <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                  <!-- 日志归档名称  LOG_FILE_PATH = logging.file.name  APP_NAME=logstash -->
                  <fileNamePattern>${LOG_FILE_PATH}/info/${APP_NAME}-info-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
                  <!--日志文档保留天数-->
                  <maxHistory>${log.maxHistory}</maxHistory>
                  <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                      <!-- 日志分割文件最大大小               -->
                      <maxFileSize>${log.maxFileSize}</maxFileSize>
                  </timeBasedFileNamingAndTriggeringPolicy>
              </rollingPolicy>
              <!--日志文档输出格式-->
              <encoder>
                  <pattern>${FILE_LOG_PATTERN}</pattern>
                  <charset>UTF-8</charset> <!-- 此处设置字符集，防止中文乱码 -->
              </encoder>
              <!-- 此日志文档只记录info级别的 -->
              <filter class="ch.qos.logback.classic.filter.LevelFilter">
                  <level>INFO</level>
                  <onMatch>ACCEPT</onMatch>
                  <onMismatch>DENY</onMismatch>
              </filter>
          </appender>
          <!--2.3 Warn级别日志输出-->
          <appender name="WARN_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
              <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                  <!-- 日志归档名称  LOG_FILE_PATH = logging.file.name  APP_NAME=logstash -->
                  <fileNamePattern>${LOG_FILE_PATH}/warn/${APP_NAME}-warn-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
                  <!--日志文档保留天数-->
                  <maxHistory>${log.maxHistory}</maxHistory>
                  <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                      <!-- 日志分割文件最大大小               -->
                      <maxFileSize>${log.maxFileSize}</maxFileSize>
                  </timeBasedFileNamingAndTriggeringPolicy>
              </rollingPolicy>
              <!--日志文档输出格式-->
              <encoder>
                  <pattern>${FILE_LOG_PATTERN}</pattern>
                  <charset>UTF-8</charset> <!-- 此处设置字符集，防止中文乱码 -->
              </encoder>
              <!-- 此日志文档只记录WARN级别的 -->
              <filter class="ch.qos.logback.classic.filter.LevelFilter">
                  <level>WARN</level>
                  <onMatch>ACCEPT</onMatch>
                  <onMismatch>DENY</onMismatch>
              </filter>
          </appender>
          <!--2.4 Error级别日志输出-->
          <appender name="ERROR_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
              <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
                  <!-- 日志归档名称  LOG_FILE_PATH = logging.file.name  APP_NAME=logstash -->
                  <fileNamePattern>${LOG_FILE_PATH}/error/${APP_NAME}-error-%d{yyyy-MM-dd}.%i.log</fileNamePattern>
                  <!--日志文档保留天数-->
                  <maxHistory>${log.maxHistory}</maxHistory>
                  <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                      <!-- 日志分割文件最大大小               -->
                      <maxFileSize>${log.maxFileSize}</maxFileSize>
                  </timeBasedFileNamingAndTriggeringPolicy>
              </rollingPolicy>
              <!--日志文档输出格式-->
              <encoder>
                  <pattern>${FILE_LOG_PATTERN}</pattern>
                  <charset>UTF-8</charset> <!-- 此处设置字符集，防止中文乱码 -->
              </encoder>
              <!-- 此日志文档只记录ERROR级别的 -->
              <filter class="ch.qos.logback.classic.filter.LevelFilter">
                  <level>ERROR</level>
                  <onMatch>ACCEPT</onMatch>
                  <onMismatch>DENY</onMismatch>
              </filter>
          </appender>

        ```
    
### 1.2 配置日志输出到 logstash
```xml
        <!--3.输出日志到logstash-->
          <appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
              <!--可以访问的logstash日志收集端口-->
              <destination>127.0.0.1:4560</destination>
              <encoder charset="UTF-8" class="net.logstash.logback.encoder.LogstashEncoder"/>
          </appender>
```
    
### 1.3 测试接口，生成日志
```java
  http://localhost:8080/hello
```
 ## 2.logstash
 ### 2.1 增加config配置
 - config文件夹下增加 logstash-springboot.cnf
 ```cnf
 input {
     tcp {
         mode => "server"
         host => "0.0.0.0"
         port => 4560
         codec => json_lines
     }
 }
 filter {
 
 }
 output {
     elasticsearch {
         hosts => ["127.0.0.1:9200"]
         index => "log-javaboy-dev-%{+yyyy.MM.dd}" 
     }
 }
 ```
 
 ### 2.2 在pipelines.yml中新增
 ```yaml
- pipeline.id: log_dev
  path.config: "C:/myWork/WorkSpace/spring-cloud-alibaba-fanyao/elasticsearch/es7.x/logstash-7.9.3/config/logstash-springboot.conf"
```
 ### 3.启动logstash
 ```
 cd bin 
 logstash -f ..\config\logstash-springboot.conf
 ```
 
 ### 4. druid
 - 访问　localhost:8080/druid
 - 账号密码: admin
 
