package org.terentich.metaj;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		MetaReader reader = new MetaReader(Main.class);
		System.out.println(reader);
		System.out.println("Archiver version: " + reader.getArchiverVersion());
		System.out.println("Build-Jdk: " + reader.getBuildJdk());
		System.out.println("Built-By: " + reader.getBuiltBy());
		System.out.println("Classpath: " + reader.getClasspath());
		System.out.println("Created-By: " + reader.getCreatedBy());
		System.out.println("Impl title: " + reader.getImplementationTitle());
		System.out.println("Impl vendorId: "
				+ reader.getImplementationVendorId());
		System.out
				.println("Impl version: " + reader.getImplementationVersion());
		System.out.println("Mainclass: " + reader.getMainClass());
		System.out.println("Manifest version: " + reader.getManifestVersion());
		System.out.println("Spec title: " + reader.getSpecificationTitle());
		System.out.println("Spec version: " + reader.getSpecificationVersion());

		System.out.println("Impl timestamp: "
				+ reader.getImplementationTimestamp());
	}
}
