# csc380_owm_demo
OpenWeatherMap demo showing how to use OwmClient


To utilize this to automatically download your dependencies, you need to use Maven. I have noticed that the owm-lib dependency doesn't work on a clean setup. The one on OSSRH is an old version that doesn't support 2.5. To get the OWM library to work, this is what I did.

1. git clone https://github.com/Ayutac/owmClient.git (The releases on this repo are outdated as well I think).
2. I open this project in Netbeans, so directions will vary for IntelliJ.
3. I build it. Netbeans knows it is a maven project because of the pom.xml file. Building that downloads the dependencies for the default repo.
4. git clone https://github.com/Trailhead-Jared/csc380_owm_demo.git, Then open that project in Netbeans (in my case). When I try to build that, I get an error.
5. It doesn't know where the owm-lib is. Because its not part of the standard Maven repository. I need to Manually install artifact.
Browse to the build output of the owmClient and get the .jar file.
6. Now build and run.

org.bitpipeline.lib.owm.WeatherStatusResponse@73f792cf
Temperature [temp=44.6, tempMin=44.6, tempMax=44.6, tempDay=NaN, tempDayMin=NaN, tempDayMax=NaN, tempNight=NaN, tempEve=NaN, tempMorn=NaN]
27.51
