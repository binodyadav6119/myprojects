<p>Singleton Design Pattern</p>
objective
<br>
To create the instance only once
<br>
eg:
<br>
To create jdbc connection it requires one connection.
so we will use simgleton pattern for this.
<br>
steps:
<br>
constructor should be private
<br>
use static method to get instance using classname
<br>
this method will create object of the class
<br>
That method can be called multiple times to create multiple object.
we can keep check if instance is created or not.
 we will keep check if instance is not there then we create instance of class.
create field to store object which is private static

some issue is there.
i.e lazy initialization lazy way of creating singleton object
<br>
cons.
object is created only when method is called.
it is not specific to threads.
lets say if we have many threads and while creating object in getObject method then there is chance of creating the tw object.
we can fix this issue using synchronised block
<br>
other way
<br>
i.e eager way
<br>
we will create object on field declaration.
cons:
if that object is not used then memory is consumed.
performance issues.

<br>
ways of breaking this design
lets say if we make constructor public some how. we can create object of that class.
we can use Reflection api to change property at run time like private to public

