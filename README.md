# basic-java-starter

Use this to create a simple java executable with dependencies.


_Note_ Never commit to this repo. It's a basic starter for any project needing to run a java application

Instead: duplicate it following this steps : [docs.github.com/en/repositories/creating-and-managing-repositories/duplicating-a-repository](https://docs.github.com/en/repositories/creating-and-managing-repositories/duplicating-a-repository)


The java maven project is `abc`.

Main class is : `org.example.App`.

Uses the `exec-maven-plugin` plugin to run the executable.

Usage:
```
cd abc
mvn clean install
mvn exec:exec
```

