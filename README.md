# Selenium Tests 

## O projekcie

* Testy automatyczne platformy e-commerce http://live.demoguru99.com/ przy użyciu Selenium i Javy.


## Instalacja

1. Sklonuj repozytorium:
```
gh repo clone madiukpiotr/Selenium-Tests-Guru99-Magento
```

## Wymagania
1. Apache Maven (https://maven.apache.org/)
2. Java SE Development Kit 15 (https://www.oracle.com/java/technologies/javase-jdk15-downloads.html)

## Konfiguracja
1. Uruchom hub-a Selenium Grid: `selenium_server/starthub.bat`
2. Edytuj plik `selenium_server/startChromeNode.bat` i podaj pełną scieżkę do ChromeDrivera np.:
```
java -Dwebdriver.chrome.driver="C:\Users\Piotr\IdeaProjects\Guru99 Tests\src\main\resources\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig nodeconfig.json
```
3. Uruchom nod-a Selenium Grid: `selenium_server/startChromeNode.bat`
4. Edytuj plik `src/main/resources/config.properties` i podaj adres swojego hub-a. (Adres bedzie widzony po uruchomieniu pliku `starthub.bat` przy komunikacie ` INFO [Hub.start] - Clients should connect to http://192.168.56.1:4444/wd/hub`

## Uruchamianie
``` mvn test```
