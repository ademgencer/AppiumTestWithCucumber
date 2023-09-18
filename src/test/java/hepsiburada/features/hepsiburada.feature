@HepsiBurada
Feature: Hepsiburada Uygulaması

  @FavoriyeEkle
  Scenario: Hepsiburada uygulaması Favorilere ekleme özelliği test edilir
    Given Kullanıcı önceden uygulamaya SignIn olmuştur
    When Kullanıcı "SAMSUNG_GALAXY_FAN" cihazında "HEPSIBURADA" uygulamasina girer
    And Anasayfada "NUTELLA" aratır
    * Arama sonucu "NUTELLA" gelen ilk ürüne tıklar
    * Ürünü favorilere ekle butonuna tıklar
    * Çıkan login ekranından login olur
    * Ekrandaki uyarı yazısında "TAMAM" butonuna tıklanır
    And Çıkış yapılır


  @SwipeYapSepeteEkle
  Scenario: Hepsiburada uygulaması Sepete ekleme özelliği test edilir
    Given Kullanıcı önceden uygulamaya SignIn olmuştur
    When Kullanıcı "SAMSUNG_GALAXY_FAN" cihazında "HEPSIBURADA" uygulamasina girer
    And Anasayfada "Samsung Galaxy Z Flip5 512 GB" ürününü aratır
    * Açılan sayfada "Samsung Galaxy Z Flip5 512 GB" adında bir ürüne tıklar
    * Görsel üzerinde sağa doğru swipe yapılarak diğer resimlere geçilir
    When Kullanıcı "Sepete ekle" ekle butonuna tıklar
    And "Sepete git" butonuna tıklar
    Then Ürünün sepete eklendiği kontrol edilir
    And Çıkış yapılır