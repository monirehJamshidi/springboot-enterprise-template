# springboot enterprise template

### Swagger UI چیست؟
Swagger UI یک ابزار Interactive Documentation برای APIهای REST است.

در واقع، Swagger UI یک صفحه وب گرافیکی ایجاد می‌کند که می‌توانی:

- تمام Endpointهای API را ببینی
- پارامترها و پاسخ‌ها را مطالعه کنی
- در خود صفحه API را تست کنی (مثلاً GET یا POST بگیری)

این ابزار بر اساس استاندارد OpenAPI Specification (OAS) کار می‌کند.

### چطور کار می‌کند؟
1. پروژه Spring Boot شما یک JSON به نام OpenAPI JSON تولید می‌کند:

```http request

    http://localhost:8081/v3/api-docs

```

این JSON شامل اطلاعات همه‌ی Controllerها، متدها، پارامترها و پاسخ‌هاست.

2. و Swagger UI این JSON را می‌خواند و به یک صفحه وب زیبا و قابل تعامل تبدیل می‌کند:

```http request

http://localhost:8081/swagger-ui/index.html


```

3. شما می‌توانید در همین UI:
   - مسیرها (Endpoints) را ببینید
   - مقادیر ورودی را وارد کنید
   - روی Try it out کلیک کنید تا مستقیماً API اجرا شود و پاسخ واقعی برگشت داده شود

### مزایای Swagger UI
1. مستندات زنده و قابل تعامل:

همیشه با کد پروژه هم‌زمان است، هیچ مستندات دستی قدیمی وجود ندارد.

2. تست سریع API:

بدون Postman یا ابزار خارجی می‌توان API را تست کرد.
3. سازگار با OpenAPI 3:

استاندارد باز، قابل استفاده در ابزارهای دیگر.
4. Enterprise-Friendly:

می‌توان با JWT، API Key، یا OAuth2 به آن امنیت داد.

### مثال ساده در پروژه من
فرض کن متد Controller شما:

```java

@GetMapping("/person/find/{id}")
public String find(@PathVariable Long id){
    return personService.findPersonById(id);
}


```

و  Swagger UI آن را نمایش می‌دهد:
| Endpoint          | Method | Parameter |
| ----------------- | ------ | --------- |
| /person/find/{id} | GET    | id (Long) |

و می‌توانی مقدار id=1 بدهی، روی Try it out بزنی، و پاسخ "Person 1" را ببینی.


### Swagger UI — توضیح مصاحبه‌ای (Senior Level)

"Swagger UI یک ابزار مستندسازی و تست تعاملی APIهای REST است که بر پایه استاندارد OpenAPI کار می‌کند. این ابزار به ما اجازه می‌دهد تا تمام Endpointها، پارامترها و پاسخ‌های API را به صورت گرافیکی و زنده مشاهده کنیم.

مزیت اصلی Swagger UI این است که مستندات همواره با کد پروژه همگام هستند و امکان تست فوری API بدون نیاز به ابزار خارجی مثل Postman فراهم می‌کند.

به طور مثال در پروژه‌های Spring Boot، با اضافه کردن dependency springdoc-openapi-starter-webmvc-ui، سیستم به صورت خودکار JSON استاندارد OpenAPI را در مسیر /v3/api-docs تولید می‌کند و Swagger UI آن را در صفحه وب نمایش می‌دهد.

این ابزار برای تیم‌های توسعه، QA و حتی Frontend اهمیت بالایی دارد، زیرا همه می‌توانند Endpointها را بررسی، تست و حتی نمونه پاسخ واقعی دریافت کنند. علاوه بر این، Swagger UI قابلیت ترکیب با امنیت مثل JWT یا OAuth2 را نیز دارد، بنابراین در پروژه‌های Enterprise و محیط‌های واقعی قابل استفاده است."

### چند نکته مصاحبه‌ای 

1. فرق Swagger و OpenAPI:
   - OpenAPI یک استاندارد است (Specification)
   - Swagger UI یک ابزار برای نمایش و تست همان استاندارد است
2. چرا در پروژه‌های Enterprise مهم است:
    - مستندات همیشه به‌روز هستند
    - تیم‌های مختلف بدون تماس مستقیم با Backend می‌توانند APIها را بررسی کنند
    - تست سریع و کاهش خطای دستی
3. تجربه شخصی شما:

“در پروژه Spring Boot شخصی، همه Controllerها و Responseها را با springdoc مستندسازی کردم و Swagger UI به ما اجازه داد قبل از اینکه Frontend بخواهد کار کند، API را تست کنیم و خطاها را سریع پیدا کنیم.”
