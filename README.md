# ScalaTricks

scala code for learn

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

####Scala Regex

```scala
val date = """(\d\d\d\d)-(\d\d)-(\d\d)""".r

"2012-03-12" match
{
    case date(year,month,day) => println(s"this is year $year")
}

```

```scala
val dates = "Important dates in history: 2004-01-20, 1958-09-05, 2010-10-06, 2011-07-15"
val res1 = date findFirstIn dates getOrElse "none found"
println(res1)
//out: 2004-01-20

val res2 = date findAllIn dates
println(res2.toList)
//out: List(2004-01-20, 1958-09-05, 2010-10-06, 2011-07-15)

val res3 = date replaceAllIn(dates,"rep")
println(res3)
//Important dates in history: rep, rep, rep, rep

val res4 = date replaceAllIn(dates,m=>m.group(1)+m.group(2))
println(res4)
//Important dates in history: 200401, 195809, 201010, 201107

val docSpree = """2004(?:-\d{2}){2}""".r
val docView  = date replaceAllIn (dates, _ match {
      case docSpree() => "Historic doc spree!"
      case _          => "Something else happened"
    })
//Important dates in history: Historic doc spree!, Something else happened, Something else happened, Something else happened
```

####scala match case with if clause

```scala
"str" match {
    case b:String if b contains "s" => println("yes")
    case _ => println("no")
}
```
yes
