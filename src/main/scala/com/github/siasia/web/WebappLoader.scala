package org.apache.catalina.loader

class SbtWebappClassLoader(parent: ClassLoader) extends WebappClassLoader(parent) {
	override def addJar(jar: String, jarFile: java.util.jar.JarFile, file: java.io.File) {
	}
}


