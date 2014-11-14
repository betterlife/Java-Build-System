Java-Build-System
=================

Java Build System

Description
-----------

This is a build system for java / web project build upon Apache Ant, the reason why I create this system rather than use maven is 

  - Keep things simply focusing on what I cares
  - Take full control of how things to be done, not only what needs to be done.

Features
--------

  - Build / Package / Junit test
  - FindBugs Report
  - PMD Report
  - Unit test code coverage
  - Generate ctags/cscope format tag file.
  - Generate JavaDoc

Bootstrap
---------
  This module can be used as a sub module for your WebApp, bootstrap code as below:
```
  mkdir myWebApp  # Workspace
  cd myWebApp     
  git init
  git submodule add https://github.com/betterlife/Java-Build-System.git .builder
  cd .builder
  chmod +x init.sh
  ./init.sh
  cd ..
  ant -f .builder/build.xml help # Show build system help information.
```  
  
Configuration
-------------

  All configurations is in .builder/projectTemplate/work/build.properties, and all the settings are documented in that file.
  
Usage 
-----

  In the webApp root folder, invoke the command via:
```
  ant -f .builder/build.xml [targetName]
```  

 Target list  
 -----------

- Common Tasks    
```
 clean           Clean everything in target folder
```

- Compile source code
```
 compile         Compile source code
```

- Junit tasks
```
 junit.compile   Compile unit test source code
 junit.run       Run unit tests
 junit.test      Run a specify test(-Dtest=xxx) 
 junit.report    Generate unit test report in xml and html format
``` 

- Code QA tasks
```    
 findbugs        Generate findbugs report
 cc.report       Generate unit test code coverage report
 pmd             Generate PMD report
 reportall       Generate code coverage, unit test, findbugs and PMD report
```

- Artifact tasks
```   
 build.flat      Prepare contents and folder structure for war packing
 build.war       Generate war package for web app
```

- Application server tasks(Current liberty on MAC supported)    
```    
 server.restart  Restart Application Server
 server.start    Start Application server
 server.status   Show Application server status
 server.stop     Stop Application server
``` 
 
- Utility tasks
```    
 run             Run class, full class name(xxx) passed by parameter c(-Dc=xxx)
 docs.javadoc    Generate java doc 
 tags            Generate tag file for ctags and cscope
 help            Show help content
```

License
-------

MIT © 2008-2014 Liu Xiangqian
