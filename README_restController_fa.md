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

### 🎯 تفاوت RestController با Controller چیست؟


| ویژگی                 | @Controller                 | @RestController      |
| --------------------- | --------------------------- | -------------------- |
| خروجی                 | صفحه‌ی HTML (View)          | JSON, String, Object |
| نیاز به @ResponseBody | ✔ بله                       | ❌ نه                 |
| کاربرد                | پروژه‌های MVC مثل Thymeleaf | REST API و Back-end  |



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


## در حقیقت Spring REST چیست؟
در حقیقت Spring REST یا همان Spring RESTful Web Services مجموعه‌ای از قابلیت‌ها و ساختارهای Spring Framework است که به شما اجازه می‌دهد وب‌سرویس‌های RESTful بسازید.

یعنی با استفاده از Spring می‌توانی APIهایی بسازی که:
- از طریق HTTP کار می‌کنند
- و JSON یا XML برمی‌گردانند
- عملیات CRUD را با متدهای HTTP انجام می‌دهند
  (GET, POST, PUT, DELETE…)

### 🌿 تعریف خیلی ساده
Spring REST = استفاده از Spring MVC برای ساخت RESTful API

در واقع Spring MVC همان موتور اصلی است، اما Spring قابلیت‌های زیر را به‌صورت آماده فراهم می‌کند:

- @RestController
- @RequestMapping, @GetMapping, @PostMapping
- تبدیل خودکار Object به JSON
- مدیریت Exception
- Validation
- ارتباط با Database

### 🌐 REST چیست؟ (خیلی کوتاه)

REST یک سبک معماری است که می‌گوید:
- هر چیز یک Resource است (مثل /users یا /orders)
- عملیات روی منابع با HTTP انجام می‌شود:

| کار            | HTTP Method | مثال     |
| -------------- | ----------- | -------- |
| خواندن یک لیست | GET         | /users   |
| خواندن یک نفر  | GET         | /users/1 |
| ساختن          | POST        | /users   |
| به‌روزرسانی    | PUT/PATCH   | /users/1 |
| حذف            | DELETE      | /users/1 |


Spring همین REST را پیاده‌سازی می‌کند.


### 🎯 پس Spring REST یعنی چه؟

یعنی:

- 🔹 ساخت API با استفاده از Spring
- 🔹 بر اساس اصول REST
- 🔹 با خروجی JSON
- 🔹 با Annotationهای راحت و خوانا

### 📌 مثال ساده از Spring REST (یک RESTful API کامل)

    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public List<User> getAll() {
            return userService.findAll();
        }

        @GetMapping("/{id}")
        public User getOne(@PathVariable Long id) {
            return userService.findById(id);
        }

        @PostMapping
        public User create(@RequestBody User user) {
            return userService.save(user);
        }

        @PutMapping("/{id}")
        public User update(@PathVariable Long id, @RequestBody User user) {
            return userService.update(id, user);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            userService.delete(id);
        }
    }



 این یک Spring RESTful Web Service کامل است.

