::java <java_params> –jar <jar-file-name>.jar <exc_params>  
::java -Djava.util.logging.config.file=/path/to/logging.properties –jar <jar-file-name>.jar

:: copy  logging.properties vào "/target" folder và run lệnh sau  
:: nếu ko có logging.properties sẽ lấy default của Java ở C:\Program Files\Java\jdk-11.0.2\conf\logging.properties
java -Djava.util.logging.config.file=./logging.properties -jar App1_java_logging_default.jar 

:: run lênh sau ở "/target" folder.  logging.properties đã ở trong *.jar file rồi (add vào ở java code)
java -jar App2_java_logging_properties_file.jar