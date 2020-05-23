@echo off
setlocal
if not defined JAVA_HOME (
    echo Error: JAVA_HOME is not set.
    goto :eof
)


set MPECFGDIR=%~dp0..\conf/,classpath:application.yml
set STATICDIR="file:%~dp0..\static/"
set CLASSPATH=%~dp0..\lib\*

set MPEMAIN=com.goudai.mpe.MpeApplication

call java -cp %CLASSPATH% %MPEMAIN% --spring.config.location=%MPECFGDIR% --spring.resources.static-locations=%STATICDIR%

endlocal