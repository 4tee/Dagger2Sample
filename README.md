# Dagger2Sample

Dagger is a dependency injection framework, first created by Jake Wharton and currenly maintained by Google. Dagger1 was dropped in the favour of Dagger2. This code sample is the tutorial of fetching repository data from Github using Github REST API call. By using Dagger 2, we created dependency injection tree and let it manage automatically. The sample is the result of following a video tutorial from Youtube [Dagger 2 Android Tutorial by TwistedEquations](https://youtu.be/Qwk7ESmaCq0?list=PLuR1PJnGR-Ih-HXnGSpnqjdhdvqcwhfFU). Before you jump into it, there are a number of library that you need to familiar with (Not really important, just let you know what it does cos the focus is on Dagger):
 - Retrofit & Gson (I have a sample at [RetrofitSample](https://github.com/4tee/RetrofitSample))
 - Picasso (Image Loading libaray)
 - Timber (Logging for flexibility)
 - Okhttp3 logging interceptor (Network interceptor)
 - Butterknife (Binding for both fields & methods)

## What is Dagger
Dagger is a dependency injection framework for Android and popular among the Android developer communitity. Dagger helps to manage the dependencies and code generation automatically. It uses annotation to map the dependency graph in your project. More info about Dagger is at [User's Guide](https://google.github.io/dagger/users-guide).

## What and Why is Dependency Injection for Dagger
Dependency Injection is not new. Since the early day, it has been well used and well known in Software Engineering field. Literally, it is to inject the dependency. Dependency is just another object that your function needs to operate. For example, to make a yogurt, you need milk. Your yogurt class depends on milk. Traditionally, if you write your own class of Yogurt, then you need to handle milk and all the other dependencies. Maybe milk requires Cows. Cow requires Food, etc.. It can get complex pretty soon. That is where we need Dependency Injection Framework who can handle it for us.

## How to do
You need to add two things into your gradle. Since it uses annotation, you will need to add annotation processsor.
In your top level ```build.gradle``` file,
```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
}
```
Next, in your app level ```build.gradle``` file, you add
```
apply plugin: 'com.android.application'
apply plugin: 'com.neenbedankt.android-apt'
.
.
.
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:26+'
    testCompile 'junit:junit:4.12'

    compile 'com.google.dagger:dagger:2.6'
    apt 'com.google.dagger:dagger-compiler:2.6'
    .
    .
    .
```

Okay. you are good to start the project.

## Credits
Youtube video that I referred to is at [Dagger 2 Android Tutorial by TwistedEquations](https://youtu.be/Qwk7ESmaCq0?list=PLuR1PJnGR-Ih-HXnGSpnqjdhdvqcwhfFU) . 
The REST API from (Github Developer API v3)[https://developer.github.com/v3/repos/]
