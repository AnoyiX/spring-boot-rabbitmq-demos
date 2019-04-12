# 使用手册

### 运行示例

1、启动 RabbitMQ

```
docker run -d --hostname rabbit --name rabbit -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=anoyi -e RABBITMQ_DEFAULT_PASS=Passw0rd rabbitmq:3.7-management
```

2、运行 `Application` (或者执行 `mvn spring-boot:run`)


### 测试

**1、测试 fanout exchange**

![](https://upload-images.jianshu.io/upload_images/3424642-fa92d2b554bf1b91.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-fanout",
	"routingKey": "default",
	"content":" hello fanout!",
	"count": 1
}'
```

**2、测试 direct exchange**

![](https://upload-images.jianshu.io/upload_images/3424642-131576cc25f29c89.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct",
	"routingKey": "queue.direct.key1",
	"content":" hello direct! ",
	"count": 1
}'
```

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-direct",
	"routingKey": "queue.direct.key2",
	"content":" hello direct! ",
	"count": 1
}'
```

**3、测试 topic exchange**

![](https://upload-images.jianshu.io/upload_images/3424642-f1313089dae51505.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-topic",
	"routingKey": "queue.topic.key1",
	"content":" hello topic! ",
	"count": 1
}'
```

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-topic",
	"routingKey": "test.topic.key2",
	"content":" hello topic! ",
	"count": 1
}'
```

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-topic",
	"routingKey": "queue.hello",
	"content":" hello topic! ",
	"count": 1
}'
```


**4、测试 headers exchange**

![](https://upload-images.jianshu.io/upload_images/3424642-6e6efb71c958d18f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-headers",
	"content":" hello headers! ",
	"count": 1,
	"headers":{
		"one":"value"
	}
}'
```

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-headers",
	"content":" hello headers! ",
	"count": 1,
	"headers":{
		"all1":"value",
        "all2":"value"
	}
}'
```

```
curl -X POST \
  http://127.0.0.1:8080/send \
  -H 'Content-Type: application/json' \
  -d '{
	"exchange":"exchange-headers",
	"content":" hello headers! ",
	"count": 1,
	"headers":{
		"any2":"value",
	}
}'
```