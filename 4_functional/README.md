# Functional Programming

> Functional Programming = Functional Composition + Lazy Evaluation
> - Lazy evaluation requires purity of functions
> - Pure functions are idempotent - they return the same result everytime when called with the same parameters
> - Pure Functions don't have side-effect
>   - They don't change anything
>   - They don't depend on anything that may possibly change 

<br/>

## Lambdas
- Lambdas appear to be a neat replacement for anonymous inner classes, but under the hood it is an `invokedynamic`.

### Method References
- parameter as an argument
- parameter as an argument to a static method
- parameter as a target
- two parameters as arguments
- two parameters, one as target the other as an argument

<br/> 
    
## Streams        
- **`filter`**:
    - Filters item(s) from the input stream
    - Input and Output streams are of same type 
    - 0 <= number of elements in the output <= number of input
    - parameter: `Stream<T>` `filter` takes `Predicate<T>`
    
- **`map`**:
    - Transforms values
    - number of output == number of input
    - no guarantee on the type of the output with respect to the type of the input
    - parameter:  `Stream<T>` map takes `Function<T, R>` to return `Stream<R>`
    
- **`reduce`**:
    - Reduces the stream to a single, or a list of values.
    - `reduce` on `Stream<T>` takes two parameters:
    - first parameter is of type `T`, which denotes the starting value
    - second parameter is of type `BiFunction<R, T, R>` to produce a result of `R`

> Note:
> - Each `filter` and `map` operation works on a single piece of item. They operate in their own swimlanes.
> - Whereas `reduce` cuts across the swimlanes. Operates on the current item as well as the carry-over/initial item.

### Key things to remember with Streams
- Avoid share mutability when using streams.
- Streams are lazy until the terminal operation is invoked.    
- Streams are 
    - sized or unbounded
    - distinct or duplicate
    - ordered or un-ordered
    - sorted or un-sorted
- Streams can be infinite

<br/>
    
## Collectors     
- `toList()`
- `toSet()`
- `toMap()` 
- Unmodifiable Collections introduced as a part of Java 10
    - `toUnmodifiableList()` : Immutable List 
    - `toUnmodifiableSet()` : Immutable Set
    - `toUnmodifiableMap()` : Immutable Map
- `joining()`        
- `groupingBy` and `mapping`        

## 1. Collections with Lambdas

## 2. Strings, Comparators & Filters

## 3. Designing with Lambdas

## 4. Working with Resources

## 5. Being Lazy



## 6. Optimizing Recursions

## 7. Composing with Lambdas

