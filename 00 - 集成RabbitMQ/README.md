## Spring Boot RabbitMQ 参数配置详解

**连接配置**

```
spring.rabbitmq.host=localhost                          # RabbitMQ 地址
spring.rabbitmq.port=5672                               # RabbitMQ 端口
spring.rabbitmq.username=guest                          # RabbitMQ 用户名
spring.rabbitmq.password=guest                          # RabbitMQ 密码

spring.rabbitmq.addresses=                              # 设置 RabbitMQ 集群，多个地址使用 "," 分隔，例如：192.168.0.100:5672,192.168.0.101:5672

spring.rabbitmq.virtual-host=                           # 设置 Virtual Host

spring.rabbitmq.ssl.algorithm=                          # SSL 算法，默认情况下，由 Rabbit 客户端配置
spring.rabbitmq.ssl.enabled=false                       # 是否启用 SSL 支持
spring.rabbitmq.ssl.key-store=                          # key 存储路径
spring.rabbitmq.ssl.key-store-password=                 # 用于访问 key 的密码
spring.rabbitmq.ssl.key-store-type=PKCS12               # Key 存储类型
spring.rabbitmq.ssl.trust-store=                        # Trust 存储路径
spring.rabbitmq.ssl.trust-store-password=               # 用于访问 Trust 的密码
spring.rabbitmq.ssl.trust-store-type=JKS                # Trust 存储类型
spring.rabbitmq.ssl.validate-server-certificate=true    # 是否启用服务端证书验证
spring.rabbitmq.ssl.verify-hostname=true                # 是否启用 hostname 验证
```

**Publisher 配置**

```
spring.rabbitmq.publisher-confirms=false                # 是否启用 publisher 确认
spring.rabbitmq.publisher-returns=false                 # 是否启用 publisher 返回

spring.rabbitmq.template.default-receive-queue=         # 没有没确定指定队列时的默认队列
spring.rabbitmq.template.exchange=                      # 发送消息默认的 exchange
spring.rabbitmq.template.mandatory=                     # 是否启用 mandatory 消息
spring.rabbitmq.template.receive-timeout=               # `receive()` 操作的超时时间
spring.rabbitmq.template.reply-timeout=                 # `sendAndReceive()` 操作的超时时间
spring.rabbitmq.template.retry.enabled=false            # 是否启用重试
spring.rabbitmq.template.retry.initial-interval=1000ms  # 两次重试间的时间间隔
spring.rabbitmq.template.retry.max-attempts=3           # 最大重试次数
spring.rabbitmq.template.retry.max-interval=10000ms     # 最长重试时间
spring.rabbitmq.template.retry.multiplier=1             # Multiplier to apply to the previous retry interval.
spring.rabbitmq.template.routing-key=                   # 发送消息默认的 routing key
```

**Consumer 设置**

```
spring.rabbitmq.listener.direct.acknowledge-mode=           # 确认模式：auto / manual / none
spring.rabbitmq.listener.direct.auto-startup=true           # 是否在应用启动时自动启动容器
spring.rabbitmq.listener.direct.consumers-per-queue=        # 每个队列的消费者数量
spring.rabbitmq.listener.direct.default-requeue-rejected=   # 默认情况下，拒收的消息是否重新排队
spring.rabbitmq.listener.direct.idle-event-interval=        # 空闲容器事件发布的频率
spring.rabbitmq.listener.direct.missing-queues-fatal=false  # 如果容器声明的队列在 broker 上不可用，是否失败
spring.rabbitmq.listener.direct.prefetch=                   # 预加载的消息数量
spring.rabbitmq.listener.direct.retry.enabled=false         # 是否启用发布重试
spring.rabbitmq.listener.direct.retry.initial-interval=1000ms   # 两次重试时间间隔
spring.rabbitmq.listener.direct.retry.max-attempts=3        # 最大重试次数
spring.rabbitmq.listener.direct.retry.max-interval=10000ms  # 最长重试时间
spring.rabbitmq.listener.direct.retry.multiplier=1          # 上次重试间隔的倍数
spring.rabbitmq.listener.direct.retry.stateless=true        # 重试是否有状态

spring.rabbitmq.listener.simple.acknowledge-mode=           # 确认模式：auto / manual / none
spring.rabbitmq.listener.simple.auto-startup=true           # 是否在应用启动时自动启动容器
spring.rabbitmq.listener.simple.concurrency=                # 监听器最小线程数
spring.rabbitmq.listener.simple.default-requeue-rejected=   # 默认情况下，拒收的消息是否重新排队
spring.rabbitmq.listener.simple.idle-event-interval=        # 空闲容器事件发布的频率
spring.rabbitmq.listener.simple.max-concurrency=            # 监听器最大线程数
spring.rabbitmq.listener.simple.missing-queues-fatal=true   # 如果容器声明的队列在 broker 上不可用，是否失败； 如果在运行时删除队列，容器是否停止
spring.rabbitmq.listener.simple.prefetch=                   # 预加载的消息数量
spring.rabbitmq.listener.simple.retry.enabled=false         # 是否启用发布重试
spring.rabbitmq.listener.simple.retry.initial-interval=1000ms   # 两次重试时间间隔
spring.rabbitmq.listener.simple.retry.max-attempts=3        # 最大重试次数
spring.rabbitmq.listener.simple.retry.max-interval=10000ms  # 最长重试时间
spring.rabbitmq.listener.simple.retry.multiplier=1          # 上次重试间隔的倍数
spring.rabbitmq.listener.simple.retry.stateless=true        # 重试是否有状态
spring.rabbitmq.listener.simple.transaction-size=           # 确认模式为 auto 时，在 acks 之间处理的消息数. 如果大于预加载的数量，则预加载的数量增加到此值
```

rabbitmq listener 类型有两种：`simple` 和 `direct`，二者有什么区别呢？ `DirectMessageListenerContainer` 注释如下：
```
 * The {@code SimpleMessageListenerContainer} is not so simple. Recent changes to the
 * rabbitmq java client has facilitated a much simpler listener container that invokes the
 * listener directly on the rabbit client consumer thread. There is no txSize property -
 * each message is acked (or nacked) individually.
```

**其他设置**

```
spring.rabbitmq.dynamic=true                                # 是否创建 AmqpAdmin bean

spring.rabbitmq.requested-heartbeat=                        # 请求心跳超时时间. 设置为 0 代表没有，如果未指定时间后缀，则默认使用秒
```