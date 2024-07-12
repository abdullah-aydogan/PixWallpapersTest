
# Pix Wallpapers Test Projesi

![pix_wallpapers_play_store](https://github.com/abdullah-aydogan/PixWallpapersTest/assets/117303457/ef43ed73-dead-4b3f-bf5b-bfe63c5996c1)

Bu test projesi, Google Play Store uygulama mağazasında yer alan **Pix Wallpapers** isimli duvar kağıdı uygulaması üzerinde test adımlarının koşulduğu bir projedir.

Projede, yazılım test otomasyonunda kullanılan BDD (Behavior Driven Development - Davranış Odaklı Geliştirme) araçlarından biri olan **Cucumber Framework** kullanıldı.
## Kullanılan Teknolojiler

**Programlama Dili :** Java (JDK 21)

**Framework :** Appium (9.2.3), Cucumber (7.18.0), TestNG (7.10.2)
## Test Senaryoları

**Anasayfa Test Senaryoları**

- Anasayfa kontrolü

- Listeden rastgele bir duvar kağıdını favoriler listesine ekleme

- Favoriler listesine herhangi bir duvar kağıdı eklemeden favoriler sekmesine geçiş yapma

- Uygulamada yer alan bir duvar kağıdını arama

- Uygulamada bulunmayan bir duvar kağıdını arama



**Detay Sayfası Test Senaryoları**

- Uygulamanın anasayfa açılma kontrolü

- Anasayfadaki listeden rastgele bir duvar kağıdına tıklama

- Koleksiyonlar sekmesine geçip rastgele koleksiyon seçimi yapma ve seçilen koleksiyondan rastgele duvar kağıdı seçimi yapma
## İlişkili Projeler

[Pix Wallpapers](https://github.com/pashapuma/Wallpapers_app)
## Bilgisayarınızda Çalıştırın

1 - Projeyi klonlayın.

```bash
  git clone https://github.com/abdullah-aydogan/PixWallpapersTest.git
```

2 - Proje dizinine gidin.

```bash
  cd PixWallpapersTest
```

3 - Projeyi **IntelliJ Idea** veya benzeri IDE üzerinden açın.

4 - Bütün test senaryolarını çalıştırmak için **parallel.xml** dosyasını çalıştırın.

5 - Test senaryolarını ayrı ayrı çalıştırmak için **.feature** uzantılı dosyalardan herhangi birini çalıştırın.
## pom.xml Dosya İçeriği

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>PixWallpapersTest</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

        <testNgVersion>7.9.0</testNgVersion>
        <cucumberVersion>7.15.0</cucumberVersion>
        <appiumVersion>9.1.0</appiumVersion>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>${testNgVersion}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>${testNgVersion}</version>
            <scope>compile</scope>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumberVersion}</version>
        </dependency>

        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>${cucumberVersion}</version>
        </dependency>

        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>${appiumVersion}</version>
        </dependency>
    </dependencies>

</project>
```


## homePage.feature Dosya İçeriği

```.feature
Feature: Home Page Test Senarios

  Background: Go to Home Page
    Then Check that the home page opens

  Scenario: Add a Random Image to Favorites
    Given Get count of images listed
    When Click the heart icon of a random image
    When Switch to the favorites tab
    Then Check that the favorites list appears

  Scenario: Switch to Favorites Tab Without Adding Images to Favorites
    When Switch to the favorites tab
    Then Check that the empty favorites list appears

  Scenario Outline: Search for Wallpaper
    When Click on the search icon
    When Type blue in the EditText field
    Then Check the search result "<Result>"
    Examples:
    |Result|
    |Sonuc bulundu|

  Scenario Outline: Search for Invalid Wallpaper
    When Click on the search icon
    When Type dsd in the EditText field
    Then Check the search empty result "<Result>"
    Examples:
    |Result|
    |Sonuc bulunamadi|
```

## detailPage.feature Dosya İçeriği

```.feature
Feature: Detail Page Test Senarios

  Background: Open Home Page
    Then Check that the home page

  Scenario: Click On a Random Image
    Given Get count images
    When Click on the random image from the list
    When Click on the information button
    When Check that the information screen appears
    When Click outside
    When Click on the apply button
    When Check that the apply screen appears
    When Click the cancel button
    When Click the close button
    Then Check return home page

  Scenario: Click Random Image from Collections
    Given Switch to collections tab
    When Get count collections
    When Click random collection
    When Get count collection images
    When Click random collection image
    When Save image
    When Apply image to phone home screen
    When Return to home page
    Then Check return app home page
```
