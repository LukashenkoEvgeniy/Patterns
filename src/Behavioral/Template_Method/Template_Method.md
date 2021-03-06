# Шаблонный метод 

![UML](/src/AdditionalDocs/uml/Template_Method.png)

Определяет скелет алгоритма, перекладывая ответственность за некоторые его шаги на подклассы. **Паттерн позволяет подклассам переопределять шаги алгоритма, не меняя его общей структуры**.

**Перехватчик (hook)** - метод объявленный в абстрактном классе, но имеющий пустую реализацию (или по умолчанию). Дает возможность, по желанию, **субкалссу подключаться к алгоритму в разных точках**. (Для необязательных частей алгоритма)

Применение JAVA : **`java.util.Arrays.sort()`** - Не похожа на обычную реализацию (через наследование), так как `sort()` статический. Нужно для сравниваемых объектов реализовать интерфейс `Comparable` метод `compereTo()`, который используется в методе `sort()`.

## Применимость

 - Когда подклассы должны **расширять базовый алгоритм, не меняя его структуры**.

   - Шаблонный метод позволяет подклассам расширять определённые шаги алгоритма через наследование, не меняя при этом структуру алгоритмов, объявленную в родительском классе.

 - Когда у вас есть несколько классов, делающих одно и то же с незначительными отличиями. Если вы редактируете один класс, то приходится вносить такие же правки и в остальные классы.

   - Паттерн шаблонный метод предлагает **создать для похожих классов общий суперкласс и оформить в нём главный алгоритма в виде шагов**. Отличающиеся шаги можно переопределить в подклассах.

     Это позволит **убрать дублирование кода в нескольких классах с похожим поведением, но отличающихся в деталях**.

## Шаги реализации
1. Изучите алгоритм и подумайте, можно ли его разбить на шаги. Какие шаги будут стандартными для всех вариаций алгоритма, а какие - изменчивыми.

2. Создайте абстрактный базовый класс. Определите в нём шаблонный метод. Этот метод должен состоять из вызовов шагов алгоритма. **Имеет смысл сделать шаблонный метод финальным**, чтобы подклассы не могли его переопределить.

3. Добавьте в абстрактный класс методы для каждого из шагов алгоритма. **Стандартные шаги должны иметь реализацию по умолчанию. Изменяемые шаги должны быть объявлены абстрактными.** Их нужно будет реализовать в подклассах.

4. Подумайте о введении в алгоритм хуков. Чаще всего, хуки располагают между основными шагами алгоритма, а также до и после всех шагов.

5. Создайте конкретные классы, унаследовав их от абстрактного класса. Реализуйте в них все недостающие шаги и хуки.

## Преимущества и недостатки
 | + | - |
 | ------ | ------ |
 |Облегчает повторное использование кода. |Вы можете нарушить [**Принцип подстановки Барбары Лисков**][LSP], изменяя базовое поведение одного из шагов алгоритма через подкласс.
 |Вы **жёстко ограничены скелетом существующего алгоритма**. |С ростом количества шагов, шаблонный метод становится слишком сложно поддерживать.
 
## Отношения с другими паттернами

- [**Фабричный метод**][Factory_Method] можно рассматривать как частный случай **Шаблонного метода**. Кроме того, [**Фабричный метод**][Factory_Method] нередко бывает частью большого класса с **Шаблонными методами**.

- **Шаблонный метод** использует наследование, чтобы расширять **части алгоритма**. [**Стратегия**][Strategy] использует делегирование, чтобы изменять алгоритм. **Шаблонный метод** работает на уровне классов. [**Стратегия**][Strategy] позволяет менять логику отдельных объектов.


[LSP]: </src/AdditionalDocs/SOLID/Liskov_Substitution_principle.md>

[Abstract_Factory]: </src/Creational/Factorys/Abstract_Factory/Abstract_Factory.md>
[Factory_Method]: </src/Creational/Factorys/Factory_Method/Factory_Method.md>
[Builder]: </src/Creational/Builder/Builder.md>
[Prototype]: </src/Creational/Prototype/Prototype.md>
[Singleton]: </src/Creational/Singleton/Singleton.md>

[Adapter]: </src/Structural/Adapter/Adapter.md>
[Bridge]: </src/Structural/Bridge/Bridge.md>
[Composite]: </src/Structural/Composite/Composite.md>
[Decorator]: </src/Structural/Decorator/Decorator.md>
[Facade]: </src/Structural/Facade/Facade.md>
[Flyweight]: </src/Structural/Flyweight/Flyweight.md>
[Proxy]: </src/Structural/Proxy/Proxy.md>

[Chain_of_Responsibility]: </src/Behavioral/Chain_of_Responsibility/Chain_of_Responsibility.md>
[Command]: </src/Behavioral/Command/Command.md>
[Iterator]: </src/Behavioral/Iterator/Iterator.md>
[Mediator]: </src/Behavioral/Mediator/Mediator.md>
[Memento]: </src/Behavioral/Memento/Memento.md>
[Observer]: </src/Behavioral/Observer/Observer.md>
[State]: </src/Behavioral/State/State.md>
[Strategy]: </src/Behavioral/Strategy/Strategy.md>
[Template_Method]: </src/Behavioral/Template_Method/Template_Method.md>
[Visitor]: </src/Behavioral/Visitor/Visitor.md>
