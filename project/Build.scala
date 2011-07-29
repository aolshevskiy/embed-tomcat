import sbt._

import Keys._

object TomcatBuild extends Build {
	private def tomcatVersion = "7.0.19"
	
	def rootSettings = Seq(
		libraryDependencies ++= Seq(
			"org.apache.tomcat" % "tomcat-catalina" % tomcatVersion,
			"org.apache.tomcat.embed" % "tomcat-embed-core" % tomcatVersion,
			"org.apache.tomcat" % "tomcat-jasper" % tomcatVersion,
			"net.liftweb" %% "lift-webkit" % "2.3" % "compile",
			"ch.qos.logback" % "logback-classic" % "0.9.26"
		),
		ivyXML :=
			<dependencies>
				<dependency org="org.apache.tomcat" name="tomcat-jasper" rev="7.0.19">
					<exclude module="ecj" />
				</dependency>
		</dependencies>,
		unmanagedClasspath in Runtime += Attributed.blank(file("/home/siasia/work/lift-basic/target/webapp/WEB-INF/classes"))
	)

	lazy val root = Project("root", file(".")) settings(rootSettings :_*)

	override def projects = Seq(root)
}
