package org.terentich.metaj;

public enum MetaAttributes {
	ARCHIVER_VERSION("Archiver-Version"),

	BUILT_BY("Built-By"),

	BUILD_JDK("Build-Jdk"),

	CREATED_BY("Created-By"),

	IMPLEMENTATION_BUILD("Implementation-Build"),

	IMPLEMENTATION_REVISION("Implementation-Revision"),

	IMPLEMENTATION_TIMESTAMP("Implementation-Timestamp"),

	PACKAGE("Package");

	private String name;

	private MetaAttributes(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
