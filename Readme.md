# Dom.ru тестовое задание: прокат автомобилей
## Используемые технологии:
* Spring Boot
* Spring Security
* Spring Web
* Spring Data (Hibernate)
* Thymeleaf
* Jquery
* MySQL DB
### Пояснение к коду.
Так как код должен быть расширяемым было решено использовать типовой набор 
базовых компонентов с согласованной на будущее семантикой. Это означает, что
мы договавриваемся, что каждая операция с бизнес сущностью или их набором
осуществляется по одному и тому же шаблону, установленному в базовых компонентах.
В нашем случае, базовый набор - это CommonController, CommonService, CommonDto,
CommonEntity, CommonParams и CommonHibernateDAO. Все они парметризированы. Для
взаимодействия с ними, для каждой бизнес сущности предполагается создание 
наследников для каждого описанного слоя с соответствующими типами, также
унаследованными от базовых. В данный момент - есть один типовой запрос - filter.
Он возвращает набор соотвествующих сущностей, соотвествующий ограничениям, 
пришедшим в объекте типа, унаследованного от CommonParams. Минус такого подхода
в том, что такая фильтрация обеспечивает только признак эквивалентности заданным
параметрам. Для создания, к примеру, ограничителя-промежутка, скажем, по дате,
можно создать свой перечислимый тип со списком типовых операций, и связанными с
ними Restrictions у Criteria.
Особоняком от этого стоит регистрация и аутентификация пользователя. Компоненты этого
модуля никак не связаны с базовыми, а используют возможности Spring Security. Для 
клиентской части был выбран Thymeleaf, как движок шаблонов, так как я хотел с ним
познакомиться. Как позже выяснилось - он не очень хорошо переваривает ajax-запросы
и вообще не очень дружит с rest. Ввиду этого, в клиентском коде встречаются небольшие
костыли, например, event.preventDefault(), так как после запроса, Thymeleaf постоянно
пытается обновить страницу. Также, для формы регистрации написан простой валидатор,
который следит, чтобы, в нашем случае, пароль в in и confirm был одинаковым.
Со стороны БД тоже нужно соблюдать некоторые правила. Первичным ключем всегда
является поле i_id, даже если напрашивается вариант, скажем, с электронной почтой или
еще чем-нибудь подобным. Сделано это для того, чтобы иметь возможность использовать 
базовый компонент CommonEntity с описанным в нем первичным ключем. Кроме того, это
может пригодиться для гипотетически созданных в будущем типовых хранимых процедур.
Кроме этого, названия полей строятся по формуле тип_имя (s_name) - исключительно для
удобства разработки. Если будут подключены процедуы, имена переменных в их сигнатуре
должны строится следующим образом направление_тип_имя, то есть, переменная i_s_car_name 
означает, что i - IN , s - String, car_name - имя.
Кроме вышеописанного, в коде встречаются комментарии.

### Как это работает.
Регистрируемся и заходим под своим аакаунтом. Нажимаем Hire, видим три доступные локации. 
Нажимаем кнопку show cars на любой из них и видим доступные для проката машины. Взять машину
можно, кликнув на кнопку hire car. У недоступных для найма машин эта кнопка будет затемнена и
будет статус unavailable. Кроме этого, можно посмотреть историю проката машины, нажав на кнопку
show history. Для сдачи машины обратно - нажимаем на кнопку my cars, выбираем локацию, куда 
хотим ее сдать кнопко choose location for giving back и нажимаем на give back под нужной 
машиной. Вернуть можно в любую точку.

### Для запуска.
В файле application.properties в поля db.username и db.password вписать пользователя и его пароль
для MySQL базы данных. Выполнить команды create database car_hiring, а затем use car_hiring. Далее
скопировать содержимое файла create.sql и вставить в командную строку MySQL. Или прочитать здесь
https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
как инициализировать ДБ средствами Spring Boot. Затем запустить приложение, которое развернется по
адресу localhost:8888.

### От себя
Выполнил не все пукнты, так как считаю, что некоторые из них не соответствуют сути тестового задания
и займут больше моего свободного времени, чем я готов этому уделить.
