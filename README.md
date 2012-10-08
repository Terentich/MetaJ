MetaJ
=====

Description
-----------
The simple java library (and CLI-application) for reading manifest meta-information.

Requirements
------------
It needs a Java Virtual Machine of at least version 1.6 ([Java SE 6.0](http://www.oracle.com/technetwork/java/javase/downloads/index.html)).
If you want to build the jar from source, you will also need [Maven](http://maven.apache.org/).

Usage
-----
Just add these lines into your Maven's project file:

    <dependency>
        <groupId>org.terentich</groupId>
        <artifactId>metaj</artifactId>
        <version>1.0</version>
    <dependency>

Example
-------

The file 'src/test/java/Main.java' contains base example:

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


LICENSE
-------

The Metaj library publish under the [Apache Software License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt).