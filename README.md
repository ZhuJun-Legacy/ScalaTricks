# ScalaTricks

scala code for selflearning

####Scala Default Input Parameter

```scala
def Foo(a: String, b: String="default") =
{
      println(a + b)
}
```
```scala
Foo("one ")
```
output: one default
```scala
Foo("two ","parameter")
```
output: two parameter

####Scala Regix

```scala
val date = """(\d\d\d\d)-(\d\d)-(\d\d)""".r

"2012-03-12" match
{
    case date(year,month,day) => println(s"this is year $year")
}

```
