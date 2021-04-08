Proje lokalde herhangi bir IDE yardımıyla çalıştırılabilir. 8080 portunda çalışmaktadır.
Çalıştırılacak sunucu ya da bilgisayarda mongoDB (port:27017)'de "poc" adıyla database oluşturulmalı, ayrıca "menu", "product" ve "loc" collection'ları eklenmelidir.
Proje çalıştırıldığında, default olarak dökümandaki listede verilen menüler ve rasgele 1000 product oluşturulur ve mongoDB'ye kaydedilir. Proje başlaması tamamlandığında aşağıdaki endpointlere istekler atılabilir ve dökümandan istenen şu api'ler çalışır:

http://localhost:8080/menu/all-list  ---> "getMenuList" --> Menü isimlerinden oluşan String listesi döner.
(GET - istenen parametre yok)


http://localhost:8080/product/all-list  ---> "getProductList" --> Product istesi döner.
(GET - istenen parametre yok)


http://localhost:8080/menu/update-info  ---> "updateProductInfo" --> İstekte gönderilen telefon numara listesindeki product'ları bulur ve shortNumber değişkenlerini rasgele 4 haneli bir sayı ile değiştirir. 
(POST - "phoneList" değişken ismiyle telefon numaraları(String) listesinden oluşan request body gönderilmeli)


NOT: Ayrıca Swagger entegrasyonu yapılmıştır. Proje çalışıyor iken, "http://localhost:8080/swagger-ui.html#/" linki ile dokumantasyona ulaşabilirsiniz.
