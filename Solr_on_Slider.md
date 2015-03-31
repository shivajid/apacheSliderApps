***Download the slider package for solr from the following download location***

```
  https://www.dropbox.com/s/23ro97ufs0stdzr/solr-slider-packages_hdp22.zip?dl=0
```

***Install the slider package***

```
su yarn

/usr/hdp/current/slider-client/bin/./slider install-package --name solr --package /tmp/solr-5.0.0.zip

```
***Create the slider instance***

```
/usr/hdp/current/slider-client/bin/./slider create c10 --template appConfig.json --resources resources.json

```

***Check the slider status***

```
slider status c10

```

***List all the pacakages***
```
slider list

```

***Stop the Slider instance***

```
slider stop

```

***Destroy the slider instance***

```
slider destroy
```

- @Shivaji
