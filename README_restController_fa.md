# springboot enterprise template


### 🌿نکته این است Rest Controller چیست؟ (در Spring Boot) 
و اینکه @RestController یکی از مهم‌ترین Annotationها در Spring MVC/Spring Boot است که برای ساخت RESTful API استفاده می‌شود.

### ⭐ تعریف ساده
@RestController = @Controller + @ResponseBody

یعنی:
- این کلاس یک Controller است.
- خروجی همه متدهایش به صورت مستقیم در body پاسخ HTTP قرار می‌گیرد (نه یک View یا صفحه‌ی HTML).

### 🔍 چه زمانی از RestController استفاده می‌کنیم؟

وقتی می‌خواهیم:
- API بسازیم
- JSON برگردانیم
- با Front-end (React, Angular, Vue) یا Mobile App ارتباط بگیریم
- داده‌های CRUD را از طریق HTTP ارسال/دریافت کنیم

### 📌 مثال ساده از یک RestController

    @RestController
    @RequestMapping("/api/hello")
    public class HelloController {

        @GetMapping
        public String sayHello() {
            return "Hello Monire!";
        }
    }

وقتی user به /api/hello درخواست GET بزند، مستقیماً متن "Hello Monire!" به عنوان بدنه پاسخ HTTP برمی‌گردد.


### 🔥 یک مثال کاربردی‌تر (برگرداندن Object)

    @RestController
    @RequestMapping("/api/person")
    public class PersonController {

        @GetMapping("/{id}")
        public Person getPerson(@PathVariable Long id) {
            return new Person(id, "Monire", "Jamshidi");
        }
    }

در پاسخ، Spring به طور خودکار Object را به JSON تبدیل می‌کند:

    {
    "id": 1,
    "firstName": "Monire",
    "lastName": "Jamshidi"
    }
