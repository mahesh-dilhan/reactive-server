# Reactive Stream
Threads are very expensive...Scaling is matters... 


# Reactive examples
One word .i.e. Non-Blocking

To verify we use `BlockHond.install`

Examples in this repo:

 * Router Functions
 * WebFlux examples with Mongo DB
 * RSocket example with Mongo DB

## Setup & build

OpenJDK 13 (let jenv to manage multiple JDKs )

install `httpie`
```
https://httpie.org/
``` 

Download `RSocket` Client library
```
wget -O rsc.jar https://github.com/making/rsc/releases/download/0.4.2/rsc-0.4.2.jar
```

install & Run `mongo` service (please refer official page)

Run `mvn package` to build a single executable JAR file.
 
Server starts : `Netty` (8080) and `RScoket` (7001) 

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.1.RELEASE)

2020-06-28 05:18:50.797  INFO 40014 --- [           main] c.r.reactserver.ReactServerApplication   : Starting ReactServerApplication on Maheshs-MacBook-Pro.local with PID 40014 (/Users/mahesh/play/reactive/react-server/target/classes started by mahesh in /Users/mahesh/play/reactive/react-server)
2020-06-28 05:18:50.800  INFO 40014 --- [           main] c.r.reactserver.ReactServerApplication   : No active profile set, falling back to default profiles: default
2020-06-28 05:18:51.190  INFO 40014 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Reactive MongoDB repositories in DEFAULT mode.
2020-06-28 05:18:51.256  INFO 40014 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 63ms. Found 1 Reactive MongoDB repository interfaces.
2020-06-28 05:18:51.701  INFO 40014 --- [           main] org.mongodb.driver.cluster               : Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms'}
2020-06-28 05:18:51.851  INFO 40014 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:90}] to localhost:27017
2020-06-28 05:18:51.856  INFO 40014 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=8, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=3625434}
2020-06-28 05:18:52.311  INFO 40014 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port(s): 8080
2020-06-28 05:18:52.316  INFO 40014 --- [           main] o.s.b.rsocket.netty.NettyRSocketServer   : Netty RSocket started on port(s): 7001
2020-06-28 05:18:52.325  INFO 40014 --- [           main] c.r.reactserver.ReactServerApplication   : Started ReactServerApplication in 6.852 seconds (JVM running for 8.362)

```
 
### Data insert Output 
```
2020-06-28 05:18:52.515  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae60c, name=Xiaoyuan)
2020-06-28 05:18:52.515  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae60d, name=Lloyd)
2020-06-28 05:18:52.516  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae60e, name=Bing Jie)
2020-06-28 05:18:52.516  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae60f, name=Swapnik)
2020-06-28 05:18:52.516  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae610, name=Reni)
2020-06-28 05:18:52.516  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae611, name=Vlad)
2020-06-28 05:18:52.516  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae612, name=Murali)
2020-06-28 05:18:52.517  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae614, name=Kishore)
2020-06-28 05:18:52.517  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae615, name=SriDevi)
2020-06-28 05:18:52.517  INFO 40014 --- [ntLoopGroup-3-6] com.rserver.reactserver.DataGenerator    : Person(id=5ef7b7bc7e39d12247dae613, name=Naren)
```

Explore same in mongodb

```
> db.person.find()
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae60c"), "name" : "Xiaoyuan", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae60d"), "name" : "Lloyd", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae60e"), "name" : "Bing Jie", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae60f"), "name" : "Swapnik", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae610"), "name" : "Reni", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae611"), "name" : "Vlad", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae612"), "name" : "Murali", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae614"), "name" : "Kishore", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae615"), "name" : "SriDevi", "_class" : "com.rserver.reactserver.Person" }
{ "_id" : ObjectId("5ef7b7bc7e39d12247dae613"), "name" : "Naren", "_class" : "com.rserver.reactserver.Person" }
> 

```
### Flux Endpoint
Lets invoke `/author` endpoint

```
Maheshs-MBP:rsocket-starter mahesh$ http :8080/author
HTTP/1.1 200 OK
Content-Length: 6
Content-Type: text/plain;charset=UTF-8

Mahesh

```
Lets invoke `/colleagues` endpoint

```
Maheshs-MBP:rsocket-starter mahesh$ http :8080/colleagues
HTTP/1.1 200 OK
Content-Type: application/json
transfer-encoding: chunked

[
    {
        "id": "5ef7b7bc7e39d12247dae60c",
        "name": "Xiaoyuan"
    },
    {
        "id": "5ef7b7bc7e39d12247dae60d",
        "name": "Lloyd"
    },
    {
        "id": "5ef7b7bc7e39d12247dae60e",
        "name": "Bing Jie"
    },
    {
        "id": "5ef7b7bc7e39d12247dae60f",
        "name": "Swapnik"
    },
    {
        "id": "5ef7b7bc7e39d12247dae610",
        "name": "Reni"
    },
    {
        "id": "5ef7b7bc7e39d12247dae611",
        "name": "Vlad"
    },
    {
        "id": "5ef7b7bc7e39d12247dae612",
        "name": "Murali"
    },
    {
        "id": "5ef7b7bc7e39d12247dae614",
        "name": "Kishore"
    },
    {
        "id": "5ef7b7bc7e39d12247dae615",
        "name": "SriDevi"
    },
    {
        "id": "5ef7b7bc7e39d12247dae613",
        "name": "Naren"
    }
]

```

Lets invoke `/colleague/<name>` endpoint
```
Maheshs-MBP:react-server mahesh$ http :8080/colleague/Suresh
HTTP/1.1 200 OK
Content-Length: 49
Content-Type: application/json

{
    "id": "5ef8aca638737c328db613f3",
    "name": "Suresh"
}
```

## Flux Endpoint POST
There different ways to consume POST. I would suggest to stick with Spring documentation. 
use ServerRequest

Lets invoke `/colleage` with data `-data '{"name":"Suresh"}'`
 
```
Maheshs-MBP:rsocket-greeting-client mahesh$ curl -H "content-type: application/json" -d '{"name":"Suresh"}' http://localhost:8080/colleague
{"id":"5ef8a6deef07386a8a1a0751","name":"Suresh"}
```

## Run RSocket Client
comment `BlockHound.install` before running the client

### GET

```bash
Maheshs-MacBook-Pro:react-server mahesh$ java -jar rsc.jar --stream --debug tcp://localhost:7001 --route rsock-colleagues
2020-06-28 05:48:45.049 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : sending -> 
Frame => Stream ID: 1 Type: REQUEST_STREAM Flags: 0b100000000 Length: 29
Metadata:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 0f 72 73 6f 63 6b 2d 63 6f 6c 6c 65 67 75 65 73 |.rsock-colleagues|
+--------+-------------------------------------------------+----------------+
Data:

2020-06-28 05:48:45.138 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 57
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 32 22 |5808236be7be4f2"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 58 69 61 6f 79 75 61 |,"name":"Xiaoyua|
|00000030| 6e 22 7d                                        |n"}             |
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4f2","name":"Xiaoyuan"}
2020-06-28 05:48:45.141 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 54
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 33 22 |5808236be7be4f3"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 4c 6c 6f 79 64 22 7d |,"name":"Lloyd"}|
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4f3","name":"Lloyd"}
2020-06-28 05:48:45.142 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 57
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 34 22 |5808236be7be4f4"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 42 69 6e 67 20 4a 69 |,"name":"Bing Ji|
|00000030| 65 22 7d                                        |e"}             |
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4f4","name":"Bing Jie"}
2020-06-28 05:48:45.142 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 56
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 35 22 |5808236be7be4f5"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 53 77 61 70 6e 69 6b |,"name":"Swapnik|
|00000030| 22 7d                                           |"}              |
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4f5","name":"Swapnik"}
2020-06-28 05:48:45.142 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 54
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 39 22 |5808236be7be4f9"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 4e 61 72 65 6e 22 7d |,"name":"Naren"}|
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4f9","name":"Naren"}
2020-06-28 05:48:45.143 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 55
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 38 22 |5808236be7be4f8"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 4d 75 72 61 6c 69 22 |,"name":"Murali"|
|00000030| 7d                                              |}               |
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4f8","name":"Murali"}
2020-06-28 05:48:45.143 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 53
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 36 22 |5808236be7be4f6"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 52 65 6e 69 22 7d    |,"name":"Reni"} |
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4f6","name":"Reni"}
2020-06-28 05:48:45.143 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 56
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 61 22 |5808236be7be4fa"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 4b 69 73 68 6f 72 65 |,"name":"Kishore|
|00000030| 22 7d                                           |"}              |
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4fa","name":"Kishore"}
2020-06-28 05:48:45.143 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 53
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 37 22 |5808236be7be4f7"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 56 6c 61 64 22 7d    |,"name":"Vlad"} |
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4f7","name":"Vlad"}
2020-06-28 05:48:45.144 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 56
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 37 62 65 62 33 64 |{"id":"5ef7beb3d|
|00000010| 35 38 30 38 32 33 36 62 65 37 62 65 34 66 62 22 |5808236be7be4fb"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 53 72 69 44 65 76 69 |,"name":"SriDevi|
|00000030| 22 7d                                           |"}              |
+--------+-------------------------------------------------+----------------+
{"id":"5ef7beb3d5808236be7be4fb","name":"SriDevi"}
2020-06-28 05:48:45.144 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: COMPLETE Flags: 0b1000000 Length: 6
Data:

```

## Flux Endpoint POST

Lets invoke `/colleage` with data `-data '{"name":"Suresh"}'`
 
```
Maheshs-MBP:rsocket-greeting-client mahesh$ curl -H "content-type: application/json" -d '{"name":"Suresh"}' http://localhost:8080/colleague
{"id":"5ef8a6deef07386a8a1a0751","name":"Suresh"}
```

## Query Results 
```
Maheshs-MBP:react-server mahesh$ java -jar rsc.jar --debug tcp://localhost:7001 --route rsock-colleagues --stream
2020-06-28 22:24:16.597 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : sending -> 
Frame => Stream ID: 1 Type: REQUEST_STREAM Flags: 0b100000000 Length: 29
Metadata:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 0f 72 73 6f 63 6b 2d 63 6f 6c 6c 65 67 75 65 73 |.rsock-colleagues|
+--------+-------------------------------------------------+----------------+
Data:

2020-06-28 22:24:16.615 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 57
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 37 22 |f07386a8a1a0747"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 58 69 61 6f 79 75 61 |,"name":"Xiaoyua|
|00000030| 6e 22 7d                                        |n"}             |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a0747","name":"Xiaoyuan"}
2020-06-28 22:24:16.617 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 54
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 38 22 |f07386a8a1a0748"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 4c 6c 6f 79 64 22 7d |,"name":"Lloyd"}|
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a0748","name":"Lloyd"}
2020-06-28 22:24:16.617 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 57
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 39 22 |f07386a8a1a0749"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 42 69 6e 67 20 4a 69 |,"name":"Bing Ji|
|00000030| 65 22 7d                                        |e"}             |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a0749","name":"Bing Jie"}
2020-06-28 22:24:16.617 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 56
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 61 22 |f07386a8a1a074a"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 53 77 61 70 6e 69 6b |,"name":"Swapnik|
|00000030| 22 7d                                           |"}              |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a074a","name":"Swapnik"}
2020-06-28 22:24:16.617 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 55
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 64 22 |f07386a8a1a074d"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 4d 75 72 61 6c 69 22 |,"name":"Murali"|
|00000030| 7d                                              |}               |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a074d","name":"Murali"}
2020-06-28 22:24:16.618 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 53
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 62 22 |f07386a8a1a074b"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 52 65 6e 69 22 7d    |,"name":"Reni"} |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a074b","name":"Reni"}
2020-06-28 22:24:16.618 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 53
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 63 22 |f07386a8a1a074c"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 56 6c 61 64 22 7d    |,"name":"Vlad"} |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a074c","name":"Vlad"}
2020-06-28 22:24:16.618 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 54
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 65 22 |f07386a8a1a074e"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 4e 61 72 65 6e 22 7d |,"name":"Naren"}|
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a074e","name":"Naren"}
2020-06-28 22:24:16.618 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 56
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 34 66 22 |f07386a8a1a074f"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 4b 69 73 68 6f 72 65 |,"name":"Kishore|
|00000030| 22 7d                                           |"}              |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a074f","name":"Kishore"}
2020-06-28 22:24:16.618 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 56
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 39 35 65 |{"id":"5ef8a695e|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 35 30 22 |f07386a8a1a0750"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 53 72 69 44 65 76 69 |,"name":"SriDevi|
|00000030| 22 7d                                           |"}              |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a695ef07386a8a1a0750","name":"SriDevi"}
2020-06-28 22:24:16.619 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT Flags: 0b100000 Length: 55
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 36 64 65 65 |{"id":"5ef8a6dee|
|00000010| 66 30 37 33 38 36 61 38 61 31 61 30 37 35 31 22 |f07386a8a1a0751"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 53 75 72 65 73 68 22 |,"name":"Suresh"|
|00000030| 7d                                              |}               |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8a6deef07386a8a1a0751","name":"Suresh"}
2020-06-28 22:24:16.619 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: COMPLETE Flags: 0b1000000 Length: 6
Data:

```

### GET 
Query for Single Object
```
Maheshs-MBP:react-server mahesh$ java -jar rsc.jar --debug tcp://localhost:7001 --route rsock-colleague -d Suresh --request
2020-06-28 22:49:37.046 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : sending -> 
Frame => Stream ID: 1 Type: REQUEST_RESPONSE Flags: 0b100000000 Length: 31
Metadata:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 0f 72 73 6f 63 6b 2d 63 6f 6c 6c 65 61 67 75 65 |.rsock-colleague|
+--------+-------------------------------------------------+----------------+
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 53 75 72 65 73 68                               |Suresh          |
+--------+-------------------------------------------------+----------------+
2020-06-28 22:49:37.069 DEBUG --- [actor-tcp-nio-1] i.r.FrameLogger : receiving -> 
Frame => Stream ID: 1 Type: NEXT_COMPLETE Flags: 0b1100000 Length: 55
Data:
         +-------------------------------------------------+
         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |
+--------+-------------------------------------------------+----------------+
|00000000| 7b 22 69 64 22 3a 22 35 65 66 38 61 63 61 36 33 |{"id":"5ef8aca63|
|00000010| 38 37 33 37 63 33 32 38 64 62 36 31 33 66 33 22 |8737c328db613f3"|
|00000020| 2c 22 6e 61 6d 65 22 3a 22 53 75 72 65 73 68 22 |,"name":"Suresh"|
|00000030| 7d                                              |}               |
+--------+-------------------------------------------------+----------------+
{"id":"5ef8aca638737c328db613f3","name":"Suresh"}

```


### TODO
Error Handling
Event Handling