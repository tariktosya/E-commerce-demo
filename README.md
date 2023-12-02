# E-commerce-demo

- Database olarak PostgreSql kullanıldı. Docker üzerinde ayağa kaldırıldı. Yml dosyasını Docker üzerinde ayağa kaldırmak için -> "docker compose up -d".
- Projeyi ayağa kaldırmak için -> "./gradlew clean build" ve ardından Debug edebilirsiniz.
- Database bağlantısında problem yok ise ilgili tablolar oluşacaktır.
- Son olarak "http://localhost:8080/swagger-ui/index.html" ile API'lar hizmetinize hazır.

# Genel Yapı
- Standart CRUD işlemleri tüm servislerde yer almaktadır. Ayrıca çeşitli istenirlere özel API'ler de yer alıyor.
- Request ve Response işlemleri için DTO'lar alınıyor ve dönülüyor. Entity dönülmemiştir.
- Bu denli çok DTO olacağı için Spring Boot/Mapping Struct yapısı tercih edildi.
- Mapping Struct gerek DTO to Entity, gerek Entity to DTO dönüşümlerinden kaynaklı oluşacak karmaşık ve uzun kod yapısını önledi. 
- Hataların yönetimi için "ErrorCode" yapısı kullanıldı.
- Tüm Entity'lerde Soft Delete yapısı kullanıldı.
- Ddl-auto -> update ile Entity Classlar üzerinden database'e müdahale edilebilir.
- Bir çok Entity'de ortak alanlar olacağı için bir BaseEntity kullanıldı.
- Tablolar arası bağlantı Spring annotasyonları ile gerçekleştirildi.
- Her Method yalnızca bir düzlemde işlem yapmaktadır.
- İki adet sorgu türü kullanıldı. JPA Query ve JPQL Query(@Query annotation).
