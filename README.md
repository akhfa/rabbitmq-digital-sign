=====================================================<br>
##*   IF4130 - PENGEMBANGAN APLIKASI TERDISTRIBUSI   *<br>
###*             13512052 - 13513601                 *<br>
###*                Try Ajitiono                     *<br>
###*        Akhmad Fakhoni Listiyan Dede             *<br>
=====================================================<br>

###REQUIREMENT:<br>
    - commons-cli-1.1.jar<br>
    - json-simple-1.1.1.jar<br>
    - rabbitmq-client-tests.jar<br>
    - commons-io-1.2.jar<br>
    - hamcrest-core.jar<br>
    - rabbitmq-client.jar<br>
    - port 15672 dan 5672 terbuka
    - JDK 1.8
    - Platform Linux yang bisa menjalankan cURL
    - Port 5672 dan 15672 yang terbuka untuk komunikasi ke server rabbitmq
    
###How to deploy<br>
    - Buka folder bin<br>
    - Jalankan client menggunakan perintah "java -jar client.jar"<br>
    - Ulangi langkah sebelumnya sesuai keinginan<br>
    - Gunakan /NICK <nama> untuk mengganti nama, apabila hanya /NICK, maka aplikasi akan
      meng-assign nick random<br>
    - Gunakan /JOIN <channel> untuk masuk ke dalam channel<br>
    - Gunakan /LEAVE <channel> untuk keluar dari dalam channel<br>
    - Gunakan /EXIT untuk keluar dari aplikasi<br>
    - Gunakan @<nama channel> <pesan> untuk mengirim pesan ke semua orang di dalam channel tersebut<br>

###screenshoot: <br>

**Initialize NICK**
![Initialize NICK](screenshoot/1 - register and join.png?raw=true "Initialize NICK and JOIN")

**Send message to if dan if2, hanya akan diterima oleh user yang join ke channel yang bersangkutan**
![Join Channel](screenshoot/2 - register and join and send message.png?raw=true "Join Channel")

**NICK error ketika sudah mendapat nick, namun ingin daftar nick lagi**
![Sending message](screenshoot/3 - NICK error.png?raw=true "Request NICK error")

**aji2 leave channel if dan zacky send message to if, dan aji2 tidak menerima message tersebut**
![Sending message](screenshoot/4 - aji2 leave if and zacky send message to if.png?raw=true "Leave Channel")

**Exit**
![Sending message](screenshoot/5 - exit all.png?raw=true "Exit")
