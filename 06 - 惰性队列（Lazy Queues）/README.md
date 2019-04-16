# Lazy Queues Overview

自 `RabbitMQ 3.6.0` 以来，broker 新增 `Lazy Queues` 的概念：尽可能早地将其消息存储到磁盘的队列，并且只在消费者请求时将它们时才加载到内存中。

惰性队列的主要目标之一是能够支持非常长的队列（数百万条消息），由于各种原因，队列可能变得很长：
- 消费者离线/已经崩溃/正在维修
- 突发消息飙升，生产者正在超过消费者
- 消费者比平常慢

默认情况下，消息发送到 RabbitMQ 的时候，队列中的消息会尽可能地存储在内存中，这样可以更快的发送给消费者。需要注意的是，即时是持久化消息写入磁盘的同时也会写入内存中。

当 broker 认为需要释放内存时，内存中的消息将被分页到磁盘，将一批消息分页到磁盘需要花费时间并阻止队列进程，使其在分页时无法接收新消息。尽管 RabbitMQ 的最新版本改进了分页算法，但对于可能需要分页的队列中有数百万条消息的情况，仍然不理想。

# 使用手册

### 运行示例

1、启动 RabbitMQ

```
docker run -d --hostname rabbit --name rabbit -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=anoyi -e RABBITMQ_DEFAULT_PASS=Passw0rd rabbitmq:3.7-management
```

2、运行 `Application` (或者执行 `mvn spring-boot:run`)


### 测试

**1、测试惰性队列**

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct",
	"routingKey": "direct.queue.lazy",
	"content":" hello lazy queue! ",
	"count": 10000
}'
```
