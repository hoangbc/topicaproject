﻿Bài 1: Chạy ở https://localhost:8080, do app trên facebook chưa được public vì thế chỉ có thể đăng nhập với tài khoản tạo app.

Bài 2: Chạy project trên với miền là localhost với các cổng: 80, 1234 và miền ex2.web2 với cổng là 88.

Bài 3:  Chạy project trên với miền là localhost với các cổng: 80, 1234. Riêng project sử dụng java chạy trên cổng 8080.

Để chạy bài 2 và bài 3, ta cần config xampp theo các bước sau:

B1. Truy cập vào C:\xampp\apache\conf\extra\httpd-vhosts.conf
Thêm các virtual host sau:

<VirtualHost *:88>
    ServerAdmin webmaster@ex2.web2
    DocumentRoot "C:\xampp\htdocs\ex2app2"
    ServerName ex2.web2
</VirtualHost>

<VirtualHost *:1234>
    ServerAdmin webmaster@localhost
    DocumentRoot "C:\xampp\htdocs"
    ServerName localhost
</VirtualHost>

B2. Vào C:\Windows\System32\drivers\etc\hosts bằng quyền admin
Thêm dòng 127.0.0.1 ex2.web2 vào cuối file và save lại.


B3. Vào C:\xampp\apache\conf\httpd.conf
Tìm kiếm 'Listen 80' và thêm vào dưới các dòng sau:
Listen 88
Listen 1234

Tìm kiếm 'ServerName localhost:80' và thêm vào dưới các dòng sau:
ServerName ex2.web2:88
ServerName localhost:1234

Sau đó save file lại.


