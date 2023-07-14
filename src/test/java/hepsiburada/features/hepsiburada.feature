@hepsiburada
Feature: Hepsiburada Uygulaması

  @favoriyeekle
  Scenario: Hepsiburada uygulaması Favorilere ekleme özelliği test edilir
    Given Kullanıcı öncesinde uygulamaya login olmuştur
    When Kullanıcı "SAMSUNG_GALAXY_FAN" cihazında "HEPSIBURADA" uygulamasina girer
    And Anasayfada "nutella" aratır
    And Çıkan sonuclardan "Hemen Al Sonra Öde" metinli ürünü favorilere ekler
    And Listelerim sekmesinden favoriler butonuna tıklar
    Then Favorilere eklendiğini kontrol eder


    @swipeyap
    Scenario: Hepsiburada uygulaması Sepete ekleme özelliği test edilir
      Given Kullanıcı öncesinde uygulamaya login olmuştur
      When Kullanıcı "SAMSUNG_GALAXY_FAN" cihazında "HEPSIBURADA" uygulamasina girer
      And Anasayfada "elektronik" sekmesine tıklanır
      And Elektronik sayfasından bir ürün grubuna tıklar
      And Açılan sayfada bir ürüne tıklar
      And Ürün görseline tıklar
      And Görsel üzerinde sağa doğru swipe yapılarak diğer resme geçilir
      And Görsel kapatılır