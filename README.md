# JAVA

## How to compile files into a java package

Inside the homework folder, a typical project is made up of a source file `Example.java` and a test file `Test.java`. We compile these files into a single test package called `example`. It is done as described below.

First, we want to make sure that both files begin with the line `package example;`.

Next, we compile two files from their direct directory

~~~
javac -d . Example.java Test.java
~~~ 

Note that the `.` here indicates the directory where we want our package to reside in.

After this, we should get a subfolder in our current folder named `example`. Inside `example` reside two files, `Example.class` and `Test.class`. Invoke the executable from outside this subfolder with 

~~~
java example.Test
~~~

Here `example` refers to the package, while `Test` is the `Test` class within this package.

The full command set for the compilation is summarized below:

~~~
# inside src/example folder:
javac -d ../../build/  Example.java Test.java # compile
cd ../../build # must execute commands from this dir!
java example.Test # execute
~~~