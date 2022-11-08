# README

## Deploy Tutorial

New Project -> Gradle -> Java & Web(war)

Optional step: File -> project structure -> module -> main -> specify the `web.xml` file when tomcat run.

Edit 'run' configuration, add `tomcat server` and configure the application server(add the path of tomcat). Then set deployment, add the artifact name `xxx-war(exploded)`.

tips: tomcat directory and file need the `x` authorization.

---

`exploded` means than instead of deploying a WAR/EAR file to your application server to test your application you point your application server at a folder containing the unzipped (exploded) contents of what would be inside the WAR/EAR file.

This makes development quicker as most application servers support Hot Deploy where you can change the code/JSPs etc and these changes will be reflected almost immediately in the running application.

The Tomcat plugin in Eclipse essentially uses this technique. The only thing to be careful of is that after many hot deploys most application servers start to run out of memory in the PermGen space and need restarting (well i've had this problem with Weblogic and Tomcat).




