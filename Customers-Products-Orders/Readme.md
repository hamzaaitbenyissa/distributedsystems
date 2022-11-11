# Micro Services Architecture-Consul-Config- Gateway-Feign-Resilience4J

orders - customers - products  Microservices using Spring boot and consul.

## Table of contents

- [Project Architecture](#project-architecture)
- [Consul Disovery Service](#consul-disovery-service)
- [Order Service](#order-service)

## Project Architecture

In this project we have the following services:

    1. Customer Service :
        My job is not complicated ,I will handle CRUD operations for our customers ✔

    2. Product service :
        I will be here for handling CRUD operations for invoices ✔

    2. Order service :
        I will be here for handling CRUD operations for orders ✔        

    3. OpenFeign :
        I will get customer and product details if any order ask me about them 🤷‍♂️

    4. Consul Disovery Service :
        I will holds the information about all other services 😎

    5. Gateway :
        Your clients will send me their requests, then I will send it to the wanted service 😜

<br>
<img src="./main/demo/arch.png" width="1000px">
<br>


## Consul Disovery Service
<br>
First, let's run our services :

<br>
<img src="./main/demo/1.png" width="1000px">
<br>

<br>
then let's check them in the consul interface :

<br>
<img src="./main/demo/consul.png" width="1000px">
<br>



## Order Service

<br>
<img src="./main/demo/3.png" width="1000px">
<br>


<br>
<img src="./main/demo/4.png" width="1000px">
<br>

## 🔗 About me :

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/hamzaaitbenyissa/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/h_aitbenyissa)
[![Web](https://img.shields.io/badge/web-1DA1F2?style=for-the-badge&logo=web)](https://benyissa.com)
