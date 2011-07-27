package com.github.siasia.web

import org.apache.catalina._
import startup.Tomcat
import core.AprLifecycleListener
import loader.WebappLoader

object EmbedTomcat {
	def main(args: Array[String]) {
		val appBase = args(0);
		val port = args(1).toInt

		val tomcat = new Tomcat
		tomcat.setPort(port)

		tomcat.setBaseDir(".")
		tomcat.getHost.setAppBase(appBase)

		val contextPath = "/"

		// Add AprLifecycleListener
		val server = tomcat.getServer
		val listener = new AprLifecycleListener
		server.addLifecycleListener(listener)

		val context = tomcat.addWebapp(contextPath, appBase)
		val loader = new WebappLoader(getClass.getClassLoader)
		context.setLoader(loader)
		tomcat.start()
	}
}
