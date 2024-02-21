[Lambda表达式](https://dev.java/learn/lambdas/)
- 使用Lambda表达式提高代码的可读性
- 从 Java 8 版本开始加入, 2014年

## 1. 认识Lambda表达式
- 写匿名类实例的简便方法
- 三步: 确定lambda表达式的类型(functional interface), 找出要实现的方法,  使用lambda表达式来实现该方法.
- syntax: ()->{}
- lambdas只能捕获值, 而不能捕获变量; 在lambda表达式中使用的变量, 必须是final或者effectively final(Java SE 8)

## 2. 使用Lambdas表达式
- a new package: java.util.function, in the java.base module.
- Supplier<T>: 没有参数, 返回一个值
- Consumer<T>: 接收一个参数, 不返回任何东西
- Predicate<T>: 接收一个参数, 返回一个布尔值
- Function<T, R>: 接收一个参数, 返回另一个类型的值

## 3. 以Method References的方式来写Lambda表达式
- Static method references: RefType::staticMethod
- Bound method references: RefType::instanceMethod
- Unbound method references: expr::instanceMethod
- Constructor method references: ClassName::new

## 4. 组合Lambda表达式
- Default Methods
- Factory Methods

## 5. Writing and Combining Comparators
