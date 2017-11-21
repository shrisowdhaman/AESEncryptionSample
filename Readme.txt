Java by default it support 128 bit key. If you want to use 256 bit key fallow below steps 

Update   Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files  to support 256Bit Key 
Java8 Link to download the policy. 
  

1.	Download the java policy files  for Java 7 or Java 8.
2.	Locate the jre\lib\security directory for the Java instance that the Atom is using.
	For example, this location might be:
	C:\Program Files\Java\jre1.8.0_144\lib\security. 
	C:\Program Files\Java\jdk1.8.0_144\jre\lib\security
3.	Replace the following .jar files directory: local_policy.jar and US_export_policy.jar.
4.	Stop and restart the eclipse/server.
