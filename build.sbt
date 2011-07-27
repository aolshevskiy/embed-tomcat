libraryDependencies ++= Seq(
	"org.apache.tomcat" % "tomcat-catalina" % "7.0.0",
	"org.apache.tomcat.embed" % "tomcat-embed-core" % "7.0.0",
	"org.apache.tomcat" % "tomcat-jasper" % "7.0.0"
)

ivyXML :=
<dependencies>
<dependency org="org.apache.tomcat" name="tomcat-jasper" rev="7.0.0">
<exclude module="ecj" />
</dependency>
</dependencies>
