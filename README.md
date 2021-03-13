# Envoy Discovery

This project uses envoys xDS api to stream upstream endpoints for dynamic configuration

Every new grpc service will call the `register` rpc during startup and `deregister` during shutdown. 
The same is then streamed to envoy as endpoints to the cluster


## Demo

1. Start the grpc server. The grpc server will run at port `8080`

2. Now build run the envoy docker container

```
docker build -t eds-envoy .
docker run -p 8000:8000 -p 8081:8081 eds-envoy
```

3. For registering a service we will make use of evans for grpc request

```
evans --host 127.0.0.1 --port 8080 --proto Register.proto --path .
```
Make sure that you run the command from inside `proto` folder

In evans do the the following
```
service DiscoveryService
call register
```
Add values for ip and port. Make sure that ip is a valid one. Example -
```
ip ->  127.0.0.1
port -> 1234
```

Once the registeration is successful you should be able to curl within the container to see upstream clusters

```
curl localhost:8081/clusters
```

<img width="726" alt="Screenshot 2021-03-13 at 12 19 58 PM" src="https://user-images.githubusercontent.com/12782512/111022526-30937e80-83f9-11eb-87e6-00d869928d84.png">
<img width="726" alt="Screenshot 2021-03-13 at 12 22 49 PM" src="https://user-images.githubusercontent.com/12782512/111022525-2f625180-83f9-11eb-8935-20da7b5dabc1.png">

For deregistering 

```
service DiscoveryService
call deregister
```
Add values for ip and port. Make sure that ip is a valid one. Example -
```
ip ->  127.0.0.1
port -> 1234
```

Once the deregisteration is successful check the upstream cluster

<img width="411" alt="Screenshot 2021-03-13 at 12 23 21 PM" src="https://user-images.githubusercontent.com/12782512/111022523-2ec9bb00-83f9-11eb-983f-8562f6019f7d.png">
<img width="602" alt="Screenshot 2021-03-13 at 12 31 43 PM" src="https://user-images.githubusercontent.com/12782512/111022516-2a9d9d80-83f9-11eb-85c2-d766ea954368.png">


