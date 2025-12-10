# springboot enterprise template

### در حقیقت Spring Boot چیست؟ (تعریف ساده و کامل برای مصاحبه + یادگیری)
Spring Boot یک فریم‌ورک روی Spring است که ساختن و راه‌اندازی پروژه‌های Spring را فوق‌العاده ساده و سریع می‌کند.

### ⭐ تعریف خیلی ساده
#### Spring Boot = Spring + تنظیمات خودکار + سرور داخلی + آماده برای تولید

یعنی شما بدون اینکه:
- تنظیمات پیچیده XML بنویسی
- کانفیگ‌های زیاد انجام بدی
- Tomcat جدا نصب کنی
- ساختار پروژه را از صفر بچینی


### 🎯 هدف Spring Boot
Spring Boot آمده که:
- پروسه‌ی ساخت پروژه‌ی Spring را خیلی سریع کند
- کانفیگ‌های تکراری و سخت را حذف کند
- یک سرور داخلی (Tomcat, Jetty) فراهم کند
  می‌تونی خیلی سریع یک پروژه Spring راه‌اندازی کنی.قابلیت‌های آماده مثل Security، JPA، Scheduling و… را با Autoconfiguration فعال کند

به همین دلیل در شرکت‌ها معمولاً 99٪ پروژه‌های جدید با Spring Boot ساخته می‌شوند.

### 🔧 ویژگی‌های اصلی Spring Boot
#### 1) Auto-Configuration (تنظیمات خودکار)
Spring Boot به صورت خودکار بسیاری از کانفیگ‌ها را حدس می‌زند.

مثلاً اگر spring-boot-starter-web را اضافه کنید، خودش:
- Tomcat را بالا می‌آورد
- DispatcherServlet را پیکربندی می‌کند
- JSON Converter اضافه می‌کند

بدون اینکه شما چیزی بنویسید.

#### 2) Starter Dependencies (استارترها)
Spring Boot مجموعه‌هایی آماده از dependencyها می‌دهد.
مثلاً
- spring-boot-starter-web → برای ساخت REST API
- spring-boot-starter-data-jpa → برای کار با دیتابیس
- spring-boot-starter-security → امنیت
- spring-boot-starter-test → تست

این باعث می‌شود مشکل سازگاری نسخه‌ها نداشته باشید.

#### 3) Embedded Server (سرور داخلی)
Spring Boot یک Tomcat داخلی دارد.
یعنی یک فایل jar اجرا می‌کنی و پروژه بالا می‌آید:

    java -jar myapp.jar

نیازی به نصب Tomcat جداگانه نیست.

#### 4) Spring Boot Actuator
برای مانیتورینگ، metrics، health check و…
بسیار عالی برای محیط production.
#### 5) Spring Boot CLI (اختیاری)
امکان اجرای اسکریپت‌های Groovy برای توسعه سریع.


### 🔥 یک مثال ساده از پروژه Spring Boot

```java

    @SpringBootApplication
    public class DemoApplication {
        public static void main(String[] args) {
            SpringApplication.run(DemoApplication.class, args);
        }
    }

    
```

و یک RestController ساده:

```java

    @RestController
    public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Monire!";
    }
    }

```

و تمام! پروژه آماده است.


### 🎤 پاسخ مصاحبه‌ای (خیلی استاندارد)
اگر در مصاحبه پرسیدند Spring Boot چیست؟
#### پاسخ ۱ (کوتاه و حرفه‌ای):
Spring Boot یک فریم‌ورک مبتنی بر Spring است که با استفاده از Auto-Configuration، سرور داخلی و استارترها، توسعه و استقرار برنامه‌های Spring را بسیار ساده و سریع می‌کند.

#### پاسخ ۲ (کامل‌تر):
Spring Boot فرایند راه‌اندازی و پیکربندی Spring را اتوماتیک می‌کند، dependencyها را از طریق استارترها مدیریت می‌کند، یک سرور Tomcat داخلی فراهم می‌کند و امکانات اضافی مثل Actuator ارائه می‌دهد. هدف اصلی آن افزایش سرعت توسعه، کاهش کانفیگ و آماده‌سازی سریع برای محیط production است.


در ادامه فرق بین Spring و Spring Boot را کاملاً واضح، کوتاه، و مناسب مصاحبه توضیح می‌دهم — دقیقاً همان چیزی که برای Senior Java Developer در اتریش لازم داری 👇

### ⭐ تفاوت Spring و Spring Boot
#### 🔹 1. هدف اصلی
#### Spring Framework
یک فریم‌ورک بزرگ و جامع برای توسعه جاوا است که امکانات زیادی می‌دهد (DI, MVC, AOP, Security, Data …)

اما پیکربندی زیاد و پیچیده دارد.

#### Spring Boot
ابزاری روی Spring که هدفش ساده‌سازی و سریع‌کردن توسعه با Spring است.

همه‌چیز را Auto-Configure می‌کند.

#### 🔹 2. کانفیگ (Configuration)
#### Spring:
- نیاز به تنظیمات زیاد (اغلب XML یا Java Config)

- باید همه‌ کارها را خودت پیکربندی کنی
مثل:

- DispatcherServlet
- DataSource
- ViewResolver
- Jackson
- Security
و …

#### Spring Boot:
- AutoConfiguration انجام می‌دهد
- فقط چیزهای خاص را لازم است خودت override کنی
- بدون کانفیگ هم پروژه بالا می‌آید!

#### 🔹 3. Dependency Management
#### Spring:
باید خودت نسخه‌ها را هماهنگ نگه‌داری.
ممکن است نسخه‌ها با هم سازگار نباشند.

#### Spring Boot:
“Starter” دارد:
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security

این استارترها شامل dependencyهای سازگار هستند.
مشکل version conflict تقریباً صفر می‌شود.

#### 🔹 4. سرور (Deployment)
#### Spring:
نیاز داری پروژه را به فرم WAR در یک Tomcat خارجی deploy کنی.

#### Spring Boot:
- Tomcat داخلی دارد
- برنامه را به‌صورت JAR اجرا می‌کنی:


    java -jar app.jar

#### 🔹 5. ساختار پروژه
#### Spring:
پروژه‌ها پیچیده‌تر و دستی‌تر.

#### Spring Boot:
ساختار استاندارد دارد:

```java

    src/main/java
    src/main/resources
    application.properties

```

#### 🔹 6. راه‌اندازی (Startup Time)
#### Spring:
کندتر و نیازمند کانفیگ.

#### Spring Boot:
خیلی سریع بالا می‌آید.

#### 🔹 7. ابزارهای اضافه
#### Spring:
بدون ابزار مانیتورینگ داخلی.

#### Spring Boot:
- Actuator
- DevTools
- Metrics
- Health Check

### 🔥 جدول خلاصه (برای مصاحبه)

| موضوع            | Spring                         | Spring Boot              |
| ---------------- | ------------------------------ | ------------------------ |
| نوع              | Framework بزرگ                 | Wrapper روی Spring       |
| هدف              | توسعه انعطاف‌پذیر ولی پرکانفیگ | توسعه سریع و بدون کانفیگ |
| پیکربندی         | زیاد (XML/Java)                | حداقل (AutoConfig)       |
| dependency       | مدیریت دستی                    | Starter Dependencies     |
| سرور             | خارجی                          | Embedded Tomcat          |
| خروجی            | WAR                            | JAR                      |
| ابزار مانیتورینگ | ندارد                          | Actuator دارد            |


#### 🎤 جواب کوتاه برای مصاحبه اتریش

Spring یک فریم‌ورک جامع جاواست که نیاز به پیکربندی زیاد دارد. Spring Boot روی Spring ساخته شده تا توسعه را سریع‌تر کند و با AutoConfiguration، Starterها و سرور داخلی، فرآیند پیکربندی و Deploy را ساده کند.

### ⭐ معماری استاندارد پروژه‌های Spring Boot

در ادامه معماری استاندارد پروژه‌های Spring Boot را کامل، تمیز، مصاحبه‌ای و مناسب سطح Senior Java Developer

این معماری همان چیزی است که در شرکت‌های اتریش و آلمان استفاده می‌شود.

(لایه‌به‌لایه)
یک پروژه Spring Boot معمولا شامل چند Layer (لایه) است:
1. Controller Layer

2. Service Layer

3. Repository Layer

4. Entity Layer

5. DTO & Mapper Layer

6. Configuration Layer

7. Exception Handling Layer

8. Security Layer (اختیاری)

9. Util / Helper Layers

حالا هرکدام را با مثال توضیح می‌دهم👇

### حالا هرکدام را با مثال توضیح می‌دهم👇
- دریافت Request

- ارسال Response

- هیچ منطق بیزینس نباید اینجا باشد

- معمولاً RestController هست

مثال:
```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}

```

### 2) ⚙️ Service Layer (Business Logic Layer)
در این لایه منطق اصلی برنامه نوشته می‌شود:
- Validation بیزینسی
- قوانین مربوط به پردازش داده
- Transaction Management
- ارتباط بین چند Repository
  مثال:
```java
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repo, UserMapper mapper) {
        this.userRepository = repo;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return mapper.toDto(user);
    }
}

```

### 3) 🗂 Repository Layer (Data Access Layer)
برای ارتباط با دیتابیس.

معمولاً از Spring Data JPA استفاده می‌شود.

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

```

### 4) 🧱 Entity Layer (Database Models)
نماینده جدول دیتابیس هستند.

```java
@Entity
public class User {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;
}

```

### 5) 📦 DTO Layer + Mapper Layer
در پروژه‌های واقعی هیچ‌وقت Entity را مستقیم به Controller برنمی‌گردانیم.

#### DTO برای:
- امنیت
- جداسازی لایه دیتابیس از API
- سبک‌کردن Response
- جلوگیری از Reference Loop

امنیت

جداسازی لایه دیتابیس از API

سبک‌کردن Response

جلوگیری از Reference Loop

```java
public class UserDto {
    private Long id;
    private String name;
}

```

Mapper (با MapStruct):

```java

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto dto);
}

```

### 6) ⚙️ Configuration Layer
تمام beanها یا configهای سفارشی اینجا قرار می‌گیرند.

مثلاً:

```java

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

```

### 7) ❌ Global Exception Handling Layer

برای مدیریت خطاها:

```java

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFound(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

```

### 8) 🔐 Security Layer (در صورت نیاز)

معمولاً با Spring Security:

```java

@EnableWebSecurity
public class SecurityConfig {
    // http config here
}


```

### 9) 🛠 Util / Helper / Common Layer

کلاس‌های کمکی:

- Date utils
- String utils
- JWT utils
- File utils

### 📁 ساختار فولدر استاندارد Spring Boot

```java

src/main/java/com/example/app
 ├── controller
 ├── service
 │    └── impl
 ├── repository
 ├── exception
 ├── entity
 ├── dto
 ├── mapper
 ├── config
 ├── security (اختیاری)
 └── util

```

### 🎤 پاسخ کوتاه و حرفه‌ای برای مصاحبه

اگر بپرسند معماری Spring Boot چگونه است؟

معماری Spring Boot معمولاً لایه‌ای است و شامل Controller برای مدیریت API، Service برای منطق بیزینس، Repository برای دسترسی به داده، Entity برای مدل دیتابیس، و DTO/Mapper برای انتقال داده است. همچنین لایه‌های مجزایی برای Config، Exception Handling و Security در نظر گرفته می‌شود. این معماری باعث جداسازی مسئولیت‌ها و رعایت اصول SOLID می‌شود و نگه‌داری سیستم را ساده‌تر می‌کند.


