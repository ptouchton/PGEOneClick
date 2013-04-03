@echo off

rem ANT Home Dir
set ANT_HOME=C:\Apache\apache-ant-1.7.1
               
rem Set JAVA_HOME to JDK path
set JAVA_HOME=C:\IBM\WID7_WTE\runtimes\bi_v7\java

rem Set the location for the IBM installation
set STUDIO_DIR=C:\IBM\WID7_WTE

rem Set the the location of the Runtim dir
set WID_LIB_DIR=C:\IBM\WID7_WTE\runtimes\bi_v7\lib\ext

rem Set the location of the build dir
set BUILD_DIR=C:\sandbox\BuildScriptbuild

rem Set the locations for the IBM deploy batch scripts
set SERVICEDEPLOY=%STUDIO_DIR%\runtimes\bi_v7\bin\servicedeploy.bat
set EJBDEPLOY=%STUDIO_DIR%\runtimes\bi_v7\bin\ejbdeploy.bat
set WSDEPLOY=%STUDIO_DIR%\runtimes\bi_v7\bin\wsdeploy.bat
%ANT_HOME%\bin\ant -Dbuild.config=buildConfig.properties createWorkSpace
