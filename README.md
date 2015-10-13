======================================================================================<br>
##*   IF4130 - PENGEMBANGAN APLIKASI TERDISTRIBUSI   *<br>
###*             13512052 - 13513601                 *<br>
###*                Try Ajitiono                     *<br>
###*        Akhmad Fakhoni Listiyan Dede             *<br>
======================================================================================<br>

###REQUIREMENT:<br>
    - commons-cli-1.1.jar<br>
    - json-simple-1.1.1.jar<br>
    - rabbitmq-client-tests.jar<br>
	- commons-io-1.2.jar<br>
	- junit.jar<br>
	- hamcrest-core.jar<br>
	- rabbitmq-client.jar<br>
	- port 15672 dan 5672 terbuka
	- JDK 1.8
    
###How to deploy<br>
    - Buka folder bin<br>
    - Jalankan client menggunakan perintah "java -jar irc.jar"<br>
    - Ulangi langkah sebelumnya sesuai keinginan<br>
    - Gunakan /NICK <nama> untuk mengganti nama, apabila hanya /NICK, maka aplikasi akan
      meng-assign nick random<br>
    - Gunakan /JOIN <channel> untuk masuk ke dalam channel<br>
    - Gunakan /LEAVE <channel> untuk keluar dari dalam channel<br>
    - Gunakan /EXIT untuk keluar dari aplikasi<br>
    - Gunakan @<nama channel> <pesan> untuk mengirim pesan ke semua orang di dalam channel tersebut<br>

###screenshoot: <br>

**Initialize NICK**
![Initialize NICK](screenshoot/1 - init.png?raw=true "Initialize NICK")

**Join Channel**
![Join Channel](screenshoot/2 - join channel.png?raw=true "Join Channel")

**Dede send message to if channel**
![Sending message](screenshoot/3 - dede send if.png?raw=true "Sending message")

**dede join sti channel dan send to sti**
![Sending message](screenshoot/4 - dede join sti dan send sti.png?raw=true "Sending message")

**Ardee leave sti dan dede send to sti**
![Sending message](screenshoot/5 - ardee leave sti dan dede send sti.png?raw=true "Sending message")

**Exiting**
![Exit](screenshoot/6 - exit.png?raw=true "Exit")
