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

//yes
```


####scala yield

val res = for {子句} yield {变量或表达式}

yield将结果以数组形式存入res
> 著作权归作者所有。
商业转载请联系作者获得授权，非商业转载请注明出处。
作者：2gua
链接：http://zhuanlan.zhihu.com/guagua/19752481
来源：知乎

```scala
object YieldDemo {
    private val files = (new java.io.File(".")).listFiles
    private def fileLines(file: java.io.File) =
        scala.io.Source.fromFile(file).getLines.toList
    def main(args: Array[String]): Unit = {
        val lineLengths =
        for {
            file <- files
            if file.getName.endsWith(".txt")
            line <- fileLines(file)
            trimmedLine = line.trim
            if trimmedLine.matches(".*棒.*")
        } yield line + "：合计" + trimmedLine.length + "个字。"
        lineLengths.foreach(println)
    }
}
```

